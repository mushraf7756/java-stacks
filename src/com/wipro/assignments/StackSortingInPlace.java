package com.wipro.assignments;

import java.util.Scanner;
import java.util.Stack;

public class StackSortingInPlace {

    public static void sortStack(Stack<Integer> stack) {
	Stack<Integer> tempStack = new Stack<>();

	// Step 1: Sort the elements in tempStack in ascending order
	while (!stack.isEmpty()) {
	    int current = stack.pop();

	    // Move elements from tempStack back to stack if they are greater than current
	    while (!tempStack.isEmpty() && tempStack.peek() < current) {
		stack.push(tempStack.pop());
	    }

	    // Push the current element onto tempStack
	    tempStack.push(current);
	}

	// Step 2: Transfer the sorted elements back to the original stack
	while (!tempStack.isEmpty()) {
	    stack.push(tempStack.pop());
	}
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	Stack<Integer> stack = new Stack<>();
	Scanner scanner = new Scanner(System.in);

	System.out.println("Enter the number of elements to push into the stack:");
	int n = scanner.nextInt();

	System.out.println("Enter the elements to push into the stack:");
	for (int i = 0; i < n; i++) {
	    int element = scanner.nextInt();
	    stack.push(element);
	}

	System.out.println("Original Stack: " + stack);
	sortStack(stack);
	System.out.println("Sorted Stack: " + stack);
    }

}
