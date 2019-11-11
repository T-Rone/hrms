/*    */ package org.fkit.hrm.domain;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Notice
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private String title;
/*    */   private String content;
/*    */   private Date createDate;
/*    */   private User user;//相当于外键 也就是关联关系
/*    */   
/* 18 */   public void setId(Integer id) { this.id = id; }
/*    */ 
/*    */   
/* 21 */   public Integer getId() { return this.id; }
/*    */ 
/*    */   
/* 24 */   public void setTitle(String title) { this.title = title; }
/*    */ 
/*    */   
/* 27 */   public String getTitle() { return this.title; }
/*    */ 
/*    */   
/* 30 */   public void setContent(String content) { this.content = content; }
/*    */ 
/*    */   
/* 33 */   public String getContent() { return this.content; }
/*    */ 
/*    */   
/* 36 */   public void setCreateDate(Date createDate) { this.createDate = createDate; }
/*    */ 
/*    */   
/* 39 */   public Date getCreateDate() { return this.createDate; }
/*    */ 
/*    */   
/* 42 */   public User getUser() { return this.user; }
/*    */ 
/*    */   
/* 45 */   public void setUser(User user) { this.user = user; }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 49 */     return "Notice [id=" + this.id + ", title=" + this.title + ", content=" + this.content + 
/* 50 */       ", createDate=" + this.createDate + ", user=" + this.user + "]";
/*    */   }
/*    */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\domain\Notice.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */