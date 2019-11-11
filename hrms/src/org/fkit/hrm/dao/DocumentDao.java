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
import org.fkit.hrm.domain.Document;

public interface DocumentDao {
  @SelectProvider(type = org.fkit.hrm.dao.provider.DocumentDynaSqlProvider.class, method = "selectWhitParam")
  @Results({@Result(id = true, column = "id", property = "id"), @Result(column = "CREATE_DATE", property = "createDate", javaType = java.util.Date.class), @Result(column = "USER_ID", property = "user", one = @One(select = "org.fkit.hrm.dao.UserDao.selectById", fetchType = FetchType.EAGER))})
  List<Document> selectByPage(Map<String, Object> paramMap);
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.DocumentDynaSqlProvider.class, method = "count")
  Integer count(Map<String, Object> paramMap);
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.DocumentDynaSqlProvider.class, method = "insertDocument")
  void save(Document paramDocument);
  
  @Select({"select * from document_inf where ID = #{id}"})
  Document selectById(int paramInt);
  
  @Delete({" delete from document_inf where id = #{id} "})
  void deleteById(Integer paramInteger);
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.DocumentDynaSqlProvider.class, method = "updateDocument")
  void update(Document paramDocument);
}


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\dao\DocumentDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */