package namedcq.dao;

import java.util.List;

import javax.sql.DataSource;

import namedcq.model.QAns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class QAnsDAOImp implements QAnsDAO{

	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   @Autowired
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	   /*
	    * qid
			questions
			answers
			ownQ
			ownA
	    * */
	   public void create(	String questions,String answers,String ownQ,String ownA ,int qGroup) {
		      String SQL = "insert into qAns (qid, questions, answers, ownQ, ownA,qGroup) values (?,?,?,?,?,?)";
		      
		      int questionsIDForHash = questions.hashCode();
		      if(questionsIDForHash < 0){questionsIDForHash = questionsIDForHash*(-1);}
		      
		      jdbcTemplateObject.update(SQL, new Object[]{questionsIDForHash,questions,answers,ownQ,ownA,qGroup});
		   //   System.out.println("Created Record Provinces = " + provinces + " Region = " + region);
		      return;
		   }

		  
		   public QAns getQAns(String qa) {
		      String SQL = "select * from qAns where questions = ?";		    
		      QAns qAns = (QAns) jdbcTemplateObject.queryForObject(SQL, new Object[]{qa}, new QAnsDAOMapper());
//		      Province province = (Province) jdbcTemplateObject.query(sql, rowMapper)
		      System.out.println("Is Ok= ");

		      return qAns;
		   }

		   public List<QAns> listQAns() {
		      String SQL = "select * from qAns";
		      List <QAns> qAns = jdbcTemplateObject.query(SQL, new QAnsDAOMapper());
		      return qAns;
		   }
		   
		   public List<QAns> listQAnsIndex() {
			      String SQL = "select * from qAns where (answers is null or answers = '') ";
			      List <QAns> qAns = jdbcTemplateObject.query(SQL, new QAnsDAOMapper());
			      return qAns;
			   }
		   
		   public List<QAns> listQAnsSearch(String key) {
			      String SQL = "select * from qAns where questions like '%"+key+"%' ";
			      System.out.println("SQL is a >>>>> =  " + SQL );
			      System.out.println("key Record with key is a = " + key );
			      List <QAns> qAns = jdbcTemplateObject.query(SQL, new QAnsDAOMapper());
			      return qAns;
			   }
		   
		   public List<QAns> listQAnsOpt(int qGroup) {
			      String SQL = "select * from qAns where qGroup = ?";
			      //List <QAns> qAns = jdbcTemplateObject.query(SQL, new QAnsDAOMapper());
			      //   List <ActivityHierarchy> activtyList = (List<ActivityHierarchy>) jdbcTemplateObject.query(SQL, new Object[]{Option}, new ActivityHierarchyMapper());
			      List <QAns> qAns = jdbcTemplateObject.query(SQL, new Object[]{qGroup},new QAnsDAOMapper());
			      return qAns;
			   }

		   
		   public void delete(int qid){
		      String SQL = "delete from qAns where qid = ?";
		      jdbcTemplateObject.update(SQL,new Object[]{qid});
		      System.out.println("Deleted Record with Provinces = " + qid );
		      return;
		   }

		   
		   public void update(int qid ,String questions,String answers,String ownQ,String ownA ,int qGroup){
			//   String SQL = "insert into qAns (qid, questions, answers, ownQ, ownA,qGroup) values (?,?,?,?,?,?)";
			  String SQL = "update qAns set questions = ? ,answers = ? ,ownQ = ? ,ownA = ? , qGroup = ?  where qid = ?";
		      
			  jdbcTemplateObject.update(SQL, new Object[]{questions,answers, ownQ ,ownA,qGroup,qid});
		      System.out.println("Updated Record with IS Ok = " );
		      return;
		   }
	
}
