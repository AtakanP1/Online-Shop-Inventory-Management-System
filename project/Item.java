package atakan;

public abstract class Item implements Service{
	protected double itemPrice;
	protected int itemQuantity;
	protected Provider provider;
	protected String type,itemName;
	
public Item(String itemName,double itemPrice,int itemQuantity,Provider provider,String type){
	this.itemName=itemName;
	this.itemPrice=itemPrice;
	this.itemQuantity=itemQuantity;
	this.provider=provider;
	this.type=type;
}
	
	
@Override
public String getServiceType() {
return type;
}

@Override
public double calculateService(){
  	return itemPrice+calculateShippingFee();
 }

@Override
public abstract void displayServiceInfo();
@Override
public abstract double calculateShippingFee();


public abstract Provider getprovider();
public abstract String getName();
public abstract int getQuantity();
public abstract double getPrice();
public abstract double calculateVolumetricWeight();
public abstract void updatePrice(double parameter);
public abstract double calculateTotalWorth();
public abstract void updateQuantity(int parameter);







}
	
	
	
	
	

