package Dibujos;


import Ejecuciones.Partida;
import static com.oracle.jrockit.jfr.ContentType.Class;
import enemy.test.ColaEnemigos;
import enemy.test.EnemyTest;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;


@SuppressWarnings("serial")
public class Panel extends javax.swing.JPanel implements KeyListener {		//Clase que nos sirve para los dibujos
    public int level=1;
    public int puntaje=0;
    public int marcador=0;
    public int contador=200;
    public boolean estado=true;
    public  String Nombre= "Nombre";
    public int vidas=3;
    public int powerUp=0; 
    @SuppressWarnings("rawtypes")    
    ArrayList arreglo;                                                          //Arreglo donde llegan todos los objetos a dibujar
    ArrayList arreglo2;
    NaveGrafica nave;
    Coordenadas moviendoIzq=new Coordenadas(-25,0);
    Coordenadas moviendoDer=new Coordenadas(25,0);
    Coordenadas moviendoArri=new Coordenadas(0,-25);
    Coordenadas moviendoAbaj=new Coordenadas(0,25);
    Coordenadas moviendoNulo=new Coordenadas(0,0);
    int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    int alto= java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    ColaEnemigos cola=new ColaEnemigos();
    EnemyTest enemigo;
    EnemyTest enemigo2;
    EnemyTest enemigo3;
    EnemyTest enemigo4;
    Image imagen;
    Image imagen1=imagen;
    Image imagen2=imagen;
    Image imagen3=imagen;
    Image imagen4=imagen;
    int k;



    @SuppressWarnings("rawtypes")
    public Panel(ArrayList parametro) throws InterruptedException{
        this.enemigo = new EnemyTest(1, 7, 3, "Jet.png");                       //kamikaze
    	this.enemigo2 = new EnemyTest(2,10,3,"Jet.png");                         //torre
        this.enemigo3 = new EnemyTest(2,20,3,"Jet.png");                         //bombero
        this.enemigo4 = new EnemyTest(2,10,3,"Jet.png");                         //jet
        this.arreglo=parametro;                                                 //Lista de varios tipos de objetos
    	this.arreglo2=parametro;       
        this.addKeyListener(this);
    	setFocusable(true);
        this.aliniacion();
       // nave.setX(ancho/2 -50);
       // nave.setY(alto-200);
   
    }
    
    public void aliniacion(){
        Random random1 = new Random();
        enemigo.setY(-random1.nextInt(300));
        enemigo.setX(random1.nextInt(1000));
        Random random2 = new Random();
        enemigo2.setY(-random2.nextInt(300));
        enemigo2.setX(random2.nextInt(1000));
        Random random3 = new Random();
        enemigo3.setY(-random3.nextInt(300));
        enemigo3.setX(random3.nextInt(1000));
        Random random4 = new Random();
        enemigo4.setY(-random4.nextInt(300));
        enemigo4.setX(random4.nextInt(1000));
    }
    
//-------------------------------------------------------------------------------------------------------------------------        
    public void vidas(){
        if(marcador==100){
            this.setVidas(this.getVidas()+1);   
        }
        if (marcador>100)
            this.setMarcador(0);
    }
//-------------------------------------------------------------------------------------------------------------------------         
    
    public void enemigos() throws InterruptedException{
            Random random = new Random();
            
            int a = random.nextInt(4);
            if(a == 0) {
                imagen= enemigo.imagenbomber;
            } else if(a == 1) {
                imagen= enemigo.imagenjet;
            } else if(a == 2) {
                imagen= enemigo.imagenkamikazwe;
            } else if(a == 3) {
                imagen= enemigo.imagentower;
            }
            
            
        }
//-------------------------------------------------------------------------------------------------------------------------        
     
