package week_3_quiz;

import java.util.ArrayList;

public class Quiz {
    public static void main(String[] args) {
        ArrayList<String> myRows = new ArrayList<>();
        myRows.add("Loan,200.00");
        myRows.add("Debt,100.99");
        showResults(approveLoan(myRows));

        ArrayList<String> myRows2 = new ArrayList<>();
        myRows2.add("Loan,202.99");
        myRows2.add("Debt,100.99");
        showResults(approveLoan(myRows2));
    }

    private static boolean approveLoan(ArrayList<String> myRows) {
        double loanAmount = Double.parseDouble(myRows.get(0).split("[,]")[1]);
        double debtAmount = Double.parseDouble(myRows.get(1).split("[,]")[1]);

        return !(debtAmount * 2 > loanAmount); //If debt * 2 is more than the Loan amount return false otherwise return true
    }

    private static boolean approveLoanOneLine(ArrayList<String> myRows) {
        return !(Double.parseDouble(myRows.get(1).split("[,]")[1]) * 2 > Double.parseDouble(myRows.get(0).split("[,]")[1]));
    }

    private static void showResults(boolean res) {
        System.out.print(res ? "\nYes your loan is approved" : "\nSorry your loan is denied");
    }
}
