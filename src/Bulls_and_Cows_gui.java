import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;

public class Bulls_and_Cows_gui {
    JFrame frame;

    public static void main(String[] args) {
        Bulls_and_Cows_gui gui = new Bulls_and_Cows_gui();
        gui.BuildGUI();
    }
    public void BuildGUI(){
        frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel text_panel = new JPanel();
        JLabel mission = new JLabel("Загадано число, угадай =Р");
        JLabel answer = new JLabel("Твой вариант: ");
        JTextField input_answer = new JTextField(10);
      //  panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //  frame.getContentPane().add(BorderLayout.CENTER, panel);
       // JTextArea text = new JTextArea(10,20);
       // JScrollPane scroller = new JScrollPane(text);
       // scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      //  scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
      //  text.setLineWrap(true);
        JButton exit_button = new JButton("Выход");
        JButton chekout_button = new JButton("Попытка угадать");
        frame.getContentPane().add(BorderLayout.NORTH,mission);
        frame.getContentPane().add(BorderLayout.SOUTH,panel);
        frame.getContentPane().add(BorderLayout.CENTER,text_panel);

      //  frame.getContentPane().add(BorderLayout.SOUTH, chekout_button);
      //  frame.getContentPane().add(BorderLayout.SOUTH, exit_button);

        panel.add(chekout_button);
        panel.add(exit_button);
        text_panel.add(answer);
        text_panel.add(input_answer);

        frame.setSize(400,200);
        frame.setVisible(true);

    }
    public class MyExitButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
        }
    }
}
