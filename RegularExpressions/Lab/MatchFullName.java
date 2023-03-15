package ProgrammingFundamentalsWithJava2023.RegularExpressions.Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*String regex = "[A-Za-z]+";
        Pattern pattern = Pattern.compile(regex);//шаблон

        String text = "Hello bou";
        Matcher matcher = pattern.matcher(text);
        //вс текстове от "Hello bou", който отговарят на шаблона
        //matcher = {"Hello","bou"}

        System.out.println(matcher.find());
        //true ако се среща
        // false ако не се среща
        while (matcher.find()){
            System.out.println(matcher.group());
        }
*/
        String text = scanner.nextLine();
        String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.print(matcher.group()+ " ");
        }

    }
}
