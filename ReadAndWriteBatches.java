import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteBatches {
    public static void main(String[] args) {
        String inputFileName = "example.csv";
        int batchSize = 50;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            List<String> currentBatch = new ArrayList<>();
            int batchIndex = 1;

            while ((line = br.readLine()) != null) {
                currentBatch.add(line);

                if (currentBatch.size() == batchSize) {
                    writeBatchToFile(currentBatch, batchIndex);
                    currentBatch.clear();
                    batchIndex++;
                }
            }

            // Write the remaining lines as the last batch
            if (!currentBatch.isEmpty()) {
                writeBatchToFile(currentBatch, batchIndex);
            }

            System.out.println("Data successfully written to multiple files.");
        } catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
        }
    }

    private static void writeBatchToFile(List<String> batch, int batchIndex) throws IOException {
        String outputFileName = "output" + batchIndex + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (String line : batch) {
                writer.write(line);
                writer.newLine();
            }
        }

        System.out.println("Batch " + batchIndex + " written to " + outputFileName);
    }
}
