package abchospital_models;

public class Ward {
	
	private int id;
	private String name;
	private int beds;
	private int rooms;
	private int nurses;
	private String head;
	private String section;
	private String SittingArea;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public int getNurses() {
		return nurses;
	}
	public void setNurses(int nurses) {
		this.nurses = nurses;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getSittingArea() {
		return SittingArea;
	}
	public void setSittingArea(String sittingArea) {
		SittingArea = sittingArea;
	}
	
	@Override
	public String toString() {
		return "Ward [id=" + id + ", name=" + name + ", beds=" + beds + ", rooms=" + rooms + ", nurses=" + nurses
				+ ", head=" + head + ", section=" + section + ", SittingArea=" + SittingArea + "]";
	}
	
	
	

}
