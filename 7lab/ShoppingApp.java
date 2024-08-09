package slab7;
/*Write a java program using Swing to perform the following:
Allow the user to enter the item purchased by giving the item id and quantity
purchased.
On clicking of a button, the item name and the total cost should appear in the
corresponding GUI components.
Using option dialog box, indicate the types of discount available for the
customer. On clicking on the print button, print the details of final cost in
information dialog box.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
public class ShoppingApp implements ActionListener {
	double total=0.0;
	JFrame jf;
	JLabel jl1, jl2, jl3, jl4, jl5, jl6;
	JTextField userid, phno, itemId, quantity, itemName, totalCost;
    JButton submit, printButton;
	static ArrayList<items> items=new ArrayList<items>();
	
	ShoppingApp() {
		String id=JOptionPane.showInputDialog(null, "New user, Enter new id");
		String ph=JOptionPane.showInputDialog(null, "Enter Phone Number");
		jf=new JFrame("Item Details");
		jl1=new JLabel("User ID");
		jl2=new JLabel("Phone Number");
		jl3=new JLabel("Item ID");
		jl4=new JLabel("Quantity");
		jl5=new JLabel("Item Name");
		jl6=new JLabel("Total Cost");
		userid=new JTextField(20);
		phno=new JTextField(20);;
		itemId=new JTextField(20);
		quantity=new JTextField(20);
		itemName=new JTextField(20);
		totalCost=new JTextField(20);
		submit=new JButton("Submit");
		printButton=new JButton("Print");
		jf.add(jl1); jf.add(userid); userid.setText(id);
		jf.add(jl2); jf.add(phno); phno.setText(ph);
		jf.add(jl3); jf.add(itemId);
		jf.add(jl4); jf.add(quantity);
		jf.add(jl5); jf.add(itemName);
		jf.add(jl6); jf.add(totalCost);
		jf.add(submit);
		jf.add(printButton);
		submit.addActionListener(this);
		printButton.addActionListener(this);
		jf.setSize(600, 600);
		jf.setLayout(new GridLayout(12, 2));
		jf.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit) {
			String itemId1=itemId.getText();
			int quantity1=Integer.parseInt(quantity.getText());
			for(items item: items) {
				if(item.id.equals(itemId1)) {
					itemName.setText(item.name);
					total=quantity1*item.price;
					totalCost.setText(String.valueOf(total));
					break;
				}
			}
			String discounts[]= {"5", "10", "15"};
			int r=JOptionPane.showOptionDialog(null, "Select discount", "Discount",
											   JOptionPane.DEFAULT_OPTION,
											   JOptionPane.QUESTION_MESSAGE,
											   null, discounts, discounts[0]);
			if(r!=-1) {
				total=total-(total*0.01*Integer.parseInt(discounts[r]));
				totalCost.setText(String.valueOf(total));
			}
		}
		if(ae.getSource()==printButton) {
			String itemName1=itemName.getText();
			String totalCost1=totalCost.getText();
			JOptionPane.showMessageDialog(null, "Item: "+itemName1+"\nTotal Cost: "+totalCost1);
		}
	}
	
	public static void main(String[] args) {
		items.add(new items("Bat", "1", 5000));
		items.add(new items("Gloves", "2", 2000));
		items.add(new items("Ball", "3", 600));
		new Shop();
	}
}