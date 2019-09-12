// Name: Qiuchen Zhang
// AndrewID: qiuchenz

package lab1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumParser {
	double sum, max, min; //to store the results to be printed
	int count; //to count the valid numbers parsed

	/** DO NOT change the main method **/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the numbers separated by a space or a comma");
		String numbers = input.nextLine();
		NumParser np = new NumParser();
		np.parseCalculate(numbers);
		np.printResults();
		input.close();
	}

	/**The parseCalculate method takes a string as input parameter and parses
	 * out the valid numbers from it. While parsing, it also calculates sum, max, min, and count.
	 * If it finds any invalid token, it discards it and prints it out as a discarded token 
	 * @param numbers
	 */
	void parseCalculate(String numbers) {
		//Write your code here
//	    Pattern pattern = Pattern.compile("[+-]?[0-9]+[.]?[0-9]*");
		Scanner inp = new Scanner(numbers);
		this.count = 0;
		this.sum = 0.0;
		this.max = - Double.MAX_VALUE;
		this.min = Double.MAX_VALUE;
		double num;
		while(inp.hasNext()) {
			String token = inp.useDelimiter("[\\s,]+").next(); 
//			Matcher  = pattern.matcher(INPUT);
			if (token.matches("[+-]?[0-9]+[.]?[0-9]*")) {
				num = Double.valueOf(token);
				sum += num;
				max = num > max? num : max;
				min = num < min? num : min;
				this.count++;
			}
			else {
				System.out.printf("Discarded token: %s\n", token);
			}
		}
		if (this.count == 0) {
			this.max = 0;
			this.min = 0;
		}
		inp.close();
	}

	/** The printResult method prints the output as shown 
	 * in the lab-handout
	 */
	private void printResults() {
		//Write your code here
		System.out.printf("Sum is %.1f\n", this.sum);
		System.out.printf("Average is %f\n", this.sum / this.count);
		System.out.printf("Max is %.1f\n", this.max);
		System.out.printf("Min is %.1f\n", this.min);		
	}
}