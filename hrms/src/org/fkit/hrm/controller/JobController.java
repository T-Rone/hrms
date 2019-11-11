/*     */ package org.fkit.hrm.controller;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.fkit.hrm.domain.Job;
/*     */ import org.fkit.hrm.service.HrmService;
/*     */ import org.fkit.hrm.util.tag.PageModel;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Qualifier;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ public class JobController
/*     */ {
/*     */   @Autowired
/*     */   @Qualifier("hrmService")
/*     */   private HrmService hrmService;
/*     */   
/*     */   @RequestMapping({"/job/selectJob"})
/*     */   public String selectJob(Model model, Integer pageIndex, @ModelAttribute Job job) {
/*  39 */     System.out.println("selectJob -->> " + job);
/*  40 */     PageModel pageModel = new PageModel();
/*  41 */     if (pageIndex != null) {
/*  42 */       pageModel.setPageIndex(pageIndex.intValue());
/*     */     }
/*     */     
/*  45 */     List<Job> jobs = this.hrmService.findJob(job, pageModel);
/*  46 */     model.addAttribute("jobs", jobs);
/*  47 */     model.addAttribute("pageModel", pageModel);
/*  48 */     return "job/job";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/job/removeJob"})
/*     */   public ModelAndView removeJob(String ids, ModelAndView mv) {
/*  60 */     String[] idArray = ids.split(",");
//byte b; int i; String[] arrayOfString;
///*  61 */     for (i = arrayOfString = idArray.length, b = 0; b < i; ) { String id = arrayOfString[b];
/*     */ for(String id : idArray){      
/*  63 */       this.hrmService.removeJobById(Integer.parseInt(id));
/*     */       }
/*     */     
/*  66 */     mv.setViewName("redirect:/job/selectJob");
/*     */     
/*  68 */     return mv;
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
/*     */   @RequestMapping({"/job/addJob"})
/*     */   public ModelAndView addJob(String flag, @ModelAttribute Job job, ModelAndView mv) {
/*  82 */     if (flag.equals("1")) {
/*     */       
/*  84 */       mv.setViewName("job/showAddJob");
/*     */     } else {
/*     */       
/*  87 */       this.hrmService.addJob(job);
/*     */       
/*  89 */       mv.setViewName("redirect:/job/selectJob");
/*     */     } 
/*     */     
/*  92 */     return mv;
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
/*     */   @RequestMapping({"/job/updateJob"})
/*     */   public ModelAndView updateDpet(String flag, @ModelAttribute Job job, ModelAndView mv) {
/* 107 */     if (flag.equals("1")) {
/*     */       
/* 109 */       Job target = this.hrmService.findJobById(job.getId());
/*     */       
/* 111 */       mv.addObject("job", target);
/*     */       
/* 113 */       mv.setViewName("job/showUpdateJob");
/*     */     } else {
/*     */       
/* 116 */       this.hrmService.modifyJob(job);
/*     */       
/* 118 */       mv.setViewName("redirect:/job/selectJob");
/*     */     } 
/*     */     
/* 121 */     return mv;
/*     */   }
/*     */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\controller\JobController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */