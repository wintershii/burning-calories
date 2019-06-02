package com.burn.burningcalories.service.impl;


import com.burn.burningcalories.dao.UserMapper;
import com.burn.burningcalories.service.IFileService;
import com.burn.burningcalories.util.FileUtil;
import com.burn.burningcalories.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public String upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();


        logger.info("开始上传文件,上传的文件名:" + fileName);


        String uploadName = FileUtil.upload(file);

        String url = PropertiesUtil.getProperty("image.server.http.prefix") + uploadName;

        return url;

    }

}
