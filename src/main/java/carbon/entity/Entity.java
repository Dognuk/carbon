package carbon.entity;

import java.awt.Shape;
import java.util.ArrayList;

import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

import carbon.util.Direction;
import carbon.util.Position;
import carbon.util.Settings;

/**
 * The base class for every player, NPC, and enemy.
 * 
 * @author Jonathan Redeker
 */
public abstract class Entity {

    protected static Settings settings;

    private Rectangle hitbox;
    private Position position;
    private SpriteSheet spriteSheet;

    public boolean friendy;
    public int health;
    public int v;
    public int vt;

    protected Entity(Settings s, Position position, Rectangle rectangle, SpriteSheet spriteSheet) {

        settings = s;

        this.hitbox = rectangle;
        this.position = position;
        this.spriteSheet = spriteSheet;
        this.v = 0;
        this.vt = 20;

    }

    public final void move(Direction direction, int forward, ArrayList<Entity> entities) {

        int x = (int) hitbox.getX();
        int y = (int) hitbox.getY();
        
        if (v < vt) v++;

        int s = v;

        if (forward == -1) s = 1; 
        
        switch (direction) {

            case UP:
                position.y -= s * forward;
                hitbox.setY(y - s * forward);
                break;

            case RIGHT:
                position.x += s * forward;
                hitbox.setX(x + s * forward);
                break;

            case DOWN:
                position.y += s * forward;
                hitbox.setY(y + s * forward);
                break;

            case LEFT:
                position.x -= s * forward;
                hitbox.setX(x - s * forward);
                break;

        }

        if (collides(entities)) {

            this.move(direction, -1, entities);

        }

    }

    public void stop() {

        v = 0;

    }

    //Make ArrayList of only nearby Entities
    public boolean collides(ArrayList<Entity> entities) {

        for (Entity entity : entities) {

            if (this.hitbox.intersects(entity.hitbox) || this.hitbox.contains(entity.hitbox)) {

                return true;

            }

        }

        return false; 

    }

    /**
     * @return The entity's current position.
     */
    public final Position getPosition() {

        return position;

    }

    /**
     * @return The entity's hitbox. Useful for collision detection.
     */
    public final Rectangle getHitbox() {

        return hitbox;

    }

    /**
     * @return The entity's spritesheet.
     */
    public final SpriteSheet getSpriteSheet() {
    
        return spriteSheet;
    
    }

    /**
     * @param position Sets the position and position of the hitbox.
     */
    public final void setPosition(Position position) {

        this.position = position;
        this.hitbox.setY(position.y);
        this.hitbox.setX(position.x);

    }

    /**
     * @param spriteSheet Sets a new spritesheet.
     */
    protected final void setSpriteSheet(SpriteSheet spriteSheet) {

        this.spriteSheet = spriteSheet;
        
    }

}