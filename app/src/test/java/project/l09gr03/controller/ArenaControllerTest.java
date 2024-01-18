package project.l09gr03.controller;
import java.io.IOException;
import java.util.*;
import java.util.List;


import org.mockito.Mockito;
import project.l09gr03.controller.game.ArenaController;
import project.l09gr03.game.Game;
import project.l09gr03.gui.GUI;
import project.l09gr03.model.game.arena.Arena;
import project.l09gr03.model.game.elements.Alien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.l09gr03.model.game.elements.Ship;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class ArenaControllerTest {
    private ArenaController controller;
    private Alien alien;
    private Arena arena;

    private Ship ship;
    private Game game;

    @BeforeEach
    void setUp() throws IOException{
        game = Mockito.mock(Game.class);
        game.start();
        ship = new Ship(2, 3);
        arena = new Arena(20, 20);
        alien = new Alien(5, 15);
        List<Alien> aliens = new ArrayList<Alien>();
        aliens.add(alien);
        arena.setAliens(aliens);
        controller = new ArenaController(arena);
        controller.getModel().setShip(ship);
        arena.setAliens(aliens);

    }


    @Test
    void steptest() throws IOException {
        controller.step(game, GUI.ACTION.RIGHT,501);
        assertEquals(0, ship.getScore());
    }
}