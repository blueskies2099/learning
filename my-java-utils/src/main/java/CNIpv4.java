import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CNIpv4 {
    /* Apanic IP地址分配信息总表 */
    private static String apanicIpTableUrl = "http://ftp.apnic.net/apnic/stats/apnic/delegated-apnic-latest";

    /**
     * @param href 需要判断的http网址
     * @return
     */
    public static boolean isCNIp(String href) throws IOException {
        String ip = ip(href);
        Pattern p1 = Pattern.compile("(\\|CN\\|ipv4\\|)");
        Pattern p2 = Pattern.compile("(\\d+)[\\d.]+\\|\\d+");
        URL url = new URL(apanicIpTableUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\cn.txt")));
        String line;
        Matcher m1, m2;
        while ((line = in.readLine()) != null) {
            m1 = p1.matcher(line);
            if (m1.find()) {        // 过滤CN ipv4
                m2 = p2.matcher(line);
                if (m2.find()) {    // 过滤ipv4
                    String[] tmp = m2.group().split("\\|");
                    int subMask = (int) (Math.log(Double.valueOf(tmp[1].toString())) / Math.log(2));
                    // out.write(tmp[0] + "/" + subMask);
                    // out.newLine();
                    // out.flush();
                    if (judgeIP(tmp[0], ip, subMask)) {
                        System.out.println("国内地址");
                        return true;
                    }
                }
            }
        }
        in.close();
        out.close();
        return false;
    }

    /**
     * 从url获取ip
     *
     * @param href
     * @return
     * @throws MalformedURLException
     * @throws UnknownHostException
     */
    private static String ip(String href) throws MalformedURLException, UnknownHostException {
        String ip;
        URL url = new URL(href);
        String host = url.getHost();
        System.out.println(host);
        ip = InetAddress.getByName(host).getHostAddress(); //获取ip
        System.out.println(ip);
        return ip;
    }

    /**
     * 判断ip是否属于该ip段
     *
     * @param ipBlock
     * @param ip
     * @param subMask
     * @return
     */
    private static boolean judgeIP(String ipBlock, String ip, int subMask) {
        int shift = 32 - subMask;
        int ibs = ip2Long(ipBlock) >>> shift;
        int ips = ip2Long(ip) >>> shift;
        if ((ibs ^ ips) == 0) {
            return true;
        }
        return false;
    }

    /**
     * 将ip(字符串)转成long类型
     *
     * @param ip
     * @return
     */
    private static int ip2Long(String ip) {
        String[] fields = ip.split("\\.");
        int[] tmp = new int[4];
        for (int i = 0; i < 4; i++) {
            tmp[i] = Integer.parseInt(fields[i]);
        }

        return ((tmp[0] & 0xff) << 24) + ((tmp[1] & 0xff) << 16) + ((tmp[2] & 0xff) << 8) + (tmp[3] & 0xff);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(isCNIp("https://blog.csdn.net/xiaoli_feng/article/details/4567184"));
    }
}
