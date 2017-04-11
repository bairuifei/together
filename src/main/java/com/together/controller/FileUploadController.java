package com.together.controller;

import com.together.exception.StorageException;
import com.together.model.ResultInfo;
import com.together.model.enumes.ServerMsgEnum;
import com.together.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by BRF on 2017-04-08.
 */
@RestController
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    /**
     * 图片预览
     * @param filename 文件名
     * @return
     */
    @RequestMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }

    /**
     * 图片上传
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public ResultInfo handleFileUpload(@RequestParam("file") MultipartFile file) {
        ResultInfo resultInfo = new ResultInfo();
        try {
            String filename = storageService.store(file);
            resultInfo.setResult(true);
            resultInfo.setServerCode(ServerMsgEnum.UPLOADED.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.UPLOADED.getServerMsg());
            resultInfo.setData(filename);
        } catch (Exception e) {
            resultInfo.setResult(false);
            resultInfo.setServerCode(ServerMsgEnum.UNUPLOAD.getServerCode());
            resultInfo.setServerMsg(ServerMsgEnum.UNUPLOAD.getServerMsg());
            e.printStackTrace();
        }
        return resultInfo;
    }

    //当这个Controller中任何一个方法发生异常，一定会被这个方法拦截到，并执行该方法的输出
    @ExceptionHandler(StorageException.class)
    public ResultInfo handleStorageFileNotFound() {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResult(false);
        resultInfo.setServerCode(ServerMsgEnum.UNUPLOAD.getServerCode());
        resultInfo.setServerMsg(ServerMsgEnum.UNUPLOAD.getServerMsg());
        return resultInfo;
    }
}
