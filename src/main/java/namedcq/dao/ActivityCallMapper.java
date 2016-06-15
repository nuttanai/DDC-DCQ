package namedcq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import namedcq.model.ActivityCall;

import org.springframework.jdbc.core.RowMapper;

public class ActivityCallMapper implements RowMapper {
	
	   public ActivityCall mapRow(ResultSet rs, int rowNum) throws SQLException {
		   ActivityCall activityCall = new ActivityCall();
		  /*
		      province.setProvinces(rs.getString("province"));
		      System.out.println("Deleted Record with Provinces = " + province.getProvinces() );
		      province.setRegion(rs.getString("region"));
		      System.out.println("Deleted Record with Provinces = " + province.getRegion() );
		   */
		   activityCall.setActivityPhoneID(rs.getInt("activityPhoneID"));
		   activityCall.setActivityNumber(rs.getNString("activityNumber"));
		   activityCall.setActivityNumberOwnerID(rs.getInt("activityCallOwnerID"));
		 
		      return activityCall;
		   }

}
