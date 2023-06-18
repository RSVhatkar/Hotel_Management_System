import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.awt.event.*;
import javax.swing.*;
public class UpdateCheck extends JFrame implements ActionListener{

	JLabel text,id,roomno,name,checkin,amountpaid,pendingamount,background;
	Choice customer;
	JTextField roomtext,nametext,checkintext,amountpaidtext,pendingamounttext;
	JButton check,update,back;
	
	UpdateCheck()
	{
		setVisible(true);
		setLayout(null);
		setBounds(300,200,900,500);
		
		getContentPane().setBackground(Color.white);
		
		text=new JLabel("Update Status");
		text.setBounds(90,20,200,30);
		text.setFont(new Font("Tahoma",Font.PLAIN,20));
		text.setForeground(Color.blue);
		add(text);
		
		id=new JLabel("Customer ID");
		id.setBounds(20,80,100,20);
		id.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(id);
		
		customer=new Choice();
		customer.setBounds(200,80,150,25);
		add(customer);
		
		try
		{
			Conn c=new Conn();
			String query="select * from customer";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				customer.add(rs.getString("number"));
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		roomno=new JLabel("Room Number");
		roomno.setBounds(20,120,120,20);
		roomno.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(roomno);
		
		roomtext=new JTextField();
		roomtext.setBounds(200,120,150,25);
		add(roomtext);
		
		name=new JLabel("Name");
		name.setBounds(20,160,100,20);
		name.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(name);
		
		nametext=new JTextField();
		nametext.setBounds(200,160,150,25);
		add(nametext);
		
		checkin=new JLabel("Checkin Time");
		checkin.setBounds(20,200,100,20);
		checkin.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(checkin);
		
		checkintext=new JTextField();
		checkintext.setBounds(200,200,150,20);
		add(checkintext);
		
		amountpaid=new JLabel("Amount Paid");
		amountpaid.setBounds(20,240,100,20);
		amountpaid.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(amountpaid);
		
		amountpaidtext=new JTextField();
		amountpaidtext.setBounds(200,240,150,20);
		add(amountpaidtext);
		
		pendingamount=new JLabel("Pending Amount");
		pendingamount.setBounds(20,280,150,20);
		pendingamount.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(pendingamount);
		
		pendingamounttext=new JTextField();
		pendingamounttext.setBounds(200,280,150,20);
		add(pendingamounttext);
		
		check=new JButton("Check");
		check.setBounds(30,340,100,30);
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		add(check);
		check.addActionListener(this);
		
		update=new JButton("Update");
		update.setBounds(150,340,100,30);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		add(update);
		update.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(270,340,100,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		
		ImageIcon img=new ImageIcon("icons/nine.jpg");
		
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(400,50,500,300);
		add(background);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==check)
		{
			String scustomer=customer.getSelectedItem();
			String query="select * from customer where number= '"+scustomer+"' ";
			try
			{
				Conn c=new Conn();
				ResultSet rs=c.s.executeQuery(query);
				while(rs.next())
				{
					roomtext.setText(rs.getString("room"));
					nametext.setText(rs.getString("name"));
					checkintext.setText(rs.getString("checkintime"));
					amountpaidtext.setText(rs.getString("deposite"));
				}
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
			
			try
			{
				Conn c=new Conn();
				String sroomnumber=roomtext.getText();
				String query2="select * from room where roomnumber= '"+sroomnumber+"' ";
				ResultSet rs=c.s.executeQuery(query2);
				while(rs.next())
				{
					String sprice=rs.getString("price");
					int amountpaid=Integer.parseInt(sprice)-Integer.parseInt(amountpaidtext.getText());//calculating pending amount
					pendingamounttext.setText(""+amountpaid);
				}
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		else if(ae.getSource()==update)
		{
			String scustomer=customer.getSelectedItem();
			String sroom=roomtext.getText();
			String sname=nametext.getText();
			String scheckin=checkintext.getText();
			String sdeposite=amountpaidtext.getText();
			
			try
			{
				Conn c=new Conn();
				c.s.executeUpdate("update customer set room= '"+sroom+"' , name= '"+sname+"' , checkintime= '"+scheckin+"' ,deposite= '"+sdeposite+"' where number= '"+scustomer+"' ");
				JOptionPane.showMessageDialog(null,"Data Updated Successfully");
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
		new UpdateCheck();

	}

}
