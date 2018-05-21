import java.util.Scanner;

public class FortuneTellerMethods
{
	
	static String strAppQuit = "Quit";
	static String strTerminating = "Nobody likes a quitter... Terminating.";
	
	private static void hasQuit (String input)
	{
		if(input.equalsIgnoreCase(strAppQuit))
		{
			System.out.println(strTerminating);
			System.exit(0);
		}
	}
	
	private static String VacationSpot (int sibling)
	{
		String vacation = "";
		
		switch (sibling)
		{
			case 0:
				vacation = "San José, Costa Rica";
				break;
			case 1:
				vacation = "Sydney, Australia";
				break;
			case 2:
				vacation = "Hong Kong, China";
				break;
			case 3:
				vacation = "Scottsdale, Arizona";
				break;

			default:
				if (sibling > 3)
				{
					vacation = "Sicily, Italy";
					break;
				}
				System.out.println("I didn't know you could have less than 0 sibling...");
				vacation = "Chernobyl, Ukraine";
				break;
		}
		
		return vacation;
	}
	
	private static int YearsTilRetirement(int age)
	{
		int retire = 0;
		
		if (age <= 1 || age > 90)
		{
			System.out.println("How are you alive?!");
			retire = 4000;
		}
		else if ((age % 2) == 0)
		{
			retire = 40;
		}
		else
		{
			retire = 33;
		}
		
		return retire;
	}
	
	private static double futureBankBalance(int monthOfBirth)
	{
		double money = 0;
		
		switch (monthOfBirth)
		{
			case 1:
			case 2:
			case 3:
			case 4:
				money = 357_000.44;
				break;
			case 5:
			case 6:
			case 7:
			case 8:
				money = 6_420_256.42;
				break;
			case 9:
			case 10:
			case 11:
			case 12:
				money = 36_000.36;
				break;
			default:
				System.out.println("You poor sod.");
				money = 0;
				break;
		}
		
		return money;
	}
	
	private static String FutureCarFromColor (String color)
	{
		String vehicle = "";
		
		if (color.isEmpty())
		{
			System.out.println("No favorite color :( ");
			vehicle = "A cardboard box?";
		}
		else
		{
			switch (color.toLowerCase())
			{
				case "red":
					vehicle = "Ferrari LaFerrari";
					break;
				case "orange":
					vehicle = "Dodge Viper SRT";
					break;
				case "yellow":
					vehicle = "McLaren P1 GTR";
					break;
				case "green":
					vehicle = "Lamborghini Murciélago";
					break;
				case "blue":
					vehicle = "Ferrari F60 America";
					break;
				case "indigo":
					vehicle = "Noble M600";
					break;
				case "violet":
					vehicle = "Lamborghini Aventador Galaxy";
					break;
				default:
					System.out.println("You did not choose a color in the ROYGBIV");
					vehicle = "Flying Saucer";
					break;
			}
		}
		
		return vehicle;
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		String vacationLocation = "";
		String modeOfTransportation = "";
		
		try
		{		
			// first name
			System.out.println("Please enter your first name.");
			String firstName = input.nextLine();
			hasQuit(firstName);
			
			// last name
			System.out.println("Please enter your last name (sur name).");
			String lastName = input.nextLine();
			hasQuit(lastName);

			// age
			System.out.println("How old are you?");
			String userAge = input.nextLine();
			hasQuit(userAge);
			int parsedUserAge = Integer.parseInt(userAge);
			int yearsToRetire = YearsTilRetirement(parsedUserAge);
			
			// birth month && bank account
			System.out.println("What is your birth month? Enter a number 1-12, January being 1.");
			String birthMonth = input.nextLine();
			hasQuit(birthMonth);

			int parsedBirthMonth = Integer.parseInt(birthMonth);
			double bankBalance = futureBankBalance(parsedBirthMonth);
			
			// favorite color
			System.out.println("What is your favorite ROYGBIV color?");
			String favoriteColor = input.nextLine();
			hasQuit(favoriteColor);

			while (favoriteColor.equalsIgnoreCase("Help"))
			{
				System.out.println("The ROYGBIV colors are red, orange, yellow, green, blue, indigo, violet.");
				favoriteColor = input.nextLine();
			}
			modeOfTransportation = FutureCarFromColor(favoriteColor);

			// siblings
			System.out.println("How many siblings do you have?");
			String numOfSiblings = input.nextLine();
			hasQuit(numOfSiblings);
			
			int parsedSiblings = Integer.parseInt(numOfSiblings);
			vacationLocation = VacationSpot(parsedSiblings);

			System.out.println(firstName + " " + lastName + " will retire in " + yearsToRetire + " years with $"
					+ bankBalance + " in the bank, " + "a vacation home in " + vacationLocation + ", and travel by "
					+ modeOfTransportation + ".");
		}
		catch (NumberFormatException e)
		{
			System.out.println(e + ", is not a valid input");
			System.exit(0);
		}

		input.close();

		System.exit(0);
	}

}
