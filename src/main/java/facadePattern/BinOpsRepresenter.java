package facadePattern;

public class BinOpsRepresenter {
    public static void main(String[] args) {
        BinOps bins = new BinOps();
        System.out.println(bins.sum("101001010110", "101100111"));
        System.out.println(bins.mult("101001010110", "101100111"));
    }
}
