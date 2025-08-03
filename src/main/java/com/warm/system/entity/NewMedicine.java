package com.warm.system.entity;



import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("medicine")
public class NewMedicine extends Model<NewMedicine> {
    @TableId
    private Long id;
    private String medicineType;
    private Integer prescription;
    private String name;
    private String nameEn;
    private String nameFirstLetter;
    private String alias;
    private String nameUseBefore;
    private String brand;
    private String brandEn;
    private String fullName;
    private String fullNameEn;
    private String authorizedCode;
    private Date authorizedCodeExpireDate;
    private String standard;
    private String dose;
    private String unit;
    private String trocheType;
    private String millTitle;
    private String millTitleEn;
    private String bentrustedStoreName;
    private String bentrustedStoreNameEn;
    private String barcode;
    private String trademark;
    private Integer period;
    private Integer periodUnit;
    private Integer weight;
    private String weightUnit;
    private Integer storageType;
    private String storageTempMin;
    private String storageTempMax;
    private String customsCode;
    private String customsWebsite;
    private Integer incomeControl;
    private String taxCode;
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
    private Integer anesthesia;
    private Integer spirit;
    private Integer toxic;
    private Integer radiation;
    private Integer excited;
    private BigDecimal taxRate;
    private Long companyId;
    private String produceCountry;
    private String trademarkEn;
    private String millTitleAddress;
    private String produceCountryCode;
    private String produceCountryPrice;
    private String arcCode;
    private String meiTuanCode;
    private Integer expressType;
    private Integer reportAuditStatus;
    private Integer synDataType;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}