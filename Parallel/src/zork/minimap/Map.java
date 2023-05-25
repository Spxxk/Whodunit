package zork.minimap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Map extends JFrame {
    
    private static final int MAP_WIDTH = 2000;
    private static final int MAP_HEIGHT = 2000;
    private static final double MINIMAP_SCALE = 0.1;

    public Map() {
        BufferedImage map = new BufferedImage(MAP_WIDTH, MAP_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        BufferedImage miniMap = new BufferedImage((int) (MAP_WIDTH * MINIMAP_SCALE), (int) (MAP_HEIGHT * MINIMAP_SCALE), BufferedImage.TYPE_INT_ARGB);

        drawMap(map);

        Graphics g = miniMap.getGraphics();
        g.drawImage(map, 0, 0, miniMap.getWidth(), miniMap.getHeight(), null);

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(map, (int) (-mouseX / MINIMAP_SCALE + getWidth() / 2), (int) (-mouseY / MINIMAP_SCALE + getHeight() / 2), null);
                g.drawImage(miniMap, 700, 10, null);
            }
        };

        panel.setPreferredSize(new Dimension(800, 800));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                panel.repaint();
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

    private double mouseX;
    private double mouseY;

    private void drawMap(BufferedImage image) {
        Graphics2D g = image.createGraphics();
        g.setColor(Color.GREEN);
        for (int i = 0; i < MAP_WIDTH; i += 100) {
            for (int j = 0; j < MAP_HEIGHT; j += 100) {
                g.fillRect(i, j, 50, 50);
            }
        }
        g.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Map::new);
    }
}