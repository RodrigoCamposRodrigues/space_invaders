package project.l09gr03.viewer;

import project.l09gr03.model.game.elements.Ship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import project.l09gr03.gui.GUI;
import project.l09gr03.viewer.game.GameViewer;
import project.l09gr03.model.game.arena.Arena;
import project.l09gr03.model.game.elements.Alien;
import project.l09gr03.model.Position;

public class ArenaViewerTest {

    private GUI gui;
    private GameViewer viewer;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);

        arena.setAliens(Arrays.asList(new Alien(4, 5), new Alien(5, 6)));
        arena.setShip(new Ship(5, 8));
    }



    @Test
    void drawAlien() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawAlien(new Position(4, 5));
        Mockito.verify(gui, Mockito.times(1)).drawAlien(new Position(5, 6));
        Mockito.verify(gui, Mockito.times(2)).drawAlien(Mockito.any(Position.class));
    }

    @Test
    void drawShip() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawShip(new Position(5, 8));
        Mockito.verify(gui, Mockito.times(1)).drawShip(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }

}
