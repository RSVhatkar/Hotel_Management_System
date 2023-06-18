import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class EmployeeInfo extends JFrame implements ActionListener{

	JButton back;
	JTable table;
	JLabel name,age,gender,job,salary,phone,email,adharno;
	
	EmployeeInfo()
	{
		setLayout(null);
		setVisible(true);
		setBounds(300,200,1050,600);
		
		getContentPane().setBackground(Color.white);
		
		name=new JLabel("Name");
		name.setBounds(40,10,100,20);
		add(name);
		
		age=new JLabel("Age");
		age.setBounds(170,10,100,20);
		add(age);
		
		gender=new JLabel("Gender");
		gender.setBounds(290,10,100,20);
		add(gender);
		
		job=new JLabel("Job");
		job.setBounds(400,10,100,20);
		add(job);
		
		salary=new JLabel("Salary");
		salary.setBounds(540,10,100,20);
		add(salary);
		
		phone=new JLabel("Phone");
		phone.setBounds(670,10,100,20);
		add(phone);
		
		email=new JLabel("Email");
		email.setBounds(790,10,100,20);
		add(email);
		
		adharno=new JLabel("Adhar Number");
		adharno.setBounds(930,10,100,20);
		add(adharno);
		
		table=new JTable();
		table.setBounds(0,40,1050,400);
		add(table);
		
		try
		{
			Conn c=new Conn();
			String query="select * from employee";
			ResultSet rs=c.s.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		back=new JButton("Back");
		back.setBounds(420,500,120,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Reception();
	}
	
	public static void main(String[] args) {
		new EmployeeInfo();

	}

}
