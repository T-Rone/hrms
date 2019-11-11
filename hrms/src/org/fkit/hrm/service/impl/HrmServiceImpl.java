package org.fkit.hrm.service.impl;

/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.fkit.hrm.dao.DeptDao;
/*     */ import org.fkit.hrm.dao.DocumentDao;
/*     */ import org.fkit.hrm.dao.EmployeeDao;
/*     */ import org.fkit.hrm.dao.JobDao;
/*     */ import org.fkit.hrm.dao.NoticeDao;
/*     */ import org.fkit.hrm.dao.UserDao;
import  org.fkit.hrm.dao.SalDao;
/*     */ import org.fkit.hrm.domain.Dept;
/*     */ import org.fkit.hrm.domain.Document;
/*     */ import org.fkit.hrm.domain.Employee;
/*     */ import org.fkit.hrm.domain.Job;
/*     */ import org.fkit.hrm.domain.Notice;
import org.fkit.hrm.domain.Sal;
/*     */ import org.fkit.hrm.domain.User;
/*     */ import org.fkit.hrm.service.HrmService;
/*     */ import org.fkit.hrm.util.tag.PageModel;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Isolation;
/*     */ import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*     */ @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
/*     */ @Service("hrmService")
/*     */ public class HrmServiceImpl
/*     */   implements HrmService
/*     */ {
/*     */   @Autowired
/*     */   private UserDao userDao;
/*     */   @Autowired
/*     */   private DeptDao deptDao;
/*     */   @Autowired
/*     */   private EmployeeDao employeeDao;
/*     */   @Autowired
/*     */   private JobDao jobDao;
/*     */   @Autowired
/*     */   private NoticeDao noticeDao;
/*     */   @Autowired
/*     */   private DocumentDao documentDao;
/*     */   @Autowired
/*     */   private SalDao salDao;

/*     */   @Transactional(readOnly = true)
/*  67 */   public User login(String loginname, String password) { return this.userDao.selectByLoginnameAndPassword(loginname, password); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<User> findUser(User user, PageModel pageModel) {
/*  78 */     Map<String, Object> params = new HashMap<String, Object>();
/*  79 */     params.put("user", user);
/*  80 */     int recordCount = this.userDao.count(params).intValue();
/*  81 */     pageModel.setRecordCount(recordCount);
/*  82 */     if (recordCount > 0)
/*     */     {
/*  84 */       params.put("pageModel", pageModel);
/*     */     }
/*  86 */     return this.userDao.selectByPage(params);
/*     */   }
/*     */ 
/*     */ 

/*     */   
/*     */   @Transactional(readOnly = true)
/*  98 */   public User findUserById(Integer id) { return this.userDao.selectById(id); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   public void removeUserById(Integer id) { this.userDao.deleteById(id); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 117 */   public void modifyUser(User user) { this.userDao.update(user); }
/*     */ 

/*     */ 
/*     */ 
/*     */   
/* 127 */   public void addUser(User user) { this.userDao.save(user); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/* 136 */   public List<Dept> findAllDept() { return this.deptDao.selectAllDept(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<Dept> findDept(Dept dept, PageModel pageModel) {
/* 147 */     Map<String, Object> params = new HashMap<String, Object>();
/* 148 */     params.put("dept", dept);
/* 149 */     int recordCount = this.deptDao.count(params).intValue();
/* 150 */     pageModel.setRecordCount(recordCount);
/*     */     
/* 152 */     if (recordCount > 0)
/*     */     {
/* 154 */       params.put("pageModel", pageModel);
/*     */     }
/*     */     
/* 157 */     return this.deptDao.selectByPage(params);
/*     */   }
/*     */ 
/*     */ 

/*     */   
/* 168 */   public void removeDeptById(Integer id) { this.deptDao.deleteById(id); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 178 */   public void addDept(Dept dept) { this.deptDao.save(dept); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 189 */   public Dept findDeptById(Integer id) { return this.deptDao.selectById(id.intValue()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 198 */   public void modifyDept(Dept dept) { this.deptDao.update(dept); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<Employee> findEmployee(Employee employee, PageModel pageModel) {
/* 210 */     Map<String, Object> params = new HashMap<String, Object>();
/* 211 */     params.put("employee", employee);
/*     */     
/* 213 */     int recordCount = this.employeeDao.count(params).intValue();
/* 214 */     pageModel.setRecordCount(recordCount);
/*     */     
/* 216 */     if (recordCount > 0)
/*     */     {
/* 218 */       params.put("pageModel", pageModel);
/*     */     }
/* 220 */     return this.employeeDao.selectByPage(params);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 229 */   public void removeEmployeeById(Integer id) { this.employeeDao.deleteById(id); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/* 240 */   public Employee findEmployeeById(Integer id) { return this.employeeDao.selectById(id); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 249 */   public void addEmployee(Employee employee) { this.employeeDao.save(employee); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 259 */   public void modifyEmployee(Employee employee) { this.employeeDao.update(employee); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/* 272 */   public List<Job> findAllJob() { return this.jobDao.selectAllJob(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<Job> findJob(Job job, PageModel pageModel) {
/* 283 */     Map<String, Object> params = new HashMap<String, Object>();
/* 284 */     params.put("job", job);
/* 285 */     int recordCount = this.jobDao.count(params).intValue();
/* 286 */     pageModel.setRecordCount(recordCount);
/*     */     
/* 288 */     if (recordCount > 0)
/*     */     {
/* 290 */       params.put("pageModel", pageModel);
/*     */     }
/*     */     
/* 293 */     return this.jobDao.selectByPage(params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 304 */   public void removeJobById(Integer id) { this.jobDao.deleteById(id); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 314 */   public void addJob(Job job) { this.jobDao.save(job); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/* 326 */   public Job findJobById(Integer id) { return this.jobDao.selectById(id.intValue()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 335 */   public void modifyJob(Job job) { this.jobDao.update(job); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<Notice> findNotice(Notice notice, PageModel pageModel) {
/* 344 */     Map<String, Object> params = new HashMap<String, Object>();
/* 345 */     params.put("notice", notice);
/* 346 */     int recordCount = this.noticeDao.count(params).intValue();
/* 347 */     pageModel.setRecordCount(recordCount);
/*     */     
/* 349 */     if (recordCount > 0)
/*     */     {
/* 351 */       params.put("pageModel", pageModel);
/*     */     }
/*     */     
/* 354 */     return this.noticeDao.selectByPage(params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/* 367 */   public Notice findNoticeById(Integer id) { return this.noticeDao.selectById(id.intValue()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 376 */   public void removeNoticeById(Integer id) { this.noticeDao.deleteById(id); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 386 */   public void addNotice(Notice notice) { this.noticeDao.save(notice); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 396 */   public void modifyNotice(Notice notice) { this.noticeDao.update(notice); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/*     */   public List<Document> findDocument(Document document, PageModel pageModel) {
/* 410 */     Map<String, Object> params = new HashMap<String, Object>();
/* 411 */     params.put("document", document);
/* 412 */     int recordCount = this.documentDao.count(params).intValue();
/* 413 */     pageModel.setRecordCount(recordCount);
/*     */     
/* 415 */     if (recordCount > 0)
/*     */     {
/* 417 */       params.put("pageModel", pageModel);
/*     */     }
/*     */     
/* 420 */     return this.documentDao.selectByPage(params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 431 */   public void addDocument(Document document) { this.documentDao.save(document); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 440 */   public void removeDocumentById(Integer id) { this.documentDao.deleteById(id); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 449 */   public void modifyDocument(Document document) { this.documentDao.update(document); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional(readOnly = true)
/* 460 */   public Document findDocumentById(Integer id) { return this.documentDao.selectById(id.intValue()); }
/*     */

public List<Sal> findSal(Sal sal, PageModel pageModel) {
	// TODO Auto-generated method stub
	 Map<String, Object> params = new HashMap<String, Object>();
	 /* 211 */     params.put("sal",sal);
	 /*     */     
	 /* 213 */     int recordCount = this.salDao.count(params).intValue();
	 /* 214 */     pageModel.setRecordCount(recordCount);
	 /*     */     
	 /* 216 */     if (recordCount > 0)
	 /*     */     {
	 /* 218 */       params.put("pageModel", pageModel);
	 /*     */     }
	 /* 220 */     return this.salDao.selectByPage(params);
}
public void removeSalById(Integer id) {
	// TODO Auto-generated method stub
	this.salDao.deleteById(id);
}
public Sal findSalById(Integer id) {
	// TODO Auto-generated method stub
  return	this.salDao.selectById(id.intValue());
}
public void addSal(Sal sal) {
	// TODO Auto-generated method stub
	this.salDao.save(sal);
}
public void modifySal(Sal sal) {
	// TODO Auto-generated method stub
	this.salDao.update(sal);
}
public List<Sal> findAllSal() {
	// TODO Auto-generated method stub
	
	return this.salDao.selectAllSal();
} }


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\service\impl\HrmServiceImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */