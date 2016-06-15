package namedcq.dao;

import java.util.List;

import javax.sql.DataSource;

import namedcq.model.DocLink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DocLinkDAOImp implements DocLinkDAO {
	
	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   @Autowired
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	   /*
	    *   	int docLinkId;
				int docLinkOwner;
				String docLink;
	    * 
	    * */
	   
	   public void create(int docLinkOwner, String docLink) {
		      String SQL = "insert into docLink (docLinkId,docLinkOwner, docLink) values (?,?,?)";
		      
		      int IDForHash = docLink.hashCode();
		      if(IDForHash < 0){IDForHash = IDForHash*(-1);}
		      jdbcTemplateObject.update(SQL, new Object[]{IDForHash,docLinkOwner,docLink});
		   //   System.out.println("Created Record Provinces = " + provinces + " Region = " + region);
		      return;
		   }
	   
	   public List<DocLink> listDocLink() {
		      String SQL = "select * from docLink";
		      List <DocLink> docLink = jdbcTemplateObject.query(SQL, new DocLinkMapper());
		      return docLink;
		   }
	   
	   public List<DocLink> listDocLinkOpt(int docLinkId) {
		      String SQL = "select * from docLink where docLinkOwner = ?";
		  //    List <DocLink> docLink = jdbcTemplateObject.query(SQL,new object{docLinkId}, new DocLinkMapper());
		  //    List <DocHierarchy> docHierarchy = jdbcTemplateObject.query(SQL,new Object[]{hierarchyName}, new DocHierarchyMapper());
		      List <DocLink> docLink = jdbcTemplateObject.query(SQL, new Object[]{docLinkId}, new DocLinkMapper());
		      return docLink;
		   }

		   


		   
		   public void update(int docLinkId ,int docLinkOwner,String docLink){
			//  String SQL = "insert into docLink (docLinkId,docLinkOwner, docLink) values (?,?,?)";
		      String SQL = "update docLink set docLink = ? ,docLinkOwner = ? where docLinkId = ?";
		      jdbcTemplateObject.update(SQL, new Object[]{docLink,docLinkOwner,docLinkId});
		
		      return;
		   }
			public void delete(int docLinkId){
			      String SQL = "delete from docLink where docLinkId = ?";
			      jdbcTemplateObject.update(SQL,new Object[]{docLinkId});
			      System.out.println("Deleted Record with Provinces = " + docLinkId );
			      return;
			}
	   
	   

}
