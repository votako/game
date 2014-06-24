import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ufo extends Canvas{
    int x;
    int y;
    public BufferedImage imageUfo;
    String imgName = "img/Ufo.png";

    Ufo(){
        y = 200;
        x = 200;

        try { imageUfo = ImageIO.read(new File(imgName)); }
        catch (IOException e) { e.printStackTrace(); }
    }

    public BufferedImage getImg(){
        return imageUfo;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
}