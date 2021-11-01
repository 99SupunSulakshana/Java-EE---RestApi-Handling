package abchospital_models;

public class Patient {
	
	private int id;
	private String fullName;
	private String nic;
	private String gender;
	private int mobile;
	private String bdy;
	private int age;
	private String address;
	private String AttendCheck;
	private String PatientGradian;
	private String EnterDate;
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
	public String getAttendCheck() {
		return AttendCheck;
	}
	public void setAttendCheck(String attendCheck) {
		AttendCheck = attendCheck;
	}
	public String getPatientGradian() {
		return PatientGradian;
	}
	public void setPatientGradian(String patientGradian) {
		PatientGradian = patientGradian;
	}
	public String getEnterDate() {
		return EnterDate;
	}
	public void setEnterDate(String enterDate) {
		EnterDate = enterDate;
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
		return "Patient [id=" + id + ", fullName=" + fullName + ", nic=" + nic + ", gender=" + gender + ", mobile="
				+ mobile + ", bdy=" + bdy + ", age=" + age + ", address=" + address + ", AttendCheck=" + AttendCheck
				+ ", PatientGradian=" + PatientGradian + ", EnterDate=" + EnterDate + ", wardName=" + wardName
				+ ", Doctor=" + Doctor + "]";
	}
	
	

}
