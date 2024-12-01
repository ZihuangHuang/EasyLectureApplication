package Interface_adapter.summary_to_quiz;

import entity.Quiz;
import use_case.summary_to_quiz.SummaryToQuiz;

import java.util.List;

/**
 * The View Model for the Login View.
 */
public class SummaryToQuizViewModel {
    private Quiz quiz;

    public SummaryToQuizViewModel() {
        SummaryToQuiz summaryToQuiz = new SummaryToQuiz();
    }

    public void getQuiz() {
        quiz.getcontent();
    }

    public void getChoices() {
         quiz.getchoices();
    }

    public void setQuiz(String getcontent) {
        quiz.setcontent(getcontent);
    }

    public void setChoices(List<String> getchoices) {
        quiz.setchoices(getchoices);
    }
}

