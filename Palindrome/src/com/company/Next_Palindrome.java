package com.company;

import java.util.Scanner;

public class Next_Palindrome
{
    public static void main(String[] args)
    {
        // test numbers : 45312,12345,12945,4531,1459,1997;
        Scanner input_number = new Scanner(System.in);
        System.out.print( "Enter number: " );
        get_next_palindrome(input_number.nextInt());
    }
    //function to check if the input number has even or odd length
    private static boolean check_even_len(int input_number)
    {
        return String.valueOf(input_number).length() % 2 == 0;
    }

    //function to compute the next palindrome for an input number based on length of number
    private static void get_next_palindrome(int input_number)
    {
        if (check_even_len(input_number))
            System.out.println ("Next palindrome is : " + get_next_palindrome_even_number(input_number));
        else
            System.out.println ("Next palindrome is : " + get_next_palindrome_odd_number(input_number));
    }

    private static StringBuilder get_next_palindrome_even_number(int original_number)
    {
        StringBuilder input_string = new StringBuilder();
        input_string.append(original_number);

        //store the digits until the middle element (inclusive) E.g. From 1234 store 12
        StringBuilder palindrome_number = new StringBuilder();
        palindrome_number.append(input_string.substring(0, input_string.length() / 2));

        //delete digits in original input from middle element and replace with reverse of remaining  E.g. In 1234 (input_string) delete 34 and append 12 (palindrome_number) with 21 making it 1221
        palindrome_number.append(input_string.delete(input_string.length() / 2, input_string.length()).reverse());

        //if the palindrome is greater than the original number E.g. 1661 > 1623 then it is the next smallest palindrome
        if (Integer.parseInt(palindrome_number.toString()) > original_number) {
        }
        //if palindrome is less than the original_number E.g. 1221 < 1234 then add 11 to the middle number
        else
        {
            //get the middle elements for even numbers E.g. in 1221 the middle number is 22
            String middle_elements_even_string = palindrome_number.substring(palindrome_number.length() / 2 - 1, palindrome_number.length() / 2 + 1);
            int middle_elements_even_int = Integer.parseInt(middle_elements_even_string);
            //increment the middle elements by 1 so check if after this the value is not greater than 99
            if (middle_elements_even_int + 11 < 99)
            {
               //replacing middle element in next palindrome for an even number with middle_element + 11; E.g. 22 is replaced with 33 making it 1331
                palindrome_number.replace(palindrome_number.length() / 2 - 1,palindrome_number.length() / 2 + 1, String.valueOf(middle_elements_even_int + 11));
                return palindrome_number;
            }
            //if palindrome is less than the original_number and middle element is 99 E.g. 1991 < 1997 then add 1 number until to the middle number E.g. in 1991, 199+1 is 200 making it 2001
            else
            {
                String number_till_middle_odd = palindrome_number.substring(0, palindrome_number.length() / 2 + 1);
                int number_till_middle_oddInt = Integer.parseInt(number_till_middle_odd);
                palindrome_number.replace(0, palindrome_number.length() / 2 + 1, String.valueOf(number_till_middle_oddInt + 1));
                get_next_palindrome(Integer.parseInt(palindrome_number.toString()));
            }
        }
        return palindrome_number;
    }

        private static StringBuilder get_next_palindrome_odd_number(int original_number)
        {

            StringBuilder input_string = new StringBuilder();
            input_string.append(original_number);

            StringBuilder palindrome_number = new StringBuilder();
            //store the digits until the middle element (inclusive) E.g. From 12345 store 123
            palindrome_number.append(input_string.substring(0, input_string.length() / 2 + 1));

            //delete digits in original input from middle element and replace with reverse of remaining  E.g. In 12345 (input_string) delete 345 and append 123 (palindrome_number) with 21 making it 12321
            palindrome_number.append(input_string.delete(input_string.length() / 2, input_string.length()).reverse());

            //if palindrome is greater than original number E.g. 52317 > 52325
            if (Integer.parseInt(palindrome_number.toString()) > original_number)
            {
                return palindrome_number;
            }
            //E.g. 12321 < 12345 - we need the next palindrome to be 12421
            else
            {
                char middle_element_odd = palindrome_number.charAt(palindrome_number.length() / 2); // E.g 3
                int middle_element_odd_int = Character.getNumericValue(middle_element_odd);

                //increment the middle element by 1
                if (middle_element_odd_int < 9)
                {
                    //replacing middle element in next palindrome for an odd number with middle_element + 1; E.g. 3 is replaced with 4
                    palindrome_number.replace(palindrome_number.length() / 2,palindrome_number.length() / 2 + 1, String.valueOf(middle_element_odd_int + 1));
                    return palindrome_number;
                }
                //E.g. 197's next palindrome is 202
                //if palindrome is less than the original_number and middle element is 9 E.g. 191 < 197 then add 1 number until to the middle number E.g. in 191, 19+1 is 20 making it 201
                else
                {
                    String number_till_middle_odd = palindrome_number.substring(0, palindrome_number.length() / 2 + 1); //E.g. in 191 number until middle number is 19
                    int number_till_middle_odd_int = Integer.parseInt(number_till_middle_odd);
                    //increment and replace the number until the middle element (inclusive) by 1, E.g. in 191, 19 is replaced with 20 making it 201
                    palindrome_number.replace(0, palindrome_number.length() / 2 + 1, String.valueOf(number_till_middle_odd_int + 1));
                    //Computing the next palindrome of current palindrome E.g. 201
                    get_next_palindrome(Integer.parseInt(palindrome_number.toString()));
                }
                return palindrome_number;
            }
        }
}
