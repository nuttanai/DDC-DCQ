package namedcq.model;

public class ActivityCall {

	Integer activityPhoneID;
	String activityNumber;
	Integer activityNumberOwnerID; 
	
	public ActivityCall(Integer activityPhoneID,String activityNumber,
			Integer activityNumberOwnerID) {
		
		super();
		this.activityPhoneID = activityPhoneID;
		this.activityNumber = activityNumber;
		this.activityNumberOwnerID = activityNumberOwnerID;

	}
	public ActivityCall(){
		
	}
	public Integer getActivityPhoneID() {
		return activityPhoneID;
	}
	public void setActivityPhoneID(Integer activityPhoneID) {
		this.activityPhoneID = activityPhoneID;
	}
	public String getActivityNumber() {
		return activityNumber;
	}
	public void setActivityNumber(String activityNumber) {
		this.activityNumber = activityNumber;
	}
	public Integer getActivityNumberOwnerID() {
		return activityNumberOwnerID;
	}
	public void setActivityNumberOwnerID(Integer activityNumberOwnerID) {
		this.activityNumberOwnerID = activityNumberOwnerID;
	}
	
	
	
}
