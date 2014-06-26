import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends Canvas{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    public Ufo ufo = new Ufo(0, 0);

//    создание массива коров.
//    для дальнейшего использования необходимо инициализировать кол-во.(?)
    public Cow cow[] = new Cow[5];
    public int cowLength = cow.length;

//      конструктор класса с инициализацией переменных и добавления слушателя событий
    Main(){
        addKeyListener(new TAdapter());
//        создание коров
        for(int i=0; i<cowLength; i++){
            //      случайные числа для старта коров.
            int randCoord = 10 + (int)(Math.random() * ((500 - 10) + 1));
            int randCoord2 = 10 + (int)(Math.random() * ((500 - 10) + 1));
//            инициализация коров по ^
            cow[i] = new Cow(randCoord, randCoord2);
        }
    }
/**     отрисовка компонентов(коровы, НЛО)
        порядок отрисовки имеет значение.
        если НЛО инициализировать первыми, отображатся будет ПОД коровами

        добавил "буферизацию с
 http://www.javaportal.ru/mobiljava/articles/Elimination_blinking.html
        что-то не очень работает
 */
    public void paint(Graphics g){
        Graphics saved = g;
        if (ufo.imageUfo != null){
            g = ufo.getImg().getGraphics();
        }

        for (int i=0; i<cowLength; i++){
            g.drawImage(cow[i].getImg(), cow[i].x, cow[i].y, null);
        }
        g.drawImage(ufo.getImg(), ufo.x, ufo.y, null);

        if (g != saved){
            saved.drawImage(ufo.getImg(), ufo.x, ufo.y, null);
        }
    }

    public static void main(String[] args){
//        создаем экземпляр класса с инициализироваными коровами, отрисовкой, слушателем
        Main m = new Main();
//          создаем фрейм с закрытием по крестику, размером и видимостью
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(WIDTH, HEIGHT));
        f.setVisible(true);
//        помещаем на фрейм экземпляр класса
        f.add(m, BorderLayout.CENTER);
    }




//  меняем координаты от нажатии кнопки
    /**
     по нажатию клавиши определяет координаты и сверяет их с допустимыми
     если координаты допустимы - перемещает ufo
     опять таки repaint!!!
     * */
    class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    if (ufo.x == 0) ufo.x = 0;
                    else ufo.x -= 5;
                    repaint();
                    System.out.println(ufo.x);
                    break;
                case KeyEvent.VK_RIGHT:
                    if (ufo.x == WIDTH-30) ufo.x = WIDTH-30;
                    else ufo.x += 5;
                    repaint();
                    System.out.println(ufo.x);
                    break;
                case KeyEvent.VK_UP:
                    if(ufo.y == 0) ufo.x = 0;
                    else ufo.y -= 5;
                    repaint();
                    System.out.println(ufo.y);
                    break;
                case KeyEvent.VK_DOWN:
                    if (ufo.y == HEIGHT-50) ufo.y = HEIGHT-50;
                    else ufo.y += 5;
                    repaint();
                    System.out.println(ufo.y);
                    break;
            }
            /**
                обработка поведения при похищении
                циклом обрабатываем всех коров
                затем сверяем координаты с "размерами" коровы меняет спрайт
                опять repaint. как обойтись без него?
             */
            for (int i=0; i<cowLength; i++) {
                if (ufo.x > cow[i].getX() - 10 & ufo.x < cow[i].getX() + 20
                        & ufo.y > cow[i].getY() - 10 & ufo.y < cow[i].getY() + 20) {
//                    если попал на корову - меняет спрайт
                    cow[i].setImg("img/Alien_Cow.png");
                }
            }
        }
    }
}