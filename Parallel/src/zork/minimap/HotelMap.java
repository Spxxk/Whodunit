package zork.minimap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HotelMap {
    private JFrame frame;
    private Map<String, Set<Point>> roomCoordinates = new HashMap<>();
    private Map<String, JLabel> roomLabels = new HashMap<>();
    private JLabel playerLabel;
    private Point currentPoint;
    private String currentRoom;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HotelMap hotelMap = new HotelMap();
            hotelMap.initializeMap();
        });
    }

    public void initializeMap() {
        frame = new JFrame("Hotel Map");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        initializeRooms();
        currentRoom = "Glenn's Kitchen"; // Start at Glenn's Kitchen
        currentPoint = roomCoordinates.get(currentRoom).iterator().next(); // Starting position

        for (String room : roomCoordinates.keySet()) {
            Set<Point> points = roomCoordinates.get(room);
            for (Point point : points) {
                JLabel roomLabel = new JLabel(room);
                roomLabel.setFont(new Font("Arial", Font.PLAIN, 10));
                roomLabel.setBounds(point.x, point.y, 150, 50);
                roomLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                frame.add(roomLabel);
                roomLabels.put(point.toString(), roomLabel);
            }
        }

        playerLabel = new JLabel("You are here");
        playerLabel.setFont(new Font("Arial", Font.BOLD, 12));
        playerLabel.setBounds(currentPoint.x, currentPoint.y + 60, 150, 20);
        playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(playerLabel);

        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        move("north");
                        break;
                    case KeyEvent.VK_DOWN:
                        move("south");
                        break;
                    case KeyEvent.VK_LEFT:
                        move("west");
                        break;
                    case KeyEvent.VK_RIGHT:
                        move("east");
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        frame.requestFocusInWindow();
    }

    private void move(String direction) {
        Set<Point> currentRoomPoints = roomCoordinates.get(currentRoom);

        Point newPoint = currentPoint;
        switch (direction) {
            case "north":
                newPoint = new Point(currentPoint.x, currentPoint.y - 50);
                break;
            case "south":
                newPoint = new Point(currentPoint.x, currentPoint.y + 50);
                break;
            case "west":
                newPoint = new Point(currentPoint.x - 100, currentPoint.y);
                break;
            case "east":
                newPoint = new Point(currentPoint.x + 100, currentPoint.y);
                break;
        }

        for (String room : roomCoordinates.keySet()) {
            Set<Point> points = roomCoordinates.get(room);
            if (points.contains(newPoint)) {
                currentRoom = room;
                currentPoint = newPoint;
                playerLabel.setBounds(currentPoint.x, currentPoint.y + 60, 150, 20);
                updateRoomLabels();
                break;
            }
        }
    }

    private void updateRoomLabels() {
        for (String room : roomLabels.keySet()) {
            JLabel roomLabel = roomLabels.get(room);
            roomLabel.setBounds(-100, -100, 0, 0); // Hide all room labels
        }

        Set<Point> currentRoomPoints = roomCoordinates.get(currentRoom);
        for (Point point : currentRoomPoints) {
            JLabel roomLabel = roomLabels.get(point.toString());
            roomLabel.setBounds(point.x, point.y, 150, 50);
        }
    }

    private void initializeRooms() {
        // Define the coordinates for each room
        roomCoordinates.put("Glenn's Kitchen", new HashSet<>(Collections.singletonList(new Point(150, 0))));
        roomCoordinates.put("Glenn's Room", new HashSet<>(Collections.singletonList(new Point(150, 50))));
        roomCoordinates.put("Glenn's Bathroom", new HashSet<>(Collections.singletonList(new Point(50, 50))));
        roomCoordinates.put("Glenn's Sink", new HashSet<>(Collections.singletonList(new Point(50, 100))));
        roomCoordinates.put("Glenn's Closet", new HashSet<>(Collections.singletonList(new Point(150, 100))));
        roomCoordinates.put("Garbage Chute", new HashSet<>(Collections.singletonList(new Point(250, 0))));
        roomCoordinates.put("Hallway High", new HashSet<>(Collections.singletonList(new Point(250, 50))));
        roomCoordinates.put("Brent's Kitchen", new HashSet<>(Collections.singletonList(new Point(150, 250))));
        roomCoordinates.put("Brent's Room", new HashSet<>(Collections.singletonList(new Point(150, 300))));
        roomCoordinates.put("Brent's Bathroom", new HashSet<>(Collections.singletonList(new Point(50, 300))));
        roomCoordinates.put("Brent's Sink", new HashSet<>(Collections.singletonList(new Point(50, 350))));
        roomCoordinates.put("Brent's Closet", new HashSet<>(Collections.singletonList(new Point(150, 350))));
        roomCoordinates.put("Hallway Mid", new HashSet<>(Collections.singletonList(new Point(250, 300))));
        roomCoordinates.put("Frank's Kitchen", new HashSet<>(Collections.singletonList(new Point(150, 550))));
        roomCoordinates.put("Frank's Bathroom", new HashSet<>(Collections.singletonList(new Point(150, 600))));
        roomCoordinates.put("Frank's Room", new HashSet<>(Collections.singletonList(new Point(50, 600))));
        roomCoordinates.put("Frank's Sink", new HashSet<>(Collections.singletonList(new Point(50, 650))));
        roomCoordinates.put("Frank's Closet", new HashSet<>(Collections.singletonList(new Point(150, 650))));
        roomCoordinates.put("Hallway Low", new HashSet<>(Collections.singletonList(new Point(250, 600))));
        roomCoordinates.put("Roof Top", new HashSet<>(Collections.singletonList(new Point(350, 200))));
        roomCoordinates.put("Elevator", new HashSet<>(Collections.singletonList(new Point(1000, 350))));
        roomCoordinates.put("Hotel Lobby", new HashSet<>(Collections.singletonList(new Point(350, 450))));
        roomCoordinates.put("Hotel Front Door", new HashSet<>(Collections.singletonList(new Point(450, 450))));
        roomCoordinates.put("Parking Lot", new HashSet<>(Collections.singletonList(new Point(350, 550))));
        roomCoordinates.put("Swimming Pool", new HashSet<>(Collections.singletonList(new Point(250, 550))));
        roomCoordinates.put("BasketBall Court", new HashSet<>(Collections.singletonList(new Point(450, 550))));
        roomCoordinates.put("Grass", new HashSet<>(Collections.singletonList(new Point(450, 250))));
        roomCoordinates.put("Stands", new HashSet<>(Collections.singletonList(new Point(350, 250))));
        roomCoordinates.put("Tennis Court", new HashSet<>(Collections.singletonList(new Point(450, 150))));
        roomCoordinates.put("Snack Bar", new HashSet<>(Collections.singletonList(new Point(550, 350))));
        roomCoordinates.put("Reception", new HashSet<>(Collections.singletonList(new Point(550, 550))));
        roomCoordinates.put("Casino", new HashSet<>(Collections.singletonList(new Point(550, 650))));
        roomCoordinates.put("Slots", new HashSet<>(Collections.singletonList(new Point(650, 650))));
        roomCoordinates.put("Vault", new HashSet<>(Collections.singletonList(new Point(650, 550))));
        roomCoordinates.put("Poker Tables", new HashSet<>(Collections.singletonList(new Point(750, 650))));
        roomCoordinates.put("Private Poker Table Room", new HashSet<>(Collections.singletonList(new Point(750, 550))));

        // Define the connections between hallways
        roomCoordinates.get("Hallway High").add(new Point(250, 100));  // Connection to Hallway Mid
        roomCoordinates.get("Hallway Mid").add(new Point(250, 200));   // Connection to Hallway High and Low
        roomCoordinates.get("Hallway Mid").add(new Point(250, 400));   // Connection to Hallway High and Low
        roomCoordinates.get("Hallway Low").add(new Point(250, 500));   // Connection to Hallway Mid
    }
}
