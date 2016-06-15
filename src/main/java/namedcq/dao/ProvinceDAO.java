package namedcq.dao;

import java.util.List;

import javax.sql.DataSource;

import namedcq.model.Province;

public interface ProvinceDAO {
	   

	   public abstract void setDataSource(DataSource ds);

	   public abstract void create(String provinces, String region);

	   public abstract List<Province> listProvince();

	   public abstract void delete(Integer id);
	
	   public abstract void update(String provinces, String region);
	   
	   public abstract Province getProvince(String provinces);

}
