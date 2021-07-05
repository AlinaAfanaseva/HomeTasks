import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Loader
{

    public static void main(String[] args) throws Exception
    {
        long usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        try {
            String fileName = "res/data-18M.xml";
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(new File(fileName), handler);
            handler.printDuplicatedVoters();
        }catch (NullPointerException n){
            n.printStackTrace();
        }
        usage =  Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - usage;
        System.out.println("Memory is : " + usage);
        
    }

}