import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame4 extends JFrame{
    private Container cp;
    private JLabel jlb = new JLabel("game");
    private JPanel jpn = new JPanel(new GridLayout(3,3,3,3));
    private JButton jbtn1 = new JButton();
    private JButton jbtn2 = new JButton();
    private JButton jbtn3 = new JButton();
    private JButton jbtn4 = new JButton();
    private JButton jbtn5 = new JButton();
    private JButton jbtn6 = new JButton();
    private JButton jbtn7 = new JButton();
    private JButton jbtn8 = new JButton();
    private JButton jbtn9 = new JButton();
    private int x = 0;
    MainFrame3 ad;
    public MainFrame4(MainFrame3 af){
        ad= af;
        init();
    }
    public void init(){
        this.setBounds(100,100,500,300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                ad.setVisible(true);
            }
        });
        this.setLayout(null);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        jlb.setOpaque(true);
        jlb.setBackground(new Color(84, 13, 47));
        jlb.setFont(new Font(null,Font.BOLD,24));
        jbtn1.setFont(new Font(null,Font.BOLD,32));
        jbtn2.setFont(new Font(null,Font.BOLD,32));
        jbtn3.setFont(new Font(null,Font.BOLD,32));
        jbtn4.setFont(new Font(null,Font.BOLD,32));
        jbtn5.setFont(new Font(null,Font.BOLD,32));
        jbtn6.setFont(new Font(null,Font.BOLD,32));
        jbtn7.setFont(new Font(null,Font.BOLD,32));
        jbtn8.setFont(new Font(null,Font.BOLD,32));
        jbtn9.setFont(new Font(null,Font.BOLD,32));
        cp.add(jlb,BorderLayout.NORTH);
        cp.add(jpn,BorderLayout.CENTER);
        jpn.add(jbtn1);
        jpn.add(jbtn2);
        jpn.add(jbtn3);
        jpn.add(jbtn4);
        jpn.add(jbtn5);
        jpn.add(jbtn6);
        jpn.add(jbtn7);
        jpn.add(jbtn8);
        jpn.add(jbtn9);
        jbtn1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmp = (JButton) e.getSource();
                if (x % 2 == 0){
                    tmp.setText("O");
                }else {
                    tmp.setText("x");
                }
                jbtn1.setEnabled(false);
                x++;
                main();
            }
        });
        jbtn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmp = (JButton) e.getSource();
                if (x % 2 == 0){
                    tmp.setText("O");
                }else {
                    tmp.setText("x");
                }
                jbtn2.setEnabled(false);
                x++;
                main();
            }
        });
        jbtn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmp = (JButton) e.getSource();
                if (x % 2 == 0){
                    tmp.setText("O");
                }else {
                    tmp.setText("x");
                }
                jbtn3.setEnabled(false);
                x++;
                main();
            }
        });
        jbtn4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmp = (JButton) e.getSource();
                if (x % 2 == 0){
                    tmp.setText("O");
                }else {
                    tmp.setText("x");
                }
                jbtn4.setEnabled(false);
                x++;
                main();
            }
        });
        jbtn5.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmp = (JButton) e.getSource();
                if (x % 2 == 0){
                    tmp.setText("O");
                }else {
                    tmp.setText("x");
                }
                jbtn5.setEnabled(false);
                x++;
                main();
            }
        });
        jbtn6.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmp = (JButton) e.getSource();
                if (x % 2 == 0){
                    tmp.setText("O");
                }else {
                    tmp.setText("x");
                }
                jbtn6.setEnabled(false);
                x++;
                main();
            }
        });
        jbtn7.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmp = (JButton) e.getSource();
                if (x % 2 == 0){
                    tmp.setText("O");
                }else {
                    tmp.setText("x");
                }
                jbtn7.setEnabled(false);
                x++;
                main();
            }
        });
        jbtn8.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmp = (JButton) e.getSource();
                if (x % 2 == 0){
                    tmp.setText("O");
                }else {
                    tmp.setText("x");
                }
                jbtn8.setEnabled(false);
                x++;
                main();
            }
        });
        jbtn9.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmp = (JButton) e.getSource();
                if (x % 2 == 0){
                    tmp.setText("O");
                }else {
                    tmp.setText("x");
                }
                jbtn9.setEnabled(false);
                x++;
                main();
            }
        });
    }
    public void main(){
        if (jbtn1.getText().equals(jbtn2.getText()) && jbtn2.getText().equals(jbtn3.getText()) && !jbtn1.getText().equals("")){
            if (jbtn1.getText().equals("o")){
                jlb.setText("player1 win~");
            }else {
                jlb.setText("player2 win~");
            }
        }
        if (jbtn4.getText().equals(jbtn5.getText()) && jbtn5.getText().equals(jbtn6.getText()) && !jbtn4.getText().equals("")){
            if (jbtn4.getText().equals("o")){
                jlb.setText("player1 win~");
            }else {
                jlb.setText("player2 win~");
            }
        }
        if (jbtn7.getText().equals(jbtn8.getText()) && jbtn8.getText().equals(jbtn9.getText()) && !jbtn7.getText().equals("")){
            if (jbtn7.getText().equals("o")){
                jlb.setText("player1 win~");
            }else {
                jlb.setText("player2 win~");
            }
        }
        if (jbtn1.getText().equals(jbtn4.getText()) && jbtn4.getText().equals(jbtn7.getText()) && !jbtn1.getText().equals("")){
            if (jbtn1.getText().equals("o")){
                jlb.setText("player1 win~");
            }else {
                jlb.setText("player2 win~");
            }
        }
        if (jbtn2.getText().equals(jbtn5.getText()) && jbtn5.getText().equals(jbtn8.getText()) && !jbtn2.getText().equals("")){
            if (jbtn2.getText().equals("o")){
                jlb.setText("player1 win~");
            }else {
                jlb.setText("player2 win~");
            }
        }
        if (jbtn3.getText().equals(jbtn6.getText()) && jbtn6.getText().equals(jbtn9.getText()) && !jbtn3.getText().equals("")){
            if (jbtn3.getText().equals("o")){
                jlb.setText("player1 win~");
            }else {
                jlb.setText("player2 win~");
            }
        }
        if (jbtn1.getText().equals(jbtn5.getText()) && jbtn5.getText().equals(jbtn9.getText()) && !jbtn1.getText().equals("")){
            if (jbtn1.getText().equals("o")){
                jlb.setText("player1 win~");
            }else {
                jlb.setText("player2 win~");
            }
        }
        if (jbtn3.getText().equals(jbtn5.getText()) && jbtn5.getText().equals(jbtn7.getText()) && !jbtn3.getText().equals("")){
            if (jbtn3.getText().equals("o")){
                jlb.setText("player1 win~");
            }else {
                jlb.setText("player2 win~");
            }
        }
    }
}