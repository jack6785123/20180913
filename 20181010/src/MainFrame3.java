import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame3 extends JFrame {
    private JMenuBar jbr = new JMenuBar();
    private JMenu jnu = new JMenu("file");
    private JMenu jnu1 = new JMenu("game");
    private JMenuItem jit = new JMenuItem("OPEN");
    private JMenuItem jit2 = new JMenuItem("EXIT");
    private JMenuItem jit3 = new JMenuItem("Decrypt");
    private JMenuItem jit4 = new JMenuItem("about");
    private JMenuItem OX = new JMenuItem("OX");
    private JMenuItem jiFileDecrypt = new JMenuItem("File-Decrypt");

    public MainFrame3() {
        inin();
    }

    public void inin() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(500, 500, 500, 500);
        this.setLayout(null);
        this.setJMenuBar(jbr);
        jbr.add(jnu);
        jbr.add(jnu1);
        jnu1.add(OX);
        jnu.add(jiFileDecrypt);
        jnu.add(jit2);
        jnu.add(jit3);
        jnu.add(jit);
        jnu.add(jit4);

        OX.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame4 mm = new MainFrame4(MainFrame3.this);
                mm.setVisible(true);
                MainFrame3.this.setVisible(false);
            }
        });
        jit3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Decrypt D = new Decrypt(MainFrame3.this);
                D.setVisible(true);
            }
        });
        jit2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jiFileDecrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDecrypt fid = new FileDecrypt(MainFrame3.this);
                fid.setVisible(true);
                MainFrame3.this.setVisible(false);


            }
        });
    }
}
