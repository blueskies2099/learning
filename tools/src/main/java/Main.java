import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author qing
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\qing\\Desktop\\新建文本文档.txt");
        System.out.println(getFileCharsetByICU4J(file));
    }

    private static String getFileCharsetByICU4J(File file) {
        String encoding = null;
        try{
            Path path = Paths.get(file.getPath());
            byte[] data = Files.readAllBytes(path);
            CharsetDetector detector = new CharsetDetector();
            detector.setText(data);
            CharsetMatch match = detector.detect();

            CharsetMatch[] matches = detector.detectAll();
            if (match == null ){
                return null;
            }
            encoding = match.getName();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return encoding;

    }
}
