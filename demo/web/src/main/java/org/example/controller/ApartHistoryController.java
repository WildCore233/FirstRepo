package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.entity.ApartRecord;
import org.example.mapper.ApartHistoryMapper;
import org.example.result;
import org.example.service.ApartHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(name = "历史记录查询")
@RestController
@CrossOrigin(origins = "*")
public class ApartHistoryController {
    @Autowired
    private ApartHistoryMapper apartHistoryMapper;
    @Operation(summary = "图像分割记录查询")
    @GetMapping("/history/apart")
    public result<List<ApartRecord>> getApartHistory(@RequestParam("pageNow") int pageNow,@RequestParam("pageSize") int pageSize) {
        Page<ApartRecord> page = new Page<>(pageNow, pageSize);
        Page<ApartRecord> pp = apartHistoryMapper.selectPage(page, null);
        List<ApartRecord> records=pp.getRecords();
        return result.success(records);
    }
}
