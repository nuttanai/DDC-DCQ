package namedcq.dao;

import java.util.List;

import javax.sql.DataSource;

import namedcq.model.ActivityHierarchy;



public interface ActivityHierarchyDAO {
	
	   public abstract void setDataSource(DataSource ds);

	   public abstract void create(String activtyName, String activtyHierarchyOwner,Integer activtyHierarchyOwnerID,Integer activityHierarchyForDataMain, String activityAgency);

	   public abstract List<ActivityHierarchy> listActivityHierarchy();
	   
	   public abstract List<ActivityHierarchy> listActivityHierarchyOption(String option);

	   public abstract void delete(String activtyName);
	
	   public abstract void update(String activtyName, String activtyHierarchyOwner,Integer activtyHierarchyOwnerID,Integer activityHierarchyForDataMain);
	   
	   public abstract ActivityHierarchy getProvince(String provinces);

}
