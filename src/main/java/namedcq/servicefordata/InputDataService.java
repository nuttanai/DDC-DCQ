package namedcq.servicefordata;

public interface InputDataService {

		public abstract void insertProvinceData(String provinces, String region);
		public abstract void insertActivityDataMain(String activtyName, String activityDetail,String activityDetailForLinkDoc,Integer activityDataHID);
		public abstract void insertActivityDataHierarchy(String activtyName, String activtyHierarchyOwner, Integer activtyHierarchyOwnerID, Integer activityHierarchyForDataMain, String activityAgency);
		public abstract void insertActivityCall(String activityNumber, Integer activityNumberOwnerID);
		
		public abstract void insertQcat(String qCat);
		public abstract void insertQans(String questions,String answers,String ownQ,String ownA ,int qGroup);
		public abstract void insertDocHierarchy(String docHierarchyName,String docHierarchyOwner,int docDetail);
		public abstract void insertDocDetail(String docDetail,String docHowTo);
		public abstract void insertDocLink(int docLinkOwner, String docLink);
		
		public abstract void insertNews(String newsName,String newsData);
}


