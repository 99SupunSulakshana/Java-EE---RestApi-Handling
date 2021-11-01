package abchospital_models;

public class Appoinment {
	
	private int id;
	private String fullName;
	private String Gender;
	private int phone;
	private String bdy;
	private String address;
	private String email;
	private String AdmitCheck;
	private String condition;
	private String doctor;
	
	
	
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
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
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getBdy() {
		return bdy;
	}
	public void setBdy(String bdy) {
		this.bdy = bdy;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdmitCheck() {
		return AdmitCheck;
	}
	public void setAdmitCheck(String admitCheck) {
		AdmitCheck = admitCheck;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	@Override
	public String toString() {
		return "Appoinment [id=" + id + ", fullName=" + fullName + ", Gender=" + Gender + ", phone=" + phone + ", bdy="
				+ bdy + ", address=" + address + ", email=" + email + ", AdmitCheck=" + AdmitCheck + ", condition="
				+ condition + ", doctor=" + doctor + "]";
	}
	
	

}
