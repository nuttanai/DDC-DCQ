package namedcq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;




import namedcq.model.News;

import org.springframework.jdbc.core.RowMapper;

public class NewsMapper implements RowMapper {

		   public News mapRow(ResultSet rs, int rowNum) throws SQLException {
			   News news = new News();
			   news.setNewId(rs.getInt("newId"));
			   news.setHotNewsName(rs.getString("hotNewsName"));			    
			   news.setHotNews(rs.getString("hotNews"));
			   news.setNewsDate(rs.getString("newsDate"));
			   return news;
			   }
	
}
