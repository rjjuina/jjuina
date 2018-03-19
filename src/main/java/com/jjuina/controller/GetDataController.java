package com.jjuina.controller;

import com.jjuina.utils.HttpHelper;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("data")
public class GetDataController {

    private static List<String> dataList = new ArrayList<String>();

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ModelAndView getAllDatas() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("dataDisplay");

        mav.addObject("dataList", dataList);

        return mav;
    }

    @RequestMapping(value = "/doHttpRequest", method = RequestMethod.POST)
    public ModelAndView getRegionCodesFromSemKeywordEntityRecognitionService(@RequestParam("requestUrl") String requestUrl, @RequestParam("destinations") String destinations) {

        List<String> dess = Arrays.asList(StringUtils.deleteWhitespace(destinations).replace("\"", "").split(","));
        handleResult(dess, requestUrl);

        return new ModelAndView("redirect:getAll");
    }

    private List<String> handleResult(List<String> destinations, String requestUrl) {
        JSONObject res = null;
        for (String des : destinations) {
            String url = requestUrl + des;
            res = HttpHelper.sendGetByHttpURLConnection(url);
            JSONArray entities = (JSONArray) res.get("entities");
            Iterator entitiesIt = entities.iterator();
            while (entitiesIt.hasNext()) {
                JSONObject entitiesObj = (JSONObject) entitiesIt.next();
                JSONArray domainValues = (JSONArray) entitiesObj.get("domainValues");
                Iterator domainValuesIt = domainValues.iterator();
                while (domainValuesIt.hasNext()) {
                    JSONObject dvObj = (JSONObject) domainValuesIt.next();
                    JSONArray idsArr = (JSONArray) dvObj.get("ids");
                    Iterator idsIt = idsArr.iterator();
                    while (idsIt.hasNext()) {
                        JSONObject idObj = (JSONObject) idsIt.next();
                        dataList.add("/" + des + "-Hotels.d" + idObj.get("value") + ".Travel-Guide-Hotels");
                    }
                }
            }

        }
        return dataList;
    }
}
