package zork.minimap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

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

    private void drawMap(Graphics2D g, double scale) {
        g.setColor(new Color(200, 200, 255)); // Light blue for the squares
        for (int i = 0; i < MAP_WIDTH * scale; i += 100 * scale) {
            for (int j = 0; j < MAP_HEIGHT * scale; j += 100 * scale) {
                g.fillRect((int)i, (int)j, (int)(50 * scale), (int)(50 * scale));
            }
        }
        g.setColor(new Color(255, 150, 150)); // Pink color for the player
        g.fillRect((int)(player.getX() * scale), (int)(player.getY() * scale), (int)(PLAYER_SIZE * scale), (int)(PLAYER_SIZE * scale));
        g.dispose();
    }

    public Map() {
        player = new Player(0, 0);

        map = new BufferedImage(MAP_WIDTH, MAP_HEIGHT, BufferedImage.TYPE_INT_RGB);
        drawMap(map.createGraphics(), 1);

        miniMap = new BufferedImage((int) (MAP_WIDTH * MINIMAP_SCALE), (int) (MAP_HEIGHT * MINIMAP_SCALE), BufferedImage.TYPE_INT_RGB);
        drawMap(miniMap.createGraphics(), MINIMAP_SCALE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int miniMapX = screenSize.width - miniMap.getWidth() - 10;
        int miniMapY = 10;

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(map, (int) (-mouseX / MINIMAP_SCALE + getWidth() / 2), (int) (-mouseY / MINIMAP_SCALE + getHeight() / 2), this);
                g.drawImage(miniMap, miniMapX, miniMapY, this);
                g.setColor(Color.YELLOW);
                g.drawString("Currently here", miniMapX + (int) (player.getX() * MINIMAP_SCALE), miniMapY + (int) (player.getY() * MINIMAP_SCALE));
                g.drawRect(miniMapX + (int) (player.getX() * MINIMAP_SCALE), miniMapY + (int) (player.getY() * MINIMAP_SCALE), (int)(PLAYER_SIZE * MINIMAP_SCALE), (int)(PLAYER_SIZE * MINIMAP_SCALE));
            }
        };

        panel.setPreferredSize(screenSize);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getX() >= miniMapX && e.getX() <= miniMapX + MAP_WIDTH * MINIMAP_SCALE && e.getY() >= miniMapY && e.getY() <= miniMapY + MAP_HEIGHT * MINIMAP_SCALE) {
                    int clickedX = (int) ((e.getX() - miniMapX) / MINIMAP_SCALE);
                    int clickedY = (int) ((e.getY() - miniMapY) / MINIMAP_SCALE);

                    int closestSquareCenterX = (int)Math.round(clickedX / 100.0) * 100 + 50;
                    int closestSquareCenterY = (int)Math.round(clickedY / 100.0) * 100 + 50;

                    int tolerance = PLAYER_SIZE / 2;
                    if (Math.abs(clickedX - closestSquareCenterX) <= tolerance && Math.abs(clickedY - closestSquareCenterY) <= tolerance) {
                        player.setX(closestSquareCenterX);
                        player.setY(closestSquareCenterY);

                        map = new BufferedImage(MAP_WIDTH, MAP_HEIGHT, BufferedImage.TYPE_INT_RGB);
                        drawMap(map.createGraphics(), 1);
                        miniMap = new BufferedImage((int) (MAP_WIDTH * MINIMAP_SCALE), (int) (MAP_HEIGHT * MINIMAP_SCALE), BufferedImage.TYPE_INT_RGB);
                        drawMap(miniMap.createGraphics(), MINIMAP_SCALE);
                        panel.repaint();
                    }
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

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                switch (key) {
                    case KeyEvent.VK_UP:
                        player.setY(Math.max(player.getY() - 100, 0));
                        break;
                    case KeyEvent.VK_DOWN:
                        player.setY(Math.min(player.getY() + 100, MAP_HEIGHT - 100));
                        break;
                    case KeyEvent.VK_LEFT:
                        player.setX(Math.max(player.getX() - 100, 0));
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.setX(Math.min(player.getX() + 100, MAP_WIDTH - 100));
                        break;
                }

                map = new BufferedImage(MAP_WIDTH, MAP_HEIGHT, BufferedImage.TYPE_INT_RGB);
                drawMap(map.createGraphics(), 1);
                miniMap = new BufferedImage((int) (MAP_WIDTH * MINIMAP_SCALE), (int) (MAP_HEIGHT * MINIMAP_SCALE), BufferedImage.TYPE_INT_RGB);
                drawMap(miniMap.createGraphics(), MINIMAP_SCALE);
                panel.repaint();
            }
        });

        panel.setFocusable(true);
        panel.requestFocusInWindow();

        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Map::new);
    }
}
