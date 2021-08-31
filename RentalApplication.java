import javax.swing.JFrame;


public class RentalApplication {

    public static void main(String[] args) 
    {
        GUI g = new GUI(); 

        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        g.pack(); 
        g.setVisible(true);
    }
    
}
