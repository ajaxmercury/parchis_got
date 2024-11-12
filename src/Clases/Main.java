

package Clases;


import GUI.CMainFrame;


public class Main {

    static int c;

    public static void main(String[] args) {

        CGameMaster gameMaster = new CGameMaster();
        CMainFrame game = new CMainFrame(gameMaster);
        game.setVisible(true);

        gameMaster.setMainFrame(game);

      



    }

}
