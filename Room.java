import java.awt.Color;
import java.awt.Image;
import java.sql.ResultSet;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.*;//to display data in JTable and for this rs2xml.jar file is included
public class Room extends JFrame implements ActionListener{

	JLabel background,roomheading,availabilityheading,cleaningstatusheading,priceheading,bedtypeheading;
	JTable table;
	JButton back;
	
	Room()
	{
		setVisible(true);
		setLayout(null);
		setBounds(300,200,1050,600);
		
		getContentPane().setBackground(Color.white);
		
		ImageIcon img=new ImageIcon("icons/eight.jpg");
		
		Image i=img.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
		
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(500,0,600,600);
		add(background);
		
		roomheading=new JLabel("Room Number");
		roomheading.setBounds(10,10,100,20);
		add(roomheading);
		
		availabilityheading=new JLabel("Availability");
		availabilityheading.setBounds(120,10,100,20);
		add(availabilityheading);
		
		cleaningstatusheading=new JLabel("Status");
		cleaningstatusheading.setBounds(230,10,100,20);
		add(cleaningstatusheading);
		
		priceheading=new JLabel("Price");
		priceheading.setBounds(330,10,100,20);
		add(priceheading);
		
		bedtypeheading=new JLabel("Bed Type");
		bedtypeheading.setBounds(410,10,100,20);
		add(bedtypeheading);
		
		table=new JTable();
		table.setBounds(0,40,500,400);
		add(table);
		
		try
		{
			Conn c=new Conn();
			String query="select * from room";
			ResultSet rs=c.s.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));//to put data in table
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		back=new JButton("Back");
		back.setBounds(200,500,120,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==back)
		{
			setVisible(false);
			new Reception();
		}
	}
	
	public static void main(String[] args) {
		new Room();

	}

}
