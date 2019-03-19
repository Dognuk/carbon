package carbon;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

/**
 * Hello world!
 */
public final class Carbon extends BasicGame {
    private Carbon(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer container) throws SlickException {

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {

    }

    public void render(GameContainer container, Graphics graphics) throws SlickException {

    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws SlickException {
        System.out.println("Hello World!");
        AppGameContainer application = new AppGameContainer(new Carbon("Carbon 0.1-alpha"));
        application.setDisplayMode(800, 600, false);
        application.getAlwaysRender();
        application.start();
    }
}
