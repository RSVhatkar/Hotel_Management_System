import java.awt.Choice;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
public class Checkout extends JFrame implements ActionListener{

	JLabel backgroundimg,checkout,customerid,background,roomno,roomnolbl,checkin,checkinlbl,checkouttime,checkouttimelbl;
	Choice id;
	JButton checkoutbtn,back;
	
	Checkout()
	{
		setVisible(true);
		setBounds(300,200,800,400);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		checkout=new JLabel("Checkout");
		checkout.setBounds(100,20,100,30);
		checkout.setFont(new Font("Tahoma",Font.PLAIN,20));
		checkout.setForeground(Color.blue);
		add(checkout);
		
		customerid=new JLabel("Customer ID");
		customerid.setBounds(30,80,100,30);
		customerid.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(customerid);
		
		id=new Choice();
		id.setBounds(150,80,150,25);
		add(id);
				
		ImageIcon img=new ImageIcon("icons/tick.png");
		
		Image i=img.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
		
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(310,80,20,20);
		add(background);
		
		roomno=new JLabel("Room Number");
		roomno.setBounds(30,130,150,30);
		roomno.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(roomno);
		
		roomnolbl=new JLabel();
		roomnolbl.setBounds(150,130,100,30);
		roomnolbl.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(roomnolbl);
		
		checkin=new JLabel("Checkin Time");
		checkin.setBounds(30,180,100,30);
		checkin.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(checkin);
		
		checkinlbl=new JLabel();
		checkinlbl.setBounds(150,180,250,30);
		checkinlbl.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(checkinlbl);
		
		checkouttime=new JLabel("Checkout Time");
		checkouttime.setBounds(30,230,120,30);
		checkouttime.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(checkouttime);
		
		Date date=new Date();
		
		checkouttimelbl=new JLabel(""+date);
		checkouttimelbl.setBounds(150,230,250,30);
		checkouttimelbl.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(checkouttimelbl);
		
		checkoutbtn=new JButton("Checkout");
		checkoutbtn.setBounds(30,280,120,30);
		checkoutbtn.setBackground(Color.black);
		checkoutbtn.setForeground(Color.white);
		add(checkoutbtn);
		checkoutbtn.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(170,280,120,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		
		//to fetch number ie customer id from customer table
		try
		{
			Conn c= new Conn();
			String query="select * from customer";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				id.add(rs.getString("number"));
				roomnolbl.setText(rs.getString("room"));
				checkinlbl.setText(rs.getString("checkintime"));
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		ImageIcon img1=new ImageIcon("icons/sixth.jpg");
		
		Image i1=img1.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
		
		ImageIcon imgnew1=new ImageIcon(i1);
		
		backgroundimg=new JLabel("",imgnew1,JLabel.CENTER);
		backgroundimg.setBounds(350,50,400,250);
		add(backgroundimg);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==checkoutbtn)
		{
			Conn c=new Conn();
			String query1="delete from customer where number= '"+id.getSelectedItem()+"' ";
			String query2="update room set availability= 'Available' where roomnumber= '"+roomnolbl.getText()+"' ";
			try
			{
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null,"Checkout done");
				
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
		new Checkout();

	}

}
