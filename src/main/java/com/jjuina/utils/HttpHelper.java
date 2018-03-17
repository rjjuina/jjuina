package com.jjuina.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

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
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int status = connection.getResponseCode();
            if (200 == status) {
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String inputLine;
                while ((inputLine = bufferedReader.readLine()) != null) {
                    content.append(inputLine);
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
                connection.disconnect();

                res = content.toString();
                object = new JSONObject(res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static JSONObject setPostByHttpURLConnect(String requestUrl, Map<String, String> params) {
        URL url = null;
        try {
            url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            // connection.setConnectTimeout(10000);
            // connection.setReadTimeout(2000);
            connection.setDoOutput(true);
            connection.setDoInput(true);

            // send data
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getParameterString(params));
            out.flush();
            out.close();

            // get data
            int status = connection.getResponseCode();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if(200 == status) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(connection.getInputStream());
                int len;
                byte[] arr = new byte[1024];
                while ((len = bufferedInputStream.read(arr)) != -1) {
                    byteArrayOutputStream.write(arr, 0, len);
                    byteArrayOutputStream.flush();
                }
                byteArrayOutputStream.close();
            }
            return !"".equals(byteArrayOutputStream.toString())
                    ? new JSONObject(byteArrayOutputStream.toString())
                    : new JSONObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String args [] ) {
        JSONObject res = null;
//        res = sendGetByHttpURLConnection("https://sem-keyword-entity-recognition-service.us-east-1.bigdata.expedia.com/entity/parse?locale=en_IE&siteId=4400&keyword=Florence");
        res = setPostByHttpURLConnect("http://ip.taobao.com/service/getIpInfo.php?ip=63.223.108.42", new HashMap<String, String>());
        System.out.println(res);
        System.out.println(res.get("code"));
        System.out.println(res.get("data"));

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
