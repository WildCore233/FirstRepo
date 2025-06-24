package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.entity.DiagnoseRecord;
import org.example.result;
import org.example.service.SaveDiagnoseRecord;
import org.example.tools.ImgToBlob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
@Tag(name = "影像诊断结果保存")
public class DiagnoseImgController {
    @Autowired
    private SaveDiagnoseRecord saveDiagnoseRecord;
    private DiagnoseRecord diagnoseRecord;
    @PostMapping("/Diagnose")
    @Operation(summary = "接收前端的诊断记录数据")
    public result saveDiagnoseRecord(@RequestParam("discribe") String discribe,@RequestParam("orginFile") MultipartFile file) throws Exception {
        diagnoseRecord = new DiagnoseRecord();
        byte[] bytes = ImgToBlob.toByteArray(file);
        diagnoseRecord.setDiscribe(discribe);
        diagnoseRecord.setImg(bytes);
        saveDiagnoseRecord.save(diagnoseRecord);
        return result.success();
    }
}
