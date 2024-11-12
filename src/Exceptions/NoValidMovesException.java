

package Exceptions;


public class NoValidMovesException extends Exception{

    public NoValidMovesException() {
        super("No puede moverse, le toco parcharse");
    }

}
