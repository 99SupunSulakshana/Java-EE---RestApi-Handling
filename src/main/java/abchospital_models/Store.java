package abchospital_models;

public class Store {
	
	private int id;
	private String itemName;
	private int amount;
	private String Description;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	@Override
	public String toString() {
		return "Store [id=" + id + ", itemName=" + itemName + ", amount=" + amount + ", Description=" + Description
				+ "]";
	}
	
	

}
