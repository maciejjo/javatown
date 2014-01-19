import java.util.Random;

public class Human {
  final private String Name;
  final private double MaxSpeed;
  
  private double X, Y;
  private double Alpha;

  public Human(String NewName) {
    Name = NewName;
    
    Random rn = new Random();
    X = rn.nextInt(320);
    Y = rn.nextInt(240);
    MaxSpeed = rn.nextInt(20) + 1;
    Alpha = rn.nextInt(360);
  }

  public void Move() {
  }

}
    

  
