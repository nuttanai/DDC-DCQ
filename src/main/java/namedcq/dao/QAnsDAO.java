package namedcq.dao;

import java.util.List;

import namedcq.model.QAns;

public interface QAnsDAO {

	   public abstract void create(String questions,String answers,String ownQ,String ownA ,int qGroup) ;
	   public abstract void delete(int qid);
	   public abstract void update(int qid ,String questions,String answers,String ownQ,String ownA ,int qGroup);
	   public abstract List<QAns> listQAnsOpt(int qGroup) ;
	   public abstract List<QAns> listQAns();
	   public abstract List<QAns> listQAnsIndex();
	   public abstract List<QAns> listQAnsSearch(String key) ;
	
}
