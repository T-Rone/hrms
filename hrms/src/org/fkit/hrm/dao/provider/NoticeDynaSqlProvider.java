/*    */ package org.fkit.hrm.dao.provider;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.apache.ibatis.jdbc.SQL;
/*    */ import org.fkit.hrm.domain.Notice;
/*    */ 
/*    */ public class NoticeDynaSqlProvider
/*    */ {
/*    */   public String selectWhitParam(final Map<String, Object> params) {
/* 19 */     String sql = (new SQL()
/*    */       {
/*    */ {
	/* 21 */     SELECT("*");
	/* 22 */     FROM("notice_inf");
	/* 23 */     if (params.get("notice") != null) {
	/* 24 */       Notice notice = (Notice)params.get("notice");
	/* 25 */       if (notice.getTitle() != null && !notice.getTitle().equals("")) {
	/* 26 */         WHERE("  title LIKE CONCAT ('%',#{notice.title},'%') ");
	/*    */       }
	/* 28 */       if (notice.getContent() != null && !notice.getContent().equals(""))
	/* 29 */         WHERE("  content LIKE CONCAT ('%',#{notice.content},'%') "); 
	/*    */     } 
	/*    */   }
/* 33 */       }).toString();
/*    */     
/* 35 */     if (params.get("pageModel") != null) {
/* 36 */       sql = String.valueOf(sql) + " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
/*    */     }
/*    */     
/* 39 */     return sql;
/*    */   }
/*    */ 
/*    */   
/* 43 */   public String count(final Map<String, Object> params) { return (new SQL()
/*    */       {
/*    */ {
	/* 45 */     SELECT("count(*)");
	/* 46 */     FROM("notice_inf");
	/* 47 */     if (params.get("notice") != null) {
	/* 48 */       Notice notice = (Notice)params.get("notice");
	/* 49 */       if (notice.getTitle() != null && !notice.getTitle().equals("")) {
	/* 50 */         WHERE("  title LIKE CONCAT ('%',#{notice.title},'%') ");
	/*    */       }
	/* 52 */       if (notice.getContent() != null && !notice.getContent().equals(""))
	/* 53 */         WHERE("  content LIKE CONCAT ('%',#{notice.content},'%') "); 
	/*    */     } 
	/*    */   }
/* 57 */       }).toString(); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 62 */   public String insertNotice(final Notice notice) { 
				return (new SQL()
/*    */       {
/*    */ {
	/* 64 */     INSERT_INTO("notice_inf");
	/* 65 */     if (notice.getTitle() != null && !notice.getTitle().equals("")) {
	/* 66 */       VALUES("title", "#{title}");
	/*    */     }
	/* 68 */     if (notice.getContent() != null && !notice.getContent().equals("")) {
	/* 69 */       VALUES("content", "#{content}");
	/*    */     }
	/* 71 */     if (notice.getUser() != null && notice.getUser().getId() != null){
	/* 72 */       VALUES("user_id", "#{user.id}"); 
	/*    */   }
	/*    */ }
/* 75 */       }).toString(); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 80 */   public String updateNotice(final Notice notice) { 
				return (new SQL()
/*    */       {
/*    */ {
	/* 82 */     UPDATE("notice_inf");
	/* 83 */     if (notice.getTitle() != null && !notice.getTitle().equals("")) {
	/* 84 */       SET(" title = #{title} ");
	/*    */     }
	/* 86 */     if (notice.getContent() != null && !notice.getContent().equals("")) {
	/* 87 */       SET(" content = #{content} ");
	/*    */     }
	/* 89 */     if (notice.getUser() != null && notice.getUser().getId() != null) {
	/* 90 */       SET(" user_id = #{user.id} ");
	/*    */     }
	/* 92 */     WHERE(" id = #{id} ");
	/*    */   }
/* 94 */       }).toString(); }
/*    */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\dao\provider\NoticeDynaSqlProvider.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */