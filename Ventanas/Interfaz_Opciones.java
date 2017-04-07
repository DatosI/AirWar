/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Image;
import java.awt.Toolkit;



/**
 *
 * @author emers
 */
public class Interfaz_Opciones extends javax.swing.JFrame {
    private boolean estado=false;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    private final Interfaz VentanaPrincipal;
    /**
     * Creates new form Interfaz
     */
    public Interfaz_Opciones( Interfaz VentanaPrincipal) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.VentanaPrincipal=VentanaPrincipal;
    }
    
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Usuario.png"));
        return retValue;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        Boton_Volver = new javax.swing.JButton();
        Control = new javax.swing.JButton();
        Notificacion = new javax.swing.JTextField();
        JLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Titulo.setForeground(new java.awt.Color(204, 204, 204));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Opciones");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 990, 70));

        Boton_Volver.setBackground(new java.awt.Color(0, 102, 153));
        Boton_Volver.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Boton_Volver.setForeground(new java.awt.Color(204, 204, 204));
        Boton_Volver.setText("Volver");
        Boton_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 90, 40));

        Control.setBackground(new java.awt.Color(0, 102, 153));
        Control.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Control.setForeground(new java.awt.Color(204, 204, 204));
        Control.setText("Conectar Control");
        Control.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControlActionPerformed(evt);
            }
        });
        getContentPane().add(Control, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 300, 50));

        Notificacion.setBackground(new java.awt.Color(204, 204, 204));
        Notificacion.setText("Desconectado");
        Notificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotificacionActionPerformed(evt);
            }
        });
        getContentPane().add(Notificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 300, 40));

        JLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/oiLHQw (1).jpg"))); // NOI18N
        JLabelFondo.setText("jLabel1");
        getContentPane().add(JLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 1040, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_VolverActionPerformed
        VentanaPrincipal.setVisible(true);
        VentanaPrincipal.setEstado(true);
        VentanaPrincipal.setEstado2(true);
        this.setVisible(false);
        this.setEstado(false);
    }//GEN-LAST:event_Boton_VolverActionPerformed

    private void NotificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificacionActionPerformed
        String aviso = (Notificacion.getText());
        
    }//GEN-LAST:event_NotificacionActionPerformed

    private void ControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControlActionPerformed
        this.setEstado(true);
        Notificacion.setText("Conectando...");
    }//GEN-LAST:event_ControlActionPerformed

    public void avisar(){
        Notificacion.setText("Conectado");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_Volver;
    private javax.swing.JButton Control;
    private javax.swing.JLabel JLabelFondo;
    private javax.swing.JTextField Notificacion;
    private javax.swing.JLabel Titulo;
    // End of variables declaration//GEN-END:variables
}
