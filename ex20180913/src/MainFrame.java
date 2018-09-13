import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame {
    private  Button btexit = new Button("EXIT");
    private  Button bttt = new Button("minus");
    private Label la = new Label("LA");
    private int x = 0, y = 0;
 public MainFrame(){
     init();
 }
 private void init(){
    this.setBounds(100,100,500,500);
     this.setLayout(null);
     this.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });

     btexit.setBounds(50,50,100,100);
     bttt.setBounds(100,100,200,200);
     la.setBounds(20,20,50,50);
     add(btexit);
     add(bttt);
     add(la);
      btexit.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
           x = x+5;
           la.setLocation(x,y);
 //          MainFrame.this.setTitle(Integer.toString(x));
//           la.setText(Integer.toString(x));
              //              System.exit(0);
          }
      });
      bttt.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              x = x-5;
              la.setLocation(x,y);
//              MainFrame.this.setTitle(Integer.toString(x));
//              la.setText(Integer.toString(x));
          }
      });
      this.setTitle("fist java");
 }
    }



