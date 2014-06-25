import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
    }

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
