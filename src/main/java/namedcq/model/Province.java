package namedcq.model;

public class Province {
	
	private String provinces ; 
	private String region; 
	
	public Province(String provinces, String region) {
		super();
		this.provinces = provinces;
		this.region = region;
	}
	public Province(){
		
	}
	
	public String getProvinces() {
		return provinces;
	}
	public void setProvinces(String provinces) {
		this.provinces = provinces;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}


}
