package namedcq.dao;

import java.util.List;

import javax.sql.DataSource;

import namedcq.model.DocDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DocDetailDAOImp implements DocDetailDAO{

	  private DataSource dataSource;
	  private JdbcTemplate jdbcTemplateObject;
	
	   @Autowired
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	   /*
		int docDetailId;
		String docDetail;
		String docHowTo;
	    */
	   public void create(String docDetail,String docHowTo) {
		      String SQL = "insert into docDetail (docDetailId, docDetail, docHowTo ) values (?,?,?)";
		      
		      int IDForHash = docDetail.hashCode();
		      if(IDForHash < 0){IDForHash = IDForHash*(-1);}
		      
		      jdbcTemplateObject.update(SQL, new Object[]{IDForHash,docDetail,docHowTo});
		   //   System.out.println("Created Record Provinces = " + provinces + " Region = " + region);
		      return;
		   }
	   
	   public List<DocDetail> listDocDetailAll() {
		      String SQL = "select * from docDetail";
		      List <DocDetail> docDetail = jdbcTemplateObject.query(SQL, new DocDetailMapper());
		      return docDetail;
		   }

	   public List<DocDetail> listDocDetail(String DocDetail ) {
		      String SQL = "select * from docDetail where docDetail = ? ";
		  // jdbcTemplateObject.query(SQL, new Object[]{key}, new ActivityDataMainMapper());
		      List <DocDetail> docDetail = jdbcTemplateObject.query(SQL, new Object[]{DocDetail}, new DocDetailMapper());
		      return docDetail;
		   }
	   
	   public DocDetail docDetail(String DocDetail ) {
		      String SQL = "select * from docDetail where docDetail = ?";
			  
		      jdbcTemplateObject.queryForObject(SQL, new Object[]{DocDetail}, new DocDetailMapper());
		      
		      // jdbcTemplateObject.query(SQL, new Object[]{key}, new ActivityDataMainMapper());
			   //   System.out.println("Deleted Record with DocDetailDocDetailDocDetailDocDetailDocDetailDocDetail = " + DocDetail );
			      DocDetail docDetail = (DocDetail) jdbcTemplateObject.queryForObject(SQL, new Object[]{DocDetail}, new DocDetailMapper());
		      /*
		      DocDetail docDetail = new DocDetail();
		      docDetail = null;
		      docDetail = (DocDetail) jdbcTemplateObject.queryForObject(SQL, new Object[]{DocDetail}, new DocDetailMapper());
		      queryForObject(SQL, new Object[]{DocDetail}, new DocDetailMapper());
		    */
		//      System.out.println( SQL );
		//      DocDetail docDetail = (DocDetail) jdbcTemplateObject.queryForObject(SQL, new DocDetailMapper());
		
		      if(docDetail.equals(null)){
		    	  System.out.println("Deleted Record with Provinces = Is NULL "  );
		    	  return null; 
		      }else{
		    	    System.out.println("Deleted Record with Provinces = " + docDetail );
				      return docDetail;
		      }
		  
		   }
	       public DocDetail docDetailData(String DocDetail ) {  
	    	      String SQL = "select * from docDetail where docDetail = ?";  
	    	      DocDetail docDetail = (DocDetail) jdbcTemplateObject.queryForObject(SQL, new Object[]{DocDetail}, new DocDetailMapper()); 	   
	    	   return docDetail;
	       }
		   
		   public void delete(int docDetailId){
		      String SQL = "delete from docDetail where docDetailId = ?";
		      jdbcTemplateObject.update(SQL,new Object[]{docDetailId});
		      System.out.println("Deleted Record with Provinces = " + docDetailId );
		      return;
		   }

		   
		   public void update(int docDetailId , String docDetail,String docHowTo){
			   
		//	  String SQL = "insert into docDetail (docDetailId, docDetail, docHowTo, docDetailHiOwner) values (?,?,?,?)";
			   
		      String SQL = "update docDetail set docDetail = ? , docHowTo = ? where docDetailId = ?";
		    
		      jdbcTemplateObject.update(SQL, new Object[]{docDetail,docHowTo,docDetailId});
		      System.out.println("Updated Record with province = " + docHowTo + docDetailId);
		      return;
		   }
		   public List<DocDetail> listDocDetailSearch(String key){
			      String SQL = "select * from docDetail where docDetail like '%"+key+"%' ";
			      List <DocDetail> docDetail = jdbcTemplateObject.query(SQL, new DocDetailMapper());
			      return docDetail;
		   }
	   
	   
}
