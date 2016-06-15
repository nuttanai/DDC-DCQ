package namedcq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

import namedcq.model.ActivityCall;
import namedcq.model.ActivityDataMain;
import namedcq.model.ActivityHierarchy;
import namedcq.model.DocDetail;
import namedcq.model.DocHierarchy;
import namedcq.model.DocLink;
import namedcq.model.News;
import namedcq.model.Province;
import namedcq.model.QAns;
import namedcq.model.QCat;
import namedcq.servicefordata.InputDataService;
import namedcq.servicefordata.ManagerDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ServerServiceController {
	private InputDataService inputDataService ;
	private ManagerDataService managerDataService;
	
	
	@Required
	@Autowired
	public void setManagerDataService(ManagerDataService managerDataService) {
		this.managerDataService = managerDataService;
	}

	@Required
	@Autowired
	public void setInputDataService(InputDataService inputDataService) {
		this.inputDataService = inputDataService;
	}
	
	@RequestMapping(value="/setDataForProvince",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public @ResponseBody void getDataForListView( @RequestBody Province provincenData){
	
    inputDataService.insertProvinceData(provincenData.getProvinces(), provincenData.getRegion());
		
		return ;
	}
	
	@RequestMapping(value="/setDataForMain",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public @ResponseBody void setDataForMain( @RequestBody ActivityDataMain activityDataMain){

		 inputDataService.insertActivityDataMain(activityDataMain.getActivityName(), activityDataMain.getActivityDetail(),activityDataMain.getActivityDetailForLinkDoce(),activityDataMain.getActivityDataHID());
		
		return ;
	}
	
	@RequestMapping(value="/setDataTestToTone",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public @ResponseBody void setDataTestToTone( @RequestBody ActivityDataMain activityDataMain ,@RequestBody Province provincenData){

		 
		inputDataService.insertActivityDataMain(activityDataMain.getActivityName(), activityDataMain.getActivityDetail(),activityDataMain.getActivityDetailForLinkDoce(),activityDataMain.getActivityDataHID());
		inputDataService.insertProvinceData(provincenData.getProvinces(), provincenData.getRegion());
		
		return ;
	}
	
	@RequestMapping(value="/setDataForHierarchy",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public @ResponseBody void setDataForHierarchy( @RequestBody ActivityHierarchy activityHierarchy){

		// inputDataService.insertActivityDataMain(activityDataMain.getActivityName(), activityDataMain.getActivityDetail(),activityDataMain.getActivityDetailForLinkDoce(),activityDataMain.getActivityDataHID());
		inputDataService.insertActivityDataHierarchy(activityHierarchy.getActivtyName(), activityHierarchy.getActivtyHierarchyOwner(), activityHierarchy.getActivtyHierarchyOwnerID(), activityHierarchy.getActivityHierarchyForDataMain(),activityHierarchy.getActivityAgency());
		
		return ;
	}
	
	@RequestMapping(value="/setDataCall",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public @ResponseBody void setDataCall( @RequestBody ActivityCall activityCall){

		// inputDataService.insertActivityDataMain(activityDataMain.getActivityName(), activityDataMain.getActivityDetail(),activityDataMain.getActivityDetailForLinkDoce(),activityDataMain.getActivityDataHID());
		inputDataService.insertActivityCall(activityCall.getActivityNumber(), activityCall.getActivityNumberOwnerID());
		return ;
	}
	/*
	 *		public abstract void insertQcat(String qCat);
		public abstract void insertQans(String questions,String answers,String ownQ,String ownA ,int qGroup);
		public abstract void insertDocHierarchy(String docHierarchyName,String docHierarchyOwner,int docDetail);
		public abstract void insertDocDetail(String docDetail,String docHowTo);
		public abstract void insertDocLink(int docLinkOwner, String docLink);
	 * */
	
	
	@RequestMapping(value="/setQCat",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void setQCat( @RequestBody QCat qCatTarget){
	    inputDataService.insertQcat(qCatTarget.getqCat());
		return  ;
	} 
	
	@RequestMapping(value="/setQAns",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void setQAns( @RequestBody QAns Target){
		inputDataService.insertQans(Target.getQuestions(), Target.getAnswers(), Target.getOwnQ(), Target.getOwnA(), Target.getqGroup());
		return  ;
	} 
	
	@RequestMapping(value="/setDocHierarchy",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void setDocHierarchy( @RequestBody DocHierarchy Target){
		inputDataService.insertDocHierarchy(Target.getDocHierarchyName(), Target.getDocHierarchyOwner(), Target.getDocDetail());
		return  ;
	} 
	
	@RequestMapping(value="/setDocDetail",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void setDocDetail( @RequestBody DocDetail Target){
		inputDataService.insertDocDetail(Target.getDocDetail(), Target.getDocHowTo() );
		return  ;
	} 
	
	@RequestMapping(value="/setDocLink",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void setDocLink( @RequestBody DocLink Target){
		inputDataService.insertDocLink(Target.getDocLinkOwner(), Target.getDocLink());
		return  ;
	} 
	
	@RequestMapping(value="/setNews",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void setNews( @RequestBody News Target){
		inputDataService.insertNews(Target.getHotNewsName(), Target.getHotNews());
		return  ;
	} 
	/*
	 *	public abstract void delNews(int newId );
	public abstract void delDocHi(int docHiId );
	public abstract void delDocDetail(int docDetailId );
	public abstract void delDocLink(int docLinkId );
	public abstract void delQCat(int qcatId );
	public abstract void delQAns(int qansId );
	 * */
	
	@RequestMapping(value="/delNews",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void delNews( @RequestBody News Target){
		managerDataService.delNews(Target.getNewId());
		// inputDataService.insertNews(Target.getHotNewsName(), Target.getHotNews());
		return  ;
	} 
	@RequestMapping(value="/delDocHi",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void delDocHi( @RequestBody DocHierarchy Target){
		managerDataService.delDocHi(Target.getDocHierarchyId());
		return  ;
	} 
	@RequestMapping(value="/delDocDetail",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void delDocDetail( @RequestBody DocDetail Target){
		managerDataService.delDocDetail(Target.getDocDetailId());
		return  ;
	} 
	@RequestMapping(value="/delDocLink",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void delDocLink( @RequestBody DocLink Target){
		managerDataService.delDocLink(Target.getDocLinkId());
		return  ;
	} 
	@RequestMapping(value="/delQCat",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void delQCat( @RequestBody QCat Target){
		managerDataService.delQCat(Target.getqCatId());
		return  ;
	} 
	@RequestMapping(value="/delQAns",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void delQAns( @RequestBody QAns Target){
		managerDataService.delQAns(Target.getQid());
		return  ;
	} 
	
	/*
	 *	public abstract void updateNews(int newId ,String newsName,String newsData);
	public abstract void updateDocHi(int docHierarchyId,String docHierarchyName,String docHierarchyOwner,int docDetail);
	public abstract void updateDocDetail(int docDetailId , String docDetail,String docHowTo);
	public abstract void updateDocLink(int docLinkId ,int docLinkOwner,String docLink);
	public abstract void updateQCat(int qCatId ,String qCat);
	public abstract void updateQAns(int qid ,String questions,String answers,String ownQ,String ownA ,int qGroup ); 
	 *
	 * */
	
	@RequestMapping(value="/updateNews",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void updateNews( @RequestBody News Target){
		managerDataService.updateNews(Target.getNewId(), Target.getHotNewsName(), Target.getHotNews());
		return  ;
	} 
	@RequestMapping(value="/updateDocHi",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void updateDocHi( @RequestBody DocHierarchy Target){
		//managerDataService.delDocHi(Target.getDocHierarchyId());
		managerDataService.updateDocHi(Target.getDocHierarchyId(), Target.getDocHierarchyName(), Target.getDocHierarchyOwner(), Target.getDocDetail());
		return  ;
	} 
	@RequestMapping(value="/updateDocDetail",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void updateDocDetail( @RequestBody DocDetail Target){
		//managerDataService.delDocDetail(Target.getDocDetailId());

		managerDataService.updateDocDetail(Target.getDocDetailId(), Target.getDocDetail(), Target.getDocHowTo());
		return  ;
	} 
	@RequestMapping(value="/updateDocLink",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void updateDocLink( @RequestBody DocLink Target){
		//managerDataService.delDocLink(Target.getDocLinkId());
		managerDataService.updateDocLink(Target.getDocLinkId(), Target.getDocLinkOwner(), Target.getDocLink());
		return  ;
	} 
	@RequestMapping(value="/updateQCat",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void updateQCat( @RequestBody QCat Target){
		//managerDataService.delQCat(Target.getqCatId());
		managerDataService.updateQCat(Target.getqCatId(), Target.getqCat());
		return  ;
	} 
	@RequestMapping(value="/updateQAns",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public void updateQAns( @RequestBody QAns Target){
		//managerDataService.delQAns(Target.getQid());
	//	int sum = Integer.parseInt(Target.getqGroup()).intValue();
		int sum = Target.getqGroup();
		managerDataService.updateQAns(Target.getQid(), Target.getQuestions(), Target.getAnswers(), Target.getOwnQ(), Target.getOwnA(), Target.getqGroup());
		return  ;
	} 
	

	
	@RequestMapping(value="/setSes",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	public String setSes(@Context HttpServletRequest req){
		HttpSession session = req.getSession(true);
    	Object foo = session.getAttribute("foo");
    	if (foo!=null) {
    		System.out.println(foo.toString());
    	} else {
    		foo = "bar";
    		session.setAttribute("foo", "Nuttanai");
    	}
    	
		System.out.println(foo.toString() + "Is" + session.getAttribute("foo").toString());
		return  session.getAttribute("foo").toString();
	} 
	
	@RequestMapping(value="/setKillSes",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	public String setKillSes(@Context HttpServletRequest req){
		HttpSession session = req.getSession();
    //	Object foo = session.getAttribute("foo");
	//	session.invalidate();
//		session.isNew();
	//	Enumeration KK = session.getAttributeNames();
	//	KK.
		session.removeAttribute("foo");
		
		

		Object foo = session.getAttribute("foo");
    	if (foo!=null) {
    		System.out.println(foo.toString());
    	} else{
    		System.out.println("Is Null");
    	}
		
		return "Null";
	} 
	
	

}
