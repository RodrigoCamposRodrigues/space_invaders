package project.l09gr03.controller.game;

import project.l09gr03.model.Position;
import project.l09gr03.model.game.arena.Arena;
import project.l09gr03.game.Game;
import project.l09gr03.gui.GUI;
import project.l09gr03.model.game.elements.Laser;


public class ShipController extends GameController {

    private long lastMovement;
    private boolean canShoot;

    public ShipController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
        this.canShoot = true;
    }

    public void moveShipLeft() {
        moveShip(getModel().getShip().getPosition().getLeft());
    }

    public void moveShipRight() {
        moveShip(getModel().getShip().getPosition().getRight());
    }

    private void moveShip(Position position) {
        //não deixar a nave sair do terminal
        if (!getModel().ifOutOfBounds(position)) {
            getModel().getShip().setPosition(position);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.RIGHT) moveShipRight();
        if (action == GUI.ACTION.LEFT) moveShipLeft();

        checkIfShipCanShoot(action, time);
        updateVariableCanShoot(time);
    }

    private void updateVariableCanShoot(long time) {
        if (time - lastMovement > 500) {
            this.canShoot = true;
        }
    }

    private void checkIfShipCanShoot(GUI.ACTION action, long time) {
        if ((action == GUI.ACTION.SHOOT) && this.canShoot) {
            getModel().getLasers().add(new Laser(getModel().getShip()));
            this.lastMovement = time;
            this.canShoot = false;
        }
    }

}
