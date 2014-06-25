import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ufo extends Canvas{
//    координаты
    int x;
    int y;
//    изображение
    public BufferedImage imageUfo;
    String imgName = "img/Ufo.png";
//  конструктор с координатами и инициализацией изображения
    Ufo(int x, int y){
        this.x = x;
        this.y = y;

        setImg(imgName);
    }
//  отдает изображение
    public BufferedImage getImg(){
        return imageUfo;
    }

    //  изменяет изображение по параметру String
    public void setImg(String imgName){
//        пробуем считать файл
        try { imageUfo = ImageIO.read(new File(imgName)); }
//        если нет - выводим в консоль сообщения о ошибке
        catch (IOException e) { e.printStackTrace(); }
        repaint();
    }

}