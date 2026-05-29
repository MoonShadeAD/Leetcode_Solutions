/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
 

Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
*/

public class Multiply_String
{
    // public long retlong(String s)
    // {
    //     if (s.equals("0"))
    //         return 0;
    //     char[] c = s.toCharArray();
    //     for (int i = 0; i<s.length(); i++)
    //         c[i] -= '0';
    //     long[] num = new long[c.length];
    //     for (int i = 0; i<c.length; i++)
    //         num[i] = (long)c[i];
    //     long sum = 0;
    //     for (long digit : num)
    //         sum = sum*10+digit;
    //     return sum;
    // }
    // public String retStr(long num)
    // {
    //     if (num == 0)
    //         return "0";
        
    //     long temp = num;
    //     int digit_count = 0;
    //     while (temp>0)
    //     {
    //         temp/=10;
    //         digit_count++;
    //     }
    //     long long_arr[] = new long[digit_count];

    //     temp = num;
    //     for (int i = digit_count-1; i>=0; i--)
    //     {
    //         long_arr[i] = temp%10;
    //         temp/=10;
    //     }

    //     char[] ch = new char[digit_count];
    //     for (int i = 0; i<=digit_count-1; i++)
    //         ch[i] = (char)(long_arr[i]+ (long)'0');

    //     String str = "";
    //     for (char c : ch)
    //         str+=c;
    //     return str;
    // }
    // public String multiply(String num1, String num2)
    // {
    //     long mul = retlong(num1) * retlong(num2);
    //     return retStr(mul);
    // }
    public String multiply(String num1, String num2)
    {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length(), n = num2.length();

        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
            {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mul + result[p2];

                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        
        StringBuilder sb = new StringBuilder();

        for (int num : result)
            if (!(sb.length() == 0 && num == 0))
                sb.append(num);

        return sb.toString();
    }
    public static void main(String[] args)
    {
        Multiply_String obj = new Multiply_String();
        String num1 = "123456789";
        String num2 = "987654321";
        System.out.print(obj.multiply(num1, num2));
    }
}