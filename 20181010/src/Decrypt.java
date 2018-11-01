import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class Decrypt extends JFrame {
    private   Container cp;
    private JTextArea jtaR = new JTextArea("",30,15);
    private JTextArea jtaL = new JTextArea("",30,15);
    private JScrollPane jspR = new JScrollPane(jtaR);
    private JScrollPane jspL = new JScrollPane(jtaL);
    private JPanel jpnC = new JPanel(new GridLayout(9,1,5,5));
    private JPanel jpnR = new JPanel(new GridLayout(1,1,5,5));
    private JPanel jpnL = new JPanel(new GridLayout(1,1,5,5));
    private JLabel jlb = new JLabel("Method");
    private String methodStr [] = {"DES","AES", "XOR","Caesar"};
    private JComboBox jcb = new JComboBox<String>(methodStr);
    private JLabel jlbpw = new JLabel("PassWord");
    private JTextField jtf = new JTextField();
    private JRadioButton jrb1 = new JRadioButton("Encrypt");
    private JRadioButton jrb2 = new JRadioButton("Decrypt");
    private JButton jbtRN = new JButton("Run");
    private JButton jbtCL = new JButton("Close");
    private JButton jbtclear = new JButton("Clear");
    private ButtonGroup buttonGroup = new ButtonGroup();
    private  JMenuBar jmb = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenu about = new JMenu("About");
    private JMenuItem open = new JMenuItem("open");
    private JMenuItem close = new JMenuItem("close");
    private JMenuItem save = new JMenuItem("save");
    private JMenuItem exit = new JMenuItem("exit");
    private  Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private  int screew = screen.width,screeh = screen.height;
   private int frmw=300,frmh = 120;
   JFileChooser jfc  = new JFileChooser();

    //    private String a;
//    private char [] b = new char[a.length()];
//    private int key, n;
    MainFrame3 frm5;
    public Decrypt(MainFrame3 frm6){
        frm5 = frm6;
        ex1();
    }private void ex1(){
//        this.setBounds(100
// ,100,560,400);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setBounds(screew /2-frmw /2,screeh/2-frmh/2, frmw,frmh);

        this.setJMenuBar(jmb);
        jmb.add(file);
        jmb.add(about);
        file.add(open);
        file.add(close);
        file.add(save);
        file.add(exit);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frm5.setVisible(true);
            }
        });
        cp = this.getContentPane();
        cp.add(jpnL, BorderLayout.WEST);
        cp.add(jpnC, BorderLayout.CENTER);
        cp.add(jpnR, BorderLayout.EAST);
        jpnL.add(jspL);
        jpnR.add(jspR);
        jpnC.add(jlb);
        jpnC.add(jcb);
        jpnC.add(jlbpw);
        jpnC.add(jtf);
        jpnC.add(jrb1);
        jpnC.add(jrb2);
        jpnC.add(jbtRN);
        jpnC.add(jbtCL);
        jpnC.add(jbtclear);
        buttonGroup.add(jrb1);
        buttonGroup.add(jrb2);
        jbtRN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //    int key = Integer.parseInt(jtf.getText());
                if(jrb1.isSelected()){
                    int datalength = jtaL.getText().length();
                    if(datalength>0){
                        switch (jcb.getSelectedIndex()){
                            case 0:
                                JOptionPane.showMessageDialog(Decrypt.this,"sorry"+jcb.getSelectedItem()+"not");
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                char dataa[] = jtaL.getText().toCharArray();
                                char keyss[] = jtf.getText().toCharArray();
                                for(int i = 0 ;i<dataa.length;i++) {
                                dataa[i] = (char) ((int)dataa[i] ^(int)keyss[i%keyss.length]);
                                }
                                jtaL.setText(new String(dataa));

                                break;
                            case 4:
                                char data[] =jtaL.getText().toCharArray();
                                int key = Integer.parseInt(jtf.getText());
                                try {
                                    for (int i = 0; i < datalength; i++) {
                                        data[i] = (char) (data[i] + key);
                                    }


                                }catch (NumberFormatException exp) {
                                    break;
                                }
                        }

                    }
                }
            }
        });
        jbtCL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame3 frm2 = new MainFrame3();
                frm2.setVisible(true);
                Decrypt.this.dispose();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(file);
//                File f = chooser.getSelectedFile();
//
//                jtaR.setText(f.getAbsolutePath());
//                jtaR.setText(f.getName());
            }
        });
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(jfc.showOpenDialog(Decrypt.this)==JFileChooser.APPROVE_OPTION) {
                        jtaL.setText("");
                        String str = "";
                        File select = jfc.getSelectedFile();
                        FileReader fr = new FileReader(select);
                        BufferedReader br = new BufferedReader(fr);
                        while ((str = br.readLine())!=null){
                            jtaL.append(str);


                    }
                        fr.close();
                    }

                }catch (IOException ie){
                    JOptionPane.showMessageDialog(Decrypt.this,"no");
                }
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    jfc.setFileFilter(new FileNameExtensionFilter(".txt.doc","txt","doc"));
                    if(jtaR.getText().length()>0){
                    if(jfc.showSaveDialog(Decrypt.this) ==JFileChooser.APPROVE_OPTION) {
                        File select1 = new File(jfc.getSelectedFile().getPath() + jfc.getSelectedFile().getName() + ".txt");
                        FileWriter fileWriter = new FileWriter(select1);
                        BufferedWriter Buffer = new BufferedWriter(fileWriter);
                        Buffer.write(jtaR.getText());
                        Buffer.close();


                    }
                    }
                }catch (IOException ie){
                    JOptionPane.showMessageDialog(Decrypt.this,"open"+ie.toString());

                }

            }
        });
    }
}