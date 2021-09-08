
public class DateCalculator {
	
	public static final int ORIGIN_YEAR = 1980;
	public static final int DAYS_IN_A_YEAR = 365;
	
	private int daysRemaining;
	private int year;

	
	public int getDaysRemaining() {
		return daysRemaining;
	}

	public void setDaysRemaining(int daysRemaining) {
		this.daysRemaining = daysRemaining;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void peelOffLeapYear()
	{
		if (daysRemaining > (DAYS_IN_A_YEAR+1))  //Zune Bug!
		{
			daysRemaining -= (DAYS_IN_A_YEAR+1);
			year += 1;
		}
	}
	
	public void peelOffRegularYear()
	{
		daysRemaining -= DAYS_IN_A_YEAR;
		year += 1;
	}
	
	public  int calculateCurrentYear(int daysToConvert)
	{
		year = ORIGIN_YEAR;
		daysRemaining = daysToConvert;
		while (daysRemaining > DAYS_IN_A_YEAR)
		{
			if (isLeapYear(year))
			{
				peelOffLeapYear();
			}
			else
			{
				peelOffRegularYear();
			}
		}
		return year;
	}
	
	public boolean isLeapYear(int year)
	{
		return (year % 400 == 0 ||
				(year % 4 == 0 && year % 100 != 0));
	}
	
	public static void main(String[] args)
	{

	}
}

