/**
 * Tests CountryList to see if clone() works properly.
 * Starts by creating a list and cloning it.
 * Then changes the data in the cloned list to test that the clone is a deep copy.
 * 
 * @author Foothill College, [YOUR NAME HERE]
 */


import java.util.Random;

public class TestCloneableCountryList
{

	private static final int LIST_SIZE = 4;

	/**
	 * Builds a list of countries to debug.
	 */
	private void debugListOfCountries(Country [] allCountries)
	{
		// TODO: The purpose is to help you debug
		// Note: The implementation of method is optional.
	}

	/**
	 * Creates a list of randomly selected countries
	 * @param allCountries      An array of Country objects
	 * @param selectionSize     Size of the list to be cloned
	 */
	private CountryList createCloneableList(Country [] allCountries, int selectionSize)
	{	
		Random random = new Random();
		CountryList selectedCountries = new CountryList();
		for (int i = 0; i < selectionSize; i++)
		{
			int selectedIndex = random.nextInt(allCountries.length);
			selectedCountries.add(allCountries[selectedIndex]);
		}

		return selectedCountries;
	}

	/**
	 * Modifies one or more countries print the updated list of countries
	 * @param listOfCountries      The list of countries to be cloned and modified.
	 */
	private CountryList testCloneableList(CountryList listOfCountries)
	{
		// TODO: Complete the implementation of this method.
		//       See suggestions in the to TODOs below.
		CountryList clonedList = (CountryList)listOfCountries.clone();


		// TODO: Select specific indices to modify.
		//       Alternatively, select a random index to modify
		Random random = new Random();
		int selectedIndex = random.nextInt(clonedList.size());

		// TODO: To debug, temporarily hard-code the selected index to an arbitrary location.
		//selectedIndex = 2;

		// a helper reference for the country before the update
		Country countryBeforeUpdate = null;

		// a helper reference for the country after the update
		Country modifiedCountry = null;


		// TODO: Modify an existing country or create a new one.
		//       Then updated the selected index in the list.
		try
		{
			// select another random index for the new test case
			selectedIndex = random.nextInt(clonedList.size());
			// get a reference to the country to be modified
			countryBeforeUpdate = clonedList.getIndex(selectedIndex);

			// TODO: make some changes to the country at the selected index...

			// TODO: Set the clonedList to the updated Country object and check that the list was updated.
			modifiedCountry = clonedList.setIndex(selectedIndex, countryBeforeUpdate);
		}
		catch (IndexOutOfBoundsException exc)
		{
			System.err.printf("ERROR: Requested index %d is out of range.");
			System.err.printf("Valid element positions are (index >= 0 && index < size()).");
		}


		// TODO: Add additional test cases, which modify the country name 
		//       and subscription information for different countries.
		try
		{
			// select another random index for the new test case
			selectedIndex = random.nextInt(listOfCountries.size());
			// get a reference to the country to be modified
			countryBeforeUpdate = clonedList.getIndex(selectedIndex);
			// get a reference to the subscriptions to be modified
			SubscriptionYear [] subscriptionsBeforeUpdate = countryBeforeUpdate.getSubscriptions();

			// TODO: make some changes to the country at the selected index...

			// TODO: Set the clonedList to the updated Country object and check that the list was updated.
		}
		catch (IndexOutOfBoundsException exc)
		{
			System.err.printf("ERROR: Requested index %d is out of range.");
			System.err.printf("Valid element positions are (index >= 0 && index < size()).");
		}
		return clonedList;
	}

	/**
	 * Uses a CSV to parse a CSV file.
	 * Adds the data for each country to an array of Country objects.
	 * Adds a random selection of countries to a CountryList object.
	 * Clones the country list and modifies the clone.
	 */
	public static void main(String[] args) 
	{
		final String FILENAME = "resources/cellular.csv";	// Directory path for Mac OS X
		//final String FILENAME = "resources\\cellular.csv";	// Directory path for Windows OS (i.e. Operating System)


		// Parse the CSV data file
		//
		CSVReader parser = new CSVReader(FILENAME);

		String [] countryNames = parser.getCountryNames();
		int [] yearLabels = parser.getYearLabels();
		double [][] parsedTable = parser.getParsedTable();		


		// Create and set objects of type Country 
		//
		Country [] countries;
		countries = new Country[countryNames.length];
		Country current;

		for (int countryIndex = 0; countryIndex < countries.length; countryIndex++)
		{
			int numberOfYears = yearLabels.length;   // OR numberOfYears = dataTable[countryIndex].length;

			current = new Country(countryNames[countryIndex], numberOfYears);

			for (int yearIndex = 0; yearIndex < numberOfYears; yearIndex++)
			{
				double [] allSubscriptions = parsedTable[countryIndex];
				double countryData = allSubscriptions[yearIndex];
				current.addSubscriptionYear(yearLabels[yearIndex], countryData);
			}
			countries[countryIndex] = current;
		}

		TestCloneableCountryList application = new TestCloneableCountryList();

		CountryList listOfCountries = application.createCloneableList(countries, TestCloneableCountryList.LIST_SIZE);

		// Output the countries added to the CountryList
		System.out.println("\nList of countries: ");
		System.out.println(listOfCountries);


		// Clone and modify the list of nodes
		// TODO: Complete the implementation of "testCloneableList" to:
		// 				- Create a clone of your linked list.
		//				- Modify two or more countries in the cloned linked list.
		CountryList clonedAndModifiedList;
		clonedAndModifiedList = application.testCloneableList(listOfCountries);


		// NOTE REGARDING OUTPUT:
		// The difference between the original and the modified node(s) in the cloned list must be apparent.
		System.out.println("\n\nOriginal list of countries: ");
		System.out.println(listOfCountries);

		System.out.println("\n\nModified cloned list of countries: ");
		System.out.println(clonedAndModifiedList);

		// flush the error stream
		System.err.flush();

		System.out.println("\nDone with TestCloneableCountryList.");
	}
}