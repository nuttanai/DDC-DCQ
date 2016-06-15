package namedcq.servicefordata;

import namedcq.dao.ActivityCallDAO;
import namedcq.dao.ActivityDataMainDAO;
import namedcq.dao.ActivityHierarchyDAO;
import namedcq.dao.DocDetailDAO;
import namedcq.dao.DocHierarchyDAO;
import namedcq.dao.DocLinkDAO;
import namedcq.dao.NewsDAO;
import namedcq.dao.ProvinceDAO;
import namedcq.dao.QAnsDAO;
import namedcq.dao.QCatDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class InputDataServiceImp implements InputDataService  {
	
	private ProvinceDAO provinceDAO;
	private ActivityHierarchyDAO activityHierarchyDAO;
	private ActivityDataMainDAO activityDataMainDAO;
	private NewsDAO newsDAO; 
	private ActivityCallDAO activityCallDAO;

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

	@Required
	@Autowired
	public void setActivityCallDAO(ActivityCallDAO activityCallDAO) {
		this.activityCallDAO = activityCallDAO;
	}

	public void insertProvinceData(String provinces, String region){
		
			provinceDAO.create(provinces, region);
		
		
	}
	
	public void insertActivityDataMain(String activtyName, String activityDetail,String activityDetailForLinkDoc,Integer activityDataHID){
		
	activityDataMainDAO.create(activtyName, activityDetail, activityDetailForLinkDoc, activityDataHID);
		
	}
	
	public void insertActivityDataHierarchy(String activtyName, String activtyHierarchyOwner, Integer activtyHierarchyOwnerID, Integer activityHierarchyForDataMain, String activityAgency){
		activityHierarchyDAO.create(activtyName, activtyHierarchyOwner, activtyHierarchyOwnerID, activityHierarchyForDataMain, activityAgency);
	}
	
	public void insertActivityCall(String activityNumber,Integer activityNumberOwnerID){
		activityCallDAO.create(activityNumber, activityNumberOwnerID);
		
	}
	
	public void insertQcat(String qCat){
		qCatDAO.create(qCat);
	}
	public void insertQans(String questions,String answers,String ownQ,String ownA ,int qGroup){
		qAnsDAO.create(questions, answers, ownQ, ownA, qGroup);
	}
	public void insertDocHierarchy(String docHierarchyName,String docHierarchyOwner,int docDetail){
		docHierarchyDAO.create(docHierarchyName, docHierarchyOwner, docDetail);
	}
	public void insertDocDetail(String docDetail,String docHowTo){
		docDetailDAO.create(docDetail, docHowTo);	
	}
	public void insertDocLink(int docLinkOwner, String docLink){
		docLinkDAO.create(docLinkOwner, docLink);
		
	}
	public void insertNews(String newsName,String newsData){
		newsDAO.create(newsName, newsData);
		
	}
	
}
