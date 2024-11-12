

package Exceptions;


public class ExHousesSames extends Exception {

    public ExHousesSames() {
        super("No puedes escpger la misma casa (equipo)");
    }


    
    public ExHousesSames(String msg) {
        super(msg);
    }
}
