import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;

public class Bulls_and_Cows_gui {
    JFrame frame;
    game_creator gc = new game_creator();
    Player player1 = new Player();

    public static void main(String[] args) {
        Bulls_and_Cows_gui gui = new Bulls_and_Cows_gui();
        AI_enemy ai_enemy = new AI_enemy();
        ai_enemy.create_enemy_num();
        gui.BuildGUI();
    }
    public void BuildGUI(){
        frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel text_panel = new JPanel();
        JPanel game_panel = new JPanel();
        JPanel Background_panel = new JPanel();
        Background_panel.setLayout(new BoxLayout(Background_panel, BoxLayout.Y_AXIS));

        // TODO: Add last try on a screen
        JLabel last_try = new JLabel("Last try " + player1.getLast_try());
        JLabel mission = new JLabel("Загадано число, угадай =Р");
        JLabel answer = new JLabel("Твой вариант: ");
        JLabel Bulls_on_screen = new JLabel("Быки: " + gc.getBulls());
        JLabel Cows_on_screen = new JLabel("Коровы : "+ gc.getCows());
        JTextField input_answer = new JTextField(10);
      //  panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton exit_button = new JButton("Выход");
        JButton chekout_button = new JButton("Попытка угадать");
        exit_button.addActionListener(new MyExitButtonListener());
        frame.getContentPane().add(BorderLayout.NORTH,mission);
        frame.getContentPane().add(BorderLayout.SOUTH,panel);
        frame.getContentPane().add(BorderLayout.CENTER,Background_panel);


        Background_panel.add(text_panel);
        Background_panel.add(Cows_on_screen);
        Background_panel.add(Bulls_on_screen);

        panel.add(chekout_button);
        panel.add(exit_button);
        text_panel.add(answer);
        text_panel.add(input_answer);


        frame.setSize(400,200);
        frame.setVisible(true);

    }
    public class MyExitButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            System.exit(0);
        }
    }
}
