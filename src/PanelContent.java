import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class PanelContent {
  private JFrame f;
  private Clock clock;

  public PanelContent(){
    try {
      this.contentPacker();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void contentPacker() throws InterruptedException{
    f = new JFrame("Binary Clock");
    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f.setResizable(false);
    f.addWindowListener(new WindowAdapter() {
      public void windowClosed(WindowEvent w){
        System.exit(0);
      }
    });
    {
      clock = new Clock();
      f.getContentPane().add(clock, BorderLayout.CENTER);
    }
    f.setSize(334, 176);
    f.setVisible(true);
    while (true){
      clock.repaint();
      Thread.sleep(20);
    }
  }

}