    public void paint(Graphics g){
        
        Image imagefondo=nave.imagenfondo;
        g.create();
        int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto= java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
       
        Dibujable dib;                                                          //Crea objeto tipo dibujable
	Dimension d=getSize();
	Image Imagen=createImage(d.width,d.height);
        Graphics buff= Imagen.getGraphics();                                    //Se le asignan los graficos de parametros
        //g.drawImage(nave.getImagenfondo() , 0, -150, ancho, alto+300, null);
       
	for(int i=0;i<arreglo.size();i++){					//Mientras se recorre el arreglo vamos dibujando
            dib=(Dibujable)arreglo.get(i);    
            dib.dibujar(buff);                                                  //Pasamos por el buff para que no parpade
            setOpaque(false);
            g.drawImage(Imagen,0,0,null);
           
          //  g.drawImage(nave.getImagenfondo() , 0, -150, ancho, alto+300, this); 
            
        } 
        setOpaque(false);                     
        //g.drawImage(nave.getImagenfondo() , 0, -150, ancho, alto+300, this);
        
       
       
        
//------------------------------------------------------------------------------------------------------------------------         
//nivel 1     
//------------------------------------------------------------------------------------------------------------------------             
        if (contador<500){
            if (enemigo.getX()<nave.getX()){
                enemigo.setX(enemigo.getX()+8);
                }
                if (enemigo.getX()>nave.getX()){
                    enemigo.setX(enemigo.getX()-8);
                }
                if (enemigo3.getX()<nave.getX()){
                    enemigo3.setX(enemigo3.getX()+3);
                }
                if (enemigo3.getX()>nave.getX()){
                    enemigo3.setX(enemigo3.getX()-3);
                }
                if (enemigo4.getX()<nave.getX()){
                    enemigo4.setX(enemigo4.getX()+6);
                }
                if (enemigo4.getX()>nave.getX()){
                    enemigo4.setX(enemigo4.getX()-6);
                }
                g.drawImage(enemigo.imagenkamikazwe  ,enemigo.getX(), enemigo.getY()-100, 100, 150, this);                          //1
                g.drawImage(enemigo.imagentower ,enemigo2.getX(), enemigo2.getY(), 100, 150, this);                                 //2
                g.drawImage(enemigo.imagenbomber  ,enemigo3.getX(), enemigo3.getY(), 100, 150, this);                               //3
                g.drawImage(enemigo.imagenjet  ,enemigo4.getX(), enemigo4.getY(), 100, 150, this);                                  //4
                if (enemigo.getY()>alto){
                    Random random = new Random();
                    enemigo.setY(-random.nextInt(300));
                    enemigo.setX(random.nextInt(1000));
                }
                if (enemigo2.getY()>alto){
                    Random random = new Random();
                    enemigo2.setY(-random.nextInt(300));
                    enemigo2.setX(random.nextInt(1000));
                }
                if (enemigo3.getY()>alto){
                    Random random = new Random();
                    enemigo3.setY(-random.nextInt(300));
                    enemigo3.setX(random.nextInt(1000));
                }
                if (enemigo4.getY()>alto){
                    Random random = new Random();
                    enemigo4.setY(-random.nextInt(300));
                    enemigo4.setX(random.nextInt(1000));
                
                }        
        }
//------------------------------------------------------------------------------------------------------------------------         
//nivel 2    
//------------------------------------------------------------------------------------------------------------------------             
        if (contador>500 && contador<1000){
            
            if (enemigo.getX()<nave.getX()){
                enemigo.setX(enemigo.getX()+8);
                }
                if (enemigo.getX()>nave.getX()){
                    enemigo.setX(enemigo.getX()-8);
                }
                if (enemigo3.getX()<nave.getX()){
                    enemigo3.setX(enemigo3.getX()+3);
                }
                if (enemigo3.getX()>nave.getX()){
                    enemigo3.setX(enemigo3.getX()-3);
                }
                if (enemigo4.getX()<nave.getX()){
                    enemigo4.setX(enemigo4.getX()+6);
                }
                if (enemigo4.getX()>nave.getX()){
                    enemigo4.setX(enemigo4.getX()-6);
                }
            g.drawImage(enemigo.imagenkamikazwe ,enemigo.getX(), enemigo.getY()-100, 100, 150, this);                           //1
            g.drawImage(enemigo.imagentower, enemigo2.getX(), enemigo2.getY(), 100, 150, this);                                 //2
            g.drawImage(enemigo.imagenbomber ,enemigo3.getX(), enemigo3.getY(), 100, 150, this);                                //3
            g.drawImage(enemigo.imagenjet ,enemigo4.getX(), enemigo4.getY(), 100, 150, this);                                   //4
            if (enemigo.getY()>alto){
                Random random = new Random();
                enemigo.setY(-random.nextInt(300));
                enemigo.setX(random.nextInt(1000));
               
            }
            if (enemigo2.getY()>alto){
                Random random = new Random();
                enemigo2.setY(-random.nextInt(300));
                enemigo2.setX(random.nextInt(1000));
            }
            if (enemigo3.getY()>alto){
                Random random = new Random();
                enemigo3.setY(-random.nextInt(300));
                enemigo3.setX(random.nextInt(1000));
            }
            if (enemigo4.getY()>alto){
                Random random = new Random();
                enemigo4.setY(-random.nextInt(300));
                enemigo4.setX(random.nextInt(1000));   
            } 
            
            enemigo.setVelocidad(15);
            enemigo2.setVelocidad(15);
            enemigo3.setVelocidad(15);
            enemigo4.setVelocidad(15);
            this.level=2;
        }
//------------------------------------------------------------------------------------------------------------------------         
//nivel 3     
//------------------------------------------------------------------------------------------------------------------------             
        if (contador>1000 && contador<2000){
            if (enemigo.getX()<nave.getX()){
                enemigo.setX(enemigo.getX()+8);
                }
                if (enemigo.getX()>nave.getX()){
                    enemigo.setX(enemigo.getX()-8);
                }
                if (enemigo3.getX()<nave.getX()){
                    enemigo3.setX(enemigo3.getX()+3);
                }
                if (enemigo3.getX()>nave.getX()){
                    enemigo3.setX(enemigo3.getX()-3);
                }
                if (enemigo4.getX()<nave.getX()){
                    enemigo4.setX(enemigo4.getX()+6);
                }
                if (enemigo4.getX()>nave.getX()){
                    enemigo4.setX(enemigo4.getX()-6);
                }
            g.drawImage(enemigo.imagenkamikazwe ,enemigo.getX(), enemigo.getY()-100, 100, 150, this);                        //1
            g.drawImage(enemigo.imagentower ,enemigo2.getX(), enemigo2.getY(), 100, 150, this);                              //2
            g.drawImage(enemigo.imagenbomber ,enemigo3.getX(), enemigo3.getY(), 100, 150, this);                             //3
            g.drawImage(enemigo.imagenjet ,enemigo4.getX(), enemigo4.getY(), 100, 150, this);                                //4
            if (enemigo.getY()>alto){
                Random random = new Random();
                enemigo.setY(-random.nextInt(300));
                enemigo.setX(random.nextInt(1000));
            }
            if (enemigo2.getY()>alto){
                Random random = new Random();
                enemigo2.setY(-random.nextInt(300));
                enemigo2.setX(random.nextInt(1000));
            }
            if (enemigo3.getY()>alto){
                Random random = new Random();
                enemigo3.setY(-random.nextInt(300));
                enemigo3.setX(random.nextInt(1000));
            }
            if (enemigo4.getY()>alto){
                Random random = new Random();
                enemigo4.setY(-random.nextInt(300));
                enemigo4.setX(random.nextInt(1000));   
            }  
            enemigo.setVelocidad(10);
            enemigo2.setVelocidad(10);
            enemigo3.setVelocidad(10);
            enemigo4.setVelocidad(10);
            this.level=3;
            
        }
   
//------------------------------------------------------------------------------------------------------------------------         
//nivel 4     
//------------------------------------------------------------------------------------------------------------------------        
        if (contador>2000 && contador<4000){
            if (enemigo.getX()<nave.getX()){
                enemigo.setX(enemigo.getX()+8);
            }
                if (enemigo.getX()>nave.getX()){
                    enemigo.setX(enemigo.getX()-8);
                }
                if (enemigo3.getX()<nave.getX()){
                    enemigo3.setX(enemigo3.getX()+3);
                }
                if (enemigo3.getX()>nave.getX()){
                    enemigo3.setX(enemigo3.getX()-3);
                }
                if (enemigo4.getX()<nave.getX()){
                    enemigo4.setX(enemigo4.getX()+6);
                }
                if (enemigo4.getX()>nave.getX()){
                    enemigo4.setX(enemigo4.getX()-6);
                }
            g.drawImage(enemigo.imagenkamikazwe ,enemigo.getX(), enemigo.getY()-100, 100, 150, this);               //1
            g.drawImage(enemigo.imagentower,enemigo2.getX(), enemigo2.getY(), 100, 150, this);                              //2
            g.drawImage(enemigo.imagenbomber ,enemigo3.getX(), enemigo3.getY(), 100, 150, this);                              //3
            g.drawImage(enemigo.imagenjet ,enemigo4.getX(), enemigo4.getY(), 100, 150, this);                              //4
            if (enemigo.getY()>alto){
                Random random = new Random();
                enemigo.setY(-random.nextInt(300));
                enemigo.setX(random.nextInt(1000));
            }
            if (enemigo2.getY()>alto){
                Random random = new Random();
                enemigo2.setY(-random.nextInt(300));
                enemigo2.setX(random.nextInt(1000));
            }
            if (enemigo3.getY()>alto){
                Random random = new Random();
                enemigo3.setY(-random.nextInt(300));
                enemigo3.setX(random.nextInt(1000));
            }
            if (enemigo4.getY()>alto){
                Random random = new Random();
                enemigo4.setY(-random.nextInt(300));
                enemigo4.setX(random.nextInt(1000));   
            }  
            enemigo.setVelocidad(5);
            enemigo2.setVelocidad(5);
            enemigo3.setVelocidad(5);
            enemigo4.setVelocidad(5);
            this.level=4;
            
        }
//------------------------------------------------------------------------------------------------------------------------         
//nivel 5     
//------------------------------------------------------------------------------------------------------------------------             
            if (contador>4000 && contador<10000){
                if (enemigo.getX()<nave.getX()){
                enemigo.setX(enemigo.getX()+8);
                }
                if (enemigo.getX()>nave.getX()){
                    enemigo.setX(enemigo.getX()-8);
                }
                if (enemigo3.getX()<nave.getX()){
                    enemigo3.setX(enemigo3.getX()+3);
                }
                if (enemigo3.getX()>nave.getX()){
                    enemigo3.setX(enemigo3.getX()-3);
                }
                if (enemigo4.getX()<nave.getX()){
                    enemigo4.setX(enemigo4.getX()+6);
                }
                if (enemigo4.getX()>nave.getX()){
                    enemigo4.setX(enemigo4.getX()-6);
                }
                g.drawImage(enemigo.imagenkamikazwe ,enemigo.getX(), enemigo.getY()-100, 100, 150, this);               //1
                g.drawImage(enemigo.imagentower ,enemigo2.getX(), enemigo2.getY(), 100, 150, this);                     //2
                g.drawImage(enemigo.imagenbomber ,enemigo3.getX(), enemigo3.getY(), 100, 150, this);                 //3
                g.drawImage(enemigo.imagenjet ,enemigo4.getX(), enemigo4.getY(), 100, 150, this);                 //4
                if (enemigo.getY()>alto){
                    Random random = new Random();
                    enemigo.setY(-random.nextInt(300));
                    enemigo.setX(random.nextInt(1000));
                }
                if (enemigo2.getY()>alto){
                    Random random = new Random();
                    enemigo2.setY(-random.nextInt(300));
                    enemigo2.setX(random.nextInt(1000));
                }
                if (enemigo3.getY()>alto){
                    Random random = new Random();
                    enemigo3.setY(-random.nextInt(300));
                    enemigo3.setX(random.nextInt(1000));
                }
                if (enemigo4.getY()>alto){
                    Random random = new Random();
                    enemigo4.setY(-random.nextInt(300));
                    enemigo4.setX(random.nextInt(1000));   
                }  
                enemigo.setVelocidad(1);
                enemigo2.setVelocidad(1);
                enemigo3.setVelocidad(1);
                enemigo4.setVelocidad(1);
                this.level=5;

        }
            
        g.drawImage(nave.getImagennave() , nave.getX(), nave.getY(), 100, 150, this);
        super.paintComponent(g);
        setOpaque(false);      
    }
    
    
    
//-------------------------------------------------------------------------------------------------------------------------        
        
