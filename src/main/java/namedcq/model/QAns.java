package namedcq.model;

public class QAns {
	int qid;
	String questions;
	String answers;
	String ownQ;
	String ownA;
	int qGroup;
	
	public int getqGroup() {
		return qGroup;
	}
	public void setqGroup(int qGroup) {
		this.qGroup = qGroup;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	public String getOwnQ() {
		return ownQ;
	}
	public void setOwnQ(String ownQ) {
		this.ownQ = ownQ;
	}
	public String getOwnA() {
		return ownA;
	}
	public void setOwnA(String ownA) {
		this.ownA = ownA;
	}

}
