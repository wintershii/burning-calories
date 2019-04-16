package com.burn.burningcalories.service;


import com.burn.burningcalories.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {
    String upload(MultipartFile file);

}
