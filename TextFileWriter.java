import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

//addtexttofile method takes two parameters, filname and texttoadd, and adds the text to the file
public class TextFileWriter {
    public static void addTextToFile(String fileName, String textToAdd) {
        try {
            // Open the file in append mode
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the text to the file
            bufferedWriter.write(textToAdd);
            bufferedWriter.newLine();

            // Close the writer
            bufferedWriter.close();
            System.out.println("Text added to the file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}