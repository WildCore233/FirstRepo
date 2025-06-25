package org.example.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.example.tools.DiagnoseSendInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;
@RestController
@CrossOrigin(origins = "*")
public class DiagnoseHandleController {
    private String endpoint = "你的endpoint";
    private String accessKeyId = "你的accessKey";
    private String accessKeySecret = "你的accessKeySecret";
    private String bucketName = "你的bucket名";
    public DiagnoseSendInfo dss = new DiagnoseSendInfo();
    @PostMapping("/send")
    public DiagnoseSendInfo sendDiagnoseImg(@RequestParam("filePath")String filePath) {
        File file = new File(filePath);
        File viewFile = new File(filePath);
        byte[] byteFile = new byte[(int) file.length()];
        FileInputStream fis = null;
        FileInputStream vfis = null;
        try {
            fis = new FileInputStream(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String fileName = UUID.randomUUID().toString() + ".png";
        OSS ossclient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossclient.putObject(bucketName, fileName, fis);
        try {
            vfis = new FileInputStream(filePath);
            vfis.read(byteFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String OrignFilePath= "https://lung-analyse.oss-cn-beijing.aliyuncs.com/"+fileName;
        dss.setFilePath(OrignFilePath);
        dss.setByteFile(byteFile);
        return dss;
    }
}
