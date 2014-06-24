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
        try { imageCow = ImageIO.read(new File(imgName)); }
        catch (IOException e) { e.printStackTrace(); }
    }

//    получить картинку
    public BufferedImage getImg(){ return imageCow; }
//    получить значение х y
    public int getX(){return x;}
    public int getY(){return y;}

    public void setImg(String imgName){
        this.imgName = imgName;
        repaint();
    }
}
