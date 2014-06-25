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

        try { imageUfo = ImageIO.read(new File(imgName)); }
        catch (IOException e) { e.printStackTrace(); }
    }
//  отдает изображение
    public BufferedImage getImg(){
        return imageUfo;
    }

}