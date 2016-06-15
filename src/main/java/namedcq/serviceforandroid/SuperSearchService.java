package namedcq.serviceforandroid;

import java.util.List;

import namedcq.model.ActivityDataMain;
import namedcq.model.DocDetail;
import namedcq.model.QAns;
import namedcq.model.QCat;
import namedcq.model.SuperBigData;

public interface SuperSearchService {

	public abstract List<ActivityDataMain> getSearchData(String kerForSearch);
	public abstract List<QAns> getSearchQAns(String kerForSearch);
	public abstract List<DocDetail> getSearchDataDoc(String kerForSearch);
	public abstract List<QCat> getSearchQCat(String kerForSearch);
	public abstract List<SuperBigData> getSuperSearch(String kerForSearch);
		
}

