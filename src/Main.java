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

    public Ufo ufo = new Ufo();

//    создание массива коров.
//    для дальнейшего использования необходимо инициализировать кол-во.(?)
    public Cow cow[] = new Cow[3];
    public int cowLength = cow.length;

//      конструктор класса с инициализацией переменных и добавления слушателя событий
    Main(){
        addKeyListener(new TAdapter());
//        создание коров
        for(int i=0; i<cowLength; i++){
            //      случайные числа для старта коров.
            int randCoord = 100 + (int)(Math.random() * ((600 - 100) + 1));
//            инициализация коров по ^
            cow[i] = new Cow(randCoord, randCoord);
        }
    }
//    отрисовка компонентов(коровы, НЛО)
//    порядок отрисовки имеет значение.
//    если НЛО инициализировать первыми, отображатся будет ПОД коровами
    public void paint(Graphics g){
        for (int i=0; i<cowLength; i++){
            g.drawImage(cow[i].getImg(), cow[i].x, cow[i].y, null);
        }
        g.drawImage(ufo.getImg(), ufo.x, ufo.y, null);
    }

    public static void main(String[] args){
//        создаем экземпляр класса с инициализироваными коровами, отрисовкой, слушателем
        Main m = new Main();

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
//            затем светяем координаты с "размерами" коровы и меняет спрайт
            for (int i=0; i<cowLength; i++) {
                if (ufo.x > cow[i].getX() - 10 & ufo.x < cow[i].getX() + 20
                        & ufo.y > cow[i].getY() - 10 & ufo.y < cow[i].getY() + 20) {
//                    если попал на корову - меняет спрайт
                    cow[i].setImg("img/Alien_Cow.png");
                    repaint();
                }
            }
        }
    }
}