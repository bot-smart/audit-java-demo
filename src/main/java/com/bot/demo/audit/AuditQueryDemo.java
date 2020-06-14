package com.bot.demo.audit;

import com.bot.demo.util.OkHttpUtil;
import com.bot.demo.util.SignUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

public class AuditQueryDemo {
    private static Log loger = LogFactory.getLog(AuditQueryDemo.class);


    private static final String APP_ID = "请输入appId";
    private static final String APP_SECRET = "请输入appKey";
    private static final String BUSINESS_ID = "请输入businessID";
    private static final String API_URL = "https://api.botsmart.cn/v1/check/query";

    public static void main(String[] args) {
        SortedMap<String, String> params = new TreeMap<>();
        params.put("business_id", BUSINESS_ID);
        params.put("app_id", APP_ID);
        params.put("timestamp", String.valueOf(System.currentTimeMillis()));
        // 2.设置私有参数
        Set<Long> taskIds = new HashSet<>();
        // 3.请输入送审返回taskId
        taskIds.add(0L);
        params.put("taskIds", JsonUtil.objectToJson(taskIds));
        String serverSignature = SignUtil.genSignature(APP_SECRET, params);
        params.put("signature", serverSignature);
        String str = OkHttpUtil.post(API_URL, params);
        System.out.println(str);
    }
}




