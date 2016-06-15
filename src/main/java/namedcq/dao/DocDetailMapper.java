package namedcq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import namedcq.model.DocDetail;

import org.springframework.jdbc.core.RowMapper;

public class DocDetailMapper implements RowMapper{
	
	public DocDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DocDetail docDetail = new DocDetail();
		//  qAns.setQid(rs.getInt("qid"));
		/*
		 * 	int docDetailId;
	String docDetail;
	String docHowTo;
		 * */
		docDetail.setDocDetailId(rs.getInt("docDetailId"));
		docDetail.setDocDetail(rs.getString("docDetail"));
		docDetail.setDocHowTo(rs.getString("docHowTo"));
//	    docDetail.setDocDetailHiOwner(rs.getInt("docDetailHiOwner"));; 
		
		
		return docDetail;
	}

}
