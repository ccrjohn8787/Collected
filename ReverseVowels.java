import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class ReverseVowels
{
    // Google Phone interview 2015-10
    // Category: Reverse, Two pointers

    @Test
    public void test()
    {
        ReverseVowels rv = new ReverseVowels();
        String input = "United States";
        String expected = "enated StitUs";
        String output = rv.reverseVowel(input);
        Assert.assertTrue(expected.equals(output));
    }

    public String reverseVowel(String s)
    {
        if (s == null || s.length() == 0)
        {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        HashSet<Character> set = new HashSet<>();
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');
        set.add('A'); set.add('E'); set.add('I'); set.add('O'); set.add('U');

        int left = 0, right = s.length()-1;
        while (left < right)
        {
            while (left < right && !set.contains(s.charAt(left)))
            {
                left++;
            }
            while (left < right && !set.contains(s.charAt(right)))
            {
                right--;
            }
            if (left < right)
            {
                char tmp = s.charAt(left);
                sb.setCharAt(left, s.charAt(right));
                sb.setCharAt(right, tmp);
                left++;
                right--;
            }
        }
        return sb.toString();
    }
}
