package com.wikiCustomRequest.SlavaBortn;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Vyacheslav Alekseevich
 * 11/12/2019
 */

public class WikiCustomRequest {

    public void getSearchRequestWithParam(String searchRequest) throws IOException, URISyntaxException {
        // create URL
        if (searchRequest != null) {
            URIBuilder urlWithParam = new URIBuilder("https://ru.wikipedia.org/w/api.php");
            urlWithParam.addParameter("action", "opensearch");
            urlWithParam.addParameter("utf8", "1");
            urlWithParam.addParameter("limit", "1");
            urlWithParam.addParameter("search", searchRequest);

            HttpGet request = new HttpGet(urlWithParam.toString());
            request.addHeader(HttpHeaders.ACCEPT_LANGUAGE, "ru-RU");
            request.addHeader(HttpHeaders.ACCEPT_ENCODING, "utf-8");

            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpClient.execute(request)) {

                int statusCode = response.getStatusLine().getStatusCode();
                HttpEntity entity = response.getEntity();

                if (statusCode == 200) {
                    if (entity != null) {
                        String searchResult = EntityUtils.toString(entity);
                        Pattern p = Pattern.compile("\".*?\"");
                        Matcher m = p.matcher(searchResult);
                        String[] result = new String[4];
                        int counter = 0;
                        while (m.find()) {
                            result[counter] = String.valueOf(m.group().subSequence(1, m.group().length() - 1));
                            counter++;
                        }

                        if (result[1] != null) {
                            for (String s : result) {
                                if (s != null) {
                                    System.out.println(s);
                                }
                            }
                        } else {
                            System.out.println("поиск " + searchRequest + " не дал результат");
                        }
                    }
                }
            }
        }
    }
}
