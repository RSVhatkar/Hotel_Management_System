import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
public class AddDriver extends JFrame implements ActionListener{
	
	JLabel background,heading,name,age,gender,company,model,driveravailability,location;
	JTextField nametext,agetext,companytext,modeltext,locationtext;
	JComboBox gendercombo,driveravailabilitycombo;
	JButton adddriver,cancel;

	AddDriver()
	{
		setVisible(true);
		setLayout(null);
		setBounds(300,200,900,470);
		
		getContentPane().setBackground(Color.white);
		
		heading=new JLabel("Add Drivers");
		heading.setBounds(150,10,200,20);
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		add(heading);
		
		name=new JLabel("Name");
		name.setBounds(60,70,120,30);
		name.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(name);
		
		nametext=new JTextField();
		nametext.setBounds(200,70,150,30);
		add(nametext);
		
		age=new JLabel("Age");
		age.setBounds(60,110,120,30);
		age.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(age);
		
		agetext=new JTextField();
		agetext.setBounds(200,110,150,30);
		add(agetext);
		
		gender=new JLabel("Gender");
		gender.setBounds(60,150,120,30);
		gender.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(gender);
		
		String genderval[]= {"Male","Female"};
		gendercombo=new JComboBox(genderval);
		gendercombo.setBounds(200,150,150,30);
		gendercombo.setBackground(Color.white);
		add(gendercombo);
		
		company=new JLabel("Car Company");
		company.setBounds(60,190,170,30);
		company.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(company);
		
		companytext=new JTextField();
		companytext.setBounds(200,190,150,30);
		add(companytext);
		
		model=new JLabel("Car Model");
		model.setBounds(60,230,120,30);
		model.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(model);
		
		modeltext=new JTextField();
		modeltext.setBounds(200,230,150,30);
		add(modeltext);
		
		driveravailability=new JLabel("Availability");
		driveravailability.setBounds(60,270,120,30);
		driveravailability.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(driveravailability);
		
		String driveravailabilitycomboval[]= {"Available","Busy"};
		driveravailabilitycombo=new JComboBox(driveravailabilitycomboval);
		driveravailabilitycombo.setBounds(200,270,150,30);
		driveravailabilitycombo.setBackground(Color.white);
		add(driveravailabilitycombo);
		
		location=new JLabel("Location");
		location.setBounds(60,310,120,30);
		location.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(location);
		
		locationtext=new JTextField();
		locationtext.setBounds(200,310,150,30);
		add(locationtext);
		
		adddriver=new JButton("Add Driver");
		adddriver.setBounds(60,370,130,30);
		adddriver.setBackground(Color.black);
		adddriver.setForeground(Color.white);
		add(adddriver);
		adddriver.addActionListener(this);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(220,370,130,30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		add(cancel);
		cancel.addActionListener(this);
		
		ImageIcon img=new ImageIcon("icons/eleven.jpg");
		
		Image i=img.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
		
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(400,30,500,300);
		add(background);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==adddriver)
		{
			String sname=nametext.getText();
			String sage=agetext.getText();
			String sgender=(String) gendercombo.getSelectedItem();
			String scarcompany=companytext.getText();
			String scarmodel=modeltext.getText();
			String savailability=(String) driveravailabilitycombo.getSelectedItem();
			String slocation=locationtext.getText();
			
			try
			{
				Conn c=new Conn();
				String query="insert into driver values('"+sname+"','"+sage+"','"+sgender+"','"+scarcompany+"','"+scarmodel+"','"+savailability+"','"+slocation+"')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"New Driver added successfully");
				
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
		new AddDriver();

	}

}
