package atakan;

public class Provider {
      String pName;
      int countryCode,areaCode,phoneNumber;
	public Provider(String pName,int countryCode,int areaCode,int phoneNumber) {
		this.countryCode=countryCode;
		this.areaCode=areaCode;
		this.phoneNumber=phoneNumber;
		this.pName=pName;
	}
	
	public String getName() {
		return pName;
	}
	public int getcountryCode() {
		return countryCode;
	}
	public int getareaCode() {
		return areaCode;
	}
	public int getphoneNumber() {
		return phoneNumber;
	}
	
	
	
	
}
