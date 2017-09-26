import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame{
    private Button btnAdd = new Button("Add");
    private Button btnExit = new Button("EXIT");
    private Button btnC = new Button("Change");
    private Button btn0 = new Button("Return");
    private Label lab = new Label("－ω－");
    private int count = 0,labX = 200,labY = 150;
    private int fc_r = 100;
    private int fc_g = 120;
    private Color c = new Color(fc_r,fc_g,250);
    private Timer t1;
    private boolean b = true;

    public MainFrame(){

        initComp();
    }
    private void initComp(){
        this.setBounds(100,100,450,400);
        lab.setBounds(labX,labY,50,100);
        btnAdd.setBounds(30,300,100,30);
        btnC.setBounds(150,300,100,30);
        btn0.setBounds(270,300,100,30);
        btnExit.setBounds(360,370,75,20);
        lab.setBackground(c);
        this.setLayout(null);
        this.add(btnAdd);
        this.add(btnExit);
        this.add(btnC);
        this.add(btn0);
        this.add(lab);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                MainFrame.this.setTitle(Integer.toString(count));
                t1.start();
            }
        });
        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.setTitle("ヽ(∀ﾟ)人(ﾟ∀ﾟ)人( ﾟ∀)人(∀ﾟ)人(ﾟ∀ﾟ)人( ﾟ∀)ﾉ");
            }
        });
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count = 0;
                MainFrame.this.setTitle(Integer.toString(count));
                lab.setText("－ω－");
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        t1 = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(labX < 400 && b){
                    labX += 10;
                    fc_r += 5;
                    fc_g += 5;
                    if(labX == 400){
                        b = false;
                    }
                    c = new Color(fc_r,fc_g,250);
                    lab.setBackground(c);
                    lab.setLocation(labX,labY);
                }else {
                    labX -= 10;
                    fc_r -= 5;
                    fc_g -= 5;
                    if(labX == 0){
                        b = true;
                    }
                    c = new Color(fc_r,fc_g,250);
                    lab.setBackground(c);
                    lab.setLocation(labX,labY);
                }
            }
        });
    }
}
