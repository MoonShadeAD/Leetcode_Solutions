public class RailFence
{
    public String convert(String s, int numRows)
    {
        if (numRows == 1 || s.length() <= numRows)
            return s;

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++)
            rows[i] = new StringBuilder();

        int row = 0;
        boolean goingDown = true;

        for (char c : s.toCharArray())
        {
            rows[row].append(c);

            if (row == 0)
                goingDown = true;
            else if (row == numRows - 1)
                goingDown = false;

            row += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder r : rows)
            result.append(r);

        return result.toString();
    }
    public static void main(String[] args)
    {
        RailFence obj = new RailFence();
        System.out.println(obj.convert("PAYPALISHIRING", 4));

    }
}
