package com.artemis;

import com.artemis.states.GameplayState;
import com.artemis.states.MainMenuState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created with IntelliJ IDEA.
 * User: Joaqim
 * Date: 9/14/13
 * Time: 6:18 AM
 * To change this template use File | Settings | File Templates.
 */

public class Anvil extends StateBasedGame {

    public static final int MAINMENUSTATE = 0;
    public static final int GAMEPLAYSTATE = 1;

    public Anvil()
    {
        super("Anvil");

        //this.addState(new MainMenuState(MAINMENUSTATE));
        this.addState(new GameplayState(GAMEPLAYSTATE));
        //this.enterState(MAINMENUSTATE);
        this.enterState(GAMEPLAYSTATE);
    }

    public static void main(String[] args) throws SlickException
    {
        AppGameContainer app = new AppGameContainer(new Anvil());

        app.setDisplayMode(800, 600, false);
        app.start();
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException
    {
        container.setTargetFrameRate(100);

//              this.getState(MAINMENUSTATE).init(gameContainer, this);
//              this.getState(GAMEPLAYSTATE).init(gameContainer, this);
    }
}
