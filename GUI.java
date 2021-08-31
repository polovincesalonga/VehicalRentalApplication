import javax.swing.JOptionPane; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JButton; 
import javax.swing.JFormattedTextField; 
import javax.swing.JTextField; 
import javax.swing.JTextArea; 
import javax.swing.JSpinner; 
import java.awt.Insets; 
import javax.swing.SpinnerNumberModel; 
import javax.swing.event.ChangeEvent; 
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridBagConstraints; 
import java.awt.GridBagLayout; 
import java.text.NumberFormat;
import java.text.DecimalFormat;




public class GUI extends JFrame implements ChangeListener, ActionListener 
{
    protected JLabel firstNameLabel; 
    protected JLabel lastNameLabel; 
    protected JLabel weekDayLabel; 
    protected JLabel weekEndLabel; 
    protected JLabel carTypeLabel;
    protected JLabel rentalAmountLabel;


    protected JTextField firstNameField; 
    protected JTextField lastNameField; 
    protected JTextField weekDayField;
    protected JTextField weekEndField;
    protected JTextField carTypeField;
    protected JTextField rentalAmountField;


    protected JFormattedTextField firstNameInput; 
    protected JFormattedTextField lastNameInput; 
    protected JFormattedTextField weekDayInput; 
    protected JFormattedTextField weekEndInput;
    protected JFormattedTextField carTypeInput;
    protected JFormattedTextField rentalAmountInput;


    private JButton calculate;

    private JTextArea outputArea; 

    private JSpinner weekDaySpinner; 
    private JSpinner weekEndSpinner;


    private Integer weekDay; 
    private Integer weekEnd;

    private CalcRentalAmount calc = new CalcRentalAmount();
    private DecimalFormat df = new DecimalFormat("$#, ##0.00");



    GUI() 
    {

        int initial = 0; 
        int min = 0; 
        int max = 50; 
        int stepVal = 1;


        GridBagConstraints layout = null;

        SpinnerNumberModel spinnerModel = null;

        NumberFormat currency = null; 


        setTitle("Vehicle Rental Application");

        
        outputArea = new JTextArea(9,30);
        outputArea.setEditable(false);
        


        //spinner models for week day/end
        spinnerModel = new SpinnerNumberModel(initial,min,max,stepVal); 
        weekDaySpinner = new JSpinner(spinnerModel); 
        weekDaySpinner.addChangeListener(this); 

        spinnerModel = new SpinnerNumberModel(initial,min,max,stepVal); 
        weekEndSpinner = new JSpinner(spinnerModel); 
        weekEndSpinner.addChangeListener(this);
        

        //labels 
        firstNameLabel = new JLabel("First Name"); 
        lastNameLabel = new JLabel("Last Name"); 
        weekDayLabel = new JLabel("Week Days"); 
        weekEndLabel = new JLabel("Week Ends"); 
        carTypeLabel = new JLabel("Car Type");
        rentalAmountLabel = new JLabel("Rental Amount Paid");


        //text fields
        firstNameField = new JTextField(15); 
        firstNameField.setEditable(false); 


        lastNameField = new JTextField(15); 
        lastNameField.setEditable(false); 

        weekDayField = new JTextField(15); 
        weekDayField.setEditable(false); 

        weekEndField = new JTextField(15); 
        weekEndField.setEditable(false);


        carTypeField = new JTextField(15); 
        carTypeField.setEditable(false); 

        rentalAmountField = new JTextField(15); 
        rentalAmountField.setEditable(false);


        //input fields
        firstNameInput = new JFormattedTextField(""); 
        firstNameInput.setEditable(true); 
        firstNameInput.setColumns(15); 


        lastNameInput = new JFormattedTextField(""); 
        lastNameInput.setEditable(true); 
        lastNameInput.setColumns(15); 


        weekDayInput = new JFormattedTextField(NumberFormat.getIntegerInstance());
        weekDayInput.setEditable(true); 
        weekDayInput.setValue(0); 
        weekDayInput.setColumns(15); 


        weekEndInput = new JFormattedTextField(NumberFormat.getIntegerInstance()); 
        weekEndInput.setEditable(true); 
        weekEndInput.setValue(0); 
        weekEndInput.setColumns(15); 


        carTypeInput = new JFormattedTextField(""); 
        carTypeInput.setEditable(true); 
        carTypeInput.setColumns(15);

        currency = NumberFormat.getCurrencyInstance(); 
        rentalAmountInput = new JFormattedTextField(currency);
        rentalAmountInput.setEditable(true); 
        rentalAmountInput.setColumns(15); 
        rentalAmountInput.setValue(0);




        //button
        calculate = new JButton("Calculate"); 
        calculate.addChangeListener(this); 
        calculate.setBackground(Color.YELLOW); 
        calculate.setOpaque(true);  
        calculate.addActionListener(this);


        //layout 
        setLayout(new GridBagLayout()); 

        //position the first name label
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10);
        layout.gridx = 0; 
        layout.gridy = 0; 
        add(firstNameLabel,layout);


