import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
public class AddEmployee extends JFrame implements ActionListener{

	JLabel name,age,gender,job,salary,phone,email,background,adharno;
	JTextField nametext,agetext,salarytext,phonetext,emailtext,adharnotext;
	JRadioButton male,female;
	JComboBox jobcombo;
	JButton submit;
	
	AddEmployee()
	{
		setLayout(null);
		setVisible(true);
		setBounds(350,200,850,540);
		
		getContentPane().setBackground(Color.white);
		
		name=new JLabel("NAME");
		name.setBounds(60,30,120,30);
		name.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(name);
		
		nametext=new JTextField();
		nametext.setBounds(200,30,150,30);
		add(nametext);
		
		age=new JLabel("AGE");
		age.setBounds(60,80,120,30);
		age.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(age);
		
		agetext=new JTextField();
		agetext.setBounds(200,80,150,30);
		add(agetext);
		
		gender=new JLabel("GENDER");
		gender.setBounds(60,130,120,30);
		gender.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(200,130,70,30);
		male.setFont(new Font("Tahoma",Font.PLAIN,17));
		male.setBackground(Color.white);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(280,130,100,30);
		female.setFont(new Font("Tahoma",Font.PLAIN,17));
		female.setBackground(Color.white);
		add(female);
		
		ButtonGroup gendergroup=new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		job=new JLabel("JOB");
		job.setBounds(60,180,120,30);
		job.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(job);
		
		String jobvalue[]= {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Manager","Accountant"};
		jobcombo=new JComboBox(jobvalue);
		jobcombo.setBounds(200,180,150,30);
		jobcombo.setBackground(Color.white);
		add(jobcombo);
		
		salary=new JLabel("SALARY");
		salary.setBounds(60,230,120,30);
		salary.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(salary);
		
		salarytext=new JTextField();
		salarytext.setBounds(200,230,150,30);
		add(salarytext);
		
		phone=new JLabel("PHONE");
		phone.setBounds(60,280,120,30);
		phone.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(phone);
		
		phonetext=new JTextField();
		phonetext.setBounds(200,280,150,30);
		add(phonetext);
		
		email=new JLabel("EMAIL");
		email.setBounds(60,330,120,30);
		email.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(email);
		
		emailtext=new JTextField();
		emailtext.setBounds(200,330,150,30);
		add(emailtext);
		
		adharno=new JLabel("ADHAR NO");
		adharno.setBounds(60,380,120,30);
		adharno.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(adharno);
		
		adharnotext=new JTextField();
		adharnotext.setBounds(200,380,150,30);
		add(adharnotext);
		
		submit=new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setBounds(200,430,150,30);
		add(submit);
		submit.addActionListener(this);
		
		ImageIcon img=new ImageIcon("icons/tenth.jpg");
		
		Image i=img.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(380,60,450,370);
		add(background);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==submit)
		{
			String sname=nametext.getText();
			String sage=agetext.getText();
			
			String sgender=null;
			if(male.isSelected())
			{
				sgender="Male";
			}
			else if(female.isSelected())
			{
				sgender="Female";
			}
			
			String sjob=(String) jobcombo.getSelectedItem();
			
			String ssalary=salarytext.getText();
			String sphone=phonetext.getText();
			String semail=emailtext.getText();
			String sadharno=adharnotext.getText();
			
			try
			{
				Conn c=new Conn();
				String query="insert into employee values('"+sname+"','"+sage+"','"+sgender+"','"+sjob+"','"+ssalary+"','"+sphone+"','"+semail+"','"+sadharno+"')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"Employee added successfully");
				
				setVisible(false);
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
	}
	
	public static void main(String[] args) {
		new AddEmployee();

	}

}
