import javax.swing.*;

public class MortgageController {
    public static void main(String[] args) {
        
        
        String error  = "Ju lutemi t� sh�noni nj� vler� pozitive";
        String intro ="Ky aplikacion mundëson llogaritjen e kredis� hipotekare." +
        " P�r t� filluar programin, sh�noni shum�n e hipotek�s";
      
       //marrja e input1, testimi se a eshte numer negativ, paraqitja e numrit te dhene ne view class
        String input1 = JOptionPane.showInputDialog(null, intro);
        double principal = Double.valueOf(input1);
        while (principal < 0){ 
            input1= JOptionPane.showInputDialog(null, error);
            principal = Double.valueOf(input1);
        }
    
       
        //marrja e input2, testimi se a eshte numer negativ, paraqitja e numrit te dhene ne view class
        String input2 = JOptionPane.showInputDialog(null, "Sh�noni interesin(p�rqindje)");
        double interest = Double.valueOf(input2)/100;
        while(interest<0){
            input2= JOptionPane.showInputDialog(null, error);
            interest = Double.valueOf(input2)/100;
        }

        
        // marrja e input3, testimi se a eshte numer negativ, paraqitja e numrit te dhene ne view class
        String input3 = JOptionPane.showInputDialog(null, "Sh�noni numrin e muajve:");
        int years = Integer.valueOf(input3);
        while(years<0){
            input3= JOptionPane.showInputDialog(null, error);
            years = Integer.valueOf(input3);
        }
        
      new MortgageView(principal, interest, years);
        
    }
}