package app;

import data_access.DataAccessObject;
import interface_adapter.summary.SummaryController;
import interface_adapter.summary.SummaryPresenter;
import interface_adapter.summary.SummaryViewModel;
import use_case.Summary.SummaryServiceInputBoundary;
import use_case.Summary.SummaryServiceOutputBoundary;
import use_case.Summary.SummaryServiceInteractor;
import use_case.Summary.SummaryServiceUserDataAccessInterface;
import view.summary.SummaryView;
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
        SummaryViewModel viewModel = new SummaryViewModel();
        SummaryServiceOutputBoundary presenter = new SummaryPresenter(viewModel);
        SummaryServiceUserDataAccessInterface summaryDAO = new DataAccessObject();
        SummaryServiceInputBoundary SummaryInteractor = new SummaryServiceInteractor(summaryDAO, presenter);
        SummaryController summaryController = new SummaryController(SummaryInteractor);
        SummaryView summaryView = new SummaryView(viewModel, summaryController);
        javax.swing.SwingUtilities.invokeLater(() -> summaryView.show());

    }
}
