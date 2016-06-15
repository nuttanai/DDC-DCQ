package namedcq.serviceforandroid;

import java.util.ArrayList;
import java.util.List;

import namedcq.dao.ActivityDataMainDAO;
import namedcq.dao.ActivityHierarchyDAO;
import namedcq.dao.DocDetailDAO;
import namedcq.dao.NewsDAO;
import namedcq.dao.ProvinceDAO;
import namedcq.dao.QAnsDAO;
import namedcq.dao.QCatDAO;
import namedcq.model.ActivityDataMain;
import namedcq.model.DocDetail;
import namedcq.model.QAns;
import namedcq.model.QCat;
import namedcq.model.SuperBigData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class SuperSearchServiceImp implements SuperSearchService {
	
	private ProvinceDAO provinceDAO;
	private ActivityHierarchyDAO activityHierarchyDAO;
	private ActivityDataMainDAO activityDataMainDAO;
	private NewsDAO newsDAO; 
	private QAnsDAO qAnsDAO;
	private DocDetailDAO docDetailDAO;
	private QCatDAO qCatDAO;
	
	
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
	public void setqAnsDAO(QAnsDAO qAnsDAO) {
		this.qAnsDAO = qAnsDAO;
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
	
	
	public List<ActivityDataMain> getSearchData(String kerForSearch){
		
		List<ActivityDataMain> targetActivityDataMainList = (List<ActivityDataMain>) activityDataMainDAO.getListActivtyDataMainForSearch(kerForSearch);
		
		return targetActivityDataMainList;
	}
	
	public List<QAns> getSearchQAns(String kerForSearch){
		List<QAns> targetData = (List<QAns>) qAnsDAO.listQAnsSearch(kerForSearch);
		return targetData;
		
	}
	
	public List<DocDetail> getSearchDataDoc(String kerForSearch){
		List<DocDetail> target = (List<DocDetail>) docDetailDAO.listDocDetailSearch(kerForSearch);
		return target;
	}
	
	public List<QCat> getSearchQCat(String kerForSearch){
		List<QCat> target = (List<QCat>) qCatDAO.searchListQCat(kerForSearch);
		return target;
	}
	
	public List<SuperBigData> getSuperSearch(String kerForSearch){
		List<DocDetail> target = (List<DocDetail>) docDetailDAO.listDocDetailSearch(kerForSearch);
		List<QAns> targetData = (List<QAns>) qAnsDAO.listQAnsSearch(kerForSearch);
		List<SuperBigData>  tar = new ArrayList<SuperBigData>();
		

		for(int index = 0;index<target.size();index++){
			SuperBigData sbdTarget = new  SuperBigData();
			sbdTarget.setDocDetailId(target.get(index).getDocDetailId());
			sbdTarget.setDocDetail(target.get(index).getDocDetail());
			sbdTarget.setDocHowTo(target.get(index).getDocHowTo());
			sbdTarget.setDatatype(0);			
			tar.add(index, sbdTarget);
		
		}
		
		int res = tar.size() -1;
	
		for(int index = 0;index<targetData.size();index++){
			SuperBigData sbdTarget = new  SuperBigData();
			sbdTarget.setQid(targetData.get(index).getQid());
			sbdTarget.setQuestions(targetData.get(index).getQuestions());
			sbdTarget.setAnswers(targetData.get(index).getAnswers());
			sbdTarget.setOwnQ(targetData.get(index).getOwnQ());
			sbdTarget.setOwnA(targetData.get(index).getOwnA());
			sbdTarget.setqGroup(targetData.get(index).getqGroup());
			sbdTarget.setDatatype(1);
		
			tar.add(res++, sbdTarget);
			
		
		}
/*	 debug loop	
		for(int index = 0;index<tar.size();index++){
			System.out.println("Index"+ index);
			System.out.println("tar1  "+ tar.get(index).getQuestions() );
			System.out.println("tar2  "+ tar.get(index).getDocDetail() );
		}
	*/	
		
		return tar;
	}

	

}
