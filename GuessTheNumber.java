package pkg1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RandNum implements ActionListener {
	JFrame f;
	JLabel l1,l2,l3;
	JTextField t1;
	JButton b1,b2;
	int num=(int)(Math.random()*(100-0)+1);
	int trial=0;
	
	RandNum(){
		f=new JFrame();
		
		l1=new JLabel("Guess the number in my mind !");
		l1.setBounds(60,30,200,20);
		
		l2=new JLabel("Hint: It lies between 0 and 50");
		l2.setBounds(50,70,200,20);
		
		l3=new JLabel();
		l3.setBounds(50,110,500,60);
		l3.setVisible(false);
		
		t1=new JTextField();
		t1.setBounds(120,210,60,40);
		
		b1=new JButton("Enter");
		b1.setBounds(110,270,80,20);
		
		b2=new JButton("No");
		b2.setBounds(110,270,80,20);
		b2.setVisible(false);
		
		b1.addActionListener(this);
		
		b2.addActionListener(this);
		
		f.add(b1);
		f.add(l1);
		f.add(l2);
		f.add(t1);
		f.add(l3);
		f.add(b2);
		
		f.setTitle("Number Game");
		f.setSize(550,340);
		f.setLayout(null);
		f.setVisible(true);
	}
		
	public void actionPerformed(ActionEvent e) {
		int guess=Integer.parseInt(t1.getText());
		l3.setVisible(true);
		
		if(guess==num) {
			l2.setText("<html>Hurray! You guessed it right.<html>");
			l3.setText("<html>You have taken "+trial+" chances to <br>guess the correct number.<br>Do you want to play again?<html>");
			trial=0;
			b1.setText("Yes");
			b1.setBounds(75,270,70,20);
			b2.setText("No");
			b2.setBounds(170,270,70,20);
			b2.setVisible(true);
			b2.addActionListener(this);
			if(e.getSource()==b2) {
				f.dispose();
			}
			else if(e.getSource()==b1) {
				int num=(int)(Math.random()*(100-0)+1);
				int trial=0;
				l2.setText("Hint: It lies between 0 and 100");
				l2.setBounds(50,70,300,20);
				l3.setVisible(false);
				b1.setText("Enter");
				b1.setBounds(110,270,80,20);
				b2.setVisible(false);


			}
			
			
		}
		else if(num<guess) {
			l3.setText("The target is lesser than your guess. Try a smaller number");
			++trial;
		}else {
			l3.setText("The target is greater than your guess. Try a larger number");
			++trial;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RandNum();
	}

	

}
