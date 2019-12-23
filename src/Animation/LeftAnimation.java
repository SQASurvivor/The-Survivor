package Animation;

import Character.Survivor;
import Control.Gamemanager;
import javafx.animation.AnimationTimer;

public class LeftAnimation {

	private AnimationTimer Animation;
	
	/**
	 * Constructor
	 * @param survivor
	 * @param gamemanager game manager
	 * @param obstacles the set of obstacles
	 */
	public LeftAnimation(Survivor survivor, Gamemanager gamemanager){
		Animation = createAnimation(survivor, gamemanager);
	}
	

	private AnimationTimer createAnimation(Survivor survivor, Gamemanager gamemanager) {
		 double step = 5;
		 
		 return new AnimationTimer() {
	       	public void handle(long currentNanoTime)
	       	{
	       		if(survivor.getX() - step > 0) {
	       			survivor.setX(survivor.getX() - step);
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
