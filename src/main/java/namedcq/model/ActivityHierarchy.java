package namedcq.model;

public class ActivityHierarchy {
		
	Integer activtyID;
	String activtyName;
	String activtyHierarchyOwner;
	Integer activtyHierarchyOwnerID;
	Integer activityHierarchyForDataMain;
	String activityAgency;
	

	public ActivityHierarchy(Integer activtyID,String activtyName,String activtyHierarchyOwner,Integer activtyHierarchyOwnerID,Integer activityHierarchyForDataMain,String activityAgency) {
		super();
		this.activtyID = activtyID;
		this.activtyName = activtyName ;
		this.activtyHierarchyOwner=activtyHierarchyOwner;
		this.activtyHierarchyOwnerID=activtyHierarchyOwnerID;
		this.activityHierarchyForDataMain=activityHierarchyForDataMain;
		this.activityAgency = activityAgency;
	}
	public ActivityHierarchy(){
		
	}
	
	public Integer getActivtyID() {
		return activtyID;
	}
	public void setActivtyID(Integer activtyID) {
		this.activtyID = activtyID;
	}
	public String getActivtyName() {
		return activtyName;
	}
	public void setActivtyName(String activtyName) {
		this.activtyName = activtyName;
	}
	public String getActivtyHierarchyOwner() {
		return activtyHierarchyOwner;
	}
	public void setActivtyHierarchyOwner(String activtyHierarchyOwner) {
		this.activtyHierarchyOwner = activtyHierarchyOwner;
	}
	public Integer getActivtyHierarchyOwnerID() {
		return activtyHierarchyOwnerID;
	}
	public void setActivtyHierarchyOwnerID(Integer activtyHierarchyOwnerID) {
		this.activtyHierarchyOwnerID = activtyHierarchyOwnerID;
	}
	public Integer getActivityHierarchyForDataMain() {
		return activityHierarchyForDataMain;
	}
	public void setActivityHierarchyForDataMain(Integer activityHierarchyForDataMain) {
		this.activityHierarchyForDataMain = activityHierarchyForDataMain;
	}
	
	public String getActivityAgency() {
		return activityAgency;
	}
	public void setActivityAgency(String activityAgency) {
		this.activityAgency = activityAgency;
	}
	
	
	
}
