package br.una.view;

import br.una.askgame.Pergunta;
import br.una.data.DB;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Game extends javax.swing.JFrame {
    
    int idPartida;
    ArrayList<Pergunta> perguntas;
    int index = 0;

    public Game() {
        initComponents();
    }
    
    public Game(int idPartida) throws JavaLayerException {
        initComponents();
        this.idPartida = idPartida;
        perguntas = DB.getPerguntas(); // Carrega com as perguntas
        mudaPergunta(index);
        playMusicaFundo();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblLogo = new javax.swing.JLabel();
        lblPergunta = new javax.swing.JLabel();
        lblContaPergunta = new javax.swing.JLabel();
        rdbA = new javax.swing.JRadioButton();
        rdbB = new javax.swing.JRadioButton();
        rdbC = new javax.swing.JRadioButton();
        rdbD = new javax.swing.JRadioButton();
        btnConfirmar = new javax.swing.JButton();
        lblContaJogador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AskGame - Partida");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/una/img/Ask_Game_1.png")));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/una/img/Ask_Game_1.png"))); // NOI18N

        lblPergunta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPergunta.setText("(PERGUNTA AQUI)");

        lblContaPergunta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblContaPergunta.setText("Pergunta 1");

        buttonGroup1.add(rdbA);
        rdbA.setText("(resposta A)");

        buttonGroup1.add(rdbB);
        rdbB.setText("(resposta B)");

        buttonGroup1.add(rdbC);
        rdbC.setText("(resposta C)");

        buttonGroup1.add(rdbD);
        rdbD.setText("(resposta D)");

        btnConfirmar.setText("Confirmar resposta");
        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseClicked(evt);
            }
        });

        lblContaJogador.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblContaJogador.setText("- Jogador 1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPergunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnConfirmar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdbD)
                                    .addComponent(rdbA)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblContaPergunta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblContaJogador)))
                                .addGap(0, 1047, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbB)
                            .addComponent(rdbC))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblContaPergunta)
                            .addComponent(lblContaJogador))))
                .addGap(37, 37, 37)
                .addComponent(lblPergunta, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(rdbA)
                .addGap(31, 31, 31)
                .addComponent(rdbB)
                .addGap(35, 35, 35)
                .addComponent(rdbC)
                .addGap(33, 33, 33)
                .addComponent(rdbD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(btnConfirmar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseClicked
        if(index < 15){
            index++;
        }
        
        mudaPergunta(index);
    }//GEN-LAST:event_btnConfirmarMouseClicked

    private void playMusicaFundo() throws JavaLayerException{
        // Música de fundo
        FileInputStream musicaFundo = null;
        Player player = null;
        try {
            musicaFundo = new FileInputStream("src/br/una/sound/fundo.mp3");
            player = new Player(musicaFundo);
            player.play();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void mudaPergunta(int i){       
        
        if(i%2 == 0 && i != 0){
            lblContaJogador.setText("- Jogador 2");
        } else {
            lblContaJogador.setText("- Jogador 1");
        }
        
        lblContaPergunta.setText("Pergunta "+(i+1));
        
        lblPergunta.setText(perguntas.get(i).getEnunciado());
        rdbA.setText(perguntas.get(i).getAlternativaA().getDescricao());
        rdbB.setText(perguntas.get(i).getAlternativaB().getDescricao());
        rdbC.setText(perguntas.get(i).getAlternativaC().getDescricao());
        rdbD.setText(perguntas.get(i).getAlternativaD().getDescricao());
    }
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);                
            }
        });     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lblContaJogador;
    private javax.swing.JLabel lblContaPergunta;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPergunta;
    private javax.swing.JRadioButton rdbA;
    private javax.swing.JRadioButton rdbB;
    private javax.swing.JRadioButton rdbC;
    private javax.swing.JRadioButton rdbD;
    // End of variables declaration//GEN-END:variables
}
