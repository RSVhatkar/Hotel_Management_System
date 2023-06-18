import java.awt.Color;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.sql.*;
public class CustomerInfo extends JFrame implements ActionListener{

	JButton back;
	JTable table;
	JLabel document,number,name,gender,country,room,checkintime,deposite;
	
	CustomerInfo()
	{
		setVisible(true);
		setBounds(300,200,1050,600);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		document=new JLabel("Document Type");
		document.setBounds(40,10,100,20);
		add(document);
		
		number=new JLabel("Number");
		number.setBounds(170,10,100,20);
		add(number);
		
		name=new JLabel("Name");
		name.setBounds(290,10,100,20);
		add(name);
		
		gender=new JLabel("Gender");
		gender.setBounds(400,10,100,20);
		add(gender);
		
		country=new JLabel("Country");
		country.setBounds(540,10,100,20);
		add(country);
		
		room=new JLabel("Room");
		room.setBounds(670,10,100,20);
		add(room);
		
		checkintime=new JLabel("Checkin");
		checkintime.setBounds(790,10,100,20);
		add(checkintime);
		
		deposite=new JLabel("Deposite");
		deposite.setBounds(930,10,100,20);
		add(deposite);
		
		table=new JTable();
		table.setBounds(0,40,1050,400);
		add(table);
		
		try
		{
			Conn c=new Conn();
			String query="select * from customer";
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
		new CustomerInfo();

	}

}

