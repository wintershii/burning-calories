package com.burn.burningcalories.util;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class FileUtil {

    static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    //构造一个带指定Zone对象的配置类
    static Configuration cfg = new Configuration(Zone.zone2());
    //...其他参数参考类注释
    static UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传

    static String  accessKey = "5XTHecbup0ltuByfNo79Nrhqwvo-kAmS-qxqxLIs";
    static String secretKey = "7JTvgU12i7NlWO_zp7j_btvUBFyM8LS23zSQ6bXP";
    static String bucket = "winter_image";

    static String key = null;

    public static String upload(MultipartFile file) {


        try {
            byte[] uploadBytes = file.getBytes();
            Auth auth = Auth.create(accessKey,secretKey);
            String uploadToken = auth.uploadToken(bucket);

            Response response = uploadManager.put(uploadBytes,key,uploadToken);

            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);

            return putRet.hash;
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("七牛云上传文件失败");
        }
        return "";
    }
}
