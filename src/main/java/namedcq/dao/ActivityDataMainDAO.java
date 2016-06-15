package namedcq.dao;

import java.util.List;

import namedcq.model.ActivityDataMain;

public interface ActivityDataMainDAO {

	   public abstract ActivityDataMain getActivtyDataMain(String activtyName);
       public abstract List<ActivityDataMain> getListActivtyDataMain();
       public abstract List<ActivityDataMain> getListActivtyDataMainForSearch(String key);
       public abstract void create(String activtyName, String activityDetail,String activityDetailForLinkDoc,Integer activityDataHID);
	
}
