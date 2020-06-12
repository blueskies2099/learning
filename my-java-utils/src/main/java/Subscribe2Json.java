import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Set;

public class Subscribe2Json {
    public static Base64.Decoder decoder = Base64.getMimeDecoder();

    public static void main(String[] args) throws IOException {
        ArrayList<HashMap<String, String>> tmps = get("test");
        for (HashMap tmp : tmps
        ) {
            Set<String> set = tmp.keySet();
            for (String s : set
            ) {
                System.out.println(s + ": " + tmp.get(s));
            }
            System.out.println("");
        }
    }

    /**
     * 获取结果主方法
     *
     * @param urlStr
     * @return
     * @throws IOException
     */
    public static ArrayList<HashMap<String, String>> get(String urlStr) throws IOException {
        ArrayList<HashMap<String, String>> ssrLists = new ArrayList();
        // 第一次解密 并进行切割 ssr://
        String[] ssrUrls = decodeStr(getDecodedCode(urlStr)).split("ssr://");
        for (int i = 1; i < ssrUrls.length; i++) {
            HashMap<String, String> tmpKV = new HashMap<>();

            //第二次解码并进行切割 :
            ssrUrls[i] = decodeStr(ssrUrls[i]);
            String[] earlyData = ssrUrls[i].split(":");

            tmpKV.put("server", earlyData[0]);
            tmpKV.put("port", earlyData[1]);
            tmpKV.put("protocol", earlyData[2]);
            tmpKV.put("method", earlyData[3]);
            tmpKV.put("obfs", earlyData[4]);

            String[] interimData = earlyData[5].split("\\/\\?");
            tmpKV.put("password", decodeStr(interimData[0]));

            //处理尾部字符串
            HashMap<String, String> tailKV = handleTail(interimData[1]);
            tmpKV.putAll(tailKV);
            ssrLists.add(tmpKV);
        }
        return ssrLists;
    }

    /**
     * 处理尾部字符串
     *
     * @param tailStr
     * @return
     */
    private static HashMap<String, String> handleTail(String tailStr) {
        HashMap<String, String> tailKV = new HashMap<>();
        String[] taiStrs = tailStr.split("&");
        for (String item : taiStrs
        ) {
            String[] tmp = item.split("=");
            if (tmp.length == 2) {
                tailKV.put(tmp[0], decodeStr(tmp[1]));
            } else {
                tailKV.put(tmp[0], "");
            }
        }
        return tailKV;
    }

    /**
     * 将特殊字符替换掉后 进行解码
     *
     * @param str
     * @return
     */
    private static String decodeStr(String str) {
        return new String(decoder.decode(str.replace("-", "+").replace("_", "/")));
    }

    /**
     * 通过订阅地址 返回加密过的字符
     *
     * @param urlStr
     * @return
     * @throws IOException
     */
    private static String getDecodedCode(String urlStr) throws IOException {
        String res = "";
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            res += line;
        }
        in.close();
        return res.trim();
    }
}
