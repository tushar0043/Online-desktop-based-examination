import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;
import javax.swing.border.EmptyBorder;  
 
class Test extends JFrame implements ActionListener  
{  
	
	
	private JPanel contentPane;
	JLabel l; 
	JLabel lblNewLabel_x;
    JLabel lblNewLabel_y ;
    JRadioButton jb[]=new JRadioButton[5];   
    JButton b1,b2,btnNewButton_1,b3;  
    ButtonGroup bg;  
    public int min=0;
    public int sec=0;
    public int flag=0,flag1=0;
    Timer time;
    int weightage=0;
	int question_number=0;
	int x=1;
	int y=1;
	int now=0;  
    int m[]=new int[10];   
    public Test() {
    	setLocationRelativeTo(this);
    	
    }
    public Test(String s)  
    {  
    	
    	
    	
        super(s);  
        setUndecorated(true);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        contentPane = new JPanel(){  
        };
        // CODE FOR TIMER STARTS
        	JLabel lblNewLabel = new JLabel("Total Time:");
            lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
            lblNewLabel.setBounds(950, 33, 105, 25);
            contentPane.add(lblNewLabel);
            
            JLabel lblNewLabel_1 = new JLabel("10 Min");
            lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
            lblNewLabel_1.setBounds(1097, 33, 63, 25);
            contentPane.add(lblNewLabel_1);
            
            JLabel lblNewLabel_2 = new JLabel("Time Taken:");
            lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
            lblNewLabel_2.setBounds(950, 71, 105, 14);
            contentPane.add(lblNewLabel_2);
            
            JLabel lblNewLabel_3 = new JLabel("0");
            lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
            lblNewLabel_3.setBounds(1097, 71, 26, 14);
            contentPane.add(lblNewLabel_3);
            
            JLabel lblNewLabel_4 = new JLabel("0");
            lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
            lblNewLabel_4.setBounds(1133, 71, 27, 14);
            contentPane.add(lblNewLabel_4);
            
        	time = new Timer(1000, new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {

    				lblNewLabel_4.setText(String.valueOf(sec));
    				lblNewLabel_3.setText(String.valueOf(min));
    				if(sec==60) {
    					sec=0;
    					min++;
    					if(min==10) {
    						time.stop();
    						b1.setEnabled(false);  
    		                b2.setText("Result"); 
    		                JOptionPane.showMessageDialog(contentPane,"Time is over. Click on result button to view the result");
    		                flag=1;
    					}
    				}
    				sec++;
    			}
        		
        	});
        	time.start();
        	//CODE FOR TIMER ENDS
    
