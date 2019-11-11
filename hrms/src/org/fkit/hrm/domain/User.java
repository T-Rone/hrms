/*    */ package org.fkit.hrm.domain;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 

/*    */ 
/*    */ 
/*    */ public class User
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private String username;
/*    */   private String loginname;
/*    */   private String password;
/*    */   private Integer status;
/*    */   private Date createDate;
/*    */   
/* 27 */   public Integer getId() { return this.id; }
/*    */ 
/*    */   
/* 30 */   public void setId(Integer id) { this.id = id; }
/*    */ 
/*    */ 
/*    */   
/* 34 */   public String getUsername() { return this.username; }
/*    */ 
/*    */   
/* 37 */   public void setUsername(String username) { this.username = username; }
/*    */ 
/*    */   
/* 40 */   public String getLoginname() { return this.loginname; }
/*    */ 
/*    */   
/* 43 */   public void setLoginname(String loginname) { this.loginname = loginname; }
/*    */ 
/*    */   
/* 46 */   public String getPassword() { return this.password; }
/*    */ 
/*    */   
/* 49 */   public void setPassword(String password) { this.password = password; }
/*    */ 
/*    */   
/* 52 */   public Integer getStatus() { return this.status; }
/*    */ 
/*    */   
/* 55 */   public void setStatus(Integer status) { this.status = status; }
/*    */ 
/*    */   
/* 58 */   public Date getCreateDate() { return this.createDate; }
/*    */ 
/*    */   
/* 61 */   public void setCreateDate(Date createDate) { this.createDate = createDate; }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 65 */     return "User [id=" + this.id + ", username=" + this.username + ", loginname=" + 
/* 66 */       this.loginname + ", password=" + this.password + ", status=" + this.status + 
/* 67 */       ", createDate=" + this.createDate + "]";
/*    */   }
/*    */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\domain\User.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */