package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.entity.ApartRecord;
import org.example.result;
import org.example.service.SaveApartRecord;
import org.example.tools.ImgToBlob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
@Tag(name="影像分割结果保存")
public class ApartImgController {
    @Autowired
    private SaveApartRecord saveApartRecord;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    private ApartRecord apartRecord;
    @Operation(summary = "接收前端的图像分割记录数据")
    @PostMapping("/Apart")
    public result saveApartRecord(@RequestParam("mn") String modelName,@RequestParam("file") MultipartFile file) throws Exception {
        redisTemplate.opsForList().leftPush(modelName,file.getOriginalFilename());
        apartRecord = new ApartRecord();
        apartRecord.setModelName(modelName);
        apartRecord.setResult(ImgToBlob.toByteArray(file));
        saveApartRecord.save(apartRecord);
        return result.success();
    }

}
