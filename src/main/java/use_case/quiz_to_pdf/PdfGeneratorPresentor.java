package use_case.quiz_to_pdf;

import use_case.quiz_to_pdf.PdfGeneratorOutputData;

public class PdfGeneratorPresentor implements use_case.quiz_to_pdf.PdfGeneratorOutputBoundary {
    @Override
    public void present(PdfGeneratorOutputData outputData) {
        if (outputData.isSuccess()) {
            System.out.println("SUCCESS: " + outputData.getMessage());
        } else {
            System.out.println("ERROR: " + outputData.getMessage());
        }
    }
}

