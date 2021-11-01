package abchospital_models;

public class Medicine {
	
	private int id;
	private String mediName;
	private String mediCategory;
	private String mediDelivryDate;
	private int amount;
	private String mediCompany;
	private String mediManufact;
	private String mediExpire;
	private String mediNext;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMediName() {
		return mediName;
	}
	public void setMediName(String mediName) {
		this.mediName = mediName;
	}
	public String getMediCategory() {
		return mediCategory;
	}
	public void setMediCategory(String mediCategory) {
		this.mediCategory = mediCategory;
	}
	public String getMediDelivryDate() {
		return mediDelivryDate;
	}
	public void setMediDelivryDate(String mediDelivryDate) {
		this.mediDelivryDate = mediDelivryDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getMediCompany() {
		return mediCompany;
	}
	public void setMediCompany(String mediCompany) {
		this.mediCompany = mediCompany;
	}
	public String getMediManufact() {
		return mediManufact;
	}
	public void setMediManufact(String mediManufact) {
		this.mediManufact = mediManufact;
	}
	public String getMediExpire() {
		return mediExpire;
	}
	public void setMediExpire(String mediExpire) {
		this.mediExpire = mediExpire;
	}
	public String getMediNext() {
		return mediNext;
	}
	public void setMediNext(String mediNext) {
		this.mediNext = mediNext;
	}
	@Override
	public String toString() {
		return "Medicine [id=" + id + ", mediName=" + mediName + ", mediCategory=" + mediCategory + ", mediDelivryDate="
				+ mediDelivryDate + ", amount=" + amount + ", mediCompany=" + mediCompany + ", mediManufact="
				+ mediManufact + ", mediExpire=" + mediExpire + ", mediNext=" + mediNext + "]";
	}
	
	

}
