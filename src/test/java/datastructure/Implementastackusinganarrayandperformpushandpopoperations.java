package datastructure;

import java.util.Stack;

public class Implementastackusinganarrayandperformpushandpopoperations {
        private int maxSize;
        private int top;
        private int[] stackArray;

        public void Stack(int size) {
            maxSize = size;
            stackArray = new int[maxSize];
            top = -1; // Initialize the top pointer to -1 to indicate an empty stack.
        }

        public void push(int value) {
            if (isFull()) {
                System.out.println("Stack is full. Cannot push " + value);
            } else {
                stackArray[++top] = value;
                System.out.println("Pushed " + value + " to the stack.");
            }
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Cannot pop.");
                return -1; // Return a sentinel value to indicate an empty stack.
            } else {
                int poppedValue = stackArray[top--];
                System.out.println("Popped " + poppedValue + " from the stack.");
                return poppedValue;
            }
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == maxSize - 1;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Cannot peek.");
                return -1; // Return a sentinel value to indicate an empty stack.
            } else {
                return stackArray[top];
            }
        }

        public static void main(String[] args) {
            Stack stack = new Stack();

            stack.push(10);
            stack.push(20);
            stack.push(30);

            stack.pop(); // Pop 30
            stack.pop(); // Pop 20

            System.out.println("Is the stack empty? " + stack.isEmpty()); // Should print "false"

            Object topElement = stack.peek();
            System.out.println("Top element of the stack: " + topElement); // Should print "Top element of the stack: 10"
        }
    }

