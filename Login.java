import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
public class Login extends JFrame implements ActionListener{
	
	JLabel user,pass,background;
	JTextField username;
	JPasswordField password;
	JButton login,cancel;
	
	Login()
	{
		setBounds(500,200,600,300);
		setVisible(true);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		user=new JLabel("Username:");
		user.setBounds(40,20,100,30);
		add(user);
		
		username=new JTextField();
		username.setBounds(150,20,150,30);
		add(username);
		
		pass=new JLabel("Password");
		pass.setBounds(40,70,100,30);
		add(pass);
		
		password=new JPasswordField();
		password.setBounds(150,70,150,30);
		add(password);
		
		login=new JButton("Login");
		login.setBounds(40,150,120,30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		add(login);
		login.addActionListener(this);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(180,150,120,30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		add(cancel);
		cancel.addActionListener(this);
		
		ImageIcon img=new ImageIcon("icons/second.jpg");//to take image
		
		Image i=img.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);//to crop image
		
		ImageIcon imgnew=new ImageIcon(i);//again convert croped image to ImageIcon
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(350,10,200,200);
		add(background);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==login)
		{
			String getusername=username.getText();
			String getpassword=password.getText();
			
			
			if(getusername.equals("") && getpassword.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Enter Username and Password");
			}
			else if(getusername.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Username");
			}
			else if(getpassword.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Password");
			}
			else
			{
				try
				{
					Conn c=new Conn();
					String query="select * from login where username= '"+getusername+"' and password= '"+getpassword+"' ";
					ResultSet rs=c.s.executeQuery(query);
					if(rs.next())
					{
						setVisible(false);
						new Dashboard();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Username or Password");
						setVisible(false);
					}
				}
				catch(Exception e)
				{
					System.out.print(e);
				}
			}
		}
		else if(ae.getSource()==cancel)
		{
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Login();

	}

}
