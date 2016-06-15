package namedcq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import namedcq.model.ActivityDataMain;


import org.springframework.jdbc.core.RowMapper;

public class ActivityDataMainMapper implements RowMapper{

	public ActivityDataMain mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ActivityDataMain activityDataMain = new ActivityDataMain();
	//	ActivityDataMain.setActivtyID(rs.getInt("activityID"));
		/*

		 * */		
		activityDataMain.setActivityNameID(rs.getInt("activityNameID"));
		activityDataMain.setActivityName(rs.getString("activityName"));
		activityDataMain.setActivityDetail(rs.getString("activityDetail"));
		activityDataMain.setActivityDetailForLinkDoce(rs.getString("activityDetailForLinkDoc"));
		
		return activityDataMain;
	}
	
	

}
