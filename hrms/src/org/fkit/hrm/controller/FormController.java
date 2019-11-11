/*    */ package org.fkit.hrm.controller;
/*    */ 
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ public class FormController
/*    */ {
/*    */   @RequestMapping({"/{formName}"})
/* 38 */   public String loginForm(@PathVariable String formName) { return formName; }
/*    */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\controller\FormController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */