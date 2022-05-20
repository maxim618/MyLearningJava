import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
        StringBuilder text = new StringBuilder();
        while (reader1.ready()){
            text.append(reader1.readLine());
        }
        reader1.close();
        Document document = Jsoup.parse(text.toString(),"",Parser.xmlParser());
        Elements elem = document.select(args[0]);
        for (Element elements : elem) {
            System.out.println(elements);
        }
    }
}
