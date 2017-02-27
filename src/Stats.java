/**
 * Created by mouldaid000 on 2/23/2017.
 */
public class Stats {
    static boolean menu = true, play = false, pause = false, end = false, invincible = false;
    static int lives = 3, score = 0, health = 2, invulnerabilityTimer = 0;



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
    public static boolean isInvincible(){return (invulnerabilityTimer > 0);}
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
        if(isMenu() ^ isEnd()){
            menu = false;
            play = true;
            end = false;
            invulnerabilityTimer = 0;

            resetHealth();
            resetLives();
            resetScore();
        }
    }

    public static int getHealth(){return health;}
    public static void resetHealth(){
            health = 2;
}

public static void resetInvulnTimer(){
        invulnerabilityTimer = 120;
}

public static void resetScore(){
    score = 0;
}

public static void decrementInvulnTimer(){
    invulnerabilityTimer--;
}

public static void resetLives(){
    lives = 3;
}


    public static void removeLife(){
        lives -= 1;
    }
    public static void addLife(){
        lives += 1;
    }
    public static int getLives(){return lives;}
    public static void addScore(){
        score += 250;
    }
    public static int getScore(){
        return score;
    }
}
