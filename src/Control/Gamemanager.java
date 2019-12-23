package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.Timer;
import Animation.DownAnimation;
import Animation.LeftAnimation;
import Animation.RightAnimation;
import Animation.UpAnimation;
import Character.Enemy;
import Character.Survivor;
import Check.CheckTouching;
import Stage.HighScore;
import Scene.Background;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;

public class Gamemanager {
	private Group root;
	private Background background;
	private Survivor survivor;
	private Enemy enemy;
	private AnimationTimer leftAnimation;
    private AnimationTimer rightAnimation;
    private AnimationTimer upAnimation;
    private AnimationTimer downAnimation;
    private HighScore showScore;
    private int time_int;
    private int delay;
    private ActionListener task;
    private Timer timer;
    private boolean gameEnd;
	
	public Gamemanager(Group root) {
		this.root = root;
		this.background = new Background();
		background.createBackground(root);
		this.survivor = background.getSurvivor();
		this.enemy = background.getEnemy();
		this.leftAnimation = new LeftAnimation(this.survivor, this).getAnimation();
        this.rightAnimation = new RightAnimation(this.survivor, this).getAnimation();
        this.upAnimation = new UpAnimation(this.survivor, this).getAnimation();
        this.downAnimation = new DownAnimation(this.survivor, this).getAnimation();
        this.showScore = new HighScore();
        this.gameEnd = false;
        this.time_int = 0;
        this.delay = 1000;
        this.task = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				time_int++;
				background.getTime().setText(String.valueOf(time_int));
			}
        };
        this.timer = new Timer(delay, task);
	}
	
	public void moveSurvivor(KeyEvent event) {
        enemy.run();
        timer.start();
        
        switch(event.getCode()) {
            case RIGHT:
                this.rightAnimation.start();
                break;
            case LEFT:
                this.leftAnimation.start();
                break;
            case UP:
                this.upAnimation.start();
                break;
            case DOWN:
                this.downAnimation.start();
                break;
		default:
			break;
        }
    }


    public void stopSurvivor(KeyEvent event) {   	
        switch(event.getCode()) {
            case RIGHT:
                this.rightAnimation.stop();
                break;
            case LEFT:
                this.leftAnimation.stop();
                break;
            case UP:
                this.upAnimation.stop();
                break;
            case DOWN:
                this.downAnimation.stop();
                break;
            default:
            	break;
        }
    }
    
    private void endGame() {
    	gameEnd = true;
        root.getChildren().remove(enemy);
        root.getChildren().remove(survivor);
        timer.stop();

        try {
        	writeScore(this.time_int);	
        } catch (IOException e) {
        	System.out.println("Write error!");
        }         
        try {
        	
			showScore.switchwin();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private void writeScore(int i) throws IOException {
	   	FileWriter fw = new FileWriter("Score.txt", true);
	   	String Scorestr = Integer.toString(i);
   		fw.write(Scorestr);
   		fw.write(" ");
   		fw.close();
   }
    
    public void CheckOut() {
    	CheckTouching ch = new CheckTouching(this.survivor, this.enemy);
    	if(ch.isTouching()) {
    		if(gameEnd == false) {
    			endGame();
    		}
    	}
    }
}
