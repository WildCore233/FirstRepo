package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.DiagnoseRecord;
import org.example.mapper.SaveDiagnoseMapper;
import org.example.service.SaveDiagnoseRecord;
import org.springframework.stereotype.Service;

@Service
public class SaveDiagnoseRecordImpl extends ServiceImpl<SaveDiagnoseMapper, DiagnoseRecord> implements SaveDiagnoseRecord  {
}
