/*     */ package org.fkit.hrm.dao.provider;
/*     */ 
/*     */ import java.util.Map;
/*     */ import org.apache.ibatis.jdbc.SQL;
/*     */ import org.fkit.hrm.domain.User;
/*     */ public class UserDynaSqlProvider
/*     */ {
/*     */   public String selectWhitParam(final Map<String, Object> params) {
/*  18 */     String sql = (new SQL()
/*     */       {
/*     */ {
	/* 20 */     SELECT("*");
	/* 21 */     FROM("user_inf");
	/* 22 */     if (params.get("user") != null) {
	/* 23 */       User user = (User)params.get("user");
	/* 24 */       if (user.getUsername() != null && !user.getUsername().equals("")) {
	/* 25 */         WHERE("  username LIKE CONCAT ('%',#{user.username},'%') ");
	/*    */       }
	/* 27 */       if (user.getStatus() != null && !user.getStatus().equals(""))
	/* 28 */         WHERE(" status LIKE CONCAT ('%',#{user.status},'%') "); 
	/*    */     } 
	/*    */   }
/*  32 */       }).toString();
/*     */     
/*  34 */     if (params.get("pageModel") != null) {
/*  35 */       sql = String.valueOf(sql) + " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
/*     */     }
/*     */     
/*  38 */     return sql;
/*     */   }
/*     */ 
/*     */   
/*  42 */   public String count(final Map<String, Object> params) { return (new SQL()
/*     */       {
/*     */ {
	/* 44 */     SELECT("count(*)");
	/* 45 */     FROM("user_inf");
	/* 46 */     if (params.get("user") != null) {
	/* 47 */       User user = (User)params.get("user");
	/* 48 */       if (user.getUsername() != null && !user.getUsername().equals("")) {
	/* 49 */         WHERE(" username LIKE CONCAT ('%',#{user.username},'%') ");
	/*    */       }
	/* 51 */       if (user.getStatus() != null && !user.getStatus().equals(""))
	/* 52 */         WHERE(" status LIKE CONCAT ('%',#{user.status},'%') "); 
	/*    */     } 
	/*    */   }
/*  56 */       }).toString(); }
/*     */ 
/*     */ 
/*     */   
/*  63 */   public String insertUser(final User user) { return (new SQL()
/*     */       {
/*     */ {
	/* 65 */     INSERT_INTO("user_inf");
	/* 66 */     if (user.getUsername() != null && !user.getUsername().equals("")) {
	/* 67 */       VALUES("username", "#{username}");
	/*    */     }
	/* 69 */     if (user.getStatus() != null && !user.getStatus().equals("")) {
	/* 70 */       VALUES("status", "#{status}");
	/*    */     }
	/* 72 */     if (user.getLoginname() != null && !user.getLoginname().equals("")) {
	/* 73 */       VALUES("loginname", "#{loginname}");
	/*    */     }
	/* 75 */     if (user.getPassword() != null && !user.getPassword().equals("")){
	/* 76 */       VALUES("password", "#{password}"); 
	/*    */   }
	/*    */ }
/*  79 */       }).toString(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String insertUser1(final User user) {
/*  85 */     SQL sql = new SQL()
/*     */       {
/*     */       {
	/* 88 */     INSERT_INTO("user_inf");
	/* 89 */     if (user.getUsername() != null && !user.getUsername().equals("")) {
	/* 90 */       VALUES("username", "#{username}");
	/*    */     }
	/* 92 */     if (user.getStatus() != null && !user.getStatus().equals("")) {
	/* 93 */       VALUES("status", "#{status}");
	/*    */     }
	/* 95 */     if (user.getLoginname() != null && !user.getLoginname().equals("")) {
	/* 96 */       VALUES("loginname", "#{loginname}");
	/*    */     }
	/* 98 */     if (user.getPassword() != null && !user.getPassword().equals("")){
	/* 99 */       VALUES("password", "#{password}"); 
	/*    */   }
	/*    */ }
/*     */       };
/* 104 */     return sql.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 110 */   public String updateUser(final User user) { return (new SQL()
/*     */       {
/*     */ {
	/* 112 */     UPDATE("user_inf");
	/* 113 */     if (user.getUsername() != null) {
	/* 114 */       SET(" username = #{username} ");
	/*     */     }
	/* 116 */     if (user.getLoginname() != null) {
	/* 117 */       SET(" loginname = #{loginname} ");
	/*     */     }
	/* 119 */     if (user.getPassword() != null) {
	/* 120 */       SET(" password = #{password} ");
	/*     */     }
	/* 122 */     if (user.getStatus() != null) {
	/* 123 */       SET(" status = #{status} ");
	/*     */     }
	/* 125 */     if (user.getCreateDate() != null) {
	/* 126 */       SET(" create_date = #{createDate} ");
	/*     */     }
	/* 128 */     WHERE(" id = #{id} ");
	/*     */   }
/* 130 */       }).toString(); }
/*     */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\dao\provider\UserDynaSqlProvider.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */