package org.fkit.hrm.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.fkit.hrm.domain.Job;

public interface JobDao {
  @Select({"select * from job_inf where ID = #{id}"})
  Job selectById(int paramInt);
  
  @Select({"select * from job_inf "})
  List<Job> selectAllJob();
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.JobDynaSqlProvider.class, method = "selectWhitParam")
  List<Job> selectByPage(Map<String, Object> paramMap);
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.JobDynaSqlProvider.class, method = "count")
  Integer count(Map<String, Object> paramMap);
  
  @Delete({" delete from job_inf where id = #{id} "})
  void deleteById(Integer paramInteger);
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.JobDynaSqlProvider.class, method = "insertJob")
  void save(Job paramJob);
  
  @SelectProvider(type = org.fkit.hrm.dao.provider.JobDynaSqlProvider.class, method = "updateJob")
  void update(Job paramJob);
}


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\dao\JobDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */