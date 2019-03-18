package com.alibaba.json.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

/**
 * @author zhangzhiheng
 * @Date 2019-03-05
 * @Description :
 */
public class JsonTest {

    public static void main(String[] args) {
        JSONObject params = new JSONObject();
        JSONArray names = new JSONArray();
        names.add("1");
        names.add("2");
        params.put("name",names);

        System.out.println(params.containsValue(names));
    }
}
