package namedcq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import namedcq.model.ActivityHierarchy;

import org.springframework.jdbc.core.RowMapper;

public class ActivityHierarchyMapper implements RowMapper {

	
	public ActivityHierarchy mapRow(ResultSet rs, int rowNum) throws SQLException {
			ActivityHierarchy activityHierarchy = new ActivityHierarchy();
			activityHierarchy.setActivtyID(rs.getInt("activityID"));
			activityHierarchy.setActivtyName(rs.getString("activityName"));
			activityHierarchy.setActivtyHierarchyOwner(rs.getString("activityHierarchyOwner"));
			activityHierarchy.setActivtyHierarchyOwnerID(rs.getInt("activityHierarchyOwnerID"));
			activityHierarchy.setActivityHierarchyForDataMain(rs.getInt("activityHierarchyForDataMain"));
			activityHierarchy.setActivityAgency(rs.getString("activityAgency"));
			
		return activityHierarchy;
	}

}
