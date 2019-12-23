package Character;


import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Survivor extends Rectangle{
	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Survivor (double x, double y, double width, double height) {
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
		Image image = new Image("Character/user.png");
		this.setFill(new ImagePattern(image));
	}
}
