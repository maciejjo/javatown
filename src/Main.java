import java.util.Vector;
import javax.swing.RepaintManager;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.concurrent.TimeUnit;

public class Main {
    public static java.util.Vector<Human> Population = new java.util.Vector<Human>();
    public static java.util.Vector<RectangleField> Places = new java.util.Vector<RectangleField>();
    public static void main(String[] args) throws InterruptedException {

    //Human grzegorz = new Human("Grzegorz");


    Places.add(new Street(20, 100, 20, 120));
    Places.add(new Street(120, 250, 200, 230));
    Places.add(new CrimeScene(50, 250, 240, 290));
    Places.add(new CrimeScene(270, 390, 250, 280));
    Places.add(new ConstructionSite(280, 350, 20, 100));


    for(int i = 0; i < 25; i++) {
      Population.add(new Policeman("Szkieł"));
      Population.add(new Builder("Majster"));
      Population.add(new Human("NPC"));

    }

    JFrame Town = new JFrame();
    Town.setTitle("ex7");
    Town.setBackground(Color.GRAY);
    Town.setSize(480, 320);
    Town.setLocationRelativeTo(null);
    Town.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Town.setResizable(false);
    Town.setVisible(true);

    for(Human Person: Population) {
        Town.add(Person);
        Town.setVisible(true);
    }

    for(RectangleField Place : Places) {
        Town.add(Place);
        Town.setVisible(true);
    }

    while(true) {
      for(Human Person : Population)
        Person.Move();

      java.util.concurrent.TimeUnit.MILLISECONDS.sleep(600);
    }
  }

}
    

