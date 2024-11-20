package use_case;

import entity.Lecture;
import entity.Summary;

/**
 * The summary service interactor.
 */
public class SummaryServiceInteractor implements SummaryServiceInputBoundary {
    private final SummaryServiceUserDataAccessInterface summaryDataAccessObject;
    private final SummaryServiceOutputBoundary summaryPresenter;

    public SummaryServiceInteractor(SummaryServiceUserDataAccessInterface summaryDataAccessObject,
                                    SummaryServiceOutputBoundary summaryPresenter) {
        this.summaryDataAccessObject = summaryDataAccessObject;
        this.summaryPresenter = summaryPresenter;

    }

    @Override
    public void execute(SummaryServiceInputData summaryServiceInputData) {
        try {
            // Assuming we have a way to get the lecture URL or create a Lecture object, should be done by Huy.
            Lecture lecture = new Lecture(null, summaryServiceInputData.getTranscript());
            Summary summary = summaryDataAccessObject.getSummary(lecture);

            SummaryServiceOutputData outputData = new SummaryServiceOutputData(
                    summary.getSummaryText(),
                    summary.getTopics(),
                    false // No errors
            );

            summaryPresenter.prepareSuccessView(outputData);
        } catch (Exception e) {
            e.printStackTrace();
            summaryPresenter.prepareFailView("An error occurred while generating the summary.");
        }
    }
}
