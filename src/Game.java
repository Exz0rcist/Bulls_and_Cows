import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public static void main(String[] args) throws IOException {
        Player player = new Player();
        AI_enemy ai_enemy = new AI_enemy();
        ai_enemy.create_enemy_num();

        System.out.println("Приветствую в игре Быки и Коровы.\nПусть игра и известна, но лишний раз напомнить правила стоит.\nМною " +
                "загадано четырёхзначное число" +
                "и ваша задача за меньшее число попыток угадать, какое число я загадал.\nЧтобы облегчить задачу, в игре есть для вас подсказки:\n" +
                "1. Быки - это количество цифр, значение и положение которых совпадает с загаданным мною числом.\n" +
                "2. Коровы - количество цифр, которые присутствуют в загаданном числе, но не совпадают по месту расположения.\n" +
                "Надеюсь вам понравится!\nИтак начнём. Я загадал число, попробуй угадать какое ;Р");

        game_creator game = new game_creator();
        game.start_game(player, ai_enemy);
    }
}

