package carbon.state;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

import carbon.entity.Ball;
import carbon.entity.Entity;
import carbon.util.Direction;
import carbon.util.Position;
import carbon.util.Settings;

public final class Test extends GameState {

    private static Ball ball1;
    private static Ball ball2;
    public Input input;
    ArrayList<Entity> e = new ArrayList<Entity>();

    public Test(Settings settings) {

        super(settings);

    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {

        ball1 = new Ball(settings, new Position(700, 200), new Rectangle(700, 200, 100, 100),
                new SpriteSheet("data/sprites/curly2.png", 64, 64));
        ball2 = new Ball(settings, new Position(300, 300), new Rectangle(300, 300, 100, 100),
                new SpriteSheet("data/sprites/curly2.png", 64, 64));

        
        e.add(ball2);

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

        input = container.getInput();
        
        if (input.isKeyDown(input.KEY_D)) {
            ball1.move(Direction.RIGHT, 1, e);
        }
        if (input.isKeyDown(input.KEY_S)) {
            ball1.move(Direction.DOWN, 1, e);
        }
        if (input.isKeyDown(input.KEY_W)) {
            ball1.move(Direction.UP, 1, e);
        }
        if (input.isKeyDown(input.KEY_A)) {
            ball1.move(Direction.LEFT, 1, e);
        }

    }

    @Override
    public void keyReleased(int key, char c) {
        ball1.stop();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

        g.draw(ball1.getHitbox());
        g.draw(ball2.getHitbox());

    }

    @Override
    public int getID() {

        return 0x00;

    }

    
} 