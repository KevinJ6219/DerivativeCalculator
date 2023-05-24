public class Main {
    public static void main(String[] args) {
        Derive question1 = new Derive("2x^2 - 3x + 3 / 6");
        System.out.println(question1.separate());
        System.out.println(question1.powerRule("-3x^5"));
        System.out.println(question1.getSymbols());
        System.out.println(question1.solve());
    }
}
