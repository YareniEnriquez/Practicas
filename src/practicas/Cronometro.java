package practicas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author sandy
 */
public class Cronometro extends javax.swing.JFrame {

    private Timer tiempo;
    private int centecimas_segundos = 0;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;
    
private ActionListener acciones = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            centecimas_segundos ++;
            if (centecimas_segundos == 100){
                segundos ++;
                centecimas_segundos = 0;
            }
            if(segundos == 60){
                minutos ++;
                segundos = 0;
            }
            if(minutos == 60){
                horas ++;
                minutos = 0;
            }
            if(horas == 24){
                horas = 0;
            }
            
            actualizarEtiquetaTiempo();
        }
    
}

private void actualizarEtiquetaTiempo(){
    String texto = (horas<=9?"0":"")+horas+:+(minutos<=9?"0":"")+minutos+:+(segundos<=9?"0":"")+segundos+:+(centecimas_segundos<=9?"0":"")+centecimas_segundos;
    etiqueta_tiempo.setText("texto");
}
    
    
    public Cronometro() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Cronometro");
        tiempo = new Timer(10,acciones);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiqueta_titulo = new javax.swing.JLabel();
        etiqueta_tiempo = new javax.swing.JLabel();
        botonPausar = new javax.swing.JButton();
        botonIniciar = new javax.swing.JButton();
        botonDetener = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Eras Bold ITC", 1, 24)); // NOI18N

        etiqueta_titulo.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 48)); // NOI18N
        etiqueta_titulo.setText("Cronómetro");

        etiqueta_tiempo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        etiqueta_tiempo.setText("00:00:00:00");

        botonPausar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        botonPausar.setText("Pausar");
        botonPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPausarActionPerformed(evt);
            }
        });

        botonIniciar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        botonIniciar.setText("Iniciar");
        botonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarActionPerformed(evt);
            }
        });

        botonDetener.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        botonDetener.setText("Detener");
        botonDetener.setEnabled(false);
        botonDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDetenerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(etiqueta_titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(etiqueta_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(botonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(botonPausar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(botonDetener, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiqueta_titulo)
                .addGap(18, 18, 18)
                .addComponent(etiqueta_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonPausar)
                    .addComponent(botonDetener)
                    .addComponent(botonIniciar))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarActionPerformed
        // TODO add your handling code here:
        tiempo.start();
        botonIniciar.setEnabled(false);
        botonIniciar.setText("Reaunudar");
        botonDetener.setEnabled(true);
        botonPausar.setEnabled(true);
    }//GEN-LAST:event_botonIniciarActionPerformed

    private void botonDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDetenerActionPerformed
        // TODO add your handling code here:
        if(tiempo.isRunning()){
            tiempo.stop();
        }
        
        centecimas_segundos = 0;
        segundos = 0;
        minutos = 0;
        horas = 0;
        
        actualizarEtiquetaTiempo();
        botonIniciar.setText("Iniciar");
        botonIniciar.setEnabled(false);
        botonPausar.setEnabled(true);
        botonDetener.setEnabled(true);
        
    }//GEN-LAST:event_botonDetenerActionPerformed

    private void botonPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPausarActionPerformed
        // TODO add your handling code here:
        tiempo.stop();
        botonIniciar.setEnabled(true);
    }//GEN-LAST:event_botonPausarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cronometro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonDetener;
    private javax.swing.JButton botonIniciar;
    private javax.swing.JButton botonPausar;
    private javax.swing.JLabel etiqueta_tiempo;
    private javax.swing.JLabel etiqueta_titulo;
    // End of variables declaration//GEN-END:variables
}
