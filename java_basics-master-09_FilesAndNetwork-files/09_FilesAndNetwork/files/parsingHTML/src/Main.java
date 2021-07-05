import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


private static final String WEB_URL = "https://www.lenta.ru";

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect(WEB_URL).get();
        Elements imagesURLs = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
        imagesURLs.forEach(i -> {
            try {
                FileUtils.copyURLToFile(new URL(i.attr("src")),
                        new File("Stage9/src/main/java/LentaImageDownloader/lenta.ru/" +
                                i.attr("src")
                                        .substring(i.attr("src").lastIndexOf("/"))));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        System.out.println("=============================================================");
        System.out.println("Result of doings: " + Files.exists(Paths.get("/home/afanaseva/Рабочий стол/parsingHTML/gotten_images/img.txt")));
    }

    public static void getName(ArrayList<Image> images){
       String name = String.valueOf(images.toString().trim().lastIndexOf("/"));
    }


    public static String parseFile(String path){

       StringBuilder builder = new StringBuilder();
       try{
           List<String> lines = Files.readAllLines(Paths.get(path));
           lines.forEach(line -> builder.append(line + "\n"));
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return builder.toString();
   }
}
