package app;

import java.awt.*;
import javax.swing.*;

import data_access.DataAccessObject;
import entity.Summary;
import entity.Lecture;
import interface_adapter.SummaryController;
import interface_adapter.SummaryPresenter;
import interface_adapter.SummaryViewModel;
import use_case.SummaryServiceInputBoundary;
import use_case.SummaryServiceOutputBoundary;
import use_case.SummaryServiceInteractor;
import use_case.SummaryServiceUserDataAccessInterface;
import view.SummaryView;
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
        String apiKey = "jwgBCFFlmTYQiX6B3jhukmHwq1HDEwNRabSUvY9Z";
        SummaryViewModel viewModel = new SummaryViewModel();
        SummaryServiceOutputBoundary presenter = new SummaryPresenter(viewModel);
        SummaryServiceUserDataAccessInterface summaryDAO = new DataAccessObject();
        SummaryServiceInputBoundary SummaryInteractor = new SummaryServiceInteractor(summaryDAO, presenter);
        SummaryController summaryController = new SummaryController(SummaryInteractor);
        SummaryView summaryView = new SummaryView(viewModel, summaryController);
        javax.swing.SwingUtilities.invokeLater(() -> summaryView.show());

    }
}
