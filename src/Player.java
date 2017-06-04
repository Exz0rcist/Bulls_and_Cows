import com.sun.security.jgss.InquireSecContextPermission;

public class Player {
    public int n_try = 0;
    private String player_num = "";
    private boolean correct_num = false;
    private boolean winner = false;
    private String last_try = "";

    public void setLast_try(String last_try) {
        this.last_try = last_try;
    }

    public String getLast_try() {
        return last_try;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean isWinner() {
        return winner;
    }

    public boolean isCorrect_num() {
        return correct_num;
    }

    public void setCorrect_num(boolean correct_num) {
        this.correct_num = correct_num;
    }

    public void setPlayer_num(String player_num) {
        this.player_num = player_num;
    }

    public int getN_try() {
        return n_try;
    }

    public String getPlayer_num() {
        return player_num;
    }

    public void validate_num(String num){
        try{
            if (num.length()==4) {
                this.setCorrect_num(true);
                this.setPlayer_num(num);
            }
            else System.out.println("Ну я же просил четырёхзначное же =(");
        }
        catch (Exception e)
        {
            System.out.println("Нужно ввести число. Попробуй еще раз =Р");
        }
    }
}
