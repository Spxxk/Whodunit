package zork.minimap;

import javax.swing.*;
import java.awt.*;

public class HotelMap {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hotel Map");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);

            String[] rooms = {
                    "Glenn's Kitchen", "Glenn's Room", "Glenn's Bathroom", "Glenn's Sink", "Glenn's Closet", "Garbage Chute", "Hallway High",
                    "Brent's Kitchen", "Brent's Room", "Brent's Bathroom", "Brent's Sink", "Brent's Closet", "Hallway Mid",
                    "Frank's Kitchen", "Frank's Bathroom", "Frank's Room", "Frank's Sink", "Frank's Closet", "Hallway Low",
                    "Roof Top", "Elevator", "Hotel Lobby", "Hotel Front Door", "Parking Lot", "Swimming Pool", "BasketBall Court",
                    "Grass", "Stands", "Tennis Court", "Snack Bar", "Reception", "Casino", "Slots", "Vault", "Poker Tables", "Private Poker Table Room"
            };

            Point[] points = {
                    new Point(150, 0),   // Glenn's Kitchen
                    new Point(150, 50),    // Glenn's Room
                    new Point(50, 50),     // Glenn's Bathroom
                    new Point(50, 100),    // Glenn's Sink
                    new Point(150, 100),   // Glenn's Closet
                    new Point(250, 0),   // Garbage Chute
                    new Point(250, 50),    // Hallway High
                    new Point(150, 250),   // Brent's Kitchen
                    new Point(150, 300),   // Brent's Room
                    new Point(50, 300),    // Brent's Bathroom
                    new Point(50, 350),    // Brent's Sink
                    new Point(150, 350),   // Brent's Closet
                    new Point(250, 300),   // Hallway Mid
                    new Point(150, 550),   // Frank's Kitchen
                    new Point(150, 600),   // Frank's Bathroom
                    new Point(50, 600),    // Frank's Room
                    new Point(50, 650),    // Frank's Sink
                    new Point(150, 650),   // Frank's Closet
                    new Point(250, 600),   // Hallway Low
                    new Point(350, 200),   // Roof Top
                    new Point(1000, 350),   // Elevator
                    new Point(350, 450),   // Hotel Lobby
                    new Point(450, 450),   // Hotel Front Door
                    new Point(350, 550),   // Parking Lot
                    new Point(250, 550),   // Swimming Pool
                    new Point(450, 550),   // BasketBall Court
                    new Point(450, 250),   // Grass
                    new Point(350, 250),   // Stands
                    new Point(450, 150),   // Tennis Court
                    new Point(550, 350),   // Snack Bar
                    new Point(550, 550),   // Reception
                    new Point(550, 650),   // Casino
                    new Point(650, 650),   // Slots
                    new Point(650, 550),   // Vault
                    new Point(750, 650),   // Poker Tables
                    new Point(750, 550),   // Private Poker Tabl Room
            };

            for (int i = 0; i < rooms.length; i++) {
                JLabel roomLabel = new JLabel(rooms[i]);
                roomLabel.setFont(new Font("Arial", Font.PLAIN, 10)); // Set the font to be smaller
                roomLabel.setBounds(points[i].x, points[i].y, 150, 50);
                frame.add(roomLabel);
            }

            frame.setSize(1200, 800);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
