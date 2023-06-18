import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener{

	JButton newcustomer,rooms,department,allemployees,cutomerinfo,managerinfo,checkout,updatestatus,updateroomstatus,pickupservice,searchroom,logout;
	JLabel background;
	
	Reception()
	{
		setVisible(true);
		setLayout(null);
		setBounds(350,200,800,570);
		
		getContentPane().setBackground(Color.white);
		
		newcustomer=new JButton("New Customer Form");
		newcustomer.setBounds(10,30,200,30);
		newcustomer.setBackground(Color.black);
		newcustomer.setForeground(Color.white);
		add(newcustomer);
		newcustomer.addActionListener(this);
		
		rooms=new JButton("Rooms");
		rooms.setBounds(10,70,200,30);
		rooms.setBackground(Color.black);
		rooms.setForeground(Color.white);
		add(rooms);
		rooms.addActionListener(this);
		
		department=new JButton("Department");
		department.setBounds(10,110,200,30);
		department.setBackground(Color.black);
		department.setForeground(Color.white);
		add(department);
		department.addActionListener(this);
		
		allemployees=new JButton("All Employees");
		allemployees.setBounds(10,150,200,30);
		allemployees.setBackground(Color.black);
		allemployees.setForeground(Color.white);
		add(allemployees);
		allemployees.addActionListener(this);
		
		cutomerinfo=new JButton("Customer Info");
		cutomerinfo.setBounds(10,190,200,30);
		cutomerinfo.setBackground(Color.black);
		cutomerinfo.setForeground(Color.white);
		add(cutomerinfo);
		cutomerinfo.addActionListener(this);
		
		managerinfo=new JButton("Manager Info");
		managerinfo.setBounds(10,230,200,30);
		managerinfo.setBackground(Color.black);
		managerinfo.setForeground(Color.white);
		add(managerinfo);
		managerinfo.addActionListener(this);
		
		checkout=new JButton("Checkout");
		checkout.setBounds(10,270,200,30);
		checkout.setBackground(Color.black);
		checkout.setForeground(Color.white);
		add(checkout);
		checkout.addActionListener(this);
		
		updatestatus=new JButton("Update Status");
		updatestatus.setBounds(10,310,200,30);
		updatestatus.setBackground(Color.black);
		updatestatus.setForeground(Color.white);
		add(updatestatus);
		updatestatus.addActionListener(this);
		
		updateroomstatus=new JButton("Update Room Status");
		updateroomstatus.setBounds(10,350,200,30);
		updateroomstatus.setBackground(Color.black);
		updateroomstatus.setForeground(Color.white);
		add(updateroomstatus);
		updateroomstatus.addActionListener(this);
		
		pickupservice=new JButton("Pickup Service");
		pickupservice.setBounds(10,390,200,30);
		pickupservice.setBackground(Color.black);
		pickupservice.setForeground(Color.white);
		add(pickupservice);
		pickupservice.addActionListener(this);
		
		searchroom=new JButton("Search Room");
		searchroom.setBounds(10,430,200,30);
		searchroom.setBackground(Color.black);
		searchroom.setForeground(Color.white);
		add(searchroom);
		searchroom.addActionListener(this);
		
		logout=new JButton("Logout");
		logout.setBounds(10,470,200,30);
		logout.setBackground(Color.black);
		logout.setForeground(Color.white);
		add(logout);
		logout.addActionListener(this);
		
		ImageIcon img=new ImageIcon("icons/fourth.jpg");
		
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(250,30,500,470);
		add(background);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==newcustomer)
		{
			setVisible(false);
			new AddCustomer();
		}
		else if(ae.getSource()==rooms)
		{
			setVisible(false);
			new Room();
		}
		else if(ae.getSource()==department)
		{
			setVisible(false);
			new Department();
		}
		else if(ae.getSource()==allemployees)
		{
			setVisible(false);
			new EmployeeInfo();
		}
		else if(ae.getSource()==managerinfo)
		{
			setVisible(false);
			new ManagerInfo();
		}
		else if(ae.getSource()==cutomerinfo)
		{
			setVisible(false);
			new CustomerInfo();
		}
		else if(ae.getSource()==searchroom)
		{
			setVisible(false);
			new SearchRoom();
		}
		else if(ae.getSource()==updatestatus)
		{
			setVisible(false);
			new UpdateCheck();
		}
		else if(ae.getSource()==updateroomstatus)
		{
			setVisible(false);
			new UpdateRoom();
		}
		else if(ae.getSource()==pickupservice)
		{
			setVisible(false);
			new Pickup();
		}
		else if(ae.getSource()==checkout)
		{
			setVisible(false);
			new Checkout();
		}
		else if(ae.getSource()==logout)
		{
			setVisible(false);
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Reception();

	}

}
