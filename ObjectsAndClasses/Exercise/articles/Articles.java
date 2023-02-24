package ProgrammingFundamentalsWithJava2023.ObjectsAndClasses.Exercise.articles;

public class Articles {
//полета харакстеристики
    private String title;
    private String content;
    private String author;
//конструктор създава нови обекти
    //alt + insert генериране на неща
    public Articles(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
//методи поведение
    public void edit(String newContent) {
        this.content = newContent;
    }

    public void changeAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public void rename(String newTitle) {
        this.title = newTitle;
    }//пренаписваме вградения метод toString преобразува даден обект в текст както желаем

    public String toString(){
        return  this.title + " - " + this.content + ": " + this.author;
    }

}
