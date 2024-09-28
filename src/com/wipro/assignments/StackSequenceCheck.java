package com.wipro.assignments;

import java.util.Stack;

public class StackSequenceCheck {

    public static boolean isSequencePresent(Stack<Integer> stack, int[] sequence) {
	// Convert the stack to an array to facilitate checking
	int[] stackArray = new int[stack.size()];
	int index = 0;

	// Pop elements from the stack to array
	while (!stack.isEmpty()) {
	    stackArray[index++] = stack.pop();
	}

	// Restore the stack from the array
	for (int i = stackArray.length - 1; i >= 0; i--) {
	    stack.push(stackArray[i]);
	}

	// Check if the sequence is present consecutively from the top of the stack
	for (int i = 0; i <= stackArray.length - sequence.length; i++) {
	    boolean found = true;
	    for (int j = 0; j < sequence.length; j++) {
		if (stackArray[i + j] != sequence[j]) {
		    found = false;
		    break;
		}
	    }
	    if (found) {
		return true;
	    }
	}

	return false;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	Stack<Integer> stack = new Stack<>();
	stack.push(1);
	stack.push(2);
	stack.push(3);
	stack.push(4);
	stack.push(5);

	// Input sequence
	int[] sequence = { 1, 2, 3 };

	// Check if the sequence is present in the stack
	boolean result = isSequencePresent(stack, sequence);

	// Print result as "true" or "false"
	System.out.println(result);
    }

}
