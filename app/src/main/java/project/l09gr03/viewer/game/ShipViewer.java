package project.l09gr03.viewer.game;

import project.l09gr03.model.game.elements.Ship;
import project.l09gr03.gui.GUI;

public class ShipViewer implements ElementViewer<Ship>{

    @Override
    public void draw(Ship ship, GUI gui) {
        gui.drawShip(ship.getPosition());
    }

}
