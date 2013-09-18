package com.artemis;

import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.artemis.utils.Bag;
import org.newdawn.slick.*;

/**
 * Created with IntelliJ IDEA.
 * User: Joaqim
 * Date: 9/15/13
 * Time: 2:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class RenderSystem extends EntityProcessingSystem {
    @Mapper ComponentMapper<Tile> tm;
    @Mapper ComponentMapper<Position> pm;
    //@Mapper ComponentMapper<Sentient> sm;

    private Image tileMapImage;

    private GameContainer container;
    private Graphics graphics;
    private Bag<Position> positions;

    public RenderSystem(GameContainer container) {
        super(Aspect.getAspectForAll(Tile.class, Position.class, Sentient.class));
        this.container = container;
        this.graphics = container.getGraphics();
    }

    /*public void init(String image) throws SlickException {
        tileMapImage = new Image("resource/menu_button_play.png");
    } */

    protected void process(Entity e) {
        Tile tile = tm.get(e);
        Position position = pm.get(e);
        //Sentient sentient = sm.get(e);

        //tileMapImage.draw(position.getX(), position.getY());
        if (position.getZ()==0) {
            graphics.setColor(tile.getTileType().getColor());
            //graphics.setAntiAlias(true);
            //graphics.drawImage(tileMapImage,1, 1);
            graphics.fillRect(position.getX()*11, position.getY()*11, 10, 10);
        }
    }
}
