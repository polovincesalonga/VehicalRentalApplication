public class CalcRentalAmount { 

    protected final double COMPACT_WEEK_DAYS = 29.99; 
    protected final double COMPACT_WEEK_ENDS = 39.99; 
    protected final double MIDSIZE_WEEK_DAYS = 39.99; 
    protected final double MIDSIZE_WEEK_ENDS = 49.99;
    protected final double SEDAN_WEEK_DAYS = 49.99; 
    protected final double SEDAN_WEEK_ENDS = 59.99; 

    protected double nationalAvg;
    protected String compareRental;


    public double nationalAvg(String carType, int weekDay, int weekEnd) 
    {
        if (carType.equalsIgnoreCase("sedan"))
        {
            nationalAvg = (SEDAN_WEEK_DAYS * weekDay) + (SEDAN_WEEK_ENDS * weekEnd);
        }

        else if (carType.equalsIgnoreCase("midsize")) 
        {
            nationalAvg = (MIDSIZE_WEEK_DAYS * weekDay) + (MIDSIZE_WEEK_ENDS * weekEnd);
        }

        else     
        {
            nationalAvg = (COMPACT_WEEK_DAYS * weekDay) + (COMPACT_WEEK_ENDS * weekEnd);
        }

        return nationalAvg;
    }

    public String compareRental(double nationalAvg, double rentalPaid) 
    {
        if(rentalPaid > nationalAvg + 5) 
        {
            compareRental = "Expensive";
        }

        else if (rentalPaid < nationalAvg - 5) 
        {
            compareRental = "Bargain";
        }

        else    
        {
            compareRental = "Average";
        }

        return compareRental;
    }
    
}
