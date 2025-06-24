package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.ApartRecord;
import org.example.service.ApartHistory;
@Mapper
public interface ApartHistoryMapper extends BaseMapper<ApartRecord> {
}
