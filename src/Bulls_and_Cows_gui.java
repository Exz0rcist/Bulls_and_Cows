import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;

public class Bulls_and_Cows_gui {
    JFrame frame;
    game_creator gc = new game_creator();
    Player player1 = new Player();
    JTextField input_answer;
    JLabel last_try;
    JLabel debug;
    AI_enemy ai_enemy = new AI_enemy();

    public static void main(String[] args) {
        Bulls_and_Cows_gui gui = new Bulls_and_Cows_gui();
        gui.BuildGUI();
    }
    public void BuildGUI(){
        ai_enemy = new AI_enemy();
        ai_enemy.create_enemy_num();
        frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel text_panel = new JPanel();
        JPanel game_panel = new JPanel();
        JPanel Background_panel = new JPanel();
        Background_panel.setLayout(new BoxLayout(Background_panel, BoxLayout.Y_AXIS));

        // TODO: Add last try on a screen
        last_try = new JLabel("Последнее введенное число " + player1.getLast_try());
        debug = new JLabel("Debug");
        JLabel mission = new JLabel("Загадано число, угадай =Р");
        JLabel answer = new JLabel("Твой вариант: ");
        JLabel Bulls_on_screen = new JLabel("Быки: " + gc.getBulls());
        JLabel Cows_on_screen = new JLabel("Коровы : "+ gc.getCows());
        input_answer = new JTextField(10);
      //  panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton exit_button = new JButton("Выход");
        JButton chekout_button = new JButton("Попытка угадать");
        exit_button.addActionListener(new MyExitButtonListener());
        chekout_button.addActionListener(new MyChekoutButtonListener());

        frame.getContentPane().add(BorderLayout.NORTH,mission);
        frame.getContentPane().add(BorderLayout.SOUTH,panel);
        frame.getContentPane().add(BorderLayout.CENTER,Background_panel);


        Background_panel.add(text_panel);
        Background_panel.add(last_try);
        Background_panel.add(debug);
        Background_panel.add(Cows_on_screen);
        Background_panel.add(Bulls_on_screen);
        debug.setText(ai_enemy.getEnemy_num());

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

    public class MyChekoutButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent a) {
            last_try.setText(input_answer.getText());
            player1.validate_num(input_answer.getText());
            player1.n_try++;
            if (player1.isCorrect_num()){
                if (!ai_enemy.getEnemy_num().equals(player1.getPlayer_num())){
                    for (int i = 0; i < ai_enemy.getEnemy_num().length(); i++) {
                        for (int j = 0; j < player1.getPlayer_num().length(); j++) {
                            if(ai_enemy.getEnemy_num().charAt(i) == player1.getPlayer_num().charAt(j))
                                if(i == j) gc.Bulls++;
                                else gc.Cows++;
                        }
                    }
                }
            }

        }
    }
}
