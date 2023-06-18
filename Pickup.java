import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.awt.Choice;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class Pickup extends JFrame implements ActionListener{
	
	JLabel pickupservice,typeofcar,name,age,gender,company,model,available,location;
	Choice cartype;
	JTable table;
	JButton submit,back;

	Pickup()
	{
		setVisible(true);
		setLayout(null);
		setBounds(300,200,1000,600);
		
		getContentPane().setBackground(Color.white);
		
		pickupservice=new JLabel("Pickup Service");
		pickupservice.setBounds(400,30,200,30);
		pickupservice.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(pickupservice);
		
		typeofcar=new JLabel("Type of car");
		typeofcar.setBounds(50,100,100,20);
		typeofcar.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(typeofcar);
		
		cartype=new Choice();
		cartype.setBounds(150,100,200,25);
		add(cartype);
		
		//to fetch typeof car from driver table
		try
		{
			Conn c=new Conn();
			String query="select * from driver";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				cartype.add(rs.getString("model"));
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		name=new JLabel("Name");
		name.setBounds(30,160,100,20);
		name.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(name);
		
		age=new JLabel("Age");
		age.setBounds(200,160,100,20);
		age.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(age);
		
		gender=new JLabel("Gender");
		gender.setBounds(330,160,100,20);
		gender.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(gender);
		
		company=new JLabel("Company");
		company.setBounds(460,160,100,20);
		company.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(company);
		
		model=new JLabel("Model");
		model.setBounds(630,160,100,20);
		model.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(model);
		
		available=new JLabel("Avaiable");
		available.setBounds(740,160,100,20);
		available.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(available);
		
		location=new JLabel("Location");
		location.setBounds(890,160,100,20);
		location.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(location);
		
		table=new JTable();
		table.setBounds(0,200,1000,300);
		add(table);
		
		//to fetch all info of driver
		try
		{
			Conn c=new Conn();
			String query="select * from driver";
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
			String stypeofcar=cartype.getSelectedItem();
			//to fetch info of selected car type
			try
			{
				Conn c=new Conn();
				String query="select * from driver where model= '"+stypeofcar+"' ";
				ResultSet rs=c.s.executeQuery(query);
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
		new Pickup();

	}

}
