package Adapter;

//Adapter превращает (адаптирует) один интерфейс в другой
public class AdapterMain {
    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        carWash.washCar(new Audi());
        carWash.washCar(new TrackWrap(new MyTrack()));
    }
}

interface Car {
    void wash();
}

class CarWash {
    public void washCar(Car car) {
        car.wash();
    }
}

class Audi implements Car {
    @Override
    public void wash() {
        System.out.println("wash car");
    }
}

interface Track {
    void clean();
}

class MyTrack implements Track {
    @Override
    public void clean() {
        System.out.println("Track is clean");
    }
}

//Adapter между car и track
//Обертка
class TrackWrap implements Car {
    Track track;

    public TrackWrap(Track track) {
        this.track = track;
    }

    @Override
    public void wash() {
        track.clean();
    }
}