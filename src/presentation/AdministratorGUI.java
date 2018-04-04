package presentation;

import buisness.BLL.FisierRaport;
import buisness.BLL.RaportBLL;
import buisness.BLL.UserBLL;
import buisness.model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdministratorGUI extends JFrame{

    public   JFrame frame = new JFrame("Administrator");
    String tipp []={"angajat","administrator"};
    private JLabel id = new JLabel(" IdUser");
    private JTextField ida = new JTextField("");
    private JLabel user = new JLabel("Username");
    private JTextField usera = new JTextField("");
    private JLabel pass = new JLabel("Password");
    private JTextField passa = new JTextField("");
    private JComboBox tip = new JComboBox(tipp);
    private JTextField tipa = new JTextField("");
    private JTextField numea = new JTextField("");
    private JLabel nume = new JLabel(" Nume");
    private JTextField adresaa = new JTextField("");
    private JLabel adresa = new JLabel("Adresa");

    private JButton add = new JButton("Create");
    private JButton  delete= new JButton("Delete");
    private JButton update = new JButton("Update");
    private JButton view = new JButton("View");
    private JButton logOut = new JButton("Log Out");
    private JButton raport = new JButton("Raport");
    private UserBLL userbll= new UserBLL();
    private DefaultTableModel model1 = new DefaultTableModel();
    private JTable tp1;
    private JFrame framee;
    private JButton b = new JButton("Refresh");

    private JLabel idr = new JLabel("Username");
    private JTextField idrr = new JTextField("");
    private JLabel data = new JLabel("DD/MM/YYYY");
    private JTextField datar = new JTextField("");
    private RaportBLL raportBLL= new RaportBLL();


    public AdministratorGUI() {

        addComponents();
        jFrameSetup();

    }


    private void jFrameSetup() {


        frame.getContentPane().setBackground(Color.CYAN);
        frame.setBounds(250, 100, 830, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        frame.setLocation(485, 0);


    }

    public void addComponents() {



        idr.setBounds(90, 435, 80, 25);
        frame.getContentPane().add(idr);
        idrr.setBounds(80, 470, 80, 25);
        frame.getContentPane().add(idrr);

        data.setBounds(195, 440, 80, 25);
        frame.getContentPane().add(data);
        datar.setBounds(180, 470, 80, 25);
        frame.getContentPane().add(datar);

        raport.setBounds(130, 540, 100, 30);
        frame.getContentPane().add(raport);


        id.setBounds(90, 245, 80, 25);
        frame.getContentPane().add(id);
        ida.setBounds(80, 270, 80, 25);
        frame.getContentPane().add(ida);

        user.setBounds(195, 240, 80, 25);
        frame.getContentPane().add(user);
        usera.setBounds(180, 270, 80, 25);
        frame.getContentPane().add(usera);

        pass.setBounds(290, 245, 80, 25);
        frame.getContentPane().add(pass);
        passa.setBounds(280, 270, 80, 25);
        frame.getContentPane().add(passa);

        nume.setBounds(400, 245, 80, 25);
        frame.getContentPane().add(nume);
        numea.setBounds(380, 270, 80, 25);
        frame.getContentPane().add(numea);

        adresa.setBounds(500, 245, 80, 25);
        frame.getContentPane().add(adresa);
        adresaa.setBounds(480, 270, 80, 25);
        frame.getContentPane().add(adresaa);

        add.setBounds(130, 340, 100, 30);
        frame.getContentPane().add(add);
        update.setBounds(250, 340, 100, 30);
        frame.getContentPane().add(update);
        delete.setBounds(370, 340, 100, 30);
        frame.getContentPane().add(delete);
        view.setBounds(490, 340, 100, 30);
        frame.getContentPane().add(view);


        tip.setBounds(580, 270, 100, 25);
        frame.getContentPane().add(tip);

        logOut.setBounds(650, 600, 100, 30);
        frame.getContentPane().add(logOut);


        b.setBounds(235, 600, 100, 30);


       logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StartWindow start = new StartWindow();
                start.frame.setVisible(true);
            }

        });


        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(tip.getSelectedItem().toString().equals("angajat"))
                {
                    User user = new User(Integer.parseInt(ida.getText()),usera.getText(),passa.getText(),1,numea.getText(),adresaa.getText());
                    userbll.insertUser(user);
                    JOptionPane.showMessageDialog(null,"Success");
                }else

                {
                    User user = new User(Integer.parseInt(ida.getText()),usera.getText(),passa.getText(),2,numea.getText(),adresaa.getText());
                    userbll.insertUser(user);
                    JOptionPane.showMessageDialog(null,"Success");
                }
               framee.invalidate();
                framee.validate();
                framee.repaint();

            }
        });

        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                userbll.update(numea.getText(),adresaa.getText(),Integer.parseInt(ida.getText()));
                JOptionPane.showMessageDialog(null,"Success");
            }
        });

        raport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

               List<String>lista=raportBLL.cauta(idrr.getText(),datar.getText());
                FisierRaport fisier = new FisierRaport();
                fisier.genereazaFactura(lista);
            }
        });


        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                userbll.deleteUser(Integer.parseInt(ida.getText()));
                JOptionPane.showMessageDialog(null,"Success");


            }
        });


        model1.addColumn("IdUser");
        model1.addColumn("Username");
        model1.addColumn("Pass");
        model1.addColumn("Tip");
        model1.addColumn("Nume");
        model1.addColumn("Adresa");
        view.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<User> list =userbll.getAll();
                model1.setRowCount(0);
                tp1 = new JTable(model1);
                for (User user : list) {
                    model1.addRow(new Object[]{user.getIdUser(),user.getUsername(),user.getPass(),user.getTip(),user.getNume(),user.getAdresa()});


                }


                 framee = new JFrame("User");

                framee.setSize(500, 700);

                JPanel p = new JPanel();
                p.setBackground(Color.CYAN);
                p.add(new JScrollPane(tp1), BorderLayout.CENTER);

                p.setLayout(new FlowLayout());
                framee.setBackground(Color.CYAN);
                framee.setContentPane(p);
                framee.setVisible(true);
            }
        });
    }

    }
