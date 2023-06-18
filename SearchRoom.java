import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class SearchRoom extends JFrame implements ActionListener{

	JLabel text,bedtype,roomheading,availabilityheading,cleaningstatusheading,priceheading,bedtypeheading;
	JComboBox bedtypecombo;
	JCheckBox available;
	JTable table;
	JButton submit,back;
	
	SearchRoom()
	{
		setVisible(true);
		setBounds(300,200,1000,600);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		text=new JLabel("Search for Room");
		text.setBounds(400,30,200,30);
		text.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(text);
		
		bedtype=new JLabel("Bed Type");
		bedtype.setBounds(50,100,100,20);
		bedtype.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(bedtype);
		
		String bedtypeval[]= {"Single Bed","Double Bed"};
		bedtypecombo=new JComboBox(bedtypeval);
		bedtypecombo.setBounds(150,100,150,25);
		bedtypecombo.setBackground(Color.white);
		add(bedtypecombo);
		
		available=new JCheckBox("Only display available");
		available.setBounds(650,100,250,25);
		available.setFont(new Font("Tahoma",Font.PLAIN,18));
		available.setBackground(Color.white);
		add(available);
		
		roomheading=new JLabel("Room Number");
		roomheading.setBounds(50,160,100,20);
		add(roomheading);
		
		availabilityheading=new JLabel("Availability");
		availabilityheading.setBounds(270,160,100,20);
		add(availabilityheading);
		
		cleaningstatusheading=new JLabel("Cleaning Status");
		cleaningstatusheading.setBounds(450,160,100,20);
		add(cleaningstatusheading);
		
		priceheading=new JLabel("Price");
		priceheading.setBounds(670,160,100,20);
		add(priceheading);
		
		bedtypeheading=new JLabel("Bed Type");
		bedtypeheading.setBounds(870,160,100,20);
		add(bedtypeheading);
		
		table=new JTable();
		table.setBounds(0,200,1000,300);
		add(table);
		
		//disp all room details
		try
		{
			Conn c=new Conn();
			String query="select * from room";
			ResultSet rs=c.s.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		submit=new JButton("Submit");
		submit.setBounds(300,520,120,30);
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		add(submit);
		submit.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(500,520,120,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==submit)
		{
			String type=(String) bedtypecombo.getSelectedItem();
			try
			{
				Conn c=new Conn();
				ResultSet rs;
				
				String query1="select * from room where bedtype= '"+type+"' ";
				String query2="select * from room where availability= 'Available' AND bedtype= '"+type+"' ";
				
				if(available.isSelected())
				{
					rs=c.s.executeQuery(query2);
				}
				else
				{
					rs=c.s.executeQuery(query1);
				}
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		else
		{
			setVisible(false);
			new Reception();
		}
	}
	
	public static void main(String[] args) {
		new SearchRoom();

	}

}
