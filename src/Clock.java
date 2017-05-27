import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Date;

public class Clock extends Canvas {
  private static final long serialVersionUID = 1254350238918281618L;

  private Date date;

  private final int SIZE_ON = 18;

  private Image dbimage;
  private Graphics dbg;

  private final int[][][] time_sec = {{
          {250, 100},
          {250, 70},
          {250, 40},
          {250, 10}
  }, {
          {220, 100},
          {220, 70},
          {220, 40}
  }
  };
  private final int[][][] time_min = {
          {
                  {170, 100},
                  {170, 70},
                  {170, 40},
                  {170, 10}
          }, {
          {140, 100},
          {140, 70},
          {140, 40}
  }
  };
  private final int[][][] time_std = {
          {
                  {90, 100},
                  {90, 70},
                  {90, 40},
                  {90, 10}
          }, {
          {60, 100},
          {60, 70}
  }
  };

  public Clock() {
    date = new Date();
  }

  public void paint(final Graphics g) {

    super.paint(g);
    this.setBackground(Color.BLACK);
    this.drawFields(g);
    date = new Date();
    this.finishSec(g);
    this.finishMin(g);
    this.finishStd(g);
  }

  public void update(Graphics g) {
    if (dbimage == null) {
      dbimage = createImage(this.getSize().width, this.getSize().height);
      dbg = dbimage.getGraphics();
    }
    dbg.setColor(getBackground());
    paint(dbg);
    g.drawImage(dbimage, 0, 0, this);
  }

  public boolean drawFields(Graphics g) {
    g.setColor(Color.WHITE);
    for (int a = 0; a < 2; a++) {
      for (int i = 0; i < time_sec[1].length; i++) {
        g.drawOval(time_sec[a][i][0], time_sec[a][i][1], 20, 20);
      }
    }
    g.drawOval(time_sec[0][3][0], time_sec[0][3][1], 20, 20);
    for (int a = 0; a < 2; a++) {
      for (int i = 0; i < time_min[1].length; i++) {
        g.drawOval(time_min[a][i][0], time_min[a][i][1], 20, 20);
      }
    }
    g.drawOval(time_min[0][3][0], time_min[0][3][1], 20, 20);
    for (int a = 0; a < 2; a++) {
      for (int i = 0; i < time_std[1].length; i++) {
        g.drawOval(time_std[a][i][0], time_std[a][i][1], 20, 20);
      }
    }
    g.drawOval(time_std[0][2][0], time_std[0][2][1], 20, 20);
    g.drawOval(time_std[0][3][0], time_std[0][3][1], 20, 20);
    return true;
  }

  @SuppressWarnings("deprecation")
  public boolean finishSec(Graphics g) {
    int sek[] = {
            (date.getSeconds() - ((date.getSeconds() / 10) * 10)),
            (date.getSeconds() / 10)
    };
    for (int i = 0; i < 2; i++) {
      int rechner = sek[i];
      int indexArray = 0;
      while (rechner > 0) {
        if (rechner % 2 == 1) {
          g.setColor(Color.RED);
          g.fillOval((time_sec[i][indexArray][0] + 1), (time_sec[i][indexArray][1] + 1), SIZE_ON, SIZE_ON);
        }
        rechner = rechner / 2;
        indexArray++;
      }
    }
    return true;
  }

  @SuppressWarnings("deprecation")
  public boolean finishMin(Graphics g) {
    // Ziffern einzeln holen:
    int min[] = {
            (date.getMinutes() - ((date.getMinutes() / 10) * 10)),
            (date.getMinutes() / 10)
    };
    for (int i = 0; i < 2; i++) {
      int rechner = min[i];
      int indexArray = 0;
      while (rechner > 0) {
        if (rechner % 2 == 1) {
          g.setColor(Color.RED);
          g.fillOval((time_min[i][indexArray][0] + 1), (time_min[i][indexArray][1] + 1), SIZE_ON, SIZE_ON);
        }
        rechner = rechner / 2;
        indexArray++;
      }
    }
    return true;
  }

  @SuppressWarnings("deprecation")
  public boolean finishStd(Graphics g) {
    int std[] = {
            (date.getHours() - ((date.getHours() / 10) * 10)),
            (date.getHours() / 10)
    };
    for (int i = 0; i < 2; i++) {
      int rechner = std[i];
      int indexArray = 0;
      while (rechner > 0) {
        if (rechner % 2 == 1) {
          g.setColor(Color.RED);
          g.fillOval((time_std[i][indexArray][0] + 1), (time_std[i][indexArray][1] + 1), SIZE_ON, SIZE_ON);
        }
        rechner = rechner / 2;
        indexArray++;
      }
    }
    return true;
  }

}
