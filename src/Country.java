/**
 * This class creates new SubscriptionYear objects and saves them
 * in an array. It also takes a starting and ending year that it 
 * pulls out the average subscriptions of. 
 * 
 */


public class Country  {

	// Instance variable fields that are private to the user. 
	private String name;
	private  SubscriptionYear[] subscriptions;
	private  int c;
	
	
	/**
	 * This method is a Constructor that takes in the country name and number of years. 
	 * @param country 				The name of the country 
	 * @param numberOfYears			The integer of the number of years 
	 */
	  
	public Country(String country, int numberOfYears) {
	    this.name = country;
	    this.subscriptions = new SubscriptionYear[numberOfYears];
	    this.c = 0;
	}
	
	/**
	 *  Method that takes in the year, and a single subscription
	 *  It creates a new SubscriptionYear object and that object 
	 *  is saved in the subscriptions array
	 *  @param 	year 					Integer of the Year input. 
	 *  @param  countryData 			The passed data values specific to the country
	 */
 
	

	public void addSubscriptionYear(int year, double countryData) {
		SubscriptionYear years = new SubscriptionYear(year,countryData);
		this.subscriptions[this.c] = years; 
		this.c++;
	}
	/**
	 * Method acts as a constructor that will be used to create a temporary Country 
	 * object that has the information about the name of the Country given. 
	 */
	public Country(String countryNameToFind) { 
		this.name = countryNameToFind;
		subscriptions = new SubscriptionYear[0];
		
	}

	/**
	 * Method that takes in the starting year and the ending year
	 * returns the total number of subscriptions between the two years
	 * @param 	syear						The integer value of the starting year
	 * @param 	eyear						The integer value of the ending year
	 * @return	subscription 				The running sum of the subcriptions 
	 */
	
	public double getNumSubscriptionsForPeriod(int syear, int eyear) {
		double subscription = 0;
		
		if(syear > eyear || eyear > subscriptions[subscriptions.length-1].getYear()) {
			return -1;
		} 
		
		
	    for (int i = 0; i < subscriptions.length ; i++ ) {
	    	if (subscriptions[i].getYear() >= syear && subscriptions[i].getYear() <= eyear) {
	    		subscription = subscriptions[i].getSubscription() + subscription;
	    	} 
	    }
		return subscription;
	}
	
	/**
	 *  Method which returns a representation of the country 
	 *  @return 			The string and the subscriptions 
	 */
	// 
	public String toString()
	{
	    String result="";
	    result += "\n"+this.name;
	    
	    for( int i = 0; i<subscriptions.length; i++ ) {
	    
	        result+="\t"+ subscriptions[i].getSubscription();
	                
	    }
	    return result;
	}
	
	/**
	 * This method returns countryName
	 * @return 				The name of the country 
	 */
	 public String getName() {
	    return this.name;
	}
	 
	/**
	 * This method checks to see if the array is null
	 * @return 			If the array is empty or not. 
	 */  
	public boolean isEmpty() {
	    return (subscriptions == null);
	}
	/**
	 * This method checks to see if the array is null
	 * @return 			Clones the objects in this method  
	 */  
	public Country clone() {
		Country copy = new Country(this.name,this.subscriptions.length);
		for(int i =0; i<subscriptions.length;i++) {
			
			copy.subscriptions[i] = this.subscriptions[i].clone(); 
		}
		copy.c = this.c;
		//String copyName = this.name;
		return copy;
		
	}
	
	/**
	 * This method checks to see if the array is null
	 * @return 			Getter method for subscriptions 
	 */  
	
	public SubscriptionYear[] getSubscriptions() {
		
		return subscriptions;
	}
	
}