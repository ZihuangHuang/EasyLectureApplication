package view;

import interface_adapter.GetTranscript.GetTranscriptViewModel;
import interface_adapter.GetTranscript.GetTranscriptController;

import javax.swing.*;
import java.awt.*;

public class GetTranscriptView extends JPanel {

    private GetTranscriptViewModel viewModel;
    private GetTranscriptController controller;

    // Constructor to initialize the View
    public GetTranscriptView(GetTranscriptViewModel viewModel, GetTranscriptController controller) {
        this.viewModel = viewModel;
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Create and configure the UI components
        JTextField youtubeUrlField = new JTextField();
        JButton fetchButton = new JButton("Fetch Transcript");
        JTextArea transcriptArea = new JTextArea();
        transcriptArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(transcriptArea);

        // Panel for the input field and button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Enter YouTube URL:"));
        inputPanel.add(youtubeUrlField);
        inputPanel.add(fetchButton);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Action listener for the fetch button
        fetchButton.addActionListener(e -> {
            String youtubeUrl = youtubeUrlField.getText().trim();
            if (!youtubeUrl.isEmpty()) {
                // Create the input data and pass it to the controller
                GetTranscriptInputData inputData = new GetTranscriptInputData(youtubeUrl);
                controller.fetchTranscript(inputData);

                // Update the UI with the fetched transcript path and message
                String transcriptPath = viewModel.getTranscriptPath();
                String message = viewModel.getMessage();
                transcriptArea.setText(message + "\n\nTranscript saved at: " + transcriptPath);
            }
        });
    }
}
