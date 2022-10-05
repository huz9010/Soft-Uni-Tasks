package ObjectsAndClassesExercise;

import java.util.Scanner;

public class Articles {
    static class Article {
        private String title;
        private String content;
        private String author;

        public String getTitle() {
            return this.title;
        }

        public String getContent() {
            return this.content;
        }

        public String getAuthor() {
            return this.author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }

    public static void printArticle(String title, String content, String author)   {
        System.out.printf("%s - %s: %s", title, content, author);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        String title = input[0];
        String content = input[1];
        String author = input[2];

        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setAuthor(author);

        int commandCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commandCount; i++) {
            String[] command = scanner.nextLine().split(": ");
            switch (command[0]) {
                case "Edit":
                    article.setContent(command[1]);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(command[1]);
                    break;
                case "Rename":
                    article.setTitle(command[1]);
                    break;
            }
        }
        printArticle(article.getTitle(), article.getContent(), article.getAuthor());
    }
}
