package bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qing
 * @date 2020 09 12
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(666);

        System.out.println("服务器启动了");

        while (true) {
            // 监听 等待客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");

            // 创建一个线程 与之通讯 单独写一个方法
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    // 与客户端通讯

                }
            });
        }
    }

    // 编写一个 handle 方法 和客户端通讯
    public static void handle(Socket socket){

        try {
            // 通过 socket 获取输入流
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
