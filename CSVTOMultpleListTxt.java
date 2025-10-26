import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVTOMultpleListTxt {
    public static void main(String[] args) {
        String inputFileName = "C:\\Users\\kumar2r\\OneDrive - Mavenir Ltd\\Documents\\Prod data\\Line\\finalData.csv";
        int batchSize = 50000;

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
        String outputFileName = "output_local" + batchIndex + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\kumar2r\\OneDrive - Mavenir Ltd\\Documents\\Prod data\\Line\\" + outputFileName))) {
            StringBuffer ppk = new StringBuffer();
            for (String line : batch) {
                String[] values = line.split(",");
                ppk.append("'" + values[0].trim() + "', ");
//                writer.write(values[0]);
//                writer.newLine();
            }
            writer.write("UPDATE sessiondb_dep AS p\n" +
                    "SET p.serviceId = p.msisdn,\n" +
                    "                  p.serviceIdType = \"MSISDN\"\n" +
                    "WHERE p.classId='421'\n" +
                    "\tAND p.state ='ACTIVE'\n" +
                    "\tAND p.serviceId IS NULL\n" +
                    "\tAND p.id IN ["+ ppk +"];");
            writer.newLine();
        }

        System.out.println("Batch " + batchIndex + " written to " + outputFileName);
    }
}
