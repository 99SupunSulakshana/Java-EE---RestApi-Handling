package abchospital_models;

public class Change {
	
	private int id;
	private String branch;
	private String pName;
	private String reason;
	private String condition;
	private String finalTreat;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getFinalTreat() {
		return finalTreat;
	}
	public void setFinalTreat(String finalTreat) {
		this.finalTreat = finalTreat;
	}
	@Override
	public String toString() {
		return "Change [id=" + id + ", branch=" + branch + ", pName=" + pName + ", reason=" + reason + ", condition="
				+ condition + ", finalTreat=" + finalTreat + "]";
	}
	
	

}
