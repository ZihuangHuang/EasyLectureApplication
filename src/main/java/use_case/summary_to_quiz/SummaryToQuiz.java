package use_case.summary_to_quiz;

import use_case.TranscriptionReader;

import java.io.IOException;
import java.util.Random;


public class TranscriptionToQuiz {
    public static void main(String[] args) {
        String apiKey = "<<apiKey>>";
        String transcriptionFilePath = "path/to/transcription.txt";

        try {
            String transcription = TranscriptionReader.readTranscription(transcriptionFilePath);
            String quiz = QuizService.generateQuizframe(transcription, apiKey)["content"]["text"];
            // We know this text(summary) consists of exactly 3 sentences. So we can generate a quiz for each:
            String[] quizpiece = quiz.split(".");
            String quiz1 = quizpiece[0];
            String[] quiz1piece = quiz1.split(" ");
            Random r = new Random();
            int i1 = r.nextInt(quiz1piece.length); // the correct answer!
            int i2 = r.nextInt(quiz1piece.length);
            while (i2 == i1) {
                i2 = r.nextInt(quiz1piece.length); // make sure i2 and i1 are different ints!
            }
            int i3 = r.nextInt(quiz1piece.length);
            while (i3 == i1 || i3 == i2) {
                i3 = r.nextInt(quiz1piece.length); // make sure i3, i2 and i1 are different ints!
            }
            for (int i = 1; i <= quiz1piece.length; i++) {
                if (i == i1) {
                    quiz1piece[i] = "()";
                } else {
                    quiz1piece[i] = quiz1piece[i] + ",";
                }
            }
            String quiz2 = quizpiece[1];
            String quiz3 = quizpiece[2];
            System.out.println("Lecture quiz1:\n" + quiz1piece + ":\n" + "A." + quiz1piece[i1] + "\n"
            + "B." + quiz1piece[i2] + "\n"
            + "C." + quiz1piece[i3] + "\n"); // Only quiz1 is generated here; since there are many problems remaining
            // to solve; when they are all fixed, we can write a new function similar to this and all it three times!
            // Remaining problems:
            // 1. It is possible that a sentence contains the same word of different positions;
            // 2. This random answer maybe a trivial one, such as "this", "a", etc;
            // 3. The similar problem arises for the wrong answer.
            System.out.println("Lecture quiz2:\n" + quiz2);
            System.out.println("Lecture quiz3:\n" + quiz3);
        } catch (IOException e) {
            System.err.println("Error reading transcription file: " + e.getMessage());
        }
    }
}