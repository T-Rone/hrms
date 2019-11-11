/*    */ package org.fkit.hrm.dao.provider;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.apache.ibatis.jdbc.SQL;
/*    */ import org.fkit.hrm.domain.Document;
/*    */ public class DocumentDynaSqlProvider
/*    */ {
/*    */   public String selectWhitParam(final Map<String, Object> params) {
/* 18 */     String sql = (new SQL()
/*    */       {
/*    */  {
	/* 20 */     SELECT("*");
	/* 21 */     FROM("document_inf");
	/* 22 */     if (params.get("document") != null) {
	/* 23 */       Document document = (Document)params.get("document");
	/* 24 */       if (document.getTitle() != null && !document.getTitle().equals("")){
	/* 25 */         WHERE("  title LIKE CONCAT ('%',#{document.title},'%') "); 
	/*    */     } 
	/*    */   }
	/*    */ }
/* 29 */       }).toString();
/*    */     
/* 31 */     if (params.get("pageModel") != null) {
/* 32 */       sql = String.valueOf(sql) + " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
/*    */     }
/*    */     
/* 35 */     return sql;
/*    */   }
/*    */ 
/*    */   
/* 39 */   public String count(final Map<String, Object> params) { return (new SQL()
/*    */       {
/*    */ {
	/* 41 */     SELECT("count(*)");
	/* 42 */     FROM("document_inf");
	/* 43 */     if (params.get("document") != null) {
	/* 44 */       Document document = (Document)params.get("document");
	/* 45 */       if (document.getTitle() != null && !document.getTitle().equals("")){
	/* 46 */         WHERE("  title LIKE CONCAT ('%',#{document.title},'%') "); 
	/*    */     } 
	/*    */   }
	/*    */ }
/* 50 */       }).toString(); }
/*    */   
/* 55 */   public String insertDocument(final Document document) { return (new SQL()
/*    */       {
/*    */  {
	/* 57 */     INSERT_INTO("document_inf");
	/* 58 */     if (document.getTitle() != null && !document.getTitle().equals("")) {
	/* 59 */       VALUES("title", "#{title}");
	/*    */     }
	/* 61 */     if (document.getFileName() != null && !document.getFileName().equals("")) {
	/* 62 */       VALUES("filename", "#{fileName}");
	/*    */     }
	/* 64 */     if (document.getRemark() != null && !document.getRemark().equals("")) {
	/* 65 */       VALUES("remark", "#{remark}");
	/*    */     }
	/* 67 */     if (document.getUser() != null && document.getUser().getId() != null){
	/* 68 */       VALUES("user_id", "#{user.id}"); 
	/*    */   }
	/*    */ }
}).toString(); }
/*    */ 
/*    */   
/* 77 */   public String updateDocument(final Document document) { return (new SQL()
/*    */       {
/*    */  {
	/* 79 */     UPDATE("document_inf");
	/* 80 */     if (document.getTitle() != null && !document.getTitle().equals("")) {
	/* 81 */       SET(" title = #{title} ");
	/*    */     }
	/* 83 */     if (document.getFileName() != null && !document.getFileName().equals("")) {
	/* 84 */       SET(" filename = #{fileName} ");
	/*    */     }
	/* 86 */     if (document.getRemark() != null && !document.getRemark().equals("")) {
	/* 87 */       SET("remark = #{remark}");
	/*    */     }
	/* 89 */     if (document.getUser() != null && document.getUser().getId() != null) {
	/* 90 */       SET("user_id = #{user.id}");
	/*    */     }
	/* 92 */     WHERE(" id = #{id} ");
	/*    */   }
/* 94 */       }).toString(); 
			}
/*    */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\dao\provider\DocumentDynaSqlProvider.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */