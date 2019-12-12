import com.wikiCustomRequest.SlavaBortn.WikiCustomRequest;
import com.yandexCustomRequest.SlavaBortn.YandexCustomRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

/**
 * Vyacheslav Alekseevich
 * 11/12/2019
 */

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        WikiCustomRequest wikiCustomRequest = new WikiCustomRequest();
        YandexCustomRequest yandexCustomRequest = new YandexCustomRequest();


        while (!string.equals("")) {
            // wiki search
//            wikiCustomRequest.getSearchRequestWithParam(string);

            // yandex translator en -> ru
            yandexCustomRequest.getTranslateRequest(string);
            string = reader.readLine();
        }





    }

}
