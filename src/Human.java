import java.util.Random;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.*;
import java.awt.Graphics2D;

public class Human extends JComponent implements IPoliceOfficer, ILicensedBuilder, IWearingUniform {

  final private String Name;
  final private double MaxSpeed;
  
  private double X, Y;
  private double Alpha;

  public Human(String NewName) {

    Name = NewName;
    
    Random rn = new Random();
    X = rn.nextInt(480);
    Y = rn.nextInt(320);
    MaxSpeed = rn.nextInt(20) + 1;
    Alpha = rn.nextInt(360);

    for(RectangleField Field : Main.Places) {
      if(X > Field.X1 && X < Field.X2 &&
          Y > Field.Y1 && Y < Field.Y2) {
        X += Field.X2 - X;
        Y += Field.Y2 - Y;
      }
    }

  }

  public void Move() {

    System.out.format("Coordinates for %s: %f %f\n", this.Name, this.X, this.Y);
    Boolean IsPaused = false;
    Random rn = new Random();
    int MoveLen = rn.nextInt((int)MaxSpeed);
    double NewX = 
      X + (int)(Math.cos(Math.toRadians(Alpha)) * MoveLen);
    double NewY = 
      Y + (int)(Math.sin(Math.toRadians(Alpha)) * MoveLen);

    if(NewX >= 480 || NewX <= 0 || NewY >= 320 || NewY <= 0)
      IsPaused = true;

    if(!IsPaused) {
      for(RectangleField Field : Main.Places) {
        if(
          (X <= Field.X1 && NewX >= Field.X1 &&
           Field.Y1 <= NewY && NewY <= Field.Y2) || 
          (X >= Field.X2 && NewX <= Field.X2 && 
           Field.Y1 <= NewY && NewY <= Field.Y2) || 
          (Y <= Field.Y1 && NewY >= Field.Y1 && 
           Field.X1 <= NewX && NewX <= Field.X2) || 
          (Y >= Field.Y2 && NewY <= Field.Y2 && 
           Field.X1 <= NewX && NewX <= Field.X2)
        ) {
          if(!Field.CanAccess(this)) {
            IsPaused = true;
            break;
          }
        }
      }

      if(!IsPaused) {
        X = NewX;
        Y = NewY;
        if(rn.nextBoolean()) Alpha += rn.nextInt(60);
        else Alpha -= rn.nextInt(60);
      } else {
        if(rn.nextBoolean()) Alpha += rn.nextInt(360);
        else Alpha -= rn.nextInt(360);
      }

    }

    if(Alpha >= 360) Alpha = Alpha - 360;
    if(Alpha < 0) Alpha = 360 + Alpha;
  }

  @Override
  public void paint(Graphics g) {
      super.paint(g);
      Graphics2D g2d = (Graphics2D) g;
      if(this instanceof Policeman)
          g2d.setPaint(Color.BLUE);
      else if(this instanceof Builder)
          g2d.setPaint(Color.YELLOW);
      else
          g2d.setPaint(Color.BLACK);
      Ellipse2D circle = new Ellipse2D.Double(X, Y, 5, 5);
      g2d.fill(circle);
      g2d.draw(circle);
      repaint();
  }

  @Override
  public Uniform ShowUniform() {
    return null;
  }

  @Override
  public Badge ShowBadge() {
    return null;
  }

  @Override
  public Permission ShowPermission() {
    return null;
  }

}
    

  
