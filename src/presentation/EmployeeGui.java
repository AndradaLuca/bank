package presentation;

import buisness.BLL.ClientBLL;
import buisness.BLL.ContBLL;
import buisness.model.Client;
import buisness.model.Cont;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmployeeGui extends JFrame {
    private DefaultTableModel model = new DefaultTableModel();
    private DefaultTableModel model1 = new DefaultTableModel();
    private JButton button = new JButton("View Client");
    private JButton button1 = new JButton("Log out");
    private JButton updateClient = new JButton("Update Client");
    private JButton insertClient = new JButton(" Insert Client");
    private JButton createAcc = new JButton("Create Acc");
    private JButton ViewAcc = new JButton("View");
    private JButton deleteAcc = new JButton("Delete");
    private JButton updateAcc = new JButton("Update");
    private JLabel idl = new JLabel(" IdClient");
    private JLabel numel = new JLabel("  Nume");
    private JLabel seriel = new JLabel("  Serie");
    private JLabel cnpl = new JLabel("  CNP");
    private JLabel adresal = new JLabel("Adresa");
    private JLabel telefonl = new JLabel(" Telefon");
    private JLabel idAcc = new JLabel("IdAccount");
    private JLabel idClient = new JLabel("IdPosesor");
    private JLabel data = new JLabel("Data");
    private JLabel tip = new JLabel(" Tip");
    private JLabel bani = new JLabel(" Suma");
    private JTextField id = new JTextField("");
    private JTextField nume = new JTextField("");
    private JTextField serie = new JTextField("");
    private JTextField cnp = new JTextField("");
    private JTextField adresa = new JTextField("");
    private JTextField telefon = new JTextField("");
    private JTextField idAcco = new JTextField("");
    private JTextField idClientAcco = new JTextField("");
    private JTextField sumaAcco = new JTextField("");
    private JTextField dataAcco = new JTextField("");
    private JTextField tipAcco = new JTextField("");
    private ContBLL contBll=new ContBLL();
    ClientBLL c = new ClientBLL();
    private JTable tp;
    private JTable tp1;

    private JLabel transfer1 = new JLabel(" IdCont");
    private JLabel transfer2 = new JLabel(" IdCont");
    private JTextField t1 = new JTextField("");
    private JTextField t2 = new JTextField("");
    private JLabel suma = new JLabel(" Suma");
    private JTextField suma1 = new JTextField("");
    private JButton transfer = new JButton("Transfer");
    private JButton utilitati = new JButton("Plata utilitati");

    public JFrame frame = new JFrame("Employee");

    public EmployeeGui() {

        addComponents();
        jFrameSetup();

    }


    private void jFrameSetup() {


        frame.getContentPane().setBackground(Color.CYAN);
        frame.setBounds(250, 100, 830, 700);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // frame.setLocationRelativeTo(null);
        frame.setLocation(485, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void addComponents() {

        idl.setBounds(90, 45, 80, 25);
        frame.getContentPane().add(idl);
        id.setBounds(80, 70, 80, 25);
        frame.getContentPane().add(id);

        numel.setBounds(195, 45, 80, 25);
        frame.getContentPane().add(numel);
        nume.setBounds(180, 70, 80, 25);
        frame.getContentPane().add(nume);

        seriel.setBounds(290, 45, 80, 25);
        frame.getContentPane().add(seriel);
        serie.setBounds(280, 70, 80, 25);
        frame.getContentPane().add(serie);

        cnpl.setBounds(400, 45, 80, 25);
        frame.getContentPane().add(cnpl);
        cnp.setBounds(380, 70, 80, 25);
        frame.getContentPane().add(cnp);

        adresal.setBounds(500, 45, 80, 25);
        frame.getContentPane().add(adresal);
        adresa.setBounds(480, 70, 80, 25);
        frame.getContentPane().add(adresa);

        telefonl.setBounds(595, 45, 80, 25);
        frame.getContentPane().add(telefonl);
        telefon.setBounds(580, 70, 80, 25);
        frame.getContentPane().add(telefon);


        idAcc.setBounds(90, 300, 80, 25);
        frame.getContentPane().add(idAcc);
        idAcco.setBounds(80, 330, 80, 25);
        frame.getContentPane().add(idAcco);

        idClient.setBounds(200, 300, 80, 25);
        frame.getContentPane().add(idClient);
        idClientAcco.setBounds(190, 330, 80, 25);
        frame.getContentPane().add(idClientAcco);


        tip.setBounds(320, 300, 80, 25);
        frame.getContentPane().add(tip);
        tipAcco.setBounds(300, 330, 80, 25);
        frame.getContentPane().add(tipAcco);

        data.setBounds(430, 300,80, 25);
        frame.getContentPane().add(data);
        dataAcco.setBounds(410, 330, 80, 25);
        frame.getContentPane().add(dataAcco);

        bani.setBounds(540, 300, 80, 25);
        frame.getContentPane().add(bani);
        sumaAcco.setBounds(520, 330, 80, 25);
        frame.getContentPane().add(sumaAcco);


        createAcc.setBounds(110, 390, 100, 30);
        frame.getContentPane().add(createAcc);
        updateAcc.setBounds(230, 390, 100, 30);
        frame.getContentPane().add(updateAcc);
        deleteAcc.setBounds(350, 390, 100, 30);
        frame.getContentPane().add(deleteAcc);
        ViewAcc.setBounds(470, 390, 100, 30);
        frame.getContentPane().add(ViewAcc);

        button1.setBounds(650, 600, 100, 30);
        frame.getContentPane().add(button1);

        transfer1.setBounds(150,500,100,30);
        frame.getContentPane().add(transfer1);
        t1.setBounds(123,530,100,30);
        frame.getContentPane().add(t1);
        transfer2.setBounds(270,500,100,30);
        frame.getContentPane().add(transfer2);
        t2.setBounds(248,530,100,30);
        frame.getContentPane().add(t2);
        suma.setBounds(390,500,100,30);
        frame.getContentPane().add(suma);
        suma1.setBounds(368,530,100,30);
        frame.getContentPane().add(suma1);

        transfer.setBounds(180,580,100,30);
        frame.getContentPane().add(transfer);
        utilitati.setBounds(300,580,130,30);
        frame.getContentPane().add(utilitati);

        insertClient.setBounds(500, 130, 120, 30);
        updateClient.setBounds(320, 130, 120, 30);
        button.setBounds(140, 130, 120, 30);
        frame.getContentPane().add(insertClient);
        frame.getContentPane().add(button);
        frame.getContentPane().add(updateClient);

        model1.addColumn("IdCont");
        model1.addColumn("IdClient");
        model1.addColumn("Tip");
        model1.addColumn("Suma");
        model1.addColumn("Data");


        utilitati.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contBll.utilitati(Integer.parseInt(id.getText()));

            }
        });

        transfer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contBll.transferaBani(Integer.parseInt(t1.getText()),Integer.parseInt(t2.getText()),Integer.parseInt(suma1.getText()));
            }
        });
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StartWindow start = new StartWindow();
                start.frame.setVisible(true);
            }

            });

                ViewAcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                List<Cont> list = contBll.getAll();
                model1.setRowCount(0);
                tp1 = new JTable(model1);
                for (Cont cont : list) {
                    model1.addRow(new Object[]{cont.getIdCont(),cont.getIdClient(),cont.getTip(),cont.getBani(),cont.getData()});

                    System.out.println(cont.toString());
                }


                final JFrame framee = new JFrame("Conturi");

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

        updateAcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                contBll.update(Integer.parseInt(idAcco.getText()),Integer.parseInt(sumaAcco.getText()),Integer.parseInt(tipAcco.getText()),dataAcco.getText());

            }
        });
        deleteAcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                contBll.deleteCont(Integer.parseInt(idAcco.getText()));
                JOptionPane.showMessageDialog(null,"Success");
            }
        });

        createAcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                contBll.insertCont(Integer.parseInt(idAcco.getText()),Integer.parseInt(idClientAcco.getText()),Integer.parseInt(tipAcco.getText()),Integer.parseInt(sumaAcco.getText()),dataAcco.getText());
                JOptionPane.showMessageDialog(null,"Success");

            }
        });
        insertClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {




                c.insertClient(Integer.parseInt(id.getText()), nume.getText(), serie.getText(), cnp.getText(), adresa.getText(), telefon.getText());
                JOptionPane.showMessageDialog(null,"Success");


            }

        });

        updateClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {



                c.update(Integer.parseInt(id.getText()), nume.getText(), serie.getText(), cnp.getText(), adresa.getText(), telefon.getText());
                JOptionPane.showMessageDialog(null,"Success");

            }

        });

        model.addColumn("idClient");
        model.addColumn("Nume");
        model.addColumn("Serie");
        model.addColumn("CNP");
        model.addColumn("Adresa");
        model.addColumn("Telefon");


        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                List<Client> list = c.getALL();
                model.setRowCount(0);
                tp = new JTable(model);
                for (Client client : list) {
                    model.addRow(new Object[]{client.getIdClient(), client.getNume(), client.getSerie(), client.getCnp(), client.getAdresa(), client.getTelefon()});

                    System.out.println(client.toString());
                }


                final JFrame framee = new JFrame("Clienti");

                framee.setSize(500, 700);
                JPanel p = new JPanel();
                p.setBackground(Color.CYAN);
                p.add(new JScrollPane(tp), BorderLayout.CENTER);
                p.setLayout(new FlowLayout());
                framee.setBackground(Color.CYAN);
                framee.setContentPane(p);
                framee.setVisible(true);


            }
        });


    }

}
