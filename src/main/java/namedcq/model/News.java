package namedcq.model;

public class News {

	Integer newId;
	String hotNewsName;
	String hotNews;
	String NewsDate;
	
	public News(Integer newId,String hotNewsName,
			String hotNews,String NewsDate) {
		
		super();
		this.newId = newId;
		this.hotNewsName = hotNewsName;
		this.hotNews = hotNews;
		this.NewsDate = NewsDate;

	}
	public News(){
		
	}
	
	public Integer getNewId() {
		return newId;
	}
	public void setNewId(Integer newId) {
		this.newId = newId;
	}
	public String getHotNewsName() {
		return hotNewsName;
	}
	public void setHotNewsName(String hotNewsName) {
		this.hotNewsName = hotNewsName;
	}
	public String getHotNews() {
		return hotNews;
	}
	public void setHotNews(String hotNews) {
		this.hotNews = hotNews;
	}
	public String getNewsDate() {
		return NewsDate;
	}
	public void setNewsDate(String newsDate) {
		NewsDate = newsDate;
	}
	
}
