/*    */ package org.fkit.hrm.domain;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Dept
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private String name;
/*    */   private String remark;
/*    */   
/* 15 */   public void setId(Integer id) { this.id = id; }
/*    */ 
/*    */   
/* 18 */   public Integer getId() { return this.id; }
/*    */ 
/*    */   
/* 21 */   public void setName(String name) { this.name = name; }
/*    */ 
/*    */   
/* 24 */   public String getName() { return this.name; }
/*    */ 
/*    */   
/* 27 */   public void setRemark(String remark) { this.remark = remark; }
/*    */ 
/*    */   
/* 30 */   public String getRemark() { return this.remark; }
/*    */ 
/*    */ 
/*    */   
/* 34 */   public String toString() { return "Dept [id=" + this.id + ", name=" + this.name + ", remark=" + this.remark + "]"; }
/*    */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\domain\Dept.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */