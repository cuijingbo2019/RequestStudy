package ApiTestStudy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * @author cuijingbo
 * @date 2021/6/28 11:34
 */
public class DemoTestRestassured {
    static String access_token;
    @BeforeAll
   public static void GetWxToken(){
        access_token=given()
                    .get(" https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=wwc0c3dfb329c5c9cf&corpsecret=pEepLEBMN-L0L_hf2XDww1bOGAn0WZWYpsTBeTq_gHk")
                    .then()
                    .log().all()
                    .extract()
                    .response()
                    .path("access_token");
    }

    @Test
    void  postMethod(){
        given()
                .contentType("application/json;charset=utf-8")
                .body("{\n" +
                        "   \"touser\" : \"@all\",\n" +
                        "   \"msgtype\" : \"text\",\n" +
                        "   \"agentid\" : 1000002,\n" +
                        "   \"text\" : {\n" +
                        "       \"content\" : \"你的快递已到，请携带工卡前往邮件中心领取。\\n出发前可查看<a href=\\\"http://work.weixin.qq.com\\\">邮件中心视频实况</a>，聪明避开排队。\"\n" +
                        "   },\n" +
                        "}")
                //添加的参数
                .queryParam("access_token",access_token)
                .post("https://qyapi.weixin.qq.com/cgi-bin/message/send")
                .then()
                .log().all();
    }

}
