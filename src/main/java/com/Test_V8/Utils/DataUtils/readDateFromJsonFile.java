package com.Test_V8.Utils.DataUtils;

import com.Test_V8.Utils.LogUtil.LogUtils;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class readDateFromJsonFile {

    static String jsonData = "";
    String jsonPath = "src/test/resources/";
    String jsonFileName = "";


    // constructor to read json file
    public readDateFromJsonFile(String jsonFileName) {
        this.jsonFileName = jsonFileName;
        try {
            JSONObject object = (JSONObject) new JSONParser().parse(new FileReader(jsonPath + jsonFileName + ".json"));
            jsonData = object.toJSONString();
        } catch (Exception e) {
            LogUtils.error("Failed to parse json file" + e.getMessage());
        }


    }


    // get json  key
    public static String getJsonKey(String key)
    {
        String testData="";
        try {
            testData= JsonPath.read(jsonData,key);
        }catch (Exception e)
        {
            LogUtils.error("failed to get key from json file"+e.getMessage());
        }
        return testData;
    }


}
