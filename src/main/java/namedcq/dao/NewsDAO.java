package namedcq.dao;

import java.util.List;

import namedcq.model.News;

public interface NewsDAO {
	
	public abstract List<News> getNews();
	public abstract void create(String newsName,String newsData);
	public abstract void update(int newId ,String newsName,String newsData);
	public abstract void delete(int newId);

}
