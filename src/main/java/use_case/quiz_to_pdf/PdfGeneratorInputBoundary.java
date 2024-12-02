package use_case.quiz_to_pdf;

import use_case.quiz_to_pdf.PdfGeneratorInputData;

public interface PdfGeneratorInputBoundary {
    void generate(PdfGeneratorInputData inputData);
}

