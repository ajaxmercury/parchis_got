
package GUI;

import Clases.CFileManager;
import Clases.CGameMaster;

import Clases.CPlayer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.help.JHelp;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class CMainFrame extends javax.swing.JFrame {

    CGameMaster gameMaster;
    CBoard board;
    CDice dado;
    CCredits newVentana;
    CFileManager gestor;

    public CMainFrame(CGameMaster gameMaster) {
        initComponents();
        this.gameMaster = gameMaster;

        newVentana = new CCredits(this, true);

        initMyComponents();
        this.setLocationRelativeTo(this);
    }

    public void updateData(String jugador, String msg, Color c) {
        TFjugador.setText(jugador);
        TFactionText.setText(msg);
        JPinfo.setBackground(c);
    }

    private void initMyComponents() {
        
        board = gameMaster.getBoard();

        board.setSize(600, 600);
        board.setVisible(true);
        this.add(board);

        dado = new CDice(gameMaster);
        dado.setVisible(true);
        dado.setLocation(300 - 25, 300 - 25);
        dado.setSize(50, 50);
        this.add(dado);

        
        JPinfo.setSize(this.getWidth(), TFjugador.getHeight());

        
        this.setSize(600 + 12, barraDeMenu.getHeight() + 600 + 32 + JPinfo.getHeight() + 5);
        this.setResizable(false);

    }

    public void ShowHelp() {

        try {
            HelpSet helpset = null;
            JFrame helpWindow = new JFrame("Ayuda del juego");
            URL hsURL = this.getClass().getResource("/help/help_set.hs");
            helpset = new HelpSet(null, hsURL);
            JHelp help = new JHelp(helpset);
            helpWindow.setContentPane(help);
            help.setNavigatorDisplayed(true);
            helpWindow.pack();
            //ventanaAyuda.setIconImage(new ImageIcon(getClass().getResource("/Vista/Iconos/question_mark_16.png")).getImage());
            helpWindow.setLocationRelativeTo(null);
            helpWindow.setVisible(true);
        } catch (HelpSetException e) {
            JOptionPane.showMessageDialog(this, "No es posible mostrar la ayuda " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void BeginGame() {

        if (gameMaster.getStatus() != 0) {
            int opt = JOptionPane.showConfirmDialog(this, "Quieres Guardar El Juego?", "Información", JOptionPane.OK_CANCEL_OPTION);
            if (opt == JOptionPane.OK_OPTION) {
                try {
                    CFileManager.saveFile(gameMaster, this);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "Archivo No Encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Leyendo Error", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            gameMaster.endGame();

        }

        CPlayer[] players = new CPlayer[4];
        JDPlayersSelector dPlayersSelector = new JDPlayersSelector(this, true, players);
        dPlayersSelector.setLocationRelativeTo(this);
        dPlayersSelector.setVisible(true);
        int cont = 0;
        if (players[0] != null) {
            for (CPlayer player : players) {
                if (player != null) {
                    cont++;
                }
            }
        }

        gameMaster.nPlayers = cont;
        gameMaster.setPlayers(players);
        gameMaster.newGame(cont);

        gameMaster.getBoard().paint(gameMaster.getBoard().getGraphics());

    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        JPinfo = new javax.swing.JPanel();
        TFjugador = new javax.swing.JLabel();
        TFactionText = new javax.swing.JLabel();
        barraDeMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemJuegoNuevo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSalvar = new javax.swing.JMenuItem();
        jMenuItemCargar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parchís GoT 1.0");
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JPinfo.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), null));
        JPinfo.setPreferredSize(new java.awt.Dimension(452, 20));

        TFjugador.setText("Jugador");

        TFactionText.setText("Acción");

        javax.swing.GroupLayout JPinfoLayout = new javax.swing.GroupLayout(JPinfo);
        JPinfo.setLayout(JPinfoLayout);
        JPinfoLayout.setHorizontalGroup(
            JPinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPinfoLayout.createSequentialGroup()
                .addComponent(TFjugador)
                .addGap(168, 168, 168)
                .addComponent(TFactionText)
                .addContainerGap(220, Short.MAX_VALUE))
        );
        JPinfoLayout.setVerticalGroup(
            JPinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(TFjugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TFactionText, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE))
        );

        jMenu1.setText("Juego");

        jMenuItemJuegoNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/new.png"))); // NOI18N
        jMenuItemJuegoNuevo.setText("Nuevo Juego");
        jMenuItemJuegoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemJuegoNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemJuegoNuevo);
        jMenu1.add(jSeparator1);

        jMenuItemSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/save.png"))); // NOI18N
        jMenuItemSalvar.setText("Guardar Juego");
        jMenuItemSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalvarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSalvar);

        jMenuItemCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/open.png"))); // NOI18N
        jMenuItemCargar.setText("Continuar Juego");
        jMenuItemCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCargarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCargar);
        jMenu1.add(jSeparator2);

        jMenuItemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/close.png"))); // NOI18N
        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSalir);

        barraDeMenu.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/help.png"))); // NOI18N
        jMenuItem1.setText("Ayuda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/about.png"))); // NOI18N
        jMenuItem5.setText("Acerca de...");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        barraDeMenu.add(jMenu2);

        setJMenuBar(barraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPinfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(342, Short.MAX_VALUE)
                .addComponent(JPinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private void jMenuItemJuegoNuevoActionPerformed(java.awt.event.ActionEvent evt) {
        BeginGame();
    }

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        ShowHelp();
    }

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {
        newVentana.setLocationRelativeTo(this);
        newVentana.setVisible(true);
    }

    private void jMenuItemSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (gameMaster.getStatus() == 0) {
                JOptionPane.showMessageDialog(this, "No has inciado ningun juego", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                CFileManager.saveFile(gameMaster, this);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Archivo No Encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Leyendo Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jMenuItemCargarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (gameMaster.getStatus() != 0) {
                

                int opt = JOptionPane.showConfirmDialog(this, "Te gustaria guardar el juego?", "Informacion", JOptionPane.YES_NO_OPTION);
                if (opt == JOptionPane.OK_OPTION) {
                    try {
                        gameMaster.endGame();
                        CFileManager.loadGameFromFile(gameMaster, this);
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(this, "Archivo No Encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Leyendo Error", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                try {
                    CFileManager.loadGameFromFile(gameMaster, this);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "Archivo No encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Leyendo Error", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
            
        }
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {

    }



    private javax.swing.JPanel JPinfo;
    private javax.swing.JLabel TFactionText;
    private javax.swing.JLabel TFjugador;
    private javax.swing.JMenuBar barraDeMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItemCargar;
    private javax.swing.JMenuItem jMenuItemJuegoNuevo;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenuItem jMenuItemSalvar;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;


}
