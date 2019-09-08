// Andrew-ID: qiuchenz
// Name: Qiuchen Zhang
// package lab0b;

import java.math.BigInteger;
// import java.text.NumberFormat;
import java.util.Scanner;

public class Factorial {
	public int calculateFactorial(int number) {
		//write your code here to calculate factorial using data-type as int
		//it should take care of number being 0 or negative as well. 
		if (number <= 0)  return 1;
		return calculateFactorial(number - 1) * number;
	}

	public BigInteger calculateBigFactorial (int number) {		
		//write your code here to calculate factorial using data-type as BigInteger
		//it should take care of number being 0 or negative as well. 
		BigInteger bigNumber = new BigInteger(String.valueOf(number));
		if (number <= 0) return new BigInteger("1");
		return bigNumber.multiply(calculateBigFactorial(number - 1));
	}
	
	public static void main(String[] args) {
		Factorial f = new Factorial();							//create Factorial object
		
		System.out.println("Factorial upto which number?");		//display console message
		Scanner input = new Scanner(System.in);					//create object to capture keyboard input
		int number = input.nextInt();							//get user input
		input.close();
		//Write code here to print the output as shown
		System.out.println("Factorials using int");
		// NumberFormat myFormat = NumberFormat.getInstance();
        // myFormat.setGroupingUsed(true); // this will also round numbers, 3
		for (int i = 0; i <= number; i++) {
			System.out.printf("%d! = %d\n", i, f.calculateFactorial(i));
		}
		
		System.out.println("Factorials using BigInteger");
		for (int i = 0; i <= number; i++) {
			System.out.printf("%d! = %d\n", i, f.calculateBigFactorial(i));
		}
	}
}
