import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tester on 13.06.17.
 */
public class Winner_Window {
    JFrame WinnerWindow;
    JPanel panel1;
    JLabel WinnerLable;
    public void StartScreen(){
        WinnerWindow = new JFrame();
        panel1 = new JPanel();
        JButton OK_button = new JButton("Ура!");
        OK_button.addActionListener(new OKButtonListener());
        WinnerLable = new JLabel("");

        WinnerWindow.getContentPane().add(BorderLayout.NORTH, panel1);
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        WinnerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.add(WinnerLable);

        WinnerWindow.setSize(200,200);
        WinnerWindow.setVisible(true);
        panel1.add(WinnerWindow);
        WinnerWindow.getContentPane().add(BorderLayout.SOUTH,OK_button);
    }

    public class OKButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent){
            System.exit(0);
        }
    }
}
