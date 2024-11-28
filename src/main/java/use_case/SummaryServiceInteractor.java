package use_case;

import entity.Lecture;
import entity.Summary;

/**
 * The summary service interactor.
 */
public class SummaryServiceInteractor implements SummaryServiceInputBoundary {
    private final SummaryServiceUserDataAccessInterface summaryDataAccessInterface;
    private final SummaryServiceOutputBoundary summaryOutputBoundary;


    public SummaryServiceInteractor(SummaryServiceUserDataAccessInterface summaryDataAccessInterface,
                                    SummaryServiceOutputBoundary summaryOutputBoundary) {
        this.summaryDataAccessInterface = summaryDataAccessInterface;
        this.summaryOutputBoundary = summaryOutputBoundary;


    }

    @Override
    public void execute(SummaryServiceInputData summaryServiceInputData) {
        try {
            // Assuming we have a way to get the lecture URL or create a Lecture object, should be done by Huy.
            Lecture lecture = new Lecture(null, summaryServiceInputData.getTranscript());
            Summary summary = summaryDataAccessInterface.getSummary(lecture);

            SummaryServiceOutputData outputData = new SummaryServiceOutputData(
                    summary.getSummaryText(),
                    summary.getTopics(),
                    false
            );

            summaryOutputBoundary.prepareSuccessView(outputData);
        } catch (Exception e) {
            e.printStackTrace();
            summaryOutputBoundary.prepareFailView("An error occurred while generating the summary.");
        }
    }
}
