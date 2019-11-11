/*    */ package org.fkit.hrm.domain;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Job
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private String name;
/*    */   private String remark;
/*    */   
/* 16 */   public void setId(Integer id) { this.id = id; }
/*    */ 
/*    */   
/* 19 */   public Integer getId() { return this.id; }
/*    */ 
/*    */   
/* 22 */   public void setName(String name) { this.name = name; }
/*    */ 
/*    */   
/* 25 */   public String getName() { return this.name; }
/*    */ 
/*    */   
/* 28 */   public void setRemark(String remark) { this.remark = remark; }
/*    */ 
/*    */   
/* 31 */   public String getRemark() { return this.remark; }
/*    */ 
/*    */ 
/*    */   
/* 35 */   public String toString() { return "Job [id=" + this.id + ", name=" + this.name + ", remark=" + this.remark + "]"; }
/*    */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\domain\Job.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */