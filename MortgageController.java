import javax.swing.*;

public class MortgageController {
    public static void main(String[] args) {
        
        
        String error  = "Ju lutemi të shënoni një vlerë pozitive";
        String intro ="Ky aplikacion mundÃ«son llogaritjen e kredisë hipotekare." +
        " Për të filluar programin, shënoni shumën e hipotekës";
      
       //marrja e input1, testimi se a eshte numer negativ, paraqitja e numrit te dhene ne view class
        String input1 = JOptionPane.showInputDialog(null, intro);
        double principal = Double.valueOf(input1);
        while (principal < 0){ 
            input1= JOptionPane.showInputDialog(null, error);
            principal = Double.valueOf(input1);
        }
    
       
        //marrja e input2, testimi se a eshte numer negativ, paraqitja e numrit te dhene ne view class
        String input2 = JOptionPane.showInputDialog(null, "Shënoni interesin(përqindje)");
        double interest = Double.valueOf(input2)/100;
        while(interest<0){
            input2= JOptionPane.showInputDialog(null, error);
            interest = Double.valueOf(input2)/100;
        }

        
        // marrja e input3, testimi se a eshte numer negativ, paraqitja e numrit te dhene ne view class
        String input3 = JOptionPane.showInputDialog(null, "Shënoni numrin e muajve:");
        int years = Integer.valueOf(input3);
        while(years<0){
            input3= JOptionPane.showInputDialog(null, error);
            years = Integer.valueOf(input3);
        }
        
      new MortgageView(principal, interest, years);
        
    }
}