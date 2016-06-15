package namedcq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import namedcq.model.QCat;

import org.springframework.jdbc.core.RowMapper;

public class QCatMapper implements RowMapper {

	public QCat mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		QCat qCat = new QCat();
		//  qAns.setQid(rs.getInt("qid"));
		qCat.setqCatId(rs.getInt("qCatId"));
		qCat.setqCat(rs.getString("qCat"));
		
		return qCat;
	}

}
