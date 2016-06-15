package namedcq.dao;

import java.util.List;

import javax.sql.DataSource;

import namedcq.model.Province;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProvinceDAOImp implements ProvinceDAO {
	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   @Autowired
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }

	   
	   public void create(String provinces, String region) {
	      String SQL = "insert into province (province, region) values (?,?)";
	      
	     // jdbcTemplateObject.update( SQL);
	      
	      jdbcTemplateObject.update(SQL, new Object[]{provinces,region});
	      System.out.println("Created Record Provinces = " + provinces + " Region = " + region);
	      return;
	   }

	  
	   public Province getProvince(String provinces) {
	      String SQL = "select * from province where province = ?";
	      System.out.println(provinces);
	      System.out.println("Is Not ");
	    
	      Province province = (Province) jdbcTemplateObject.queryForObject(SQL, new Object[]{provinces}, new Mapper());
//	      Province province = (Province) jdbcTemplateObject.query(sql, rowMapper)
	      System.out.println("Is Ok= ");

	      return province;
	   }

	   public List<Province> listProvince() {
	      String SQL = "select * from province";
	      List <Province> province = jdbcTemplateObject.query(SQL, new Mapper());
	      return province;
	   }

	   
	   public void delete(String provinces){
	      String SQL = "delete from province where province = ?";
	      jdbcTemplateObject.update(SQL);
	      System.out.println("Deleted Record with Provinces = " + provinces );
	      return;
	   }

	   
	   public void update(String provinces, String region){
	      String SQL = "update province set region = ? where province = ?";
	      jdbcTemplateObject.update(SQL);
	      System.out.println("Updated Record with province = " + provinces );
	      return;
	   }


	public List<Province> listStudents() {
		// TODO Auto-generated method stub
		return null;
	}


	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
