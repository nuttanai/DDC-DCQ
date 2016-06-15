package namedcq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import namedcq.model.DocLink;

import org.springframework.jdbc.core.RowMapper;

public class DocLinkMapper implements RowMapper {
	
	public DocLink mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		/*
		 * 	int docLinkId;
	int docLinkOwner;
	String docLink;
		 * 
		 * */
		
		DocLink docLink = new DocLink();
		//  qAns.setQid(rs.getInt("qid"));
		docLink.setDocLinkId(rs.getInt("docLinkId"));
		docLink.setDocLinkOwner(rs.getInt("docLinkOwner"));
		docLink.setDocLink(rs.getString("docLink"));

		return docLink;
	}

}
