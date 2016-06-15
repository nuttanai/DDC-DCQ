package namedcq.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

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
import namedcq.model.SuperBigData;
import namedcq.model.User;
import namedcq.serviceforandroid.DataListService;
import namedcq.serviceforandroid.SuperSearchService;
import namedcq.servicefordata.OutputDataService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPSearchException;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchResultEntry;
import com.unboundid.ldap.sdk.SearchScope;

@RestController  
public class AndroidServiceController {

	private OutputDataService outputDataService;
	private DataListService dataListService; 
	private SuperSearchService superSearchService;
	
	@Required
	@Autowired
	public void setSuperSearchService(SuperSearchService superSearchService) {
		this.superSearchService = superSearchService;
	}
	
	@Required
	@Autowired
	public void setDataListService(DataListService dataListService) {
		this.dataListService = dataListService;
	}
	
	@Required
	@Autowired
    public void setOutputDataService(OutputDataService outputDataService) {
		this.outputDataService = outputDataService;
	}
	
	//	{"provinces":"กรุงเทพ"}
//	@RequestMapping(value="/sayHellos/{name}",method=RequestMethod.GET , produces={"application/json; charset=UTF-8"})
	@RequestMapping(value="/sayHellos",method=RequestMethod.POST , produces={"application/json; charset=UTF-8"} )
	public  String sayHellos( @RequestBody Province p ){

	    Province province = (Province) outputDataService.getProvinceData(p.getProvinces());
		return "Hi "+p.getProvinces() + province.getProvinces() ;
	}
	
	
	@RequestMapping(value="/sayHello/{name}",method=RequestMethod.GET )
	public  String sayHello( @PathVariable String name ){
		
		List<Province> province = (List<Province>) outputDataService.getProvince(name);
		//String pwds = province.get(0).getProvinces();	
		return "Hi "+name + province.get(0).getRegion();
	}
	
	
	@RequestMapping(value="/viewUser/{id}",method=RequestMethod.GET)
	public String viewUser(@PathVariable String id, Model model ){		
		User user = new User(id,id+ "name");
		List<Province> province = (List<Province>) outputDataService.getProvince(id);
		
		model.addAttribute("user", province.get(0));
		
		return "viewUser"; // ส่งไป view
	}
	/*
	@RequestMapping(value="/getUsers/{id}",method=RequestMethod.GET)
	public  Province getUsers(@PathVariable String id){
		User user = new User(id,id+ "name");
		Province provinceX = new Province("ชลบุรี","ข่าวสด กลุ่มหัวรุนแรงรัฐอิสลาม หรือ ไอเอส ได้เผยแพร่คลิปวีดีโอลงบนอินเทอร์เน็ต อ้างว่าได้สังหารโหด ด้วยการเผาทั้งเป็น เรืออากาศโท โมอัซ อัล-คาซัสเบห์ นักบินของกองทัพอากาศจอร์แดน");
		return provinceX;
	}
	*/

	@RequestMapping(value="/getUser/{id}",method=RequestMethod.GET)
	public  User getUser(@PathVariable String id){
		User user = new User(id,id+ "name");
		return user;
	}
	
	@RequestMapping(value="/getNew/{id}",method=RequestMethod.GET)
	public  Province getNew(@PathVariable String id){
		//User user = new User(id,id+ "name");
		Province provinceX = new Province("ชลบุรี","ข่าวสด กลุ่มหัวรุนแรงรัฐอิสลาม หรือ ไอเอส ได้เผยแพร่คลิปวีดีโอลงบนอินเทอร์เน็ต อ้างว่าได้สังหารโหด ด้วยการเผาทั้งเป็น เรืออากาศโท โมอัซ อัล-คาซัสเบห์ นักบินของกองทัพอากาศจอร์แดน");
		return provinceX;
	}

	@RequestMapping(value="/getActivityHierarchy/",method=RequestMethod.GET , produces={"application/json; charset=UTF-8"})
	public  List<ActivityHierarchy> getActivityHierarchy(){
		List<ActivityHierarchy> activityHierarchyList = (List<ActivityHierarchy>) outputDataService.getActivityHierarchyList();
		return activityHierarchyList;
	}
	
