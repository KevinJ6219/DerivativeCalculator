import java.util.ArrayList;

public class Derive {

    private String equation;
    private ArrayList<String> separatedList;
    public Derive(String equation) {
        this.equation = equation;
        separatedList = separate();
    }

    public ArrayList<String> separate() {
        ArrayList<String> separatedList = new ArrayList<String>();
        String temp = equation;
        if (equation.contains("+") || equation.contains("-") || equation.contains("*") || equation.contains("/")) {
            for (int i = 0; i < temp.length(); i++) {
                int index = 0;
                if (temp.contains("+")) {
                    index = temp.indexOf("+");
                }
                else if (temp.contains("-")) {
                    index = temp.indexOf("-");
                }
                else if (temp.contains("*")) {
                    index = temp.indexOf("*");
                }
                else if(temp.contains("/")) {
                    index = temp.indexOf("/");
                }
                separatedList.add(temp.substring(0,index));
                temp = temp.substring(index+1);
            }
            separatedList.add(temp);
        }
        for (int i = 0; i < separatedList.size(); i++) {
            separatedList.set(i,separatedList.get(i).replaceAll("\\s", ""));
        }
        return separatedList;
    }

    public String powerRule(String term) {
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

    public String quotientRule(String fraction) {
        String firstTerm = fraction.substring(0,fraction.indexOf("/"));
        String secondTerm = fraction.substring(fraction.indexOf("/") + 1);
        String result = "((" + powerRule(firstTerm) + "*" + secondTerm + ") - (" + powerRule(secondTerm) + "*" + firstTerm + ")) / (" + secondTerm + ")^2";
        return result;
    }

    public String productRule(String function) {
        String firstTerm = function.substring(0,function.indexOf("*")).replaceAll("\\s", "");
        String secondTerm = function.substring(function.indexOf("*") + 1).replaceAll("\\s", "");
        String result = "((" + powerRule(firstTerm) + "*" + secondTerm + ") + (" + powerRule(secondTerm) + "*" + firstTerm + "))";
        return result;
    }

    public String solve() {
        for (int i = 0; i < separatedList.size(); i = i + 2) {
        }
        return null;
    }

    public ArrayList<String> getSeparatedList() {
        return separatedList;
    }
    public String getEquation() {
        return equation;
    }


}
