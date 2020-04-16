package com.bot.demo.audit;

import com.bot.demo.util.OkHttpUtil;
import com.bot.demo.util.SignUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

/**
 * 调用botsmart云审核图片打标API调用接口示例
 *
 * @author cilong
 * @version 2020-04-16请输入图片url
 */
public class ImageTagsDemo {

    private static Log log = LogFactory.getLog(AuditDemo.class);

    private static final String APP_ID = "";
    private static final String APP_SECRET = "";
    private static final String BUSINESS_ID = "";
    private static final String API_URL = "https://api.botsmart.cn/v1/nlp/tags";

    public static void main(String[] args) {
        SortedMap<String, String> params = new TreeMap<>();
        params.put("business_id", BUSINESS_ID);
        params.put("app_id", APP_ID);
        params.put("unique_id", UUID.randomUUID().toString());
        params.put("url", "请输入需要检测的url");
        String serverSignature = SignUtil.genSignature(APP_SECRET, params);
        params.put("signature", serverSignature);
        String str = OkHttpUtil.post(API_URL, params);
        System.out.println(str);
    }
}
