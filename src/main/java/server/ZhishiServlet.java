package server;

import java.io.IOException;

public class ZhishiServlet extends HttpServlet{
    @Override
    public void doGet(Request request, Response response) {
        String content="<h1>BaozhuoServlet get</h1>";
        try {
            response.output(HttpProtocolUtil.getHttpHeader200(content.getBytes().length)+content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(Request request, Response response) {
        String content="<h1>BaoServlet post</h1>";
        try {
            response.output(HttpProtocolUtil.getHttpHeader200(content.getBytes().length)+content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void destory() throws Exception {
        super.destory();
    }
}
