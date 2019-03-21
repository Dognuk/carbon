package carbon.entity;

import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

import carbon.util.Position;
import carbon.util.Settings;

public class Ball extends Entity {

    public Circle circle = new Circle(0, 0, 50);

    public Ball(Settings settings,
                Position position, 
                Rectangle rectangle, 
                SpriteSheet spriteSheet) {

        super(settings, position, rectangle, spriteSheet);

    }

}