package namedcq.dao;

import java.util.List;

import javax.sql.DataSource;

import namedcq.model.ActivityCall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ActivityCallDAOImp implements ActivityCallDAO{
	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   @Autowired
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	   /*
	    	Integer activityPhoneID;
	String activityNumber;
	Integer activityNumberOwnerID; 
	    * */
	   
	   public void create(String activityNumber,Integer activityNumberOwnerID) {
		      String SQL = "insert into activityCall(activityPhoneID, activityNumber, activityCallOwnerID) values ( 0, ?, ?);";
		      jdbcTemplateObject.update(SQL, new Object[]{activityNumber,activityNumberOwnerID});
		      System.out.println("Created Record For ActivityDataMain >> activityNumber = " + activityNumber + " activityNumberOwnerID = " + activityNumberOwnerID);
		      return;
		   }
	   public List<ActivityCall> listActivityCall() {
		      String SQL = "select * from activityCall";
		      List <ActivityCall> activityCall = jdbcTemplateObject.query(SQL, new ActivityCallMapper());
		      return activityCall;
		   }
	   
	   
	   
	   
}
