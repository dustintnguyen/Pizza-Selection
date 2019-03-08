/*Dustin Nguyen*/
//import lib
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;


public class PizzaSelectionFrame extends JFrame{
	private JComboBox <String> imagesComboBox;
	private JLabel picture;
        //Make array of pizza for combo box
       	private static String [] names= {"Chicken Pizza","Pepperoni Pizza", "Veggie Pizza"};
        //add the image that goes with the right pizza
	private Icon [] icons= {
 		new ImageIcon("chicken.PNG"),
 		new ImageIcon("pepperoni.PNG"),
 		new ImageIcon("veggie.PNG")};
        private JLabel size;
        private ButtonGroup size_buttons;
        private JRadioButton small;
        private JRadioButton medium;
        private JRadioButton large;
        private JLabel toppings;
        private JCheckBox mushrooms;
        private JCheckBox bacon;
        private JButton submitorder;
        public String tops;
        

	public PizzaSelectionFrame() {
                //Title
		super("Order Pizza");
                //Set Layout
                setLayout(new FlowLayout());
                setSize(350,350);
                setLocation(600, 400);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                getContentPane().setBackground(Color.LIGHT_GRAY);
                
                
                //Make image change to selected item in combo box
                imagesComboBox= new JComboBox<String>(names);
                //Add item listener to combo box
                imagesComboBox.addItemListener(new ItemListener(){
                		public void itemStateChanged(ItemEvent e){
                			if (e.getStateChange()==ItemEvent.SELECTED){
                			picture.setIcon(icons[imagesComboBox.getSelectedIndex()]);
                		}
                        }
                	});
                picture = new JLabel(icons[0]);
                //Add iagmes and combo box
                add(picture);
                add(imagesComboBox);

                //make size label and buttons
                size = new JLabel("Select Size: ");
                add(size);
                size_buttons = new ButtonGroup();
                small = new JRadioButton("Small");
                medium = new JRadioButton("Medium");
                large = new JRadioButton("Large");
                

                //add buttons to frame than into button gourp
                add(small);
                add(medium);
                add(large);
                size_buttons.add(small);
                size_buttons.add(medium);
                size_buttons.add(large);

                //Make topping label
                toppings = new JLabel("Select Topping(s): ");
                add(toppings);
                mushrooms = new JCheckBox("Mushroons");
                bacon = new JCheckBox("Bacon");
                add(mushrooms);
                add(bacon);
                

                //make submit button
                submitorder = new JButton("Submit Order");
                add(submitorder);
                //add action listener to buton
                submitorder.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                                String tops = "";
                                //prints  toppings
                                if(mushrooms.isSelected() && bacon.isSelected()){
                                        tops = " with mushrooms and bacon";
                                }
                                else if (mushrooms.isSelected()){
                                        tops = " with mushrooms";
                                }
                                else if (bacon.isSelected()) {
                                        tops = "with bacon";
                                }
                                //String selected pizza from combobox 
                                String pizza = imagesComboBox.getSelectedItem().toString();
                                String order = "";
                                //print size of pizza
                                if(small.isSelected()){
                                        order = "Order Summary: Small size " + pizza + tops;
                                }
                                
                                else if (medium.isSelected()){
                                        order = "Order Summary: Medium size " + pizza + tops;
                                }
                                
                                else if (large.isSelected()){
                                        order = "Order Summary: Large size " + pizza + tops;
                                }
                                //if ok is selected new payment window pop-up
                                int n = JOptionPane.showOptionDialog(PizzaSelectionFrame.this, order,"Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
                                if (n == 0){
                                        new PaymentFrame();
                                        setVisible(false);
                                    }
                                else{
                                    setVisible(true);
                                }
                        }
                        });
                
        
        
}

public static void main(String[] args) {
        PizzaSelectionFrame f = new PizzaSelectionFrame();
        //Set visible
        f.setVisible(true);
        }
}