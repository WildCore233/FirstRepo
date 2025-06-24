package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.UserInfo;
@Mapper
public interface LoginMapper extends BaseMapper<UserInfo> {
}
