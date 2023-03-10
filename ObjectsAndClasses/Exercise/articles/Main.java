package ProgrammingFundamentalsWithJava2023.ObjectsAndClasses.Exercise.articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String articleData = scanner.nextLine();
        String title = articleData.split(", ")[0];
        String content = articleData.split(", ")[1];
        String author = articleData.split(", ")[2];

        Articles article = new Articles(title, content, author);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String commandName =command.split("\\: ")[0];
                    String newValue = command.split("\\: ")[1];

                    switch (commandName){
                        case "Edit":
                            //променя съдържанието ма статията с даденото
                            article.edit(newValue);
                            break;
                        case "ChangeAuthor":
                            //променя автора на моята статиа с дадения
                            article.changeAuthor(newValue);
                            break;
                        case "Rename":
                            //променя заглавието на моята статия с даденото
                            article.rename(newValue);
                            break;
                    }
        }
        System.out.println(article.toString());
    }
}
