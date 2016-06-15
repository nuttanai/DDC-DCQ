package namedcq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import namedcq.model.Province;

import org.springframework.jdbc.core.RowMapper;

public class Mapper implements RowMapper {
	
	
	   public Province mapRow(ResultSet rs, int rowNum) throws SQLException {
		      Province province = new Province();
		      province.setProvinces(rs.getString("province"));
		      System.out.println("Deleted Record with Provinces = " + province.getProvinces() );
		      province.setRegion(rs.getString("region"));
		      System.out.println("Deleted Record with Provinces = " + province.getRegion() );
		      return province;
		   }
	
	/*
	   public Province mapRow(ResultSet rs) throws SQLException {
		      Province province = new Province();
		      province.setProvinces(rs.getString("province"));
		      province.setRegion(rs.getString("region"));
		      return province;
		   }

	public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	*/   
	   
}
