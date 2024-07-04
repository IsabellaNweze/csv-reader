import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String file = "C:\\JAVA projects\\CSVFiles\\src\\tips.csv";
        BufferedReader reader = null;
        String line = "";
        int maxLines = 100; // Assume a maximum number of lines
        String[] lines = new String[maxLines];
        int lineCount = 0;

        // Variables to store statistics
        int numFemales = 0;
        int numMales = 0;
        int totalLunch = 0;
        int totalDinner = 0;
        int totalSundaySize = 0;

        try {
            reader = new BufferedReader(new FileReader(file));
            Scanner scanner = new Scanner(reader);

            // Skip the header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine() && lineCount < maxLines) {
                lines[lineCount] = scanner.nextLine();
                String[] columns = lines[lineCount].split(",");

                String sex = columns[2];
                String day = columns[4];
                String time = columns[5];
                int size = Integer.parseInt(columns[6]);

                if (sex.equals("Female")) {
                    numFemales++;
                } else if (sex.equals("Male")) {
                    numMales++;
                }

                if (time.equals("Lunch")) {
                    totalLunch++;
                } else if (time.equals("Dinner")) {
                    totalDinner++;
                }

                if (day.equals("Sun")) {
                    totalSundaySize += size;
                }

                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Print out the statistics
        System.out.println("Number of females: " + numFemales);
        System.out.println("Number of males: " + numMales);
        System.out.println("Total lunch: " + totalLunch);
        System.out.println("Total dinner: " + totalDinner);
        System.out.println("Total Sunday sizes: " + totalSundaySize);
    }
}
