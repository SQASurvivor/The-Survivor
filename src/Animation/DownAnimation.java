package Animation;

import Character.Survivor;
import Control.Gamemanager;
import javafx.animation.AnimationTimer;

public class DownAnimation {
	private AnimationTimer Animation;


	/**
	 * @param survivor
	 * @param gamemanager
	 * @param obstacles
	 */
	public DownAnimation(Survivor survivor, Gamemanager gamemanager){
		Animation = createAnimation(survivor, gamemanager);
	}
	
	
	private AnimationTimer createAnimation(Survivor survivor, Gamemanager gamemanager) {
		 double step = 5;
		 
		 return new AnimationTimer() {
        	public void handle(long currentNanoTime)
        	{
        		if(survivor.getY() + step < 495) {
        			survivor.setY(survivor.getY() + step);
        		}
        		gamemanager.CheckOut();
        	}
        };
	}
	
	/**
	 * getter
	 * @return the created animation
	 */
	public AnimationTimer getAnimation() {
		return Animation;
	}
}
