package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.DiagnoseRecord;
@Mapper
public interface SaveDiagnoseMapper extends BaseMapper<DiagnoseRecord> {
}
