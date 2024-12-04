package use_case.quiz_to_pdf;

public class PdfGenerator {
    public static void execute() {
        PdfGeneratorPresentor presenter = new PdfGeneratorPresentor();
        PdfGeneratorInteractor interactor = new PdfGeneratorInteractor(presenter);
        PdfGeneratorUserAccessInterface controller = new PdfGeneratorUserAccessInterface(interactor);

        controller.generatePdf("data/input.json", "output/result.pdf");
    }
}


