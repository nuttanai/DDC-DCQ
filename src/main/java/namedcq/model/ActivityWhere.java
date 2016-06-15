package namedcq.model;

public class ActivityWhere {
	Integer activityWhereID;
	String activityWhereName;
	String activityWhereOwner;
	Integer activityWhereOwnerId; 
	
	public ActivityWhere(Integer activityWhereID,String activityWhereName,
			String activityWhereOwner,Integer activityWhereOwnerId) {
		
		super();
		this.activityWhereID = activityWhereID;
		this.activityWhereName = activityWhereName;
		this.activityWhereOwner = activityWhereOwner;
		this.activityWhereOwnerId = activityWhereOwnerId;
		
		
	}
	public ActivityWhere(){
		
	}
	public Integer getActivityWhereID() {
		return activityWhereID;
	}
	public void setActivityWhereID(Integer activityWhereID) {
		this.activityWhereID = activityWhereID;
	}
	public String getActivityWhereName() {
		return activityWhereName;
	}
	public void setActivityWhereName(String activityWhereName) {
		this.activityWhereName = activityWhereName;
	}
	public String getActivityWhereOwner() {
		return activityWhereOwner;
	}
	public void setActivityWhereOwner(String activityWhereOwner) {
		this.activityWhereOwner = activityWhereOwner;
	}
	public Integer getActivityWhereOwnerId() {
		return activityWhereOwnerId;
	}
	public void setActivityWhereOwnerId(Integer activityWhereOwnerId) {
		this.activityWhereOwnerId = activityWhereOwnerId;
	}
	
	

}

