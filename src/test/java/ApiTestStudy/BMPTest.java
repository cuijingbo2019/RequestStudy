package ApiTestStudy;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author cuijingbo
 * @date 2021/6/24 19:09
 */
public class BMPTest {
    @Test
    public void bmp() throws IOException {
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(8080);
        int port = proxy.getPort();
        //通过filter完成处理过程
        //har可以拿到每个接口响应
        //latency  延迟
        proxy.addResponseFilter((response,contents,messageInfo)->{
            if (messageInfo.getOriginalUrl().contains(".json")){
                //todo:json->hashmap->rescue->hashmap->json
                String contentNew=contents.getTextContents().replaceAll(":\"[^\"]*\"", "null");
                contents.setTextContents(contentNew);
            }
        });

        proxy.addRequestFilter((request,contents,messageInfo)->{
           request.setUri("/");

           return null;
        });


        System.in.read();
    }

}
