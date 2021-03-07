package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Response {
    private OutputStream outputStream;

    public Response(OutputStream outputStream){
        this.outputStream = outputStream;
    }
    public Response(){

    }

    public void outputHtml(String path)throws IOException {
        //获取静态资源的绝对路径
        String absoluteResourcePath = StaticResourceUtil.getAbsolutePath(path);


        //输出静态资源文件
        File file = new File(absoluteResourcePath);
        if(file.exists() && file.isFile()){
            //读取静态文件，获取静态资源
            StaticResourceUtil.outputStaticResource(new FileInputStream(file),outputStream);
        }else{
            //输出404
            output(HttpProtocolUtil.getHttpHeader404());
        }

    }






    public void output(String context) throws IOException{
        outputStream.write(context.getBytes());
    }

}
