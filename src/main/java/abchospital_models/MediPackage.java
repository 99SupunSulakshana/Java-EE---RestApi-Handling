package abchospital_models;

public class MediPackage {
	
	private int id;
	private String pkgName;
	private String Desc;
	private double price;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPkgName() {
		return pkgName;
	}
	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "MediPackage [id=" + id + ", pkgName=" + pkgName + ", Desc=" + Desc + ", price=" + price + "]";
	}
	
	

}
