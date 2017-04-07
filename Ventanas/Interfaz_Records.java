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
public class Interfaz_Records extends javax.swing.JFrame {

    private final Interfaz VentanaPrincipal;
    /**
     * Creates new form Interfaz
     */
    public Interfaz_Records(Interfaz VentanaPrincipal) {
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        JLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Titulo.setForeground(new java.awt.Color(204, 204, 204));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Records");
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

        jScrollPane2.setViewportView(jLabel2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 202, 610, 230));

        JLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/oiLHQw (1).jpg"))); // NOI18N
        JLabelFondo.setText("jLabel1");
        getContentPane().add(JLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 1040, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_VolverActionPerformed
        VentanaPrincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Boton_VolverActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_Volver;
    private javax.swing.JLabel JLabelFondo;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
