package namedcq.model;

import java.util.List;

public class DocBigData {
	
	DocDetail docDetail;
	List<DocHierarchy> docHierarchy;
	
	public DocBigData(DocDetail docDetailX, List<DocHierarchy> docHierarchyX){
		super();
		this.docDetail = docDetailX;
		this.docHierarchy = (List<DocHierarchy>) docHierarchyX;
	}
	
	public DocDetail getDocDetail() {
		return docDetail;
	}
	public void setDocDetail(DocDetail docDetail) {
		this.docDetail = docDetail;
	}
	public List<DocHierarchy> getDocHierarchy() {
		return docHierarchy;
	}
	public void setDocHierarchy(List<DocHierarchy> docHierarchy) {
		this.docHierarchy = docHierarchy;
	}
	
}
