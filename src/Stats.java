/**
 * Created by mouldaid000 on 2/23/2017.
 */
public class Stats {
    static boolean menu = false, play = true, pause = false, end = false;



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

}
