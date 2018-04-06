package Singelton;

public class SingeltonMain {
    public static void main(String[] args) {
        Singelton singelton = Singelton.getSingelton();
    }
}

class Singelton {

    static Singelton singelton = new Singelton();

    private Singelton() {}

    public static Singelton getSingelton() {
        return singelton;
    }
}