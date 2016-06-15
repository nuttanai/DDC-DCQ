package namedcq.dao;

import java.util.List;

import namedcq.model.DocLink;

public interface DocLinkDAO {
	
	 public abstract void create(int docLinkOwner, String docLink);
	 public abstract List<DocLink> listDocLinkOpt(int docLinkId);
	 public abstract void update(int docLinkId ,int docLinkOwner,String docLink);
     public abstract void delete(int docLinkId);

}

