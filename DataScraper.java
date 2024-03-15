/*
 * Problem 2 Sell My Pet Food
 */



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
// import java.util.ArrayList;

public class DataScraper {
  
  public static void main(String[] args) {
    try {
      // each web scrape of a review page requires updating of the url variable with the corresponding html file for that page
    String url = "http://127.0.0.1:5500/AmazonPage9.html";
    Document doc = Jsoup.connect(url).get();
    Elements reviews = doc.select("div.review");
    for (Element review : reviews)
    {
      // accessed the elements of the html file that show reviewer name and the review text
      String reviewerName = review.select("span.a-profile-name").text();
      String reviewText = review.select("span.review-text").text();

      // add the reviewer + the review to socialmediaposts.txt text file
      String fileName = "socialMediaPosts.txt";
      String textToAdd = "Reviewer: " + reviewerName + " Text: " + reviewText;
      TextFileWriter.addTextToFile(fileName, textToAdd);

     } 
    // handle io exception
  } catch (IOException e) {
    e.printStackTrace();
  }

}

}
