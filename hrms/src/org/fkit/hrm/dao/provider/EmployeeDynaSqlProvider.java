/*     */ package org.fkit.hrm.dao.provider;
/*     */ 
/*     */ import java.util.Map;
/*     */ import org.apache.ibatis.jdbc.SQL;
/*     */ import org.fkit.hrm.domain.Employee;

/*     */ 
/*     */ public class EmployeeDynaSqlProvider
/*     */ {
/*     */   public String selectWhitParam(final Map<String, Object> params) {
/*  20 */     String sql = (new SQL()
/*     */       {
/*     */ {
	/* 22 */     SELECT("*");
	/* 23 */     FROM("employee_inf");
	/* 24 */     if (params.get("employee") != null) {
	/* 25 */       Employee employee = (Employee)params.get("employee");
	/* 26 */       if (employee.getDept() != null && employee.getDept().getId() != null && employee.getDept().getId().intValue() != 0) {
	/* 27 */         WHERE(" DEPT_ID = #{employee.dept.id} ");
	/*    */       }
	/* 29 */       if (employee.getJob() != null && employee.getJob().getId() != null && employee.getJob().getId().intValue() != 0) {
	/* 30 */         WHERE(" JOB_ID = #{employee.job.id} ");
	/*    */       }
	 			   if(employee.getSal()!=null && employee.getSal().getId()!=null && employee.getSal().getId().intValue()!=0)
	 			   {
	 				   WHERE("SAL_ID=#{employee.sal.id}");
	 			   }
	/* 32 */       if (employee.getName() != null && !employee.getName().equals("")) {
	/* 33 */         WHERE("  NAME LIKE CONCAT ('%',#{employee.name},'%') ");
	/*    */       }
	/* 35 */       if (employee.getPhone() != null && !employee.getPhone().equals("")) {
	/* 36 */         WHERE(" phone LIKE CONCAT ('%',#{employee.phone},'%') ");
	/*    */       }
	/* 38 */       if (employee.getCardId() != null && !employee.getCardId().equals("")) {
	/* 39 */         WHERE(" card_id LIKE CONCAT ('%',#{employee.cardId},'%') ");
	/*    */       }
	/* 41 */       if (employee.getSex() != null && employee.getSex().intValue() != 0)
	/* 42 */         WHERE("sex = #{employee.sex}"); 
	/*    */     } 
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
/*     */   
/*  56 */   public String count(final Map<String, Object> params) { 
			return (new SQL()
/*     */       {
/*     */ {
	/* 58 */     SELECT("count(*)");
	/* 59 */     FROM("employee_inf");
	/* 60 */     if (params.get("employee") != null) {
	/* 61 */       Employee employee = (Employee)params.get("employee");
	/* 62 */       if (employee.getDept() != null && employee.getDept().getId() != null && employee.getDept().getId().intValue() != 0) {
	/* 63 */         WHERE(" DEPT_ID = #{employee.dept.id} ");
	/*    */       }
	/* 65 */       if (employee.getJob() != null && employee.getJob().getId() != null && employee.getJob().getId().intValue() != 0) {
	/* 66 */         WHERE(" JOB_ID = #{employee.job.id} ");
	/*    */       }
	  			  if(employee.getSal() !=null && employee.getSal().getId()!=null && employee.getSal().getId().intValue()!=0)
	  			  {
	  				  WHERE("SAL_ID=#{employee.sal.id}");
	  			  }
	/* 68 */       if (employee.getName() != null && !employee.getName().equals("")) {
	/* 69 */         WHERE("  NAME LIKE CONCAT ('%',#{employee.name},'%') ");
	/*    */       }
	/* 71 */       if (employee.getPhone() != null && !employee.getPhone().equals("")) {
	/* 72 */         WHERE(" phone LIKE CONCAT ('%',#{employee.phone},'%') ");
	/*    */       }
	/* 74 */       if (employee.getCardId() != null && !employee.getCardId().equals("")) {
	/* 75 */         WHERE(" card_id LIKE CONCAT ('%',#{employee.cardId},'%') ");
	/*    */       }
	/* 77 */       if (employee.getSex() != null && employee.getSex().intValue() != 0){
	/* 78 */         WHERE("sex = #{employee.sex}"); 
	/*    */     } 
	/*    */   }
	/*    */ }
/*  82 */   }).toString(); }
/*     */ 
/*     */ 
/*     */   
/*  88 */   public String insertEmployee(final Employee employee) { 
				return (new SQL()
/*     */       {
/*     */  {
	/*  90 */     INSERT_INTO("employee_inf");
	/*  91 */     if (employee.getName() != null) {
	/*  92 */       VALUES("name", "#{name}");
	/*     */     }
	/*  94 */     if (employee.getCardId() != null) {
	/*  95 */       VALUES("card_id", "#{cardId}");
	/*     */     }
	/*  97 */     if (employee.getAddress() != null) {
	/*  98 */       VALUES("address", "#{address}");
	/*     */     }
	/* 100 */     if (employee.getPostCode() != null) {
	/* 101 */       VALUES("post_code", "#{postCode}");
	/*     */     }
	/* 103 */     if (employee.getTel() != null) {
	/* 104 */       VALUES("tel", "#{tel}");
	/*     */     }
	/* 106 */     if (employee.getPhone() != null) {
	/* 107 */       VALUES("phone", "#{phone}");
	/*     */     }
	/* 109 */     if (employee.getQqNum() != null) {
	/* 110 */       VALUES("qq_num", "#{qqNum}");
	/*     */     }
	/* 112 */     if (employee.getEmail() != null) {
	/* 113 */       VALUES("email", "#{email}");
	/*     */     }
	/* 115 */     if (employee.getSex() != null) {
	/* 116 */       VALUES("sex", "#{sex}");
	/*     */     }
	/* 118 */     if (employee.getParty() != null) {
	/* 119 */       VALUES("party", "#{party}");
	/*     */     }
	/* 121 */     if (employee.getBirthday() != null) {
	/* 122 */       VALUES("birthday", "#{birthday}");
	/*     */     }
	/* 124 */     if (employee.getRace() != null) {
	/* 125 */       VALUES("race", "#{race}");
	/*     */     }
	/* 127 */     if (employee.getEducation() != null) {
	/* 128 */       VALUES("education", "#{education}");
	/*     */     }
	/* 130 */     if (employee.getSpeciality() != null) {
	/* 131 */       VALUES("speciality", "#{speciality}");
	/*     */     }
	/* 133 */     if (employee.getHobby() != null) {
	/* 134 */       VALUES("hobby", "#{hobby}");
	/*     */     }
	/* 136 */     if (employee.getRemark() != null) {
	/* 137 */       VALUES("remark", "#{remark}");
	/*     */     }
	/* 139 */     if (employee.getCreateDate() != null) {
	/* 140 */       VALUES("create_Date", "#{createDate}");
	/*     */     }
	/* 142 */     if (employee.getDept() != null) {
	/* 143 */       VALUES("dept_id", "#{dept.id}");
	/*     */     }
	/* 145 */     if (employee.getJob() != null){
	/* 146 */       VALUES("job_id", "#{job.id}"); 
	/*     */   }
				if(employee.getSal()!=null)
				{
					VALUES("sal_id","#{sal.id}");
				}
	/*     */ }
/*     */       
/* 149 */       }).toString(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 154 */   public String updateEmployee(final Employee employee) { return (new SQL()
/*     */       {
/*     */ {
	/* 156 */     UPDATE("employee_inf");
	/* 157 */     if (employee.getName() != null) {
	/* 158 */       SET(" name = #{name} ");
	/*     */     }
	/* 160 */     if (employee.getCardId() != null) {
	/* 161 */       SET(" card_id = #{cardId} ");
	/*     */     }
	/* 163 */     if (employee.getAddress() != null) {
	/* 164 */       SET(" address = #{address} ");
	/*     */     }
	/* 166 */     if (employee.getPostCode() != null) {
	/* 167 */       SET(" post_code = #{postCode} ");
	/*     */     }
	/* 169 */     if (employee.getTel() != null) {
	/* 170 */       SET(" tel = #{tel} ");
	/*     */     }
	/* 172 */     if (employee.getPhone() != null) {
	/* 173 */       SET(" phone = #{phone} ");
	/*     */     }
	/* 175 */     if (employee.getQqNum() != null) {
	/* 176 */       SET(" qq_num = #{qqNum} ");
	/*     */     }
	/* 178 */     if (employee.getEmail() != null) {
	/* 179 */       SET(" email = #{email} ");
	/*     */     }
	/* 181 */     if (employee.getSex() != null) {
	/* 182 */       SET(" sex = #{sex} ");
	/*     */     }
	/* 184 */     if (employee.getParty() != null) {
	/* 185 */       SET(" party = #{party} ");
	/*     */     }
	/* 187 */     if (employee.getBirthday() != null) {
	/* 188 */       SET(" birthday = #{birthday} ");
	/*     */     }
	/* 190 */     if (employee.getRace() != null) {
	/* 191 */       SET(" race = #{race} ");
	/*     */     }
	/* 193 */     if (employee.getEducation() != null) {
	/* 194 */       SET(" education = #{education} ");
	/*     */     }
	/* 196 */     if (employee.getSpeciality() != null) {
	/* 197 */       SET(" speciality = #{speciality} ");
	/*     */     }
	/* 199 */     if (employee.getHobby() != null) {
	/* 200 */       SET(" hobby = #{hobby} ");
	/*     */     }
	/* 202 */     if (employee.getRemark() != null) {
	/* 203 */       SET(" remark = #{remark} ");
	/*     */     }
	/* 205 */     if (employee.getCreateDate() != null) {
	/* 206 */       SET(" create_Date = #{createDate} ");
	/*     */     }
	/* 208 */     if (employee.getDept() != null) {
	/* 209 */       SET(" dept_id = #{dept.id} ");
	/*     */     }
	/* 211 */     if (employee.getJob() != null) {
	/* 212 */       SET(" job_id = #{job.id} ");
	/*     */     }
				if(employee.getSal()!=null)
				{
					SET("sal_id=#{sal.id}");
				}
	/* 214 */     WHERE(" id = #{id} ");
	/*     */   }
/* 216 */       }).toString(); }
/*     */ }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\dao\provider\EmployeeDynaSqlProvider.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */