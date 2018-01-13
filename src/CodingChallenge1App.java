import java.util.Scanner;

public class CodingChallenge1App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("You will be prompted to enter the number of small bars (1 kilo each) " +
							"and big bars (5 kilo each) that you have.");
		System.out.println("You will also be prompted to enter the size (in kilos) " +
								"of the \"goal\" packages you wish to make from the number of small and large bars you entered.");
		System.out.println();
		
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			int smallBars =  getUserInput(sc, "Enter the number of small bars (1 kilo) you have: ");
			int largeBars =  getUserInput(sc, "Enter the number of big bars (5 kilo) you have: ");
			int idealGoal = getUserInput(sc, "Enter the size of each \"goal\" package (in kilos) you would like to try to make: ");
				
			System.out.println();
			
			int smallBarsNeeded = makeChocolate(smallBars, largeBars, idealGoal);
//			makeChocolate(smallBars, largeBars, idealGoal);
//			
			if (smallBarsNeeded == -1) {
				System.out.println("Sorry, but your order can not be filled with the number of small and large bars you entered.");
			} else {
				System.out.println("Your order can be filled. You will need " + smallBarsNeeded + " small bars.");
			}

			choice = checkAnotherGoal(sc);
			System.out.println();
	}	
		
		System.out.println("Buh-bye!");
}		

// version 1 of makeChocolate method
		public static int makeChocolate(int small, int big, int goal) {
			int diff = goal - 5*big;
			if (diff <= small) {
				small = diff;			
			} else {
				small = -1;
			}
			return small;				
		}

//	public static void makeChocolate(int small, int big, int goal) {
//		int goal2 = goal;
//		
//		int smallCount = small;
//		int bigCount = big;
//		int bigCount2 = 0;
//		int smallCount2 = 0;
//
//		int leftOverSmall = small-smallCount2;
//		int leftOverBig = big - bigCount2;
//
//		int packageCount = 0;
//	
//		int bigUsedCount = 0;
//		int smallUsedCount = 0;
//		
//		int testSmall = 0;
//		int testBig = 0;
//		
//		
//		if (small + 5*big < goal || goal%5>small) {
//			System.out.println("Sorry, but your order can not be filled with the number of small and big bars you entered.");
//		} else {
//
////			while (big > bigUsedCount && small > smallUsedCount) {
//			while (goal >= testSmall + testBig*5 && big > bigUsedCount && small > smallUsedCount) {	
//				goal2 = goal;
//				
//				while (goal2 >= 5 && bigCount > 0) {
//					goal2 -= 5;
//					bigCount--;
//					bigUsedCount++;
//				} 
//					if (goal2 == 0) {
//					packageCount++;
//					}			
//						
//				while (goal2 > 0 && smallCount > 0) {
//					goal2--;
//					smallCount--;
//					smallUsedCount++;
//				} 
//					if (goal2 == 0) {
//					packageCount++;
//				}
//					System.out.println("small + big used: " + (testSmall + 5*testBig) );
//					
//					leftOverBig = big - bigUsedCount;					
//					leftOverSmall = small - smallUsedCount;
//					System.out.println("testSmall, test big : " + testSmall + " , " + testBig);
//					testSmall = Math.min(leftOverSmall, smallUsedCount);
//					testBig = Math.min(leftOverBig, bigUsedCount);
//					System.out.println("testSmall, test big : " + testSmall + " , " + testBig);
//			}		
//			System.out.println("You will be able to make " + packageCount + " \"goal\" package(s) of " + goal + " kilos." );
//			System.out.println("It will require " + smallUsedCount + " small bar(s), and " + bigUsedCount + " big bar(s).");
//			System.out.println("You will have " + leftOverSmall + " small bar(s) and " + leftOverBig + " big bar(s) left over.");
//		}	
//	}
//		

		public static int getUserInput(Scanner sc, String prompt) {
			int input = 0;
			boolean isValid = false;		
			while (!isValid) {
//				System.out.println();
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



// Earlier version of makeChocolate method

//public static void makeChocolate(int small, int big, int goal) {
//	int originalTotal = big * 5 + small;
//	int goal2 = goal;
//	int numberOfGoals = originalTotal/goal;
//
//	int totalKilos = goal*numberOfGoals;
////	int total = totalKilos;
//	
//	int smallCount = small;
//	int bigCount = big;
//	int bigCount2 = 0;
//	int smallCount2 = 0;
////	numberOfGoals = 0;
//	int leftOverSmall = small-smallCount2;
//	int leftOverBig = big - bigCount2;
//	int packageTotal = 0;
//	int packageCount = 0;
//	int bigCount3 = 0;
//	int smallCount3 = 0;
//	
//	if (small + 5*big < goal) {
//		System.out.println("Sorry, but your order can not be filled with the number of small and big bars you entered.");
//	} else {
//		if ((big*5)%goal == 0) {
//			int bigPackageCount = (big*5)/goal;
//			System.out.println("bigPackageCount: " +bigPackageCount);
//			bigCount3 = bigPackageCount;
//			System.out.println("bigCount3: " +bigCount3);
//			leftOverBig = originalTotal - (big*5);
//			
//			if (small >= goal) {
//				int smallPackageCount = small/goal;
//				packageCount = bigPackageCount + smallPackageCount;
//				smallCount3 = smallPackageCount;
//				leftOverSmall = small - smallPackageCount;
//			} else {
//				smallCount3= 0;
//				leftOverSmall = small;
//			}			
//			
//		} else {
//	
//		while (goal2 > 5  && bigCount > 0) {
//			goal2 -= 5;	
//			bigCount--;
//			bigCount2++;
//		}	
//		while (goal2 > 0 && smallCount > 0) {
//			goal2--;
//			smallCount--;
//			smallCount2++;
//		}	
//
//		packageTotal = (bigCount2)*5 + smallCount2;
//		
//		while (originalTotal - packageTotal >= 0) {
//			originalTotal -= packageTotal;
//			packageCount++;
//		}
//		
//		bigCount3 = bigCount2 * packageCount;
//		leftOverBig = big - bigCount3;
//		
//		smallCount3 = smallCount2*packageCount;
//		leftOverSmall = small - smallCount3;
//	}
//		
//		System.out.println("You will be able to make " + packageCount + " \"goal\" package(s) of " + goal + " kilos." );
//		System.out.println("It will require " + smallCount3 + " small bar(s), and " + (bigCount3) + " big bar(s).");
//		System.out.println("You will have " + leftOverSmall + " small bar(s) and " + leftOverBig + " big bar(s) left over.");
//	}	
//}
//
