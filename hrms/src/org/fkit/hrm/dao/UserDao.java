package org.fkit.hrm.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.fkit.hrm.domain.User;

public interface UserDao {
  @Select({"select * from user_inf where loginname = #{loginname} and password = #{password}"})
  User selectByLoginnameAndPassword(@Param("loginname") String paramString1, @Param("password") String paramString2);
  
  @Select({"select * from user_inf where ID = #{id}"})
  User selectById(Integer paramInteger);
  
  @Delete({" delete from user_inf where id = #{id} "})
  void deleteById(Integer paramInteger);
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.UserDynaSqlProvider.class, method = "updateUser")
  void update(User paramUser);
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.UserDynaSqlProvider.class, method = "selectWhitParam")
  List<User> selectByPage(Map<String, Object> paramMap);
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.UserDynaSqlProvider.class, method = "count")
  Integer count(Map<String, Object> paramMap);
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.UserDynaSqlProvider.class, method = "insertUser")
  void save(User paramUser);
}


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\dao\UserDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */