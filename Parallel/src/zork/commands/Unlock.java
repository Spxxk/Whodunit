// package zork.commands;

// import zork.Game;
// import zork.Constants.ArgumentCount;
// import zork.proto.Player;
// import zork.proto.Room;
// import zork.proto.Command;
// import zork.proto.Exit;
// import zork.proto.Item;

// public class Unlock extends Command{

//     public Unlock() { super("Unlock", "Unlocks a room, if you have the key, of course", ArgumentCount.INFINITE); }

//     @Override
//     public void runCommand(String... args) {
//         Player player = Game.player;

//         String name = args[0];

//         if (name == null) {
//             System.out.printf("Room [%s] does not exist\n", name);
//             return;
//         }

//         for (Item item : player.getInventory().getContents()) {
//             if (item.getId().equalsIgnoreCase(name+"Key")) { 

//                 for (Room room : Game.roomMap.values()) {
//                     for (Exit e : room.getExits()) {
//                         if (e.)
//                     }
//                 }

//                 e.setLocked(false); 

//                 try {
//                     player.setCurrentRoom(e.getAdjacentRoom());
//                     Game.print("/bYou have just unlocked "+player.getCurrentRoom().getRoomName()+"!");
//                     System.out.printf("You just travelled to [%s]!\n\n", player.getCurrentRoom().getRoomName());
//                     System.out.println(player.getCurrentRoom().longDescription());
//                 } catch (Exception ex) {
//                     ex.printStackTrace();
//                 }
//                 return;
//             }
//         }
//     }
    
// }
