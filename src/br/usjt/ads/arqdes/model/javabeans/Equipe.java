package br.usjt.ads.arqdes.model.javabeans;

public class Equipe {
	private String credit_id;
	private String department;
	private int gender;
	private int id;
	private String job;
	private String name;
	private String profile_path;
	public String getCredit_id() {
		return credit_id;
	}
	public void setCredit_id(String credit_id) {
		this.credit_id = credit_id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfile_path() {
		return profile_path;
	}
	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}
	@Override
	public String toString() {
		return "Equipe [credit_id=" + credit_id + ", department=" + department + ", gender=" + gender + ", id=" + id
				+ ", job=" + job + ", name=" + name + ", profile_path=" + profile_path + "]";
	}
	
}
