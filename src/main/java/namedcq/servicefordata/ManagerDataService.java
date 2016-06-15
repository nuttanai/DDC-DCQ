package namedcq.servicefordata;

public interface ManagerDataService {
	
	public abstract void delNews(int newId );
	public abstract void delDocHi(int docHiId );
	public abstract void delDocDetail(int docDetailId );
	public abstract void delDocLink(int docLinkId );
	public abstract void delQCat(int qcatId );
	public abstract void delQAns(int qansId );
	
	public abstract void updateNews(int newId ,String newsName,String newsData);
	public abstract void updateDocHi(int docHierarchyId,String docHierarchyName,String docHierarchyOwner,int docDetail);
	public abstract void updateDocDetail(int docDetailId , String docDetail,String docHowTo);
	public abstract void updateDocLink(int docLinkId ,int docLinkOwner,String docLink);
	public abstract void updateQCat(int qCatId ,String qCat);
	public abstract void updateQAns(int qid ,String questions,String answers,String ownQ,String ownA ,int qGroup);
	
	

}
