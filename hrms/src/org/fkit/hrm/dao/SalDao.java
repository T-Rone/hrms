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
import org.fkit.hrm.domain.Sal;
public interface SalDao {
	  
	  @SelectProvider(type = org.fkit.hrm.dao.provider.SalDynaSqlProvider.class, method = "count")
	  Integer count(Map<String, Object> paramMap);
	  
	  @SelectProvider(type = org.fkit.hrm.dao.provider.SalDynaSqlProvider.class, method = "selectWhitParam")
	  List<Sal> selectByPage(Map<String, Object> paramMap);
	  
	  @SelectProvider(type = org.fkit.hrm.dao.provider.SalDynaSqlProvider.class, method = "insertSal")
	  void save(Sal paramSal);
	  
	  @Delete({"delete from salary_inf where id = #{id} "})
	  void deleteById(Integer paramInteger);
	  
	  @Select({"select * from salary_inf  where ID = #{id}"})
	  Sal selectById(int paramInt);
	  
	  @SelectProvider(type = org.fkit.hrm.dao.provider.SalDynaSqlProvider.class, method = "updateSal")
	  void update(Sal paramSal);

	  @Select({"select * from dept_inf "})
	  List<Sal> selectAllSal();
}
