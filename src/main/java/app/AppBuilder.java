package app;

import Interface_adapter.SummaryToQuizController;
import Interface_adapter.SummaryToQuizPresenter;
import Interface_adapter.SummaryToQuizViewModel;
import data_access.DataAccessObject;
import use_case.summary_to_quiz.QuizServiceInteractor;
import use_case.summary_to_quiz.SummaryToQuizInputBoundary;
import use_case.summary_to_quiz.SummaryToQuizOutputBoundary;
import use_case.summary_to_quiz.SummaryToQuizUserDataAccessInterface;
import view.SummaryToQuizView;

/**
 * The AppBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * <p/>
 * This is done by adding each View and then adding related Use Cases.
 */

public class AppBuilder {
    /**
     * Builds and starts the application by wiring together all components.
     */
    public static void buildApp() {
        SummaryToQuizViewModel viewModel = new SummaryToQuizViewModel();
        SummaryToQuizOutputBoundary presenter = new SummaryToQuizPresenter(viewModel);
        SummaryToQuizUserDataAccessInterface summaryDAO = new DataAccessObject();
        SummaryToQuizInputBoundary QuizInteractor = new QuizServiceInteractor(summaryDAO, presenter);
        SummaryToQuizController summarytoquizController = new SummaryToQuizController(QuizInteractor);
        SummaryToQuizView summarytoquizView = new SummaryToQuizView(viewModel, summarytoquizController);
        javax.swing.SwingUtilities.invokeLater(() -> summarytoquizView.show());

    }
}