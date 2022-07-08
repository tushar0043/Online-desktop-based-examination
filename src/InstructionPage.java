import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InstructionPage extends JFrame {

	/**
	 * 
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructionPage frame = new InstructionPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	InstructionPage(){
		setUndecorated(true);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 40));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100,100,1500,1000);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSTRUCTIONS- Read Carefully");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 11, 713, 70);
		getContentPane().add(lblNewLabel);
		Image image2=new ImageIcon(this.getClass().getResource("/instructions.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image2));
		
		JTextArea txtrreadTheQuestions = new JTextArea();
		txtrreadTheQuestions.setBackground(new Color(240, 128, 128));
		txtrreadTheQuestions.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtrreadTheQuestions.setText(" 1.Read the questions properly\r\n 2.Answer all the questions.\r\n 3.NO NEGATIVE MARKING.\r\n 4.Questions are of varying difficulties,"
				+ " 3 easy questions of 3 marks each, 4 medium\r\n   questions of 4 marks each , 3 diffiult questions of 5 marks each.\r\n 5.Each question have 4 option"
				+ " out of which one or more options are correct.\r\n 6.Your answer will only be considered if you click save button for each question.\r\n 7.If you move to next or bookmarked question, you can't return or access any\r\n   previous question.\r\n   ALL THE BEST!!");
		txtrreadTheQuestions.setBounds(10, 128, 800, 240);
		getContentPane().add(txtrreadTheQuestions);

		txtrreadTheQuestions.setCaretColor(txtrreadTheQuestions.getBackground());
		txtrreadTheQuestions.getCaret().setVisible(false);
		JButton btnNewButton = new JButton("Click here to Begin!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Test t = new Test("ONLINE DESKTOP PORTAL");
				t.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(10, 387, 260, 49);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit the Portal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x=JOptionPane.showConfirmDialog(null,"Do you want to exit the Portal?","Select",JOptionPane.YES_NO_OPTION);
				if(x==0)
					System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(10, 467, 260, 39);
		getContentPane().add(btnNewButton_1);
		
	}
}