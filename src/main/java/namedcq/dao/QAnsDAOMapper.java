package namedcq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import namedcq.model.QAns;

import org.springframework.jdbc.core.RowMapper;

public class QAnsDAOMapper implements RowMapper{

	public QAns mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		/*
		 
		 	int qid;
	String questions;
	String answers;
	String ownQ;
	String ownA;
		 
		 */
		
		  QAns qAns = new QAns();
		
		  qAns.setQid(rs.getInt("qid"));
		  qAns.setQuestions(rs.getString("questions"));
		  qAns.setAnswers(rs.getString("answers"));
		  qAns.setOwnQ(rs.getString("ownQ"));
		  qAns.setOwnA(rs.getString("ownA"));
		  qAns.setqGroup(rs.getInt("qGroup"));
	//	  System.out.println("Deleted Record with Provinces = " + province.getProvinces() );
	//      System.out.println("Deleted Record with Provinces = " + province.getRegion() );
	      return qAns;
		
	
	}
	

}
