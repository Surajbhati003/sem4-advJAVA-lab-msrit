package slab6;
/*Create a desktop java application using swings to enable a user to enter 
student information such as name, usn, age, address, sgpa of 4 semesters,category.
Perform validations on all the fields. Display appropriate messages in pop up boxes to indicate wrong entries.
On clicking of the “compute” button, find the cgpa. On clicking of the
“done” button, place the student details in a collection. Display the
collection in a textarea on the click of a button.*/
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StudentManagement implements ActionListener {
	ArrayList<Student> arr=new ArrayList<>();
	static JFrame jf;
	JPanel jp;
	JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9;
	JTextField name, usn, address, age, sgpa1, sgpa2, sgpa3, sgpa4, category;
	JButton compute, done, display;
	JTextArea jt;
	double cgpa;
	double[] sgpas=new double[4];
	StudentManagement() {
		jf=new JFrame("Student Management System");
		jp=new JPanel(new GridLayout(12, 2));
		jl1=new JLabel("Enter name: ");
		jl2=new JLabel("Enter usn: ");
		jl3=new JLabel("Enter address: ");
		jl4=new JLabel("Enter age: ");
		jl5=new JLabel("Enter sgpa1: ");
		jl6=new JLabel("Enter sgpa2: ");
		jl7=new JLabel("Enter sgpa3: ");
		jl8=new JLabel("Enter sgpa4: ");
		jl9=new JLabel("Enter category: ");
		name=new JTextField(20);
		usn=new JTextField(20);
		address=new JTextField(20);
		age=new JTextField(20);
		sgpa1=new JTextField(20);
		sgpa2=new JTextField(20);
		sgpa3=new JTextField(20);
		sgpa4=new JTextField(20);
		category=new JTextField(20);
		jt=new JTextArea(5, 50);
		compute=new JButton("Compute CGPA");
		done=new JButton("Add Student");
		display=new JButton("Display");
		jp.add(jl1); jp.add(name);
		jp.add(jl2); jp.add(usn);
		jp.add(jl3); jp.add(address);
		jp.add(jl4); jp.add(age);
		jp.add(jl5); jp.add(sgpa1);
		jp.add(jl6); jp.add(sgpa2);
		jp.add(jl7); jp.add(sgpa3);
		jp.add(jl8); jp.add(sgpa4);
		jp.add(jl9); jp.add(category);
		jp.add(compute);
		jp.add(done);
		jp.add(display);
		jp.add(jt);
		jf.add(jp);
		jf.setSize(600, 600);
		jf.setVisible(true);
		compute.addActionListener(this);
		done.addActionListener(this);
		display.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==compute) {
			try {
				sgpas[0]=Double.parseDouble(sgpa1.getText());
				sgpas[1]=Double.parseDouble(sgpa2.getText());
				sgpas[2]=Double.parseDouble(sgpa3.getText());
				sgpas[3]=Double.parseDouble(sgpa4.getText());
				double sum=0.0;
				for(double sgpa: sgpas) {
					sum+=sgpa;
				}
				cgpa=sum/4;
				JOptionPane.showMessageDialog(null, "Final cgpa: "+cgpa);
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please enter valid sgpa values");
			}
		}
		if(ae.getSource()==done) {
			String name1=name.getText();
			String usn1=usn.getText();
			String address1=address.getText();
			int age1=Integer.parseInt(age.getText());
			if(name1.isEmpty() || usn1.isEmpty() || address1.isEmpty()) {
				JOptionPane.showMessageDialog(null, "All Fields must be filled");
				return;
			}
			Student s1=new Student(name1, address1, usn1, age1, cgpa);
			arr.add(s1);
			JOptionPane.showMessageDialog(null, "Student details added successfully");
		}
		if(ae.getSource()==display) {
			jt.setText("");
			for(Student s: arr) {
				jt.append(s.toString()+"\n");
			}
		}
	}
	
	public static void main(String[] args) {
		new StudentManagement();
	}
}