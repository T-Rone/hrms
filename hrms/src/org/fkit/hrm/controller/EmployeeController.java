/*     */ package org.fkit.hrm.controller;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.fkit.hrm.domain.Dept;
/*     */ import org.fkit.hrm.domain.Employee;
/*     */ import org.fkit.hrm.domain.Job;
import org.fkit.hrm.domain.Sal;
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
/*     */ 
/*     */ @Controller
/*     */ public class EmployeeController
/*     */ {
/*     */   @Autowired
/*     */   @Qualifier("hrmService")
/*     */   private HrmService hrmService;
/*     */   
/*     */   @RequestMapping({"/employee/selectEmployee"})
/*     */   public String selectEmployee(Integer pageIndex, Integer job_id, Integer dept_id, Integer sal_id,@ModelAttribute Employee employee, Model model) {
/*  47 */     genericAssociation(job_id, dept_id, sal_id, employee);
/*     */     
/*  49 */     PageModel pageModel = new PageModel();
/*     */     
/*  51 */     if (pageIndex != null) {
/*  52 */       pageModel.setPageIndex(pageIndex.intValue());
/*     */     }
/*     */     
/*  55 */     List<Job> jobs = this.hrmService.findAllJob();
/*     */     List<Sal> sals=this.hrmService.findAllSal();
/*  57 */     List<Dept> depts = this.hrmService.findAllDept();
/*     */     
/*  59 */     List<Employee> employees = this.hrmService.findEmployee(employee, pageModel);
/*     */     
/*  61 */     model.addAttribute("employees", employees);
/*  62 */     model.addAttribute("jobs", jobs);
/*  63 */     model.addAttribute("depts", depts);
			  model.addAttribute("sals",sals);
/*  64 */     model.addAttribute("pageModel", pageModel);
/*     */     
/*  66 */     return "employee/employee";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/employee/addEmployee"})
/*     */   public ModelAndView addEmployee(String flag, Integer job_id, Integer dept_id,Integer sal_id, @ModelAttribute Employee employee, ModelAndView mv) {
/*  84 */     if (flag.equals("1")) {
/*     */       
/*  86 */       List<Job> jobs = this.hrmService.findAllJob();
/*     */       List<Sal> sals=this.hrmService.findAllSal();
/*  88 */       List<Dept> depts = this.hrmService.findAllDept();
/*     */       
/*  90 */       mv.addObject("jobs", jobs);
/*  91 */       mv.addObject("depts", depts);
/*     */       mv.addObject("sals",sals);
/*  93 */       mv.setViewName("employee/showAddEmployee");
/*     */     } else {
/*     */       
/*Íâ¼üÁ´½Ó 96 */       genericAssociation(job_id, dept_id,sal_id,employee);
/*     */       
/*  98 */       this.hrmService.addEmployee(employee);
/*     */       
/* 100 */       mv.setViewName("redirect:/employee/selectEmployee");
/*     */     } 
/*     */     
/* 103 */     return mv;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/employee/removeEmployee"})
/*     */   public ModelAndView removeEmployee(String ids, ModelAndView mv) {
/* 115 */     String[] idArray = ids.split(",");
//byte b; int i; String[] arrayOfString;
///* 116 */     for (i = arrayOfString = idArray.length, b = 0; b < i; ) { String id = arrayOfString[b];
/*     */      for(String id : idArray){ 
/* 118 */       this.hrmService.removeEmployeeById(Integer.parseInt(id));
/*     */       
/*     */       }
/*     */ 
/*     */     
/* 123 */     mv.setViewName("redirect:/employee/selectEmployee");
/*     */     
/* 125 */     return mv;
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
/*     */ 
/*     */   
/*     */   @RequestMapping({"/employee/updateEmployee"})
/*     */   public ModelAndView updateEmployee(String flag, Integer job_id, Integer dept_id,Integer sal_id, @ModelAttribute Employee employee, ModelAndView mv) {
/* 142 */     if (flag.equals("1")) {
/*     */       
/* 144 */       Employee target = this.hrmService.findEmployeeById(employee.getId());
/*     */       
/* 146 */       List<Job> jobs = this.hrmService.findAllJob();
/*     */        List<Sal> sals=this.hrmService.findAllSal();
/* 148 */       List<Dept> depts = this.hrmService.findAllDept();
/*     */       
/* 150 */       mv.addObject("jobs", jobs);
/* 151 */       mv.addObject("depts", depts);
				mv.addObject("sals",sals);
/* 152 */       mv.addObject("employee", target);
/*     */       
/* 154 */       mv.setViewName("employee/showUpdateEmployee");
/*     */     } else {
/*     */       
/* 157 */       genericAssociation(job_id, dept_id,sal_id, employee);
/* 158 */       System.out.println("updateEmployee -->> " + employee);
/*     */       
/* 160 */       this.hrmService.modifyEmployee(employee);
/*     */       
/* 162 */       mv.setViewName("redirect:/employee/selectEmployee");
/*     */     } 
/*     */     
/* 165 */     return mv;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void genericAssociation(Integer job_id, Integer dept_id, Integer sal_id, Employee employee) {
/* 174 */     if (job_id != null) {
/* 175 */       Job job = new Job();
/* 176 */       job.setId(job_id);
/* 177 */       employee.setJob(job);
/*     */     } 
/* 179 */     if (dept_id != null) {
/* 180 */       Dept dept = new Dept();
/* 181 */       dept.setId(dept_id);
/* 182 */       employee.setDept(dept);
/*     */     }
			if(sal_id!=null)
			{
				Sal sal=new Sal();
				sal.setId(sal_id);
				employee.setSal(sal);
			}
/*     */   }
/*     */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\controller\EmployeeController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */