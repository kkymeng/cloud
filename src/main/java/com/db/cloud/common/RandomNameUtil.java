package com.db.cloud.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @author yunkk
 * @description 随机生成用户名
 */
@Slf4j
public class RandomNameUtil {
    public static String generateName(){
        File file = new File("document/randomName.json");
        StringBuilder stringBuilder = new StringBuilder();
        if(file.exists()){
            try {
                String files = FileUtils.readFileToString(file,"utf-8");
                JSONObject jsonObject = JSON.parseObject(files);
                String adj = jsonObject.getString("adj");
                String noun = jsonObject.getString("noun");
                String[] adjs = adj.split(",");
                String[] nouns = noun.split(",");
                Random random = new Random();
                stringBuilder.append(adjs[random.nextInt(adjs.length)])
                        .append("的小").append(nouns[random.nextInt(nouns.length)]);
            } catch (IOException e) {
                log.error("---读取姓名 json 文件失败---error:{}",e);
            }
        }
        return stringBuilder.toString();
    }
}
