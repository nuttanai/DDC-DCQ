package namedcq.servicefordata;

import java.util.List;

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

public interface OutputDataService {

	public abstract List<Province> getProvince( String province );
	
	public abstract Province getProvinceData( String province );
	
	public abstract List<ActivityHierarchy> getActivityHierarchyList();
	
	public abstract List<ActivityHierarchy> getActivityHierarchyListOption(String ActivityHierarchyName);
	
	public abstract List<ActivityDataMain> getActivityDataMainList();
	
	public abstract ActivityDataSet getActivityDataMainSet();
	
	public abstract ActivityCall getActivityCall();
	
	public abstract List<News> getNews();
	
	public abstract List<QCat> getListQCat();
	
//	public abstract List<DocBigData> getBigDataList(String name);
	
	public abstract DocBigData getBigData(String name);
	
	public abstract List<QAns> getQAnsList();
	
	public abstract List<QAns> getQAnsListIndex();
	
	public abstract List<QAns> getQAns(String catForQA);
	
	public abstract List<DocHierarchy> getDocHierarchyFirst();
	
	public abstract List<DocHierarchy> getDocHierarchyAll();
	
	public abstract List<DocHierarchy> getDocHierarchy(String name);
	
	public abstract DocDetail getDocData(String name);
	
	public abstract List<DocDetail> getDocDetailAll();
	
	public abstract List<DocLink> getDocLinkList(int docLinkId);
	
	public abstract List<DocHierarchy> getDoclistForView();
	
	public abstract List<DocHierarchy> getDoclistForViewHi();
	
	
}
