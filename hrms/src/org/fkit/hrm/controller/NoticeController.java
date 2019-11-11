/*     */ package org.fkit.hrm.controller;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.fkit.hrm.domain.Notice;
/*     */ import org.fkit.hrm.domain.User;
/*     */ import org.fkit.hrm.service.HrmService;
/*     */ import org.fkit.hrm.util.tag.PageModel;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Qualifier;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*     */ @Controller
/*     */ public class NoticeController
/*     */ {
/*     */   @Autowired
/*     */   @Qualifier("hrmService")
/*     */   private HrmService hrmService;
/*     */   
/*     */   @RequestMapping({"/notice/selectNotice"})
/*     */   public String selectNotice(Model model, Integer pageIndex, @ModelAttribute Notice notice) {
/*  43 */     PageModel pageModel = new PageModel();
/*  44 */     if (pageIndex != null) {
/*  45 */       pageModel.setPageIndex(pageIndex.intValue());
/*     */     }
/*     */     
/*  48 */     List<Notice> notices = this.hrmService.findNotice(notice, pageModel);
/*  49 */     model.addAttribute("notices", notices);
/*  50 */     model.addAttribute("pageModel", pageModel);
/*  51 */     return "notice/notice";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/notice/previewNotice"})
/*     */   public String previewNotice(Integer id, Model model) {
/*  64 */     Notice notice = this.hrmService.findNoticeById(id);
/*     */     
/*  66 */     model.addAttribute("notice", notice);
/*     */     
/*  68 */     return "notice/previewNotice";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/notice/removeNotice"})
/*     */   public ModelAndView removeNotice(String ids, ModelAndView mv) {
/*  79 */     String[] idArray = ids.split(",");
//				byte b; int i; String[] arrayOfString;
///*  80 */     for (i = arrayOfString = idArray.length, b = 0; b < i; ) { String id = arrayOfString[b];
/*     */       for(String id : idArray){
/*  82 */       this.hrmService.removeNoticeById(Integer.parseInt(id));
/*     */        }
/*     */     
/*  85 */     mv.setViewName("redirect:/notice/selectNotice");
/*     */     
/*  87 */     return mv;
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
/*     */   @RequestMapping({"/notice/addNotice"})
/*     */   public ModelAndView addNotice(String flag, @ModelAttribute Notice notice, ModelAndView mv, HttpSession session) {
/* 102 */     if (flag.equals("1")) {
/* 103 */       mv.setViewName("notice/showAddNotice");
/*     */     } else {
/* 105 */       User user = (User)session.getAttribute("user_session");
/* 106 */       notice.setUser(user);
/* 107 */       this.hrmService.addNotice(notice);
/* 108 */       mv.setViewName("redirect:/notice/selectNotice");
/*     */     } 
/*     */     
/* 111 */     return mv;
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
/*     */   @RequestMapping({"/notice/updateNotice"})
/*     */   public ModelAndView updateNotice(String flag, @ModelAttribute Notice notice, ModelAndView mv, HttpSession session) {
/* 126 */     if (flag.equals("1")) {
/* 127 */       Notice target = this.hrmService.findNoticeById(notice.getId());
/* 128 */       mv.addObject("notice", target);
/* 129 */       mv.setViewName("notice/showUpdateNotice");
/*     */     } else {
/* 131 */       this.hrmService.modifyNotice(notice);
/* 132 */       mv.setViewName("redirect:/notice/selectNotice");
/*     */     } 
/*     */     
/* 135 */     return mv;
/*     */   }
/*     */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\controller\NoticeController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */