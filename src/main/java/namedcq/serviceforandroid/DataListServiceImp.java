package namedcq.serviceforandroid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import namedcq.dao.ActivityDataMainDAO;
import namedcq.dao.ActivityHierarchyDAO;
import namedcq.dao.NewsDAO;
import namedcq.dao.ProvinceDAO;
import namedcq.model.ActivityCall;
import namedcq.model.ActivityDataMain;
import namedcq.model.ActivityDataSet;
import namedcq.model.ActivityHierarchy;

@Component
public class DataListServiceImp implements DataListService{
	
	
	private ProvinceDAO provinceDAO;
	private ActivityHierarchyDAO activityHierarchyDAO;
	private ActivityDataMainDAO activityDataMainDAO;
	private NewsDAO newsDAO; 


	@Required
	@Autowired
	public void setNewsDAO(NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

	@Required
	@Autowired
	public void setProvinceDAO(ProvinceDAO provinceDAO) {
		this.provinceDAO = provinceDAO;
	}

	@Required
	@Autowired
	public void setActivityHierarchyDAO(ActivityHierarchyDAO activityHierarchyDAO) {
		this.activityHierarchyDAO = activityHierarchyDAO;
	}

	@Required
	@Autowired
	public void setActivityDataMainDAO(ActivityDataMainDAO activityDataMainDAO) {
		this.activityDataMainDAO = activityDataMainDAO;
	}
	
	public ActivityDataSet getActivityDataSetForAndroidAll(String activityName ){
		List<ActivityHierarchy> targetActivityHierarchy = (List<ActivityHierarchy>) activityHierarchyDAO.listActivityHierarchy();
		List<ActivityDataMain> targetActivityDataMain = (List<ActivityDataMain>) activityDataMainDAO.getListActivtyDataMain();
		ActivityCall targetActivityCall = new ActivityCall();
		
		ActivityDataSet targetActivityDataSet = new ActivityDataSet (targetActivityDataMain,targetActivityHierarchy,targetActivityCall);
		return targetActivityDataSet;
		
	}
	
	
	public ActivityDataSet getActivityDataSetForAndroid(String activityName ){	
	List<ActivityHierarchy> targetActivityHierarchy = (List<ActivityHierarchy>) activityHierarchyDAO.listActivityHierarchyOption(activityName);
	ActivityDataMain targetActivityDataMain = new ActivityDataMain();
	ActivityCall targetActivityCall = new ActivityCall();
	

//	int targetActivityHierarchyForDataMain = targetActivityHierarchy.get(0).getActivityHierarchyForDataMain();
	System.out.println("Target Is Run " + targetActivityHierarchy);
	
	if( targetActivityHierarchy.isEmpty()){
		System.out.println("Target Is Null ไม่ปกติ");
		ActivityHierarchy targetActivityHierarchyNull = new ActivityHierarchy();
		ActivityDataSet targetActivityDataSet = new ActivityDataSet (targetActivityDataMain ,targetActivityHierarchyNull, targetActivityCall);
		return targetActivityDataSet;
		
	}else if (targetActivityHierarchy.get(0).getActivityHierarchyForDataMain() == 1){
		System.out.println("Target Is 1 DataMain " );
		/// ต้องไปใช้ Service เรียกหน้ารายละเอียด
		targetActivityDataMain = activityDataMainDAO.getActivtyDataMain(targetActivityHierarchy.get(0).getActivtyName());
		ActivityDataSet  targetActivityDataSet = new ActivityDataSet (targetActivityDataMain,targetActivityHierarchy,targetActivityCall);
		return targetActivityDataSet;
	}else{
		/// Service ปกติ
		System.out.println("Service ปกติ");
		ActivityDataSet  targetActivityDataSet = new ActivityDataSet (targetActivityDataMain,targetActivityHierarchy,targetActivityCall);
		return targetActivityDataSet;
	}
	
}

}
