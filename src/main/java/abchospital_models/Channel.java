package abchospital_models;

public class Channel {
	
	private int id;
	private String datetime;
	private String Doctor;
	private String section;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getDoctor() {
		return Doctor;
	}
	public void setDoctor(String doctor) {
		Doctor = doctor;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	@Override
	public String toString() {
		return "Channel [id=" + id + ", datetime=" + datetime + ", Doctor=" + Doctor + ", section=" + section + "]";
	}
	
	

}
