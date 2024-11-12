
package GUI;

import Clases.CPlayer;
import Clases.CAIPlayerKnight;
import Clases.CAIPlayerSquire;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Arrays;
import javax.swing.JOptionPane;


public class JDPlayersSelector extends javax.swing.JDialog {

    CPlayer[] players;

    int nPlayers;

    String[] houses = {
        "Vacio",
        "Night King",
        "Stark",
        "Baratheon",
        "Lanister",
        "Targaryen",
        "Arryn",
        "Martell",
        "Tyrell",
        "Greyjoy",
        "Tully"
    };

    
    public JDPlayersSelector(CMainFrame parent, boolean modal, CPlayer[] players) {
        super(parent, modal);
        initComponents();
        this.players = players;
        this.nPlayers = 0;

        this.setLocationRelativeTo(this);
    }

    public void marcarJugadores() {
        if (PlayerSelector2.getSelectedIndex() != 0) {
            jComboBox2.setEnabled(true);
            jTextField2.setEnabled(true);
        } else {
            jComboBox2.setEnabled(false);
            jTextField2.setEnabled(false);
        }

        if (PlayerSelector3.getSelectedIndex() != 0) {
            jComboBox3.setEnabled(true);
            jTextField3.setEnabled(true);
        } else {
            jComboBox3.setEnabled(false);
            jTextField3.setEnabled(false);
        }

        if (PlayerSelector4.getSelectedIndex() != 0) {
            jComboBox4.setEnabled(true);
            jTextField4.setEnabled(true);
        } else {
            jComboBox4.setEnabled(false);
            jTextField4.setEnabled(false);
        }
    }

  
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        PlayerSelector1 = new javax.swing.JComboBox();
        PlayerSelector2 = new javax.swing.JComboBox();
        PlayerSelector3 = new javax.swing.JComboBox();
        PlayerSelector4 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Escoger Jugadores");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Escoger Jugadores", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 36))); // NOI18N
        jPanel1.setName(""); 

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Escoger Casita (equipo) --", "Night King", "Stark", "Baratheon", "Lanister", "Targaryen", "Arryn", "Martell", "Tyrell", "Greyjoy", "Tully" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Escoger Casita (equipo) --", "Night King", "Stark", "Baratheon", "Lanister", "Targaryen", "Arryn", "Martell", "Tyrell", "Greyjoy", "Tully" }));
        jComboBox2.setEnabled(false);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Escoger Casita (equipo) --", "Night King", "Stark", "Baratheon", "Lanister", "Targaryen", "Arryn", "Martell", "Tyrell", "Greyjoy", "Tully" }));
        jComboBox3.setEnabled(false);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Escoger Casita (equipo) --", "Night King", "Stark", "Baratheon", "Lanister", "Targaryen", "Arryn", "Martell", "Tyrell", "Greyjoy", "Tully" }));
        jComboBox4.setEnabled(false);

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("LIMPIAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setText("Nombre...");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });

        jTextField2.setText("Nombre...");
        jTextField2.setEnabled(false);
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });

        jTextField3.setText("Nombre...");
        jTextField3.setEnabled(false);
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });

        jTextField4.setText("Nombre...");
        jTextField4.setToolTipText("");
        jTextField4.setEnabled(false);
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        PlayerSelector1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Humanoo", "AI escudero", "AI caballero" }));

        PlayerSelector2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Choose type --", "Humanoo", "AI escudero", "AI caballero" }));
        PlayerSelector2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayerSelector2ActionPerformed(evt);
            }
        });

        PlayerSelector3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Choose type --", "Humanoo", "AI escudero", "AI caballero" }));
        PlayerSelector3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayerSelector3ActionPerformed(evt);
            }
        });

        PlayerSelector4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Choose type --", "Humanoo", "AI escudero", "AI caballero" }));
        PlayerSelector4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayerSelector4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PlayerSelector3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PlayerSelector1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PlayerSelector2, javax.swing.GroupLayout.Alignment.LEADING, 0, 117, Short.MAX_VALUE)
                    .addComponent(PlayerSelector4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4)
                    .addComponent(jTextField3)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, 164, Short.MAX_VALUE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlayerSelector1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlayerSelector2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlayerSelector3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlayerSelector4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jButton1.getAccessibleContext().setAccessibleName("OK");
        jButton1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Escoger Jugadores");
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

        jTextField1.setText("Nombre...");
        jTextField2.setText("Nombre...");
        jTextField3.setText("Nombre...");
        jTextField4.setText("Nombre...");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
       
        int cont = 1;
        String name = "";
        int house = 0;

      
        if ((name = jTextField1.getText()).isEmpty() || jComboBox1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Información Incompleta", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        house = Arrays.asList(houses).indexOf((String) jComboBox1.getSelectedItem());

        
        switch (PlayerSelector1.getSelectedIndex()) {
            case 0:
                players[0] = new CPlayer(0, name, house, false);
                break;
            case 1:
                players[0] = (new CAIPlayerSquire(0, name, house));
                break;
            case 2:
                players[0] = (new CAIPlayerKnight(0, name, house));
                break;
        }

        this.nPlayers = 1;

        
        if (PlayerSelector2.getSelectedIndex() != 0) {
            
            if ((name = jTextField2.getText()).isEmpty() || jComboBox2.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Informacion Incompleta", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                cont++;

                house = Arrays.asList(houses).indexOf((String) jComboBox2.getSelectedItem());

                
                switch (PlayerSelector2.getSelectedIndex()) {
                    case 1:
                        players[1] = new CPlayer(0, name, house, false);
                        break;
                    case 2:
                        players[1] = (new CAIPlayerSquire(0, name, house));
                        break;
                    case 3:
                        players[1] = (new CAIPlayerKnight(0, name, house));
                        break;
                }
            }

            this.nPlayers = 2;
        }
        
        if (PlayerSelector3.getSelectedIndex() != 0) {
            
            if ((name = jTextField3.getText()).isEmpty() || jComboBox3.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Informacion Incompleta", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                cont++;

                house = Arrays.asList(houses).indexOf((String) jComboBox3.getSelectedItem());

                
                switch (PlayerSelector3.getSelectedIndex()) {
                    case 1:
                        players[2] = new CPlayer(0, name, house, false);
                        break;
                    case 2:
                        players[2] = (new CAIPlayerSquire(0, name, house));
                        break;
                    case 3:
                        players[2] = (new CAIPlayerKnight(0, name, house));
                        break;
                }
            }

            this.nPlayers = 3;
        }
        
        if (PlayerSelector4.getSelectedIndex() != 0) {
            
            if ((name = jTextField4.getText()).isEmpty() || jComboBox4.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Datos incompletos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                cont++;

                house = Arrays.asList(houses).indexOf((String) jComboBox4.getSelectedItem());

                
                switch (PlayerSelector4.getSelectedIndex()) {
                    case 1:
                        players[3] = new CPlayer(0, name, house, false);
                        break;
                    case 2:
                        players[3] = (new CAIPlayerSquire(0, name, house));
                        break;
                    case 3:
                        players[3] = (new CAIPlayerKnight(0, name, house));
                        break;
                }
            }
            this.nPlayers = 4;
        }

        for (int i = 0; i < this.nPlayers; i++) {
            for (int j = 0; j < this.nPlayers; j++) {
                if (i != j && players[i].getHouse() == players[j].getHouse()) {
                    JOptionPane.showMessageDialog(this, "Cada jugador debe escoger una casa diferente", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            switch (i + 1) {
                case 1:
                    if (jTextField1.getText().equals("Nombre...")) {
                        JOptionPane.showMessageDialog(this, "Jugador 1 debe tener un nombre", "Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    break;
                case 2:
                    if (jTextField2.getText().equals("Nombre...")) {
                        JOptionPane.showMessageDialog(this, "Jugador 2 debe tener un nombre", "Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    break;
                case 3:
                    if (jTextField3.getText().equals("Nombre...")) {
                        JOptionPane.showMessageDialog(this, "Jugador 3 debe tener un nombre", "Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    break;
                case 4:
                    if (jTextField4.getText().equals("Nombre...")) {
                        JOptionPane.showMessageDialog(this, "Jugador 4 debe tener un nombre", "Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    break;
            }
        }

        dispose();
    }

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {
        jTextField1.setText(null);
    }

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {
        jTextField2.setText(null);
    }

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {
        jTextField3.setText(null);
    }

    private void jTextField4FocusGained(java.awt.event.FocusEvent evt) {
        jTextField4.setText(null);
    }

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {
        if (jTextField1.getText().equals(null)) {
            jTextField1.setText("Nombre...");
        }

    }

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {
        if (jTextField2.getText().equals(null)) {
            jTextField2.setText("Nombre...");
        }
    }

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {
        if (jTextField3.getText().equals(null)) {
            jTextField3.setText("Nombre...");
        }
    }

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {
        if (jTextField4.getText().equals(null)) {
            jTextField4.setText("Nombre...");
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        this.players = new CPlayer[4];
        dispose();
    }

    private void PlayerSelector2ActionPerformed(java.awt.event.ActionEvent evt) {
        marcarJugadores();
    }

    private void PlayerSelector3ActionPerformed(java.awt.event.ActionEvent evt) {
        marcarJugadores();
    }

    private void PlayerSelector4ActionPerformed(java.awt.event.ActionEvent evt) {
        marcarJugadores();
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {

    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }



    
    private javax.swing.JComboBox PlayerSelector1;
    private javax.swing.JComboBox PlayerSelector2;
    private javax.swing.JComboBox PlayerSelector3;
    private javax.swing.JComboBox PlayerSelector4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    

}