    public void update(Graphics g){
        paint(g);	 
    }  
        
//-------------------------------------------------------------------------------------------------------------------------        
//-----------------------------Metodos de la implementaci�n del KeyListener------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------- 
        
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e){                                         //Acciones al apretar los botones
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
            BalaGrafica bala=nave.Bala();                                       //se crea una nueva bala
            nave.Bala.add(bala);                                                //se agrega esta al arreglo de la nave
            arreglo.add(bala);                                                  //se agrega la bala al arreglo del panel
            arreglo2.add(bala);   
            
            
             
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
        
//-------------------------------------------------------------------------------------------------------------------------



    public void refNave(NaveGrafica n){ 					//Modifica la referencia de la nave
        this.nave=n;
    }
    
    public void destruir_nave(){
        nave.setEstado(false);
    }




//-------------------------------------------------------------------------------------------------------------------------      
    public void Colision(){
              
        if(nave.getX()+100==enemigo.getX()){                                    //si la parte de derecha de la nave es igual que la parte de izquierda del enemigo
            if (nave.getY()+150==enemigo.getY()){                               
                 System.out.print("bum1");
                
                this.setVidas(this.getVidas()-1);
                nave.setX(ancho/2 -50);
                nave.setY(alto-200);
            }
        }
        if(nave.getX()==enemigo.getX()+100){                                    //si la parte de izquierda de la nave es igual que la parte de derecha del enemigo
            if(nave.getY()==enemigo.getY()+150){
                System.out.print("bum2");
             
                this.setVidas(this.getVidas()-1);
                nave.setX(ancho/2 -50);
                nave.setY(alto-200);
                
            }    
        } 
        
        if(nave.getY()==enemigo.getY()+150){
            if(nave.getX()==enemigo.getX()+100){                                //si la parte de izquierda de la nave es igual que la parte de derecha del enemigo
                System.out.print("bum3");
                
                this.setVidas(this.getVidas()-1);
                nave.setX(ancho/2 -50);
                nave.setY(alto-200);
            }
        }    
//-------------------------------------------------------------------------------------------------------------------------         
               
        if(nave.getX()+100>enemigo.getX()){                                     //si la parte de derecha de la nave es mayor que la parte de izquierda del enemigo
            if(nave.getX()+100<enemigo.getX()+100){                             //si la parte de derecha de la nave es menor que la parte de derecha del enemigo
                
                
                if(nave.getY()+150>enemigo.getY()){                             //si la parte de abajo de la nave es mayor que la parte de arriba del enemigo
                    if(nave.getY()+150<enemigo.getY()+150){                     //si la parte de abajo de la nave es menor que la parte de abajo del enemigo
                        System.out.print("bum4");
                        
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                }
                if(nave.getY()<enemigo.getY()+150){                             //si la parte de arriba de la nave es menor q la parte de abajo del enemigo
                    if(nave.getY()>enemigo.getY()){                             //si la parte de arriba de la nave es menor q la parte de arriba del enemigo
                        System.out.print("bum5");
                        
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                } 
                
            }  
        }
        
        if(nave.getX()<enemigo.getX()+100){                                     //si la parte de izquierda de la nave es menor que la parte de derecha del enemigo
            if(nave.getX()>enemigo.getX()){                                     //si la parte de izquierda de la nave es mayor que la parte de izquierda del enemigo
                if(nave.getY()+150>enemigo.getY()){                             //si la parte de abajo de la nave es mayor que la parte de arriba del enemigo
                    if(nave.getY()+150<enemigo.getY()+150){                     //si la parte de abajo de la nave es menor que la parte de abajo del enemigo
                        System.out.print("bum6");
                        
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                }
                /*
                if(nave.getY()<enemigo.getY()+150){                             //si la parte de arriba de la nave esta mas arriba que la parte de abajo del enemigo
                    if(nave.getY()>enemigo.getY()){                             //si la parte de arriba de la nave esta mas abajo que la parte de arriba del enemigo
                        System.out.print("bum7");
                        nave.setEstado(false);
                        this.setEstado(false);
                    }         
                } 
                */
            }  
        }  
       
//-------------------------------------------------------------------------------------------------------------------------        
//-------------------------------------------------------------------------------------------------------------------------        
        if(nave.getY()+150>enemigo.getY()){                                     //si la parte de abajo de la nave es mayor que la parte de arriba del enemigo
            if(nave.getY()+150<enemigo.getY()+150){                             //si la parte de abajo de la nave es menor que la parte de abajo del enemigo
                if(nave.getX()+100>enemigo.getX()){                             //si la parte de derecha de la nave es mayor que la parte de izquierda del enemigo
                    if(nave.getX()+100<enemigo.getX()+100){                     //si la parte de derecha de la nave es menor que la parte de derecha del enemigo
                        System.out.print("bum8");
                        
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                }
                if(nave.getX()<enemigo.getX()+100){                             //si la parte de izquierda de la nave es menor que la parte de derecha del enemigo
                    if(nave.getX()>enemigo.getX()){                             //si la parte de izquierda de la nave es mayor que la parte de izquierda del enemigo
                        System.out.print("bum9");
                        
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                }
            }  
        }          
          
        if(nave.getY()<enemigo.getY()+150){                                     //si la parte de arriba de la nave esta mas arriba que la parte de abajo del enemigo
            if(nave.getY()>enemigo.getY()){                                     //si la parte de arriba de la nave esta mas abajo que la parte de arriba del enemigo
                if(nave.getX()+100>enemigo.getX()){                             //si la parte de derecha de la nave es mayor que la parte de izquierda del enemigo
                    if(nave.getX()+100<enemigo.getX()+100){                     //si la parte de derecha de la nave es menor que la parte de derecha del enemigo
                        System.out.print("bum10");
                     
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                }
                
                if(nave.getX()<enemigo.getX()+100){                             //si la parte de izquierda de la nave es menor que la parte de derecha del enemigo
                    if(nave.getX()>enemigo.getX()){                             //si la parte de izquierda de la nave es mayor que la parte de izquierda del enemigo
                        System.out.print("bum11");
                     
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                }
                
            }  
        } 
//-------------------------------------------------------------------------------------------------------------------        
//------------------------------------------------------------------------------------------------------------------- 
//------------------------------------------------------------------------------------------------------------------- 
//------------------------------------------------------------------------------------------------------------------- 
//------------------------------------------------------------------------------------------------------------------- 


        if(nave.getX()+100==enemigo3.getX()){                                    //si la parte de derecha de la nave es igual que la parte de izquierda del enemigo
            if (nave.getY()+150==enemigo3.getY()){                               
                System.out.print("bum1");
                this.setVidas(this.getVidas()-1);
                nave.setX(ancho/2 -50);
                nave.setY(alto-200);
            }
        }
        if(nave.getX()==enemigo3.getX()+100){                                    //si la parte de izquierda de la nave es igual que la parte de derecha del enemigo
            if(nave.getY()==enemigo3.getY()+150){
                System.out.print("bum2");
               
                this.setVidas(this.getVidas()-1);
                nave.setX(ancho/2 -50);
                nave.setY(alto-200);
                
            }    
        } 
        
        if(nave.getY()==enemigo3.getY()+150){
            if(nave.getX()==enemigo3.getX()+100){                                //si la parte de izquierda de la nave es igual que la parte de derecha del enemigo
                System.out.print("bum3");
              
                this.setVidas(this.getVidas()-1);
                nave.setX(ancho/2 -50);
                nave.setY(alto-200);
            }
        }    
//-------------------------------------------------------------------------------------------------------------------------         
               
        if(nave.getX()+100>enemigo3.getX()){                                     //si la parte de derecha de la nave es mayor que la parte de izquierda del enemigo
            if(nave.getX()+100<enemigo3.getX()+100){                             //si la parte de derecha de la nave es menor que la parte de derecha del enemigo
                if(nave.getY()+150>enemigo3.getY()){                             //si la parte de abajo de la nave es mayor que la parte de arriba del enemigo
                    if(nave.getY()+150<enemigo3.getY()+150){                     //si la parte de abajo de la nave es menor que la parte de abajo del enemigo
                        System.out.print("bum4");
                       
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                }
                if(nave.getY()<enemigo3.getY()+150){                             //si la parte de arriba de la nave es menor q la parte de abajo del enemigo
                    if(nave.getY()>enemigo3.getY()){                             //si la parte de arriba de la nave es menor q la parte de arriba del enemigo
                        System.out.print("bum5");
                    
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                } 
                
            }  
        }
        
        if(nave.getX()<enemigo3.getX()+100){                                     //si la parte de izquierda de la nave es menor que la parte de derecha del enemigo
            if(nave.getX()>enemigo3.getX()){                                     //si la parte de izquierda de la nave es mayor que la parte de izquierda del enemigo
                if(nave.getY()+150>enemigo3.getY()){                             //si la parte de abajo de la nave es mayor que la parte de arriba del enemigo
                    if(nave.getY()+150<enemigo3.getY()+150){                     //si la parte de abajo de la nave es menor que la parte de abajo del enemigo
                        System.out.print("bum6");
                        
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                }
                /*
                if(nave.getY()<enemigo.getY()+150){                             //si la parte de arriba de la nave esta mas arriba que la parte de abajo del enemigo
                    if(nave.getY()>enemigo.getY()){                             //si la parte de arriba de la nave esta mas abajo que la parte de arriba del enemigo
                        System.out.print("bum7");
                        nave.setEstado(false);
                        this.setEstado(false);
                    }         
                } 
                */
            }
//-------------------------------------------------------------------------------------------------------------------        
//------------------------------------------------------------------------------------------------------------------- 
//------------------------------------------------------------------------------------------------------------------- 
//------------------------------------------------------------------------------------------------------------------- 
//------------------------------------------------------------------------------------------------------------------- 


        if(nave.getX()+100==enemigo4.getX()){                                    //si la parte de derecha de la nave es igual que la parte de izquierda del enemigo
            if (nave.getY()+150==enemigo4.getY()){                               
                 System.out.print("bum1");
               
                this.setVidas(this.getVidas()-1);
                nave.setX(ancho/2 -50);
                nave.setY(alto-200);
            }
        }
        if(nave.getX()==enemigo4.getX()+100){                                    //si la parte de izquierda de la nave es igual que la parte de derecha del enemigo
            if(nave.getY()==enemigo4.getY()+150){
                System.out.print("bum2");
               
                this.setVidas(this.getVidas()-1);
                nave.setX(ancho/2 -50);
                nave.setY(alto-200);
                
            }    
        } 
        
        if(nave.getY()==enemigo4.getY()+150){
            if(nave.getX()==enemigo4.getX()+100){                                //si la parte de izquierda de la nave es igual que la parte de derecha del enemigo
                System.out.print("bum3");
               
                this.setVidas(this.getVidas()-1);
                nave.setX(ancho/2 -50);
                nave.setY(alto-200);
            }
        }    
//-------------------------------------------------------------------------------------------------------------------------         
               
        if(nave.getX()+100>enemigo4.getX()){                                     //si la parte de derecha de la nave es mayor que la parte de izquierda del enemigo
            if(nave.getX()+100<enemigo4.getX()+100){                             //si la parte de derecha de la nave es menor que la parte de derecha del enemigo
                
                
                if(nave.getY()+150>enemigo4.getY()){                             //si la parte de abajo de la nave es mayor que la parte de arriba del enemigo
                    if(nave.getY()+150<enemigo4.getY()+150){                     //si la parte de abajo de la nave es menor que la parte de abajo del enemigo
                        System.out.print("bum4");
                        
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                }
                if(nave.getY()<enemigo4.getY()+150){                             //si la parte de arriba de la nave es menor q la parte de abajo del enemigo
                    if(nave.getY()>enemigo4.getY()){                             //si la parte de arriba de la nave es menor q la parte de arriba del enemigo
                        System.out.print("bum5");
                        
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                } 
                
            }  
        }
        
        if(nave.getX()<enemigo4.getX()+100){                                     //si la parte de izquierda de la nave es menor que la parte de derecha del enemigo
            if(nave.getX()>enemigo4.getX()){                                     //si la parte de izquierda de la nave es mayor que la parte de izquierda del enemigo
                if(nave.getY()+150>enemigo4.getY()){                             //si la parte de abajo de la nave es mayor que la parte de arriba del enemigo
                    if(nave.getY()+150<enemigo4.getY()+150){                     //si la parte de abajo de la nave es menor que la parte de abajo del enemigo
                        System.out.print("bum6");
                        
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                }
                /*
                if(nave.getY()<enemigo.getY()+150){                             //si la parte de arriba de la nave esta mas arriba que la parte de abajo del enemigo
                    if(nave.getY()>enemigo.getY()){                             //si la parte de arriba de la nave esta mas abajo que la parte de arriba del enemigo
                        System.out.print("bum7");
                        nave.setEstado(false);
                        this.setEstado(false);
                    }         
                } 
                */
            }  
        }  
       
//-------------------------------------------------------------------------------------------------------------------------        
//-------------------------------------------------------------------------------------------------------------------------        
        if(nave.getY()+150>enemigo4.getY()){                                     //si la parte de abajo de la nave es mayor que la parte de arriba del enemigo
            if(nave.getY()+150<enemigo4.getY()+150){                             //si la parte de abajo de la nave es menor que la parte de abajo del enemigo
                if(nave.getX()+100>enemigo4.getX()){                             //si la parte de derecha de la nave es mayor que la parte de izquierda del enemigo
                    if(nave.getX()+100<enemigo4.getX()+100){                     //si la parte de derecha de la nave es menor que la parte de derecha del enemigo
                        System.out.print("bum8");
                        
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                }
                if(nave.getX()<enemigo4.getX()+100){                             //si la parte de izquierda de la nave es menor que la parte de derecha del enemigo
                    if(nave.getX()>enemigo4.getX()){                             //si la parte de izquierda de la nave es mayor que la parte de izquierda del enemigo
                        System.out.print("bum9");
                    
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                }
            }  
        }          
          
        if(nave.getY()<enemigo4.getY()+150){                                     //si la parte de arriba de la nave esta mas arriba que la parte de abajo del enemigo
            if(nave.getY()>enemigo4.getY()){                                     //si la parte de arriba de la nave esta mas abajo que la parte de arriba del enemigo
                if(nave.getX()+100>enemigo4.getX()){                             //si la parte de derecha de la nave es mayor que la parte de izquierda del enemigo
                    if(nave.getX()+100<enemigo4.getX()+100){                     //si la parte de derecha de la nave es menor que la parte de derecha del enemigo
                        System.out.print("bum10");
                        
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                }
                
                if(nave.getX()<enemigo4.getX()+100){                             //si la parte de izquierda de la nave es menor que la parte de derecha del enemigo
                    if(nave.getX()>enemigo4.getX()){                             //si la parte de izquierda de la nave es mayor que la parte de izquierda del enemigo
                        System.out.print("bum11");
                        
                        this.setVidas(this.getVidas()-1);
                        nave.setX(ancho/2 -50);
                        nave.setY(alto-200);
                    }  
                }
                
            }  
        }  
          
    }
    }
                           
//------------------------------------------------------------------------------------------------------------------------- 
//-------------------------------------------------------------------------------------------------------------------------     
//------------------------------------------------------------------------------------------------------------------------- 
  
//-------------------------------------------------------------------------------------------------------------------------     
//-------------------------------------------------------------------------------------------------------------------------  
//-------------------------------------------------------------------------------------------------------------------------  
    public void Disparos(){
        int i;
        
	for(i=0;i<nave.Bala.size();i++){
            BalaGrafica bala=(BalaGrafica)nave.Bala.get(i);                     //Cada bala creada se va a comparar con el enemigo
            //int j=0;
            
           // for(j=0;enemigos.size();j++){                                     //Recorrer lista de enemigos
            Coordenadas coorbala= new Coordenadas(bala.getX(),bala.getY());
            if (enemigo.getX()< coorbala.getX()  &&  enemigo.getX()+100 > coorbala.getX() &&  enemigo.getY()<coorbala.getY() && enemigo.getY()+150  > coorbala.getY()   ){
              
                enemigo.setLife(enemigo.getLife()-2);
                puntaje=puntaje+1;
                marcador=marcador+1;
            }
            if (enemigo2.getX()< coorbala.getX()  &&  enemigo2.getX()+100 > coorbala.getX() &&  enemigo2.getY()<coorbala.getY() && enemigo2.getY()+150  > coorbala.getY()   ){
                enemigo2.setLife(enemigo2.getLife()-2);
                puntaje=puntaje+1;
                marcador=marcador+1;
            }
            if (enemigo3.getX()< coorbala.getX()  &&  enemigo3.getX()+100 > coorbala.getX() &&  enemigo3.getY()<coorbala.getY() && enemigo3.getY()+150  > coorbala.getY()   ){
                enemigo3.setLife(enemigo3.getLife()-2);
                puntaje=puntaje+1;
                marcador=marcador+1;
            }
            if (enemigo4.getX()< coorbala.getX()  &&  enemigo4.getX()+100 > coorbala.getX() &&  enemigo4.getY()<coorbala.getY() && enemigo4.getY()+150  > coorbala.getY()   ){
                enemigo4.setLife(enemigo4.getLife()-2);
                puntaje=puntaje+1;
                marcador=marcador+1;
            }
        }
			
        
    }
        
//------------------------------------------------------------------------------------------------------------------------- 
    
    public void vidaEnemiga(){
        if(enemigo.GetLife()==0 ||enemigo.getLife()<0 ){
            enemigo.setY(-200);
            puntaje=puntaje+3;
            marcador=marcador+3;
            enemigo.setLife(7);
        }
        if(enemigo2.GetLife()==0 ||enemigo2.getLife()<0 ){
            enemigo2.setY(-200);
            puntaje=puntaje+3;
            marcador=marcador+3;
            enemigo2.setLife(10);
        }
        if(enemigo3.GetLife()==0 ||enemigo3.getLife()<0 ){
            enemigo3.setY(-200);
            puntaje=puntaje+3;
            marcador=marcador+3;
            enemigo3.setLife(20);
        }
        if(enemigo4.GetLife()==0 ||enemigo4.getLife()<0 ){
            enemigo.setY(-200);
            puntaje=puntaje+3;
            marcador=marcador+3;
            enemigo4.setLife(10);
        }
        
        
    }
//-------------------------------------------------------------------------------------------------------------------------  







    
    public void iniciar() throws InterruptedException, IOException{
        while(this.isEstado()){
            try{                                                                //Por si pasa algun error de memoria y no se caiga el juego
                if(!nave.Bala.isEmpty()){                                       //Si el arreglo de balas no est� vacio las mueve
                    nave.Ciclo();                                       
                    }
                Thread.sleep(1);                                               //Hilo de Ejecuci�n, cada 50ms								
                }
            catch(InterruptedException err){                                    //Una excepci�n
                System.out.println(err);
            } 
            
            this.Colision();
            this.Disparos();
            this.vidaEnemiga();
            enemigo.Move();
            enemigo2.Movetorre();
            enemigo3.Move();
            enemigo4.Move();
            if(this.getVidas()==0){
                this.setEstado(false); 
            }
            
//          this.destruccion();
            puntaje++;
            marcador++;
            repaint();
            contador++;
            
        }
        this.setVisible(false);
        puntos();
        new Partida().run();
        	
        
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    

    public void puntos() throws IOException{
        //puntaje
        
        String score = "";
        score = String.valueOf(this.getPuntaje());
        score= Integer.toString(this.getPuntaje());
        try{
            File archivo = new File("C:\\Users\\emers\\Desktop\\fondos\\texto.txt");
            FileWriter escribir=new FileWriter(archivo, true);
            escribir.write("Nombre:  "+this.getNombre()+" /  Puntaje:  "+  this.getPuntaje() +" /  Nivel:   "+ level);
            escribir.close();
        }
        catch(Exception e){
            System.out.println("Error al escribir");
        }       
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getMarcador() {
        return marcador;
    }

    public void setMarcador(int marcador) {
        this.marcador = marcador;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(int powerUp) {
        this.powerUp = powerUp;
    }
    
}

 

