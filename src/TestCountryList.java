/**
 *  Tests the CountryList class by creating multiple objects of type CountryNode.
 *  Creates one object of type CSVReader class, which reads input from a CSV file. Uses
 *  the attributes stored in CSVReader object to create objects of type Country class.
 *  Then adds the newest country read into the list
 *
 * @author Foothill College, [YOUR NAME HERE]
 */


import java.util.Random;
import java.util.Scanner;


public class TestCountryList
{
	/**
	 * Builds a list of countries to debug.
	 */
	private void debugListOfCountries(Country [] allCountries)
	{
		// TODO: Use this method to debug a subset of the input file data.
		// Note: The implementation of method is optional.
		//       The purpose is to help you debug
		CountryList list = new CountryList();
		//list.getIndex(0);
		if(list.getIndex(0) == null) {
			System.out.println("null");
		}
		list.add(allCountries[0]);
		System.out.println(allCountries[0]);
		System.out.println(list.getIndex(0));
		
		
		System.out.println(list.contains(allCountries[0]));
		
		list.add(allCountries[1]);
		System.out.println(allCountries[1]);
		System.out.println(list.getIndex(1));
		
		System.out.println(list.contains(allCountries[1]));
		list.add(allCountries[2]);
		System.out.println(allCountries[2]);
		System.out.println(list.getIndex(2));
		
		String s = "example 1";
		Country country = new Country(s);
		System.out.print("country is: ");
		System.out.println(country.getName()==null);
		list.add(country);
		System.out.println(list.contains(country));
		
		//System.out.println(list.getIndex(1));
	}

	/**
	 * Builds a random list of countries.
	 * @param allCountries      An array of Country objects
	 */
	private void testRandomListOfCountries(Country [] allCountries)
	{
		
		// Prompts the user for the number of countries they want to add to the list.
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many countries do you want to add to the list?");
		int requestedSize = Integer.parseInt( keyboard.nextLine() );

		// Build the list out of a random selection of countries.
		Random random = new Random();
		CountryList selectedCountries = new CountryList();
		for (int i = 0; i < requestedSize; i++)
		{
			// Selects a random index of the Country data array
			int selectedIndex = random.nextInt(allCountries.length);

			// TODO: Define the add() method in class such that it adds the randomly
			// selected Country to the end of the list.
			selectedCountries.add(allCountries[selectedIndex]);
		
		}


		// TODO: Override the toString() method such that it traverses the list of nodes
		//       and prints every element in the list.
		// Note: To debug your list, do not comment this line out
		System.out.println("List of countries: " + selectedCountries);


		// Note: To debug specific elements of your list, do not comment this line out
		int index = 0;
		Country first = selectedCountries.getIndex(index);
		index = selectedCountries.size()/2;
		Country middle = selectedCountries.getIndex(index);
		index = selectedCountries.size()-1;
		Country last = selectedCountries.getIndex(index);

		// Print out the results from above getIndex operations
		System.out.println ("first: " + first);
		System.out.println ("middle: " + middle);
		System.out.println ("last: " + last);
		
		// Test cases
		int indextest = 2;
		Country firsttest = selectedCountries.getIndex(indextest);
		indextest = selectedCountries.size()/2;
		Country middletest = selectedCountries.getIndex(indextest);
		indextest = selectedCountries.size()-1;
		Country lasttest = selectedCountries.getIndex(indextest);

		// Print out the results from above getIndex operations
		System.out.println ("first Test : " + firsttest);
		System.out.println ("middle Test : " + middletest);
		System.out.println ("last Test : " + lasttest);


		// Check if the name of a country is in the list.
		// If the country is found, print the details.
		// Otherwise output not found.
		System.out.println("\nWhat country do you want to search for?");
		String countryNameToFind = keyboard.nextLine();

		// TODO: Define a Country constructor which will create a dummy Country object
		//       that only holds the name of the Country.
		// NOTE: In order to call contains in our Linked List,
		//       we need to define a constructor for our Country class
		//       that takes in a String. This Country object will have
		//       no other useful information, specifically no SubscriptionYears.
		Country tmpCountry = new Country(countryNameToFind);
		Country foundCountry = selectedCountries.contains(tmpCountry);
		if (foundCountry != null)
		{
			System.out.println("Country " + countryNameToFind + " found with details:\n" + foundCountry);
		}
		else
		{
			System.out.println("Country " + countryNameToFind + " not found.");
		}   

		// Extra Credit Opportunity
		// TODO: For full credit, include test cases for the extra credit portion.
		//
		// TODO: At minimum include a test for each case of inserting to the 
		//      front, middle and end of the list.
		//
		// Note: To debug specific elements of your list, do not comment this line out
				

	}

	/**
	 * Uses a CSV to parse a CSV file.
	 * Adds the data for each country to an array of Country objects.
	 * Adds a random selection of countries to a CountryList object.
	 */
	public static void main(String[] args)
	{
		
		
		// TODO: Make sure to test yoru implementation with different input data files.
		final String FILENAME = "resources/cellular.csv";	// Directory path for Mac OS X
		//final String FILENAME = "resources\\cellular.csv";	// Directory path for Windows OS (i.e. Operating System)

		// Note: Comment this line in if you want to debug a subset of the input file data.
		//final int NUM_COUNTRIES_TO_TEST = 3;			    


		// Parse the CSV data file.
		CSVReader parser = new CSVReader(FILENAME);
		String [] countryNames = parser.getCountryNames();
		int [] yearLabels = parser.getYearLabels();
		double [][] parsedTable = parser.getParsedTable();


		// Holds the data for all Country object read from the input data file.
		Country [] countries;

		// Initializes the to the number of entries read by CSVReader.
		countries = new Country[countryNames.length];

		// Note: If you are debugging, use this version instead to limit the number of countries
		// countries = new Country[NUM_COUNTRIES_TO_TEST];

		Country current;

		// Go through each country name parsed from the CSV file.
		for (int countryIndex = 0; countryIndex < countries.length; countryIndex++)
		{
			int numberOfYears = yearLabels.length;   // OR numberOfYears = dataTable[countryIndex].length;

			// Create a Country object.
			current = new Country(countryNames[countryIndex], numberOfYears);

			// Go through each year of cellular data read from the CSV file.
			for (int yearIndex = 0; yearIndex < numberOfYears; yearIndex++)
			{
				double [] allSubscriptions = parsedTable[countryIndex];
				double countryData = allSubscriptions[yearIndex];
				current.addSubscriptionYear(yearLabels[yearIndex], countryData);
			}

			// Add the newly created country to the 1D array.
			countries[countryIndex] = current;
		}

		// Creates an object of our current application, for testing purposes.
		TestCountryList application = new TestCountryList();

		// Note: Initially, to test your output you may hard code the number of 
		//       countries added, and the array positions selected.
		//		 However, make sure to comment this out before submitting your work.
		//application.debugListOfCountries(countries);

		
		// Tests the CountryLinkedList class by adding a random number of entries
		// from the array of Country objects.
		application.testRandomListOfCountries(countries);

		// Flush the error stream.
		System.err.flush();

		System.out.println("\nDone with TestCountryList.");
	}
}