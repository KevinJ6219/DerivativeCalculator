import java.util.*;
public class  Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Equation: ");
        String equation = input.nextLine();
        Derive question = new Derive(equation);
        question.solve();
    }
}
