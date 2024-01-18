package project.l09gr03.viewer;

import project.l09gr03.viewer.game.ShipViewer;
import project.l09gr03.model.game.elements.Ship;
import project.l09gr03.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ShipViewerTest {

    private Ship ship;
    private ShipViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        ship = new Ship(10, 10);
        viewer = new ShipViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(ship, gui);
        Mockito.verify(gui, Mockito.times(1)).drawShip(ship.getPosition());
    }

}
