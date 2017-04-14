package enemy.test;


import enemy.test.Boss;
import enemy.test.EnemyTest;
import java.util.Random;

public class ColaEnemigos{
    public EnemyTest[] Enemigos;
    public int level;
    public int current;
    private Object[] enemy;
/*
    public ColaEnemigos() {
        throw new RuntimeException("Uncompilable source code - Erroneous sym type: enemy.test.EnemyTest.<init>");
    }
*/
    public void filled() throws InterruptedException {
        Random random = new Random();
        int i = 0;

        while(i != 20) {
            
            int a = random.nextInt(5);
            if(a == 0) {
                this.Enemigos[i] = new EnemyTest(1, 3, 3, "Jet.png");
                ++i;
            } else if(a == 1) {
                this.Enemigos[i] = new EnemyTest(2, 3, 2, "Bomber.png");
                ++i;
            } else if(a == 2) {
                this.Enemigos[i] = new EnemyTest(2, 0, 3, "Tower.png");
                ++i;
            } else if(a == 3) {
                this.Enemigos[i] = new EnemyTest(3, 1, 3, "BomberTower.png");
            } else {
                this.Enemigos[i] = new EnemyTest(4, 1, 4, "Kamikaze.png");
            }
            
        }
/*
        if(this.level == 0) {
            this.Enemigos[i] = new Boss(1, 10, "Boss1.png");
            ++this.level;
        } else if(this.level == 1) {
            this.Enemigos[i] = new Boss(1, 15, "Boss2.png");
            ++this.level;
        } else if(this.level == 2) {
            this.Enemigos[i] = new Boss(1, 20, "Boss3.png");
        } else if(this.level == 3) {
            this.Enemigos[i] = new Boss(2, 20, "Boss4.png");
        } else if(this.level == 4) {
            this.Enemigos[i] = new Boss(2, 25, "Boss5.png");
        } else if(this.level == 5) {
            this.Enemigos[i] = new Boss(3, 25, "Boss6.png");
        } else if(this.level == 6) {
            this.Enemigos[i] = new Boss(3, 30, "Boss7.png");
        } else if(this.level == 7) {
            this.Enemigos[i] = new Boss(3, 35, "Boss8.png");
        } else if(this.level == 8) {
            this.Enemigos[i] = new Boss(4, 35, "Boss9.png");
        } else {
            this.Enemigos[i] = new Boss(5, 50, "FinalBoss.png");
        }
*/
    }
/*
    public void delete() {
        int i = 0;
        if(this.Enemigos[i].GetLife() == 0) {
            ++i;
            this.reorder();
        }

        if(i == 20) {
            boolean var2 = false;
        }

        this.delete();
    }

    public void reorder() {
        for(int i = 0; i != 20; ++i) {
            this.Enemigos[i] = this.Enemigos[i + 1];
        }

        throw new RuntimeException("Uncompilable source code - not a statement");
    }

    public void insert() {
        if(this.current < 4) {
            this.Enemigos[this.current].show();
            ++this.current;
        }

    }

*/
}

