package namedcq.model;

import java.util.List;

public class ActivityDataSet {
	
	ActivityDataMain activityDataMain;  
	ActivityHierarchy activityHierarchy;
	ActivityCall activityCall;
	
	List<ActivityDataMain> activityDataMainList;  
	List<ActivityHierarchy> activityHierarchyList;
	List<ActivityCall> activityCallList;
	
	


	public ActivityDataSet(ActivityDataSet activityDataSet){
		
	}
	
	public ActivityDataSet(){
	
	}
	
	

	public ActivityDataSet(	ActivityDataMain activityDataMain, ActivityHierarchy activityHierarchy
	            ,ActivityCall activityCall){
		super();
		this.activityHierarchy = activityHierarchy;
		this.activityDataMain = activityDataMain; 
		this.activityCall = activityCall;
		
	}
	
	public ActivityDataSet(	List<ActivityDataMain> activityDataMainList, List<ActivityHierarchy> activityHierarchyList
			               ,ActivityCall activityCall){
		super();
		this.activityDataMainList = (List<ActivityDataMain>) activityDataMainList; 
		this.activityHierarchyList = (List<ActivityHierarchy>) activityHierarchyList;
		this.activityCall =  activityCall;
		
	}
	
	public ActivityDataSet(	ActivityDataMain activityDataMain,List<ActivityHierarchy> activityHierarchyList
            ,ActivityCall activityCall){
			super();
			this.activityDataMain = activityDataMain; 
			this.activityHierarchyList = (List<ActivityHierarchy>) activityHierarchyList;
			this.activityCall =  activityCall;

}
	
	
	public ActivityDataMain getActivityDataMain() {
		return activityDataMain;
	}
	public void setActivityDataMain(ActivityDataMain activityDataMain) {
		this.activityDataMain = activityDataMain;
	}
	public ActivityHierarchy getActivityHierarchy() {
		return activityHierarchy;
	}
	public void setActivityHierarchy(ActivityHierarchy activityHierarchy) {
		this.activityHierarchy = activityHierarchy;
	}
	public ActivityCall getActivityCall() {
		return activityCall;
	}
	

	public List<ActivityDataMain> getActivityDataMainList() {
		return activityDataMainList;
	}


	public void setActivityDataMainList(List<ActivityDataMain> activityDataMainList) {
		this.activityDataMainList = activityDataMainList;
	}


	public List<ActivityHierarchy> getActivityHierarchyList() {
		return activityHierarchyList;
	}


	public void setActivityHierarchyList(List<ActivityHierarchy> activityHierarchyList) {
		this.activityHierarchyList = activityHierarchyList;
	}


	public List<ActivityCall> getActivityCallList() {
		return activityCallList;
	}


	public void setActivityCallList(List<ActivityCall> activityCallList) {
		this.activityCallList = activityCallList;
	}


	public void setActivityCall(ActivityCall activityCall) {
		this.activityCall = activityCall;
	}



}
