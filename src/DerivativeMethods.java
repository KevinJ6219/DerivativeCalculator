public class DerivativeMethods {
    public static String powerRule(String term) {
        String result = "";
        int power = 0;
        int coefficient = Integer.parseInt(term.substring(0,term.indexOf("x")));
        if (term.contains("^")){
            power = Integer.parseInt(term.substring(term.indexOf("^") + 1));
        }
        int newCoefficient = coefficient * power;
        result = "" + newCoefficient + "x" + "^" + (power - 1);
        return result;
    }

    public static String quotientRule(String term1, String term2) {
        String firstTerm = term1;
        String secondTerm = term2;
        String result = "((" + powerRule(firstTerm) + "*" + secondTerm + ") - (" + powerRule(secondTerm) + "*" + firstTerm + ")) / (" + secondTerm + ")^2";
        return result;
    }

    public static String productRule(String term1, String term2) {
        String firstTerm = term1.replaceAll("\\s", "");
        String secondTerm = term2.replaceAll("\\s", "");
        String result = "((" + powerRule(firstTerm) + "*" + secondTerm + ") + ("
                + powerRule(secondTerm) + "*" + firstTerm + "))";
        return result;
    }
}
