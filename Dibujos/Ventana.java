package Dibujos;

import java.awt.event.*;
import javax.swing.JFrame;

import com.sun.prism.paint.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Ventana extends JFrame implements WindowListener {
    public Image imagennave;
    public Image imagenfondo;
    public int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    public int alto= java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public Ventana(String title){
            
            super(title);							//Se situa en el constructor actual del padre Jframe
            setSize(500,500);
            setBackground(java.awt.Color.black);
            addWindowListener(this);       					//Poder reconocer acciones
            
            this.setLocationRelativeTo(null);
            isUndecorated();
            ImageIcon img=new ImageIcon(this.getClass().getResource("Usuario.png"));//Ponemos la imagen
            imagennave=img.getImage();
            ImageIcon img2=new ImageIcon(this.getClass().getResource("FondoGif.gif")); 
            imagenfondo=img2.getImage();
            this.setIconImage(imagennave);
            
            
            this.prepareImage(imagenfondo, 0, 0, this);
            
            
            //this.prepareImage(imagennave, WIDTH, HEIGHT, rootPane)
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
