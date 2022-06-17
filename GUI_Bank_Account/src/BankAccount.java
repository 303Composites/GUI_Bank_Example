/*
Create a simple Graphical User Interface (GUI) Bank Balance application. 
The application must obtain the BankAccount balance from a user, and then display 
that balance within a JPanel when the user selects a button. The program should
 allow for the user to deposit and withdraw funds from their account using a simple 
 interface. The remaining balance in the account should be displayed before exiting 
 the program. Ensure that your application includes the following components:

JPanel
JButton
ActionListener
Submit screenshots of your program’s execution and output. Include all appropriate source code in a zip file.
*/

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BankAccount extends JFrame implements ActionListener {

   private JLabel accountBalance;    // Label for account balance
   private JLabel depositAmount;     // Label for deposit amount
   private JLabel withdrawAmount;    // Label for the withdraw amount
   private JTextField accountBal;    // Displays current account balance
   private JTextField depositBal;    // Displays the amount to deposit
   private JTextField withdrawBal;	//  Displays the amount to withdraw
   private JButton submitButton;       // Triggers new account balance 
   private JButton logOutButton;	// Exits the program "Logging out"

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   BankAccount() {
      // Used to specify GUI component layout
      GridBagConstraints positionConst = null;

      // Set frame's title
      setTitle("Bank Account Summary");

      // Set hourly and yearly salary labels
      accountBalance = new JLabel("Your account Balance is: $");
      depositAmount = new JLabel("Enter amount to deposit: $");
      withdrawAmount = new JLabel ("Enter amount to withdraw: $");
      
      
    
      accountBal = new JTextField(15);
      accountBal.setText("1000"); // setting the initial value to something
      accountBal.setEditable(false);
      
      depositBal = new JTextField(15);
      depositBal.setText("0");
      depositBal.setEditable(true);
      
      withdrawBal = new JTextField(15);
      withdrawBal.setText ("0");
      withdrawBal.setEditable(true);
      
   
      JButton submitButton = new JButton("Complete your transaction");
      JButton logOutButton = new JButton("Log Out");
    
      
      // Use "this" class to handle button presses
      submitButton.addActionListener(this);

      // Use a GridBagLayout
      setLayout(new GridBagLayout());
      positionConst = new GridBagConstraints();

      // Specify component's grid location
      positionConst.gridx = 0;
      positionConst.gridy = 0;
      
      // 10 pixels of padding around component
      positionConst.insets = new Insets(10, 10, 10, 10);
      
      // Add component using the specified constraints
      add(accountBalance, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 0;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(accountBal, positionConst);  //label

      positionConst.gridx = 0;
      positionConst.gridy = 1;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(depositAmount, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 1;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(depositBal, positionConst);
      
      positionConst.gridx = 0;
      positionConst.gridy = 3;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(withdrawAmount, positionConst);
      
      positionConst.gridx = 1;
      positionConst.gridy = 3;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(withdrawBal, positionConst);

      positionConst.gridx = 0;
      positionConst.gridy = 4;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(submitButton, positionConst);
      
      positionConst.gridx = 1;
      positionConst.gridy = 4;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(logOutButton, positionConst);
      
      
   }/*
   public void actionPerformed(java.awt.event.ActionEvent e) {
	      logOutButton.addActionListener(new ActionListener()
	        { public void actionPerformer(ActionEvent e)
	    	  {System.exit(0);
	        }});
	    }*/
	      
   /* Method is automatically called when an event 
      occurs (e.g, button is pressed) */
   @Override
   public void actionPerformed(ActionEvent event) {
      String userInput;      // User deposit
      String userIn; 		// User withdraw
      String userI;			// User account balance
      int depositVal;        
      int withdrawVal;
      int accountVal;
      

      // Get users account input
      userInput = depositBal.getText();
      userIn = withdrawBal.getText();
      userI = accountBal.getText();
      // Convert from String to an int 
      depositVal = Integer.parseInt(userInput);
      withdrawVal = Integer.parseInt(userIn);
      accountVal = Integer.parseInt(userI);
      
      accountVal = (accountVal + depositVal -withdrawVal);
      // Display new account balance
      if (accountVal < 0 ) {
    	  System.out.println("You do not have enough money to withdraw\n "
    	  		+ "please add more funds to your account");
   
      }
      else if (accountVal > 0){
    	  accountBal.setText(Integer.toString(accountVal));
      }


   }

   /* Creates a BankAccountFrame and makes it visible */
   public static void main(String[] args) {
      // Creates BankAccountFrame and its components
      BankAccount myFrame = new BankAccount();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}