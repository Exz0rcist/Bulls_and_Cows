import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    JFrame new_game_screen;
    JPanel nss;
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.StartScreen();
/*        Player player = new Player();
        AI_enemy ai_enemy = new AI_enemy();
        ai_enemy.create_enemy_num();

        System.out.println("Приветствую в игре Быки и Коровы.\nПусть игра и известна, но лишний раз напомнить правила стоит.\nМною " +
                "загадано четырёхзначное число" +
                "и ваша задача за меньшее число попыток угадать, какое число я загадал.\nЧтобы облегчить задачу, в игре есть для вас подсказки:\n" +
                "1. Быки - это количество цифр, значение и положение которых совпадает с загаданным мною числом.\n" +
                "2. Коровы - количество цифр, которые присутствуют в загаданном числе, но не совпадают по месту расположения.\n" +
                "Надеюсь вам понравится!\nИтак начнём. Я загадал число, попробуй угадать какое ;Р");

        game_creator game = new game_creator();
        game.start_game(player, ai_enemy);*/
    }

    public void StartScreen(){
        new_game_screen = new JFrame();
        nss = new JPanel();
        JButton new_game_button = new JButton("Начать новую игру");
        new_game_button.addActionListener(new newGameButton());
        JButton exit_button = new JButton("Выход");
        exit_button.addActionListener(new ExtButton());
        new_game_screen.getContentPane().add(BorderLayout.NORTH, nss);
        nss.setLayout(new BoxLayout(nss,BoxLayout.Y_AXIS));
        new_game_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new_game_screen.setSize(200,200);
        new_game_screen.setVisible(true);
        nss.add(new_game_button);
        nss.add(exit_button);
    }

    public class ExtButton implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent){
            System.exit(0);
        }
    }
    public class newGameButton implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent){

        }
    }

}

