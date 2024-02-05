import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.JTree;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;

public class LoginPage extends JFrame implements ActionListener{
	
	
	private JPanel contentPane;
	private JTextField textField_1, textField_2, textField_3;
	private JButton btnNewButton_1, btnNewButton_2, btnNewButton, btnNewButton_3;
	public JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6, lblNewLabel_7, lblNewLabel_8;
	JTextPane txtpnUserId;
	static Customer VecObj=new Customer();
	static Scanner file_in;
	/**
	 * Launch the application.
	 */
	static LoginPage frame;
	private JPasswordField passwordField;
	static PrintWriter fout;

	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void actionPerformed(ActionEvent E)
	{
		if(E.getSource()==btnNewButton)
		{
			lblNewLabel.setVisible(false);
			lblNewLabel_1.setVisible(false);
			txtpnUserId.setVisible(false);
			lblNewLabel_2.setVisible(false);
			lblNewLabel_3.setVisible(false);
			passwordField.setVisible(false);
			lblNewLabel_4.setVisible(false);
			btnNewButton_1.setVisible(false);
			btnNewButton.setVisible(false);
			lblNewLabel_5.setVisible(true);
			lblNewLabel_6.setVisible(true);
			lblNewLabel_7.setVisible(true);
			lblNewLabel_8.setVisible(true);
			textField_1.setVisible(true);
			textField_2.setVisible(true);
			btnNewButton_2.setVisible(true);
			textField_3.setVisible(true);
			btnNewButton_3.setVisible(true);
		}
		else if(E.getSource()==btnNewButton_2)
		{
			if(textField_1.getText().equals("") || textField_2.getText().equals("")|| textField_3.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "You have left one or more empty text fields!");
			}
			else
			{
				try
				{
					String str=textField_1.getText().replaceAll("\\s", "_")+" "+ textField_2.getText().replaceAll("\\s", "_")+" "+ Integer.parseInt(textField_3.getText().replaceAll("\\s", "_"))+" "+(VecObj.CustomersList.size()+1000);
					JOptionPane.showMessageDialog(null, "Dear "+ textField_1.getText()+", \nThank you for registering in KU Gifts Store \nPlease note that you must sign in with your user id, which is: "+(VecObj.CustomersList.size()+1000));
					Print(str);
					Read(fout);
					
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
				}
				catch(InputMismatchException e)
				{
					JOptionPane.showMessageDialog(null, "Please use text for name and password and digits without decimals for phone number");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Please use text for name and password and digits without decimals for phone number");
				}
				
			}
		}
		else if(E.getSource()==btnNewButton_3)
		{
			Read(fout);
			lblNewLabel.setVisible(true);
			lblNewLabel_1.setVisible(true);
			txtpnUserId.setVisible(true);
			lblNewLabel_2.setVisible(true);
			lblNewLabel_3.setVisible(true);
			passwordField.setVisible(true);
			lblNewLabel_4.setVisible(true);
			btnNewButton_1.setVisible(true);
			btnNewButton.setVisible(true);
			lblNewLabel_5.setVisible(false);
			lblNewLabel_6.setVisible(false);
			lblNewLabel_7.setVisible(false);
			lblNewLabel_8.setVisible(false);
			textField_1.setVisible(false);
			textField_2.setVisible(false);
			btnNewButton_2.setVisible(false);
			textField_3.setVisible(false);
			btnNewButton_3.setVisible(false);
		}
		else if(E.getSource()==btnNewButton_1)
		{
			
			
			Read(fout);
			char[] c=passwordField.getPassword();
			String p=new String(c);
			System.out.println(p);
			if(txtpnUserId.getText().equals("") || p.equals(""))
			{
				JOptionPane.showMessageDialog(null, "You have left at least one empty text field, please fill up all the data");
			}
			else if(txtpnUserId.getText().charAt(0)=='k')
			{
				AdminFrame f1=new AdminFrame();
				String[][] Data=f1.AdminsData();
				boolean x=true;
				for (int i=0; i<Data.length;i++)
				{
					if(txtpnUserId.getText().equals(Data[i][1]))
					{
						if(p.equals(Data[i][2]))
						{
							AdminFrame f2=new AdminFrame(Data[i][0], Data[i][1], Data[i][2]);
							f2.setVisible(true);
							dispose();
							x=false;
						}
					}
				}
				if(x)
					JOptionPane.showMessageDialog(null, "Invalid Password or user ID");
				
			}
			else if(txtpnUserId.getText().toLowerCase().equals("ahmed"))
			{
				AdminFrame f2=new AdminFrame("Ahmed","Admin1", "2021");
				f2.setVisible(true);
				dispose();
			}
			
			else if(txtpnUserId.getText().charAt(0)=='1')
			{
				
				String n, Pass, ID;
				int Pnr;
				try {
					file_in=new Scanner(new FileReader("Customers Data"));
					while(file_in.hasNext())
					{
						try
						{
							n=file_in.next();
						Pass=file_in.next();
						Pnr=file_in.nextInt();
						ID=file_in.next();
						if(ID.equals(txtpnUserId.getText()) && p.equals(Pass))
						{
							CustomerFrame f12=new CustomerFrame(n, Pnr, ID);
							f12.setVisible(true);
							dispose();
						}
						}
						catch (InputMismatchException e)
						{
							JOptionPane.showMessageDialog(null, "Please use text for name and Password, and digits without decimals for phone number");
						}
						catch (NumberFormatException e)
						{
							JOptionPane.showMessageDialog(null, "Please use text for name and Password, and digits without decimals for phone number");
						}
						catch (Exception e)
						{
							
						}
			}
				}
					catch(FileNotFoundException error)
					{
						
					}}
			else
				JOptionPane.showMessageDialog(null, "Invalid Password or username");
				}
		
	}

	/**
	 * Create the frame.
	 */
	
	public LoginPage() {
		Read(fout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setVisible(true);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Welcome To KU Gifts Store");
		lblNewLabel.setBounds(250, 27, 418, 61);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(true);
		
		lblNewLabel_1 = new JLabel("Sign in");
		lblNewLabel_1.setBounds(426, 84, 67, 61);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(true);
		
		txtpnUserId = new JTextPane();
		txtpnUserId.setBounds(344, 143, 251, 38);
		txtpnUserId.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(txtpnUserId);
		txtpnUserId.setVisible(true);
		
		lblNewLabel_2 = new JLabel("User ID: ");
		lblNewLabel_2.setBounds(250, 143, 84, 38);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setLabelFor(txtpnUserId);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(true);
		
		lblNewLabel_3 = new JLabel("Password: ");
		lblNewLabel_3.setBounds(234, 200, 100, 38);
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(true);
		
		lblNewLabel_4 = new JLabel("New Customer? Sign Up Here");
		lblNewLabel_4.setBounds(752, 396, 199, 26);
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(true);
		
		btnNewButton_1=new JButton("Login");
		btnNewButton_1.setBounds(409, 253, 108, 38);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setVisible(true);
		btnNewButton_1.addActionListener(this);
		
		lblNewLabel_5 = new JLabel("Please enter your information: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel_5.setBounds(218, 89, 472, 38);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		lblNewLabel_6 = new JLabel("Name: ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_6.setBounds(234, 143, 86, 38);
		contentPane.add(lblNewLabel_6);
		lblNewLabel_6.setVisible(false);
		
		lblNewLabel_7 = new JLabel("Phone number: ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_7.setBounds(172, 265, 162, 32);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_7.setVisible(false);
		
		lblNewLabel_8 = new JLabel("Password: ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_8.setBounds(234, 206, 116, 27);
		contentPane.add(lblNewLabel_8);
		lblNewLabel_8.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(336, 143, 259, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(336, 205, 259, 38);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		
		textField_3 = new JTextField();
		textField_3.setBounds(336, 267, 259, 38);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(false);
		
		btnNewButton_2 = new JButton("Sign up");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(409, 339, 108, 38);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setVisible(false);
		btnNewButton_2.addActionListener(this);
		
		btnNewButton = new JButton("Sign up");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(793, 422, 116, 31);
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(true);
		btnNewButton.addActionListener(this);
		
		btnNewButton_3 = new JButton("Back");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_3.setBounds(10, 10, 108, 38);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.setVisible(false);
		btnNewButton_3.addActionListener(this);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		passwordField.setBounds(344, 206, 251, 38);
		contentPane.add(passwordField);
		passwordField.setVisible(true);
	}
	public void Print(String str)
	{
		PrintWriter fout;
		
		try
		{
			fout=new PrintWriter(new FileOutputStream(new File("Customers Data"),true));
			fout.println(str);
			fout.close();
		}
		catch(FileNotFoundException E)
		{
			E.toString();
		}
	}

	public void Read(PrintWriter F)
	{
		
		VecObj.CustomersList.clear();
		String n, Pass, ID;
		int Pnr;
		try {
			file_in=new Scanner(new FileReader("Customers Data"));
			while(file_in.hasNextLine())
			{
				try
				{
					n=file_in.next();
				Pass=file_in.next();
				Pnr=file_in.nextInt();
				ID=file_in.next();
				VecObj.CustomersList.add(new Customer(n, Pass, Pnr, ID));
				}
				catch (InputMismatchException e)
				{
					JOptionPane.showMessageDialog(null, "Please use text for name and Password, and digits without decimals for phone number");
				}
				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Please use text for name and Password, and digits without decimals for phone number");
				}
				catch (Exception e)
				{
					
				}
				
			}
			
		}
		catch(FileNotFoundException error)
		{
			
		}
	}

	}
	


