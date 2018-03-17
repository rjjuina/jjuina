package com.jjuina.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HttpHelper {
    /**
     * start a http request and return result with json
     *
     * @param requestUrl
     * @return
     */
    public static JSONObject sendGetByHttpURLConnection(String requestUrl) {
        String res = "";
        JSONObject object = null;
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if (200 == urlConnection.getResponseCode()) {
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String str = null;
                while ((str = bufferedReader.readLine()) != null) {
                    buffer.append(str);
                }
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
                res = buffer.toString();
                object = new JSONObject(res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static JSONObject setPostByHttpURLConnect(String requestUrl, String params) {
        URL url = null;
        try {
            url = new URL(requestUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            // httpURLConnection.setConnectTimeout(10000);
            // httpURLConnection.setReadTimeout(2000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            // send data
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            printWriter.write(params);
            printWriter.flush();

            //            get data
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while ((len = bufferedInputStream.read(arr)) != -1) {
                byteArrayOutputStream.write(arr, 0, len);
                byteArrayOutputStream.flush();
            }
            byteArrayOutputStream.close();
            return new JSONObject(byteArrayOutputStream.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String args [] ) {
        JSONObject res = null;
        //        res = sendGetByHttpURLConnection("https://sem-keyword-entity-recognition-service.us-east-1.bigdata.expedia.com/entity/parse?locale=en_IE&siteId=4400&keyword=Florence");
        ////        res = setPostByHttpURLConnect("http://ip.taobao.com/service/getIpInfo.php?ip=63.223.108.42","123");
        //        System.out.println(res);
        //        System.out.println(res.get("code"));
        //        System.out.println(res.get("data"));

//        List<String> result = new ArrayList<String>();
//        String[] dess = {"Florence", "Faro", "Budapest"};
//        List<String> destinations = Arrays.asList(dess);
//        for(String des : destinations) {
//            String url = "https://sem-keyword-entity-recognition-service.us-east-1.bigdata.expedia.com/entity/parse?locale=en_IE&siteId=4400&keyword=" + des;
//            res = sendGetByHttpURLConnection(url);
//            JSONArray entities = (JSONArray)res.get("entities");
//            Iterator entitiesIt = entities.iterator();
//            while (entitiesIt.hasNext()) {
//                JSONObject entitiesObj = (JSONObject)entitiesIt.next();
//                JSONArray domainValues = (JSONArray)entitiesObj.get("domainValues");
//                Iterator domainValuesIt = domainValues.iterator();
//                while (domainValuesIt.hasNext()) {
//                    JSONObject dvObj = (JSONObject)domainValuesIt.next();
//                    JSONArray idsArr = (JSONArray)dvObj.get("ids");
//                    Iterator idsIt = idsArr.iterator();
//                    while (idsIt.hasNext()) {
//                        JSONObject idObj = (JSONObject)idsIt.next();
//                        result.add("/" + des + "-Hotels.d" + idObj.get("value") + ".Travel-Guide-Hotels");
//                    }
//                }
//            }
//
//        }
//        System.out.println(result.toString());
    }
}
