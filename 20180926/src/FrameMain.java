import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class FrameMain extends JFrame{
    private Container cp;
    private JPanel jpnc = new JPanel(new GridLayout(4,3,2,2));
    private JPanel jpnn = new JPanel();
    private JLabel jlb = new JLabel("0");
    private JButton jbtn[] = new JButton[12];
    private String st[] = new String[10];
    FrameMain2 af;
    public FrameMain (FrameMain2 ad){
        af = ad;
        init();
    }
    public void init() {
        this.setBounds(500, 100, 500, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(jpnc, BorderLayout.CENTER);
        cp.add(jpnn, BorderLayout.NORTH);
        jpnn.add(jlb);




        Main(st);
        for (int i = 0; i < 10; i++) {
            jbtn[i] = new JButton();
            jpnc.add(jbtn[i]);
            jbtn[i].setText(st[i]);
            jbtn[i].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmp = (JButton) e.getSource();
                    jlb.setText(jlb.getText() + tmp.getText());


                }
            });
        }

        jbtn[10] = new JButton("re");
        jbtn[11] = new JButton("傳");
        jpnc.add(jbtn[10]);
        jpnc.add(jbtn[11]);



        jbtn[10].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main(st);
                for (int i = 0; i < 10; i++){
                    jbtn[i].setText(st[i]);
                }
            }
        });


        jbtn[11].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                af.setpass(jlb.getText());
            }
        });

    }

    public void  Main (String  arg[]){
        int i = 0 ;
        Random rad = new Random(System.currentTimeMillis());
        while (i <10){
            arg[i] = Integer.toString(rad.nextInt(10));
            int j = 0;
            boolean falg = false;
            while (j<i){
                if (arg[i].equals(arg[j])){
                    falg = true;
                    j=i;
                }
                j++;
            }
            if (!falg){
                i++;
            }
        }
    }
}