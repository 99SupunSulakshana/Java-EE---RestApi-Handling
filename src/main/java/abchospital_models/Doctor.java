package abchospital_models;

public class Doctor {
	
	private int id;
	private String nic;
	private String fullname;
	private String address;
	private String citizen;
	private String email;
	private int age;
	private int graduatedY;
	private String graduatedCampus;
	private int cetifyY;
	private String section;
	private String Category;
	private String ward;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCitizen() {
		return citizen;
	}
	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGraduatedY() {
		return graduatedY;
	}
	public void setGraduatedY(int graduatedY) {
		this.graduatedY = graduatedY;
	}
	public String getGraduatedCampus() {
		return graduatedCampus;
	}
	public void setGraduatedCampus(String graduatedCampus) {
		this.graduatedCampus = graduatedCampus;
	}
	public int getCetifyY() {
		return cetifyY;
	}
	public void setCetifyY(int cetifyY) {
		this.cetifyY = cetifyY;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", nic=" + nic + ", fullname=" + fullname + ", address=" + address + ", citizen="
				+ citizen + ", email=" + email + ", age=" + age + ", graduatedY=" + graduatedY + ", graduatedCampus="
				+ graduatedCampus + ", cetifyY=" + cetifyY + ", section=" + section + ", Category=" + Category
				+ ", ward=" + ward + "]";
	}
	
	
	

}
