package TRAINING;
import java.io.*;
import java.util.*;
class StringProcessor
{
    public static String reverse_String(String str)
    {
        return new StringBuilder(str).reverse().toString();
    }
    public static int count_Occurrences(String text, String sub)
    {
        int count = 0,index = 0;
        while ((index = text.indexOf(sub, index)) != -1)
        {
            count++;
            index = index + sub.length();
        }
        return count;
    }
    public static String splitAndCapitalize(String str)
    {
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words)
        {
            if (!word.isEmpty())
            {
                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
        }
        return result.toString().trim();
    }
}
class StringHandling
{
    public static void main(String[] args)
    {
        String str = "HELLO PANIMALAR ENGINEERING COLLEGE";
        System.out.println("Reversed: " + StringProcessor.reverse_String(str));
        System.out.println("Occurrences of 'E': " + StringProcessor.count_Occurrences(str, "E"));
        System.out.println("Capitalized: " + StringProcessor.splitAndCapitalize(str));
    }
}
