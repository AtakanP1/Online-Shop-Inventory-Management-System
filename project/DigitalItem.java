package atakan;


public class DigitalItem extends Item{
double diskSpace;

public DigitalItem(String itemName,double itemPrice,int itemQuantity,double diskSpace,Provider provider,String type){
	super(itemName,itemPrice,itemQuantity,provider,type);
	this.diskSpace=diskSpace;
}

@Override
public void displayServiceInfo() {
System.out.println("Item: "+getName() +"\nPrice: "+itemPrice+"\nQuantity: "+itemQuantity+"\nProvider: "+getprovider().getName()+"\nProvider Contact: "+
		getprovider().getphoneNumber()+"\ndiskspace"+diskSpace+"\n");

}
@Override
public double calculateVolumetricWeight() {
	return 0;
}
@Override 
 public double calculateShippingFee() {
	return 0;
}
@Override
public Provider getprovider() {
	return provider;
}
@Override
public String getName(){
	return itemName;

}
@Override
public void updatePrice(double value) {
	itemPrice=value;
}
@Override
public void updateQuantity(int purchasedQuantity){
    itemQuantity=itemQuantity-purchasedQuantity;
}
@Override
public int getQuantity() {
	return itemQuantity;
}
@Override
public double getPrice() {
	return itemPrice;
}
@Override 
public double calculateTotalWorth() {
	return itemPrice*itemQuantity;
}



}







