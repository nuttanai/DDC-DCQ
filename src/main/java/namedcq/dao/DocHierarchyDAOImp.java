package namedcq.dao;

import java.util.List;

import javax.sql.DataSource;

import namedcq.model.DocHierarchy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DocHierarchyDAOImp implements DocHierarchyDAO{
	
	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   @Autowired
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	/*   
		int docHierarchyId;
		String docHierarchyName;
		String docHierarchyOwner;
		int docDetail;
	*/   
	   public void create(	String docHierarchyName,String docHierarchyOwner,int docDetail) {
		      String SQL = "insert into docHierarchy (docHierarchyId, docHierarchyName, docHierarchyOwner, docDetail) values (?,?,?,?)";
		      
		      int IDForHash = docHierarchyName.hashCode();
		      if(IDForHash < 0){IDForHash = IDForHash*(-1);}
		      
		      jdbcTemplateObject.update(SQL, new Object[]{IDForHash,docHierarchyName,docHierarchyOwner,docDetail});
		   //   System.out.println("Created Record Provinces = " + provinces + " Region = " + region);
		      return;
		   }
	   
	   public List<DocHierarchy> listDocHierarchy() {
		      String SQL = "select * from docHierarchy";
		      List <DocHierarchy> docHierarchy = jdbcTemplateObject.query(SQL, new DocHierarchyMapper());
		      return docHierarchy;
		   }
	   
	   public List<DocHierarchy> listForView() {
		      String SQL = "select * from docHierarchy where (docHierarchyName != docHierarchyOwner) && (docDetail = 0)";
		      List <DocHierarchy> docHierarchy = jdbcTemplateObject.query(SQL, new DocHierarchyMapper());
		      return docHierarchy;
		   }
	   
	   public List<DocHierarchy> listForHaveData(){
		      String SQL = "select * from docHierarchy where docDetail = 1 ";
		      List <DocHierarchy> docHierarchy = jdbcTemplateObject.query(SQL, new DocHierarchyMapper());
		      return docHierarchy;   
	   }
	   
	   public List<DocHierarchy> listForNotHaveData(){
		      String SQL = "select * from docHierarchy where docDetail = 0 ";
		      List <DocHierarchy> docHierarchy = jdbcTemplateObject.query(SQL, new DocHierarchyMapper());
		      return docHierarchy;   
	   }
	   
	   
	   public List<DocHierarchy> listForFirst(){
		      String SQL = "select * from docHierarchy where docHierarchyName = docHierarchyOwner ";
		      List <DocHierarchy> docHierarchy = jdbcTemplateObject.query(SQL, new DocHierarchyMapper());
		      return docHierarchy;   
	   }
	   
	   public List<DocHierarchy> listForOrder(String hierarchyName){
		      String SQL = "select * from docHierarchy where (docHierarchyOwner = ? ) && (docHierarchyOwner != docHierarchyName) ";
		      System.out.println("Created Record Provinces = " + hierarchyName );
		      // jdbcTemplateObject.query(SQL, new Object[]{key}, new ActivityDataMainMapper());
		      List <DocHierarchy> docHierarchy = jdbcTemplateObject.query(SQL,new Object[]{hierarchyName}, new DocHierarchyMapper());
		      return docHierarchy;   
	   }
	   
	   public List<DocHierarchy> listForHaveDataOrder(String hierarchyName){
		      String SQL = "select * from docHierarchy where (docDetail = 1 and docHierarchyOwner = ?) ";
		      List <DocHierarchy> docHierarchy = jdbcTemplateObject.query(SQL, new Object[]{hierarchyName}, new DocHierarchyMapper());
		      return docHierarchy;   
	   }

		   
		   public void delete(int docHierarchyId){
		      String SQL = "delete from docHierarchy where docHierarchyId = ?";
		      jdbcTemplateObject.update(SQL,new Object[]{docHierarchyId});
		      System.out.println("Deleted Record with Provinces = " + docHierarchyId );
		      return;
		   }
		   
		   public void update(int docHierarchyId,String docHierarchyName,String docHierarchyOwner,int docDetail) {
			    //  String SQL = "insert into docHierarchy (docHierarchyId, docHierarchyName, docHierarchyOwner, docDetail) values (?,?,?)";
			      String SQL = "update docHierarchy set docHierarchyName = ? ,docHierarchyOwner = ? ,docDetail = ? where docHierarchyId = ?";

			      jdbcTemplateObject.update(SQL, new Object[]{docHierarchyName,docHierarchyOwner,docDetail,docHierarchyId});
			   //   System.out.println("Created Record Provinces = " + provinces + " Region = " + region);
			      return;
			   }

	   
	   
}
