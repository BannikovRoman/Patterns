package Bridge;
//Плохая реализация!
 /*                ----Shape---
                  /            \
           Rectangle              Circle
           /         \            /      \
BlueRectangle  RedRectangle BlueCircle RedCircle
*/

//С помощью Bridge получаем хорошую реализацию!
/*       ----Shape---                        Color
        /            \                       /   \
Rectangle(Color)   Circle(Color)           Blue   Red
*/

public class BridgeMain {
    public static void main(String[] args) {
        Car car = new ToyotaCar(new CarBridge());
        car.drive();
    }
}

abstract class Car {
    IBridge iBridge;

    public Car(IBridge iBridge) {
        this.iBridge = iBridge;
    }

    public abstract void drive();
}

abstract class Track {
    IBridge iBridge;

    public Track(IBridge iBridge) {
        this.iBridge = iBridge;
    }

    public abstract void drive();
}

interface IBridge {
    void drive();
}

class CarBridge implements IBridge {
    @Override
    public void drive() {
        System.out.println("drive car");
    }
}

class TrackBridge implements IBridge {
    @Override
    public void drive() {
        System.out.println("drive track");
    }
}

class ToyotaCar extends Car {

    public ToyotaCar(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive Toyota");
    }
}

class AudiCar extends Car {

    public AudiCar(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive Audi");
    }
}