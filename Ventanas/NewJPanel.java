/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author emers
 */
public class NewJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public NewJPanel() {
        initComponents();
    }
    


@SuppressWarnings("serial")
public class Ventana extends JFrame implements WindowListener {
	
	public Ventana(String title){
            
            super(title);							//Se situa en el constructor actual del padre Jframe
            setSize(500,500);
            addWindowListener(this);       					//Poder reconocer acciones
            //setBackground(java.awt.Color.BLACK);
            JLabel fondo = new javax.swing.JLabel();
            
           
            
            int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
            int alto= java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
            
            fondo.createImage(ancho,alto);
            fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dibujos/FondoGif.gif")));
           // fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/oiLHQw (1).jpg"))); // NOI18N
           // fondo.setText("jLabel1");
           // getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 0, 1040, 530));
         //  setBounds((ancho / 2) - ( fondo.getWidth() / 2), (alto / 2) - ( fondo.getHeight() / 2),ancho, alto);
         
         

           
            
            
            //
            this.setLocationRelativeTo(null);
	}
        
        public Image getIconImage(){
            Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Usuario.png"));
            return retValue;
        }
														
	
	//Si queremos implementar interfaz Windows listener debemos declarar todos sus metodos
	@Override
	public void windowActivated(WindowEvent arg0) {}
	@Override
	public void windowClosed(WindowEvent arg0) {}
	@Override
	public void windowClosing(WindowEvent arg0)  {System.exit(0);} 		//Para poder cerrar la ventana
	@Override
	public void windowDeactivated(WindowEvent arg0) {}
	@Override
	public void windowDeiconified(WindowEvent arg0) {}
	@Override
	public void windowIconified(WindowEvent arg0) {}
	@Override
	public void windowOpened(WindowEvent arg0) {}

  
  
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dibujos/FondoGif.gif"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
