/*    */ package org.fkit.hrm.domain;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Document
/*    */   implements Serializable
/*    */ {
/*    */   private int id;
/*    */   private String title;
/*    */   private String fileName;
/*    */   private MultipartFile file;
/*    */   private String remark;
/*    */   private Date createDate;
/*    */   private User user;
/*    */   
/* 22 */   public void setId(int id) { this.id = id; }
/*    */ 
/*    */   
/* 25 */   public int getId() { return this.id; }
/*    */ 
/*    */   
/* 28 */   public void setTitle(String title) { this.title = title; }
/*    */ 
/*    */   
/* 31 */   public String getTitle() { return this.title; }
/*    */ 
/*    */ 
/*    */   
/* 35 */   public String getFileName() { return this.fileName; }
/*    */ 
/*    */   
/* 38 */   public void setFileName(String fileName) { this.fileName = fileName; }
/*    */ 
/*    */   
/* 41 */   public MultipartFile getFile() { return this.file; }
/*    */ 
/*    */   
/* 44 */   public void setFile(MultipartFile file) { this.file = file; }
/*    */ 
/*    */   
/* 47 */   public void setRemark(String remark) { this.remark = remark; }
/*    */ 
/*    */   
/* 50 */   public String getRemark() { return this.remark; }
/*    */ 
/*    */   
/* 53 */   public void setCreateDate(Date createDate) { this.createDate = createDate; }
/*    */ 
/*    */   
/* 56 */   public Date getCreateDate() { return this.createDate; }
/*    */ 
/*    */   
/* 59 */   public User getUser() { return this.user; }
/*    */ 
/*    */   
/* 62 */   public void setUser(User user) { this.user = user; }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 66 */     return "Document [id=" + this.id + ", title=" + this.title + ", fileName=" + 
/* 67 */       this.fileName + ", file=" + this.file + ", remark=" + this.remark + 
/* 68 */       ", createDate=" + this.createDate + ", user=" + this.user + "]";
/*    */   }
/*    */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\domain\Document.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */