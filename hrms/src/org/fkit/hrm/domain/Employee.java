/*     */ package org.fkit.hrm.domain;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import org.springframework.format.annotation.DateTimeFormat;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Employee
/*     */   implements Serializable
/*     */ {
/*     */   private Integer id;
/*     */   private Dept dept;
/*     */   private Job job;
			private Sal sal;
/*     */   private String name;
/*     */   private String cardId;
/*     */   private String address;
/*     */   private String postCode;
/*     */   private String tel;
/*     */   private String phone;
/*     */   private String qqNum;
/*     */   private String email;
/*     */   private Integer sex;
/*     */   private String party;
/*     */   @DateTimeFormat(pattern = "yyyy-MM-dd")
/*     */   private Date birthday;
/*     */   private String race;
/*     */   private String education;
/*     */   private String speciality;
/*     */   private String hobby;
/*     */   private String remark;
/*     */   private Date createDate;
/*     */   
/*  40 */   public void setId(Integer id) { this.id = id; }
/*     */ 
/*     */   
/*  43 */   public Integer getId() { return this.id; }
/*     */ 
/*     */   public Sal getSal() {return sal;}
			public void setSal(Sal sal) { this.sal = sal;}
/*     */   
/*  47 */   public Dept getDept() { return this.dept; }
/*     */ 
/*     */   
/*  50 */   public void setDept(Dept dept) { this.dept = dept; }
/*     */ 
/*     */   
/*  53 */   public Job getJob() { return this.job; }
/*     */ 
/*     */   
/*  56 */   public void setJob(Job job) { this.job = job; }
/*     */ 
/*     */   
/*  59 */   public void setName(String name) { this.name = name; }
/*     */ 
/*     */   
/*  62 */   public String getName() { return this.name; }
/*     */ 
/*     */   
/*  65 */   public void setCardId(String cardId) { this.cardId = cardId; }
/*     */ 
/*     */   
/*  68 */   public String getCardId() { return this.cardId; }
/*     */ 
/*     */   
/*  71 */   public void setAddress(String address) { this.address = address; }
/*     */ 
/*     */   
/*  74 */   public String getAddress() { return this.address; }
/*     */ 
/*     */   
/*  77 */   public void setPostCode(String postCode) { this.postCode = postCode; }
/*     */ 
/*     */   
/*  80 */   public String getPostCode() { return this.postCode; }
/*     */ 
/*     */   
/*  83 */   public void setTel(String tel) { this.tel = tel; }
/*     */ 
/*     */   
/*  86 */   public String getTel() { return this.tel; }
/*     */ 
/*     */   
/*  89 */   public void setPhone(String phone) { this.phone = phone; }
/*     */ 
/*     */   
/*  92 */   public String getPhone() { return this.phone; }
/*     */ 
/*     */   
/*  95 */   public void setQqNum(String qqNum) { this.qqNum = qqNum; }
/*     */ 
/*     */   
/*  98 */   public String getQqNum() { return this.qqNum; }
/*     */ 
/*     */   
/* 101 */   public void setEmail(String email) { this.email = email; }
/*     */ 
/*     */   
/* 104 */   public String getEmail() { return this.email; }
/*     */ 
/*     */   
/* 107 */   public void setSex(Integer sex) { this.sex = sex; }
/*     */ 
/*     */   
/* 110 */   public Integer getSex() { return this.sex; }
/*     */ 
/*     */   
/* 113 */   public void setParty(String party) { this.party = party; }
/*     */ 
/*     */   
/* 116 */   public String getParty() { return this.party; }
/*     */ 
/*     */   
/* 119 */   public void setBirthday(Date birthday) { this.birthday = birthday; }
/*     */ 
/*     */   
/* 122 */   public Date getBirthday() { return this.birthday; }
/*     */ 
/*     */   
/* 125 */   public void setRace(String race) { this.race = race; }
/*     */ 
/*     */   
/* 128 */   public String getRace() { return this.race; }
/*     */ 
/*     */   
/* 131 */   public void setEducation(String education) { this.education = education; }
/*     */ 
/*     */   
/* 134 */   public String getEducation() { return this.education; }
/*     */ 
/*     */   
/* 137 */   public void setSpeciality(String speciality) { this.speciality = speciality; }
/*     */ 
/*     */   
/* 140 */   public String getSpeciality() { return this.speciality; }
/*     */ 
/*     */   
/* 143 */   public void setHobby(String hobby) { this.hobby = hobby; }
/*     */ 
/*     */   
/* 146 */   public String getHobby() { return this.hobby; }
/*     */ 
/*     */   
/* 149 */   public void setRemark(String remark) { this.remark = remark; }
/*     */ 
/*     */   
/* 152 */   public String getRemark() { return this.remark; }
/*     */ 
/*     */   
/* 155 */   public void setCreateDate(Date createDate) { this.createDate = createDate; }
/*     */ 
/*     */   
/* 158 */   public Date getCreateDate() { return this.createDate; }
/*     */ 
/*     */   
/*     */
	@Override
	public String toString() {
	return "Employee [id=" + id + ", dept=" + dept + ", job=" + job + ", sal="
			+ sal + ", name=" + name + ", cardId=" + cardId + ", address="
			+ address + ", postCode=" + postCode + ", tel=" + tel + ", phone="
			+ phone + ", qqNum=" + qqNum + ", email=" + email + ", sex=" + sex
			+ ", party=" + party + ", birthday=" + birthday + ", race=" + race
			+ ", education=" + education + ", speciality=" + speciality
			+ ", hobby=" + hobby + ", remark=" + remark + ", createDate="
			+ createDate + "]";
}

}

/* Location:              D:\apache-tomcat-8.5.45\webapps\hrms\WEB-INF\classes\!\org\fkit\hrm\domain\Employee.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.0.7
 */