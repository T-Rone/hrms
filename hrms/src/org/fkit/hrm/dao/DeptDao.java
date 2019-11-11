package org.fkit.hrm.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.fkit.hrm.domain.Dept;

public interface DeptDao {
  @SelectProvider(type = org.fkit.hrm.dao.provider.DeptDynaSqlProvider.class, method = "selectWhitParam")
  List<Dept> selectByPage(Map<String, Object> paramMap);
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.DeptDynaSqlProvider.class, method = "count")
  Integer count(Map<String, Object> paramMap);
  
  @Select({"select * from dept_inf "})
  List<Dept> selectAllDept();
  
  @Select({"select * from dept_inf where ID = #{id}"})
  Dept selectById(int paramInt);
  
  @Delete({" delete from dept_inf where id = #{id} "})
  void deleteById(Integer paramInteger);
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.DeptDynaSqlProvider.class, method = "insertDept")
  void save(Dept paramDept);
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.DeptDynaSqlProvider.class, method = "updateDept")
  void update(Dept paramDept);
}


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\dao\DeptDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */