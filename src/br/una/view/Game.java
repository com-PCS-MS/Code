package br.una.view;

import br.una.askgame.Pergunta;
import br.una.askgame.Personagem;
import br.una.data.DB;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Game extends javax.swing.JFrame {
    
    int idPartida;
    ArrayList<Pergunta> perguntas;
    Personagem personagem1;
    Personagem personagem2;
    
    int index = 0;
    
    int acertosJogador1 = 0;
    int acertosJogador2 = 0;
    int errosJogador1 = 0;
    int errosJogador2 = 0;
    
    Clip clip;
    AudioInputStream audioInputStream;

    public Game() {
        initComponents();
    }
    
    public Game(int idPartida, Personagem personagem1, Personagem personagem2) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        initComponents();
        this.idPartida = idPartida;
        this.personagem1 = personagem1;
        this.personagem2 = personagem2;
        perguntas = DB.getPerguntas(); // Carrega com as perguntas
        mudaPergunta(index); 
        
        audioInputStream = AudioSystem.getAudioInputStream(new File("src/br/una/sound/fundo.wav").getAbsoluteFile());          
        clip = AudioSystem.getClip();      
        clip.open(audioInputStream);       
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
    }
    
    private void tocaSomAcerto() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        AudioInputStream aisAcerto = AudioSystem.getAudioInputStream(new File("src/br/una/sound/respostaCerta.wav").getAbsoluteFile());          
        Clip clipAcerto = AudioSystem.getClip();      
        clipAcerto.open(aisAcerto);       
        clipAcerto.start();
    }
    
    private void tocaSomErro() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        AudioInputStream aisAcerto = AudioSystem.getAudioInputStream(new File("src/br/una/sound/respostaErrada.wav").getAbsoluteFile());          
        Clip clipAcerto = AudioSystem.getClip();      
        clipAcerto.open(aisAcerto);       
        clipAcerto.start();
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
        lblContaJogador1 = new javax.swing.JLabel();
        lblVida = new javax.swing.JLabel();

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

        lblContaJogador1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblContaJogador1.setText("- vida:");

        lblVida.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPergunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbD)
                            .addComponent(rdbA)
                            .addComponent(rdbB)
                            .addComponent(rdbC)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblContaPergunta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblContaJogador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblContaJogador1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblVida)))
                        .addGap(0, 925, Short.MAX_VALUE)))
                .addContainerGap())
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
                            .addComponent(lblContaJogador)
                            .addComponent(lblContaJogador1)
                            .addComponent(lblVida))))
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
        if(personagem1.getVida() <= 0){
            if(JOptionPane.showOptionDialog(
                null, 
                "O jogador 1 perdeu todas suas vidas, vitória do jogador 2!", 
                "Vitória do jogador 2!", 
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                null,
                null
            ) != -1){ System.exit(0); } else { System.exit(0); }
        } else if(personagem2.getVida() <= 0){
            if(JOptionPane.showOptionDialog(
                null, 
                "O jogador 2 perdeu todas suas vidas, vitória do jogador 1!", 
                "Vitória do jogador 1!", 
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                null,
                null
            ) != -1){ System.exit(0); } else { System.exit(0); }
        } else {
            if(!rdbA.isSelected() && !rdbB.isSelected() && !rdbC.isSelected() && !rdbD.isSelected()){
                JOptionPane.showMessageDialog(null, "Você deve selecionar ao menos uma opção.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else{        
                // Execução das habilidades
                switch(index){
                    case 3: {
                        JOptionPane.showMessageDialog(
                            null, 
                            "Se você errar esta questão seu personagem perderá 60 de vida", 
                            "Fique atento!", 
                            JOptionPane.INFORMATION_MESSAGE
                        );                    
                        break;
                    }
                    case 6: {
                        JOptionPane.showMessageDialog(
                            null, 
                            "Se você errar esta questão seu personagem perderá 60 de vida", 
                            "Fique atento!", 
                            JOptionPane.INFORMATION_MESSAGE
                        );                    
                        break;
                    }
                    case 9: {
                        JOptionPane.showMessageDialog(
                            null, 
                            "Se você acertar esta questão seu personagem ganhará 21 de vida", 
                            "Fique atento!", 
                            JOptionPane.INFORMATION_MESSAGE
                        );                     
                        break;
                    } 
                    case 12: {
                        JOptionPane.showMessageDialog(
                            null, 
                            "Se você acertar esta questão seu personagem ganhará 21 de vida", 
                            "Fique atento!", 
                            JOptionPane.INFORMATION_MESSAGE
                        );                    
                        break;
                    }
                    case 14: {
                        JOptionPane.showMessageDialog(
                            null, 
                            "Se você acertar esta questão seu personagem perderá 60 de vida", 
                            "Fique atento!", 
                            JOptionPane.INFORMATION_MESSAGE
                        );                      
                        break;
                    } 
                    case 15: {
                        JOptionPane.showMessageDialog(
                            null, 
                            "Se você errar esta questão seu personagem perderá 60 de vida", 
                            "Fique atento!", 
                            JOptionPane.INFORMATION_MESSAGE
                        );                      
                        break;
                    }             
                }        
                // Verifica se existe campo vazio e se resposta está correta
                if(rdbA.isSelected() && perguntas.get(index).getRespostaCerta().equals("A")){
                    somaAcertos(index);
                    try {
                        tocaSomAcerto();
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if(rdbB.isSelected() && perguntas.get(index).getRespostaCerta().equals("B")){
                    somaAcertos(index);
                    try {
                        tocaSomAcerto();
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if(rdbC.isSelected() && perguntas.get(index).getRespostaCerta().equals("C")){
                    somaAcertos(index);
                    try {
                        tocaSomAcerto();
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if(rdbD.isSelected() && perguntas.get(index).getRespostaCerta().equals("D")){
                    somaAcertos(index);
                    try {
                        tocaSomAcerto();
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else{
                    somaErros(index);              

                    // Execução das habilidades
                    switch(index){
                        case 3: {
                            mudaVida(index, 60, "perde");                     
                            break;
                        }
                        case 6: {
                            mudaVida(index, 60, "perde");                    
                            break;
                        }
                        case 9: {
                            mudaVida(index, 21, "soma");                      
                            break;
                        } 
                        case 12: {
                            mudaVida(index, 21, "soma");                       
                            break;
                        }
                        case 14: {
                            mudaVida(index, 60, "perde");                      
                            break;
                        } 
                        case 15: {
                            mudaVida(index, 60, "perde");                     
                            break;
                        }
                        default: {
                            mudaVida(index, 7, "perde");
                            break;
                        }
                    }                                   

                    try {
                        tocaSomErro();
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
                // Aumento do index para troca de questão e exibe painel de término
                if(index < 13){
                    index++;
                    mudaPergunta(index);
                } else if(index >= 13){
                    if(acertosJogador1 > acertosJogador2){
                        if(JOptionPane.showOptionDialog(
                            null, 
                            "Vitória do jogador 1, acompanhe o placar: \n\n"
                                    +"Acertos jogador 1: "+acertosJogador1+"\nErros jogador 1: "+errosJogador1+
                                    "\n\nAcertos jogador 2: "+acertosJogador2+"\nErros jogador 2: "+errosJogador2+"\n\n", 
                            "Partida finalizada!", 
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            null
                        ) != -1){ System.exit(0); } else { System.exit(0); }
                    } else {
                        if(JOptionPane.showOptionDialog(
                            null, 
                            "Vitória do jogador 2, acompanhe o placar: \n\n"
                                    +"Acertos jogador 1: "+acertosJogador1+"\nErros jogador 1: "+errosJogador1+
                                    "\n\nAcertos jogador 2: "+acertosJogador2+"\nErros jogador 2: "+errosJogador2+"\n\n", 
                            "Partida finalizada!", 
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            null
                        ) != -1){ System.exit(0); } else { System.exit(0); }
                    }            
                }
            }
        }                                  
    }//GEN-LAST:event_btnConfirmarMouseClicked
    
    private void somaAcertos(int i){
        if(i%2==0 || i==0){
            acertosJogador1++;
        } else {
            acertosJogador2++;            
        }
    }
    
    private void somaErros(int i){
        if(i%2==0 || i==0){
            errosJogador1++;
        } else {
            errosJogador2++;
        }
    }
    
    private void mudaVida(int i, int quantidade, String operacao){
        if(i%2==0 || i==0){             
            if(operacao.equals("soma")){
                personagem1.setVida(personagem1.getVida()+quantidade);
            } else {
                personagem1.setVida(personagem1.getVida()-quantidade);
            }
        } else {
            if(operacao.equals("soma")){
                personagem2.setVida(personagem2.getVida()+quantidade);
            } else {
                personagem2.setVida(personagem2.getVida()-quantidade);
            }             
        }
    }
    
    private void mudaPergunta(int i){               
        if(i%2==0 || i==0){
            lblContaJogador.setText("- Jogador 1");
            lblVida.setText(Integer.toString(personagem1.getVida()));
        } else {            
            lblContaJogador.setText("- Jogador 2");
            lblVida.setText(Integer.toString(personagem2.getVida()));
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
        java.awt.EventQueue.invokeLater(() -> {
            new Game().setVisible(true);            
        });                     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lblContaJogador;
    private javax.swing.JLabel lblContaJogador1;
    private javax.swing.JLabel lblContaPergunta;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPergunta;
    private javax.swing.JLabel lblVida;
    private javax.swing.JRadioButton rdbA;
    private javax.swing.JRadioButton rdbB;
    private javax.swing.JRadioButton rdbC;
    private javax.swing.JRadioButton rdbD;
    // End of variables declaration//GEN-END:variables
}