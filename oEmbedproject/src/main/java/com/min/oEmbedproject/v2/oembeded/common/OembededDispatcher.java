package com.min.oEmbedproject.v2.oembeded.common;

import com.min.oEmbedproject.exception.NotCollectDataException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OembededDispatcher {

    //플랫폼의 oEmbed 서비스에서 원하는 url의 데이터를 받아오는 메서드
    public static String collectOembedData(String completeOembedUrl) {

        BufferedReader in = null;
        String resultData = null;

        try {
            URL resultUrl = new URL(completeOembedUrl);
            HttpURLConnection con = (HttpURLConnection) resultUrl.openConnection();
            con.setRequestMethod("GET");

            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

            String line;

            while ((line = in.readLine()) != null) {
                resultData = line;
            }

            return resultData;
        } catch (IOException e) {
            e.printStackTrace();
            throw new NotCollectDataException(e);
        }
    }
}
