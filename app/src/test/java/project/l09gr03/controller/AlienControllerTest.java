package project.l09gr03.controller;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.List;

import org.mockito.Mockito;
import project.l09gr03.controller.game.AlienController;
import project.l09gr03.game.Game;
import project.l09gr03.gui.GUI;
import project.l09gr03.model.Position;
import project.l09gr03.model.game.arena.Arena;
import project.l09gr03.model.game.elements.Alien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.l09gr03.model.game.elements.Ship;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class AlienControllerTest {
    private AlienController controller;
    private Alien alien;
    private Arena arena;

    private Ship ship;
    private Game game;

    @BeforeEach
    void setUp() throws IOException {
        game = Mockito.mock(Game.class);
        game.start();
        ship=new Ship(2,3);
        arena = new Arena(20, 20);
        alien = new Alien(5, 15);
        List<Alien> aliens = new ArrayList<Alien>();
        aliens.add(alien);
        arena.setAliens(aliens);
        controller = new AlienController(arena);
        controller.getModel().setShip(ship);
        arena.setAliens(aliens);

    }

    @Test
    void steptest() throws IOException {
        controller.step(game, GUI.ACTION.RIGHT,501);
        assertEquals(new Position(6, 15), alien.getPosition());
    }


    @Test
    void moveAlienRightTest() {
        controller.moveAlienRight(alien, Alien.DIRECTION.RIGHT);
        assertEquals(new Position(6, 15), alien.getPosition());
    }

    @Test
    void moveAlienLeftTest() {
        controller.moveAlienLeft(alien, Alien.DIRECTION.LEFT);
        assertEquals(new Position(4, 15), alien.getPosition());
    }

    @Test
    void moveAlienDownTest() {
        controller.moveAlienDown(alien);
        assertEquals(new Position(5, 16), alien.getPosition());
    }







}