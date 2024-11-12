
package Clases;

import Clases.Boxes.CBox;
import Clases.Boxes.CBoxEnd;
import Clases.Boxes.CBoxHome;
import Clases.Boxes.CBoxSafe;
import Exceptions.InvalidMoveException;
import GUI.CBoard;
import GUI.CToken;


public class CTryMove {

    
    public int status;

    public int player;
    public CBoard board;
    public CToken token;
    public int forward;
    public boolean valid = false;
    public CBox destiny;
    public CBox origin;
    public int bonus;
    public CGameMaster gameMaster;

    public CTryMove(CGameMaster gameMaster, CToken token, int forward) {
        this.gameMaster = gameMaster;
        this.board = gameMaster.getBoard();
        this.token = token;
        this.origin = token.getBox();
        this.forward = forward;
        this.status = 0;

        this.destiny = null;
        this.bonus = 0;
        this.player = token.getPlayer();
        lightDestiny();
    }

    private void lightDestiny() {
        origin = token.getBox();
       
        if (origin instanceof CBoxEnd) {
            valid = false;
            return;
        }
        int c;
        CBox current;

       
        if (origin instanceof CBoxHome) {
            
            if (forward == 5) {
                current = token.getBox().getNext(this.player);
                destiny = current;
                
                if (destiny.isFilled()) {
                    if (((CBoxSafe) destiny).eatExceptional(token)) {    
                        destiny.property = CBox.EAT;
                        valid = true;
                    } else {   
                        destiny.property = CBox.BARRIER;
                        valid = false;
                    }
                    return;
                }
                
                destiny.property = CBox.MOVE;
                valid = true;
                return;
            }
            valid = false;
            return;
        }
        
        c = 0;
        current = origin;
        while (c < forward) {
            current = current.getNext(this.player);

            if (current == null || current.thereIsBarrier()) {
                break;
            }
            c++;
        }
        if (c == forward && current != null && !current.thereIsBarrier()) {
            if (current.eating(token)) {
                current.property = CBox.EAT;
            } else {
                current.property = CBox.MOVE;
            }
            valid = true;
            destiny = current;
        } else {
            if (current != null) {
                current.property = CBox.BARRIER;
            }
            valid = false;
        }
    }

    public void doMove() throws Exception {
        if (!valid) {
            status = 2;
            throw new InvalidMoveException();
        }
        if (destiny.property == CBox.EAT) {
            CToken food = null;
            for (CToken f : destiny.getTokens()) {
                if (f.getPlayer() != this.token.getPlayer()) {
                    food = f;
                }
            }
            
            destiny.quitToken(food);
            
            bonus = 20;

            
            board.homes[food.getPlayer()].addToken(food);

            
            origin.quitToken(this.token);

            
            destiny.addToken(this.token);

           
            return;

        }

        if (destiny.property == CBox.MOVE) {
            
            origin.quitToken(this.token);

            
            destiny.addToken(this.token);

            
            return;
        }

    }

    public int getForward() {
        return forward;
    }

    public int getBonus() {
        return bonus;
    }

    public CBox getDestiny() {
        return destiny;
    }

    public CBox getOrigin() {
        return origin;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

}
