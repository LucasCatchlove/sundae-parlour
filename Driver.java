// -------------------------------------------------------
// final take home exam
// Written by: Lucas catchlove 27145640
// For COMP 248 Section (section U) – Winter 2020
// --------------------------------------------------------
/* This program allows the user to input data corresponding to ice cream sundaes
   and manipulate it as well compute relevant statistics that are displayed to 
   the user
 */


	import java.util.Scanner; 

	public class Driver {
		public static void main(String[] args) {
			
			System.out.println("*****************************************\n" +
					"          Nancy's Sundae Parlour           \n" + 
					"*****************************************\n");

			Scanner kb = new Scanner(System.in);

			Sundae[] sundaeList; 
			int maxSundaes;
			int validChoice;
			int scoops;
			final double nutsCost = 1.25;

			validChoice = 0;

			//main menu option 1 variables
			String flavor;
			String hasNutsChoice;
			boolean hasNuts;

			//main menu option 2 variables
			int sundaeIndex; 
			int updateIndex=0;

			//main menu option 3 variables
			String flavorInfo = "";

			//main menu option 4 variables
			int statIndex;
			int soldCount;
			double cheapestSundaePrice;
			int cheapestSundae;
			int scoopNumber;
			int scoopCount;
			double totalCost;

			statIndex=0;
			soldCount=0;
			cheapestSundaePrice=0;
			cheapestSundae=0;
			scoopNumber=0;
			scoopCount=0;
		    totalCost=0;

			

			System.out.print("How many sundaes can you make today? ");
			maxSundaes = kb.nextInt();

			sundaeList = new Sundae[maxSundaes];

			// main menu while loop


			while(validChoice < 1 || validChoice > 5) {

				System.out.print("\nWhat do you want to do?\n"+
								"\n1. Enter a new sundae order\n"+
								"2. Change information of specific order\n"+
								"3. Display details for all sundaes of a specific ice cream flavor\n"+
								"4. Statistics on today's sundaes\n"+
								"5. Quit\n"+
								"\nPlease enter your choice > ");

			    

				validChoice = kb.nextInt();


				switch (validChoice) {

	            ////////////////////////////////////////////// main menu option 1

				case 1:

				for(int i = 0; i< sundaeList.length; i++) {
					if(sundaeList[i] == null) {
						
						System.out.println("\nHow many scoops of ice cream? ");
						scoops = kb.nextInt();

						System.out.println("What flavor? ");
						kb.nextLine();
						flavor = kb.nextLine();

						System.out.println(" Any nuts? (y for yes anything else for no) ");
						hasNutsChoice = kb.next();

						if(hasNutsChoice.equalsIgnoreCase("y"))
							hasNuts = true;
						else
							hasNuts = false;

						Sundae sundae = new Sundae(scoops, flavor, hasNuts);
						sundaeList[i] = sundae;
						soldCount++;
						totalCost += sundaeList[i].getCost();
						break;
						
					}
					else if((i == sundaeList.length-1) && (sundaeList[i] != null))
						System.out.println("\nSorry we don't have enough ingredients to make another sundae\n");

				}

				validChoice = -1;
				break;

				///////////////////////////////////////////// main menu option 2

				case 2:

				System.out.println("\nWhich sundae would you like to change? \n"+
									"Please enter your choice: ");
				sundaeIndex = kb.nextInt();
				if((sundaeIndex < 0 || (sundaeIndex > (maxSundaes-1))) || sundaeList[sundaeIndex] == null)
					System.out.println("Sorry no such sundae");
				else {
					while(updateIndex != 4) {
						System.out.println("sundae # " + sundaeIndex + "\n");
							sundaeList[sundaeIndex].toMyString();
						
						System.out.println("\nWhat would you like to change?\n"+
											"1. Ice cream flavor\n"+
											"2. Number of scoops\n"+
											"3. Nuts or no nuts\n"+
											"4. quit\n"+
											"Enter choice >");
						updateIndex = kb.nextInt();

						switch (updateIndex) {
							case 1:
							System.out.print("new flavor ");
							kb.nextLine();
							sundaeList[sundaeIndex].setFlavor(kb.nextLine()); 
							System.out.print("Here's what the sundae looks like now\n");
							break;

							case 2:
							System.out.println("How many scoops?  ");
							sundaeList[sundaeIndex].setScoops(kb.nextInt()); 
							sundaeList[sundaeIndex].updateCost();
							System.out.print("Here's what the sundae looks like now\n");
							break;

							case 3:
							if(sundaeList[sundaeIndex].getNuts() == true) {
							sundaeList[sundaeIndex].setNuts(!sundaeList[sundaeIndex].getNuts());
							totalCost -= nutsCost; 
							}
							
							

							else if(sundaeList[sundaeIndex].getNuts() == false) {
							sundaeList[sundaeIndex].setNuts(!sundaeList[sundaeIndex].getNuts());
							totalCost += nutsCost;
							}

							sundaeList[sundaeIndex].updateCost();
							System.out.print("Here's what the sundae looks like now\n");


						}

					}

				}
				updateIndex = 0;
				validChoice = -1; 
				break;




				/////////////////////////////////////////// main menu option 3

				case 3:

				System.out.print("\nWhat flavor do you want a list of? \n");
				kb.nextLine();
				flavorInfo = kb.nextLine();
				for(int i = 0; i< maxSundaes; i++) {
					if(sundaeList[i].getFlavor().equalsIgnoreCase(flavorInfo) && (sundaeList[i] != null)) {
						System.out.println("sundae #" + i);
						sundaeList[i].toMyString();
					}
				}

				validChoice = -1;

				break;


				///////////////////////////////////////////// main menu option 4




				case 4:
				
					while(statIndex != 6) {
						
						
						System.out.print("\nWhat information would you like?\n"+
											"\n1. List of all sundaes sold today\n"+
											"2. Details of cheapest sundae\n"+
											"3. Number of sundaes sold today\n"+
											"4. Number of sundaes with specific number of scoops\n"+
											"5. Average cost of sundaes\n"+
											"6. quit\n"+
											"Enter choice >");
						statIndex = kb.nextInt();

						switch (statIndex) {
							case 1:

							for(int i = 0; i< maxSundaes; i++) {
								if(sundaeList[i] != null) {
									System.out.println("sundae #" + i);
									sundaeList[i].toMyString();
									
									//totalCost += sundaeList[i].getCost();
								}
							}

							break;

							case 2:

							for(int i = 0; i<maxSundaes; i++) {

								if(i == 0)
									cheapestSundae = 0;
								else if(sundaeList[i].getCost() < sundaeList[cheapestSundae].getCost())
									cheapestSundae = i; 

							}

							System.out.println("\nthe cheapest sundae is # " + cheapestSundae);
							sundaeList[cheapestSundae].toMyString();

							break;

							case 3:
							System.out.println("\n"+soldCount + " sundaes were sold today");
							break;
							
							case 4:
							System.out.print("\nsundaes with how many scoops: ");
							scoopNumber = kb.nextInt();
							for(int i = 0; i<maxSundaes; i++) {
								if(sundaeList[i].getScoops() == scoopNumber)
									scoopCount++;
							}

							System.out.println("\nThere are " + scoopCount + " sundaes with " + scoopNumber + " scoops");



							break;

							case 5:
							
							System.out.print("\nthe average cost of all sundaes is " + totalCost/soldCount);
							
							break;





						}

					}

				
				statIndex=0;
				validChoice = -1;

				break;

				///////////////////////////////////////// main menu option 5

				case 5: 
				System.out.println("\nThank you for using Nancy's Sundae Parlour! Goobye!\n");
				
				System.exit(0);


				default: 
					System.out.println("\nYou entered an invalid choice! Please try again");
					
		  		}
				     


			}

			

		}
	}