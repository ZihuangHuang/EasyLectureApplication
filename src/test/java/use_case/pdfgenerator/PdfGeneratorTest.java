package use_case.pdfgenerator;

import app.JsonToPdfService;

import java.io.File;
import java.nio.file.Files;

public class PdfGeneratorTest {

    public static void main(String[] args) {
        // Paths for the test
        String testJsonFilePath = "test-data.json";
        String testOutputPdfPath = "test-output.pdf";

        // Create a sample JSON file for testing
        createTestJsonFile(testJsonFilePath);

        // Initialize the service
        JsonToPdfService service = new JsonToPdfService();

        // Run the PDF generation test
        System.out.println("Running PDF Generation Test...");
        service.generatePdf(testJsonFilePath, testOutputPdfPath);

        // Validate the output
        File outputPdf = new File(testOutputPdfPath);
        if (outputPdf.exists() && outputPdf.isFile()) {
            System.out.println("Test Passed: PDF generated successfully at " + testOutputPdfPath);
        } else {
            System.err.println("Test Failed: PDF was not generated.");
        }

        // Clean up test files
        cleanupTestFiles(testJsonFilePath, testOutputPdfPath);
    }

    /**
     * Creates a sample JSON file for testing.
     *
     * @param filePath the path to create the file
     */
    private static void createTestJsonFile(String filePath) {
        String sampleJson = """
            {
                "Name": "Jane Doe",
                "Age": 28,
                "Country": "Canada",
                "Hobbies": ["Reading", "Traveling", "Cooking"]
            }
            """;

        try {
            Files.writeString(new File(filePath).toPath(), sampleJson);
            System.out.println("Test JSON file created at " + filePath);
        } catch (Exception e) {
            System.err.println("Error creating test JSON file: " + e.getMessage());
        }
    }

    /**
     * Cleans up the test files after the test is complete.
     *
     * @param jsonFilePath path to the test JSON file
     * @param pdfFilePath  path to the generated PDF file
     */
    private static void cleanupTestFiles(String jsonFilePath, String pdfFilePath) {
        try {
            Files.deleteIfExists(new File(jsonFilePath).toPath());
            Files.deleteIfExists(new File(pdfFilePath).toPath());
            System.out.println("Test files cleaned up.");
        } catch (Exception e) {
            System.err.println("Error cleaning up test files: " + e.getMessage());
        }
    }
}

