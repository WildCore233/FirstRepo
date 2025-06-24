package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.ApartRecord;
import org.example.mapper.ApartHistoryMapper;
import org.example.service.ApartHistory;
import org.springframework.stereotype.Service;

@Service
public class ApartHistoryImpl extends ServiceImpl<ApartHistoryMapper,ApartRecord> implements ApartHistory {

}
