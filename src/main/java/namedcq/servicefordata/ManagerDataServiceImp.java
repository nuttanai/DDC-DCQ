package namedcq.servicefordata;

import namedcq.dao.DocDetailDAO;
import namedcq.dao.DocHierarchyDAO;
import namedcq.dao.DocLinkDAO;
import namedcq.dao.NewsDAO;
import namedcq.dao.QAnsDAO;
import namedcq.dao.QCatDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class ManagerDataServiceImp implements ManagerDataService{


	private NewsDAO newsDAO; 
	private QCatDAO qCatDAO;
	private DocDetailDAO docDetailDAO;
	private DocHierarchyDAO docHierarchyDAO;
	private DocLinkDAO docLinkDAO;
	private QAnsDAO qAnsDAO;
	
	@Required
	@Autowired
	public void setNewsDAO(NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}
	
	@Required
	@Autowired
	public void setqCatDAO(QCatDAO qCatDAO) {
		this.qCatDAO = qCatDAO;
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
	public void setDocLinkDAO(DocLinkDAO docLinkDAO) {
		this.docLinkDAO = docLinkDAO;
	}
	
	@Required
	@Autowired
	public void setqAnsDAO(QAnsDAO qAnsDAO) {
		this.qAnsDAO = qAnsDAO;
	} 
	
	public void delNews(int newId ){
		newsDAO.delete(newId);
	}
	
	public  void delDocHi(int docHiId ){
		docHierarchyDAO.delete(docHiId);
	}
	public  void delDocDetail(int docDetailId ){
		docDetailDAO.delete(docDetailId);
	}
	public  void delDocLink(int docLinkId ){
		docLinkDAO.delete(docLinkId);
	}
	public  void delQCat(int qcatId ){
		qCatDAO.delete(qcatId);
	}
	public  void delQAns(int qansId ){
		qAnsDAO.delete(qansId);
	}
///////////////////////////////////////////////////
	
	public void updateNews(int newId ,String newsName,String newsData){
	newsDAO.update(newId, newsName, newsData);
		
	}
	public void updateDocHi(int docHierarchyId,String docHierarchyName,String docHierarchyOwner,int docDetail){
		docHierarchyDAO.update(docHierarchyId, docHierarchyName, docHierarchyOwner, docDetail);
	}
	public void updateDocDetail(int docDetailId , String docDetail,String docHowTo){
		docDetailDAO.update(docDetailId, docDetail, docHowTo );
	}
	public void updateDocLink(int docLinkId ,int docLinkOwner,String docLink){
		docLinkDAO.update(docLinkId, docLinkOwner, docLink);
	}
	public void updateQCat(int qCatId ,String qCat){
		qCatDAO.update(qCatId, qCat);
	}
	public void updateQAns(int qid ,String questions,String answers,String ownQ,String ownA ,int qGroup  ){
		qAnsDAO.update(qid, questions, answers, ownQ, ownA, qGroup);
	}
	
	
}
