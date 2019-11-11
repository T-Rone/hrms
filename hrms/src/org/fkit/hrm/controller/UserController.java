/*     */ package org.fkit.hrm.controller;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.fkit.hrm.domain.User;
/*     */ import org.fkit.hrm.service.HrmService;
/*     */ import org.fkit.hrm.util.tag.PageModel;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Qualifier;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
		  import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ public class UserController
/*     */ {
/*     */   @Autowired
/*     */   @Qualifier("hrmService")
//			两者配合注解，表明说需要的类 名字需要与接口实现类一致 @Service("hrmService")
/*     */   private HrmService hrmService;
/*     */   
/*     */   @RequestMapping({"/login"})
/*获取参数 */   public ModelAndView login(@RequestParam("loginname") String loginname, @RequestParam("password") String password, HttpSession session, ModelAndView mv) {
//				@RequestParam(value="loginname",required=true)
//				默认true必须传参
				User user = this.hrmService.login(loginname, password);
/*  44 */     if (user != null) {
/*     */       
/*  46 */       session.setAttribute("user_session", user);
/*   session.removeAttribute("user");   */      
/*  48 */       mv.setViewName("redirect:/main");
/*     */     } else {
/*     */     
/*  51 */       mv.addObject("message", "登录名或密码错误！请重新输入");
/*     */       
/*  53 */       mv.setViewName("forward:/loginForm");
/*     */     } 
/*  55 */     return mv;
/*     */   }
/*     */ 
	@RequestMapping({"/logout"})	  
	public  ModelAndView logout(HttpSession session, ModelAndView mv){	   
		
		//清除session	  
//	session.removeAttribute("user");	
	session.invalidate();
	mv.setViewName("forward:/loginForm");
	return mv;
	}

	/*@ModelAttribute
	 * 负责绑定请求参数到指定对象  
	 * eg 查询 username和status--》user   */ 
/*     */   
/*     */   @RequestMapping({"/user/selectUser"})
/*     */   public String selectUser(Integer pageIndex, @ModelAttribute User user, Model model) {
/*  69 */     System.out.println("user = " + user);
/*  70 */     PageModel pageModel = new PageModel();
/*  71 */     if (pageIndex != null) {
/*  72 */       pageModel.setPageIndex(pageIndex.intValue());
/*     */     }
/*     */     
/*  75 */     List<User> users = this.hrmService.findUser(user, pageModel);
/*  76 */     model.addAttribute("users", users);
/*  77 */     model.addAttribute("pageModel", pageModel);
/*  78 */     return "user/user";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/user/removeUser"})
/*     */   public ModelAndView removeUser(String ids, ModelAndView mv) {
/*  90 */     String[] idArray = ids.split(","); 
//			   byte b; int i; String[] arrayOfString;
///*  91 */     for (i = arrayOfString = idArray.length, b = 0; b < i; ) { String id = arrayOfString[b];
/*     */       for(String id : idArray){
/*  93 */       this.hrmService.removeUserById(Integer.valueOf(Integer.parseInt(id)));
/*     */       }
/*     */     
/*  96 */     mv.setViewName("redirect:/user/selectUser");
/*     */     
/*  98 */     return mv;
/*     */   }
/*     */ 
/*     */ 

/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/user/updateUser"})
/*     */   public ModelAndView updateUser(String flag, @ModelAttribute User user, ModelAndView mv) {
/* 113 */     if (flag.equals("1")) {
/*     */       
/* 115 */       User target = this.hrmService.findUserById(user.getId());
/*     */       
/* 117 */       mv.addObject("user", target);
/*     */       
/* 119 */       mv.setViewName("user/showUpdateUser");
/*     */     } else {
/*     */       
/* 122 */       this.hrmService.modifyUser(user);
/*     */       
/* 124 */       mv.setViewName("redirect:/user/selectUser");
/*     */     } 
/*     */     
/* 127 */     return mv;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/user/addUser"})
/*     */   public ModelAndView addUser(String flag, @ModelAttribute User user, ModelAndView mv) {
/* 142 */     if (flag.equals("1")) {
/*     */       
/* 144 */       mv.setViewName("user/showAddUser");
/*     */     } else {
/*     */       
/* 147 */       this.hrmService.addUser(user);
/*     */       
/* 149 */       mv.setViewName("redirect:/user/selectUser");
/*     */     } 
/*     */     
/* 152 */     return mv;
/*     */   }
/*     */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\controller\UserController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */