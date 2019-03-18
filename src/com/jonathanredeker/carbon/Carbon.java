package com.jonathanredeker.carbon;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Carbon extends BasicGame {

    public Carbon(String title) {
        super(title);
    } 

    @Override
    public void init(GameContainer container) throws SlickException {

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        
    }
    
    @Override
    public void render(GameContainer container, Graphics graphics) throws SlickException {

    }
    
    public static void main(String[] args) throws SlickException {
        
        AppGameContainer application = new AppGameContainer(new Carbon("Carbon 0.1-alpha"));
        application.setDisplayMode(800, 600, false);
        application.start();
        System.out.println("hey");

    }

}