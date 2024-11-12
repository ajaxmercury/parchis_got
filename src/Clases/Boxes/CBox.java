
package Clases.Boxes;

import GUI.CToken;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;

public abstract class CBox implements Cloneable {

    
    public static final int MOVE = 1;
    public static final int EAT = 2;
    public static final int BARRIER = 3;

    
    public int id;
    public int property;
    protected ArrayList<CToken> tokens;
    Polygon area;
    public Point[] positions;

    CBox next;

    
    public CBox(int id, CBox next) {
        this.property = 0;
        this.id = id;
        tokens = new ArrayList<CToken>();
        area = new Polygon();
        this.next = next;
        
        generatePositions();
    }

    public CBox(int id, int xpos[], int[] ypos, CBox next) throws Exception {
        this.id = id;
        tokens = new ArrayList<CToken>();
        this.next = next;

        if (xpos.length != ypos.length) {
            throw new Exception("Cordenadas Init Invalidas");
        }
        area = new Polygon(xpos, ypos, xpos.length);

        
        generatePositions();
    }

    public boolean isBusy() {
        return !tokens.isEmpty();
    }

    public boolean isFilled() {
        if (tokens.size() == 2) {
            return true;
        }
        return false;
    }

   
    public void setArea(Polygon area) {
        this.area = area;
    }

    public void setNext(CBox next) {
        this.next = next;
    }

   
    public abstract void generatePositions();

    public abstract void addToken(CToken token) throws Exception;

    public abstract void quitToken(CToken token) throws Exception;

    public abstract void relocate();

    public void draw(Graphics G) {
        Color c = null;
        switch (property) {

            case CBox.MOVE:
                c = new Color(0, 255, 0, 50);
                break;
            case CBox.EAT:
                c = new Color(255, 0, 0, 50);
                break;
            case CBox.BARRIER:
                c = new Color(0, 0, 255, 50);
                break;

        }
        G.setColor(c);
        G.fillPolygon(area);
    }

    
    public abstract CToken whichCliked(Point p);  

    public abstract boolean eating(CToken token);

    public abstract boolean thereIsBarrier();

    public Polygon getArea() {
        return area;
    }

    public ArrayList<CToken> getTokens() {
        return tokens;
    }

    public abstract CBox getNext(int player);

    public abstract CBox duplicate();

    public Point[] getPositions() {
        return positions;
    }

}
