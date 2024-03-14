package atakan;

public class Streaming implements Service{

private String category,type,title;
private double costPerDay;
private int days;

public Streaming(String title,String category,double costPerDay,int days,String type){
	this.title=title;
	this.category=category;
	this.costPerDay=costPerDay;
	this.days=days;
	this.type=type;
}



@Override
public String getServiceType() {
	return type;
}
@Override
public double calculateService() {
	return (costPerDay*days)+calculateShippingFee();
}
@Override
public void displayServiceInfo() {
	System.out.println("Title:"+ title +"\nCategory:"+category+"\nCost Per Day:"+costPerDay+"\nRental Days"+days+"\n");
}
@Override
public double calculateShippingFee() {
	return 0;
}
public double getPrice() {
	return costPerDay;
}
public String getName() {
	return title;
}



}


