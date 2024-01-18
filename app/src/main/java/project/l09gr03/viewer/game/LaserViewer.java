package project.l09gr03.viewer.game;

import project.l09gr03.model.game.elements.Laser;
import project.l09gr03.gui.GUI;

public class LaserViewer implements ElementViewer<Laser> {

    @Override
    public void draw(Laser laser, GUI gui) {
        gui.drawLaser(laser.getPosition());
    }

}
