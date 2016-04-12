import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.IOException;


/**
 * Created by Ulyana_Opolska on 4/7/2016.
 */
public class LaLaLa {
    int status;
    String contentType;

    public final void httpReqRes () {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
        HttpGet httpget = new HttpGet("http://www.google.com");
        System.out.println("Executing request " + httpget.getRequestLine());

        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            public String handleResponse(
                    final HttpResponse response) throws ClientProtocolException, IOException {
                 status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    System.out.println(status);
                    HttpEntity entity = response.getEntity();
                    System.out.println(entity.getContentType());
                    contentType = EntityUtils.toString(entity);
                    return entity != null ? contentType : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }


        };
            String responseBody = null;
            try {
                responseBody = httpClient.execute(httpget, responseHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        }

    public int getStatus() {
        System.out.println(status);
        return status;
    }

    public String getContentType() {
        return contentType;
    }
}


