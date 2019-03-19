package carbon;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

/**
 * The entry class to the game
 */
public final class Carbon extends BasicGame {

    private Shape circle = null;
    private Shape circle2 = null;
    private boolean collides = false;

    private Carbon(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer container) throws SlickException {

        circle = new Circle(50, 50, 25);
        circle2 = new Circle(100, 100, 35);

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {

        circle.setCenterX(container.getInput().getMouseX());
        circle.setCenterY(container.getInput().getMouseY());

        collides = circle2.contains(circle) || circle2.intersects(circle);

    }

    public void render(GameContainer container, Graphics graphics) throws SlickException {

        graphics.setColor(Color.blue);
        graphics.fill(circle2);
        graphics.draw(circle2);

        graphics.setColor(Color.red);
        graphics.fill(circle);
        graphics.draw(circle);

        graphics.setColor(Color.white);
        graphics.drawString("Collides: " + collides, 15, 30);

    }

    /**
     * Opens a window to render graphics using Slick2D
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws SlickException {

        System.out.println("Hello World!");
        AppGameContainer application = new AppGameContainer(new Carbon("Carbon 0.1-alpha"));
        application.setDisplayMode(800, 600, false);
        application.setTargetFrameRate(60);
        application.getAlwaysRender();
        application.start();

    }

}
