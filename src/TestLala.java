import org.testng.Assert;
import org.testng.annotations.Test;



public class TestLala {
    @Test
    public void testHttp () throws Exception {
        LaLaLa la = new LaLaLa();

        //verify if response status is correct
        la.httpReqRes();
        int status = la.getStatus();
        Assert.assertEquals(status, 200, "Http request code is not 200");

        //verify if content type is correct
        String expContType = "<!doctype html>";
        String contentType = la.getContentType();
        boolean ifCorrectContType = contentType.contains(expContType);
        System.out.println("Content type is http: " + ifCorrectContType);

        //verify if response body contains expected string
        String expRespBody = "<div id=\"hplogo\">";
        boolean ifRespContStr = contentType.contains(expRespBody);
        System.out.println("Response body contains expected string: " + ifRespContStr);
    }
}
