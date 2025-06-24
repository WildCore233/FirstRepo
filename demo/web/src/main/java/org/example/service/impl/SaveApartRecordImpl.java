package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.ApartRecord;
import org.example.mapper.SaveApartRecordMapper;
import org.example.service.SaveApartRecord;
import org.springframework.stereotype.Service;

@Service
public class SaveApartRecordImpl  extends ServiceImpl<SaveApartRecordMapper, ApartRecord> implements SaveApartRecord {}
