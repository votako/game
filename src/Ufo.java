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
    String s;
    public BufferedImage imageUfo;

    // ============================================
    // init
    // ============================================
    Ufo(){
//        Cow c = new Cow();
        y = 200;
        x = 200;

        try { imageUfo = ImageIO.read(new File("img/Ufo.png")); }
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