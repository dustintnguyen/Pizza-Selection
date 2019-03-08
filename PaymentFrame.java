/*Dustin Nguyen*/
//import lib
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class PaymentFrame extends JFrame {
	private JLabel name;
	private JLabel address;
	private JLabel ccn;
	private JLabel expDate;
	private JLabel cvc;
	private JTextField name_field;
	private JTextField address_field;
	private JTextField ccn_field;
	private JTextField expDate_field;
	private JTextField cvc_field;
	private JButton pay;

	public PaymentFrame(){
		//title
		super("Payment");
		setVisible(true);
		//set size
        setSize(600,200);
        setLocation(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
		//set gridlayout with gaps
		setLayout(new GridLayout(6,2,5,5 ));
		//Label Jlabel and fields to add in order
		name = new JLabel("Name and Surname:");
		name_field = new JTextField(20);
		address =new JLabel("Address:");
		address_field =new JTextField(20);
		ccn =new JLabel("Credit Card NUmber:");
		ccn_field = new JTextField(20);
		expDate =new JLabel("Expiration Date:");
		expDate_field = new JTextField(20);
		cvc =new JLabel("CVC:");
		cvc_field = new JTextField(20);
		pay = new JButton("Pay");
		//add elements to layout
		add(name);
		add(name_field);
	  	add(address);
	  	add(address_field);
	  	add(ccn);
	  	add(ccn_field);
	  	add(expDate);
	  	add(expDate_field);
	 	add(cvc);
	 	add(cvc_field);
		add(pay);
		// add actionlistener to button
		pay.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//If ok is selected program exits
				int result = JOptionPane.showConfirmDialog(PaymentFrame.this, "Your order will be delivered in 30 minutes","Message", JOptionPane.DEFAULT_OPTION);
				if(result == 0 ) System.exit(0);
			}
		});
		}

public static void main(String[] args) {
		PaymentFrame f = new PaymentFrame();
		f.setVisible(true);
        
}
}
