import java.util.Scanner;

public class cuervo_p2 {

    public static void main(String[] args){

        SavingsAccount saver1 = new SavingsAccount();       //Make new object saver1
        SavingsAccount saver2 = new SavingsAccount();       //Make new object saver2

        saver1.setSavingsBalance(2000);                     //Set saver1's savings balance to $2000
        saver2.setSavingsBalance(3000);                     //Set saver2's savings balance to $3000

        for(int i = 1; i<13; i++) {                       //Print out the new balance after each month of both savers
            System.out.println("Saver 1 has $" + saver1.calculateMonthlyInterest() + " after month " + i + ".");
            System.out.println("Saver 2 has $" + saver2.calculateMonthlyInterest() + " after month " + i + ".");
            saver1.setSavingsBalance(saver1.calculateMonthlyInterest());
            saver2.setSavingsBalance(saver2.calculateMonthlyInterest());
        }

        SavingsAccount.modifyInterestRate(0.05);       //Modify the interest rate to 5%

        System.out.println("Saver 1 has $" + saver1.calculateMonthlyInterest() + " after the next month.");
        System.out.println("Saver 2 has $" + saver2.calculateMonthlyInterest() + " after the next month.");

    }
}

class SavingsAccount{
    private static double annualInterestRate = 0.04;        //Set the interest rate to 4%
    private double savingsBalance;

    public void setSavingsBalance(double x){
        savingsBalance = x;
    }

    public static void modifyInterestRate(double x){
        annualInterestRate = x;
    }

    public double calculateMonthlyInterest(){
        double monthlyInterest = ((savingsBalance*annualInterestRate)/12)+savingsBalance;
        return monthlyInterest;
    }
}