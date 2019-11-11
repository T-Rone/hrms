package org.fkit.hrm.service;

import java.util.List;
import org.fkit.hrm.domain.Dept;
import org.fkit.hrm.domain.Document;
import org.fkit.hrm.domain.Employee;
import org.fkit.hrm.domain.Job;
import org.fkit.hrm.domain.Notice;
import org.fkit.hrm.domain.User;
import org.fkit.hrm.domain.Sal;
import org.fkit.hrm.util.tag.PageModel;

public interface HrmService {
  User login(String paramString1, String paramString2);
  
  User findUserById(Integer paramInteger);
  
  List<User> findUser(User paramUser, PageModel paramPageModel);
  
  void removeUserById(Integer paramInteger);
  
  void modifyUser(User paramUser);
  
  void addUser(User paramUser);
  
  List<Employee> findEmployee(Employee paramEmployee, PageModel paramPageModel);
  
  void removeEmployeeById(Integer paramInteger);
  
  Employee findEmployeeById(Integer paramInteger);
  
  void addEmployee(Employee paramEmployee);
  
  void modifyEmployee(Employee paramEmployee);
  
  List<Dept> findDept(Dept paramDept, PageModel paramPageModel);
  
  List<Dept> findAllDept();
  
  void removeDeptById(Integer paramInteger);
  
  void addDept(Dept paramDept);
  
  Dept findDeptById(Integer paramInteger);
  
  void modifyDept(Dept paramDept);
  
  List<Job> findAllJob();
  
  List<Job> findJob(Job paramJob, PageModel paramPageModel);
  
  void removeJobById(Integer paramInteger);
  
  void addJob(Job paramJob);
  
  Job findJobById(Integer paramInteger);
  
  void modifyJob(Job paramJob);
  
  List<Notice> findNotice(Notice paramNotice, PageModel paramPageModel);
  
  Notice findNoticeById(Integer paramInteger);
  
  void removeNoticeById(Integer paramInteger);
  
  void addNotice(Notice paramNotice);
  
  void modifyNotice(Notice paramNotice);
  
  List<Document> findDocument(Document paramDocument, PageModel paramPageModel);
  
  void addDocument(Document paramDocument);
  
  Document findDocumentById(Integer paramInteger);
  
  void removeDocumentById(Integer paramInteger);
  
  void modifyDocument(Document paramDocument);
  
  
  
  
 List<Sal> findSal(Sal paramSal, PageModel paramPageModel);
  
  void removeSalById(Integer paramInteger);
  
  Sal findSalById(Integer paramInteger);
  
  void addSal(Sal paramSal);
  
  void modifySal(Sal paramSal);

List<Sal> findAllSal();
  
}


/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\service\HrmService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */