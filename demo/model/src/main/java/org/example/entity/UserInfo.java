package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户信息表")
@TableName(value = "userinfo")
public class UserInfo {
    @Schema(description = "用户id")
    @TableId(value = "UserID",type = IdType.AUTO)
    private String id;
    @Schema(description = "用户名")
    @TableField(value = "Username")
    private String username;
    @Schema(description = "密码")
    @TableField(value = "Password")
    private String password;
    @Schema(description = "昵称")
    @TableField(value = "Petname")
    private String petname;
}
