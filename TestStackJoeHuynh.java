// Class: CS3305 Data Structures Section 03
// Term: Spring 2022
// Name: Joe Huynh
// Program Number: #2 of Assignment 3
// IDE: Intellij Community Edition 2021.2.2, azul-13 version 15.01(JDK)

import java.util.*;

public class TestStackJoeHuynh {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MyStackJoeHuynh<String> stack = new MyStackJoeHuynh<String>();
        int choice = 0;
        do {
            try {
                System.out.print("-----MAIN MENU-----\n" +
                        "0 - Exit Program\n" +
                        "1 – Push\n" +
                        "2 - Pop\n" +
                        "3 – Peek (Top)\n" +
                        "4 - Size\n" +
                        "5 – Is Empty?\n" +
                        "6 – Print Stack\n" +
                        "Choose menu: \n");
                choice = scan.nextInt();
                scan.nextLine();
                switch (choice) { //calls the method
                    case 0:
                        break;
                    case 1:
                        System.out.println("Enter String:");
                        String data = scan.nextLine();

                        stack.push(data);
                        break;
                    case 2:
                        System.out.println(stack.pop());
                        break;
                    case 3:
                        System.out.println(stack.peek());
                        break;
                    case 4:
                        System.out.println(stack.size());
                        break;
                    case 5:
                        System.out.println(stack.isEmpty());
                        break;
                    case 6:
                            System.out.println(stack);
                            break;
                }
        }catch (Exception e) {
                System.out.println("Stack is empty.");} //I assume that most crashes will derive when stack is empty
            //I save lines of code by just making the empty stack into an exception message
            }while (choice != 0) ;
    }
}
