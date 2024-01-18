package project.l09gr03.viewer.game;

import project.l09gr03.model.game.elements.Alien;
import project.l09gr03.gui.GUI;

public class AlienViewer implements ElementViewer<Alien> {

    @Override
    public void draw(Alien alien, GUI gui) {
        gui.drawAlien(alien.getPosition());
    }

}
