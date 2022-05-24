
package assignment_2.question_3;
import java.util.Scanner;

public class classA {

    /*Program entry point*/
    public static void main(String[] args) {

        /* Declaring program variables*/
        double investmentAmount, interestRate;
        int years;

        /*Declaring and initializing classB variable
        * the purpose for this class is to calculate the value of the investment based
        * on the amount of years the investment has been invested
        *  */
        classB investmentCalculator = new classB();

        /*scanner object used to read console input into variables*/
        Scanner consoleIn = new Scanner(System.in);

        try {
            /*asking the user how much they would like to invest*/
            System.out.print("What is the amount you would like to invest: ");

            /* storing the valued entered into a variable*/
            investmentAmount = consoleIn.nextDouble();

            /* asking the user what is the interest rate of the investment*/
            System.out.print("What is the interest rate of your investment: ");

            /* Storing the investment rate into a variable*/
            interestRate = consoleIn.nextDouble();

            /* asking the user how many years they would like to invest for*/
            System.out.print("How many years would you like to invest for: ");

            /* storing the value entered into a variable*/
            years = consoleIn.nextInt();

            /* Converting the value of the interest rate into a amount needed in the formula for the investment calculator */
            interestRate *= 0.01;

            /*calling the function linked to our investment calculator class*/
            investmentCalculator.futureInvestmentValue(investmentAmount, interestRate, years);

        }catch (Exception e) {

            System.out.println("Something went wrong, please re-run the program. Here is the error message - " + e);

        } finally {

            System.out.println("Thank you. Please feel free to use the program at any time.");
        }
    }

        /*Declaring our classB which is our investment calculator class */
    static class classB {

        /* initializing class variable to store investment amount*/
        double value;


        /* Defining function to calculate the investment value based on the year supplied as an argument*/
        void futureInvestmentValue (double investmentAmount, double monthlyInterestRate, int years){

            /* declaring a variable used to create string formatting*/
            int stringSpacer;

            /* Printing out the table headers*/
            System.out.println("Years    Future Value");

            /* Iterating through each year in the range of the starting year to the ending year*/
            for (int i = 1; i <= years; i++ ){

                /* if the year is smaller than 9 let the spaces be 9 characters wide otherwise let it be 20 characters wide  */
                stringSpacer = (i > 9) ?  19 : 20;

                /* let this objects value be equal to the future investment value  based on the amount of years invested.*/
                this.value = investmentAmount * Math.pow(1 + monthlyInterestRate / 12, i * 12);

                /* print out the year and the amount the investment equals for that year.*/
                System.out.printf(i + "%"+ stringSpacer +".2f\n", this.value);

            }
        }
    }
}
