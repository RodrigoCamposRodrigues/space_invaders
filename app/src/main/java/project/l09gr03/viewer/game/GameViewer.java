package project.l09gr03.viewer.game;

import project.l09gr03.viewer.Viewer;
import project.l09gr03.model.game.elements.Element;
import project.l09gr03.model.Position;
import project.l09gr03.model.game.arena.Arena;
import project.l09gr03.gui.GUI;

import java.util.List;

public class GameViewer extends Viewer<Arena> {

    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getAliens(), new AlienViewer());
        drawElement(gui, getModel().getShip(), new ShipViewer());
        drawElements(gui,getModel().getLasers(), new LaserViewer());

        gui.drawText(new Position(0, 0), "Lives: " + getModel().getShip().getLife(), "#FFFFFF");
        gui.drawText(new Position(10, 0), "Score:" + getModel().getShip().getScore(), "#FFFFFF");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

}
