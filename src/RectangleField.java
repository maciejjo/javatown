import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

abstract public class RectangleField extends JComponent {

  public double X1, X2, Y1, Y2;
  abstract public Boolean CanAccess(Human Person);

  public RectangleField(double NewX1, double NewX2, double NewY1, double NewY2) {
    
    X1 = NewX1;
    X2 = NewX2;
    Y1 = NewY1;
    Y2 = NewY2;

  }

  @Override
  public void paint(Graphics g) {
      super.paint(g);
      Graphics2D g2d = (Graphics2D) g;
      if(this instanceof CrimeScene)
          g2d.setPaint(Color.BLUE);
      else if(this instanceof ConstructionSite)
          g2d.setPaint(Color.YELLOW);
      else
          g2d.setPaint(Color.BLACK);
      Rectangle2D rectangle = new Rectangle2D.Double(X1, Y1, X2-X1, Y2-Y1);
      g2d.draw(rectangle);
  };

}
