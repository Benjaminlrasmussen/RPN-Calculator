package rpncalculator;

import interfaces.CustomStack;
import java.util.HashMap;
import interfaces.Operator;
import stack.PathStack;

public class Calculator
{
    private final CustomStack<Integer> results = new PathStack();
    private final HashMap<Character, Operator> operators = new HashMap();
    
    public Calculator()
    {
        operators.put('+', (int a, int b) -> {return a + b;});
        operators.put('-', (int a, int b) -> {return a - b;});
        operators.put('*', (int a, int b) -> {return a * b;});
        operators.put('/', (int a, int b) -> {return a / b;});
        operators.put('%', (int a, int b) -> {return a % b;});
    }
    
    public void feedInput(String input)
    {   
        int cutoffPoint = input.length();
        for (int i = 0; i < input.length(); i++)
        {
            char cur = input.charAt(i);
            if (operators.containsKey(cur))
            {
                cutoffPoint = i;
                break;
            }
        }
        
        String[] values = input.substring(0, cutoffPoint).split(" ");
        String[] ops = input.substring(cutoffPoint, input.length()).split(" ");
        
        if (cutoffPoint > 0)
        {
            for (int i = 0; i < values.length; i++)
            {
                results.push(Integer.parseInt(values[i]));
            }
        }
        
        if (ops[0].length() > 0)
        {
            for (int i = 0; i < ops.length; i++)
            {
                char op = ops[i].charAt(0);
                int a = results.pop();
                int b = results.pop();
            
                results.push(operators.get(op).calculate(a, b));
            }
        }
        
        printStack();
    }
    
    private void printStack()
    {
        System.out.print("\n");
        Object[] arr = results.toArray();
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(">" + arr[i]);
        }
        System.out.print("\n");
    }
}
