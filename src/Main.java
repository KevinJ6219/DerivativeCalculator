public class Main {
    public static void main(String[] args) {
        Derive question1 = new Derive("2x^2 + 3x + 3 + 6");
        System.out.println(question1.separate());
        System.out.println(question1.powerRule("-3x^5"));
        System.out.println(question1.quotientRule("5x^3/6x^5"));
        System.out.println(question1.productRule("7x^8 * 8x^2"));
    }
}
