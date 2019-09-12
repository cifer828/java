package practice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

//formula for EMI = [P x R x (1+R)^N]/[(1+R)^N-1], where R is monthly interest and N is number of months	
public class Loan {	
	int years;
	long principal;
	double interestRate;
	BigDecimal bigInterestRate;

	//complete this method
	public double calcEMI() {	
		double EMI;
		double monthR = interestRate / 12;
		int months = years * 12;
		EMI = principal * monthR * Math.pow(1 + monthR, months) / ((Math.pow(1 + monthR, months)) - 1);
		return EMI;								
	}

	//complete this method
	public BigDecimal calcBigEMI() {
		BigDecimal bigMonthR = new BigDecimal(interestRate / 12);
		BigDecimal bigPrincipal = new BigDecimal(principal);
		BigDecimal bigOne = new BigDecimal(1);
		BigDecimal power = bigOne.add(bigMonthR).pow(years * 12);
		return bigPrincipal.multiply(bigMonthR).multiply(power).divide(power.subtract(bigOne), 20, RoundingMode.HALF_UP);
	}

	//complete this method
	public void getInputs() {
		Scanner input = new Scanner (System.in);
		// insert your code here
		System.out.println("Enter principal amout");
		principal = input.nextLong();
		System.out.println("Enter number of years");
		years = input.nextInt();
		System.out.println("Enter anuual interest rate. %% to be enterd as 0.05");
		interestRate = input.nextDouble();
		bigInterestRate = new BigDecimal(interestRate);
		input.close();
	}

	//don't change this method
	public static void main(String[] args) {
		Loan l = new Loan();
		l.getInputs();     							//initialize all variables
		
		double doubleEMI = l.calcEMI();				//calculate EMI with double interest rate
		BigDecimal bigEMI = l.calcBigEMI();			//calculate EMI with BigDecimal interest rate

		System.out.println("********** Results ************");
		System.out.printf("Principal: $%,d%n", l.principal);
		System.out.printf("Interest rate: %.2f%%%n", l.interestRate*100);
			
		System.out.println("Monthly EMI using double: " + doubleEMI);
		
		//following statement rounds up 20 digits after decimal place. Otherwise throws Arithmetic Exception if number cannot be represented 
		System.out.println("Monthly EMI using BigDecimal: " + bigEMI.setScale(20, RoundingMode.HALF_UP));	

		double difference = (bigEMI.setScale(20, RoundingMode.HALF_UP).doubleValue() - doubleEMI)*12*l.years;

		System.out.printf("Difference bigEMI - doubleEMI = %.15f%n", (bigEMI.subtract(BigDecimal.valueOf(doubleEMI))));
		System.out.printf("Total difference = %.15f%n", difference);
	}
}
