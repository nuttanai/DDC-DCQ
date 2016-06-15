package namedcq.serviceforandroid;

import java.util.List;

import namedcq.model.ActivityDataSet;

public interface DataListService {
	
	public abstract ActivityDataSet getActivityDataSetForAndroidAll(String activityName );

	public abstract ActivityDataSet getActivityDataSetForAndroid(String activityName );
}
