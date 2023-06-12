public class DerivativeMethods {
    public static String powerRule(String term) {
        String result = "";
        int power = 0;
        double coefficient = 0.0;
        int indexOfX = term.indexOf("x");

        if (indexOfX != -1) {
            String coefficientStr = term.substring(0, indexOfX);
            if (!coefficientStr.isEmpty()) {
                coefficient = Double.parseDouble(coefficientStr);
            } else {
                coefficient = 1.0;
            }
        } else {
            coefficient = Double.parseDouble(term);
        }

        if (term.contains("^")) {
            power = Integer.parseInt(term.substring(term.indexOf("^") + 1));
        }

        double newCoefficient = coefficient * power;
        result = "" + (int) newCoefficient + "x" + "^" + (power - 1);
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
