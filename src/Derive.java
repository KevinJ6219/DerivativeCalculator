import java.util.ArrayList;

public class Derive {

    private String equation;
    private ArrayList<String> separatedList;
    public Derive(String equation) {
        this.equation = equation;
        separatedList = separate();
    }

    public ArrayList<String> separate() {
        ArrayList<String> separtatedList = new ArrayList<String>();
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

    public ArrayList<String> getSeparatedList() {
        return separatedList;
    }

    public String getEQuation() {
        return equation;
    }


}
