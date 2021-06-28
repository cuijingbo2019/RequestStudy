package ApiTestStudy;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

/**
 * @author cuijingbo
 * @date 2021/6/11 16:33
 */
public class wiremockTest {
    static WireMockServer wireMockServer;

    @BeforeAll
    public  static void initData(){
        wireMockServer = new WireMockServer(wireMockConfig().port(8089)); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();
        //指定ip和端口信息
        configureFor("localhost",8089);

    }
    @Test
    public  void  stupMock() {

        try {
            stubFor(get(urlEqualTo("/my/resource"))
                    .withHeader("Accept", equalTo("text/xml"))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type","text/xml")
                            .withBody("<respinse>Some content</response>")));//端口返回内容
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void  easy_mock(){
        try {
            stubFor(get(urlEqualTo("/my/resource"))
                    .withHeader("Accept",equalTo("text/xml"))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type","text/xml")
                            .withBody("<response>名企定向4期</response>")));
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void proxy_mock(){
        try {
            stubFor(get(urlMatching(".*")).atPriority(10)
                    .willReturn(aResponse().proxiedFrom("https://ceshiren.com")));

            stubFor(get(urlEqualTo("/categories_and_latest")).atPriority(10)
                    //从本地resource下读取文件，类似与charles 的maplocal功能
                    //出现path无法正常读取清况，用substring
                    .willReturn(aResponse().withBody(Files.readAllBytes(Paths.get(wiremockTest.class.getResource("/mock.json").getPath().substring(1))))));


            Thread.sleep(50000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }




}
