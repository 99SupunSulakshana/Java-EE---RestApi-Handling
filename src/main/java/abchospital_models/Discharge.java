package abchospital_models;

public class Discharge {
	
	private int id;
	private String fullName;
	private String nic;
	private String gender;
	private int mobile;
	private String bdy;
	private int age;
	private String address;
	private String PatientGradian;
	private String DischargeDate;
	private String condition;
	private String wardName;
	private String Doctor;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getBdy() {
		return bdy;
	}
	public void setBdy(String bdy) {
		this.bdy = bdy;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPatientGradian() {
		return PatientGradian;
	}
	public void setPatientGradian(String patientGradian) {
		PatientGradian = patientGradian;
	}
	public String getDischargeDate() {
		return DischargeDate;
	}
	public void setDischargeDate(String dischargeDate) {
		DischargeDate = dischargeDate;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getWardName() {
		return wardName;
	}
	public void setWardName(String wardName) {
		this.wardName = wardName;
	}
	public String getDoctor() {
		return Doctor;
	}
	public void setDoctor(String doctor) {
		Doctor = doctor;
	}
	@Override
	public String toString() {
		return "Discharge [id=" + id + ", fullName=" + fullName + ", nic=" + nic + ", gender=" + gender + ", mobile="
				+ mobile + ", bdy=" + bdy + ", age=" + age + ", address=" + address + ", PatientGradian="
				+ PatientGradian + ", DischargeDate=" + DischargeDate + ", condition=" + condition + ", wardName="
				+ wardName + ", Doctor=" + Doctor + "]";
	}
	
	

}
