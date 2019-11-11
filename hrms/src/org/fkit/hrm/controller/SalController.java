package org.fkit.hrm.controller;
/*     */ import java.util.List;
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

		@Controller
		public class SalController {
				  @Autowired
	  /*     */   @Qualifier("hrmService")
	  /*     */   private HrmService hrmService;
				
				  @RequestMapping({"/sal/selectSal"})
				  public String selectSal(Integer pageIndex, @ModelAttribute Sal sal, Model model) {
				  /*  47 */       System.out.println("selectSal -->>");
				  /*  40 */     System.out.println("pageIndex = " + pageIndex);
				  /*  41 */     System.out.println("sal = " + sal);
				  /*  42 */     PageModel pageModel = new PageModel();
				  /*  43 */     System.out.println("getPageIndex = " + pageModel.getPageIndex());
				  /*  44 */     System.out.println("getPageSize = " + pageModel.getPageSize());
				  /*  45 */     System.out.println("getRecordCount = " + pageModel.getRecordCount());
				  /*  46 */     if (pageIndex != null) {
				  /*  47 */       pageModel.setPageIndex(pageIndex.intValue());
				  /*     */     }
				  /*     */     
				  /*  50 */     List<Sal> sals= this.hrmService.findSal(sal, pageModel);
				  /*  51 */     model.addAttribute("sals", sals);
				  /*  52 */     model.addAttribute("pageModel", pageModel);
				  /*  53 */     return "sal/sal";
				  /*     */   }
				  
				  
				  @RequestMapping({"/sal/removeSal"})
				  public ModelAndView removeSal(String ids, ModelAndView mv) {
				  /*  65 */     String[] idArray = ids.split(",");
//				  				byte b; int i; String[] arrayOfString;
				  //     for (i = arrayOfString = idArray.length, b = 0; b < i; ) { String id = arrayOfString[b];
				  /*     */      for(String id : idArray){ 
				  /*  68 */       this.hrmService.removeSalById(Integer.parseInt(id));
				  /*     */       }
				  /*     */     
				  /*  71 */     mv.setViewName("redirect:/sal/selectSal");
				  /*     */     
				  /*  73 */     return mv;
				  /*     */   }
				  
				  
				    @RequestMapping({"/sal/addSal"})
				    public ModelAndView addSal(String flag, @ModelAttribute Sal sal, ModelAndView mv) {
				  /*  87 */     if (flag.equals("1")) {
				  /*     */       
				  /*  89 */       mv.setViewName("sal/showAddSal");
				  /*     */     } else {
				  /*     */       
				  /*  92 */       this.hrmService.addSal(sal);
				  /*     */       
				  /*  94 */       mv.setViewName("redirect:/sal/selectSal");
				  /*     */     } 
				  /*     */     
				  /*  97 */     return mv;
				  /*     */   }
				    
				    
				    @RequestMapping({"/sal/updateSal"})
				    public ModelAndView updateSal(String flag, @ModelAttribute Sal sal, ModelAndView mv) {
				    /* 112 */     if (flag.equals("1")) {
				    /*     */       
				    /* 114 */      Sal target = this.hrmService.findSalById(sal.getId());
				    /*     */       
				    /* 116 */       mv.addObject("sal", target);
				    /*     */       
				    /* 118 */       mv.setViewName("sal/showUpdateSal");
				    /*     */     } else {
				    /*     */       
				    /* 121 */       this.hrmService.modifySal(sal);
				    /*     */       
				    /* 123 */       mv.setViewName("redirect:/sal/selectSal");
				    /*     */     } 
				    /*     */     
				    /* 126 */     return mv;
				    /*     */   }
		}
