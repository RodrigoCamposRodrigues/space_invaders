package project.l09gr03.controller.game;

import java.io.IOException;
import project.l09gr03.game.Game;
import project.l09gr03.model.game.arena.Arena;
import project.l09gr03.gui.GUI;
import project.l09gr03.model.game.arena.LoaderArenaBuilder;
import project.l09gr03.model.menu.MenuGameOver;
import project.l09gr03.states.GameState;
import project.l09gr03.states.MenuGameOverState;
import project.l09gr03.states.MenuState;
import project.l09gr03.model.menu.MainMenu;

public class ArenaController extends GameController
{
    private final ShipController shipController;
    private final AlienController alienController;
    private final LaserController laserController;

    public ArenaController(Arena arena) {
        super(arena);

        this.shipController = new ShipController(arena);
        this.alienController = new AlienController(arena);
        this.laserController = new LaserController(arena);
    }

    public void checkCollisionLaserAlien()
    {
        for(int i = 0; i < getModel().getLasers().size(); i++)
        {
            for(int j = 0; j < getModel().getAliens().size(); j++)
            {
                 if(getModel().getLasers().get(i).getPosition().equals(getModel().getAliens().get(j).getPosition()))
                 {
                     getModel().getAliens().remove(j);
                     getModel().getLasers().remove(i);
                     getModel().getShip().increaseScore(10);
                     break;
                 }

            }
        }
    }

    public void checkIfLaserOutOfBounds()
    {
        getModel().getLasers().removeIf(laser -> getModel().ifOutOfBounds(laser.getPosition()));
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        checkCollisionLaserAlien();
        checkIfLaserOutOfBounds();

        if (action == GUI.ACTION.QUIT ) {
            game.setHighScore(getModel().getShip().getScore());
            game.setState(new MenuState(new MainMenu()));
        }
        else if(getModel().getAliens().size() == 0)
        {
            game.setState(new GameState(new LoaderArenaBuilder().createArenaWithShip(getModel().getShip())));
        }
        else if(getModel().getShip().getLife() == 0)
        {
            game.setHighScore(getModel().getShip().getScore());
            game.setState(new MenuGameOverState(new MenuGameOver()));
        }
        else
        {
            shipController.step(game, action, time);
            alienController.step(game, action, time);
            laserController.step(game, action, time);
        }
    }

}
