package namedcq.dao;

import java.util.List;

import javax.sql.DataSource;

import namedcq.model.QCat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class QCatDAOImp implements QCatDAO {
	
	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   @Autowired
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	   
	   //qCatId
	   //qCat
	   
	   public void create(String qCat) {
		      String SQL = "insert into qCat (qCatId, qCat) values (?,?)";
		      int qCatIDForHash = qCat.hashCode();
		      if(qCatIDForHash < 0){qCatIDForHash = qCatIDForHash*(-1);}
		      jdbcTemplateObject.update(SQL, new Object[]{qCatIDForHash,qCat});
		   //   System.out.println("Created Record Provinces = " + provinces + " Region = " + region);
		      return;
		   }
	   
	   public QCat getQCat(String qa) {
		      String SQL = "select * from qCat where qCat = ?";		    
		      QCat qCat = (QCat) jdbcTemplateObject.queryForObject(SQL, new Object[]{qa}, new QCatMapper());
		      System.out.println("Is Ok= ");

		      return qCat;
		   }

		   public List<QCat> listQCat() {
		      String SQL = "select * from qCat";
		      List <QCat> qCat = jdbcTemplateObject.query(SQL, new QCatMapper());
		      return qCat;
		   }
		   
		   public List<QCat> searchListQCat(String key){
			   String SQL = "select * from qCat where qCat like '%"+key+"%' ";
			   List<QCat> qCat = jdbcTemplateObject.query(SQL, new QCatMapper());
			   return qCat;   
		   }

		   
		   public void delete(int qCatId){
		      String SQL = "delete from qCat where qCatId = ?";
		      jdbcTemplateObject.update(SQL,new Object[]{qCatId});
		      System.out.println("Deleted Record with Provinces = " + qCatId );
		      return;
		   }

		   
		   public void update(int qCatId ,String qCat){
		      String SQL = "update qCat set qCat = ? where qCatId = ?";
		      jdbcTemplateObject.update(SQL, new Object[]{qCat,qCatId});
		      return;
		   }
	

}
