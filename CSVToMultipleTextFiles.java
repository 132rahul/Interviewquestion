import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVToMultipleTextFiles {
    public static void main(String[] args) {
        //Input file location
        String csvFile = "C:\\Users\\kumar2r\\OneDrive - Mavenir Ltd\\Documents\\Input.csv";
        //Query count in File
        int linesPerFile = 75;
        int fileIndex = 1;
        int lineCount = 0;
        String line = "";
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            BufferedWriter writer = createNewFileWriter(fileIndex);

            while ((line = br.readLine()) != null) {
                String[] val = line.split(splitBy);
                String str = "UPDATE sessiondb_dep a\n" +
                        "SET orderLine.serviceId= '0" + val[2] + "' FOR orderLine IN a.orderLines WHEN orderLine.billingLineId='" + val[0] + "' AND orderLine.serviceId IS NULL END\n" +
                        "WHERE a.classId=\"700\"\n" +
                        "    AND a.id='" + val[1] + "';";
                writer.newLine();
                writer.write(str);
                writer.newLine();
                lineCount++;

                if (lineCount % linesPerFile == 0) {
                    writer.close();
                    fileIndex++;
                    writer = createNewFileWriter(fileIndex);
                }
            }

            // Close the last writer if it is still open
            if (lineCount % linesPerFile != 0) {
                writer.close();
            }

            System.out.println("Data successfully written to multiple files.");
        } catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
        }
    }

    private static BufferedWriter createNewFileWriter(int fileIndex) throws IOException {
        String fileName = "Stg1_rahul_output" + fileIndex + ".txt";
        //output file location
        return new BufferedWriter(new FileWriter("C:\\Users\\kumar2r\\OneDrive - Mavenir Ltd\\Documents\\"+fileName));
    }
}
