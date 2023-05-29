import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean isOn = true;
        Scanner scan = new Scanner(System.in);

        while (isOn) {
            Expression expression = new Expression();
            DatabaseConnection databaseConnection = new DatabaseConnection();

            String input = scan.nextLine();
            if (input.equals("Esc")) {
                isOn = false;
            } else {
                expression.setArithmeticExpression(input);
                String exp = expression.getArithmeticExpression();
                int res = (int) expression.calculatePartually(exp);
                System.out.println(res);
                databaseConnection.sendQuery(exp, res);
            }
        }
    }
}
