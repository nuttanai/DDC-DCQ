package namedcq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import namedcq.model.DocHierarchy;

import org.springframework.jdbc.core.RowMapper;

public class DocHierarchyMapper implements RowMapper {
	
	public DocHierarchy mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DocHierarchy docHierarchy = new DocHierarchy();
		//  qAns.setQid(rs.getInt("qid"));
		
		/*
		 * 	int docHierarchyId;
	String docHierarchyName;
	String docHierarchyOwner;
	int docDetail;
		 * */
		docHierarchy.setDocHierarchyId(rs.getInt("docHierarchyId"));
		docHierarchy.setDocHierarchyName(rs.getString("docHierarchyName"));
		docHierarchy.setDocHierarchyOwner(rs.getString("docHierarchyOwner"));
		docHierarchy.setDocDetail(rs.getInt("docDetail"));

		return docHierarchy;
	}

}
