package presentation;

import buisness.BLL.RaportBLL;
import buisness.BLL.UserBLL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow extends JFrame{


    public JFrame frame = new JFrame("");

    private JLabel label1= new JLabel("Username");
    private JTextField username= new JTextField("");
    private JTextField textField1= new JTextField("");
    private JLabel label2= new JLabel("Password");
    private JButton logInButton=new JButton("log in");
    private  UserBLL u;
    private RaportBLL r;



    public StartWindow() {

        addComponents();
        jFrameSetup();

    }


    private void jFrameSetup() {


        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setBounds(250, 100, 830, 700);
        frame.getContentPane().setLayout(null);


        frame.setLocation(300, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void addComponents() {
        label1.setBounds(300, 270, 120, 25);
        frame.getContentPane().add(label1);
        username.setBounds(370, 270, 120, 30);
        frame.getContentPane().add(username);

        label2.setBounds(300, 320, 120, 25);
        frame.getContentPane().add(label2);
        textField1.setBounds(370, 320, 120, 30);
        frame.getContentPane().add(textField1);

       logInButton.setBounds(380, 390, 90, 30);
        frame.getContentPane().add(logInButton);


        logInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                String usern=username.getText();
                String pass=textField1.getText();
                 u = new UserBLL();
                System.out.println(usern);
                int ok=u.cauta(usern,pass);
                System.out.println(ok);
                if(ok==1)
                {

                    EmployeeGui employee = new EmployeeGui();
                    employee.frame.setVisible(true);

                    // JOptionPane.showMessageDialog(null,"Hei!");
                }else if(ok==2)
                {
                    AdministratorGUI admin = new AdministratorGUI();
                    admin.frame.setVisible(true);

                }else
                    JOptionPane.showMessageDialog(null,"Username/Password Wrong");




            }
        });


    }
    public static void main(String[] args) {
        StartWindow start = new StartWindow();
        start.frame.setVisible(true);
    }

}
