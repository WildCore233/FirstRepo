package org.example.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "apartrecord")
@Schema(description = "x光片分割历史记录")
public class ApartRecord {
    @Schema(description = "分割记录ID")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @Schema(description = "模型名称")
    @TableField(value = "ModelName")
    private String modelName;
    @Schema(description = "结果图片二进制数据")
    @TableField(value = "result")
    private byte[] result;
    @Schema(description = "分割时间")
    @TableField(value = "time",fill = FieldFill.INSERT)
    private Date time;
    @Schema(description = "是否删除")
    @TableField(value = "is_delete")
    @JsonIgnore
    @TableLogic
    private Integer isDelete;
}
