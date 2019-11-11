/*    */ package org.fkit.hrm.dao.provider;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.apache.ibatis.jdbc.SQL;
/*    */ import org.fkit.hrm.domain.Job;
/*    */ 
/*    */ 
/*    */ public class JobDynaSqlProvider
/*    */ {
/*    */   public String selectWhitParam(final Map<String, Object> params) {
/* 20 */     String sql = (new SQL()
/*    */       {
/*    */  {
	/* 22 */     SELECT("*");
	/* 23 */     FROM("job_inf");
	/* 24 */     if (params.get("job") != null) {
	/* 25 */       Job job = (Job)params.get("job");
	/* 26 */       if (job.getName() != null && !job.getName().equals(""))
	/* 27 */         WHERE("  name LIKE CONCAT ('%',#{job.name},'%') "); 
	/*    */     } 
	/*    */   }
/* 31 */       }).toString();
/*    */     
/* 33 */     if (params.get("pageModel") != null) {
/* 34 */       sql = String.valueOf(sql) + " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
/*    */     }
/*    */     
/* 37 */     return sql;
/*    */   }
/*    */ 
/*    */   
/* 41 */   public String count(final Map<String, Object> params) { 
				return (new SQL()
/*    */       {
/*    */ {
	/* 43 */     SELECT("count(*)");
	/* 44 */     FROM("job_inf");
	/* 45 */     if (params.get("job") != null) {
	/* 46 */       Job job = (Job)params.get("job");
	/* 47 */       if (job.getName() != null && !job.getName().equals(""))
	/* 48 */         WHERE("  name LIKE CONCAT ('%',#{job.name},'%') "); 
	/*    */     } 
	/*    */   }
/* 52 */       }).toString(); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 57 */   public String insertJob(final Job job) { 
				return (new SQL()
/*    */       {
/*    */ 		{
	/* 59 */     INSERT_INTO("job_inf");
	/* 60 */     if (job.getName() != null && !job.getName().equals("")) {
	/* 61 */       VALUES("name", "#{name}");
	/*    */     }
	/* 63 */     if (job.getRemark() != null && !job.getRemark().equals("")){
	/* 64 */       VALUES("remark", "#{remark}"); 
	/*    */   }
	/*    */ }
/* 67 */       }).toString(); }
/*    */ 
/*    */   
/* 72 */   public String updateJob(final Job job) { return (new SQL()
/*    */       {
/*    */  {
	/* 74 */     UPDATE("job_inf");
	/* 75 */     if (job.getName() != null) {
	/* 76 */       SET(" name = #{name} ");
	/*    */     }
	/* 78 */     if (job.getRemark() != null) {
	/* 79 */       SET(" remark = #{remark} ");
	/*    */     }
	/* 81 */     WHERE(" id = #{id} ");
	/*    */   }
/* 83 */       }).toString(); }
/*    */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\dao\provider\JobDynaSqlProvider.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */