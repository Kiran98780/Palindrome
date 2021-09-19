package com.company;
import java.io.*;

public class Palindrome
{
        // function to check whether number is a palindrome
        static int is_palindrome(int num)
        {
            int n, k, rev = 0;
            n = num; //store orig number
            // compute reverse of a number and store in rev
            while (num != 0)
            {
                k = num % 10;
                rev = (rev * 10) + k;
                num = num / 10;
            }
            if (n == rev) // palindrome check - if original number is same as its reverse
                return 1;
            return 0;
        }

        public static void main(String[] args)
        {
            int input_number = 1234;
            while (is_palindrome(input_number) == 0)
                input_number = input_number + 1; // if not Palindrome increment count of the number
            System.out.println("Next Palindrome is:" + input_number);
        }


}
