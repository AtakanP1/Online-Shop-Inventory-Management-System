package atakan;

public class FoodDelivery implements Service {

private String foodName,type,restaurantName;
private double mealPrice;
private int foodcount;

public FoodDelivery(String foodName,String restaurantName,double mealPrice,int foodcount,String type) {
	 this.foodName=foodName;
     this.restaurantName=restaurantName;
	 this.mealPrice=mealPrice;
	 this.foodcount=foodcount;
	 this.type=type;
}

@Override
public String getServiceType() {
 return type;
}
@Override
public double calculateService() {
	return(mealPrice*foodcount)+calculateShippingFee();
}
@Override
public void displayServiceInfo() {
	System.out.println("Food Name"+ foodName +"\nRestaurant Name:"+restaurantName+"\nMeal Price:"+mealPrice+"\nFood Count"+foodcount+"\n");
	
	
}
@Override
public double calculateShippingFee() {
	return 5.0;
}
public String getName() {
	return foodName;
}
public double getPrice() {
	return mealPrice;
}





}
