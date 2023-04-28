package zork.Garbage;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//We are importing all the functions

public class OwenVersion1GUI implements ActionListener{

    private int count1 = 0;
    private int count2 = 0;
    private int count3 = 0;
    private int count4 = 0;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JFrame frame;
    private JPanel panel;
    // It is good practice to implement these before OMCH

    public OwenVersion1GUI() {
        frame = new JFrame();
        panel = new JPanel();

        JButton button1 = new JButton("Add Intellect");
        JButton button2 = new JButton("Add Psyche");
        JButton button3 = new JButton("Add Physique");
        JButton button4 = new JButton("Add Motorics");
        JButton buttonv1 = new JButton("Minus Intellect");
        JButton buttonv2 = new JButton("Minus Psyche");
        JButton buttonv3 = new JButton("Minus Physique");
        JButton buttonv4 = new JButton("Minus Motorics");
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        buttonv1.addActionListener(this);
        buttonv2.addActionListener(this);
        buttonv3.addActionListener(this);
        buttonv4.addActionListener(this);
        label1 = new JLabel("Intellect : 0");
        label2 = new JLabel("Psyche : 0");
        label3 = new JLabel("Physique : 0");
        label4 = new JLabel("Motorics : 0");

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(buttonv1);
        panel.add(buttonv2);
        panel.add(buttonv3);
        panel.add(buttonv4);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);

        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Attributes");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new OwenVersion1GUI();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("Add Intellect")) {
            count1++;
        }
        if (e.getActionCommand().equals("Add Psyche")) {
            count2++;
        }
        if (e.getActionCommand().equals("Add Physique")) {
            count3++;
        }
        if (e.getActionCommand().equals("Add Motorics")) {
            count4++;
        }
        if (e.getActionCommand().equals("Minus Intellect")) {
            count1--;
        }
        if (e.getActionCommand().equals("Minus Psyche")) {
            count2--;
        }
        if (e.getActionCommand().equals("Minus Physique")) {
            count3--;
        }
        if (e.getActionCommand().equals("Minus Motorics")) {
            count4--;
        }
        label1.setText("Intellect : " + count1);
        label2.setText("Psyche : " + count2);
        label3.setText("Physique : " + count3);
        label4.setText("Motorics : " + count4);
    }
}
