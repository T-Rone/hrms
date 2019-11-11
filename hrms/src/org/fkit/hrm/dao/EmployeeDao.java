package org.fkit.hrm.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.fkit.hrm.domain.Employee;

public interface EmployeeDao {
  @SelectProvider(type = org.fkit.hrm.dao.provider.EmployeeDynaSqlProvider.class, method = "count")
  Integer count(Map<String, Object> paramMap);
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.EmployeeDynaSqlProvider.class, method = "selectWhitParam")
  @Results({@Result(id = true, column = "id", property = "id"), @Result(column = "CARD_ID", property = "cardId"), @Result(column = "POST_CODE", property = "postCode"), @Result(column = "QQ_NUM", property = "qqNum"), @Result(column = "BIRTHDAY", property = "birthday", javaType = java.util.Date.class), @Result(column = "CREATE_DATE", property = "createDate", javaType = java.util.Date.class), @Result(column = "DEPT_ID", property = "dept", one = @One(select = "org.fkit.hrm.dao.DeptDao.selectById", fetchType = FetchType.EAGER)), @Result(column = "JOB_ID", property = "job", one = @One(select = "org.fkit.hrm.dao.JobDao.selectById", fetchType = FetchType.EAGER)),@Result(column="SAL_ID",property="sal",one=@One(select="org.fkit.hrm.dao.SalDao.selectById",fetchType=FetchType.EAGER))})
  List<Employee> selectByPage(Map<String, Object> paramMap);
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.EmployeeDynaSqlProvider.class, method = "insertEmployee")
  void save(Employee paramEmployee);
  
  @Delete({" delete from employee_inf where id = #{id} "})
  void deleteById(Integer paramInteger);
  
  @Select({"select * from employee_inf where ID = #{id}"})
  @Results({@Result(id = true, column = "id", property = "id"), @Result(column = "CARD_ID", property = "cardId"), @Result(column = "POST_CODE", property = "postCode"), @Result(column = "QQ_NUM", property = "qqNum"), @Result(column = "BIRTHDAY", property = "birthday", javaType = java.util.Date.class), @Result(column = "CREATE_DATE", property = "createDate", javaType = java.util.Date.class), @Result(column = "DEPT_ID", property = "dept", one = @One(select = "org.fkit.hrm.dao.DeptDao.selectById", fetchType = FetchType.EAGER)), @Result(column = "JOB_ID", property = "job", one = @One(select = "org.fkit.hrm.dao.JobDao.selectById", fetchType = FetchType.EAGER)),@Result(column="SAL_ID",property="sal",one=@One(select="org.fkit.hrm.dao.SalDao.selectById",fetchType=FetchType.EAGER))})
  Employee selectById(Integer paramInteger);
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.EmployeeDynaSqlProvider.class, method = "updateEmployee")
  void update(Employee paramEmployee);
}


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\dao\EmployeeDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */