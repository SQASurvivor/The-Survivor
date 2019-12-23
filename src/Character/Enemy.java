package Character;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Enemy extends Rectangle implements Runnable{
	AnimationTimer animation;
	String[] directions = {"left", "right", "up", "down"};
	int flag;
	int step;
	String direction;
	int timesWalked;
	
	public Enemy (double x, double y, double width, double height) {
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.timesWalked = 0;
		this.step = 5;
		this.direction = "down";
		this.setHeight(height);
		Image image = new Image("Character/monster.png");
		this.setFill(new ImagePattern(image));
		this.creatAnimation(this);
	}
	
	public AnimationTimer getAnimation() {
        return animation;
    }
	
	private String getRandomDirection(String exclude) {
        int rnd = new Random().nextInt(directions.length);
        while (directions[rnd].equals(exclude)) {
        	rnd = new Random().nextInt(directions.length);
        }
        return directions[rnd];
	}
	
	private void  creatAnimation(Enemy enemy) {
		this.animation = new AnimationTimer() {
			public void handle(long currentNanoTime) {
				timesWalked++;
				double CurrentX = getX();
				double CurrentY = getY();
				int walkAtLeast = 20;
				switch(direction) {
				case "left":
					moveChecking("left", flag, CurrentX, CurrentY);
					if (timesWalked > walkAtLeast) {
						direction = getRandomDirection("left");
						flag = new Random().nextInt(3);
						timesWalked = 0;
					}
					break;
				case "right":
					moveChecking("right", flag, CurrentX, CurrentY);
					if (timesWalked > walkAtLeast) {
						direction = getRandomDirection("right");
						flag = new Random().nextInt(3);
						timesWalked = 0;
					}
					break;
				case "up":
					moveChecking("up", flag, CurrentX, CurrentY);
					if (timesWalked > walkAtLeast) {
						direction = getRandomDirection("up");
						flag = new Random().nextInt(3);
						timesWalked = 0;
					}
					break;
				case "down":
					moveChecking("down", flag, CurrentX, CurrentY);
					if (timesWalked > walkAtLeast) {
						direction = getRandomDirection("down");
						flag = new Random().nextInt(3);
						timesWalked = 0;
					}
					break;
				}
			}
		};
	}
	
	private void moveChecking (String direction, int flag, double x, double y) {
		switch(direction) {
		case "left":
			if(x - step < 0) {
				setX(0);
				this.direction = "up";
				flag = new Random().nextInt(3);
			}
			else {
				setX(x - step);
				if(flag == 1) {
					if(y - step > 25) {
						setY(y - step);
					}
				}
				else if(flag == 2) {
					if (y + step < 495) {
						setY(y + step);
					}
				}
			}
			break;
		case "right":
			if(x + step > 920) {
				setX(920);
				this.direction = "down";
				flag = new Random().nextInt(3);
			}
			else {
				setX(x + step);
				if(flag == 1) {
					if(y - step > 25) {
						setY(y - step);
					}
				}
				else if(flag == 2) {
					if (y + step < 495) {
						setY(y + step);
					}
				}
			}
			break;
		case "up":
			if(y - step < 25) {
				setY(25);
				this.direction = "right";
				flag = new Random().nextInt(3);
			}
			else {
				setY(y - step);
				if(flag == 1) {
					if(x - step > 0) {
						setX(x - step);
					}
				}
				else if(flag == 2) {
					if (x + step < 920) {
						setX(x + step);
					}
				}
			}
			break;
		case "down":
			if(y + step > 495) {
				setY(495);
				this.direction = "left";
				flag = new Random().nextInt(3);
			}
			else {
				setY(y + step);
				if(flag == 1) {
					if(x - step > 0) {
						setX(x - step);
					}
				}
				else if(flag == 2) {
					if (x + step < 920) {
						setX(x + step);
					}
				}
			}
			break;
		}
	}
	
	public void run() {
		this.animation.start();
	}

}
