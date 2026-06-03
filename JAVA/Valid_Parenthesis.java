// import java.util.Vector;
import java.util.*;
public class Valid_Parenthesis
{
    // Vector<Character> open = new Vector<>();
    // Vector<Character> close = new Vector<>();
    public boolean isValid(String s)
    {
        // if (s.length() == 0) return true;
        // if (s.length()%2!=0) return false;
        // Vector<Character> valid = new Vector<>();
        // int top = -1;
        // open.add('(');
        // open.add('{');
        // open.add('[');
        // close.add(')');
        // close.add('}');
        // close.add(']');

        // for (int i = 0; i<s.length(); i++)
        // {
        //     if (open.contains(s.charAt(i)))
        //     {
        //         valid.add(s.charAt(i));
        //         top++;
        //     }
        //     else if (close.contains(s.charAt(i)))
        //     {
        //         if (top < 0) return false;
        //         if (open.get(close.indexOf(s.charAt(i))) == valid.get(top))
        //         {
        //             valid.remove(top);
        //             top--;
        //         }
        //         else return false;
        //     }
        //     else
        //         return false;
        // }

        // if (top != -1) return false;

        // return true;
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray())
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else
            {
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '['))
                    return false;
            }

        return stack.isEmpty();
    }
    public static void main(String[] args)
    {
        Valid_Parenthesis obj = new Valid_Parenthesis();
        String brackets = "(()[)]";
        if (obj.isValid(brackets))
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }
}
