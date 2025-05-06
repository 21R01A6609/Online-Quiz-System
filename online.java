import java.util.*;

class Question {
    String question;
    String[] options;
    char correctAnswer;

    public Question(String question, String[] options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean askQuestion(Scanner sc) {
        System.out.println("\n" + question);
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%c. %s\n", (char) ('A' + i), options[i]);
        }
        System.out.print("Your answer: ");
        char answer = Character.toUpperCase(sc.next().charAt(0));
        return answer == correctAnswer;
    }
}

public class OnlineQuizSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to the Online Quiz System ===");
        System.out.print("Enter your name: ");
        String username = sc.nextLine();

        System.out.println("Hello, " + username + "! Let's start the quiz.");

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                new String[] { "Berlin", "London", "Paris", "Rome" }, 'C'));
        questions.add(new Question("Which language is used for Android development?",
                new String[] { "Swift", "Kotlin", "Python", "Ruby" }, 'B'));
        questions.add(new Question("2 + 2 * 2 = ?", new String[] { "6", "8", "4", "10" }, 'A'));

        int score = 0;
        for (Question q : questions) {
            if (q.askQuestion(sc)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        System.out.println("\n=== Quiz Finished ===");
        System.out.println("Your Score: " + score + " out of " + questions.size());

        sc.close();
    }
}
