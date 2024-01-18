package project.l09gr03.viewer;

import project.l09gr03.gui.GUI;
import project.l09gr03.viewer.game.AlienViewer;
import project.l09gr03.model.game.elements.Alien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AlienViewerTest {

    private Alien alien;
    private AlienViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        alien = new Alien(10, 10);
        viewer = new AlienViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(alien, gui);
        Mockito.verify(gui, Mockito.times(1)).drawAlien(alien.getPosition());
    }

}
