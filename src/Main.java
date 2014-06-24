import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends Canvas{
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    public Ufo ufo;

//    создание массива коров.
//    для дальнейшего использования необходимо инициализировать кол-во.(?)
    public Cow cow[] = new Cow[2];

//      случайные числа для старта коров.
    int randCoord = 100 + (int)(Math.random() * ((600 - 100) + 1));
    int randCoord2 = 100 + (int)(Math.random() * ((600 - 100) + 1));
//      конструктор класса с инициализацией переменных и добавления слушателя событий
    Main(){
        ufo = new Ufo();
        addKeyListener(new TAdapter());
        cow[0] = new Cow(randCoord, randCoord);
        cow[1] = new Cow(randCoord2, randCoord2);
    }
//    отрисовка компонентов(коровы, НЛО)
//    порядок отрисовки имеет значение.
//    если НЛО инициализировать первыми, отображатся будет ПОД коровами
    public void paint(Graphics g){
        g.drawImage(cow[0].getImg(), cow[0].x, cow[0].y, null);
        g.drawImage(cow[1].getImg(), cow[1].y, cow[1].y, null);
        g.drawImage(ufo.getImg(), ufo.x, ufo.y, null);
    }

    public static void main(String[] args){

//       . зачем то необходимо для отображения Ufo
        Ufo u = new Ufo();
//        создаем экземпляр класса с инициализироваными коровами, отрисовкой, слушателем
        Main m = new Main();
//          просто для выдачи стартовых координат коров
        System.out.println(m.randCoord+" "+m.randCoord2);

//          создаем фрейм с закрытием по крестику, размером и видимостью
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(WIDTH, HEIGHT);
        f.setVisible(true);
//        помещаем на фрейм экземпляр класса
        f.add(m);
    }

//  меняем координаты от нажатии кнопки
    class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    ufo.setX(ufo.x -= 10);
                    repaint(ufo.x-9, ufo.y-9, ufo.x, ufo.y);
                    System.out.println(ufo.x);
                    break;
                case KeyEvent.VK_RIGHT:
                    ufo.x += 10;
                    repaint(ufo.x-9, ufo.y-9, ufo.x, ufo.y);
                    System.out.println(ufo.x);
                    break;
                case KeyEvent.VK_UP:
                    ufo.y -= 10;
                    repaint(ufo.x-9, ufo.y-9, ufo.x, ufo.y);
                    System.out.println(ufo.y);
                    break;
                case KeyEvent.VK_DOWN:
                    ufo.y += 10;
                    repaint(ufo.x-9, ufo.y-9, ufo.x, ufo.y);
                    System.out.println(ufo.y);
                    break;
            }
//            обработка поведения при похищении
//            циклом обрабатываем всех коров
//            затем светяем координаты с "размерами" коровы и выдаем мычание
            for (int i=0; i<2; i++){
                if (ufo.x > cow[i].getX()-10 & ufo.x < cow[i].getX()+20
                        & ufo.y > cow[i].getY()-10 & ufo.y < cow[i].getY()+20){
//                    если попал на корову - му
                    System.out.println("mooo eah!!");
//                    не изменяет спрайт!!!
                    cow[i].setImg("img/Alien_Cow.png");
                    repaint();
                }
            }
        }
    }
}