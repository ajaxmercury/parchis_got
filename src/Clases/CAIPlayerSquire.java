
package Clases;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CAIPlayerSquire extends CPlayer {

    public CAIPlayerSquire(int id, String name, int house) {
        super(id, name, house, true);
    }

    public void play(CTryMove[] moves) {
        CTryMove mov = null;
        for (int i = 0; i < moves.length; i++) {
            if (moves[i] != null && moves[i].isValid()) {
                mov = moves[i];
            }
        }
        try {
            mov.doMove();
        } catch (Exception ex) {
            Logger.getLogger(CAIPlayerSquire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
