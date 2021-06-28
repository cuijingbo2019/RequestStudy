package ApiTestStudy;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author cuijingbo
 * @date 2021/6/28 10:35
 */
public class HttpClientTest {
    @Test
    void getMethod() throws IOException {
        //获得http客户端
        CloseableHttpClient httpClient=  HttpClientBuilder.create().build();
        //创建get请求
        HttpGet httpGet=new HttpGet("http://www.baidu.com");
        //执行get请求，获取响应
        CloseableHttpResponse response= httpClient.execute(httpGet);
        //从响应中获取响应体
        HttpEntity resEntity=response.getEntity();
        System.out.println(EntityUtils.toString(resEntity,"utf-8"));
    }
    @Test
    void  postMethod() throws IOException {
        //获得http客户端
        CloseableHttpClient httpClient=  HttpClientBuilder.create().build();
        // 创建Post请求
        HttpPost httpPost = new HttpPost("http://localhost:12345/doPostControllerOne");
        //获取响应
        CloseableHttpResponse response=httpClient.execute(httpPost);
        //从响应中获取响应体
        HttpEntity resEntity=response.getEntity();
        System.out.println(EntityUtils.toString(resEntity,"utf-8"));
    }
}
