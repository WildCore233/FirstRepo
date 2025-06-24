package org.example.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "diagnoserecord")
@Schema(description = "图像智能诊断记录")
public class DiagnoseRecord {
    @Schema(description = "诊断记录ID")
    @TableId(value = "id",type = IdType.AUTO)
    private String id;
    @Schema(description = "诊断结果文本")
    @TableField(value = "discribe")
    private String discribe;
    @Schema(description = "原始图像")
    @TableField(value = "img")
    private byte[] img;
    @Schema(description = "诊断时间")
    @TableField(value = "time",fill= FieldFill.INSERT)
    private Date time;
    @Schema(description = "是否删除")
    @TableField(value = "is_delete")
    @JsonIgnore
    @TableLogic
    private Integer isDelete;
}
