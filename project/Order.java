package atakan;

public class Order implements Comparable <Order> {
	
private final Service service;
private int itemQuantity;
private int code;
private String region;
private String city;


    public Order(Service service,int itemQuantity,String region,String city,int code) {
        this.service=service;
        this.itemQuantity=itemQuantity;
        this.region=region;
        this.city=city;
        this.code=code;
    }
   
      
   public Service getService() {
    return service;
     }
   
   public String getCity() {
	   return city;
   }
   
   public double calculateOrderCost() {
	 return  ((getService().calculateService()*itemQuantity));
   }
   public int compareTo(Order otherorder) {
	   
	   return Double.compare(otherorder.getService().calculateService(),this.service.calculateService());
	   
	   
	   
	   
   }
   
   
  







}











