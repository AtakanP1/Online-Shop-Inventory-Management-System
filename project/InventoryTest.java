package atakan;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Scanner;
import java.util.EnumSet;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class InventoryTest {
	
public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		 String itemName,type,pName,title,category,restaurantname,foodname,region,city;
		 double itemPrice,diskSpace,ratio,limit,costperday,mealprice;
		 int itemQuantity,countryCode,areaCode,phoneNum,width,height,length,days,foodcount,postcode;
		 
	
		 
	
		 ArrayList<Service> ServiceList = new ArrayList<>();
		 ArrayList<Provider> ProviderList = new ArrayList<>();
		 ArrayList<Order> OrderList = new ArrayList<>();
		 ArrayList<Service> ShipList = new ArrayList<>();
	
		
		while(true) {
			System.out.println("INVENTORY MENU:\n");
			System.out.println("1. Add a New Service\n");
			System.out.println("2. Display all Services\n");
			System.out.println("3. Display the Total Number of Items\n");
			System.out.println("4. Calculate the Total Worth of the Inventory\n");
			System.out.println("5. Increase price of specific type\n");
			System.out.println("6. List servies with shipping fee above a limit\n");
			System.out.println("7 Remove Order For a Specific City");
			System.out.println("CUSTOMER MENU:\n");
			for(Menu menu : Menu.values()) 
				System.out.printf("%s\n",menu.getmessage());
			
			
		
			
			
			try {
				System.out.println("Enter your choice: ");
				int option=input.nextInt();
				if(option<1 || option>10) {
					throw new NumberFormatException("You entered an invalid menu option. Enter again.");
				}
				
			
			
		if(option==1) {
			int subopt;
			System.out.println("1. Item(Physical/Digital)\n");
			System.out.println("2. Streaming\n");
			System.out.println("3. Food Delivery\n");
			subopt=input.nextInt();
			if(subopt==1) {
			System.out.println("Item's Information: \n");
			System.out.println("Enter item name: \n");
			input.nextLine();
			itemName=input.nextLine();
			System.out.println("Enter item price:\n");
			itemPrice=input.nextDouble();
			input.nextLine();
			System.out.println("Enter item quantity: \n");
			itemQuantity=input.nextInt();
			input.nextLine();
			System.out.println("Provider's Information: \n");
			System.out.println("Enter provider name: \n");
			pName=input.nextLine();
			System.out.println("Enter country code: \n");
			countryCode=input.nextInt();
			input.nextLine();
			System.out.println("Enter area code: \n");
			areaCode=input.nextInt();
			input.nextLine();
			System.out.println("Enter phone number: \n");
			phoneNum=input.nextInt();
			input.nextLine();
			Provider myprov=new Provider(pName,countryCode,areaCode,phoneNum);
			ProviderList.add(myprov);
			System.out.println("Physical or Digital Item: \n");
			type=input.nextLine();
			if(type.equals("Physical")) {
				System.out.println("Enter width: \n");
				width=input.nextInt();
				input.nextLine();
				System.out.println("Enter length: \n");
				length=input.nextInt();
				input.nextLine();
				System.out.println("Enter height: \n");
				height=input.nextInt();
				input.nextLine();
				ServiceList.add(new PhysicalItem(itemName,itemPrice,itemQuantity,width,length,height,myprov,"Physical"));
				System.out.println("Physical Item added successfully");
				}
			if(type.equals("Digital")){
				System.out.println("disk space: \n");
				diskSpace=input.nextDouble();
				ServiceList.add(new DigitalItem(itemName,itemPrice,itemQuantity,diskSpace,myprov,"Digital"));
				System.out.println("Digital Item added successfully");
			  }
			}
			if(subopt==2) {
				System.out.println("Streaming Information: \n");
				System.out.println("Enter title: \n");
				input.nextLine();
				title=input.nextLine();
				System.out.println("Enter category: \n");
				category=input.nextLine();
				System.out.println("Enter cost per day: \n");
				costperday=input.nextDouble();
				input.nextLine();
				System.out.println("Enter days: \n");
				days=input.nextInt();
				input.nextLine();
				ServiceList.add(new Streaming(title,category,costperday,days,"Streaming"));
				System.out.println("Streaming added successfully");
				
				}
			
			if(subopt==3) {
				System.out.println("Food Delivery Information: \n");
				System.out.println("Enter food name: \n");
				input.nextLine();
				foodname=input.nextLine();
				System.out.println("Enter restaurant name: \n");
				restaurantname=input.nextLine();
				System.out.println("Enter meal price: \n");
				mealprice=input.nextDouble();
				input.nextLine();
				System.out.println("Enter food count: \n");
				foodcount=input.nextInt();
				input.nextLine();
				ServiceList.add(new FoodDelivery(foodname,restaurantname,mealprice,foodcount,"FoodDelivery"));
				System.out.println("Food Delivery added successfully");
				
			}
		}	
		
		
			if(option==2) {
				for(Service service: ServiceList) {
					service.displayServiceInfo();
				}
			}
			
			if(option==3) {
			System.out.println("Total number of items: "+ServiceList.size());
			}
			
			if(option==4) {
				for(Service service : ServiceList) {
					if(service instanceof Item) {
						Item currentItem=(Item) service;
					System.out.println("Total worth of Service "+currentItem.getServiceType() +"  $"+currentItem.calculateTotalWorth());
				}
				else System.out.println("Total worth of Service "+service.getServiceType() +"  $"+service.calculateService());	
			}
		}
			if(option==5) {
				System.out.println("Which type of items will be raised in price?: ");
				input.nextLine();
				type=input.nextLine();
				System.out.println("How much wil the raise ratio(%) be?: ");
				ratio=input.nextDouble();
				input.nextLine();
				ListIterator<Service> iterator=ServiceList.listIterator();
				boolean found=false;
				while(iterator.hasNext()) {
					Service currentService=iterator.next();
					if(currentService instanceof Item) {
						Item currentItem=(Item) currentService;
						if(currentItem.getServiceType().equals(type)) {
							double newPrice=currentItem.getPrice()+currentItem.getPrice()*ratio/100;
							currentItem.updatePrice(newPrice);
							found=true;
							
						}
					}
					
					
				}
				if(found) System.out.print("The raise ratio was applied to " +type + " items\n");
				else System.out.println("The service could not found in inventory");
		       	
			}
			if(option==6) {
				System.out.println("Enter a limit: ");
				limit=input.nextDouble();
				input.nextLine();
				ListIterator<Service> iterator=ServiceList.listIterator();
				while(iterator.hasNext()) {
					Service currentService=iterator.next();
					if(currentService.calculateShippingFee()>limit) {
						ShipList.add(currentService);
					}
				}
				
				if(ShipList.isEmpty()) System.out.println("There is no service with a shipping fee over this limit.");
				else {
			    ListIterator<Service> iterator2=ShipList.listIterator();
			    System.out.printf("Services with shipping fees over %f:\n",limit);
				while(iterator2.hasNext()) {
					Service shipping=iterator2.next();
					System.out.printf("Service: %s, Shipping Fee: %f\n",shipping.getServiceType(),shipping.calculateShippingFee());
				}
				
				
			}
		}
			if(option==7) {
				System.out.println("Type a city name to remove orders in a specific city");	
				input.nextLine();
				city=input.nextLine();
				ListIterator <Order> iterator=OrderList.listIterator();
				boolean found=false;
				while(iterator.hasNext()) {
					Order myord=iterator.next();
					if(myord.getCity().equals(city)) {
						iterator.remove();
						 found=true;
					}
				}
				if(found) System.out.printf("The order for %s was deleted successfuly\n",city);
				else System.out.printf("There are no orders places for %s\n",city);
			}
			
			if(option==8) {
				boolean Itemfound=false;
				System.out.println("Enter the item name you want to order: ");
				input.nextLine();
				itemName=input.nextLine();
				for(Service service:ServiceList) {
					if(service.getName().equals(itemName)){
						Itemfound=true;
						break;
					}
				}
				if(!Itemfound) {
					throw new NoSuchElementException("The item you are trying to order is not in inventory. Please select another item.");
				}
				System.out.println("Enter the quantity:\n ");
				itemQuantity=input.nextInt();
				input.nextLine();
				for(Service service:ServiceList) {
					if(service instanceof Item) {
						Item currentItem= (Item) service;
						if(currentItem.getQuantity()<itemQuantity) {
							throw new NoSuchElementException("The item you are trying to order is not in inventory. Please select another item.");
						}
						
					}
				}
				System.out.println("Enter the destination region:\n ");
				region=input.nextLine();
				System.out.println("Enter the destination city:\n ");
				city=input.nextLine();
				System.out.println("Enter the post code:\n ");
				postcode=input.nextInt();
				input.nextLine();
				for(Service service: ServiceList) {
					
					
					if(service instanceof Item) {
						Item currentItem = (Item) service;
						if(currentItem.getName().equals(itemName) && currentItem.getQuantity()>=itemQuantity) {
							currentItem.updateQuantity(itemQuantity);
							OrderList.add(new Order(currentItem,itemQuantity,region,city,postcode));
							System.out.println("Order has been placed");
						}
					}
					else if(service instanceof Streaming) {
						Streaming currentStream = (Streaming) service;
						if (currentStream.getName().equals(itemName)) {
						OrderList.add(new Order(currentStream,itemQuantity,region,city,postcode));
						System.out.println("Order has been placed");
					}
				}
				   else if(service instanceof FoodDelivery) {
						FoodDelivery currentFood = (FoodDelivery) service;
						if (currentFood.getName().equals(itemName)) {
						OrderList.add(new Order(currentFood,itemQuantity,region,city,postcode));
						System.out.println("Order has been placed");
					}
				}
					
						
			}
		}
			
			if(option==9) {
				Collections.sort(OrderList,Collections.reverseOrder());
				for(Order myord: OrderList) {
		if(myord.getService() instanceof Item) {
			System.out.println("The total cost of " + ((Item) myord.getService()).getName() + "order is $" + myord.calculateOrderCost());
			
		}
		else if(myord.getService() instanceof Streaming) {
		System.out.println("The total cost of " + ((Streaming) myord.getService()).getName() + "order is $" + myord.calculateOrderCost());
		}
		else if(myord.getService() instanceof FoodDelivery) {
		System.out.println("The total cost of " + ((FoodDelivery) myord.getService()).getName() + "order is $" + myord.calculateOrderCost());
		}
					
    } 
}
				
				
			
				if(option==10) {
				System.out.println("Exiting... Goodbye!");
				System.exit(0);
				
			}
		
		
		}
			
		catch(NumberFormatException e) {
			System.err.println(e.getMessage());
		}
			catch(InputMismatchException e) {
				System.err.println("Please valid input");
			}
			catch(NoSuchElementException e) {
				System.err.println(e.getMessage());
			}
			
			
			
     }
  }
}	

		

