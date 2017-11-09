package bnc;

import java.util.Date;
import java.util.Random;

public class AI_enemy {
    private String enemy_num = "1234";
    private boolean correct_num = false;


    public boolean isCorrect_num() {
        return correct_num;
    }

    public String getEnemy_num() {
        return enemy_num;
    }

    /**
     * Более короткий вариант метода create_enemy_num
     * @return случайное число с неповторяющимися цифрами
     */
    public static String getEnemyNum(){
        Random r = new Random(new Date().getTime());
        StringBuilder sb = new StringBuilder("");
        int nextRand;
        while (sb.length() < 4) {
            nextRand = r.nextInt(10);
            if (nextRand == 0 && sb.length() == 0) continue;
            if (sb.indexOf(String.valueOf(nextRand)) == -1) sb.append(nextRand);
        }
        return sb.toString();
    }

    public void create_enemy_num(){
        Random random = new Random(new Date().getTime());
        this.enemy_num = "";
        boolean check_num = true;
        String a = "";
        while (!this.correct_num){
            a = "" + random.nextInt(10);
            for (int i = 0; i < enemy_num.length(); i++) {
                if (a.charAt(0) == enemy_num.charAt(i)){
                    check_num = false;
                    break;
                }
                else check_num = true;
            }
            if (check_num){
                this.enemy_num = this.enemy_num + a;
                check_num = false;
                if (this.enemy_num.length() == 4)
                    setCorrect_num(true);
            }
        }

    }

    public void setCorrect_num(boolean correct_num) {
        this.correct_num = correct_num;
    }
}
