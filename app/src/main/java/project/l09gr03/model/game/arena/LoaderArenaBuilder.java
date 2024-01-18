package project.l09gr03.model.game.arena;

import project.l09gr03.model.game.elements.Laser;
import project.l09gr03.model.game.elements.Ship;
import project.l09gr03.model.game.elements.Alien;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder {
    private final List<String> lines;
    private Ship ship;

    public LoaderArenaBuilder() throws IOException {

        URL resource = LoaderArenaBuilder.class.getResource("/Arena/arena.txt");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }



    @Override
    protected List<Alien> createAliens() {
        List<Alien> aliens = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'A') aliens.add(new Alien(x, y));
        }

        return aliens;
    }

    @Override
    protected Ship createShip() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'S')
                {
                    this.ship = new Ship(x,y);
                    return this.ship;
                }
        }
        return null;
    }

    @Override
    protected List<Laser> createLasers()
    {
        return new ArrayList<Laser>();
    }
}