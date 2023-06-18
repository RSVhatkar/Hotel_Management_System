import java.awt.Color;
import java.awt.event.*;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.*;
public class UpdateRoom extends JFrame implements ActionListener{

	JLabel text,id,roomno,availability,cleaningstatus,background;
	Choice customerid;
	JTextField roomnotext,availabilitytext,cleaningstatustext;
	JButton check,update,back;
	
	UpdateRoom()
	{
		setVisible(true);
		setLayout(null);
		setBounds(300,200,900,450);
		
		getContentPane().setBackground(Color.white);
		
		text=new JLabel("Update Room Status");
		text.setBounds(30,20,250,30);
		text.setFont(new Font("Tahoma",Font.PLAIN,25));
		text.setForeground(Color.blue);
		add(text);
		
		id=new JLabel("Customer ID");
		id.setBounds(30,80,100,20);
		id.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(id);
		
		customerid=new Choice();
		customerid.setBounds(200,80,150,20);
		add(customerid);
		
		//to fetch customer id from custommer table
		try
		{
			Conn c=new Conn();
			String query="select * from customer";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				customerid.add(rs.getString("number"));
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		roomno=new JLabel("Room Number");
		roomno.setBounds(30,130,150,20);
		roomno.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(roomno);
		
		roomnotext=new JTextField();
		roomnotext.setBounds(200,130,150,25);
		add(roomnotext);
		
		availability=new JLabel("Availability");
		availability.setBounds(30,180,100,20);
		availability.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(availability);
		
		availabilitytext=new JTextField();
		availabilitytext.setBounds(200,180,150,25);
		add(availabilitytext);
		
		cleaningstatus=new JLabel("Cleaning Status");
		cleaningstatus.setBounds(30,230,150,20);
		cleaningstatus.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(cleaningstatus);
		
		cleaningstatustext=new JTextField();
		cleaningstatustext.setBounds(200,230,150,25);
		add(cleaningstatustext);
		
		check=new JButton("Check");
		check.setBounds(30,300,100,30);
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		add(check);
		check.addActionListener(this);
		
		update=new JButton("Update");
		update.setBounds(150,300,100,30);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		add(update);
		update.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(270,300,100,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		
		ImageIcon img=new ImageIcon("icons/seventh.jpg");
		
		Image i=img.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
		
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(400,50,500,300);
		add(background);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==check)
		{
			String sid=customerid.getSelectedItem();
			try
			{
				Conn c=new Conn();
				String query="select * from customer where number= '"+sid+"' ";//to fetch room no 
				ResultSet rs=c.s.executeQuery(query);
				while(rs.next())
				{
					roomnotext.setText(rs.getString("room"));
				}
				
				String query1="select * from room where roomnumber= '"+roomnotext.getText()+"' ";//to fetch room details
				ResultSet rs1=c.s.executeQuery(query1);
				while(rs1.next())
				{
					availabilitytext.setText(rs1.getString("availability"));
					cleaningstatustext.setText(rs1.getString("cleaningstatus"));
				}
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		else if(ae.getSource()==update)
		{
			String customer=customerid.getSelectedItem();
			String sroomno=roomnotext.getText();
			String savailability=availabilitytext.getText();
			String scleaningstatus=cleaningstatustext.getText();
			
			try
			{
				Conn c=new Conn();
				String query="update room set availability= '"+savailability+"',cleaningstatus= '"+scleaningstatus+"' where roomnumber= '"+sroomno+"' ";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Data Updated Successfully");
				
				setVisible(false);
				new Reception();
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
		new UpdateRoom();

	}

}
