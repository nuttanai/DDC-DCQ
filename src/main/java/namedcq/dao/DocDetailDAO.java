package namedcq.dao;

import java.util.List;

import namedcq.model.DocDetail;

public interface DocDetailDAO {

	   public abstract void create(String docDetail,String docHowTo) ;
	   
	   public abstract List<DocDetail> listDocDetailAll();

	   public abstract List<DocDetail> listDocDetail(String DocDetail );
	   
	   public abstract List<DocDetail> listDocDetailSearch(String key);
	   
	   public abstract DocDetail docDetail(String DocDetail );
	   
	   public abstract DocDetail docDetailData(String DocDetail ) ;
	   
	   public abstract void update(int docDetailId , String docDetail,String docHowTo);
	   
	   public abstract void delete(int docDetailId);
	
}
