package com.artemis.states;

import com.artemis.*;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Joaqim
 * Date: 9/14/13
 * Time: 6:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameplayState extends BasicGameState {

    int stateID = -1;

    private World world;
    private GameContainer container;
    private StateBasedGame sbg;

    private Entity e;
    private Entity tm;
    private Entity g;

    //private ArrayList<Grid> gridArray;
    private Entity[][][] gridArray;

    private Image playImage;

    private EntitySystem controlSystem;
    private MovementSystem movementSystem;
    private EntitySystem asteroidMovementSystem;
    private EntitySystem playerShipMovementSystem;
    private EntitySystem collisionSystem;
    private EntitySystem expirationSystem;
    private EntitySystem playerLifeSystem;
    private EntitySystem respawnSystem;

    private RenderSystem renderSystem;

    private MapRenderSystem mapRenderSystem;

    private EntitySystem hudRenderSystem;

    public GameplayState(int stateID)
    {
        this.stateID = stateID;
    }

    @Override
    public int getID()
    {
        return stateID;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        this.container = gc;
        this.sbg = sbg;

        world = new World();

        playImage = new Image("resource/menu_button_play.png");

        gridArray = new Entity[64][64][64];

        e = world.createEntity();
        e.addComponent(new Position(0,0,0));
        e.addComponent(new Velocity(0.1f, 0.1f, 0.0f));
        e.addComponent(new Rotation(0));
        e.addComponent(new Sentient());
        e.addComponent(new Tile(TileType.Stone));
        e.addToWorld();


        for(int z=0;z<32;z+=1) {
            for(int y=0;y<64;y+=1) {
                for(int x=0;x<64;x+=1) {
                    g = world.createEntity();
                    g.addComponent(new Position(x,y,0));
                    g.addComponent(new Tile(TileType.Unused));
                    g.addComponent(new Inventory());
                    //g.addComponent(new Grid());
                    //gridArray.add(g);
                    //gridArray[x][y][z] = g;
                    g.addToWorld();
                }
            }
        }


        /*
        tm = world.createEntity();
        tm.addComponent(new TileMap());

        tm.addToWorld();
        */

        //Tile t = new Tile(TileType.Stone);
        //t.getTileType().isBlocked();

        TileType t = TileType.Stone;

        tm = world.createEntity();
        tm.addComponent(new TileMap());
        tm.addToWorld();

        world.setSystem(new MovementSystem());

        renderSystem = world.setSystem(new RenderSystem(gc));

        mapRenderSystem = world.setSystem(new MapRenderSystem(gc));

        //Manager systemManager = world.getManager();

        /*
        controlSystem = systemManager.setSystem(new PlayerShipControlSystem(gc));
        movementSystem = systemManager.setSystem(new MovementSystem(gc));
        asteroidMovementSystem = systemManager.setSystem(new AsteroidMovementSystem(gc));
        playerShipMovementSystem = systemManager.setSystem(new PlayerShipMovementSystem(gc));
        collisionSystem = systemManager.setSystem(new CollisionSystem());
        expirationSystem = systemManager.setSystem(new ExpirationSystem());
        respawnSystem = systemManager.setSystem(new RespawnSystem());
        playerLifeSystem = systemManager.setSystem(new PlayerLifeSystem());

        renderSystem = systemManager.setSystem(new RenderSystem(gc));
        hudRenderSystem = systemManager.setSystem(new HudRenderSystem(gc));

        systemManager.initializeAll();
                                           */
        world.initialize();
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
    {
        //world.loopStart();

        world.setDelta(delta);
        /*
        controlSystem.process();
        */
        world.process();
        //movementSystem.process();
        /*
        asteroidMovementSystem.process();
        playerShipMovementSystem.process();
        collisionSystem.process();
        expirationSystem.process();
        playerLifeSystem.process();
        respawnSystem.process();
        */
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        mapRenderSystem.process();
        /*
        int x=0, y=0;
        for (y=0; y<gridArray[0].length; y+=1) {
            for(x=0; x<gridArray[0].length; x+=1) {
                g.setColor(gridArray[0][x][y].getComponent(Tile.class).getTileType().getColor());
                g.fillRect(x * 11, y * 11, 10, 10);
            }
            // g.draw(e.getComponent(Tile.class).getTileType());
        }
        */
        renderSystem.process();

        //hudRenderSystem.process();

        //playImage.draw(e.getComponent(Position.class).getX(), 20);
    }


    @Override
    public void keyPressed(int key, char c)
    {
        super.keyPressed(key, c);

        if (key == Keyboard.KEY_ESCAPE)
        {
            sbg.enterState(Anvil.MAINMENUSTATE);
        }
    }
}
