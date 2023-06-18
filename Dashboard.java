import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
public class Dashboard extends JFrame implements ActionListener{

	JLabel background,text;
	JMenuBar mb;
	JMenu hotel,admin;
	JMenuItem reception,addemployee,addroom,adddriver;
	
	Dashboard()
	{
		setVisible(true);
		setBounds(0,0,1550,1000);
		setLayout(null);
		
		ImageIcon img=new ImageIcon("icons/third.jpg");
		
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,1550,1000);
		add(background);
		
		text=new JLabel("THE TAJ GROUP WELCOMES YOU");
		text.setBounds(400,80,1000,50);
		text.setFont(new Font("Tahoma",Font.PLAIN,40));
		text.setForeground(Color.white);
		background.add(text);
		
		mb=new JMenuBar();
		mb.setBounds(0,0,1550,30);
		background.add(mb);
		
		hotel=new JMenu("HOTEL MANAGEMENT");
		hotel.setForeground(Color.red);
		mb.add(hotel);
		
		reception=new JMenuItem("RECEPTION");
		reception.addActionListener(this);
		hotel.add(reception);
		
		admin=new JMenu("ADMIN");
		admin.setForeground(Color.blue);
		mb.add(admin);
		
		addemployee=new JMenuItem("ADD EMPLOYEE");
		addemployee.addActionListener(this);
		admin.add(addemployee);
		
		addroom=new JMenuItem("ADD ROOM");
		addroom.addActionListener(this);
		admin.add(addroom);
		
		adddriver=new JMenuItem("ADD DRIVER");
		adddriver.addActionListener(this);
		admin.add(adddriver);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("RECEPTION"))
		{
			new Reception();
		}
		else if(ae.getActionCommand().equals("ADD EMPLOYEE"))//getActionCommand() is used to get text of menubar
		{
			new AddEmployee();
		}
		else if(ae.getActionCommand().equals("ADD ROOM"))
		{
			new AddRooms();
		}
		else if(ae.getActionCommand().equals("ADD DRIVER"))
		{
			new AddDriver();
		}
	}
	public static void main(String[] args) {
		new Dashboard();

	}

}
