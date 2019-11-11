/*     */ package org.fkit.hrm.controller;
/*     */ 
/*     */ import java.util.List;

import javax.annotation.Resource;

/*     */ import org.fkit.hrm.domain.Dept;
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
/*     */ public class DeptController
/*     */ { 
	
/*     */   @Autowired
/*     */   @Qualifier("hrmService")
/*     */   private HrmService hrmService;
/*     */   
/*     */   @RequestMapping({"/dept/selectDept"})
/*     */   public String selectDept(Model model, Integer pageIndex, @ModelAttribute Dept dept) {
/*  39 */     System.out.println("selectDept -->>");
/*  40 */     System.out.println("pageIndex = " + pageIndex);
/*  41 */     System.out.println("dept = " + dept);
/*  42 */     PageModel pageModel = new PageModel();
/*  43 */     System.out.println("getPageIndex = " + pageModel.getPageIndex());
/*  44 */     System.out.println("getPageSize = " + pageModel.getPageSize());
/*  45 */     System.out.println("getRecordCount = " + pageModel.getRecordCount());
/*  46 */     if (pageIndex != null) {
/*  47 */       pageModel.setPageIndex(pageIndex.intValue());
/*     */     }
/*     */     
/*  50 */     List<Dept> depts = this.hrmService.findDept(dept, pageModel);
/*  51 */     model.addAttribute("depts", depts);
/*  52 */     model.addAttribute("pageModel", pageModel);
/*  53 */     return "dept/dept";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/dept/removeDept"})
/*     */   public ModelAndView removeDept(String ids, ModelAndView mv) {
/*  65 */     String[] idArray = ids.split(",");
//				byte b; int i; String[] arrayOfString;
///*  66 */     for (i = arrayOfString = idArray.length, b = 0; b < i; ) { String id = arrayOfString[b];
/*     */      for(String id : idArray){ 
/*  68 */       this.hrmService.removeDeptById(Integer.parseInt(id));
/*     */       }
/*     */     
/*  71 */     mv.setViewName("redirect:/dept/selectDept");
/*     */     
/*  73 */     return mv;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/dept/addDept"})
/*     */   public ModelAndView addDept(String flag, @ModelAttribute Dept dept, ModelAndView mv) {
/*  87 */     if (flag.equals("1")) {
/*     */       
/*  89 */       mv.setViewName("dept/showAddDept");
/*     */     } else {
/*     */       
/*  92 */       this.hrmService.addDept(dept);
/*     */       
/*  94 */       mv.setViewName("redirect:/dept/selectDept");
/*     */     } 
/*     */     
/*  97 */     return mv;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/dept/updateDept"})
/*     */   public ModelAndView updateDpet(String flag, @ModelAttribute Dept dept, ModelAndView mv) {
/* 112 */     if (flag.equals("1")) {
/*     */       
/* 114 */       Dept target = this.hrmService.findDeptById(dept.getId());
/*     */       
/* 116 */       mv.addObject("dept", target);
/*     */       
/* 118 */       mv.setViewName("dept/showUpdateDept");
/*     */     } else {
/*     */       
/* 121 */       this.hrmService.modifyDept(dept);
/*     */       
/* 123 */       mv.setViewName("redirect:/dept/selectDept");
/*     */     } 
/*     */     
/* 126 */     return mv;
/*     */   }
/*     */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\controller\DeptController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */