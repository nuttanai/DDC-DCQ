package namedcq.dao;

import java.util.List;

import javax.sql.DataSource;

import namedcq.model.ActivityDataMain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ActivityDataMainDAOImp implements ActivityDataMainDAO{
	
	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   @Autowired
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	   
	   public void create(String activtyName, String activityDetail,String activityDetailForLinkDoc,Integer activityDataHID) {
		      String SQL = "insert into activityDataMain (activityNameID, activityName, activityDetail, activityDetailForLinkDoc, activityDataHID) values ( 0, ?, ?, ?, ?);";
		      jdbcTemplateObject.update(SQL, new Object[]{activtyName,activityDetail,activityDetailForLinkDoc,activityDataHID});
		      System.out.println("Created Record For ActivityDataMain >> ActivityName = " + activtyName + " ActivityDetail = " + activityDetail);
		      return;
		   }

	   
	   public ActivityDataMain getActivtyDataMain(String activtyName) {
		      String SQL = "select * from activityDataMain where activityName = ?";
		      ActivityDataMain activityDataMain= (ActivityDataMain) jdbcTemplateObject.queryForObject(SQL, new Object[]{activtyName}, new ActivityDataMainMapper());
		      return activityDataMain;
		   }

	   public List<ActivityDataMain> getListActivtyDataMain() {
		      String SQL = "select * from activityDataMain";
		      List <ActivityDataMain> activtyList = jdbcTemplateObject.query(SQL, new ActivityDataMainMapper());
		      return activtyList;
		   }
	   public List<ActivityDataMain> getListActivtyDataMainForSearch(String key) {
		      String SQL = "select * from activityDataMain where (activityName LIKE '%?%') or (activityNameDetail LIKE '%?%') ";
		      List <ActivityDataMain> activtyList = jdbcTemplateObject.query(SQL, new Object[]{key}, new ActivityDataMainMapper());
		      return activtyList;
		   }
}
