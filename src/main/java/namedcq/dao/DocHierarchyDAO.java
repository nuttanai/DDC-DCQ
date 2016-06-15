package namedcq.dao;

import java.util.List;

import namedcq.model.DocHierarchy;

public interface DocHierarchyDAO {
	
	   public abstract void create(String docHierarchyName,String docHierarchyOwner,int docDetail);
	   
	   public abstract void delete(int docHierarchyId);
	
	   public abstract List<DocHierarchy> listDocHierarchy() ;
	   
	   public abstract List<DocHierarchy> listForHaveData();
	   
	   public abstract List<DocHierarchy> listForNotHaveData();
	   
	   public abstract List<DocHierarchy> listForFirst();
	   
	   public abstract List<DocHierarchy> listForOrder(String hierarchyName);
	   
	   public abstract List<DocHierarchy> listForView();
   
	   public abstract List<DocHierarchy> listForHaveDataOrder(String hierarchyName);
	   
	   public void update(int docHierarchyId,String docHierarchyName,String docHierarchyOwner,int docDetail) ;


}
