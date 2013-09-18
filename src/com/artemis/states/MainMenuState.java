package com.artemis.states;

import com.artemis.Anvil;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created with IntelliJ IDEA.
 * User: Joaqim
 * Date: 9/14/13
 * Time: 6:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainMenuState extends BasicGameState
{
    private int stateID = -1;

    private GameContainer gc;
    private StateBasedGame sbg;

    private Image backgroundImage;
    private Image playImage;
    private Image exitImage;

    private int playX;
    private int playY;
    private int exitX;
    private int exitY;

    public MainMenuState(int stateID)
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
        this.gc = gc;
        this.sbg = sbg;

        backgroundImage = new Image("resource/menu_background.png");
        playImage = new Image("resource/menu_button_play.png");
        exitImage = new Image("resource/menu_button_exit.png");

        playX = 50;
        playY = 200;
        exitX = gc.getWidth() - 150;
        exitY = gc.getHeight() - 60;
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
    {
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        backgroundImage.draw(0, 0);
        playImage.draw(playX, playY);
        exitImage.draw(exitX, exitY);
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount)
    {
        super.mouseClicked(button, x, y, clickCount);

        if (x >= playX && x <= playX + playImage.getWidth() && y >= playY
                && y <= playY + playImage.getHeight())
        {
            playGame();
        }
        else if (x >= exitX && x <= exitX + exitImage.getWidth() && y >= exitY
                && y <= exitY + exitImage.getHeight())
        {
            exitGame();
        }
    }

    @Override
    public void keyPressed(int key, char c)
    {
        super.keyPressed(key, c);

        if (key == Keyboard.KEY_RETURN)
        {
            playGame();
        }
        else if (key == Keyboard.KEY_ESCAPE)
        {
            exitGame();
        }
    }

    protected void playGame()
    {
        sbg.enterState(Anvil.GAMEPLAYSTATE);
    }

    protected void exitGame()
    {
        gc.exit();
    }
}
