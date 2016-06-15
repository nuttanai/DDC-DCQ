package namedcq.dao;

import java.util.List;

import javax.sql.DataSource;

import namedcq.model.ActivityHierarchy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ActivityHierarchyDAOlmp implements ActivityHierarchyDAO {

	private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   @Autowired
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }

	   
	   public void create(String activtyName, String activtyHierarchyOwner,Integer activtyHierarchyOwnerID,Integer activityHierarchyForDataMain, String activityAgency ) {
	      String SQL = "insert into activityHierarchy (activityID, activityName , activityHierarchyOwner, activityHierarchyOwnerID, activityHierarchyForDataMain, activityAgency) values ( ? ,?, ?, ?, ?, ?);";
	      int activityIDForHash = activtyName.hashCode();
	      if(activityIDForHash < 0){activityIDForHash = activityIDForHash*(-1);}
	      jdbcTemplateObject.update(SQL, new Object[]{activityIDForHash,activtyName,activtyHierarchyOwner,activtyHierarchyOwnerID,activityHierarchyForDataMain,activityAgency});
         //	jdbcTemplateObject.update( SQL);
	      System.out.println("Created Record For ActivityHierarchy >> ActivityIDForHash = " + activityIDForHash + " ActivtyName = " + activtyName);
	      return;
	   }

	  
	   public ActivityHierarchy getActivty(String activtyName) {
	      String SQL = "select * from province where province = ?";
	      System.out.println(activtyName);
	      System.out.println("Is Not ");
	    
	      ActivityHierarchy activty= (ActivityHierarchy) jdbcTemplateObject.queryForObject(SQL, new Object[]{activtyName}, new ActivityHierarchyMapper());
//	      Province province = (Province) jdbcTemplateObject.query(sql, rowMapper)
	      System.out.println("Is Ok= ");

	      return activty;
	   }

	   public List<ActivityHierarchy> listActivityHierarchy() {
	      String SQL = "select * from activityHierarchy where activityHierarchyOwner = activityName";
	      List <ActivityHierarchy> activtyList = jdbcTemplateObject.query(SQL, new ActivityHierarchyMapper());
	      return activtyList;
	   }

	   public List<ActivityHierarchy> listActivityHierarchyOption(String Option) {
  
		   String SQL = "select * from activityHierarchy where (activityHierarchyOwner = ? )and (activityHierarchyOwner != activityName)";
		   List <ActivityHierarchy> activtyList = (List<ActivityHierarchy>) jdbcTemplateObject.query(SQL, new Object[]{Option}, new ActivityHierarchyMapper());
		   return activtyList;

		   }
	   
	   public void delete(String activtyName){
	      String SQL = "delete from province where activtyName = ?";
	      jdbcTemplateObject.update(SQL);
	      System.out.println("Deleted Record with Provinces = " + activtyName );
	      return;
	   }

	   
	   public void update(String activtyName, String activtyHierarchyOwner,Integer activtyHierarchyOwnerID,Integer activityHierarchyForDataMain){
	      String SQL = "update province set region = ? where province = ?";
	      jdbcTemplateObject.update(SQL);
	      System.out.println("Updated Record with province = " + activtyName );
	      return;
	   }


	public List<ActivityHierarchy> listActivityHierarchyOption() {
		// TODO Auto-generated method stub
		return null;
	}


	public ActivityHierarchy getProvince(String provinces) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
