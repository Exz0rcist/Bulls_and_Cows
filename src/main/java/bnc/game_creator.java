package bnc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by diman on 28.05.17.
 */
public class game_creator {
    public byte Bulls = 0;
    public byte Cows = 0;



    public byte getBulls() {
        return Bulls;
    }

    public byte getCows() {
        return Cows;
    }

    public void start_game(Player player, AI_enemy ai_enemy) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(!player.isWinner()) {
            while (!player.isCorrect_num()) {
                player.validate_num(reader.readLine());
            }
            if (!ai_enemy.getEnemy_num().equals(player.getPlayer_num())){
                for (int i = 0; i < ai_enemy.getEnemy_num().length(); i++) {
                for (int j = 0; j < player.getPlayer_num().length(); j++) {
                    if(ai_enemy.getEnemy_num().charAt(i) == player.getPlayer_num().charAt(j))
                        if(i == j) Bulls++;
                    else Cows++;
                }
                }
            }
            else player.setWinner(true);
            player.n_try++;
            player.setCorrect_num(false);
            if(!player.isWinner()){
                System.out.println("Ты угадал "+ Bulls + " быков и " + Cows + " коров" );
                Bulls = 0;
                Cows = 0;
            }
        }
        System.out.println("Ай да ты! Ай да молодца! Угадал таки за " + player.n_try + " попыткав!");
    }
}
