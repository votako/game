import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class MoveIt extends Applet
        implements KeyListener
{
    int nxCurrent;
    int nyCurrent;
    Dimension dm;
    final static int nBlockSize = 10;

    // ============================================
    // init
    // ============================================
    public void init()
    {
        dm = getSize();
        nxCurrent = (dm.width / 2) - nBlockSize;
        nyCurrent = (dm.height / 2) - nBlockSize;

        setBackground(Color.yellow);
        setForeground(Color.black);

        this.addKeyListener(this);
    }

    // ============================================
    // getAppletInfo
    // ============================================
    public String getAppletInfo()
    {
        return "Name: MoveIt";
    }

    // ============================================
    // paint
    // ============================================
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        g.setFont(new Font(
                "Helvetica", Font.BOLD, 24));
        g.drawString("Move it whith keyboard!",
                10, 30);

        DrawIt(g);
    }

    // ============================================
    // DrawIt
    // ============================================
    void DrawIt(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(nxCurrent, nyCurrent,
                2 * nBlockSize, 2 * nBlockSize);
    }

    // ============================================
    // keyPressed
    // ============================================
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        switch(key)
        {
            case KeyEvent.VK_LEFT:
            {
                if(nxCurrent > 0)
                    nxCurrent -= nBlockSize;
                else
                    nxCurrent =
                            dm.width - nBlockSize * 2;
                break;
            }

            case KeyEvent.VK_RIGHT:
            {
                if(nxCurrent < dm.width - nBlockSize)
                    nxCurrent += nBlockSize;
                else
                    nxCurrent = 0;
                break;
            }

            case KeyEvent.VK_DOWN:
            {
                if(nyCurrent < dm.height - nBlockSize)
                    nyCurrent += nBlockSize;
                else
                    nyCurrent = 0;
                break;
            }

            case KeyEvent.VK_UP:
            {
                if(nyCurrent > 0)
                    nyCurrent -= nBlockSize;
                else
                    nyCurrent =
                            dm.height - nBlockSize * 2;
                break;
            }
        }
        repaint();
    }

    // ============================================
    // keyReleased
    // ============================================
    public void keyReleased(KeyEvent e)
    {
    }

    // ============================================
    // keyTyped
    // ============================================
    public void keyTyped(KeyEvent e)
    {
    }
}