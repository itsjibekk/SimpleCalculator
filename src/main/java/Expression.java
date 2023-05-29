import java.util.HashMap;

public class Expression {

    private String arithmeticExpression;

    public String getArithmeticExpression() {
        return arithmeticExpression;
    }

    public void setArithmeticExpression(String arithmeticExpression) {
        this.arithmeticExpression = arithmeticExpression;
    }

    public Object calculatePartually(String expression){

        expression = expression.replaceAll("\\s+", "");

        if(!equalNumberOfParentheses()){
            return "Expression is invalid";
        }
        int currentNumber = 0;
        int result = 0;
        char operation = '+';


        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber = (currentNumber * 10) + (c - '0');
            }

            if (!Character.isDigit(c) || i == expression.length() - 1) {

                if (operation == '+') {
                    result += currentNumber;
                } else if (operation == '-') {
                    result -= currentNumber;
                } else if (operation == '*') {
                    result *= currentNumber;
                } else if (operation == '/') {
                    result /= currentNumber;
                }

                operation = c;


                currentNumber = 0;
            }
        }
        return result;
    }

    public boolean equalNumberOfParentheses(){
        int openning = 0;
        int closing = 0;
        for(int i = 0;i < arithmeticExpression.length();i++){
            char c = arithmeticExpression.charAt(i);
            if(c == '(') ++openning;
            if(c == ')') ++closing;
        }
        return openning == closing;
    }


}
