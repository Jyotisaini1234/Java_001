package Java_001;
class Rowboat extends Boat {
    public void rowTheBoat() {
        System.out.println("stroke natasha");
    }
}

class Boat {
    private int length;

    public void setLength(int len) {
        length = len;
    }

    public int getLength() {
        return length;
    }

    public void move() {
        System.out.println("drift ");
    }
}

class Sailboat extends Boat {
    public void move() {
        System.out.println("hoist sail ");
    }
}

public class TestBoats {
    public static void main(String[] args) {
        Boat b1 = new Boat();
        Sailboat b2 = new Sailboat();
        Rowboat b3 = new Rowboat();
        b2.setLength(32);
        b1.move();
        b3.move();
        b2.move();
    }
}
