/*    */ package org.fkit.hrm.dao.provider;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.apache.ibatis.jdbc.SQL;
/*    */ import org.fkit.hrm.domain.Dept;
/*    */ public class DeptDynaSqlProvider
/*    */ {
/*    */   public String selectWhitParam(final Map<String, Object> params) {
/* 18 */     String sql = (new SQL(){
/*    */   {
/*    */  SELECT("*");
/* 21 */     FROM("dept_inf");
/* 22 */     if (params.get("dept") != null) {
/* 23 */       Dept dept = (Dept)params.get("dept");
/* 24 */       if (dept.getName() != null && !dept.getName().equals("")){
/* 25 */         WHERE("  name LIKE CONCAT ('%',#{dept.name},'%') "); 
/*    */     } 
			}}}).toString();
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
/*    */  {
	/* 41 */     SELECT("count(*)");
	/* 42 */     FROM("dept_inf");
	/* 43 */     if (params.get("dept") != null) {
	/* 44 */       Dept dept = (Dept)params.get("dept");
	/* 45 */       if (dept.getName() != null && !dept.getName().equals("")){
	/* 46 */         WHERE("  name LIKE CONCAT ('%',#{dept.name},'%') "); 
	/*    */      } 
	/*    */   }
/*    */ }
/* 50 */       }).toString(); 
}
/*    */ 

/* 55 */   public String insertDept(final Dept dept) { return (new SQL()
/*    */       {
/*    */    {
		/* 57 */     INSERT_INTO("dept_inf");
		/* 58 */     if (dept.getName() != null && !dept.getName().equals("")) {
		/* 59 */       VALUES("name", "#{name}");
		/*    */     }
		/* 61 */     if (dept.getRemark() != null && !dept.getRemark().equals("")){
		/* 62 */       VALUES("remark", "#{remark}"); 
		/*    */   }
/*    */ 		}
/* 65 */       }).toString(); 
	}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 70 */   public String updateDept(final Dept dept) { 
			return (new SQL()  {
				 {
					 
					      UPDATE("dept_inf");
					      if (dept.getName() != null) {
					        SET(" name = #{name} ");
					    }
					      if (dept.getRemark() != null) {
					        SET(" remark = #{remark} ");
					      }
					      WHERE(" id = #{id} ");
				 }
/* 81 */       }).toString(); }
/*    */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\dao\provider\DeptDynaSqlProvider.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */