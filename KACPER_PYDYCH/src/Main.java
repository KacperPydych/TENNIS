import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public int result1 = 0;                                 //declaring integers and swing elements
    public int result2 = 0;
    public String winner;
    public JButton buttonresult1, buttonresult2, reset;
    public JFrame frame;
    public JPanel panel;
    public JTextField textResult1, textResult2;
    public JLabel labelWin;

    public void wins(String winner){                            //method for declaring a winner
        this.winner = winner;
        if (winner.equals("server")){
            textResult1.setBackground(Color.green);             //if server wins, method changes background of his code to green, reciever's to red, make it impossible to change score,
            textResult2.setBackground(Color.red);               // displays winner and allows to start new game
            buttonresult1.setVisible(false);
            buttonresult2.setVisible(false);
            reset.setVisible(true);
            labelWin.setText("<html>Server<br>WINS!</html>");
            labelWin.setVisible(true);

        } else if (winner.equals("reciever")) {
            textResult1.setBackground(Color.red);
            textResult2.setBackground(Color.green);
            buttonresult1.setVisible(false);
            buttonresult2.setVisible(false);
            reset.setVisible(true);
            labelWin.setText("<html>Reciever<br>WINS!</html>");
            labelWin.setVisible(true);
        }
    }

    public void setTo40(){                                              //method, that sets results to 40 and text to results converted to strings
        result1 = 40;
        textResult1.setText(Integer.toString(result1));
        result2 = 40;
        textResult2.setText(Integer.toString(result2));
    }



    public void GUI() {                                             //method,that sets GUI UP
        frame = new JFrame();
        panel = new JPanel();
        buttonresult1 = new JButton("Point for Server!");
        buttonresult2 = new JButton("Point for Reciever!");
        reset = new JButton("<html>New<br>game");
        textResult1 = new JTextField("0");
        textResult2 = new JTextField("0");
        labelWin = new JLabel();

        frame.getContentPane().add(panel);

        panel.setLayout(null);
        panel.add(buttonresult1);
        panel.add(buttonresult2);
        panel.add(reset);
        panel.add(textResult1);
        panel.add(textResult2);
        panel.add(labelWin);

        reset.setVisible(false);
        labelWin.setVisible(true);

        buttonresult1.setFont(new Font("Arial", Font.BOLD, 50));
        buttonresult2.setFont(new Font("Arial", Font.BOLD, 50));
        reset.setFont(new Font("Arial", Font.BOLD, 55));
        labelWin.setFont(new Font("Arial", Font.BOLD, 65));
        labelWin.setHorizontalAlignment(SwingConstants.CENTER);

        textResult1.setFont(new Font("Arial", Font.BOLD, 350));
        textResult1.setHorizontalAlignment(SwingConstants.CENTER);
        textResult2.setFont(new Font("Arial", Font.BOLD, 350));
        textResult2.setHorizontalAlignment(SwingConstants.CENTER);

        textResult1.setEditable(false);
        textResult1.setFocusable(false);
        textResult2.setEditable(false);
        textResult2.setFocusable(false);

        buttonresult1.setBounds(100, 600, 500, 300);
        buttonresult2.setBounds(900, 600, 500, 300);
        reset.setBounds(600, 600, 300, 300);
        textResult1.setBounds(100, 50, 500, 500);
        textResult2.setBounds(900, 50, 500, 500);
        labelWin.setBounds(600,0,300,700);

        buttonresult1.addActionListener(new buttonListener());
        buttonresult2.addActionListener(new buttonListener());
        reset.addActionListener(new buttonListener());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1000);
        frame.setVisible(true);

    }

    class buttonListener implements ActionListener {                    //buttons' functions

        public void actionPerformed(ActionEvent click) {
            Object source = click.getSource();
            if (source == buttonresult1)                                //button increasing server's points
            {
                if (result1 == 0)
                {
                    result1 = 15;
                    textResult1.setText(Integer.toString(result1));
                }
                else if (result1 == 15)
                {
                    result1 = 30;
                    textResult1.setText(Integer.toString(result1));
                }
                else if (result1 == 30)
                {
                    result1 = 40;
                    textResult1.setText(Integer.toString(result1));
                }
                else if (result1 == 40)
                {
                    if(result2<40)
                    {
                        wins("server");

                    }
                    else if(result2>40)
                    {
                        setTo40();
                    }

                    else
                    {
                        result1++;
                        textResult1.setText("A");
                    }
                }
                else if(result1 ==41)
                {
                    if(result2!=41)
                    {

                        wins("server");
                    }

                    else
                    {
                        setTo40();

                    }
                }
            }

            if (source == buttonresult2)                                //button increasing reciever's points
            {
                if (result2 == 0)
                {
                    result2 = 15;
                    textResult2.setText(Integer.toString(result2));
                }
                else if (result2 == 15)
                {
                    result2 = 30;
                    textResult2.setText(Integer.toString(result2));
                }
                else if (result2 == 30)
                {
                    result2 = 40;
                    textResult2.setText(Integer.toString(result2));
                }
                else if (result2 == 40)
                {
                    if(result1< 40)
                    {
                        wins("reciever");

                    }
                    else if(result1>40){
                        setTo40();
                    }
                    else
                    {
                        result2++;
                        textResult2.setText("A");
                    }
                }
                else if (result2 == 41)
                {
                    if(result1!=41)
                    {


                        wins("reciever");
                    }
                    else
                    {
                        setTo40();

                    }


                }
            }

            if (source == reset) {                                  //button reseting scores
                reset.setVisible(false);
                result1 = 0;
                result2 = 0;
                buttonresult1.setVisible(true);
                buttonresult2.setVisible(true);

                textResult1.setBackground(Color.white);
                textResult1.setText(Integer.toString(0));
                textResult2.setBackground(Color.white);
                textResult2.setText(Integer.toString(0));
                labelWin.setVisible(false);
            }

        }
    }

    public static void main(String[] args) {
        Main program = new Main();                                 //main method
        program.GUI();
    }


}

