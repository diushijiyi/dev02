package com.fc.service;

import com.fc.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    ResultVO upload(MultipartFile file, String type);
}
