package starter.Util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtil {
    
public static Object readJsonFile (String filePath) throws IOException, ParseException {
    Object obj = new Object();
    JSONParser jsonParser = new JSONParser();
    try (FileReader reader = new FileReader(filePath)) {
        obj = jsonParser.parse(reader);
    } catch (FileNotFoundException e){
        e.printStackTrace();
    }
    return obj;
}

}
