import java.awt.BorderLayout;
import java.util.*;
import java.util.stream.Collectors;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;



public class AdminFrame extends JFrame implements ActionListener {

	private static JPanel contentPane;
	static String[][] AdminsData=new String[][]{{"Ahmed Sajwani", "ku1","2021"},
			{"Mohamed Al Ali","ku2","2021"},
			{"Sultan Alsaedi", "ku3", "2021"},
			{"Eissa","ku4","2021"},
			{"Ahmed","Ahmed","2021"}};
	static String data[][];		
	static String columnsNames[]= {"Product Name", "Product Price", "Available Quantity", "Product Size", "Bought quantity"};
			static Products VecObj=new Products();
			static PrintWriter fout;
			static Scanner file_in, fb;
			String new_size;
			
			
			
	private final JLabel lblKuGiftsStore;
	private static JButton btnNewButton_3, btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_5, btnNewButton_4, btnNewButton_6, btnNewButton_8, btnNewButton_9, btnNewButton_11, btnNewButton_12;
	private JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5;
	private JLabel lblNewLabel_1, lblNewLabel_2, lblNewLabel_1_1, lblNewLabel, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6, lblNewLabel_7, lblNewLabel_7_1, lblNewLabel_7_2, lblNewLabel_8, lblNewLabel_9, lblNewLabel_10;
	JComboBox comboBox,comboBox_1;
	private JButton btnNewButton_7;
	private JToggleButton tglbtnNewToggleButton, tglbtnEditPrice, tglbtnEditQuantity, tglbtnNewToggleButton_1, tglbtnNewToggleButton_1_1, tglbtnNewToggleButton_1_2, tglbtnNewToggleButton_2, tglbtnNewToggleButton_3, tglbtnNewToggleButton_4, tglbtnNewToggleButton_5;
	private JButton btnNewButton_10;
	private JTable table=new JTable(data, columnsNames);;
	JScrollPane scrollPane=new JScrollPane(table);;
	private JLabel lblNewLabel_11;
	private JTextField textField_6;
	
	
		
