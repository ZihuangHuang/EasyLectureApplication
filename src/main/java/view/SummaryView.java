package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.*;

import interface_adapter.SummaryController;
import interface_adapter.SummaryViewModel;

/**
 * The View for when the user is viewing a summary content in the program.
 */

public class SummaryView extends JPanel implements ActionListener, PropertyChangeListener {
    private final SummaryViewModel viewModel;
    private SummaryController summaryController;
    private JFrame frame;
    private JTextArea summarytextArea;

}
