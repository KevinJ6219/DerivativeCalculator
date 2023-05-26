import java.util.ArrayList;

public class Derive {

    private String equation;
    private ArrayList<String> separatedList;
    private ArrayList<String> symbols;
    public Derive(String equation) {
        this.equation = equation;
        separatedList = separate();
        symbols = getSymbols();
    }

    public ArrayList<String> separate() {
        ArrayList<String> separatedList = new ArrayList<String>();
        String temp = equation;
        if (equation.contains("+") || equation.contains("-") || equation.contains("*") || equation.contains("/")) {
            for (int i = 0; i < temp.length(); i++) {
                int index = 0;
                if (temp.contains("+")) {
                    index = temp.indexOf("+");
                    separatedList.add(temp.substring(0,index));
                    temp = temp.substring(index+1);
                }
                else if (temp.contains("-")) {
                    index = temp.indexOf("-");
                    separatedList.add(temp.substring(0,index));
                    temp = temp.substring(index+1);
                }
                else if (temp.contains("*")) {
                    index = temp.indexOf("*");
                    separatedList.add(temp.substring(0,index));
                    temp = temp.substring(index+1);
                }
                else if(temp.contains("/")) {
                    index = temp.indexOf("/");
                    separatedList.add(temp.substring(0,index));
                    temp = temp.substring(index+1);
                }
            }
            separatedList.add(temp);
        }
        for (int i = 0; i < separatedList.size(); i++) {
            separatedList.set(i,separatedList.get(i).replaceAll("\\s", ""));
        }
        return separatedList;
    }

    public ArrayList<String> getSymbols() {
        ArrayList<String> symbols = new ArrayList<String>();
        for (int i = 0; i < equation.length(); i++) {
            String index = equation.substring(i, i+1);
            if (index.equals("+") || index.equals("-") || index.equals("*") || index.equals("/")) {
                symbols.add(index);
            }
        }
        return symbols;
    }

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


//    public String solve() {
//        ArrayList<String> result = new ArrayList<String>();
//        ArrayList<String> temp = separate();
//        String resultString = "";
//        for (int i = 1; i < symbols.size(); i++) {
//            if (symbols.contains("*") || symbols.contains("/")) {
//                if (symbols.get(i).equals("*")) {
//                    productRule(separatedList.get(i-1),separatedList.get(i));
//                    temp.remove(i);
//                    temp.remove(i-1);
//                    result.add(i-1, productRule(separatedList.get(i-1),separatedList.get(i)));
//                }
//                else {
//                    quotientRule(separatedList.get(i-1),separatedList.get(i));
//                    temp.remove(i);
//                    temp.remove(i-1);
//                    result.add(i-1, quotientRule(separatedList.get(i-1),separatedList.get(i)));
//
//                }
//            }
//        }
//        for (int j = 0; j < temp.size(); j++) {
//            powerRule(temp.get(j));
//            result.add(j, powerRule(temp.get(j)));
//        }
//        for (int i = 0 ; i < temp.size(); i++) {
//            resultString += temp.get(i) + " + ";
//        }
//        return resultString;
//    }

    public String solve() {
        String result = "";
        if (symbols.contains("+") || symbols.contains("-")) {
            result += "You use the power rule: ";
            for (int i = 0; i < separatedList.size(); i++) {
                if (i > 0) {
                    result += powerRule(separatedList.get(i));
                }
                else {
                    result += powerRule(separatedList.get(i)) + " + ";
                }
            }
            return result;
        }
        if (symbols.contains("*")) {
            return "You use the product rule: " + productRule(separatedList.get(0), separatedList.get(1));
        }
        else if (symbols.contains("/")) {
            return "You use the quotient rule: " + quotientRule(separatedList.get(0), separatedList.get(1));
        }
            return "Not a valid equation";
    }

    public ArrayList<String> getSeparatedList() {
        return separatedList;
    }
    public String getEquation() {
        return equation;
    }


}