	@RequestMapping(value="/getActivityHierarchyOption",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public  List<ActivityHierarchy> getActivityHierarchyOption( @RequestBody ActivityHierarchy name){
	
		List<ActivityHierarchy> activityHierarchyListByOption = (List<ActivityHierarchy>) outputDataService.getActivityHierarchyListOption(name.getActivtyName());
		
		return activityHierarchyListByOption;
	}
	
	@RequestMapping(value="/getActivityDataMain",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	public  List<ActivityDataMain> getActivityDataMainList(){
	
		List<ActivityDataMain> ActivityDataMain = (List<ActivityDataMain>) outputDataService.getActivityDataMainList();
		
		return ActivityDataMain;
	}
	
	@RequestMapping(value="/getActivityDataSet",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	public  ActivityDataSet getActivityDataSet(){
	
	//	ActivityDataSet activityDataSet = new ActivityDataSet(inputDataService.getActivityDataMainSet());
		ActivityDataSet activityDataSet = new ActivityDataSet(outputDataService.getActivityDataMainList(),outputDataService.getActivityHierarchyList(),outputDataService.getActivityCall());
				
		return activityDataSet;
	}
	
	@RequestMapping(value="/getnews",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	public  List<News> getNews(){
	
		List<News> news = (List<News>) outputDataService.getNews();
		
		return news;
	}
	
	/*
	 *	@RequestMapping(value="/getActivityHierarchyOption",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public  List<ActivityHierarchy> getActivityHierarchyOption( @RequestBody ActivityHierarchy name){
	 * */
	
	@RequestMapping(value="/getDataForListView",headers = "content-type=application/json; charset=utf-8",method=RequestMethod.POST  , produces={ "application/json","text/plain", "application/* ; charset=UTF-8"})
	public  ActivityDataSet getDataForListView( @RequestBody ActivityHierarchy name){
	 
		ActivityDataSet activityDataSet = (ActivityDataSet) dataListService.getActivityDataSetForAndroid(name.getActivtyName());
		System.out.println("This is a Logggggggggggg");
		System.out.println(name.getActivtyName());
		System.out.println(name.getActivtyName());
		System.out.println(name.getActivtyName());
		System.out.println(name.getActivtyName());
		System.out.println(name.getActivtyName());
		System.out.println(name.getActivtyName());
		System.out.println(name.getActivtyName());
		System.out.println(name.getActivtyName());
		System.out.println(name.getActivtyName());
		System.out.println(name.getActivtyName());
		System.out.println("This is a Logggggggggggg");
		return activityDataSet;
	}
	
	@RequestMapping(value="/getDataForSearch",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public  List<ActivityDataMain> getDataForSearch( @RequestBody ActivityHierarchy name){
	// ยังพังอยู่
		List<ActivityDataMain> activityDataListForSearch = (List<ActivityDataMain>) superSearchService.getSearchData(name.getActivtyName());
		
		return activityDataListForSearch;
	}
	
	@RequestMapping(value="/getListData",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public DocBigData getListData( @RequestBody DocHierarchy name){
		
		DocBigData docBigData = (DocBigData) outputDataService.getBigData(name.getDocHierarchyName());
		
		return docBigData ;
		
	}
	
	@RequestMapping(value="/getListQCat",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	public List<QCat> getListQCat(){
		
		List<QCat> QCatList = (List<QCat>) outputDataService.getListQCat();
		
		return QCatList ;
		
	}
	
	@RequestMapping(value="/getListQA",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public List<QAns> getListQA( @RequestBody QAns name){
		
		//DocBigData docBigData = (DocBigData) outputDataService.getBigData(name.getDocHierarchyName());
	//	List<QAns> QAnsList = (List<QAns>) outputDataService.getListQCat(name.getqGroup()+"");
		List<QAns> QAnsList = (List<QAns>) outputDataService.getQAns(Integer.toString(name.getqGroup()));	
		return QAnsList ;
		
	}
	
	@RequestMapping(value="/getListQAIndex",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	public List<QAns> getListQAIndex(){
		
		
		List<QAns> QAnsList = (List<QAns>) outputDataService.getQAnsListIndex();	
		return QAnsList ;
		
	}
	
	@RequestMapping(value="/getListQAAll",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	public List<QAns> getListQAAll(){
		
		//DocBigData docBigData = (DocBigData) outputDataService.getBigData(name.getDocHierarchyName());
	//	List<QAns> QAnsList = (List<QAns>) outputDataService.getListQCat(name.getqGroup()+"");
		List<QAns> QAnsList = (List<QAns>) outputDataService.getQAnsList();	
		return QAnsList ;
		
	}
	
	@RequestMapping(value="/getListDocFirst",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	public List<DocHierarchy> getListDocFirst(){
		
		List<DocHierarchy> DocHierarchyListFirst = (List<DocHierarchy>) outputDataService.getDocHierarchyFirst();	
		return DocHierarchyListFirst ;
		
	}
	
	@RequestMapping(value="/getListDocAll",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	public List<DocHierarchy> getListDocAll(){
		
		List<DocHierarchy> DocHierarchyListFirst = (List<DocHierarchy>) outputDataService.getDocHierarchyAll();	
		return DocHierarchyListFirst ;
		
	}
	
	@RequestMapping(value="/getListDocDe",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	public List<DocDetail> getListDocDe(){
		
		List<DocDetail> DocHierarchyListFirst = (List<DocDetail>) outputDataService.getDocDetailAll();	
		return DocHierarchyListFirst ;
		
	}
	
	@RequestMapping(value="/getListDoc",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public List<DocHierarchy> getListDoc( @RequestBody DocHierarchy name){
		
		List<DocHierarchy> DocHierarchyListFirst = (List<DocHierarchy>) outputDataService.getDocHierarchy(name.getDocHierarchyName());	
		return DocHierarchyListFirst ;
		
	}
	
	@RequestMapping(value="/getDocDetail",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public DocDetail getDocDetail( @RequestBody DocHierarchy name){
		
		DocDetail docDetail = (DocDetail) outputDataService.getDocData(name.getDocHierarchyName());	
		return docDetail ;
		
	}
	// 	public abstract List<DocLink> getDocLinkList(int docLinkId);
	@RequestMapping(value="/getDocLink",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public List<DocLink> getDocLink( @RequestBody DocLink linkId){
		List<DocLink> docLink = (List<DocLink>) outputDataService.getDocLinkList(linkId.getDocLinkId());	
		return docLink ;
		
	}
	
	@RequestMapping(value="/getQA",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	public List<QAns> getQA(){
		List<QAns> docLink = (List<QAns>) outputDataService.getQAnsList();	
		return docLink ;
		
	}

	@RequestMapping(value="/getSearchANS",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public List<QAns> getSearchANS( @RequestBody QAns target){
		List<QAns> resSearch = (List<QAns>) superSearchService.getSearchQAns(target.getQuestions());	
		return resSearch ;
		
	}
	
	@RequestMapping(value="/getSearchDoc",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public List<DocDetail> getSearchDoc( @RequestBody DocDetail target){
		List<DocDetail> resSearch = (List<DocDetail>) superSearchService.getSearchDataDoc(target.getDocDetail());	
		return resSearch ;
		
	}
	@RequestMapping(value="/getSearchQCat",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public List<QCat> getSearchQCat( @RequestBody QCat target){
		List<QCat> resSearch = (List<QCat>) superSearchService.getSearchQCat(target.getqCat());	
		return resSearch ;
		
	}
	
	@RequestMapping(value="/getListDocAllView",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	public List<DocHierarchy> getListDocAllView(){
		
		List<DocHierarchy> DocHierarchyListFirst = (List<DocHierarchy>) outputDataService.getDoclistForView();	
		return DocHierarchyListFirst ;
		
	}
	
	@RequestMapping(value="/getListDocAllViewHi",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	public List<DocHierarchy> getListDocAllViewHi(){
		
		List<DocHierarchy> DocHierarchyListFirst = (List<DocHierarchy>) outputDataService.getDoclistForViewHi();	
		return DocHierarchyListFirst ;
		
	}
	
	@RequestMapping(value="/getSuperSearchDDC",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public List<SuperBigData> getSuperSearchDDC(@RequestBody QCat target){

		List<SuperBigData> DocHierarchyListFirst = (List<SuperBigData>) superSearchService.getSuperSearch(target.getqCat())  ;	
		return DocHierarchyListFirst ;
		
	}
	
	@RequestMapping(value="/getSuperSearchDDCX",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public List<SuperBigData> getSuperSearchDDCX(@RequestBody String target){

		List<SuperBigData> DocHierarchyListFirst = (List<SuperBigData>) superSearchService.getSuperSearch(target)  ;	
		return DocHierarchyListFirst ;
		
	}
	@RequestMapping(value="/getLdap",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	public void getLdap(){
		
		try {
			Resource resource = new ClassPathResource("http://localhost:8080/namedcq/pages/main/springldap.xml");
			BeanFactory factory = new XmlBeanFactory(resource);
			System.out.println(factory.toString() + "\n");
 
			ContactDAO ldapContact = (LDAPContactDAO)factory.getBean("ldapContact");	
 
			List contactList = ldapContact.getContactDetails("30662");
			//List contactList =ldapContact.getAllContactNames();
			//System.out.println(contactList.size());
			int count = 0;
			for( int i = 0 ; i < contactList.size(); i++){
				System.out.print("Email: " + ((ContactDTO) contactList.get(i)).getMail() + "  ");
				System.out.println("SAP: " + ((ContactDTO) contactList.get(i)).getSap());
				count++;
			}
			System.out.println("\n" + count);
 
		} catch (DataAccessException e) {
			System.out.println("Error occured " + e.getCause());
		}
		
		
		
	}
	
	public static LDAPConnection getConnection() throws LDAPException {
	    // host, port, username and password
	   return new LDAPConnection("ldap://10.4.1.82", 389, "54160403@buu.ac.th", "1j22430k1");

	}
	public static LDAPConnection getConnection1() throws LDAPException {
	    // host, port, username and password
	    return new LDAPConnection("ldap://10.4.1.82", 389, "54160403@buu.ac.th", "1j22430k1");
	}
	public static LDAPConnection getConnection2() throws LDAPException {
	    // host, port, username and password
	    return new LDAPConnection("10.5.1.80", 389, "peerasak", "12345678");
	}
	public static LDAPConnection getConnection3() throws LDAPException {
	    // host, port, username and password
	//    return new LDAPConnection("ldap://10.4.1.82", 389, "54160403@buu.ac.th", "1j22430k1");
	    return new LDAPConnection("10.5.1.80", 389, "54160403@buu.ac.th", "1j22430k1");
	}
	
	public static List<SearchResultEntry> getResults(LDAPConnection connection, String baseDN, String filter) throws LDAPSearchException {
	    SearchResult searchResult ;
	    List<SearchResultEntry> resultX = null;
	    	  try{
	    		  connection.isConnected();
	    		  searchResult = connection.search(baseDN ,SearchScope.SUB, filter );
	    		  return searchResult.getSearchEntries();	  
	    	  }catch(Exception ex){
	    		  
	    	  }    
		return resultX;	
	}
	
	@RequestMapping(value="/getDataNut",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	//public void getNut(){
	public void getDataNut(){ 	
		
		String baseDN = "ou=People,dc=buu,dc=ac,dc=th";
		String filter = "(uid=XUID)";

		LDAPConnection connection = null;
		LDAPConnection connection1 = null;
		LDAPConnection connection2 = null;
		LDAPConnection connection3 = null;
		try {
	
			connection2 = getConnection2();

			
		} catch (LDAPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}        

		return  ;
		
	}
	
	public static LDAPConnection getConnectionByUser(String user,String pass) throws LDAPException {
	   // return new LDAPConnection("10.5.1.80", 389, user+"@buu.ac.th", pass);
	    // 10.4.1.82
		 return new LDAPConnection("10.4.1.82", 389, user+"@buu.ac.th", pass);
	}
	
	@RequestMapping(value="/getDataNut1",method=RequestMethod.GET  , produces={"application/json; charset=UTF-8"})
	//public void getNut(){
	public String getDataNut1(){ 	
		
		String baseDN = "ou=People,dc=buu,dc=ac,dc=th";
		// String filter = "uid=XUID";
		String u = "54160403";
		String filter = "(saMAccountName=" + u + ")";
		
	   		String user = "54160403";
		String pass = "1j22430k1";
		
		try {
	
		
			LDAPConnection connection3 = new LDAPConnection("10.4.1.82", 389, user+"@buu.ac.th", pass);

			String str = "word <a href=\"word\">word</word>word word";
			str = str.replaceAll("word(?!([^<]+)?>)", "repl");
			
			List<SearchResultEntry> results = getResults(connection3, baseDN,filter);
			System.out.println("results:" );
		

			if(results.isEmpty()){
			 System.out.println("results: IS Null" );
			}
			
			for (SearchResultEntry e : results) {
				 System.out.println("name: IS" );
			    System.out.println("name: " + e.getAttributeValue("displayname").toString());
				System.out.println("mail: " + e.getAttributeValue("mail").toString()); 
			}
			
		} catch (LDAPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}        

		return "Good";
		
	}
	
	
	@RequestMapping(value="/loginSet",method=RequestMethod.POST  , produces={"application/json; charset=UTF-8"})
	public String loginSet(@RequestBody DocHierarchy target,@Context HttpServletRequest req){ 	
		System.out.println("usename  "+target.getDocHierarchyOwner() +"Password "+target.getDocHierarchyName());
		//System.out.println("usename"+username +"Password" +password );
		String baseDN = "ou=People,dc=buu,dc=ac,dc=th";
		String u = target.getDocHierarchyOwner();
		String filter = "(saMAccountName=" + u + ")";
		
	   	String user = u;
		String pass = target.getDocHierarchyName();
		
		try {
	
		
			LDAPConnection connection3 = new LDAPConnection("10.4.1.82", 389, user+"@buu.ac.th", pass);

			List<SearchResultEntry> results = getResults(connection3, baseDN,filter);

			if(results.isEmpty()){
			 System.out.println("results: IS Null" );
			}
			String nameToSes = null;
			for (SearchResultEntry e : results) {
				System.out.println("name: IS" );
			    System.out.println("name: " + e.getAttributeValue("displayname").toString());
				System.out.println("mail: " + e.getAttributeValue("mail").toString()); 
				nameToSes = e.getAttributeValue("displayname").toString();
			}
			 System.out.println("Ren Ses" );
			HttpSession session = req.getSession(true);
	    	Object foo = session.getAttribute("foo");
	    	if (foo!=null) {
	    		System.out.println(foo.toString());
	    	} else {
	    		foo = "bar";
	    		session.setAttribute("foo", nameToSes);
	    	}
			
			
			
		} catch (LDAPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}        

		return "Good";
		
	}
	

	
}