    setContentPane(contentPane);
    getContentPane().setLayout(null);
    setBounds(100,100,1500,1000);
    contentPane.setBackground(Color.WHITE);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));



        l=new JLabel();  
        getContentPane().add(l); 
        lblNewLabel_x = new JLabel();
        lblNewLabel_y = new JLabel();
        getContentPane().add(lblNewLabel_x);
        getContentPane().add(lblNewLabel_y);

        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            getContentPane().add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        b2=new JButton("Bookmark");  
        b2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        b3=new JButton(" Save");  
        b3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        Image image3=new ImageIcon(this.getClass().getResource("/Next-icon.png")).getImage();
		b1.setIcon(new ImageIcon(image3));
		Image image4=new ImageIcon(this.getClass().getResource("/Bookmark-icon.png")).getImage();
		b2.setIcon(new ImageIcon(image4));
		Image image5=new ImageIcon(this.getClass().getResource("/Save-icon.png")).getImage();
		b3.setIcon(new ImageIcon(image5));
        b1.addActionListener(this);  
        b2.addActionListener(this); 
        b3.addActionListener(this); 
     
        getContentPane().add(b1);getContentPane().add(b2);
        getContentPane().add(b3);
        questionset();  
       
        Font font = new Font("Verdana",Font.BOLD, 20);
        l.setFont(font);
        lblNewLabel_x.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_y.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().setLayout(null);
        
        b1.setBounds(588,425,150,41);  
        b2.setBounds(94,425,150,41);
        b3.setBounds(341,425,150,41);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        getContentPane().setLayout(null);
         
        setVisible(true);    
    }  
    public void actionPerformed(ActionEvent e)  
    {  
    	if(e.getSource()==b3) {
        	if(check()) {
        		getWeightage();
        		Student_info.count[Student_info.find]= Student_info.count[Student_info.find]+weightage;  
        	} 
        	if(b2.getText()=="Bookmark")
        		b2.setEnabled(false);
        	b3.setEnabled(false);
        }
        if(e.getSource()==b1)  
        {  
        	b3.setEnabled(true);
        	b2.setEnabled(true);
        	if(flag1==0) 
            question_number++;  
        	else {
              question_number=now+1;
              flag1=0;}
            questionset();    
            if(question_number==9)  
            {
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(800,20+30*x,100,30);  
            getContentPane().add(bk);  
            bk.addActionListener(this);  
            m[x]=question_number;  
            x++;  
            question_number++;  
            questionset();    
            if(question_number==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
        	if(flag==1) {
        		JOptionPane.showMessageDialog(contentPane,"Time is over. Click on result button to view the result");
        		((JButton)e.getSource()).setEnabled(false);
        	}
        	else {
        		flag1=1;
        		now=question_number; 
        		b3.setEnabled(true);
        		question_number=m[y];  
                questionset();  
                 
            
            ((JButton)e.getSource()).setEnabled(false);  
             
        } 
        }  }
        
        if(e.getActionCommand().equals("Result"))  
        { 
            question_number++;  
            time.stop();
			dispose();
			FINALRESULT s = new FINALRESULT();
		    s.setVisible(true);  
        } 
        
        
    }  
    void questionset()  
    {
    	l.setBounds(30,50,910,25);  
        l.setForeground(Color.black);
        jb[0].setBounds(55,120,150,20);  
        jb[1].setBounds(55,170,150,20);  
        jb[2].setBounds(55,220,150,20);  
        jb[3].setBounds(55,270,150,20);
        jb[4].setSelected(true); 
        
        lblNewLabel_x.setBounds(950, 105, 120, 20);
        lblNewLabel_y.setBounds(950, 130, 120, 20);
       
        if(question_number==0)  
        {  
        	
            l.setText("Que1: Which of the following is not a keyword in java?");  
            jb[0].setText("private");jb[1].setText("Boolean");jb[2].setText("static");jb[3].setText("void"); 
            lblNewLabel_x.setText("level: easy");
            lblNewLabel_y.setText("marks: 3");
        }  
        if(question_number==1)  
        {  
            l.setText("Que2: What is the size of boolean variable?");  
            jb[0].setText("8 bit");jb[1].setText("32 bit");jb[2].setText("16 bit");jb[3].setText("None of the above");
            lblNewLabel_x.setText("level: easy");
            lblNewLabel_y.setText("marks: 3");
        }  
        if(question_number==2)  
        {  
            l.setText("Que3: What is the default value of byte variable?");  
            jb[0].setText("0.0");jb[1].setText("null");jb[2].setText("undefined");jb[3].setText("0");
            lblNewLabel_x.setText("level: easy");
            lblNewLabel_y.setText("marks: 3");
        }  
        if(question_number==3)  
        {  
            l.setText("Que4: String class is defined in which package?");  
            jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");  
            lblNewLabel_x.setText("level: medium");
            lblNewLabel_y.setText("marks: 4");
        }
        if(question_number==4)  
        {  
            l.setText("Que5: Which method must be implemented by all threads?");  
            jb[0].setText("start()");jb[1].setText("stop()");jb[2].setText("run()");jb[3].setText("wait()");
            lblNewLabel_x.setText("level: medium");
            lblNewLabel_y.setText("marks: 4");
        }  
        if(question_number==5)  
        {  
            l.setText("Que6: java.util.Collections is a:");  
            jb[0].setText("object");jb[1].setText("interface");jb[2].setText("class");jb[3].setText("none of the above");
            lblNewLabel_x.setText("level: medium");
            lblNewLabel_y.setText("marks: 4");
        }  
        if(question_number==6)  
        {  
            l.setText("Que7: Which one among these is not a class? ");  
            jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");  jb[3].setText("Button");  
            lblNewLabel_x.setText("level: medium");
            lblNewLabel_y.setText("marks: 4"); 
                        
        }  
        if(question_number==7)  
        {  
            l.setText("Que8: Which one among these is not a function of Object class?");  
            jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");jb[3].setText("getDocumentBase");   
            lblNewLabel_x.setText("level: hard");
            lblNewLabel_y.setText("marks: 5");
                        
        }  
        if(question_number==8)  
        {  
            l.setText("Que9: Which function is not present in Applet class?");  
            jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy"); 
            lblNewLabel_x.setText("level: hard");
            lblNewLabel_y.setText("marks: 5");
        }  
        if(question_number==9)  
        {  
            l.setText("Que10: Which one among these is not a valid component?");  
            jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup"); jb[3].setText("JTextArea");   
            lblNewLabel_x.setText("level: hard");
            lblNewLabel_y.setText("marks: 5");
        }  
          
    }  
    boolean check()  
    {  
        if(question_number==0)  
            return(jb[1].isSelected());  
        if(question_number==1)  
            return(jb[2].isSelected());  
        if(question_number==2)  
            return(jb[3].isSelected());  
        if(question_number==3)  
            return(jb[0].isSelected());  
        if(question_number==4)  
            return(jb[2].isSelected());  
        if(question_number==5)  
            return(jb[2].isSelected());  
        if(question_number==6)  
            return(jb[1].isSelected());  
        if(question_number==7)  
            return(jb[3].isSelected());  
        if(question_number==8)  
            return(jb[1].isSelected());  
        if(question_number==9)  
            return(jb[2].isSelected());  
        
        return false;  
    }  
    public static void main(String s[])  
    {  
        new Test("ONLINE DESKTOP PORTAL");  
    } 
    
    public void getWeightage() {
    	if(question_number>=0 && question_number<=2) {
    		weightage = 3;
    	}
    	else if(question_number>=3 && question_number<=6) {
    		weightage = 4;
    	}
    	else if(question_number>=7 && question_number<=9) {
    		weightage = 5;
    	}
    }
}