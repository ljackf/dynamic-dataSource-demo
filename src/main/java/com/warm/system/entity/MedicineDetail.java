package com.warm.system.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("medicine_detail")
public class MedicineDetail extends Model<MedicineDetail> {
    @TableId
    private Long id;
    private Long medicineId;
    private String images;
    private String description;
    private String indication;
    private String disease;
    private String dealerCompany;
    private Integer active;
    private Date updateTime;
    private Date createTime;
    private Long creatorId;
    private Long updaterId;
    private Integer validStatus;
    private String creator;
    private String updater;
    private String dataSource;
    private String dataSourceCompany;
    private String component;
    private String contraindication;
    private String attention;
    private String usageDosage;
    private String sideEffect;
    private String storage;
    private String marketInfo;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}