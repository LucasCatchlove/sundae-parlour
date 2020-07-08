public class Sundae {

	private String flavor; 
	private int scoops; 
	private boolean hasNuts; 
	private double cost;
	private static int sundaeCount;

	// personal variables
	private double scoopCost = 1.50;
	private double nutsCost = 1.25;

	


	//constructors
	public Sundae() {
		flavor = "";
		scoops = 0;
		hasNuts = false;
		cost = 0;
		sundaeCount++; 

	}

	public Sundae(int scoops, String flavor, boolean hasNuts) {
		this.scoops = scoops;
		this.flavor = flavor; 
		this.hasNuts = hasNuts; 

		sundaeCount++; 

		calcCost(); 

	}

	public Sundae(Sundae sundae) {

		this.scoops = sundae.scoops; 
		this.flavor = sundae.flavor; 
		this.hasNuts = sundae.hasNuts;
		this.cost = sundae.cost;  

		sundaeCount++;


	}



	//methods 

	private void calcCost() {

		cost = scoops*scoopCost;

		if(hasNuts == true)
			cost += nutsCost;

	}

	public void updateCost() {
		calcCost();
	}

	public void toMyString() {
		if(hasNuts == true)
			System.out.println("sunday with "+ scoops + " scoops of " + flavor + " with nuts for a cost of: $" + cost);
		else
			System.out.println("sunday with "+ scoops + " scoops of " + flavor + " for a cost of: $" + cost);


	}

	public boolean equaLs(Sundae sundae) {
		if(flavor.equalsIgnoreCase(sundae.flavor) && (hasNuts == sundae.hasNuts) && (scoops == sundae.scoops))
			return true;
		else 
			return false; 
	}




	//accessors 

	public String getFlavor() {
		return flavor;
	}
	public double getCost() {
		return cost; 
	}

	public boolean getNuts() {
		return hasNuts; 
	} 


	public int getCount() {
		return sundaeCount; 
	}

	public int getScoops() {
		return scoops; 
	}



	//mutators

	public void setFlavor(String flavor) {
		this.flavor = flavor; 
	}

	public void setNuts(boolean hasNuts) {
		this.hasNuts = hasNuts; 
	}

	public void setScoops(int scoops) {
		this.scoops = scoops; 

	}









































}