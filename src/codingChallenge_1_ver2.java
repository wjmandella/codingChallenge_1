import java.util.Scanner;

public class codingChallenge_1_ver2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("You will be prompted to enter the number of small bars (1 kilo each) "
				+ "and big bars (5 kilo each) that you have.");
		System.out.println("You will also be prompted to enter the size (in kilos) "
				+ "of the \"goal\" packages you wish to make from the number of small and large bars you entered.");
		System.out.println();

		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {
			int smallBars = getUserInput(sc, "Enter the number of small bars (1 kilo) you have: ");
			int largeBars = getUserInput(sc, "Enter the number of big bars (5 kilo) you have: ");
			int idealGoal = getUserInput(sc,
					"Enter the size of each \"goal\" package (in kilos) you would like to try to make: ");

			System.out.println();

			makeChocolate(smallBars, largeBars, idealGoal);
			
			choice = checkAnotherGoal(sc);
			System.out.println();
		}

		System.out.println("Buh-bye!");
	}

	 public static void makeChocolate(int small, int big, int goal) {
		 int testGoal = goal;	
		 
		 int smallCount = small;
		 int bigCount = big;

		 int bigUsedCount = 0;
		 int smallUsedCount = 0;
	
		 int leftOverSmall = 0;
		 int leftOverBig = 0;
		 
		 int packageCount = 0;	
		 
		 if (small + 5*big < goal || goal%5>small) {
		 System.out.println("Sorry, but your order can not be filled with the number of small and big bars you entered.");
		 } else {

			 while (goal <= smallCount + bigCount*5 && big >= bigUsedCount && small >= smallUsedCount) {
				 
				 testGoal = goal;
			
				 while (testGoal >= 5 && bigCount > 0) {
					 testGoal -= 5;
					 bigCount--;
				 
				 if (testGoal == 0) {
					 packageCount++;
				 }
				} 
				 while (testGoal > 0 && smallCount > 0) {
					 testGoal--;
					 smallCount--;
				 
				 if (testGoal == 0) {
					 packageCount++;
				 }	 
				}	
				bigUsedCount = big - bigCount;
				smallUsedCount = small - smallCount;
				
			 	leftOverBig = bigCount;
			 	leftOverSmall = smallCount;

			 }		 
			 System.out.println("You will be able to make " + packageCount + " \"goal\"package(s) of " + goal + " kilos each." );
			 System.out.println("It will require " + smallUsedCount + " small bar(s), and " + bigUsedCount + " big bar(s).");
			 System.out.println("You will have " + leftOverSmall + " small bar(s) and " +
			 leftOverBig + " big bar(s) left over.");
		 }
	 }
	
	public static int getUserInput(Scanner sc, String prompt) {
		int input = 0;
		boolean isValid = false;
		while (!isValid) {
			// System.out.println();
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				input = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid entry type. Try again.");
				sc.nextLine();
			}
		}
		return input;
	}

	public static String checkAnotherGoal(Scanner sc) {
		String choice = "";
		boolean isValid = false;

		while (!isValid) {
			choice = "";
			System.out.println();
			System.out.print("Do you want to do another calculation? (y/n): ");
			choice = sc.next();
			if (choice.equals("")) {
				System.out.println("Error! Entry needed.");
			} else if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
				System.out.println("Error! Entry must be \"y\" or \"n\".");
			} else {
				isValid = true;
			}
		}
		return choice;
	}

}


