package com.yandexCustomRequest.SlavaBortn;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Vyacheslav Alekseevich
 * 12/12/2019
 */

public class YandexCustomRequest {
    // translator
    public void getTranslateRequest(String word) throws URISyntaxException, IOException {
        if (!word.equals("")) {
            String apiKey = "trnsl.1.1.20191205T080823Z.bb65c6959adee4c4.a52d173186b595d60cb30c4222c79fef09d6c904";
            String lang = "en-ru";

            URIBuilder url = new URIBuilder("https://translate.yandex.net/api/v1.5/tr.json/translate");

            url.addParameter("key", apiKey);
            url.addParameter("text", word);
            url.addParameter("lang", lang);

            HttpGet request = new HttpGet(url.toString());
            request.addHeader(HttpHeaders.ACCEPT_LANGUAGE, "ru-RU");
            request.addHeader(HttpHeaders.ACCEPT_ENCODING, "utf-8");

            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpClient.execute(request)) {

                int statusCode = response.getStatusLine().getStatusCode();
                HttpEntity entity = response.getEntity();

                if (statusCode == 200) {
                    if (entity != null) {
                        String result = EntityUtils.toString(entity);
                        JSONObject jsonObject = new JSONObject(result);
                        JSONArray array = jsonObject.getJSONArray("text");
                        System.out.println(word + " -> " + lang + " = " + array.get(0));
                    }
                }
            }
        }
    }
}
