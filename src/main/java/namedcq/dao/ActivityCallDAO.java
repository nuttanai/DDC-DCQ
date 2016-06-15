package namedcq.dao;

import java.util.List;

import namedcq.model.ActivityCall;

public interface ActivityCallDAO {
	
	public void create(String activityNumber,Integer activityNumberOwnerID);
	public List<ActivityCall> listActivityCall();

}
