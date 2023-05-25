package zork.minimap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JFrame {

    private static final int MAP_WIDTH = 2000;
    private static final int MAP_HEIGHT = 2000;
    private static final double MINIMAP_SCALE = 0.1;
    private static final int PLAYER_SIZE = 10;

    private Player player;
    private double mouseX;
    private double mouseY;
    private BufferedImage map;
    private BufferedImage miniMap;

    public Map() {
        player = new Player(0, 0); // player starts at the top left of the map

        map = new BufferedImage(MAP_WIDTH, MAP_HEIGHT, BufferedImage.TYPE_INT_RGB);
        drawMap(map.createGraphics());

        miniMap = new BufferedImage((int) (MAP_WIDTH * MINIMAP_SCALE), (int) (MAP_HEIGHT * MINIMAP_SCALE), BufferedImage.TYPE_INT_RGB);
        miniMap.createGraphics().drawImage(map, 0, 0, miniMap.getWidth(), miniMap.getHeight(), this);
        
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(map, (int) (-mouseX / MINIMAP_SCALE + getWidth() / 2), (int) (-mouseY / MINIMAP_SCALE + getHeight() / 2), this);
                g.drawImage(miniMap, 700, 10, this);
                g.setColor(Color.RED);
                g.drawString("Currently here", 700 + (int) (player.getX() * MINIMAP_SCALE), 10 + (int) (player.getY() * MINIMAP_SCALE));
                g.drawRect(700 + (int) (player.getX() * MINIMAP_SCALE), 10 + (int) (player.getY() * MINIMAP_SCALE), PLAYER_SIZE, PLAYER_SIZE);
            }
        };

        panel.setPreferredSize(new Dimension(800, 800));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getX() >= 700 && e.getX() <= 700 + MAP_WIDTH * MINIMAP_SCALE && e.getY() >= 10 && e.getY() <= 10 + MAP_HEIGHT * MINIMAP_SCALE) {
                    player.setX((int) ((e.getX() - 700) / MINIMAP_SCALE));
                    player.setY((int) ((e.getY() - 10) / MINIMAP_SCALE));
                    map = new BufferedImage(MAP_WIDTH, MAP_HEIGHT, BufferedImage.TYPE_INT_RGB);
                    drawMap(map.createGraphics());
                    miniMap = new BufferedImage((int) (MAP_WIDTH * MINIMAP_SCALE), (int) (MAP_HEIGHT * MINIMAP_SCALE), BufferedImage.TYPE_INT_RGB);
                    miniMap.createGraphics().drawImage(map, 0, 0, miniMap.getWidth(), miniMap.getHeight(), panel);
                    panel.repaint();
                }
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mouseX += e.getX();
                mouseY += e.getY();
                panel.repaint();
            }
        });

        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void drawMap(Graphics2D g) {
        g.setColor(Color.GREEN);
        for (int i = 0; i < MAP_WIDTH; i += 100) {
            for (int j = 0; j < MAP_HEIGHT; j += 100) {
                g.fillRect(i, j, 50, 50);
            }
        }
        g.setColor(Color.RED);
        g.fillRect(player.getX(), player.getY(), PLAYER_SIZE, PLAYER_SIZE);
        g.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Map::new);
    }
}
