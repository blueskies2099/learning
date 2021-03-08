import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author qing
 */
public class Main {
    public static void main(String[] args) {
        InputStream in = null;
        try{
            Process pro = Runtime.getRuntime().exec(new String[]{"/bin/zsh", "-c", "ps -ef|grep java"});
            pro.waitFor();
            in = pro.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = read.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
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
