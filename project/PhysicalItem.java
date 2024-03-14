package atakan;

public class PhysicalItem extends Item{
	double width,length,height;

public PhysicalItem(String itemName,double itemPrice,int itemQuantity,int width,int length,int height,Provider provider,String type) {
	super(itemName,itemPrice,itemQuantity,provider,type);
	this.width=width;
	this.length=length;
	this.height=height;
}

@Override
public void displayServiceInfo() {
System.out.println("Item: "+ getName() +"\nPrice: "+itemPrice+"\nQuantity: "+itemQuantity+"\nProvider: "+getprovider().getName()+"\nProvider Contact: "+
		getprovider().getphoneNumber()+"\nwidth:"+width+"  "+"length"+length+"  " + "height"+height+"\n");
}



public double getWidth() {
	return width;
}
public double getLength() {
	return length;
}
public double getHeight() {
	return height;
}

@Override
public double calculateVolumetricWeight() {
	return((length*width*height)/5000);
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
public int getQuantity() {
	return itemQuantity;
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
public double getPrice() {
	return itemPrice;
}
@Override 
public double calculateTotalWorth() {
	return itemPrice*itemQuantity;
}

@Override
public double calculateShippingFee () {
	if(calculateVolumetricWeight()<1) {
		return (itemPrice*calculateVolumetricWeight()*0.1);
	}
	else if(calculateVolumetricWeight()<2) {
		return (itemPrice*calculateVolumetricWeight()*0.25);
	}
	else if(calculateVolumetricWeight()<5) {
		return (itemPrice*calculateVolumetricWeight()*0.35);
	}
	  else  return (itemPrice*calculateVolumetricWeight()*0.5);
	

}

	




}
