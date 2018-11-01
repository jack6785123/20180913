import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class FileDecrypt extends JFrame {
    Container cp;
    private JPanel jpnN = new JPanel(new GridLayout(1, 6, 3, 3));
    private JPanel jpnW = new JPanel(new GridLayout(2, 1, 3, 3));
    private JPanel jpnC = new JPanel(new GridLayout(2, 1, 3, 3));
    private JPanel jpnE = new JPanel(new GridLayout(2, 1, 3, 3));
    private JLabel jlb = new JLabel("加密法");
    private String methodStr[] = {"DES", "AES", "Caesar", "XOR"};
    private JComboBox jcb = new JComboBox<String>(methodStr);
    private JLabel jlbkey = new JLabel("KEY");
    private JButton jbtnRN = new JButton("RUN");
    private JButton jbtnClose = new JButton("Close");
    private JLabel jlbO = new JLabel("原始檔");
    private JLabel jlbS = new JLabel("加密檔");
    private JTextField jftkey = new JTextField("");
    private JTextField jftO = new JTextField("");
    private JTextField jftS = new JTextField("");
    private JButton jbtnadd = new JButton("選擇檔案");
    private JButton jbtnup = new JButton("上傳檔案");
    private JProgressBar jpb = new JProgressBar();          //輸出條
    private JFileChooser jfc = new JFileChooser();
    private String loodfile;
    MainFrame3 frm7;

    public FileDecrypt(MainFrame3 frm8) {
        frm7 = frm8;
        ex1();
    }

    private void ex1() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100, 100, 500, 150);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frm7.setVisible(true);
            }
        });
        cp = this.getContentPane();
        cp.add(jpnN, BorderLayout.NORTH);
        cp.add(jpnW, BorderLayout.WEST);
        cp.add(jpnC, BorderLayout.CENTER);
        cp.add(jpnE, BorderLayout.EAST);
        cp.add(jpb, BorderLayout.SOUTH);
        jpnN.add(jlb);
        jpnN.add(jcb);
        jpnN.add(jlbkey);
        jpnN.add(jftkey);
        jpnN.add(jbtnRN);
        jpnN.add(jbtnClose);
        jpnW.add(jlbO);
        jpnW.add(jlbS);
        jpnC.add(jftO);
        jpnC.add(jftS);
        jpnE.add(jbtnadd);
        jpnE.add(jbtnup);
        jbtnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jbtnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(jbtnadd);
            }
        });
        jbtnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jfc.showOpenDialog(FileDecrypt.this) == JFileChooser.APPROVE_OPTION) {
    //               loodfile = jfc.getSelectedFile().getPath() + jfc.getSelectedFile().getName();
                jftO.setText(jfc.getSelectedFile().getPath());
                jftS.setText(jftO.getText()+".sec");


                }
            }

        });
        jbtnRN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jbtnClose.getText().equals("")){
                    JOptionPane.showMessageDialog(FileDecrypt.this,"no file selected");
                }else {
                    try{
                        File selected = new File(jftO.getText());
                        long lengh = selected.length();
                        jpb.setMaximum(100);
                        char key[] = jftkey.getText().toCharArray();
                        FileReader fr = new FileReader(selected);
                        BufferedReader bf = new BufferedReader(fr);
                        File writeFile = new File(jftS.getText());
                        FileWriter fw = new FileWriter(writeFile);
                        BufferedWriter bw = new BufferedWriter(fw);
                        int data;
                        int i = 0;
                        while ((data = bf.read())!=-1){
                            data= data^key[i&key.length];
                            bw.write(data);
                            i++;
                            jpb.setValue(Math.round((float)i/lengh*100));
                            bf.close();
                            fr.close();
                            JOptionPane.showMessageDialog(FileDecrypt.this,"finish!");
                        }
                    }
                    catch (IOException ie){
                        JOptionPane.showMessageDialog(FileDecrypt.this,"no file");

                    }
                }
            }
        });
    }
    }



