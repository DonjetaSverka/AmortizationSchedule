import java.awt.*;
import javax.swing.*;

public class MortgageView extends JPanel {

    int width = 600;
    int height = 620;
    Mortgage model;
    Color myColor;
   
   private static  double[] balances;
   private static  double[] interests;
   private static  double[] principals;   
   private static  double[] payments;
    // konstruktori
    MortgageView(double principal, double interest, int years) {
        
        model=new Mortgage(principal, interest, years);
        balances = model.getBalances();
        interests = model.getInterests();
        principals = model.getPrincipals();
        payments = model.getPayments();

        JFrame myFrame = new JFrame();
        myFrame.setSize(width, height);
        myFrame.setTitle("TABELA E AMORTIZIMIT");
        myFrame.add(this);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
      

    }
    int y = 100;
    Color myBlue = new Color(36, 61, 76);
    Color black =  new Color(32,33,36);

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(black);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("#",70,50);
        g.drawString("Pagesa ", 140, 50);
        g.drawString("Principi",245,50);
        g.drawString("Interesi", 350, 50);
        g.drawString("Bilanci", 440,50);

        for (int i = 0; i < balances.length; i++) {
            g.drawString((i+1) +"", 70,y);
            g.drawString(payments[i] +"", 150, y);
            g.drawString(principals[i] +"", 250,y);
            g.drawString(interests[i] +"", 350,y);
            g.drawString( balances[i] + " ", 450, y);
            
            g.drawLine(70, y+3, 493, y+3);
            y += 30;
            
        }
    }
}
