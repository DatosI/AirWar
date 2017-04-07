package Dibujos;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends javax.swing.JPanel implements KeyListener {		//Clase que nos sirve para los dibujos
	
	@SuppressWarnings("rawtypes")
        
        
	ArrayList arreglo;							//Arreglo donde llegan todos los objetos a dibujar
	NaveGrafica nave;
        
	Coordenadas moviendoIzq=new Coordenadas(-25,0);
	Coordenadas moviendoDer=new Coordenadas(25,0);
	Coordenadas moviendoArri=new Coordenadas(0,-25);
	Coordenadas moviendoAbaj=new Coordenadas(0,25);
	Coordenadas moviendoNulo=new Coordenadas(0,0);
	
	@SuppressWarnings("rawtypes")
	public Panel(ArrayList parametro){
		this.arreglo=parametro;						//Lista de varios tipos de objetos
		this.addKeyListener(this);
		setFocusable(true);
                
	}
	public void paint(Graphics g){
                Image imagefondo=nave.imagenfondo;
               
               //this.setContentPane();
                g.create();
                
                int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
                int alto= java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		Dibujable dib;								//Crea objeto tipo dibujable
		Dimension d=getSize();
                g.drawImage(nave.getImagenfondo() , 0, -150, ancho, alto+300, null);
		Image Imagen=createImage(d.width,d.height);
		Graphics buff= Imagen.getGraphics();					//Se le asignan los graficos de parametros
		
                g.drawImage(nave.getImagenfondo() , 0, -150, ancho, alto+300, null);
		for(int i=0;i<arreglo.size();i++){					//Mientras se recorre el arreglo vamos dibujando
			dib=(Dibujable)arreglo.get(i);
			dib.dibujar(buff);						//Pasamos por el buff para que no parpadee
                        setOpaque(false);
                        g.drawImage(Imagen,0,0,null);
                        g.drawImage(nave.getImagenfondo() , 0, -150, ancho, alto+300, this);
                        g.drawImage(nave.getImagenbala(),nave.Bala().getX(),nave.Bala().getY(), null);
                        
                }       
                g.drawImage(nave.getImagenfondo() , 0, -150, ancho, alto+300, null);        
                setOpaque(false);
                g.drawImage(nave.imagennave, nave.getX(), nave.getY(), null);
                
                //g.drawString(nave.Nombre, 50, 50);
                super.paintComponent(g);
                setOpaque(false);
               
	}	
        
	public void update(Graphics g){
		paint(g);	 
	}
	//Metodos de la implementaci�n del KeyListener
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e){					//Acci�n al apretar boton
            int tecla=e.getKeyCode();
            if (tecla==KeyEvent.VK_LEFT){
                this.nave.mover(moviendoIzq);					//Se mueve a la izquierda
            }
            if(tecla==KeyEvent.VK_RIGHT){
                this.nave.mover(moviendoDer);					//Se mueve a la derecha
            }
            if(tecla==KeyEvent.VK_UP){
                this.nave.mover(moviendoArri);
            }
            if(tecla==KeyEvent.VK_DOWN){
                this.nave.mover(moviendoAbaj);
            }
            if(tecla==KeyEvent.VK_SPACE){
		BalaGrafica bala=nave.Bala();
		nave.Bala.add(bala);
		arreglo.add(bala);
                bala.setEstado(true);
            }
	}
	
	@Override
	public void keyReleased(KeyEvent e){					//Acciones al dejar de apretar el boton
	int tecla=e.getKeyCode();
	
	if (tecla==KeyEvent.VK_LEFT){
            this.nave.mover(moviendoNulo);
	}
	if(tecla==KeyEvent.VK_RIGHT){
            this.nave.mover(moviendoNulo);
	}
	if(tecla==KeyEvent.VK_UP){
            this.nave.mover(moviendoNulo);
	}
	if(tecla==KeyEvent.VK_DOWN){
            this.nave.mover(moviendoNulo);
	}
	if(tecla==KeyEvent.VK_SPACE){
        }

	}
	public void refNave(NaveGrafica n){ 					//Modifica la referencia de la nave
            this.nave=n;
	}
	/*public void Colision(){
		int i;
		for(i=0;i<nave.Bala.size();i++){
			BalaGrafica bala=(BalaGrafica)nave.Bala.get(i);		//Cada bala creada se va a comparar con el enemigo
			for(j=0;enemigos.size();j++){				//Recorrer lista de enemigos
				Coordenadas coorbala= new Coordenadas(bala.getX(),bala.getY());
				
			}
		}
	}*/
	public void iniciar(){
            while(true){
                {
                try{                                                            //Por si pasa algun error de memoria y no se caiga el juego
                    if(!nave.Bala.isEmpty()){                                   //Si el arreglo de balas no est� vacio las mueve
                        nave.Ciclo();
                    }
                    Thread.sleep(30);                                           //Hilo de Ejecuci�n, cada 50ms								
                }
                catch(InterruptedException err){System.out.println(err);}	//Una excepci�n
                repaint();
                }
            }
	}

 
}
