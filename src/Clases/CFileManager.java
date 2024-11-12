
package Clases;

import Clases.Boxes.CBox;
import GUI.CToken;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class CFileManager {

    private static String text = null;
    private static FileReader FR;
    private static Scanner input;
    private static FileWriter FW;
    private static PrintWriter output;
    private static int opt = 0;

    public static void loadGameFromFile(CGameMaster gameMaster, Component comp) throws Exception {
        // Show the file shooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File("ParchisGame.prs"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Parchís files (*.prs)", "prs");
        fileChooser.removeChoosableFileFilter(fileChooser.getAcceptAllFileFilter());
        fileChooser.setFileFilter(filter);
        opt = fileChooser.showOpenDialog(comp);

        if (opt == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

           
            if (!file.exists()) {
                throw new FileNotFoundException(file.getAbsolutePath());
            }

            FR = new FileReader(file);
            input = new Scanner(FR);

            int nPlayers = input.nextInt();     

            int inTurn = input.nextInt();        

            CPlayer players[] = new CPlayer[nPlayers];
            String name;
            boolean ai;
            int aiInt;
            int house = 0;
            int boxes[][] = new int[nPlayers][4];
            for (int i = 0; i < nPlayers; i++) {
                            
                name = input.next();    
                house = input.nextInt(); 
                aiInt = input.nextInt();

                if (aiInt == 0) {
                    ai = false;             
                } else {
                    ai = true;             
                }

                
                players[i] = new CPlayer(i, name, house, ai);

                
                for (int j = 0; j < 4; j++) {
                    boxes[i][j] = input.nextInt();
                }
            }

            
            CToken[] tokens;
            CBox box = null;
            for (int i = 0; i < nPlayers; i++) {
                tokens = new CToken[4];
                for (int j = 0; j < 4; j++) {
                    
                    
                    if (boxes[i][j] < 68) {
                        box = gameMaster.getBoard().map[boxes[i][j]];
                    }

                    
                    if (boxes[i][j] >= 100 && boxes[i][j] < 200) {
                        box = gameMaster.getBoard().pathEnd.get(i)[boxes[i][j] % 10];
                    }

                    
                    if (boxes[i][j] >= 200 && boxes[i][j] < 300) {
                        box = gameMaster.getBoard().homes[boxes[i][j] % 10];
                    }

                    
                    if (boxes[i][j] >= 300 && boxes[i][j] < 400) {
                        box = gameMaster.getBoard().goals[boxes[i][j] % 10];
                    }

                    
                    tokens[j] = new CToken(j, box, i, players[i].getHouse());

                }
                
                players[i].setTokens(tokens);
            }
            input.close();

            
            gameMaster.newGame(nPlayers, inTurn, players);
            gameMaster.getBoard().paint(gameMaster.getBoard().getGraphics());

        }
    }

    public static void saveFile(CGameMaster gameMaster, Component comp) throws IOException {

        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File("ParchisGame.prs"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Parchís files (*.prs)", "prs");
        fileChooser.removeChoosableFileFilter(fileChooser.getAcceptAllFileFilter());
        fileChooser.setFileFilter(filter);

        opt = fileChooser.showSaveDialog(comp);

        if (opt == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();

            
            File ficheroW = new File(fileChooser.getSelectedFile().getAbsolutePath());
            FW = new FileWriter(ficheroW);
            output = new PrintWriter(FW);

            
            output.println(gameMaster.nPlayers);
            
            output.println(gameMaster.inTurn);

            for (int i = 0; i < gameMaster.nPlayers; i++) {

                
                output.println(gameMaster.getPlayers()[i].getName()); 
                output.println(gameMaster.getPlayers()[i].getHouse()); 
                if (gameMaster.getPlayers()[i].isAI()) {              
                    output.println(1);
                } else {
                    output.println(0);
                }

                
                for (int j = 0; j < 4; j++) {
                    output.println(gameMaster.getPlayers()[i].getTokens()[j].getBox().id);
                }
            }
            output.close();

        }
    }
}
