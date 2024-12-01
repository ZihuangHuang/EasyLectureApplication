package view.transcript;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;

import interface_adapter.transcript.TranscriptController;
import interface_adapter.transcript.TranscriptViewModel;

/**
 * The View for when the user is viewing a transcript in the program.
 */
public class TranscriptView extends JPanel implements ActionListener, PropertyChangeListener {
    private final TranscriptViewModel viewModel;
    private final TranscriptController transcriptController;
    private JTextArea transcriptTextArea;
    private JFrame frame;
    private JButton generateButton;

    /**
     * Constructs a TranscriptView with the given ViewModel and Controller.
     *
     * @param viewModel The ViewModel to observe.
     * @param transcriptController The Controller to handle user actions.
     */
    public TranscriptView(TranscriptViewModel viewModel, TranscriptController transcriptController) {
        this.viewModel = viewModel;
        this.transcriptController = transcriptController;
        this.viewModel.addPropertyChangeListener(this);
        SwingUtilities.invokeLater(this::initialize); // Ensure initialization is on the EDT
    }

    /**
     * Initialize the GUI components.
     */
    private void initialize() {
        frame = new JFrame("Get Transcript");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        transcriptTextArea = new JTextArea();
        transcriptTextArea.setEditable(false);
        transcriptTextArea.setLineWrap(true);
        transcriptTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(transcriptTextArea);

        generateButton = new JButton("Generate transcript");
        generateButton.addActionListener(this);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(generateButton, BorderLayout.SOUTH);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    /**
     * Handles the generate transcript action.
     */
    private void generateTranscription() {
        String youtubeUrl = JOptionPane.showInputDialog(frame, "Enter YouTube URL:");
        if (youtubeUrl != null && !youtubeUrl.trim().isEmpty()) {
            transcriptController.execute(youtubeUrl);
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid URL. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Handles property change events from the ViewModel.
     *
     * @param evt The property change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (TranscriptViewModel.TRANSCRIPT_PROPERTY.equals(evt.getPropertyName())) {
            transcriptTextArea.setText((String) evt.getNewValue());
        }
    }

    /**
     * Handles button clicks.
     *
     * @param e The action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        generateTranscription();
    }
}
