package Check;

import javafx.scene.shape.Rectangle;

public class CheckTouching {
	private double left;
	private double right;
	private double top;
	private double bottom;
	
	private double left2;
	private double right2;
	private double top2;
	private double bottom2;
	
	public CheckTouching(Rectangle survivor, Rectangle enemy) {
		this.left = survivor.getX();
		this.right = survivor.getX() + survivor.getWidth();
		this.top = survivor.getY();
		this.bottom = survivor.getY() + survivor.getHeight();
		
		this.left2 = enemy.getX();
		this.right2 = enemy.getX() + enemy.getWidth();
		this.top2 = enemy.getY();
		this.bottom2 = enemy.getY() + enemy.getHeight(); 
	}
	
	public boolean isTouching() {
		if (checkPoint(left2, top2) || checkPoint(left2, bottom2) ||
				checkPoint(right2, top2) || checkPoint(right2, bottom2)) {
			return true;
		}
		return false;
	}
	
	public boolean checkPoint(double x, double y) {
		if(x >= left && x <= right) {
			if(y >= top && y <= bottom) {
				return true;
			}
		}
		return false;
	}
}
