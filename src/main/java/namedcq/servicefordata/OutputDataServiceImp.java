package namedcq.servicefordata;

import java.util.List;

import namedcq.dao.ActivityDataMainDAO;
import namedcq.dao.ActivityHierarchyDAO;
import namedcq.dao.DocDetailDAO;
import namedcq.dao.DocHierarchyDAO;
import namedcq.dao.DocLinkDAO;
import namedcq.dao.NewsDAO;
import namedcq.dao.ProvinceDAO;
import namedcq.dao.QAnsDAO;
import namedcq.dao.QCatDAO;
import namedcq.model.ActivityCall;
import namedcq.model.ActivityDataMain;
import namedcq.model.ActivityDataSet;
import namedcq.model.ActivityHierarchy;
import namedcq.model.DocBigData;
import namedcq.model.DocDetail;
import namedcq.model.DocHierarchy;
import namedcq.model.DocLink;
import namedcq.model.News;
import namedcq.model.Province;
import namedcq.model.QAns;
import namedcq.model.QCat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class OutputDataServiceImp implements OutputDataService {
	
	private ProvinceDAO provinceDAO;
	private ActivityHierarchyDAO activityHierarchyDAO;
	private ActivityDataMainDAO activityDataMainDAO;
	private NewsDAO newsDAO; 
	private QCatDAO qCatDAO;
	private DocDetailDAO docDetailDAO;
	private DocHierarchyDAO docHierarchyDAO;
	private DocLinkDAO docLinkDAO;
	private QAnsDAO qAnsDAO; 
	
	@Required
	@Autowired
	public void setDocLinkDAO(DocLinkDAO docLinkDAO) {
		this.docLinkDAO = docLinkDAO;
	}

	@Required
	@Autowired
	public void setqAnsDAO(QAnsDAO qAnsDAO) {
		this.qAnsDAO = qAnsDAO;
	}

	@Required
	@Autowired
	public void setDocDetailDAO(DocDetailDAO docDetailDAO) {
		this.docDetailDAO = docDetailDAO;
	}

	@Required
	@Autowired
	public void setDocHierarchyDAO(DocHierarchyDAO docHierarchyDAO) {
		this.docHierarchyDAO = docHierarchyDAO;
	}

	@Required
	@Autowired
	public void setqCatDAO(QCatDAO qCatDAO) {
		this.qCatDAO = qCatDAO;
	}

	@Required
	@Autowired
	public void setNewsDAO(NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

	@Required
	@Autowired
	public void setProvinceDAO(ProvinceDAO provinceDAO) {
		this.provinceDAO = provinceDAO;
	}

	@Required
	@Autowired
	public void setActivityHierarchyDAO(ActivityHierarchyDAO activityHierarchyDAO) {
		this.activityHierarchyDAO = activityHierarchyDAO;
	}

	@Required
	@Autowired
	public void setActivityDataMainDAO(ActivityDataMainDAO activityDataMainDAO) {
		this.activityDataMainDAO = activityDataMainDAO;
	}


	public List<Province> getProvince( String province ){		
	//Province targetPost = postDao.getPostById(postId);
	//	Province targetProvince = provinceDAO.getProvince(province);
		List<Province>targetProvince = (List<Province>) provinceDAO.listProvince();

		if( targetProvince == null ){
			System.out.println("TargetProvince Is Null");
			return targetProvince;
		}
		else{
			return targetProvince;		
		}
	}
	


	public Province getProvinceData( String province ){		
	//Province targetPost = postDao.getPostById(postId);
		Province targetProvince = provinceDAO.getProvince(province);
	//	List<Province>targetProvince = (List<Province>) provinceDAO.listProvince();

		if( targetProvince == null ){
			System.out.println("TargetProvince Is Null");
			return targetProvince;
		}
		else{
			return targetProvince;		
		}
	}

	public List<ActivityHierarchy> getActivityHierarchyList(){
		List<ActivityHierarchy> targetActivityHierarchy = (List<ActivityHierarchy>) activityHierarchyDAO.listActivityHierarchy();
		
		if( targetActivityHierarchy == null ){
			System.out.println("Target Is Null");
			return targetActivityHierarchy;
		}
		else{
			return targetActivityHierarchy;	
		}
	} 
	
	public List<ActivityHierarchy> getActivityHierarchyListOption(String ActivityHierarchyName){
	
		System.out.println("Target Is Null" + ActivityHierarchyName );
		List<ActivityHierarchy> targetActivityHierarchy = (List<ActivityHierarchy>) activityHierarchyDAO.listActivityHierarchyOption(ActivityHierarchyName);

		int targetActivityHierarchyForDataMain = targetActivityHierarchy.get(0).getActivityHierarchyForDataMain();

		if( targetActivityHierarchy == null ){
			System.out.println("Target Is Null");
			return targetActivityHierarchy;
		}else if (targetActivityHierarchyForDataMain == 1){
			/// ต้องไปใช้ Service เรียกหน้ารายละเอียด
			return targetActivityHierarchy;
		}else{
			/// Service ปกติ
			System.out.println("Service ปกติ");
			return targetActivityHierarchy;	
		}
	} 
	
	public List<ActivityDataMain> getActivityDataMainList(){
		List<ActivityDataMain> targetActivityDataMain = (List<ActivityDataMain>) activityDataMainDAO.getListActivtyDataMain();
	if(targetActivityDataMain == null){
		System.out.println("Target Is Null");
		return targetActivityDataMain;
	}else{
		return targetActivityDataMain;
	}	
		}
	public ActivityDataSet getActivityDataMainSet(){
		List<ActivityHierarchy> targetActivityHierarchy = (List<ActivityHierarchy>) activityHierarchyDAO.listActivityHierarchy();
		List<ActivityDataMain> targetActivityDataMain = (List<ActivityDataMain>) activityDataMainDAO.getListActivtyDataMain();
	//	List<ActivityDataSet> targetActivityDataSet = (List<ActivityDataSet>) activityDataMainDAO.getListActivtyDataMain();
	//	ActivityHierarchy targetActivityHierarchy = new ActivityHierarchy() ;
//		ActivityDataMain targetActivityDataMain = new ActivityDataMain();
		ActivityCall targetActivityCall = new ActivityCall();
		
		ActivityDataSet targetActivityDataSet = new ActivityDataSet (targetActivityDataMain,targetActivityHierarchy,targetActivityCall);
		return targetActivityDataSet;
		
	}
	
	public ActivityCall getActivityCall(){
		ActivityCall targetActivityCall = new ActivityCall();
		return targetActivityCall;
		
	}
	
	public List<News> getNews(){
		List<News> targetNews = (List<News>) newsDAO.getNews();
		return targetNews;
		
	}
	public List<QCat> getListQCat(){
		 List<QCat> qCat = (List<QCat>) qCatDAO.listQCat();
		return qCat ;
	}
	
	/*
	 		System.out.println("Target Is Null" + ActivityHierarchyName );
		List<ActivityHierarchy> targetActivityHierarchy = (List<ActivityHierarchy>) activityHierarchyDAO.listActivityHierarchyOption(ActivityHierarchyName);

		int targetActivityHierarchyForDataMain = targetActivityHierarchy.get(0).getActivityHierarchyForDataMain();

		if( targetActivityHierarchy == null ){
			System.out.println("Target Is Null");
			return targetActivityHierarchy;
		}else if (targetActivityHierarchyForDataMain == 1){
			/// ต้องไปใช้ Service เรียกหน้ารายละเอียด
			return targetActivityHierarchy;
		}else{
			/// Service ปกติ
			System.out.println("Service ปกติ");
			return targetActivityHierarchy;	
		} 
	 
	 * */
	
	public DocBigData getBigData(String name){
			
		if(docDetailDAO.docDetail(name).equals(null) && docHierarchyDAO.listForOrder(name).equals(null) ){
			System.out.println("Service  Is Null ERROR ");	
			return null;
			
		}else if(docHierarchyDAO.listForOrder(name).equals(null)){
			System.out.println("Service  Is Null ERROR docHierarchyDAO");	
			DocBigData docBigData = new DocBigData(null, docHierarchyDAO.listForOrder(name));
			return docBigData;
		}else if(docDetailDAO.docDetail(name).equals(null)){
			System.out.println("Service  Is Null ERROR docDetailDAO");	
			DocBigData docBigData = new DocBigData(docDetailDAO.docDetail(name), null);
			return docBigData;
		}else{
			System.out.println("Service  Is else ");	
			DocBigData docBigData = new DocBigData(docDetailDAO.docDetail(name), docHierarchyDAO.listForOrder(name));
			return docBigData;
		}	
	} // end 
	
	public List<QAns> getQAns(String catForQA){
		int qGroup = Integer.valueOf(catForQA).intValue();
		List<QAns> qAnsList =  (List<QAns>) qAnsDAO.listQAnsOpt(qGroup);
		return qAnsList ;
	}
	
	public List<QAns> getQAnsList(){
		//int qGroup = Integer.valueOf(catForQA).intValue();
		List<QAns> qAnsList =  (List<QAns>) qAnsDAO.listQAns();
		return qAnsList ;
	}
	
	public List<QAns> getQAnsListIndex(){
		//int qGroup = Integer.valueOf(catForQA).intValue();
		List<QAns> qAnsList =  (List<QAns>) qAnsDAO.listQAnsIndex();
		return qAnsList ;
	}

	public List<DocHierarchy> getDocHierarchy(String name){
		
		List<DocHierarchy> docHierarchyList = (List<DocHierarchy>) docHierarchyDAO.listForOrder(name);
		return docHierarchyList ;
	}
	
	public List<DocHierarchy> getDocHierarchyFirst(){
		
		List<DocHierarchy> docHierarchyList = (List<DocHierarchy>) docHierarchyDAO.listForFirst();
		return docHierarchyList ;
	}
	
	public List<DocHierarchy> getDocHierarchyAll(){
		
		List<DocHierarchy> docHierarchyList = (List<DocHierarchy>) docHierarchyDAO.listDocHierarchy() ;
		return docHierarchyList ;
		
	}
	
	public DocDetail getDocData(String name){
		
		DocDetail docDetail = (DocDetail) docDetailDAO.docDetailData(name) ;
		
		return docDetail;
	}
	
	public List<DocLink> getDocLinkList(int docLinkId){
		List<DocLink> docLink = (List<DocLink>) docLinkDAO.listDocLinkOpt(docLinkId);
		return docLink;
	}
	public  List<DocDetail> getDocDetailAll(){
		
		List<DocDetail> docHierarchyList = (List<DocDetail>) docDetailDAO.listDocDetailAll() ;
		return docHierarchyList ;
		
	}
	
	public  List<DocHierarchy> getDoclistForView(){
		
		List<DocHierarchy> docHierarchyList = (List<DocHierarchy>) docHierarchyDAO.listForView() ;
		return docHierarchyList ;
		
	}
	
	public  List<DocHierarchy> getDoclistForViewHi(){
		
		List<DocHierarchy> docHierarchyList = (List<DocHierarchy>) docHierarchyDAO.listForNotHaveData() ;
		return docHierarchyList ;
		
	}

}
