import java.util.ArrayList;
import java.util.HashMap;

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
        int i = 0;
        while (i < temp.length()) {
            String index = temp.substring(i, i+1);
            if (index.equals("+") || index.equals("-") || index.equals("*") || index.equals("/")) {
                separatedList.add(temp.substring(0, i));
                temp = temp.substring(i+1);
                i = 0;
            }
            i++;
        }
        separatedList.add(temp);
        for (int j = 0; j < separatedList.size(); j++) {
            separatedList.set(j,separatedList.get(j).replaceAll("\\s+", ""));
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

    public String quickSolve() {
        String result = "";
        if (symbols.contains("+") || symbols.contains("-")) {
            result += "You use the power rule: ";
            for (int i = 0; i < separatedList.size(); i++) {
                if (i > 0) {
                    result += DerivativeMethods.powerRule(separatedList.get(i));
                }
                else {
                    result += DerivativeMethods.powerRule(separatedList.get(i)) + " + ";
                }
            }
            return result;
        }
        if (symbols.contains("*")) {
            return "You use the product rule: " + DerivativeMethods.productRule(separatedList.get(0), separatedList.get(1));
        }
        else if (symbols.contains("/")) {
            return "You use the quotient rule: " + DerivativeMethods.quotientRule(separatedList.get(0), separatedList.get(1));
        }
            return "Not a valid equation";
    }

    public void solve() {
        HashMap<String, ArrayList<String>> terms = new HashMap<>();
        int count = 0;
        ArrayList<String> temp =  new ArrayList<String>();
        for (String term : separatedList) {
            temp.add(term);
        }
        for (int i = 0; i < symbols.size(); i++) {
            if (symbols.get(i).equals("*")) {
                ArrayList<String> twoTerms = new ArrayList<String>();
                twoTerms.add(temp.get(i));
                twoTerms.add(temp.get(i+1));
                System.out.println(temp);
                temp.remove(i);
                temp.remove(i);
                System.out.println(temp);
                terms.put("*" + count,twoTerms);
                count++;
            }
            else if (symbols.get(i).equals("/")) {
                ArrayList<String> twoTerms = new ArrayList<String>();
                twoTerms.add(temp.get(i));
                twoTerms.add(temp.get(i+1));
                System.out.println(temp);
                temp.remove(i);
                temp.remove(i);
                System.out.println(temp);
                terms.put("/" + count,twoTerms);
                count++;
            }
        }
        System.out.println(terms);
    }



    public ArrayList<String> getSeparatedList() {
        return separatedList;
    }
    public String getEquation() {
        return equation;
    }


}