        //position the first name input field 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.gridx = 1; 
        layout.gridy = 0; 
        add(firstNameInput,layout);

        //position the last name label 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.gridx = 2;
        layout.gridy = 0;
        add(lastNameLabel,layout); 

        //position the last name input field 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.gridx = 3;
        layout.gridy = 0;   
        add(lastNameInput,layout);

        //position the weekdays label 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10);
        layout.anchor = GridBagConstraints.LINE_END; 
        layout.gridx = 0; 
        layout.gridy = 1; 
        add(weekDayLabel,layout); 

        //position the weekDay spinner 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10);
        layout.fill = GridBagConstraints.HORIZONTAL;
        layout.gridx = 1;
        layout.gridy = 1; 
        add(weekDaySpinner,layout);

        //position the weekEnd label 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.anchor = GridBagConstraints.CENTER; 
        layout.gridx = 2; 
        layout.gridy = 1; 
        add(weekEndLabel,layout);

        //position the spinner for weekends 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.fill = GridBagConstraints.HORIZONTAL; 
        layout.gridx = 3; 
        layout.gridy = 1; 
        add(weekEndSpinner,layout);

        //position the carType Label
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10);
        layout.gridx = 0;
        layout.gridy = 4; 
        add(carTypeLabel,layout);

        //position the carType input field
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.gridx = 1; 
        layout.gridy = 4; 
        add(carTypeInput,layout); 

        //position the rental amount paid label 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10);
        layout.gridx = 2; 
        layout.gridy = 4; 
        add(rentalAmountLabel,layout);


        //position the rentl amount input field 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.gridx = 3; 
        layout.gridy = 4; 
        add(rentalAmountInput,layout);

        //position the button
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.gridx = 4;
        layout.gridy = 4; 
        add(calculate,layout);

        //position the text area
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10);
        layout.gridx = 2; 
        layout.gridy = 5; 
        add(outputArea,layout);
      

        


    }

    @Override 
    public void stateChanged(ChangeEvent event) 
    {
    
        weekDay = (Integer) weekDaySpinner.getValue(); 
        weekEnd = (Integer) weekEndSpinner.getValue();

    } 


    @Override
    public void actionPerformed(ActionEvent event) 
     {
        double nationalAvg;
        String carType;
        String first; 
        String last;
        String fullname;
        String car;
        Integer weekD; 
        Integer weekE;
        double rentalPaid;
        String compareRental;


        first = firstNameInput.getText(); 
        last = lastNameInput.getText();
        car = carTypeInput.getText();
        carType = carTypeInput.getText(); 

        weekD = ((Number) weekDaySpinner.getValue()).intValue(); 
        weekE = ((Number) weekEndSpinner.getValue()).intValue();

        rentalPaid = ((Number) rentalAmountInput.getValue()).doubleValue();

        
        nationalAvg = calc.nationalAvg(carType,weekDay,weekEnd);
        compareRental = calc.compareRental(nationalAvg,rentalPaid);

        fullname = first + " " + last;

        outputArea.setText("Car Rental Calculator Result\n"); 

        outputArea.append("Customer: " + fullname + "\nCar Type: " + car + 
        "\nDays: " + weekD + "(weekdays) " + weekE + "(weekends)" +"\nPaid: " + df.format(rentalPaid) +
        "\nNational Average: " + nationalAvg + "\nRental Comparsion Result: " + compareRental);
     }




}