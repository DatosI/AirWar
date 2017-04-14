package enemy.test;




import Dibujos.BalaGrafica;
import Dibujos.Coordenadas;
import Dibujos.Dibujable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class EnemyTest extends Coordenadas implements Dibujable {
    private int attack;
    private int life;
    private int move;
    private String image;
    public int x=500;
    public int y=0;
    private Image photo;
    public Image imagenjet;
    public Image imagenbomber;
    public Image imagenkamikazwe;
    public Image imagentower;
    public int velocidad=20;
    ArrayList Bala= new ArrayList();
    Color color;
    public Coordenadas cor1= new Coordenadas();                                 //Coordenada de la izquierda													
    public Coordenadas cor2=new Coordenadas();                                  //Coordenada de la derecha
    


   

    public EnemyTest(int atk, int def, int mov, String imagen) throws InterruptedException{
        this.attack = atk;
        this.life = def;
        this.move = mov;
        this.image = imagen;
        ImageIcon img = new ImageIcon(this.getClass().getResource(this.image));
        Image photo = img.getImage();
        ImageIcon img2=new ImageIcon(this.getClass().getResource("Jet.png"));//Ponemos la imagen
        imagenjet=img2.getImage();
        ImageIcon img3=new ImageIcon(this.getClass().getResource("bomber.png"));//Ponemos la imagen
        imagenbomber=img3.getImage();
        ImageIcon img4=new ImageIcon(this.getClass().getResource("kamikaze.png"));//Ponemos la imagen
        imagenkamikazwe=img4.getImage();
        ImageIcon img5=new ImageIcon(this.getClass().getResource("tower.png"));//Ponemos la imagen
        imagentower=img5.getImage();
        //this.Move();
        //this.Damage();
     
        
                

    }

    public EnemyTest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void show() {
        this.x = 1400;
        this.y = 500;
    }

    public int GetAttack() {
        return this.attack;
    }

    public int GetLife() {
        return this.life;
    }

    public int GetMove() {
        return this.move;
    }

    public void Move() throws InterruptedException {
        if(this.move == 0) {
            ;
        }
        Random random = new Random();
        if(random.nextInt(2)==1){
            x = x- random.nextInt(10);
        }
        if(random.nextInt(2)==2){
            x = x+ random.nextInt(10);
        }
        //x = x- random.nextInt(this.GetMove());
        //x = x+ random.nextInt(10);
        y = y+ random.nextInt(10)+5;
        Thread.sleep(velocidad);
        //this.Move();
    }
    
    public void Movetorre() throws InterruptedException {
        if(this.move == 0) {
            ;
        }
        Random random = new Random();
        
        y = y+ random.nextInt(10)+50;
        Thread.sleep(5);
        //this.Move();
    }

    public Image GetImagen() {
        throw new RuntimeException("Uncompilable source code - incompatible types: java.lang.String cannot be converted to java.awt.Image");
    }

    public void powerUp() {
        Random random = new Random();
        if(random.nextInt(4) == 0) {
            ;
        }

    }

    public void Hurt() {
        --this.life;
        if(this.life == 0) {
            ;
        }

    }

    private void Damage() throws InterruptedException {
        Thread.sleep(2L);
        //this.Damage();
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

   
    
    @Override																							//Porque ya esta en la interfaz
    public void dibujar(Graphics darreglo){                                     //Entrada dibujar el arreglo con las coordenadas 
        darreglo.setColor(color);
        int x[]={(int)this.getX(),(int)this.cor1.getX(),(int)this.cor2.getX()};											
        int y[]={(int)this.getY(),(int)this.cor1.getY(),(int)this.cor2.getY()};
        Polygon p= new Polygon(x,y,3);
        darreglo.fillPolygon(p);
        darreglo.drawImage(this.getImagenbala(),this.Bala().getX(),this.Bala().getY(), null);
    }
        
        
    public void pintar(Graphics darreglo, Color uncolor){			//Entrada para pintar el arreglo en las coordenadas
        darreglo.setColor(uncolor);
        int x[]={(int)this.getX(),(int)this.cor1.getX(),(int)this.cor2.getX()};
        int y[]={(int)this.getY(),(int)this.cor1.getY(),(int)this.cor2.getY()};
        Polygon p= new Polygon(x,y,3);                                          //Pinta el triangulo
        darreglo.fillPolygon(p);
        darreglo.drawImage(this.getImagenbala(),this.Bala().getX(),this.Bala().getY(), null);
        
    }
        
        
    public BalaGrafica Bala(){
        Coordenadas salida=new Coordenadas(this.getX()+50,this.getY());		//Coordenadas de la punta de la nave
        
        BalaGrafica bala=new BalaGrafica(salida,10,Color.YELLOW);               //Creacion de la bala
        return bala;
    }
    
     public int getYBala() {
        return this.getY();
    }
    public int getXBala() {
        return this.getX();
    }

      
        
    public void Ciclo(){
        for(int i=0; i<this.Bala.size();i++){					//Que se mueve mientras sea menor a la cantidad de elementos a observar
            BalaGrafica y=(BalaGrafica)this.Bala.get(i);			//Traemos del arreglo el cual este en la pos i
            int x=y.getY();
            y.setY(x-=5);																					//Velocidad de la Bala
        }
    }

    private Image getImagenbala() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

