import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Cow extends Canvas{
//    координаты коровы
    int x;
    int y;
//    ссылка на изображение
    private BufferedImage imageCow;
//    строка с именем изображения
    public String imgName = "img/cow.png";
//    конструктор с координатами и изображением
    Cow(int x, int y){
        this.x=x;
        this.y=y;
        setImg(imgName);

//          таймер для перемещения коров
        Timer timer = new Timer();
        // scheduling the task at interval
//        запускает таймер на ХЗ сколько. действует постоянно вызывая task
        timer.schedule(tasknew,100, 100);
    }


    /**
        creating timer task, timer
    задание таймера, при этом коровы двигаются но из за отсуцтвия repaint
    все отрисовывается когда двигаешь НЛО(там есть repaint всего холста)
    надо найти способ двигать объекты без repaint
     */
    TimerTask tasknew = new TimerTask() {
        @Override
        public void run() {
            x++;
            System.out.println(x);
            repaint();
        }
    };

//    получить картинку
    public BufferedImage getImg(){ return imageCow; }
//    получить значение х y
    public int getX(){return x;}
    public int getY(){return y;}

//  изменяет изображение по параметру String
    public void setImg(String imgName){
//        пробуем считать файл
        try { imageCow = ImageIO.read(new File(imgName)); }
//        если нет - выводим в консоль сообщения о ошибке
        catch (IOException e) { e.printStackTrace(); }
        repaint();
    }
}
