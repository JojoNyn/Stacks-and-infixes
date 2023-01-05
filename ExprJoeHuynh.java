// Class: CS3305 Data Structures Section 03
// Term: Spring 2022
// Name: Joe Huynh
// Program Number: #3 of Assignment 3
// IDE: Intellij Community Edition 2021.2.2, azul-13 version 15.01(JDK)

import java.util.*;
import java.lang.Math;

public class ExprJoeHuynh {

public static int precedence(char operator) { //checks for precedence value, higher precedence = higher number
    if(operator == '^'){
        return 3;
    }else if(operator == '*' || operator == '/'){
    return 2;
    }else if(operator == '+' || operator == '-'){
        return 1;
    }else{
        return 0;
    }
}

public static String infixToPostfix(String infix){
 String postfix = "";
 MyStackJoeHuynh<Character> stack = new MyStackJoeHuynh<Character>();
 char[] word = infix.toCharArray();
    for (char c : word) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') { //first checks if it's an operator
            while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) { //checks the current stack and pops if current precedence is lower
                postfix += stack.pop();
            }
            stack.push(c);
        } //pushes if stack is empty or current precedence is higher
        else if (c == '(') {
            stack.push(c);
        } else if (c == ')') {
            while (!stack.isEmpty() && stack.peek() != '(') { //pops every operand inside until hits the '('
                postfix += stack.pop();
            }
            stack.pop(); //gets rid of '('
        } else {
            postfix += c; //if it's a just character, attach it to the postfix string.
        }
    }
    while(!stack.isEmpty()){ //pop everything left
        postfix += stack.pop();
 }


return postfix;
}

public static double postfixEval(String postfix){
    char [] word = postfix.toCharArray();//take string to char
    MyStackJoeHuynh<Double> stack = new MyStackJoeHuynh<Double>();
    for (char c : word) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') { //first checks if it's an operator
            double temp2 = stack.pop(); //temporary variables that pop out the values
            double temp1 = stack.pop();
            switch (c) { //performs the operations and pushes them back
                case '+':
                    stack.push(temp1 + temp2);
                    break;
                case '-':
                    stack.push(temp1 - temp2);
                    break;
                case '*':
                    stack.push(temp1 * temp2);
                    break;
                case '/':
                    stack.push(temp1 / temp2);
                    break;
                case '^':
                    stack.push(Math.pow(temp1, temp2));
                    break;
            }
        } else {//assuming these are just numbers
            stack.push(Double.parseDouble(String.valueOf(c)));
            //get the value of a char by converting to the string value and parsing into a Double
        }
    }
    return stack.pop();//pops last number out
}

public static void main(String[]args) {
    Scanner scan = new Scanner(System.in);
    char choice = 'y';
    do{
        try {
            System.out.print("Enter an infix:\t");
            String infix = scan.nextLine();
            String postfix = infixToPostfix(infix);
            double result = postfixEval(postfix);
            System.out.println("Postfix Evaluation:\t" + postfix);
            System.out.println("Result value:\t" + result);
        }catch (Exception e){
            System.out.println("Enter numbers and operands only!");
        } finally{
            System.out.print("Do you want to continue? (Y/N) ");
            choice = scan.next().charAt(0);
            scan.nextLine();
        }
    }
    while(choice == 'Y' || choice == 'y');
}
}
