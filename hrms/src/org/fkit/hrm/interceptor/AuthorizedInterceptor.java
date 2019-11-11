/*    */ package org.fkit.hrm.interceptor;
/*    */ 
import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*    */ import org.fkit.hrm.domain.User;
import org.fkit.hrm.util.common.HrmConstants;
/*    */ import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/*    */ 
/*    */ public class AuthorizedInterceptor
/*    */   implements HandlerInterceptor
/*    */ {
/* 16 */   private static final String[] IGNORE_URI = { "/loginForm", "/login", "/404.html" };
/*    */ 

/*    */   
/*    */   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {}
/*    */   
/*    */   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
/* 48 */     boolean flag = false;
/*    */     
/* 50 */     String servletPath = request.getServletPath();
//byte b; int i;
//   int arrayOfString;
//    for (i = arrayOfString = IGNORE_URI.length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 53 */    for(String s: IGNORE_URI){  
			if (servletPath.contains(s)) {
/* 54 */         flag = true;
/*    */         break;
/*    */       } 
/*    */      }
/*    */     
/* 59 */     if (!flag) {
/*    */   
/* 61 */       User user = (User)request.getSession().getAttribute(HrmConstants.USER_SESSION);
//可能之前的session没拿到 getAttribute("user_session")假的--
/*    */       
/* 63 */       if (user == null) {
/*    */         
//	 		     request.getSession().invalidate();
/* 65 */         request.setAttribute("message", "请先登录再访问网站！");
/* 66 */         request.getRequestDispatcher("loginForm").forward(request, response);
/* 67 */         return flag;
/*    */       } 
/* 69 */       flag = true;
/*    */     } 
/*    */     
/* 72 */     return flag;
/*    */   }
/*    */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\interceptor\AuthorizedInterceptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */