package cn.codingstyle.base;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Service
@Slf4j
public class RestCall {
    @Setter
    private String token;
    private OkHttpClient httpClient;
    @Autowired
    private Environment env;


    @PostConstruct
    public void init() {
        httpClient = new OkHttpClient.Builder().build();
    }

    public String post(String url, String content) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(getServer() + url)
                .post(RequestBody.create(MediaType.parse("application/json"), content));
        return callRequest(builder);
    }

    private String getServer() {
        return "http://localhost:" + env.getProperty("local.server.port") + "/";
    }

    private String callRequest(Request.Builder builder) throws IOException {
        if (token != null) {
            builder = builder.addHeader("Authorization", token);
        }
        Request request = builder.build();
        Response response = httpClient.newCall(request).execute();
        if (response.code() != 200) {
            log.warn(response.body().string());
        }
        assertThat(response.code(), is(200));
        return response.body().string();
    }

    public String get(String url) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(getServer() + url)
                .get();
        return callRequest(builder);

    }

    public String delete(String url) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(getServer() + url)
                .delete();
        return callRequest(builder);

    }

    public String put(String url, String body) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(getServer() + url)
                .put(RequestBody.create(MediaType.parse("application/json"), body));
        return callRequest(builder);
    }

}
