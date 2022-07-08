import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import java.awt.Dimension;
import java.awt.Component;

public class Student_info extends JFrame {

	/**
	 * Declaration
	 */
	
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JPasswordField passwordField;

	ArrayList<String> nameList;
	ArrayList<String> idList;
	ArrayList<String> passList;
	static Integer[] count;
	static int find;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_info frame = new Student_info();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Student_info() {
		
		nameList = new ArrayList<String>(); 
		nameList.add("Jitesh");
		nameList.add("Subham");
		nameList.add("Mohit"); 
		nameList.add("Tushar");
		passList = new ArrayList<String>();  
		passList.add("Jitesh"); 
		passList.add("Subham"); 
		passList.add("Mohit"); 
		passList.add("Tushar");
		idList = new ArrayList<String>(); 
		idList.add("iit2020224"); 
		idList.add("iit2020225");
		idList.add("iib2020043"); 
		idList.add("iit2020221");
		count = new Integer[nameList.size()];
		for(int i=0;i<nameList.size(); i++) {
			count[i]=0;
		}
		
		setUndecorated(true);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
              Image img = Toolkit.getDefaultToolkit().getImage(  
                        Home.class.getResource("/studentbg (2).jpg"));  
                 g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
             }  
    }; 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		lblNewLabel_2 = new JLabel("Student ID");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		Image image2=new ImageIcon(this.getClass().getResource("/User-Interface-Login-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(image2));
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String a = textField.getText();
				String b = textField_1.getText();
				char[] c = passwordField.getPassword();
				if(nameList.contains(a)) {
					find = nameList.indexOf(a);
					String xx = passList.get(find);
					if(idList.get(find).equals(b) && Arrays.equals(xx.toCharArray(), c)){
						//dispose();
						InstructionPage s = new InstructionPage();
						s.setVisible(true);
						textField.setText("");textField_1.setText("");passwordField.setText("");
						// to get the correct answers
					}
					else {
						JFrame j1 = new JFrame("invalid Details");
						 JOptionPane.showMessageDialog(j1,"Invalid id or password");
						 textField_1.setText("");passwordField.setText("");
					}
				}
				else {
					JFrame j1 = new JFrame("Registration Issue");
					 JOptionPane.showMessageDialog(j1,"Student not registered for test");
					 textField.setText("");textField_1.setText("");passwordField.setText("");
				}
			}
			
		});
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else
					passwordField.setEchoChar('*');
			}
		});
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home h=new Home();
				h.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_1.setSize(144, 35);
		Image image3=new ImageIcon(this.getClass().getResource("/Arrows-Back-icon.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(image3));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(667, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(chckbxNewCheckBox, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, Alignment.TRAILING)
								.addComponent(textField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
					.addGap(46))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(161)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxNewCheckBox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(175, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		contentPane.setVisible(true);
	}
	
	public ArrayList<String> gettername(){
		return nameList;
	}
	public ArrayList<String> getterid(){
		return idList;
	}
}
