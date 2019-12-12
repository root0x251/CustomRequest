import com.wikiCustomRequest.SlavaBortn.WikiCustomRequest;

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
        String searchRequest = reader.readLine();
        WikiCustomRequest wikiCustomRequest = new WikiCustomRequest();


        // search in wikipedia
        while (searchRequest != null) {
            wikiCustomRequest.getSearchRequestWithParam(searchRequest);
            searchRequest = reader.readLine();
        }



    }

}
