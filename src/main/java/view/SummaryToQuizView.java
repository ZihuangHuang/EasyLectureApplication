package view;

import javax.swing.*;

// import interface_adapter.login.LoginController;
// import interface_adapter.login.LoginState;
// import interface_adapter.login.LoginViewModel;
// edit later.

public class SummaryToQuizView extends JPanel {
    private final SummaryToQuizViewModel summaryToQuizViewModel;
    private SummaryToQuizController summaryController;
    private JFrame frame;
    private JTextArea summarytoquiztextArea;
    private JButton generateButton;
    /**
     * Constructs a SummaryToQuizView with the given ViewModel.
     *
     * @param summarytoquizViewModel The ViewModel to observe.
     */
    public SummaryToQuizView(SummaryToQuizViewModel summarytoquizViewModel, SummaryToQuizController summarytoquizController) {
        this.summaryToQuizViewModel = summarytoquizViewModel;
        this.summaryController = summarytoquizController;
        // more details.
            JPanel answerPanel = new JPanel();
            answerPanel.add(new JLabel("Your answer:"));
            answerPanel.add(new JTextField(10));
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(new JButton("Submit"));
            buttonPanel.add(new JButton("Cancel"));
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.add(answerPanel);
            mainPanel.add(buttonPanel);
            JFrame frame = new JFrame("Quiz");
            frame.setContentPane(mainPanel);
    }
    private void generateQuiz() {
        SummaryToQuiz quiz = new SummaryToQuiz();
        // How to formalize this view?
    }
}
