/**
 * This class creates methods and nodes that will be used by CountryList.
 */
public class CountryNode {
	private Country country;
	private CountryNode next;

	
	/**
	 * Constructor that takes in the object of type Country 
	 * @param 	country					The name of the country 
	 */
	public CountryNode (Country country) {
		this.country = country;
		this.next = null; 
	}
	
	/**
	 * Constructor that takes in two parameters, an object of type 
	 * Country and an object of type CountryNode.
	 * @param 	nameOfCountry				Name of the Country object 
	 * @param 	node 						A node of type CountryNode
	 */
	public CountryNode (Country nameOfCountry , CountryNode node) {
		this.next = node;
		this.country = nameOfCountry;
		
	}
	
	/**
	 * Getter method for Country 
	 * @return 		country 		The name of the country 
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * Getter method for CountryNode 
	 * @return 	next 		The next country Node 
	 */
	public CountryNode getNext() {
		return next;
	}
	
	/**
	 * Setter method for next 
	 * @param 	next 		The next country Node 
	 */
	public void setNext(CountryNode next) {
		this.next = next;
	}
	
	/**
	 * This method checks to see if the array is null
	 * @param 		c	    Sets the Country to this object of type Country
	 */  
	public void setCountry(Country c) {
		this.country = c;
	}
	
	/**
	 * This method checks to see if the array is null
	 * @return 			Clones the objects in this method  
	 */  
	public CountryNode clone() {
		
		CountryNode copy = new CountryNode(this.country.clone());
		if (copy.next != null ) {
			copy.next = this.next.clone(); 
		}
		
		return copy;
		
	}
	
	

}
