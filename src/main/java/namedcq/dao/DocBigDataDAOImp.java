package namedcq.dao;

import java.util.List;

import javax.sql.DataSource;

import namedcq.model.DocBigData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DocBigDataDAOImp implements DocBigDataDAO {
	
	  private DataSource dataSource;
	  private JdbcTemplate jdbcTemplateObject;
	
	   @Autowired
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	   
	   
	   public List<DocBigData> listDocBigData() {
		      String SQL = "select * from docDetail";
		      List <DocBigData> docDetail = jdbcTemplateObject.query(SQL, new DocDetailMapper());
		   
		   
		      
		      
		      return docDetail;
		   }

}
