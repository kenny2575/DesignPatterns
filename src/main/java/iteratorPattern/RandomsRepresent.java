package iteratorPattern;

public class RandomsRepresent {
    public static void main(String[] args) {
        for (int r : new Randoms(60, 150)) {
            System.out.println("Случайное число: " + r);
            if (r == 100) {
                System.out.println("Выпало число 100, давайте на этом закончим");
                break;
            }
        }
    }
}
