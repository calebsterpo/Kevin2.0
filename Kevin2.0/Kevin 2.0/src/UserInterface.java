import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserInterface extends JFrame implements ActionListener
{
	   private JTextArea a;
	   private JTextField f;
	   private JLabel lab;
	   private JTextArea face;
	   
	   public UserInterface()
	   {
		   	 
		   	 setLayout(null);
		     //create add any controls (label, controls)
		     lab = new JLabel();
		     a = new JTextArea();
		     f = new JTextField();
		     face = new JTextArea();
		     
		     // b.setBounds(x,y,w,h);
		     lab.setBounds(110,40,150,30);
		     a.setBounds(10,90,430,360);
		     face.setBounds(10,12,80,70);
		     f.setBounds(175,42,265,30);
		     
		     lab.setText("Enter text: ");
		     
		     this.setTitle("Kevin");
		     
		     f.addActionListener(this);
		     
		     this.add(a);
		     this.add(f);
		     this.add(lab);
		     this.add(face);
		     
		     this.getContentPane().setBackground(new Color(0,150,255));
		     
		     
		     smile();
		     
		     setDefaultCloseOperation(EXIT_ON_CLOSE);
		     setSize(467,500);
		     setVisible(true);
	   } 
	 
	@Override
    public void actionPerformed(ActionEvent e)
    {
     // get the text from JTextField
     // call the sendmessageToServer and pass the string from TextField
      String s;
     s = f.getText();
     //client.sendMessageToServer(s);
     f.setText("");
     a.append("You: " + s + "\n");
    }
	
	public void smile()
	{
	 face.setText(    "      /*******\\"
		     	    + "\n     {   O  O  }"
		     	+ "\n     \\  \\___/  /"
		     	   + "\n       \\____/");
	 face.setText("         ____"
+ "\n        |  o o  |"
+ "\n        |    _   |"
+ "\n         \\___/");
	}
	
	public void wink()
	{
	 face.setText(    "     /``````````\\"
		     	    + "\n    {    ~   O   }"
		     	+ "\n     \\   \\___/  /"
		     	   + "\n       \\____/");
	 
	}
     

}
