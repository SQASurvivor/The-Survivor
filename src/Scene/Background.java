package Scene;

import java.util.HashSet;
import java.util.Set;

import Character.BarObstacle;
import Character.Enemy;
import Character.Survivor;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Background {
	private Set<BarObstacle> obstacles;
	private Survivor survivor;
	private Enemy enemy;
	private Text time;

	public Background() {
		obstacles = new HashSet<>();
	}
	
	public void createBackground(Group root) {
		this.obstacles.add(new BarObstacle(0, 0, "horizontal", 40));
        // bottom
        this.obstacles.add(new BarObstacle(0, 575, "horizontal", 40));
        // left
        //this.obstacles.add(new BarObstacle(0, 0, "vertical", 10)); 
        //this.obstacles.add(new BarObstacle(0, 375, "vertical", 10));
        // right
        //this.obstacles.add(new BarObstacle(1225 - BarObstacle.THICKNESS, 0, "vertical", 10));
        //this.obstacles.add(new BarObstacle(1225 - BarObstacle.THICKNESS, 375, "vertical", 10));
        
        this.survivor = new Survivor(30,50,60,80);
        this.enemy = new Enemy(450,250, 80, 80);
        this.time = new Text(BarObstacle.THICKNESS * 36, BarObstacle.THICKNESS * 2, "0");
        time.setFill(Color.MAGENTA);
        time.setFont(Font.font("Arial", 20));
        root.getChildren().add(survivor);
        root.getChildren().add(time);
        root.getChildren().add(enemy);
        root.getChildren().addAll(obstacles);
	}
	
	public Survivor getSurvivor() {
		return this.survivor;
	}
	
	public Enemy getEnemy() {
		return this.enemy;
	}
	
	public Text getTime() {
		return this.time;
	}
}
