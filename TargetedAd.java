import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;


public class TargetedAd {
    public static int countPosts() {
        int count = 0;
        try {
            String fileName = "socialMediaPosts.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
            
            // Read each line from the file
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Reviewer:")) {
                 count++;                
            }
        }
            
            // Close the BufferedReader
            reader.close();
        }
        catch (IOException e) {
            // Handle any potential IO exceptions
            e.printStackTrace();
        }

        return count;
    }
    
    public static void reviewRanking() {
        try {
        BufferedReader reader1 = new BufferedReader(new FileReader("socialMediaPosts.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("targetedwords.txt"));

        String line1;
        String line2;

        ArrayList<String> targwords = new ArrayList<>();
        ArrayList<String> reviewers = new ArrayList<>();
         
        //while loop to create targeted words array list to traverse
        while (((line2 = reader2.readLine()) != null)) {
            targwords.add(line2);
        }

        //testing
        // System.out.println(targwords); 
        // System.out.println(smp);

        // traverses targeted words and social media posts, and associates a point value of significance with each reviewer
        // also adds the reviewer's name and the point value associated with it to the targetmarket.txt file
        while ((line1 = reader1.readLine()) != null) {
            int points = 0;
            String reviewername = line1.substring(line1.indexOf(":")+2, line1.indexOf("Text"));
            for (int i = 0; i<targwords.size(); i++) {
                String getter = targwords.get(i);
                    if (line1.contains(getter.substring(0, getter.indexOf("-")))) {
                        points += Integer.parseInt(getter.substring(getter.indexOf("-")+1));                    
                }
            }
            // check for duplicates
            if ((points != 0) && (reviewers.indexOf(reviewername) == -1)) {
                TextFileWriter.addTextToFile("targetmarket.txt", reviewername + points);
                reviewers.add(reviewername);
            }
        }

        reader1.close();
        reader2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


