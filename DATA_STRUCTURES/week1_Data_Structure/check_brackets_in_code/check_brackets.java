import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        System.out.println(checkBrackets(text));
    }
    
    public static String checkBrackets (String text) {
        int position;
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (position = 1; position <= text.length(); ++position) {
            char next = text.charAt(position-1);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                Bracket b = new Bracket(next, position);
                opening_brackets_stack.push(b);
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if (!opening_brackets_stack.isEmpty()) {
                    Bracket tmp = opening_brackets_stack.peek();
                    if (!tmp.Match(next)) {
                    	return Integer.toString(position);
                    }
                    opening_brackets_stack.pop();
                } else {
                    return Integer.toString(position);
                }
                
            }
        }

        // Printing answer, write your code here
        /*if (position < text.length()) {
        	System.out.println(position+1);
        } else {
        	System.out.println("Success");
        }*/
        
        if (opening_brackets_stack.isEmpty()) {
            return ("Success");
        } else {
            return Integer.toString(opening_brackets_stack.pop().position);
        }
    }
}
