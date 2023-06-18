import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class Department extends JFrame implements ActionListener{

	JLabel department,budget;
	JTable table;
	JButton back;
	
	Department()
	{
		setLayout(null);
				
		getContentPane().setBackground(Color.white);
		
		department=new JLabel("Department");
		department.setBounds(180,10,100,20);
		add(department);
		
		budget=new JLabel("Budget");
		budget.setBounds(420,10,100,20);
		add(budget);
		
		table=new JTable();
		table.setBounds(0,50,700,350);
		add(table);
		
		try
		{
			Conn c=new Conn();
			String query="select * from department";
			ResultSet rs=c.s.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		back=new JButton("Back");
		back.setBounds(280,400,120,30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		
		setBounds(300,200,700,500);
		setVisible(true);
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
		new Department();

	}

}
