/**
 * Created by mouldaid000 on 2/23/2017.
 */
public class Stats {
    static boolean menu = true, play = false, pause = false, end = false;
    static int lives = 3, score = 0, health = 2;



    public static boolean isPlay(){
       return play;
    }
    public static boolean isMenu(){
        return menu;
    }
    public static boolean isPause(){
        return pause;
    }
    public static boolean isEnd(){
        return end;
    }
    public static void endGame(){
        menu = false;
        play = false;
        pause = false;
        end = true;
    }
    public static void togglePause(){
        if(isPlay()){
            play = false;
            pause = true;

        }
        else{
            pause = false;
            play = true;

        }

    }
    public static void startPlay(){
        if(isMenu()){
            menu = false;
            play = true;
        }
    }
    public static void removeLife(){
        lives -= 1;
    }
    public static void addLife(){
        lives += 1;
    }
    public static void addScore(){
        score += 250;
    }
}
