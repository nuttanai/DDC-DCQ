package namedcq.model;

public class ActivityDataMain {

	Integer activityNameID;
	String activityName;
	String activityDetail;
	String activityDetailForLinkDoce;
	Integer activityDataHID;

	

	
	public Integer getActivityDataHID() {
		return activityDataHID;
	}
	public void setActivityDataHID(Integer activityDataHID) {
		this.activityDataHID = activityDataHID;
	}
	public ActivityDataMain(Integer activityNameID,String activityName, String activityDetail ,String activityDetailForLinkDoce) {
		super();
		this.activityNameID = activityNameID;
		this.activityName = activityName;
		this.activityDetail = activityDetail;
		this.activityDetailForLinkDoce = activityDetailForLinkDoce;
	}
	public ActivityDataMain(){
		
	}
	
	public Integer getActivityNameID() {
		return activityNameID;
	}
	public void setActivityNameID(Integer activityNameID) {
		this.activityNameID = activityNameID;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getActivityDetail() {
		return activityDetail;
	}
	public void setActivityDetail(String activityDetail) {
		this.activityDetail = activityDetail;
	}
	public String getActivityDetailForLinkDoce() {
		return activityDetailForLinkDoce;
	}
	public void setActivityDetailForLinkDoce(String activityDetailForLinkDoce) {
		this.activityDetailForLinkDoce = activityDetailForLinkDoce;
	}
	
}
