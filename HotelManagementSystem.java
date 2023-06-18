import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;

import javax.swing.*;
public class HotelManagementSystem extends JFrame implements ActionListener{
	
	JLabel background,text;
	JButton next;
	
	HotelManagementSystem()
	{
		setSize(1366,565);
		setLocation(100,100);
		setLayout(null);
		setVisible(true);
		
		ImageIcon img=new ImageIcon("icons/first.jpg");
		
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,1366,565);
		add(background);
		
		text=new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(20,430,1000,90);
		text.setFont(new Font("Serif",Font.PLAIN,50));
		text.setForeground(Color.white);
		background.add(text);
		
		next=new JButton("Next");
		next.setBounds(1150,450,150,50);
		next.setBackground(Color.white);
		next.setForeground(Color.MAGENTA);
		next.setFont(new Font("Serif",Font.PLAIN,24));
		background.add(next);
		next.addActionListener(this);
		
		while(true)
		{
			//to hide text for 500milisec
			text.setVisible(false);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
			
			//to show text for 500milisec
			text.setVisible(true);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==next)
		{
			setVisible(false);
			new Login();
		}
	}

	public static void main(String[] args) {
		new HotelManagementSystem();

	}

}
