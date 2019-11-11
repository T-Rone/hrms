/*     */ package org.fkit.hrm.controller;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ import org.fkit.hrm.domain.Document;
/*     */ import org.fkit.hrm.domain.User;
/*     */ import org.fkit.hrm.service.HrmService;
/*     */ import org.fkit.hrm.util.tag.PageModel;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Qualifier;
/*     */ import org.springframework.http.HttpHeaders;
/*     */ import org.springframework.http.HttpStatus;
/*     */ import org.springframework.http.MediaType;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ public class DocumentController
/*     */ {
			
/*     */   @Autowired
/*     */   @Qualifier("hrmService")
/*     */   private HrmService hrmService;
/*     */   
/*     */   @RequestMapping({"/document/selectDocument"})
/*     */   public String selectDocument(Model model, Integer pageIndex, @ModelAttribute Document document) {
/*  51 */     PageModel pageModel = new PageModel();
/*  52 */     if (pageIndex != null) {
/*  53 */       pageModel.setPageIndex(pageIndex.intValue());
/*     */     }
/*     */     
/*  56 */     List<Document> documents = this.hrmService.findDocument(document, pageModel);
/*  57 */     model.addAttribute("documents", documents);
/*  58 */     model.addAttribute("pageModel", pageModel);
/*  59 */     return "document/document";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/document/addDocument"})
/*     */   public ModelAndView addDocument(String flag, @ModelAttribute Document document, ModelAndView mv, HttpSession session) throws Exception {
/*  75 */     if (flag.equals("1")) {
/*  76 */       mv.setViewName("document/showAddDocument");
/*     */     } else {
/*     */       
/*  79 */       String path = session.getServletContext().getRealPath(
/*  80 */           "/upload/");
/*  81 */       System.out.println(path);
/*     */       
/*  83 */       String fileName = document.getFile().getOriginalFilename();
/*     */       
/*  85 */       document.getFile().transferTo(new File(String.valueOf(path) + File.separator + fileName));
/*     */ 
/*     */ 
/*     */       
/*  89 */       document.setFileName(fileName);
/*     */       
/*  91 */       User user = (User)session.getAttribute("user_session");
/*  92 */       document.setUser(user);
/*     */       
/*  94 */       this.hrmService.addDocument(document);
/*     */       
/*  96 */       mv.setViewName("redirect:/document/selectDocument");
/*     */     } 
/*     */     
/*  99 */     return mv;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/document/removeDocument"})
/*     */   public ModelAndView removeDocument(String ids, ModelAndView mv) {
/* 110 */     String[] idArray = ids.split(","); 
//byte b; int i; String[] arrayOfString;
///* 111 */     for (i = arrayOfString = idArray.length, b = 0; b < i; ) { String id = arrayOfString[b];
/*     */     for(String id : idArray){  
/* 113 */       this.hrmService.removeDocumentById(Integer.parseInt(id));
/*     */        }
/*     */     
/* 116 */     mv.setViewName("redirect:/document/selectDocument");
/*     */     
/* 118 */     return mv;
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
/*     */   @RequestMapping({"/document/updateDocument"})
/*     */   public ModelAndView updateDocument(String flag, @ModelAttribute Document document, ModelAndView mv) {
/* 132 */     if (flag.equals("1")) {
/*     */       
/* 134 */       Document target = this.hrmService.findDocumentById(Integer.valueOf(document.getId()));
/*     */       
/* 136 */       mv.addObject("document", target);
/*     */       
/* 138 */       mv.setViewName("document/showUpdateDocument");
/*     */     } else {
/*     */       
/* 141 */       this.hrmService.modifyDocument(document);
/*     */       
/* 143 */       mv.setViewName("redirect:/document/selectDocument");
/*     */     } 
/*     */     
/* 146 */     return mv;
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
/*     */   @RequestMapping({"/document/downLoad"})
/*     */   public ResponseEntity<byte[]> downLoad(Integer id, HttpSession session) throws Exception {
/* 160 */     Document target = this.hrmService.findDocumentById(id);
/* 161 */     String fileName = target.getFileName();
/*     */     
/* 163 */     String path = session.getServletContext().getRealPath(
/* 164 */         "/upload/");
/*     */     
/* 166 */     File file = new File(String.valueOf(path) + File.separator + fileName);
/*     */     
/* 168 */     HttpHeaders headers = new HttpHeaders();
/*     */     
/* 170 */     String downloadFielName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
/*     */     
/* 172 */     headers.setContentDispositionFormData("attachment", downloadFielName);
/*     */     
/* 174 */     headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
/*     */     
/* 176 */     return new ResponseEntity(FileUtils.readFileToByteArray(file), 
/* 177 */         headers, HttpStatus.CREATED);
/*     */   }
/*     */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\controller\DocumentController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */