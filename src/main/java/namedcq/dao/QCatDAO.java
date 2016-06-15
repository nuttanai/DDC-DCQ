package namedcq.dao;

import java.util.List;

import namedcq.model.QCat;

public interface QCatDAO {
	  
	   public abstract List<QCat> listQCat();
	   public abstract List<QCat> searchListQCat(String key);
	   
	   public abstract QCat getQCat(String qa);
	   
	   public abstract void create(String qCat);
	   public abstract void update(int qCatId ,String qCat);
	   public abstract void delete(int qCatId);
	 
}
