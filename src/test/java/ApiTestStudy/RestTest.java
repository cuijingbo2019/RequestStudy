package ApiTestStudy;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
/**
 * @author cuijingbo
 * @date 2021/6/28 11:06
 */
public class RestTest {
    @Test
    void  testGet(){
        //发送一个get请求，url是http://www.baidu.com，then()是断言，statusCode(200)是响应状态码等于200。
        given()
                .get("http://www.baidu.com")
                .then()
                .statusCode(200);
        //log().all(),打印所有log,请求体和响应
        given()
                .log().all()
                    .get("http://www.baidu.com")
                .then()
                .log().all()
                    .statusCode(200);
    }
    @Test
    public void testMp3(){
        //given（）：一次网络请求所需要的条件都写在这里，头信息、query参数
        given()
                .queryParam("wd","mp3")
                //触发条件
                .when()
                .get("http://www.baidu.com/s")
                //断言
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testSearch() {
            //given开头表示输入数据
        given().log().all()
                //query请求参数
                .queryParam("code", "sogo")
                //头信息，cookie记得替换
                .header("Cookie","_ga=GA1.2.506579530.1552574503; device_id=0158c91c7ecd8e4d248a54002af6d8ae; aliyungf_tc=AQAAAIatGzFrQgoAJGDMeOsikkxtPFqv; xq_a_token=682c39a460645dafb1ff41f67e0efccba8b0f118; xq_a_token.sig=Bg9acTC-woVSsS6DZvdAtd40CQU; xq_r_token=798a7cab8cd606f61a09fbac15374f1172b00607; xq_r_token.sig=sHSWFNmu_GqEUOK9A-6umfNgFcU; _gid=GA1.2.841306833.1553178554; Hm_lvt_1db88642e346389874251b5a1eded6e3=1552574504,1552736056,1553178554; u=881553178554746; _gat=1; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1553180196")
                //when表示触发条件
                .when()
                .get("https://xueqiu.com/stock/search.json")
                //then对结果断言
                .then()
                //打印log
                .log().all()
                //断言状态码
                .statusCode(200)
                //字段断言
                .body("stocks.name",hasItems("搜狗"))
                .body("stocks.code",hasItems("sogo"));
    }

}

