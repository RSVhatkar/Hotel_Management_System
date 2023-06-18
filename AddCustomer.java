import java.awt.Choice;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Date;
import java.sql.ResultSet;

import javax.swing.*;
public class AddCustomer extends JFrame implements ActionListener{

	JLabel text,id,number,name,gender,country,allocatedroomno,checkintime,checkintimelbl,deposite,background;
	JComboBox idcombo;
	JTextField numbertext,nametext,countrytext,depositetext;
	JRadioButton male,female;
	Choice croom;
	JButton add,back;
	
	AddCustomer()
	{
		setVisible(true);
		setLayout(null);
		setBounds(350,200,800,550);
		
		getContentPane().setBackground(Color.white);
		
		text=new JLabel("NEW CUSTOMER FORM");
		text.setBounds(100,20,300,30);
		text.setFont(new Font("Raleway",Font.BOLD,20));
		add(text);
		
		id=new JLabel("ID");
		id.setBounds(35,80,300,30);
		id.setFont(new Font("Raleway",Font.PLAIN,20));
		add(id);
		
		String idvalues[]= {"Adhar Card","Passport","Driving License","Voter-id Card","Ration Card"};
		idcombo=new JComboBox(idvalues);
		idcombo.setBounds(220,80,150,25);
		idcombo.setBackground(Color.white);
		add(idcombo);
		
		number=new JLabel("Number");
		number.setBounds(35,120,100,20);
		number.setFont(new Font("Raleway",Font.PLAIN,20));
		add(number);
		
		numbertext=new JTextField();
		numbertext.setBounds(220,120,150,25);
		add(numbertext);
		
		name=new JLabel("Name");
		name.setBounds(35,160,100,20);
		name.setFont(new Font("Raleway",Font.PLAIN,20));
		add(name);
		
		nametext=new JTextField();
		nametext.setBounds(220,160,150,25);
		add(nametext);
		
		gender=new JLabel("Gender");
		gender.setBounds(35,200,100,20);
		gender.setFont(new Font("Raleway",Font.PLAIN,20));
		add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(220,200,60,25);
		male.setBackground(Color.white);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(290,200,100,25);
		female.setBackground(Color.white);
		add(female);
		
		country=new JLabel("Country");
		country.setBounds(35,240,100,20);
		country.setFont(new Font("Raleway",Font.PLAIN,20));
		add(country);
		
		countrytext=new JTextField();
		countrytext.setBounds(220,240,150,25);
		add(countrytext);
		
		allocatedroomno=new JLabel("Room Number");
		allocatedroomno.setBounds(35,280,180,20);
		allocatedroomno.setFont(new Font("Raleway",Font.PLAIN,20));
		add(allocatedroomno);
		
		croom=new Choice();
		
		//to add values of allocated room no in choice 
		try
		{
			Conn c=new Conn();
			String query="select * from room where availability='Available'";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				croom.add(rs.getString("roomnumber"));
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		croom.setBounds(220,280,150,25);
		add(croom);
		
		checkintime=new JLabel("Checkin time");
		checkintime.setBounds(35,320,150,20);
		checkintime.setFont(new Font("Raleway",Font.PLAIN,20));
		add(checkintime);
		
		Date date=new Date();
		
		checkintimelbl=new JLabel(""+date);
		checkintimelbl.setBounds(220,320,220,25);
		checkintimelbl.setFont(new Font("Raleway",Font.PLAIN,16));
		add(checkintimelbl);
		
		deposite=new JLabel("Deposite");
		deposite.setBounds(35,360,100,20);
		deposite.setFont(new Font("Raleway",Font.PLAIN,20));
		add(deposite);
		
		depositetext=new JTextField();
		depositetext.setBounds(220,360,150,25);
		add(depositetext);
		
		add=new JButton("Add");
		add.setBounds(50,410,120,30);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add(add);
		add.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(220,410,120,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		
		ImageIcon img=new ImageIcon("icons/fifth.png");
		
		Image i=img.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
		
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(400,50,300,400);
		add(background);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==add)
		{
			String sid=(String) idcombo.getSelectedItem();
			String snumber=numbertext.getText();
			String sname=nametext.getText();
			
			String sgender=null;
			if(male.isSelected())
			{
				sgender="Male";
			}
			else
			{
				sgender="Female";
			}
			
			String scountry=countrytext.getText();
			String sroom=croom.getSelectedItem();
			String time=checkintimelbl.getText();
			String sdeposite=depositetext.getText();
			
			try
			{
				Conn c=new Conn();
				String query1="insert into customer values('"+sid+"','"+snumber+"','"+sname+"','"+sgender+"','"+scountry+"','"+sroom+"','"+time+"','"+sdeposite+"')";
				c.s.executeUpdate(query1);
				
				String query2="update room set availability='Occupied' where roomnumber= '"+sroom+"' ";
				c.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "New Customer added successfully");
				
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
		new AddCustomer();

	}

}
