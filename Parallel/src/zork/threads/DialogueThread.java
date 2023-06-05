package zork.threads;

import zork.Game;

public class DialogueThread extends Thread {
    public DialogueThread() {
        super("DialogueThread");
    }

    @Override
    public void run() {
        while(true) {
            if(Game.player.getCharacterTalkingTo() != null) {
                try {
                    Game.dialogueLoop(Game.player.getCharacterTalkingTo().getId());
                    Game.player.setCharacterTalkingTo(null);
                } 
                catch(NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
