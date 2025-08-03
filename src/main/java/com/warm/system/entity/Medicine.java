package com.warm.system.entity;


import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("medicine")
@Data
public class Medicine extends Model<Medicine> {

    @TableId
    private Long medicineId;
    private String nameLocal;
    private String nameCn;
    private String nameEn;
    private String brandCn;
    private String brandEn;
    private String sellName;
    private String factoryCn;
    private String locality;
    private String standard;
    private String barcode;
    private String license;
    private String countryCode;
    private String localCode;
    private String priceLocal;
    private Float weight;
    private String storeStyle;
    private String manUrl;
    private String disease;
    private String content;
    private String adapt;
    private String tax;
    private String avoid;
    private String attentions;
    private String usages;
    private String sideEffect;
    private Integer isPrescript;
    private Integer isPoison;
    private Integer isNarcosis;
    private Integer isMental;
    private Integer isRadio;
    private Integer isDope;
    private Long creator;
    private Date createTime;
    private Date updateTime;
    private Integer deleted;
    private String globalMarketSituation;
    private String drugClassifyNumber;
    private String regulation;

    @Override
    protected Serializable pkVal() {
        return this.medicineId;
    }
}