			public void actionPerformed(ActionEvent E)
			{
				if(E.getSource()==btnNewButton_2)
				{
					lblKuGiftsStore.setVisible(true);
					btnNewButton.setVisible(true);
					btnNewButton_1.setVisible(false);
					btnNewButton_3.setVisible(false);
					btnNewButton_2.setVisible(false);
					lblNewLabel.setVisible(true);
					lblNewLabel_1.setVisible(true);
					lblNewLabel_1_1.setVisible(true);
					textField.setVisible(true);
					textField.setText("");
					textField_1.setVisible(true);
					textField_1.setText("");
					textField_2.setVisible(true);
					textField_2.setText("");
					btnNewButton_4.setVisible(true);
					btnNewButton_5.setVisible(true);
					lblNewLabel_4.setVisible(false);
					lblNewLabel_5.setVisible(false);
					lblNewLabel_6.setVisible(false);
					tglbtnNewToggleButton.setVisible(false);
					tglbtnEditQuantity.setVisible(false);
					tglbtnEditPrice.setVisible(false);
					lblNewLabel_7.setVisible(false);
					lblNewLabel_7_1.setVisible(false);
					lblNewLabel_7_2.setVisible(false);
					textField_3.setVisible(false);
					textField_4.setVisible(false);
					textField_5.setVisible(false);
					lblNewLabel_8.setVisible(true);
					tglbtnNewToggleButton_1.setVisible(true);
					tglbtnNewToggleButton_1_1.setVisible(true);
					tglbtnNewToggleButton_1_2.setVisible(true);
				}
				else if(E.getSource()==btnNewButton_4)
				{
					
					String s="";
					if (tglbtnNewToggleButton_1.isSelected())
					{
						s="small";
					}
					else if (tglbtnNewToggleButton_1_1.isSelected())
					{
						s="medium";
					}
					else if (tglbtnNewToggleButton_1_2.isSelected())
					{
						s="large";
					}
					boolean assum=true;
					for(int i=0; i<VecObj.ProductsList.size(); i++)
					{
						if(textField.getText().equals(VecObj.ProductsList.elementAt(i).getName().toLowerCase()) && s.equals(VecObj.ProductsList.elementAt(i).getSize()) && !s.equals(""))
						{
							JOptionPane.showMessageDialog(null, "There is already a product with this name and size, please use a new name or change the size");
							assum=false;
						}
					}
					if((textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("")) || (tglbtnNewToggleButton_1.isSelected()==false && tglbtnNewToggleButton_1_1.isSelected()==false && tglbtnNewToggleButton_1_2.isSelected()==false))
						JOptionPane.showMessageDialog(null, "You have left one or more empty field, or you didn't choose a size");
					
					
					else if(assum)
					{
						
						
						String n=textField.getText();
						n=n.replaceAll("\\s", "_");
						n=n.toLowerCase();
						double x; int y;
						try
						{
							x =Double.parseDouble(textField_1.getText());
						 y=Integer.parseInt(textField_2.getText());
						 JOptionPane.showMessageDialog(null, "You have successsfully added "+n+" to the store inventory");
							String str=n+" "+x+" "+y+" "+s;
							Print(str);
							Read(fout);
							System.out.println(VecObj.ProductsList.size());
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							comboBox.setSelectedIndex(0);
							comboBox_1.setSelectedIndex(0);
							btnNewButton_9.setVisible(false);
							btnNewButton_10.setVisible(false);
							tglbtnNewToggleButton_1.setSelected(false);
							tglbtnNewToggleButton_1_1.setSelected(false);
							tglbtnNewToggleButton_1_2.setSelected(false);
							
						}
						catch(InputMismatchException e)
						{
							JOptionPane.showMessageDialog(btnNewButton, "Please use text for name, number for price, and number without decimals for quantity");
						}
						catch (NumberFormatException e)
						{
							JOptionPane.showMessageDialog(btnNewButton, "Please use text for name, number for price, and number without decimals for quantity");
						}
						
						
					}
					
				}
				else if(E.getSource()==btnNewButton_5)
				{
					lblNewLabel_11.setVisible(false);
					textField_6.setVisible(false);
					btnNewButton_11.setVisible(false);
					scrollPane.setVisible(false);
					table.setVisible(false);
					lblKuGiftsStore.setVisible(true);
					btnNewButton.setVisible(true);
					btnNewButton_1.setVisible(true);
					btnNewButton_3.setVisible(true);
					btnNewButton_2.setVisible(true);
					lblNewLabel.setVisible(false);
					lblNewLabel_1.setVisible(false);
					lblNewLabel_1_1.setVisible(false);
					textField.setVisible(false);
					textField_1.setVisible(false);
					textField_2.setVisible(false);
					btnNewButton_4.setVisible(false);
					btnNewButton_5.setVisible(false);
					lblNewLabel_2.setVisible(false);
					comboBox.setVisible(false);
					btnNewButton_6.setVisible(false);
					lblNewLabel_4.setVisible(false);
					lblNewLabel_5.setVisible(false);
					lblNewLabel_6.setVisible(false);
					tglbtnNewToggleButton.setVisible(false);
					tglbtnEditQuantity.setVisible(false);
					tglbtnEditPrice.setVisible(false);
					lblNewLabel_7.setVisible(false);
					lblNewLabel_7_1.setVisible(false);
					lblNewLabel_7_2.setVisible(false);
					textField_3.setVisible(false);
					textField_4.setVisible(false);
					textField_5.setVisible(false);
					comboBox_1.setVisible(false);
					btnNewButton_7.setVisible(false);
					btnNewButton_6.setEnabled(false);
					btnNewButton_7.setEnabled(false);
					btnNewButton_8.setVisible(false);
					btnNewButton_9.setVisible(false);
					btnNewButton_10.setVisible(false);
					lblNewLabel_8.setVisible(false);
					tglbtnNewToggleButton_1.setVisible(false);
					tglbtnNewToggleButton_1_1.setVisible(false);
					tglbtnNewToggleButton_1_2.setVisible(false);
					tglbtnNewToggleButton_1.setSelected(false);
					tglbtnNewToggleButton_1_1.setSelected(false);
					tglbtnNewToggleButton_1_2.setSelected(false);
					tglbtnNewToggleButton_2.setVisible(false);
					tglbtnNewToggleButton_3.setVisible(false);
					tglbtnNewToggleButton_4.setVisible(false);
					tglbtnNewToggleButton_5.setVisible(false);
					lblNewLabel_9.setVisible(false);
					lblNewLabel_10.setVisible(false);
				}
				else if(E.getSource()==btnNewButton)
				{
					int answer = JOptionPane.showConfirmDialog(btnNewButton, 
							"Are you sure you want to logout?", "Double check", 
					        JOptionPane.YES_NO_OPTION);

					if (answer == JOptionPane.NO_OPTION) {
						
					} else if(answer == JOptionPane.YES_OPTION) {
						LoginPage f=new LoginPage();
						f.setVisible(true);
						dispose();
					}
				}
				else if(E.getSource()==btnNewButton_1)
				{
					Read(fout);
					if (VecObj.ProductsList.size()>0)
					{
					comboBox_1.setSelectedIndex(0);
					comboBox.setSelectedIndex(0);
					}
					
					lblNewLabel_2.setVisible(true);
					comboBox.setVisible(true);
					btnNewButton_6.setVisible(true);
					btnNewButton_6.setEnabled(false);
					lblKuGiftsStore.setVisible(true);
					btnNewButton.setVisible(true);
					btnNewButton_1.setVisible(false);
					btnNewButton_3.setVisible(false);
					btnNewButton_2.setVisible(false);
					lblNewLabel.setVisible(false);
					lblNewLabel_1.setVisible(false);
					lblNewLabel_1_1.setVisible(false);
					textField.setVisible(false);
					textField_1.setVisible(false);
					textField_2.setVisible(false);
					btnNewButton_4.setVisible(false);
					btnNewButton_5.setVisible(true);
					lblNewLabel_4.setVisible(false);
					lblNewLabel_5.setVisible(false);
					lblNewLabel_6.setVisible(false);
					tglbtnNewToggleButton.setVisible(false);
					tglbtnEditQuantity.setVisible(false);
					tglbtnEditPrice.setVisible(false);
					lblNewLabel_7.setVisible(false);
					lblNewLabel_7_1.setVisible(false);
					lblNewLabel_7_2.setVisible(false);
					textField_3.setVisible(false);
					textField_4.setVisible(false);
					textField_5.setVisible(false);
					comboBox_1.setVisible(true);
					btnNewButton_7.setVisible(true);
					btnNewButton_7.setEnabled(false);
					lblNewLabel_3.setVisible(false);

					btnNewButton_9.setVisible(false);
					btnNewButton_10.setVisible(false);
					
					if (VecObj.ProductsList.size()==0)
					{
						comboBox_1.setEnabled(false);
						comboBox.setEnabled(false);
						JOptionPane.showMessageDialog(btnNewButton, "No Items in the inventory");					
					}
					else
					{
						comboBox.setEnabled(true);
						comboBox_1.setEnabled(true);
					}	
				}
				else if(E.getSource()==comboBox)
				{
					comboBox_1.setEnabled(false);
					btnNewButton_6.setEnabled(true);
					btnNewButton_9.setVisible(true);
					
				}
				else if(E.getSource()==btnNewButton_9)
				{
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					comboBox_1.setEnabled(true);
					comboBox.setEnabled(true);
					btnNewButton_6.setEnabled(false);
					btnNewButton_9.setVisible(false);		
					btnNewButton_10.setVisible(false);
					btnNewButton_7.setEnabled(false);
				}
				else if(E.getSource()==comboBox_1)
				{
					comboBox.setEnabled(false);
					btnNewButton_7.setEnabled(true);
					btnNewButton_10.setVisible(true);					
					tglbtnNewToggleButton.setSelected(false);					
					tglbtnEditQuantity.setSelected(false);
					tglbtnEditPrice.setSelected(false);
				}
				else if(E.getSource()==btnNewButton_6)
				{
					int answer = JOptionPane.showConfirmDialog(btnNewButton, 
							"Are you sure you want to remove "+comboBox.getSelectedItem()+" ?", "Double check", 
					        JOptionPane.YES_NO_OPTION);

					if (answer == JOptionPane.NO_OPTION)
					{
						comboBox_1.setEnabled(true);
						btnNewButton_9.setVisible(false);
						btnNewButton_6.setEnabled(false);
					} 
					else if(answer == JOptionPane.YES_OPTION) {
						
						try
						{	btnNewButton_9.setVisible(false);
							System.out.println(VecObj.ProductsList.get(comboBox.getSelectedIndex()));
							JOptionPane.showMessageDialog(null, "You have successsfully removed "+VecObj.ProductsList.get(comboBox.getSelectedIndex()).getName());
							removeLine(VecObj.ProductsList.get(comboBox.getSelectedIndex()).getName());
							comboBox.removeItem(comboBox.getSelectedIndex());
							Read(fout);
							if(VecObj.ProductsList.size()>0)
							{
								comboBox.setSelectedIndex(0);
								comboBox_1.setSelectedIndex(0);
								comboBox.setEnabled(true);
								comboBox.setSelectedIndex(0);
								btnNewButton_9.setVisible(false);
								comboBox_1.setEnabled(true);
								btnNewButton_6.setEnabled(false);
								btnNewButton_7.setEnabled(false);							
								btnNewButton_10.setVisible(false);
							}
								
							else
							{
								btnNewButton_9.setVisible(false);
								comboBox.removeAllItems();
								comboBox_1.removeAllItems();
								comboBox.setEnabled(false);
								comboBox_1.setEnabled(false);
								btnNewButton_6.setEnabled(false);
								btnNewButton_7.setEnabled(false);
								JOptionPane.showMessageDialog(null,"You have no more items left in the inventory!");
							}
								
							
						}
						catch (IOException e)
						{
							JOptionPane.showMessageDialog(btnNewButton_6, e);
						}
					}
				}
				else if(E.getSource()==btnNewButton_7)
				{
					
					lblNewLabel_4.setVisible(true);
					lblNewLabel_5.setVisible(true);
					lblNewLabel_6.setVisible(true);
					lblNewLabel_9.setVisible(true);
					tglbtnNewToggleButton.setVisible(true);
					tglbtnNewToggleButton_2.setVisible(true);
					tglbtnNewToggleButton_2.setSelected(false);
					tglbtnEditQuantity.setVisible(true);
					tglbtnEditPrice.setVisible(true);
					lblNewLabel_4.setText("Current name: "+VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getName());
					lblNewLabel_5.setText("Current Price: "+VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getPrice()+" AED");
					lblNewLabel_6.setText("Current Quantity: "+VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getQuantity());
					textField_3.setText(VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getName());
					textField_4.setText(""+VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getPrice());
					textField_5.setText(""+VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getQuantity());
					lblNewLabel_9.setText("Current Size: "+VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getSize());
					if(VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getSize().equals("small"))
					{
						tglbtnNewToggleButton_5.setSelected(true);
					}
					if(VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getSize().equals("medium"))
					{
						tglbtnNewToggleButton_3.setSelected(true);
					}
					if(VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getSize().equals("large"))
					{
						tglbtnNewToggleButton_4.setSelected(true);
					}
					
					
				}
				else if(E.getSource()==tglbtnNewToggleButton)
				{
					
					
						if(tglbtnNewToggleButton.isSelected())
						{
							textField_3.setEnabled(true);
							lblNewLabel_7.setVisible(true);
							textField_3.setVisible(true);
							btnNewButton_8.setVisible(true);
							textField_3.setText(VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getName());
						}
						else if(!tglbtnNewToggleButton.isSelected())
						{
							textField_3.setEnabled(false);
							lblNewLabel_7.setVisible(false);
							textField_3.setVisible(false);
							textField_3.setText(VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getName());
						}
						if(!tglbtnNewToggleButton.isSelected() && !tglbtnEditQuantity.isSelected() && !tglbtnEditPrice.isSelected())
						{
							btnNewButton_8.setVisible(false);
						}
				}
				else if(E.getSource()==tglbtnEditPrice)
				{
						if(tglbtnEditPrice.isSelected())
						{
							textField_4.setEnabled(true);
						lblNewLabel_7_1.setVisible(true);
						textField_4.setVisible(true);
						btnNewButton_8.setVisible(true);
						textField_4.setText(""+VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getPrice());
						}
						else if(!tglbtnEditPrice.isSelected())
						{
							textField_4.setEnabled(false);
							lblNewLabel_7_1.setVisible(false);
							textField_4.setVisible(false);
							textField_4.setText(""+VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getPrice());
						}
						if(!tglbtnNewToggleButton.isSelected() && !tglbtnEditQuantity.isSelected() && !tglbtnEditPrice.isSelected())
						{
							btnNewButton_8.setVisible(false);
						}
				}
				else if(E.getSource()==tglbtnEditQuantity)
				{
					if(tglbtnEditQuantity.isSelected())
					{
						textField_5.setEnabled(true);
					lblNewLabel_7_2.setVisible(true);
					textField_5.setVisible(true);
					btnNewButton_8.setVisible(true);
					textField_5.setText(""+VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getQuantity());
					}
					else if(!tglbtnEditQuantity.isSelected())
					{
						textField_5.setEnabled(false);
						lblNewLabel_7_2.setVisible(false);
						textField_5.setVisible(false);
						textField_5.setText(""+VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getQuantity());
					}
					if(!tglbtnNewToggleButton.isSelected() && !tglbtnEditQuantity.isSelected() && !tglbtnEditPrice.isSelected())
					{
						btnNewButton_8.setVisible(false);
					}
				}
				else if(E.getSource()==tglbtnNewToggleButton_2)
				{
					if(tglbtnNewToggleButton_2.isSelected())
					{
						lblNewLabel_10.setVisible(true);
						tglbtnNewToggleButton_3.setVisible(true);
						tglbtnNewToggleButton_4.setVisible(true);
						tglbtnNewToggleButton_5.setVisible(true);
						btnNewButton_8.setVisible(true);
						if(VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getSize().equals("small"))
						{
							tglbtnNewToggleButton_5.setSelected(true);
						}
						else if(VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getSize().equals("medium"))
						{
							tglbtnNewToggleButton_3.setSelected(true);
						}
						else if(VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getSize().equals("large"))
						{
							tglbtnNewToggleButton_4.setSelected(true);
						}
					
					}
					else if(!tglbtnNewToggleButton_2.isSelected())
					{
						lblNewLabel_10.setVisible(false);
						tglbtnNewToggleButton_3.setVisible(false);
						tglbtnNewToggleButton_4.setVisible(false);
						tglbtnNewToggleButton_5.setVisible(false);
						if(VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getSize().equals("small"))
						{
							tglbtnNewToggleButton_5.setSelected(true);
						}
						else if(VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getSize().equals("medium"))
						{
							tglbtnNewToggleButton_3.setSelected(true);
						}
						else if(VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getSize().equals("large"))
						{
							tglbtnNewToggleButton_4.setSelected(true);
						}
					}
					if(!tglbtnNewToggleButton.isSelected() && !tglbtnEditQuantity.isSelected() && !tglbtnEditPrice.isSelected() &&!tglbtnNewToggleButton_2.isSelected())
					{
						btnNewButton_8.setVisible(false);
					}
				}
				else if(E.getSource()==btnNewButton_8)
				{
					String current_name=VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getName();
					double current_price=VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getPrice();
					int current_quantity=VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getQuantity();
					String current_size=VecObj.ProductsList.get(comboBox_1.getSelectedIndex()).getSize();
					try
					{
						if(current_name.equals(textField_3.getText().toLowerCase()) && current_price==Double.parseDouble(textField_4.getText()) && current_quantity==Integer.parseInt(textField_5.getText()) &&current_size.equals(new_size))
						{
							JOptionPane.showMessageDialog(btnNewButton, "You haven't made any changes!!");
						}
						else
					{
						boolean assum=true;
						for(int i=0; i<VecObj.ProductsList.size(); i++)
						{
							if(textField_3.getText().equals(VecObj.ProductsList.elementAt(i).getName()) && tglbtnNewToggleButton_2.isSelected() && new_size.equals(VecObj.ProductsList.elementAt(i).getSize()))
							{
								JOptionPane.showMessageDialog(null, "There is already a product with this name and size, please use a new name or change the size or unselect the edit buttons of edit size and name");
								assum=false;
							}
						}
						if(assum)
						{
							
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
								if(n.equals(current_name))
									{
									
									
										n=textField_3.getText().toLowerCase();
										n=n.replaceAll("\\s", "_");
										p=Double.parseDouble(textField_4.getText());
										q=Integer.parseInt(textField_5.getText());
										s=new_size;
										JOptionPane.showMessageDialog(btnNewButton, "You have edited "+current_name+" information");
										
									}
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
										lblNewLabel_4.setVisible(false);
										lblNewLabel_5.setVisible(false);
										lblNewLabel_6.setVisible(false);
										tglbtnNewToggleButton.setVisible(false);
										tglbtnNewToggleButton.setSelected(false);
										tglbtnEditQuantity.setVisible(false);
										tglbtnEditQuantity.setSelected(false);
										tglbtnEditPrice.setVisible(false);
										tglbtnEditPrice.setSelected(false);
										textField_3.setVisible(false);
										textField_4.setVisible(false);
										textField_5.setVisible(false);
										btnNewButton_8.setVisible(false);
										lblNewLabel_7.setVisible(false);
										lblNewLabel_7_1.setVisible(false);
										lblNewLabel_7_2.setVisible(false);
										comboBox_1.setSelectedIndex(0);
										comboBox.setEnabled(true);
										btnNewButton_7.setEnabled(false);
										btnNewButton_10.setVisible(false);
										tglbtnNewToggleButton_2.setVisible(false);
										tglbtnNewToggleButton_3.setVisible(false);
										tglbtnNewToggleButton_4.setVisible(false);
										tglbtnNewToggleButton_5.setVisible(false);
										lblNewLabel_9.setVisible(false);
										lblNewLabel_10.setVisible(false);
										
										
							}
								
							
						}
							
							lblNewLabel_4.setVisible(false);
							lblNewLabel_5.setVisible(false);
							lblNewLabel_6.setVisible(false);
							tglbtnNewToggleButton.setVisible(false);
							tglbtnNewToggleButton.setSelected(false);
							tglbtnEditQuantity.setVisible(false);
							tglbtnEditQuantity.setSelected(false);
							tglbtnEditPrice.setVisible(false);
							tglbtnEditPrice.setSelected(false);
							textField_3.setVisible(false);
							textField_4.setVisible(false);
							textField_5.setVisible(false);
							btnNewButton_8.setVisible(false);
							lblNewLabel_7.setVisible(false);
							lblNewLabel_7_1.setVisible(false);
							lblNewLabel_7_2.setVisible(false);
							comboBox_1.setSelectedIndex(0);
							comboBox.setEnabled(true);
							btnNewButton_7.setEnabled(false);
							btnNewButton_10.setVisible(false);
							tglbtnNewToggleButton_2.setVisible(false);
							tglbtnNewToggleButton_3.setVisible(false);
							tglbtnNewToggleButton_4.setVisible(false);
							tglbtnNewToggleButton_5.setVisible(false);
							lblNewLabel_9.setVisible(false);
							lblNewLabel_10.setVisible(false);
						
					}
					catch (InputMismatchException e)
					{
						JOptionPane.showMessageDialog(btnNewButton, "Please use text for name, number for price, and number without decimals for quantity");
					}
					catch (NumberFormatException e)
					{
						JOptionPane.showMessageDialog(btnNewButton, "Please use text for name, number for price, and number without decimals for quantity");
					}
					
					
						
					
					
				}
				else if(E.getSource()==btnNewButton_10)
				{
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					comboBox_1.setEnabled(true);
					btnNewButton_6.setEnabled(false);
					btnNewButton_9.setVisible(false);
					comboBox_1.setEnabled(true);
					btnNewButton_6.setEnabled(false);
					btnNewButton_9.setVisible(false);
					btnNewButton_10.setVisible(false);
					lblNewLabel_4.setVisible(false);
					lblNewLabel_5.setVisible(false);
					lblNewLabel_6.setVisible(false);
					tglbtnNewToggleButton.setVisible(false);
					tglbtnNewToggleButton.setSelected(false);
					tglbtnEditQuantity.setVisible(false);
					tglbtnEditQuantity.setSelected(false);
					tglbtnEditPrice.setVisible(false);
					tglbtnEditPrice.setSelected(false);
					textField_3.setVisible(false);
					textField_4.setVisible(false);
					textField_5.setVisible(false);
					btnNewButton_8.setVisible(false);
					lblNewLabel_7.setVisible(false);
					lblNewLabel_7_1.setVisible(false);
					lblNewLabel_7_2.setVisible(false);
					comboBox.setEnabled(true);
					btnNewButton_7.setEnabled(false);
					tglbtnNewToggleButton_2.setVisible(false);
					tglbtnNewToggleButton_3.setVisible(false);
					tglbtnNewToggleButton_4.setVisible(false);
					tglbtnNewToggleButton_5.setVisible(false);
					lblNewLabel_9.setVisible(false);
					lblNewLabel_10.setVisible(false);
				}
				else if(E.getSource()==btnNewButton_3)
				{
					Read(fout);
					try {
						fb=new Scanner(new FileReader("bought q"));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					while(fb.hasNext())
					{
						
						String n=fb.next();
						String s=fb.next();
						int qb=fb.nextInt();
						for(int i=0; i<VecObj.ProductsList.size(); i++)
						{
							
							if(n.equals(VecObj.ProductsList.elementAt(i).getName()) && s.equals(VecObj.ProductsList.elementAt(i).getSize()))
							{
								int BQ=VecObj.ProductsList.elementAt(i).getBought_quantity()+qb;
								VecObj.ProductsList.elementAt(i).setBought_quantity(BQ);
								data[i][4]=""+VecObj.ProductsList.elementAt(i).getBought_quantity();
							}
						}
					}
					lblNewLabel_11.setVisible(true);
					textField_6.setVisible(true);
					btnNewButton_11.setVisible(true);
					
					table=new JTable(data, columnsNames);
					table.setEnabled(false);
					table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					table.setFillsViewportHeight(true);
					table.setShowGrid(true);
					
					contentPane.add(table);
					table.setRowSelectionAllowed(true);
					table.setSurrendersFocusOnKeystroke(false);
					table.setFont(new Font("Tahoma", Font.PLAIN, 17));
					
					table.setBounds(20, 56, 859, 300);
					table.setRowHeight(20);
						scrollPane = new JScrollPane(table);
						
						scrollPane.setBounds(62, 57, 735, 300);
						getContentPane().add(scrollPane);
					
					scrollPane.setVisible(false);
					table.setVisible(true);
					
					
						
					
					btnNewButton_1.setVisible(false);
					btnNewButton_2.setVisible(false);
					btnNewButton_3.setVisible(false);
					btnNewButton.setVisible(false);
					btnNewButton_5.setVisible(true);
					scrollPane.setVisible(true);
					
					
				}
				
				
				else if(E.getSource()==tglbtnNewToggleButton_1)
				{
					tglbtnNewToggleButton_1_1.setSelected(false);
					tglbtnNewToggleButton_1_2.setSelected(false);
				}
				else if(E.getSource()==tglbtnNewToggleButton_1_1)
				{
					tglbtnNewToggleButton_1.setSelected(false);
					tglbtnNewToggleButton_1_2.setSelected(false);
				}
				else if(E.getSource()==tglbtnNewToggleButton_1_2)
				{
					tglbtnNewToggleButton_1_1.setSelected(false);
					tglbtnNewToggleButton_1.setSelected(false);
				}
				else if(E.getSource()==tglbtnNewToggleButton_3)
				{
					tglbtnNewToggleButton_4.setSelected(false);
					tglbtnNewToggleButton_5.setSelected(false);
					new_size="medium";
				}
				else if(E.getSource()==tglbtnNewToggleButton_4)
				{
					tglbtnNewToggleButton_3.setSelected(false);
					tglbtnNewToggleButton_5.setSelected(false);
					new_size="large";
				}
				else if(E.getSource()==tglbtnNewToggleButton_5)
				{
					tglbtnNewToggleButton_4.setSelected(false);
					tglbtnNewToggleButton_3.setSelected(false);
					new_size="small";
				}
				else if(E.getSource()==btnNewButton_11)
				{
					if(!textField_6.getText().equals(""))
					{
						boolean assump=false;
						for (int i=0; i<VecObj.ProductsList.size(); i++)
						{
							if(data[i][0].equals(textField_6.getText()))
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
					
				

					
				}
			
				

	
	public AdminFrame() {
		Read(fout);
	
		setTitle("KU Gfits Store Admin Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Enter the product name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(26, 119, 250, 61);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		
		lblNewLabel_1 = new JLabel("Enter the product price:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(26, 229, 250, 61);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		lblNewLabel_1_1 = new JLabel("Enter the product quantity:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1_1.setBounds(26, 324, 277, 61);
		contentPane.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setVisible(false);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(323, 132, 144, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		textField.addActionListener(this);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(323, 242, 144, 45);
		contentPane.add(textField_1);
		textField_1.setVisible(false);
		textField_1.addActionListener(this);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(323, 340, 144, 45);
		contentPane.add(textField_2);
		textField_2.setVisible(false);
		textField_2.addActionListener(this);
		
		lblKuGiftsStore=new JLabel("");
		lblKuGiftsStore.setBackground(new Color(224, 255, 255));
		lblKuGiftsStore.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblKuGiftsStore.setBounds(10, 10, 631, 36);
		contentPane.add(lblKuGiftsStore);
		
		btnNewButton = new JButton("Logout");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(747, 10, 110, 36);
		contentPane.add(btnNewButton);
		
		lblNewLabel_8 = new JLabel("Choose the product size:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_8.setBounds(26, 419, 277, 36);
		contentPane.add(lblNewLabel_8);
		btnNewButton.addActionListener(this);
		lblNewLabel_8.setVisible(false);
		
		btnNewButton_4 = new JButton("Add product");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_4.setBounds(359, 498, 159, 61);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.setVisible(false);
		btnNewButton_4.addActionListener(this);
		
		tglbtnNewToggleButton_1 = new JToggleButton("Small");
		tglbtnNewToggleButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tglbtnNewToggleButton_1.setBounds(323, 419, 144, 36);
		contentPane.add(tglbtnNewToggleButton_1);
		tglbtnNewToggleButton_1.setVisible(false);
		tglbtnNewToggleButton_1.addActionListener(this);
		
		tglbtnNewToggleButton_1_1 = new JToggleButton("Medium");
		tglbtnNewToggleButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tglbtnNewToggleButton_1_1.setBounds(538, 419, 144, 36);
		contentPane.add(tglbtnNewToggleButton_1_1);
		tglbtnNewToggleButton_1_1.setVisible(false);
		tglbtnNewToggleButton_1_1.addActionListener(this);
		
		tglbtnNewToggleButton_1_2 = new JToggleButton("Large");
		tglbtnNewToggleButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tglbtnNewToggleButton_1_2.setBounds(737, 419, 144, 36);
		contentPane.add(tglbtnNewToggleButton_1_2);
		tglbtnNewToggleButton_1_2.setVisible(false);
		tglbtnNewToggleButton_1_2.addActionListener(this);
		
		btnNewButton_1 = new JButton("Remove, or edit products");
		btnNewButton_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton_1.setBounds(205, 278, 471, 65);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		
		btnNewButton_3 = new JButton("Dashboard");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton_3.setBounds(205, 396, 471, 65);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(this);
		
		btnNewButton_2 = new JButton("Add a product");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton_2.setBounds(205, 178, 465, 65);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);
		
		btnNewButton_5 = new JButton("Back");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_5.setBounds(10, 514, 110, 45);
		contentPane.add(btnNewButton_5);
		btnNewButton_5.setVisible(false);
		btnNewButton_5.addActionListener(this);
		
		
		comboBox = new JComboBox(VecObj.ProductsList);
		comboBox.setBounds(281, 101, 259, 63);
		contentPane.add(comboBox);
		comboBox.setVisible(false);
		comboBox.addActionListener(this);
		comboBox.setEditable(false);
		
		lblNewLabel_2 = new JLabel("Please select which product to remove:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(235, 65, 371, 33);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		btnNewButton_6 = new JButton("Remove");
		btnNewButton_6.setEnabled(false);
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_6.setBounds(354, 182, 104, 33);
		contentPane.add(btnNewButton_6);
		btnNewButton_6.setVisible(false);
		btnNewButton_6.addActionListener(this);
		
		
		lblNewLabel_3 = new JLabel("Please select which product to edit:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(235, 221, 371, 33);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		comboBox_1 = new JComboBox(VecObj.ProductsList);
		comboBox_1.setEditable(false);
		comboBox_1.setBounds(286, 264, 259, 45);
		contentPane.add(comboBox_1);
		comboBox_1.setVisible(false);
		comboBox_1.addActionListener(this);
		
		btnNewButton_7 = new JButton("Edit");
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_7.setBounds(354, 318, 104, 33);
		contentPane.add(btnNewButton_7);
		btnNewButton_7.addActionListener(this);
		btnNewButton_7.setVisible(false);
		btnNewButton_7.setEnabled(false);
		
		lblNewLabel_4 = new JLabel("Current name:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 250, 155, 33);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		
		lblNewLabel_5 = new JLabel("Current price:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(334, 362, 192, 33);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		
		lblNewLabel_6 = new JLabel("Current quantity:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(642, 250, 229, 33);
		contentPane.add(lblNewLabel_6);
		lblNewLabel_6.setVisible(false);
		
		
		tglbtnNewToggleButton = new JToggleButton("Edit name");
		tglbtnNewToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tglbtnNewToggleButton.setBounds(10, 280, 133, 36);
		contentPane.add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.setVisible(false);
		tglbtnNewToggleButton.addActionListener(this);
		
		tglbtnEditPrice = new JToggleButton("Edit price");
		tglbtnEditPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tglbtnEditPrice.setBounds(319, 390, 133, 36);
		contentPane.add(tglbtnEditPrice);
		tglbtnEditPrice.setVisible(false);
		tglbtnEditPrice.addActionListener(this);
		
		tglbtnEditQuantity = new JToggleButton("Edit quantity");
		tglbtnEditQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tglbtnEditQuantity.setBounds(642, 280, 130, 36);
		contentPane.add(tglbtnEditQuantity);
		tglbtnEditQuantity.setVisible(false);
		tglbtnEditQuantity.addActionListener(this);
		
		lblNewLabel_7 = new JLabel("Enter new name:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(10, 310, 133, 33);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_7.setVisible(false);
		
		lblNewLabel_7_1 = new JLabel("Enter new price:");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_1.setBounds(319, 425, 133, 33);
		contentPane.add(lblNewLabel_7_1);
		lblNewLabel_7_1.setVisible(false);
		
		lblNewLabel_7_2 = new JLabel("Enter new quantity:");
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_2.setBounds(642, 310, 139, 33);
		contentPane.add(lblNewLabel_7_2);
		lblNewLabel_7_2.setVisible(false);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(10, 335, 133, 36);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(false);
		textField_3.addActionListener(this);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(319, 457, 133, 36);
		contentPane.add(textField_4);
		textField_4.setVisible(false);
		textField_4.addActionListener(this);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(642, 335, 133, 36);
		contentPane.add(textField_5);
		textField_5.setVisible(false);
		textField_5.addActionListener(this);
		
		btnNewButton_8 = new JButton("Submit Changes");
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_8.setBounds(323, 514, 166, 45);
		contentPane.add(btnNewButton_8);
		btnNewButton_8.setVisible(false);
		btnNewButton_8.addActionListener(this);
		
		lblNewLabel_9 = new JLabel("Current Size:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(10, 416, 155, 19);
		contentPane.add(lblNewLabel_9);
		lblNewLabel_9.setVisible(false);
		
		tglbtnNewToggleButton_2 = new JToggleButton("Edit Size");
		tglbtnNewToggleButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tglbtnNewToggleButton_2.setBounds(10, 433, 121, 28);
		contentPane.add(tglbtnNewToggleButton_2);
		tglbtnNewToggleButton_2.setVisible(false);
		tglbtnNewToggleButton_2.addActionListener(this);
		
		lblNewLabel_10 = new JLabel("Select new size:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(10, 463, 123, 19);
		contentPane.add(lblNewLabel_10);
		lblNewLabel_10.setVisible(false);
		
		tglbtnNewToggleButton_3 = new JToggleButton("Medium");
		tglbtnNewToggleButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tglbtnNewToggleButton_3.setBounds(10, 483, 115, 21);
		contentPane.add(tglbtnNewToggleButton_3);
		tglbtnNewToggleButton_3.setVisible(false);
		tglbtnNewToggleButton_3.addActionListener(this);
		
		tglbtnNewToggleButton_4 = new JToggleButton("Large");
		tglbtnNewToggleButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tglbtnNewToggleButton_4.setBounds(145, 483, 115, 21);
		contentPane.add(tglbtnNewToggleButton_4);
		tglbtnNewToggleButton_4.setVisible(false);
		tglbtnNewToggleButton_4.addActionListener(this);
		
		tglbtnNewToggleButton_5 = new JToggleButton("Small");
		tglbtnNewToggleButton_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tglbtnNewToggleButton_5.setBounds(145, 455, 115, 21);
		contentPane.add(tglbtnNewToggleButton_5);
		tglbtnNewToggleButton_5.setVisible(false);
		tglbtnNewToggleButton_5.addActionListener(this);
		
		btnNewButton_9 = new JButton("Cancel");
		btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_9.setBounds(518, 184, 110, 28);
		contentPane.add(btnNewButton_9);
		btnNewButton_9.setVisible(false);
		btnNewButton_9.addActionListener(this);
		
		btnNewButton_10 = new JButton("Cancel");
		btnNewButton_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_10.setBounds(502, 318, 110, 28);
		contentPane.add(btnNewButton_10);
		btnNewButton_10.setVisible(false);
		btnNewButton_10.addActionListener(this);
		
		lblNewLabel_11 = new JLabel("Search Item: ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_11.setBounds(159, 395, 144, 36);
		contentPane.add(lblNewLabel_11);
		lblNewLabel_11.setVisible(false);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setBounds(333, 395, 166, 31);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		textField_6.setVisible(false);
		textField_6.addActionListener(this);
		
		btnNewButton_11 = new JButton("Search");
		btnNewButton_11.setVisible(false);
		btnNewButton_11.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_11.setBounds(538, 396, 103, 30);
		contentPane.add(btnNewButton_11);
		btnNewButton_11.addActionListener(this);
		
		btnNewButton_12 = new JButton("Cancel Search");
		btnNewButton_12.setVisible(false);
		btnNewButton_12.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_12.setBounds(538, 440, 166, 30);
		contentPane.add(btnNewButton_12);
		btnNewButton_12.addActionListener(this);

	}
	public static void TotalSold()
	{
		try {
			fb=new Scanner(new FileReader("bought q"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(fb.hasNext())
		{
			Read(fout);
			String n=fb.next();
			String s=fb.next();
			int qb=fb.nextInt();
			for(int i=0; i<VecObj.ProductsList.size(); i++)
			{
				
				if(n.equals(VecObj.ProductsList.elementAt(i).getName()) && s.equals(VecObj.ProductsList.elementAt(i).getSize()))
				{
					int BQ=VecObj.ProductsList.elementAt(i).getBought_quantity()+qb;
					VecObj.ProductsList.elementAt(i).setBought_quantity(BQ);
					data[i][4]=""+VecObj.ProductsList.elementAt(i).getBought_quantity();
				}
			}
		}
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
	public static void Read(PrintWriter F)
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
					JOptionPane.showMessageDialog(btnNewButton, "Please use text for name, number for price, and number without decimals for quantity");
				}
				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(btnNewButton, "Please use text for name, number for price, and number without decimals for quantity");
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(btnNewButton, "Exception!");
				}
				
			}
			data=new String[VecObj.ProductsList.size()][5];
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
			JOptionPane.showMessageDialog(null, "");
		}
		
		
		
	}
	public void removeLine(String lineContent) throws IOException
	{
		{
			String s;
			
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
				s=file_in.next();
				if (n!="")
				{
					if(n.equals(lineContent))
					{
					continue;
					}
				else
				{		
						
					toPrint+= n+ " "+p +" "+q+" "+s+"\n";
				}
				}
				
					
			}
			file_in.close();
			try {
				fout=new PrintWriter("Products Data");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fout.print(toPrint);
			Print(toPrint);
			Read(fout);
			fout.close();
			
		}
	}
	
	
	public AdminFrame(String name, String ID, String Password) {
		Read(fout);
		
		setTitle("KU Gfits Store Admin Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Enter the product name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(26, 119, 250, 61);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		
		lblNewLabel_1 = new JLabel("Enter the product price:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(26, 229, 250, 61);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		lblNewLabel_1_1 = new JLabel("Enter the product quantity:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1_1.setBounds(26, 324, 277, 61);
		contentPane.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setVisible(false);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(323, 132, 144, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		textField.addActionListener(this);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(323, 242, 144, 45);
		contentPane.add(textField_1);
		textField_1.setVisible(false);
		textField_1.addActionListener(this);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(323, 340, 144, 45);
		contentPane.add(textField_2);
		textField_2.setVisible(false);
		textField_2.addActionListener(this);
		
		lblKuGiftsStore=new JLabel("Admin name: "+name +", Admin ID: "+ ID);
		lblKuGiftsStore.setBackground(new Color(224, 255, 255));
		lblKuGiftsStore.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblKuGiftsStore.setBounds(10, 10, 631, 36);
		contentPane.add(lblKuGiftsStore);
		
		btnNewButton = new JButton("Logout");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(747, 10, 110, 36);
		contentPane.add(btnNewButton);
		
		lblNewLabel_8 = new JLabel("Choose the product size:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_8.setBounds(26, 419, 277, 36);
		contentPane.add(lblNewLabel_8);
		btnNewButton.addActionListener(this);
		lblNewLabel_8.setVisible(false);
		
		btnNewButton_4 = new JButton("Add product");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_4.setBounds(359, 498, 159, 61);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.setVisible(false);
		btnNewButton_4.addActionListener(this);
		
		tglbtnNewToggleButton_1 = new JToggleButton("Small");
		tglbtnNewToggleButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tglbtnNewToggleButton_1.setBounds(323, 419, 144, 36);
		contentPane.add(tglbtnNewToggleButton_1);
		tglbtnNewToggleButton_1.setVisible(false);
		tglbtnNewToggleButton_1.addActionListener(this);
		
		tglbtnNewToggleButton_1_1 = new JToggleButton("Medium");
		tglbtnNewToggleButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tglbtnNewToggleButton_1_1.setBounds(538, 419, 144, 36);
		contentPane.add(tglbtnNewToggleButton_1_1);
		tglbtnNewToggleButton_1_1.setVisible(false);
		tglbtnNewToggleButton_1_1.addActionListener(this);
		
		tglbtnNewToggleButton_1_2 = new JToggleButton("Large");
		tglbtnNewToggleButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tglbtnNewToggleButton_1_2.setBounds(737, 419, 144, 36);
		contentPane.add(tglbtnNewToggleButton_1_2);
		tglbtnNewToggleButton_1_2.setVisible(false);
		tglbtnNewToggleButton_1_2.addActionListener(this);
		
		btnNewButton_1 = new JButton("Remove, or edit products");
		btnNewButton_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton_1.setBounds(205, 278, 471, 65);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		
		btnNewButton_3 = new JButton("Dashboard");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton_3.setBounds(205, 396, 471, 65);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(this);
		
		btnNewButton_2 = new JButton("Add a product");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton_2.setBounds(205, 178, 465, 65);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);
		
		btnNewButton_5 = new JButton("Back");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_5.setBounds(10, 514, 110, 45);
		contentPane.add(btnNewButton_5);
		btnNewButton_5.setVisible(false);
		btnNewButton_5.addActionListener(this);
		
		
		comboBox = new JComboBox(VecObj.ProductsList);
		comboBox.setBounds(281, 101, 259, 63);
		contentPane.add(comboBox);
		comboBox.setVisible(false);
		comboBox.addActionListener(this);
		comboBox.setEditable(false);
		
		lblNewLabel_2 = new JLabel("Please select which product to remove:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(235, 65, 371, 33);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		btnNewButton_6 = new JButton("Remove");
		btnNewButton_6.setEnabled(false);
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_6.setBounds(354, 182, 104, 33);
		contentPane.add(btnNewButton_6);
		btnNewButton_6.setVisible(false);
		btnNewButton_6.addActionListener(this);
		
		
		lblNewLabel_3 = new JLabel("Please select which product to edit:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(235, 221, 371, 33);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		comboBox_1 = new JComboBox(VecObj.ProductsList);
		comboBox_1.setEditable(false);
		comboBox_1.setBounds(286, 264, 259, 45);
		contentPane.add(comboBox_1);
		comboBox_1.setVisible(false);
		comboBox_1.addActionListener(this);
		
		btnNewButton_7 = new JButton("Edit");
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_7.setBounds(354, 318, 104, 33);
		contentPane.add(btnNewButton_7);
		btnNewButton_7.addActionListener(this);
		btnNewButton_7.setVisible(false);
		btnNewButton_7.setEnabled(false);
		
		lblNewLabel_4 = new JLabel("Current name:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 250, 155, 33);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		
		lblNewLabel_5 = new JLabel("Current price:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(334, 362, 192, 33);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		
		lblNewLabel_6 = new JLabel("Current quantity:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(642, 250, 229, 33);
		contentPane.add(lblNewLabel_6);
		lblNewLabel_6.setVisible(false);
		
		
		tglbtnNewToggleButton = new JToggleButton("Edit name");
		tglbtnNewToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tglbtnNewToggleButton.setBounds(10, 280, 133, 36);
		contentPane.add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.setVisible(false);
		tglbtnNewToggleButton.addActionListener(this);
		
		tglbtnEditPrice = new JToggleButton("Edit price");
		tglbtnEditPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tglbtnEditPrice.setBounds(319, 390, 133, 36);
		contentPane.add(tglbtnEditPrice);
		tglbtnEditPrice.setVisible(false);
		tglbtnEditPrice.addActionListener(this);
		
		tglbtnEditQuantity = new JToggleButton("Edit quantity");
		tglbtnEditQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tglbtnEditQuantity.setBounds(642, 280, 130, 36);
		contentPane.add(tglbtnEditQuantity);
		tglbtnEditQuantity.setVisible(false);
		tglbtnEditQuantity.addActionListener(this);
		
		lblNewLabel_7 = new JLabel("Enter new name:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(10, 310, 133, 33);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_7.setVisible(false);
		
		lblNewLabel_7_1 = new JLabel("Enter new price:");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_1.setBounds(319, 425, 133, 33);
		contentPane.add(lblNewLabel_7_1);
		lblNewLabel_7_1.setVisible(false);
		
		lblNewLabel_7_2 = new JLabel("Enter new quantity:");
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_2.setBounds(642, 310, 139, 33);
		contentPane.add(lblNewLabel_7_2);
		lblNewLabel_7_2.setVisible(false);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(10, 335, 133, 36);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(false);
		textField_3.addActionListener(this);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(319, 457, 133, 36);
		contentPane.add(textField_4);
		textField_4.setVisible(false);
		textField_4.addActionListener(this);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(642, 335, 133, 36);
		contentPane.add(textField_5);
		textField_5.setVisible(false);
		textField_5.addActionListener(this);
		
		btnNewButton_8 = new JButton("Submit Changes");
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_8.setBounds(323, 514, 166, 45);
		contentPane.add(btnNewButton_8);
		btnNewButton_8.setVisible(false);
		btnNewButton_8.addActionListener(this);
		
		lblNewLabel_9 = new JLabel("Current Size:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(10, 416, 155, 19);
		contentPane.add(lblNewLabel_9);
		lblNewLabel_9.setVisible(false);
		
		tglbtnNewToggleButton_2 = new JToggleButton("Edit Size");
		tglbtnNewToggleButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tglbtnNewToggleButton_2.setBounds(10, 433, 121, 28);
		contentPane.add(tglbtnNewToggleButton_2);
		tglbtnNewToggleButton_2.setVisible(false);
		tglbtnNewToggleButton_2.addActionListener(this);
		
		lblNewLabel_10 = new JLabel("Select new size:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(10, 463, 123, 19);
		contentPane.add(lblNewLabel_10);
		lblNewLabel_10.setVisible(false);
		
		tglbtnNewToggleButton_3 = new JToggleButton("Medium");
		tglbtnNewToggleButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tglbtnNewToggleButton_3.setBounds(10, 483, 115, 21);
		contentPane.add(tglbtnNewToggleButton_3);
		tglbtnNewToggleButton_3.setVisible(false);
		tglbtnNewToggleButton_3.addActionListener(this);
		
		tglbtnNewToggleButton_4 = new JToggleButton("Large");
		tglbtnNewToggleButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tglbtnNewToggleButton_4.setBounds(145, 483, 115, 21);
		contentPane.add(tglbtnNewToggleButton_4);
		tglbtnNewToggleButton_4.setVisible(false);
		tglbtnNewToggleButton_4.addActionListener(this);
		
		tglbtnNewToggleButton_5 = new JToggleButton("Small");
		tglbtnNewToggleButton_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tglbtnNewToggleButton_5.setBounds(145, 455, 115, 21);
		contentPane.add(tglbtnNewToggleButton_5);
		tglbtnNewToggleButton_5.setVisible(false);
		tglbtnNewToggleButton_5.addActionListener(this);
		
		btnNewButton_9 = new JButton("Cancel");
		btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_9.setBounds(518, 184, 110, 28);
		contentPane.add(btnNewButton_9);
		btnNewButton_9.setVisible(false);
		btnNewButton_9.addActionListener(this);
		
		btnNewButton_10 = new JButton("Cancel");
		btnNewButton_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_10.setBounds(502, 318, 110, 28);
		contentPane.add(btnNewButton_10);
		btnNewButton_10.setVisible(false);
		btnNewButton_10.addActionListener(this);
		
		lblNewLabel_11 = new JLabel("Search Item: ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_11.setBounds(159, 395, 144, 36);
		contentPane.add(lblNewLabel_11);
		lblNewLabel_11.setVisible(false);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setBounds(333, 395, 166, 31);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		textField_6.setVisible(false);
		textField_6.addActionListener(this);
		
		btnNewButton_11 = new JButton("Search");
		btnNewButton_11.setVisible(false);
		btnNewButton_11.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_11.setBounds(538, 396, 103, 30);
		contentPane.add(btnNewButton_11);
		btnNewButton_11.addActionListener(this);
		
		btnNewButton_12 = new JButton("Cancel Search");
		btnNewButton_12.setVisible(false);
		btnNewButton_12.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_12.setBounds(538, 440, 166, 30);
		contentPane.add(btnNewButton_12);
		btnNewButton_12.addActionListener(this);

		
	}
	public static String[][] AdminsData()
	{
 			return AdminsData;
	}
}
