import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.*;
import javax.swing.JComboBox;

public class CustomerFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	static Products VecObj=new Products();
	static Scanner file_in, fq, fq2;
	static String[][] data, dataCart;
	static PrintWriter fout, fqout, fqout2;
	static String columnsNames[]= {"Product Name", "Product Price", "Available Quantity", "Product Size"};
	static String columnsNames1[]= {"Product Name", "Product Price", "Product Size", "Quantity in cart"};
	private JTable table=new JTable(data, columnsNames);
	private JTable table1=new JTable(dataCart, columnsNames1);;
	JScrollPane scrollPane=new JScrollPane(table);
	JScrollPane scrollPane1=new JScrollPane(table1);
	private JTextField textField;;
	private JButton btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3, btnNewButton_4;
	private JLabel lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_7;
	JComboBox comboBox;
	private JLabel lblNewLabel;
	private JTextField textField_1, textField_4;
	private JLabel lblNewLabel_4;
	private JComboBox comboBox_1;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JLabel lblNewLabel_5;
	private JTextField textField_2;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JLabel lblNewLabel_6;
	String n;
	int p;
	/**
	 * Launch the application.
	 */


	@Override
	public void actionPerformed(ActionEvent E) {
		if (E.getSource()==comboBox)
		{
			
			textField.setEnabled(true);
			btnNewButton.setEnabled(true);
			textField.setText("1");
		}
		else if(E.getSource()==btnNewButton)
		{
			
			boolean assump=false;
			for(int i=0; i<VecObj.CartList.size(); i++)
			{
				if(VecObj.CartList.elementAt(i).getName().equals(VecObj.ProductsList.elementAt(comboBox.getSelectedIndex()).getName())
						&& VecObj.CartList.elementAt(i).getSize()==VecObj.ProductsList.elementAt(comboBox.getSelectedIndex()).getSize())
				{
					assump=true;
					JOptionPane.showMessageDialog(null, "Item Already in cart!");
					break;
				}
			}
			if(!assump) 
			{
				try
				{
					int x=Integer.parseInt(textField.getText());
					if(textField.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Please enter a quantity");
					else if(x<=0)
						JOptionPane.showMessageDialog(null, "Please enter a digit number quantity that is bigger than zero");
					else if(x>VecObj.ProductsList.elementAt(comboBox.getSelectedIndex()).getQuantity())
					{
						JOptionPane.showMessageDialog(null, "OOps! we dont't have enough quantity, Please re enter a quantity that is less than or equal "+VecObj.ProductsList.elementAt(comboBox.getSelectedIndex()).getQuantity());
					}
					else
					{
						Products Object=new Products();
						Object.setName(VecObj.ProductsList.elementAt(comboBox.getSelectedIndex()).getName());
						Object.setPrice(VecObj.ProductsList.elementAt(comboBox.getSelectedIndex()).getPrice());
						Object.setSize(VecObj.ProductsList.elementAt(comboBox.getSelectedIndex()).getSize());
						Object.setBought_quantity(x);
						Object.setQuantity(VecObj.ProductsList.elementAt(comboBox.getSelectedIndex()).getQuantity());
						VecObj.CartList.add(Object);
						JOptionPane.showMessageDialog(null, "Item successfully added to cart");
					}
				}
				catch(InputMismatchException e)
				{
					JOptionPane.showMessageDialog(null, "Please enter a digit number quantity that is bigger than zero and without decimals");
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Please enter a digit number quantity that is bigger than zero and without decimals");
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
			}
			
		}
		else if(E.getSource()==btnNewButton_4)
		{
			if(!textField_1.getText().equals(""))
			{
				boolean assump=false;
				for (int i=0; i<VecObj.ProductsList.size(); i++)
				{
					if(data[i][0].equals(textField_1.getText()))
						{
							assump=true;
							table.setRowSelectionInterval(i, i);
							JOptionPane.showMessageDialog(null, "The searched product is blue highlighted, please see it in the table.");
							break;
						}
				}
				if(!assump)
				{
					JOptionPane.showMessageDialog(null, "There is no product with this name");
				}
			}
			else
				JOptionPane.showMessageDialog(null, "Please Enter the proudct name in the text field");
		}
		else if(E.getSource()==btnNewButton_1)
		{
			table.setVisible(false);
			scrollPane.setVisible(false);
			dataCart=new String[VecObj.CartList.size()][4];
			for(int i=0; i<VecObj.CartList.size(); i++)
			{
				dataCart[i][0]=VecObj.CartList.elementAt(i).getName();
				dataCart[i][1]=""+VecObj.CartList.elementAt(i).getPrice();
				dataCart[i][2]=VecObj.CartList.elementAt(i).getSize();
				dataCart[i][3]=""+VecObj.CartList.elementAt(i).getBought_quantity();
			}
			
			btnNewButton_8.setVisible(true);
			
			lblNewLabel_4.setVisible(true);
			comboBox_1.setVisible(true);
			lblNewLabel.setVisible(false);
			lblNewLabel_1.setVisible(false);
			lblNewLabel_2.setVisible(false);
			lblNewLabel_3.setVisible(false);
			btnNewButton.setVisible(false);
			btnNewButton_1.setVisible(false);
			btnNewButton_2.setVisible(false);
			
			btnNewButton_4.setVisible(false);
			textField.setVisible(false);
			textField_1.setVisible(false);
			comboBox.setVisible(false);
			btnNewButton_2.setVisible(false);
			table1=new JTable(dataCart, columnsNames1);
			table1.setEnabled(false);
			table1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			table1.setFillsViewportHeight(true);
			table1.setShowGrid(true);
			
			
			
			contentPane.add(table1);
			table1.setRowSelectionAllowed(true);
			table1.setSurrendersFocusOnKeystroke(false);
			table1.setFont(new Font("Tahoma", Font.PLAIN, 17));
			
			table1.setBounds(2, 26, 450, 400);
			table1.setRowHeight(20);
				scrollPane1 = new JScrollPane(table1);
				scrollPane1.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				
				scrollPane1.setBounds(98, 74, 695, 257);
				getContentPane().add(scrollPane1);
				scrollPane1.setVisible(true);
				table1.setVisible(true);
		}
		else if(E.getSource()==btnNewButton_2)
		{
			
			
			table=new JTable(data, columnsNames);
			table.setEnabled(false);
			table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			table.setFillsViewportHeight(true);
			table.setShowGrid(true);
			
			
			
			contentPane.add(table);
			table.setRowSelectionAllowed(true);
			table.setSurrendersFocusOnKeystroke(false);
			table.setFont(new Font("Tahoma", Font.PLAIN, 17));
			
			table.setBounds(2, 26, 450, 400);
			table.setRowHeight(20);
				scrollPane = new JScrollPane(table);
				scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				
				scrollPane.setBounds(98, 74, 695, 257);
				getContentPane().add(scrollPane);
				scrollPane.setVisible(true);
			
			lblNewLabel.setVisible(true);
			lblNewLabel_1.setVisible(true);
			lblNewLabel_2.setVisible(true);
			lblNewLabel_3.setVisible(true);
			btnNewButton.setVisible(true);
			btnNewButton_1.setVisible(true);
			btnNewButton_2.setVisible(true);
			btnNewButton_3.setVisible(true);
			btnNewButton_4.setVisible(true);
			textField.setVisible(true);
			textField_1.setVisible(true);
			comboBox.setVisible(true);
			btnNewButton_2.setVisible(false);
			btnNewButton_5.setVisible(false);
			btnNewButton_6.setVisible(false);
			btnNewButton_7.setVisible(false);
			btnNewButton_8.setVisible(false);
			textField_2.setVisible(false);
			lblNewLabel_4.setVisible(false);
			lblNewLabel_5.setVisible(false);
			comboBox_1.setVisible(false);
			lblNewLabel_6.setVisible(false);
			scrollPane1.setVisible(false);
			
			
		}
		else if(E.getSource()==comboBox_1)
		{
			btnNewButton_5.setVisible(true);
			btnNewButton_6.setVisible(true);
		}
		else if(E.getSource()==btnNewButton_5)
		{
			int index=comboBox_1.getSelectedIndex();
			JOptionPane.showMessageDialog(null, "You have succesfully remove "+VecObj.CartList.elementAt(index).getName()+" from the cart.");
			comboBox_1.remove(index);
			VecObj.CartList.remove(index);
			dataCart=new String[VecObj.CartList.size()][4];
			for(int i=0; i<VecObj.CartList.size(); i++)
			{
				dataCart[i][0]=VecObj.CartList.elementAt(i).getName();
				dataCart[i][1]=""+VecObj.CartList.elementAt(i).getPrice();
				dataCart[i][2]=VecObj.CartList.elementAt(i).getSize();
				dataCart[i][3]=""+VecObj.CartList.elementAt(i).getBought_quantity();
			}
			table1=new JTable(dataCart, columnsNames1);
			table1.setEnabled(false);
			table1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			table1.setFillsViewportHeight(true);
			table1.setShowGrid(true);
			
			
			
			contentPane.add(table1);
			table1.setRowSelectionAllowed(true);
			table1.setSurrendersFocusOnKeystroke(false);
			table1.setFont(new Font("Tahoma", Font.PLAIN, 17));
			
			table1.setBounds(2, 26, 450, 400);
			table1.setRowHeight(20);
				scrollPane1 = new JScrollPane(table1);
				scrollPane1.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				
				scrollPane1.setBounds(98, 74, 695, 257);
				getContentPane().add(scrollPane1);
				scrollPane1.setVisible(true);
				table1.setVisible(true);
		}
		else if(E.getSource()==btnNewButton_6)
		{
			lblNewLabel_6.setText("Available stock: "+VecObj.CartList.elementAt(comboBox_1.getSelectedIndex()).getQuantity());
			lblNewLabel_6.setVisible(true);
			lblNewLabel_5.setVisible(true);
			textField_2.setVisible(true);
			textField_2.setText(""+VecObj.CartList.elementAt(comboBox_1.getSelectedIndex()).getBought_quantity());
			textField_2.setEnabled(true);
			btnNewButton_7.setVisible(true);
			
			for(int i=0; i<VecObj.CartList.size(); i++)
			{
				dataCart[i][0]=VecObj.CartList.elementAt(i).getName();
				dataCart[i][1]=""+VecObj.CartList.elementAt(i).getPrice();
				dataCart[i][2]=VecObj.CartList.elementAt(i).getSize();
				dataCart[i][3]=""+VecObj.CartList.elementAt(i).getBought_quantity();
			}
			table1=new JTable(dataCart, columnsNames1);
			table1.setEnabled(false);
			table1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			table1.setFillsViewportHeight(true);
			table1.setShowGrid(true);
			
			
			
			contentPane.add(table1);
			table1.setRowSelectionAllowed(true);
			table1.setSurrendersFocusOnKeystroke(false);
			table1.setFont(new Font("Tahoma", Font.PLAIN, 17));
			
			table1.setBounds(2, 26, 450, 400);
			table1.setRowHeight(20);
				scrollPane1 = new JScrollPane(table1);
				scrollPane1.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				
				scrollPane1.setBounds(98, 74, 695, 257);
				getContentPane().add(scrollPane1);
				scrollPane1.setVisible(true);
				
			
		}
		else if(E.getSource()==btnNewButton_7)
		{
			try
			{
				int x=Integer.parseInt(textField_2.getText());
				if(x<=0)
					JOptionPane.showMessageDialog(null, "Please enter a digit number quantity that is bigger than zero");
				else if(x>VecObj.CartList.elementAt(comboBox_1.getSelectedIndex()).getQuantity())
				{
					JOptionPane.showMessageDialog(null, "OOps! we dont't have enough quantity, Please re enter a quantity that is less than or equal "+VecObj.CartList.elementAt(comboBox_1.getSelectedIndex()).getQuantity());
				}
				else
				{
					VecObj.CartList.elementAt(comboBox_1.getSelectedIndex()).setBought_quantity(x);
					JOptionPane.showMessageDialog(null, "You have sucessfully changed the product quantity in your cart.");
					lblNewLabel_6.setVisible(false);
					lblNewLabel_5.setVisible(false);
					textField_2.setVisible(false);
					btnNewButton_7.setVisible(false);
					for(int i=0; i<VecObj.CartList.size(); i++)
					{
						dataCart[i][0]=VecObj.CartList.elementAt(i).getName();
						dataCart[i][1]=""+VecObj.CartList.elementAt(i).getPrice();
						dataCart[i][2]=VecObj.CartList.elementAt(i).getSize();
						dataCart[i][3]=""+VecObj.CartList.elementAt(i).getBought_quantity();
					}
					table1=new JTable(dataCart, columnsNames1);
					table1.setEnabled(false);
					table1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					table1.setFillsViewportHeight(true);
					table1.setShowGrid(true);
					
					
					
					contentPane.add(table1);
					table1.setRowSelectionAllowed(true);
					table1.setSurrendersFocusOnKeystroke(false);
					table1.setFont(new Font("Tahoma", Font.PLAIN, 17));
					
					table1.setBounds(2, 26, 450, 400);
					table1.setRowHeight(20);
						scrollPane1 = new JScrollPane(table1);
						scrollPane1.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
						
						scrollPane1.setBounds(98, 74, 695, 257);
						getContentPane().add(scrollPane1);
						scrollPane1.setVisible(true);
						table1.setVisible(true);
				}
			}

				catch(InputMismatchException e)
				{
					JOptionPane.showMessageDialog(null, "Please enter a digit number quantity that is bigger than zero and without decimals");
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Please enter a digit number quantity that is bigger than zero and without decimals");
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
			
		}
		else if(E.getSource()==btnNewButton_3)
		{
			int answer = JOptionPane.showConfirmDialog(null, 
					"Are you sure you want to logout?", "Double check", 
			        JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.NO_OPTION) {
				
			} else if(answer == JOptionPane.YES_OPTION) {
				LoginPage f=new LoginPage();
				f.setVisible(true);
				dispose();
			}
		}
		else if(E.getSource()==btnNewButton_8)
		{
			String str="";
			double totalPrice=0;
			PrintWriter Bill = null;
			try {
				Bill=new PrintWriter("Bill");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			for (int i=0; i<VecObj.CartList.size(); i++)
			{
				str+=VecObj.CartList.elementAt(i).getName()+" "+VecObj.CartList.elementAt(i).getSize()+" "+VecObj.CartList.elementAt(i).getBought_quantity()+" "+VecObj.CartList.elementAt(i).getPrice()+"\n";
			}
			for (int i=0; i<VecObj.CartList.size(); i++)
			{
				totalPrice+=VecObj.CartList.elementAt(i).getBought_quantity()*VecObj.CartList.elementAt(i).getPrice();
			}
			str+="Total Price: "+totalPrice+"\n";
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
			Date date = new Date(System.currentTimeMillis());
			str+=formatter.format(date)+"\n";
			str+=n+p;
			str+="\nThank you for choosing our KU gifts store shop";
			Bill.print(str);
			Bill.close();
			JOptionPane.showMessageDialog(null, str);
			
			try {
				file_in=new Scanner(new FileReader("Products Data"));
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String toPrint="";
			while(file_in.hasNext())
			{
				String n=file_in.next();
				Double p=file_in.nextDouble();
				int q=file_in.nextInt();
				String s=file_in.next();
				boolean assump=true;
				for(int i=0; i<VecObj.CartList.size(); i++)
				{
					if(n.equals(VecObj.CartList.elementAt(i).getName()) && s.equals(VecObj.CartList.elementAt(i).getSize()))
					{
						q=q-VecObj.CartList.elementAt(i).getBought_quantity();
						toPrint+= n+ " "+p +" "+q+" "+s+"\n";
						assump=false;
					}
					
						
				}
				if(assump)
				toPrint+= n+ " "+p +" "+q+" "+s+"\n";
				
				
						
			}			file_in.close();
			try {
							fout=new PrintWriter("Products Data");
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						fout.print(toPrint);
						Print(toPrint);							
						fout.close();
						Read(fout);
						
					try
					{
						fqout=new PrintWriter(new FileOutputStream(new File("bought q"),true));
					}
					
					catch(FileNotFoundException e)
					{
						JOptionPane.showMessageDialog(null, e.toString());
					}
					for(int i=0; i<VecObj.CartList.size(); i++)
					{
						String n=VecObj.CartList.elementAt(i).getName();
						String s=VecObj.CartList.elementAt(i).getSize();
						int TB=VecObj.CartList.elementAt(i).getBought_quantity();
						String t=n+" "+s+" "+TB+"\n";
						fqout.print(t);
					}
					fqout.close();
					VecObj.CartList.clear();
					
		}
		
		
	}
	
	
	
	public CustomerFrame() 
	{
		Read(fout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table=new JTable(data, columnsNames);
		table.setEnabled(false);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setFillsViewportHeight(true);
		table.setShowGrid(true);
		
		
		contentPane.add(table);
		table.setRowSelectionAllowed(true);
		table.setSurrendersFocusOnKeystroke(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		table.setBounds(2, 26, 450, 400);
		table.setRowHeight(20);
		
			scrollPane = new JScrollPane(table);
			scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			
			scrollPane.setBounds(98, 74, 695, 257);
			getContentPane().add(scrollPane);
			
			
			
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(10, 10, 294, 38);
			contentPane.add(lblNewLabel_1);
			
			btnNewButton = new JButton("Add to cart");
			btnNewButton.setEnabled(false);
			btnNewButton.setBounds(521, 488, 170, 38);
			contentPane.add(btnNewButton);
			btnNewButton.addActionListener(this);
			
			lblNewLabel_2 = new JLabel("Enter the quantity:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_2.setBounds(134, 479, 170, 48);
			contentPane.add(lblNewLabel_2);
			
			textField = new JTextField();
			textField.setEnabled(false);
			textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField.setBounds(314, 487, 170, 38);
			contentPane.add(textField);
			textField.setColumns(10);
			
			btnNewButton_1 = new JButton("Go to cart");
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
			btnNewButton_1.setBounds(760, 521, 121, 48);
			contentPane.add(btnNewButton_1);
			btnNewButton_1.addActionListener(this);
			
			btnNewButton_2 = new JButton("Back");
			btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
			btnNewButton_2.setBounds(10, 521, 93, 45);
			contentPane.add(btnNewButton_2);
			btnNewButton_2.setVisible(false);
			btnNewButton_2.addActionListener(this);
			
			btnNewButton_3 = new JButton("Log out");
			btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
			btnNewButton_3.setBounds(773, 12, 98, 38);
			contentPane.add(btnNewButton_3);
			btnNewButton_3.addActionListener(this);
			
			lblNewLabel_3 = new JLabel("Please select the item you want to add to cart:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_3.setBounds(10, 376, 364, 48);
			contentPane.add(lblNewLabel_3);
			
			comboBox = new JComboBox(VecObj.ProductsList);
			comboBox.setBounds(384, 345, 170, 116);
			contentPane.add(comboBox);
			comboBox.addActionListener(this);
			
			lblNewLabel = new JLabel("Search item:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(235, 40, 121, 24);
			contentPane.add(lblNewLabel);
			
			textField_1 = new JTextField();
			textField_1.setBounds(368, 40, 152, 24);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			btnNewButton_4 = new JButton("Search");
			btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
			btnNewButton_4.setBounds(556, 40, 111, 24);
			contentPane.add(btnNewButton_4);
			
			lblNewLabel_4 = new JLabel("Please select the item you want edit it's quantity or\r\n remove from cart:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_4.setBounds(10, 328, 526, 38);
			contentPane.add(lblNewLabel_4);
			btnNewButton_4.addActionListener(this);
			lblNewLabel_4.setVisible(false);
			
			comboBox_1 = new JComboBox(VecObj.CartList);
			comboBox_1.setBounds(546, 345, 152, 116);
			contentPane.add(comboBox_1);
			comboBox_1.setVisible(false);
			comboBox_1.addActionListener(this);
			
			btnNewButton_5 = new JButton("Remove item");
			btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnNewButton_5.setBounds(0, 356, 137, 31);
			contentPane.add(btnNewButton_5);
			btnNewButton_5.addActionListener(this);
			btnNewButton_5.setVisible(false);
			
			btnNewButton_6 = new JButton("Edit quantity");
			btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNewButton_6.setBounds(172, 355, 137, 35);
			contentPane.add(btnNewButton_6);
			btnNewButton_6.setVisible(false);
			btnNewButton_6.addActionListener(this);
			
			lblNewLabel_5 = new JLabel("Enter new quantity:");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_5.setBounds(10, 417, 181, 38);
			contentPane.add(lblNewLabel_5);
			lblNewLabel_5.setVisible(false);
			
			textField_2 = new JTextField();
			textField_2.setVisible(false);
			textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField_2.setEnabled(false);
			textField_2.setColumns(10);
			textField_2.setBounds(189, 421, 104, 38);
			contentPane.add(textField_2);
			
			btnNewButton_7 = new JButton("Submit Changes");
			btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNewButton_7.setBounds(10, 453, 152, 38);
			contentPane.add(btnNewButton_7);
			btnNewButton_7.setVisible(false);
			btnNewButton_7.addActionListener(this);
			
			btnNewButton_8 = new JButton("Place order");
			btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton_8.setBounds(394, 479, 160, 47);
			contentPane.add(btnNewButton_8);
			btnNewButton_8.setVisible(false);
			btnNewButton_8.addActionListener(this);
			
			lblNewLabel_6 = new JLabel("Available stock:");
			lblNewLabel_6.setVisible(false);
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_6.setBounds(10, 386, 181, 38);
			contentPane.add(lblNewLabel_6);
			
			
	}
	public CustomerFrame(String name, int phone, String user_id)
	{
		n=name;
		p=phone;
		Read(fout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table=new JTable(data, columnsNames);
		table.setEnabled(false);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setFillsViewportHeight(true);
		table.setShowGrid(true);
		
		
		contentPane.add(table);
		table.setRowSelectionAllowed(true);
		table.setSurrendersFocusOnKeystroke(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		table.setBounds(2, 26, 450, 400);
		table.setRowHeight(20);
		
			scrollPane = new JScrollPane(table);
			scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			
			scrollPane.setBounds(98, 74, 695, 257);
			getContentPane().add(scrollPane);
			
			
			
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(10, 10, 294, 38);
			contentPane.add(lblNewLabel_1);
			
			btnNewButton = new JButton("Add to cart");
			btnNewButton.setEnabled(false);
			btnNewButton.setBounds(521, 488, 170, 38);
			contentPane.add(btnNewButton);
			btnNewButton.addActionListener(this);
			
			lblNewLabel_2 = new JLabel("Enter the quantity:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_2.setBounds(134, 479, 170, 48);
			contentPane.add(lblNewLabel_2);
			
			textField = new JTextField();
			textField.setEnabled(false);
			textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField.setBounds(314, 487, 170, 38);
			contentPane.add(textField);
			textField.setColumns(10);
			
			btnNewButton_1 = new JButton("Go to cart");
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
			btnNewButton_1.setBounds(760, 521, 121, 48);
			contentPane.add(btnNewButton_1);
			btnNewButton_1.addActionListener(this);
			
			btnNewButton_2 = new JButton("Back");
			btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
			btnNewButton_2.setBounds(10, 521, 93, 45);
			contentPane.add(btnNewButton_2);
			btnNewButton_2.setVisible(false);
			btnNewButton_2.addActionListener(this);
			
			btnNewButton_3 = new JButton("Log out");
			btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
			btnNewButton_3.setBounds(773, 12, 98, 38);
			contentPane.add(btnNewButton_3);
			btnNewButton_3.addActionListener(this);
			btnNewButton_3.setVisible(true);
			
			lblNewLabel_3 = new JLabel("Please select the item you want to add to cart:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_3.setBounds(10, 376, 364, 48);
			contentPane.add(lblNewLabel_3);
			
			comboBox = new JComboBox(VecObj.ProductsList);
			comboBox.setBounds(384, 345, 170, 116);
			contentPane.add(comboBox);
			comboBox.addActionListener(this);
			
			lblNewLabel = new JLabel("Search item:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(235, 40, 121, 24);
			contentPane.add(lblNewLabel);
			
			textField_1 = new JTextField();
			textField_1.setBounds(368, 40, 152, 24);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			btnNewButton_4 = new JButton("Search");
			btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
			btnNewButton_4.setBounds(556, 40, 111, 24);
			contentPane.add(btnNewButton_4);
			
			lblNewLabel_4 = new JLabel("Please select the item you want edit it's quantity or\r\n remove from cart:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_4.setBounds(10, 328, 526, 38);
			contentPane.add(lblNewLabel_4);
			btnNewButton_4.addActionListener(this);
			lblNewLabel_4.setVisible(false);
			
			comboBox_1 = new JComboBox(VecObj.CartList);
			comboBox_1.setBounds(546, 345, 152, 116);
			contentPane.add(comboBox_1);
			comboBox_1.setVisible(false);
			comboBox_1.addActionListener(this);
			
			btnNewButton_5 = new JButton("Remove item");
			btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnNewButton_5.setBounds(0, 356, 137, 31);
			contentPane.add(btnNewButton_5);
			btnNewButton_5.addActionListener(this);
			btnNewButton_5.setVisible(false);
			
			btnNewButton_6 = new JButton("Edit quantity");
			btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNewButton_6.setBounds(172, 355, 137, 35);
			contentPane.add(btnNewButton_6);
			btnNewButton_6.setVisible(false);
			btnNewButton_6.addActionListener(this);
			
			lblNewLabel_5 = new JLabel("Enter new quantity:");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_5.setBounds(10, 417, 181, 38);
			contentPane.add(lblNewLabel_5);
			lblNewLabel_5.setVisible(false);
			
			textField_2 = new JTextField();
			textField_2.setVisible(false);
			textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField_2.setEnabled(false);
			textField_2.setColumns(10);
			textField_2.setBounds(189, 421, 104, 38);
			contentPane.add(textField_2);
			
			btnNewButton_7 = new JButton("Submit Changes");
			btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNewButton_7.setBounds(10, 453, 152, 38);
			contentPane.add(btnNewButton_7);
			btnNewButton_7.setVisible(false);
			btnNewButton_7.addActionListener(this);
			
			btnNewButton_8 = new JButton("Place order");
			btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton_8.setBounds(394, 479, 160, 47);
			contentPane.add(btnNewButton_8);
			btnNewButton_8.setVisible(false);
			btnNewButton_8.addActionListener(this);
			
			lblNewLabel_6 = new JLabel("Available stock:");
			lblNewLabel_6.setVisible(false);
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_6.setBounds(10, 386, 181, 38);
			contentPane.add(lblNewLabel_6);
			
			lblNewLabel_7 = new JLabel(name+"---"+user_id);
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_7.setBounds(10, 10, 127, 24);
			contentPane.add(lblNewLabel_7);
			
			
	}
	
	
	public void Print(String str)
	{
		PrintWriter fout;
		
		try
		{
			fout=new PrintWriter(new FileOutputStream(new File("Products Data"),true));
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
		
		VecObj.ProductsList.clear();
		String n, s;
		double p;
		int q;
		try {
			file_in=new Scanner(new FileReader("Products Data"));
			while(file_in.hasNext())
			{
				try
				{
					n=file_in.next();
				p=file_in.nextDouble();
				q=file_in.nextInt();
				s=file_in.next();
				VecObj.ProductsList.add(new Products(n,p,q, s));
				}
				catch (InputMismatchException e)
				{
					JOptionPane.showMessageDialog(null, "Please use text for name, number for price, and number without decimals for quantity");
				}
				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Please use text for name, number for price, and number without decimals for quantity");
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "Exception!");
				}
				
			}
			data=new String[VecObj.ProductsList.size()][4];
			for (int i=0; i<VecObj.ProductsList.size(); i++)
			{
				data[i][0]=VecObj.ProductsList.elementAt(i).getName();
				data[i][1]=""+VecObj.ProductsList.elementAt(i).getPrice();
				data[i][2]=""+VecObj.ProductsList.elementAt(i).getQuantity();
				data[i][3]=VecObj.ProductsList.elementAt(i).getSize();
			}
			
			}
		
		catch(FileNotFoundException error)
		{
			JOptionPane.showMessageDialog(null, "file not found");
		}

	}
}
