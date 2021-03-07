package server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 主类
 */
public class Bootstrap {
    /**
     * 定义端口号
     */
    private int port = 18080;
    public int getPort(){
        return port;
    }

    public void setPort(int port){
        this.port = port;
    }

    /**
     * 入口
     * @param args
     */
    public static void main(String[] args){
        Bootstrap bootstrap = new Bootstrap();
        try{
            bootstrap.start();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * 启动前初始化工作
     * @throws IOException
     */
    public void start() throws IOException{
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("=========>Bzcat start on port :" +port);


        while(true){
            Socket socket = serverSocket.accept();

            OutputStream outputStream = socket.getOutputStream();
            String data = "Hello Bzcat";
            String responseText = HttpProtocolUtil.getHttpHeader200(data.getBytes().length) + data;
            outputStream.write(responseText.getBytes());
            socket.close();
        }
    }

}
