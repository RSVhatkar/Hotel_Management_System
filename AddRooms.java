import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
public class AddRooms extends JFrame implements ActionListener{
	
	JLabel heading,roomno,available,cleaningstatus,price,bedtype,background;
	JTextField roomnotext,pricetext;
	JComboBox roomavaibility,cleaningstatuscombo,bedtypecombo;
	JButton addroom,cancel;

	AddRooms()
	{
		setBounds(330,200,940,470);
		setVisible(true);
		setLayout(null);
		
		heading=new JLabel("Add Rooms");
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		heading.setBounds(150,20,200,20);
		add(heading);
		
		roomno=new JLabel("Room Number");
		roomno.setFont(new Font("Tahoma",Font.PLAIN,16));
		roomno.setBounds(60,80,120,30);
		add(roomno);
		
		roomnotext=new JTextField();
		roomnotext.setBounds(200,80,150,30);
		add(roomnotext);
		
		available=new JLabel("Available");
		available.setFont(new Font("Tahoma",Font.PLAIN,16));
		available.setBounds(60,130,120,30);
		add(available);
		
		String roomavaibilityval[]= {"Available","Occupied"};
		roomavaibility=new JComboBox(roomavaibilityval);
		roomavaibility.setBounds(200,130,150,30);
		roomavaibility.setBackground(Color.white);
		add(roomavaibility);
		
		cleaningstatus=new JLabel("Cleaning Status");
		cleaningstatus.setFont(new Font("Tahoma",Font.PLAIN,16));
		cleaningstatus.setBounds(60,180,120,30);
		add(cleaningstatus);
		
		String cleaningstatusval[]= {"Cleaned","Dirty"};
		cleaningstatuscombo=new JComboBox(cleaningstatusval);
		cleaningstatuscombo.setBounds(200,180,150,30);
		cleaningstatuscombo.setBackground(Color.white);
		add(cleaningstatuscombo);
		
		price=new JLabel("Price");
		price.setFont(new Font("Tahoma",Font.PLAIN,16));
		price.setBounds(60,230,120,30);
		add(price);
		
		pricetext=new JTextField();
		pricetext.setBounds(200,230,150,30);
		add(pricetext);
		
		bedtype=new JLabel("Bed Type");
		bedtype.setBounds(60,280,120,30);
		bedtype.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(bedtype);
		
		String bedtypeval[]= {"Single bed","Double bed"};
		bedtypecombo=new JComboBox(bedtypeval);
		bedtypecombo.setBounds(200,280,150,30);
		bedtypecombo.setBackground(Color.white);
		add(bedtypecombo);
		
		addroom=new JButton("Add Room");
		addroom.setBounds(60,350,130,30);
		addroom.setBackground(Color.black);
		addroom.setForeground(Color.white);
		add(addroom);
		addroom.addActionListener(this);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(270,350,130,30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		add(cancel);
		cancel.addActionListener(this);
		
		ImageIcon img=new ImageIcon("icons/twelve.jpg");
		
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(400,30,500,300);
		add(background);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==addroom)
		{
			String sroomno=roomnotext.getText();
			String sroomavaibility=(String) roomavaibility.getSelectedItem();
			String scleaningstatus=(String) cleaningstatuscombo.getSelectedItem();
			String sprice=pricetext.getText();
			String sbedtype=(String) bedtypecombo.getSelectedItem();
			
			try
			{
				Conn c=new Conn();
				String query="insert into room values('"+sroomno+"','"+sroomavaibility+"','"+scleaningstatus+"','"+sprice+"','"+sbedtype+"')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"New room added successfully");
				
				setVisible(false);
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		else
		{
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new AddRooms();

	}

}
