package leetcode.editor.cn.stack;

import java.util.Stack;

public class Calculator {

    public static void main(String[] args) {
        System.out.println(calculate("(1+2)*3+4*7+4/2"));
    }

    public static Double calculate(String express) {
        Stack<Express> expressStack = new Stack<>();
        Stack<Double> valueStack = new Stack<>();
        char[] charArray = express.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Express.isExpress(charArray[i])) {
                Express target = Express.getExpress(charArray[i]);
                if (target == Express.LEFT_BRACKETS) {
                    expressStack.push(target);
                } else if (target == Express.RIGHT_BRACKETS) {
                    Express temp;
                    while ((temp = expressStack.pop()) != Express.LEFT_BRACKETS) {
                        Double num1 = valueStack.pop();
                        Double num2 = valueStack.pop();
                        Double v = doCalculate(num1, num2, temp);
                        valueStack.push(v);
                    }
                } else {
                    if (expressStack.isEmpty()) {
                        expressStack.push(target);
                    } else {
                        Express pop = expressStack.pop();
                        if (pop.level >= target.level) {
                            while (!expressStack.isEmpty() && pop.level >= target.level) {
                                Double num1 = valueStack.pop();
                                Double num2 = valueStack.pop();
                                Double v = doCalculate(num1, num2, pop);
                                valueStack.push(v);
                                expressStack.pop();
                            }
                        } else {
                            expressStack.push(pop);
                            expressStack.push(target);
                        }
                    }
                }
            } else {
                valueStack.push((double)charArray[i] - 49 + 1);
            }
        }
        return valueStack.pop();
    }

    public static Double doCalculate (double num1, double num2, Express express) {
        if (express == Express.ADD) {
            return num1 + num2;
        } else if (express == Express.SUB) {
            return num2 - num1;
        } else if (express == Express.MULTI) {
            return num1 * num2;
        } else if (express == Express.DIVISION) {
            return num2 / num1;
        }
        return num1;
    }

    public static enum Express {
        ADD((char)'+', 1),
        SUB((char)'-', 1),
        MULTI((char)'*', 2),
        DIVISION((char)'/', 2),
        LEFT_BRACKETS((char)'(', -1),
        RIGHT_BRACKETS((char)')', -1);

        private char symbol;

        private int level;

        Express(char symbol, int level) {
            this.symbol = symbol;
            this.level = level;
        }

        public static Express getExpress(char value) {
            Express[] values = Express.values();
            for (Express express : values) {
                if (express.symbol == value) {
                    return express;
                }
            }
            return null;
        }

        public static boolean isExpress(char value) {
            Express[] values = Express.values();
            for (Express express : values) {
                if (express.symbol == value) {
                    return true;
                }
            }
            return false;
        }
    }
}
