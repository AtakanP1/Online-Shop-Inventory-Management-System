package atakan;

public enum Menu {
 Menu1("8. Add an order"),
 Menu2("9. Calculate order cost in Descending Manner"),
 Menu3("10. Exit");
 private final String message;
 
 Menu(String message){
	 this.message=message;
 }
 
 public String getmessage() {
	 return message;
 }
           
         
 
	
	
}
