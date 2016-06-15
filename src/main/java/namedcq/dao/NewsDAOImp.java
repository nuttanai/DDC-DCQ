package namedcq.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import namedcq.model.News;
import namedcq.model.Province;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class NewsDAOImp implements NewsDAO {

	private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   @Autowired
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	   

		      
			   public void create(String newsName,String newsData) {
				      Date date = new Date( );
				      SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy ");
				      String dateDB = dateFormat.format(date);    
				      String SQL = "insert into hotNews (newId, hotNewsName,hotNews,NewsDate) values (?,?,?,?)";
				      int qCatIDForHash = newsName.hashCode();
				      if(qCatIDForHash < 0){qCatIDForHash = qCatIDForHash*(-1);}
				      jdbcTemplateObject.update(SQL, new Object[]{qCatIDForHash,newsName,newsData,dateDB});
				   //   System.out.println("Created Record Provinces = " + provinces + " Region = " + region);
				      return;
				   }

	   public List<News> getNews() {
	      String SQL = "select * from hotNews";

	      List<News> news = (List<News>) jdbcTemplateObject.query(SQL, new NewsMapper());
//	      News province = (Province) jdbcTemplateObject.query(sql, rowMapper)
	   

	      return news;
	   }

	   public List<Province> listProvince() {
	      String SQL = "select * from province";
	      List <Province> province = jdbcTemplateObject.query(SQL, new Mapper());
	      return province;
	   }

	   public void update(int newId ,String newsName,String newsData){
		   
		      Date date = new Date( );
		      SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy ");
		      String dateDB = dateFormat.format(date);    
	//	      String SQL = "insert into hotNews (newId, hotNewsName,hotNews,NewsDate) values (?,?,?,?)"; 
		   
		//   String SQL = "insert into qAns (qid, questions, answers, ownQ, ownA,qGroup) values (?,?,?,?,?,?)";
		  String SQL = "update hotNews set hotNewsName = ? ,hotNews = ? ,NewsDate = ?  where newId = ?";
	    
		  jdbcTemplateObject.update(SQL, new Object[]{newsName,newsData, dateDB,newId});
	      System.out.println("Updated Record with IS Ok = " );
	      return;
	   }
	   
		public void delete(int newId){
		      String SQL = "delete from hotNews where newId = ?";
		      jdbcTemplateObject.update(SQL,new Object[]{newId});
		      System.out.println("Deleted Record with Provinces = " + newId );
		      return;
		}

	
	
	
}
