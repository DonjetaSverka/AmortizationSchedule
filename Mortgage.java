import java.text.DecimalFormat;
import java.math.RoundingMode;

public class Mortgage {

    private static double monthly_payment;


    double total_interes;
    double i;
    double perqindja;
    double total;
    int y;

   private double[] principles;
   private double[] interests;
   private  double[] balances;
   private double[] payments;

    double balance_owed;

    Mortgage(double p, double i, int y) {
        monthly_payment = (p * (i / 12.0) * Math.pow(1 + (i / 12.0), y)) / (Math.pow(1 + (i / 12.0), y) - 1);
        total = monthly_payment * y;
    
        principles = new double[y];
        interests = new double[y];
        balances= new double[y];
        payments = new double[y];

        amortization(p, y, i);
    }

    public void amortization(double p, int m, double i) {
        monthly_payment = roundNumber(monthly_payment);
        balance_owed = roundNumber(p);
        double interes_amount;
        double remaining_principal;

        for (int j = 0; j <= m - 1; j++) {

            interes_amount = roundNumber((i / 12) * balance_owed);
            balance_owed = (1 + i / 12.0) * balance_owed - monthly_payment;
            balance_owed = roundNumber(balance_owed);
            remaining_principal = roundNumber(monthly_payment - interes_amount);

            if (j == m - 1) {
                remaining_principal = roundNumber(monthly_payment + balance_owed - interes_amount);
                balance_owed = 0;

            }
            balances[j]=balance_owed;
            interests[j]=interes_amount;
            principles[j]= remaining_principal;
            payments[j] = monthly_payment;
        }
    }

    public static double roundNumber(double x) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        formatter.setRoundingMode(RoundingMode.HALF_EVEN);
        return Double.valueOf(formatter.format(x));
    }

    public double[] getPrincipals() {
        return principles;
    }

    public double[] getPayments(){
        return payments;
    }
    public double[] getInterests() {
        return interests;
    }
    public double[] getBalances(){
        return balances;
    }
}