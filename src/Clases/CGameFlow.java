
package Clases;

import Exceptions.NoValidMovesException;
import GUI.CCatcherClicksBoard;
import java.awt.Color;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CGameFlow extends Thread {

    CGameMaster gameMaster;
    public static AtomicBoolean block;

    public CGameFlow(CGameMaster gameMaster) {
        this.gameMaster = gameMaster;
        this.setName("Game Flow");
        block = new AtomicBoolean(false);
    }

    public synchronized void littlePause(int n) {
        try {
            sleep(n);
        } catch (InterruptedException ex) {
            Logger.getLogger(CGameMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private synchronized void hold() throws InterruptedException {
        block.set(true);
        while (block.get() && !interrupted()) {
            sleep(50);
        }
        
    }

    public void release() {
        block.set(false);
    }

   
    public void run() {

        int cont;
        while (!gameMaster.endedGame() && !interrupted()) {
            try {

                
                cont = 0;
                while ((cont % 6 == 0) && (cont < 18)) {  
                    gameMaster.getDice().paintComponents(gameMaster.getDice().getGraphics());   
                    gameMaster.getMainFrame().updateData(gameMaster.getPlayers()[gameMaster.inTurn].getName(), "Throw dice.", Color.WHITE);

                    if (gameMaster.getPlayers()[gameMaster.inTurn].isAI()) {
                        gameMaster.getDice().animate();
                        gameMaster.getDice().updateValue();
                    } else {
                        gameMaster.getDice().setActive(true);
                        hold();
                        
                        if (gameMaster.status == 0) {
                            return;
                        }
                        gameMaster.getDice().setActive(false);
                    }
                    cont += gameMaster.getDice().getValue();

                    
                    if (gameMaster.lightMoves(gameMaster.getDice().getValue())) { 
                        playAThrow();
                    } else {
                        throw new NoValidMovesException();
                    }
                    
                    if (gameMaster.status == 0) {
                        return;
                    }

                }
            } catch (InterruptedException ex) {
                Logger.getLogger(CGameMaster.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoValidMovesException ex) {
                gameMaster.getMainFrame().updateData(gameMaster.getPlayers()[gameMaster.inTurn].getName(), ex.getMessage(), Color.red);
                littlePause(500);
                
            }

            gameMaster.nextTurn();
            
            System.gc();
        }
    }

    public void playAThrow() throws InterruptedException {
        
        while (gameMaster.getMoves() != null && !interrupted()) {
            gameMaster.getBoard().addMouseListener(new CCatcherClicksBoard(gameMaster));

            if (gameMaster.getPlayers()[gameMaster.inTurn].isAI()) {
                littlePause(500);
                gameMaster.getPlayers()[gameMaster.inTurn].play(gameMaster.getMoves());
            } else {
                gameMaster.getMainFrame().updateData(gameMaster.getPlayers()[gameMaster.inTurn].getName(), "Select move.", Color.WHITE);
                hold();
                if (gameMaster.status == 0) {
                    return;
                }
            }
            
            CTryMove next = null;

            for (CTryMove move : gameMaster.getMoves()) {
                if (move.getBonus() != 0) {
                    next = move;
                    break;
                }

            }

           
            gameMaster.clearMoves();
            
            if (next != null) {
                
                gameMaster.lightMoves(next.getBonus());
            }
        }
    }

}
