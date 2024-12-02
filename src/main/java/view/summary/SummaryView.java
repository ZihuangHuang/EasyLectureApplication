package view.summary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.*;

import interface_adapter.summary.SummaryController;
import interface_adapter.summary.SummaryViewModel;

/**
 * The View for when the user is viewing a summary content in the program.
 */

public class SummaryView extends JPanel implements ActionListener, PropertyChangeListener {
    private final SummaryViewModel viewModel;
    private SummaryController summaryController;
    private JFrame frame;
    private JTextArea summarytextArea;
    private JButton generateButton;

    /**
     * Constructs a SummaryView with the given ViewModel and Controller.
     *
     * @param viewModel         The ViewModel to observe.
     * @param summaryController
     */
    public SummaryView(SummaryViewModel viewModel, SummaryController summaryController) {
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);
        this.summaryController = summaryController;
        initialize();
    }

    /**
     * Initializes the GUI components.
     */
    private void initialize() {
        frame = new JFrame("Lecture Summary");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel(new BorderLayout());
        summarytextArea = new JTextArea();
        summarytextArea.setEditable(false);
        summarytextArea.setLineWrap(true);
        summarytextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(summarytextArea);
        generateButton = new JButton("Generate Quiz");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateQuiz();
            }
        });
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(generateButton, BorderLayout.SOUTH);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    private void generateQuiz() {
        //Done by Eric
    }

    /**
     * Handles property change events from the ViewModel.
     *
     * @param evt The property change event.
     */
    public void propertyChange(PropertyChangeEvent evt) {
        if ("summaryText".equals(evt.getPropertyName())) {
            summarytextArea.setText((String)evt.getNewValue());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        generateQuiz();

    }

}
