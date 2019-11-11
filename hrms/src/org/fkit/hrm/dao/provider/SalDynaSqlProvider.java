package org.fkit.hrm.dao.provider;

		  import java.util.Map;
/*     */ import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Sal;

public class SalDynaSqlProvider {
	
	   public String selectWhitParam(final Map<String, Object> params) {
		/*  20 */     String sql = (new SQL()
		/*     */       {
		/*     */ {
			/* 22 */     SELECT("*");
			/* 23 */     FROM("salary_inf");
			/* 24 */     if (params.get("sal") != null) {
			/* 25 */      Sal sal = (Sal)params.get("sal");
			/* 26 */       if (sal.getMonth() != null && !sal.getMonth().equals("")) {
			/* 之前表单是text类型 所以这么匹配 */         WHERE("MONTH LIKE CONCAT ('%',#{sal.month},'%') ");
		        }			
			 				
						} 
			/*    */   }
		/*  46 */       }).toString();
		/*     */     
		/*  48 */     if (params.get("pageModel") != null) {
		/*  49 */       sql = String.valueOf(sql) + " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		/*     */     }
		/*     */     
		/*  52 */     return sql;
		/*     */   }
		/*     */ 
	   public String count(final Map<String, Object> params) { 
			return (new SQL()
/*     */       {
/*     */ {
  			SELECT("count(*)");
  			FROM("salary_inf");
  		   if (params.get("sal") != null) {
  				/* 25 */      Sal sal = (Sal)params.get("sal");
  				/* 26 */       if (sal.getMonth() != null && !sal.getMonth().equals("")) {
  				/* 27 */         WHERE("MONTH= #{sal.month} ");
  				/* 	if (sal.getMonth() != null && !sal.getMonth().equals("") && sal.getId().intValue()!=0) {
  				 				 WHERE("ID=#{sal.month.id}");
  						      }   */       }
  				 			
  							}
 }
/*  82 */   }).toString(); 
			}
/*     */ 
	   public String insertSal(final Sal sal) { 
			return (new SQL()
       {
		 {
			 INSERT_INTO("salary_inf");
			if (sal.getMonth() != null && !sal.getMonth().equals("")) {
				VALUES("MONTH","#{month}");
	    }
			 }
		      }).toString(); 
	}
	   
	   public String updateSal(final Sal sal) { 
		   return (new SQL()
	   /*     */       {
	   /*     */ {
	   	/* 156 */     UPDATE("salary_inf");
	   				if (sal.getMonth() != null) {
	    	/*接input值 158 */       SET(" MONTH = #{month} ");
	    	/*     */     }
	   				WHERE(" id= #{id} ");
	   }
	   /* 216 */       }).toString(); }
}
