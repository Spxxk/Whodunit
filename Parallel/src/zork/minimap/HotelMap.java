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
                    "Glenn's Kitchen", "Glenn's Room", "Glenn's Bathroom", "Glenn's Sink", "Glenn's Closet", "Garbage Chute", "Hallway High", "Brent's Kitchen", "Brent's Room", "Brent's Bathroom", "Brent's Sink", "Brent's Closet", "Hallway Mid", "Frank's Kitchen", "Frank's Bathroom", "Frank's Room", "Frank's Sink", "Frank's Closet", "Hallway Low", "Roof Top", "Elevator", "Hotel Lobby", "Hotel Front Door", "Parking Lot", "Swimming Pool", "BasketBall Court", 
                    "Grass", "Stands", "Tennis Court", "Snack Bar", "Reception", "Casino", "Slots", "Vault", "Poker Tables", "Private Poker Table Room"                            
            };

            Point[] points = {
                    new Point(150, 0),  // Glenn's Kitchen
                    new Point(150, 100),  // Glenn's Room
                    new Point(50, 100),   // Glenn's Bathroom
                    new Point(50, 200),   // Glenn's Sink
                    new Point(150, 200),  // Glenn's Closet
                    new Point(250, 0),  // Garbage Chute
                    new Point(250, 100),  // Hallway High
                    new Point(150, 300),  // Brent's Kitchen
                    new Point(150, 400),  // Brent's Room
                    new Point(50, 400),   // Brent's Bathroom
                    new Point(50, 500),   // Brent's Sink
                    new Point(150, 500),  // Brent's Closet
                    new Point(250, 400),  // Hallway Mid
                    new Point(150, 700),  // Frank's Kitchen
                    new Point(150, 800),  // Frank's Room
                    new Point(50, 800),   // Frank's Bathroom
                    new Point(50, 900),  // Frank's Sink
                    new Point(150, 900), // Frank's Closet
                    new Point(250, 700),  // Hallway Low
                    new Point(350, 300),  // Elevator
                    new Point(350, 400),  // Roof Top
                    new Point(350, 500),  // Hotel Lobby
                    new Point(450, 500),  // Reception
                    new Point(350, 600),  // Hotel Front Door
                    new Point(250, 600),  // Parking Lot
                    new Point(450, 600),  // Swimming Pool
                    new Point(450, 300),  // Basketball Court
                    new Point(350, 300),  // Grass
                    new Point(450, 200),  // Stands
                    new Point(550, 400),  // Tennis Court
                    new Point(550, 600),  // Snack Bar
                    new Point(550, 700),  // Reception
                    new Point(650, 700),  // Casino
                    new Point(650, 600),  // Slots
                    new Point(750, 700),  // Poker Tables
                    new Point(750, 600),  // Vault
                    new Point(850, 700)   // Private Poker Table Room
            };

            for (int i = 0; i < rooms.length; i++) {
                JLabel roomLabel = new JLabel(rooms[i]);
                roomLabel.setBounds(points[i].x, points[i].y, 150, 50); // Increased label size
                frame.add(roomLabel);
            }

            frame.setSize(1200, 1500); // Adjusted the size to accommodate all the labels
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
