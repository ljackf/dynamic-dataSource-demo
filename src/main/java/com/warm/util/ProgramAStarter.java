package com.warm.util;



import com.warm.system.entity.Medicine;
import com.warm.system.entity.MedicineDetail;
import com.warm.system.entity.NewMedicine;
import com.warm.system.mapper.MedicineMapper;
import com.warm.system.mapper.NewMedicineMapper;
import com.warm.system.service.db1.MedicineService;
import com.warm.system.service.db2.MedicineDetailService;
import com.warm.system.service.db2.NewMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ProgramAStarter implements ApplicationRunner {

    @Autowired
    private MedicineService medicineService;
    @Autowired
    private NewMedicineService newMedicineService;
    @Autowired
    private MedicineDetailService medicineDetailService;

    @Override
    public void run(ApplicationArguments args) {
        // 程序A的执行逻辑
        System.out.println("程序A已执行");
        List<Medicine> medicines = medicineService.selectList();
        if (medicines != null && !medicines.isEmpty()) {
            System.out.println("查询到 " + medicines.size() + " 条药品数据");
            for (Medicine medicine : medicines) {
                //如果通过条形码查到数据了，就不处理
                NewMedicine newMedicine = newMedicineService.selectOneByBarcode(medicine.getBarcode());
                if (newMedicine != null) {
                    //药品信息已存在，只更新状态
                    newMedicine.setSynDataType(1);
                    newMedicineService.updateSynDataType(newMedicine);
                } else {
                    //没药品，新增
                    NewMedicine newMedicineToAdd = new NewMedicine();
//                    newMedicineToAdd.setMedicineType();没数据
                    newMedicineToAdd.setPrescription(medicine.getIsPrescript());
                    newMedicineToAdd.setName(medicine.getNameCn());
                    newMedicineToAdd.setNameEn(medicine.getNameEn());
                    newMedicineToAdd.setNameFirstLetter(genNameLetter(medicine.getNameCn()));
//                    newMedicineToAdd.setAlias();没数据
//                    newMedicineToAdd.setNameUseBefore();没数据
                    newMedicineToAdd.setBrand(medicine.getBrandCn());
                    newMedicineToAdd.setBrandEn(medicine.getBrandEn());
//                    newMedicineToAdd.setFullName();没数据
//                    newMedicineToAdd.setFullNameEn();没数据
                    newMedicineToAdd.setAuthorizedCode(medicine.getLicense());
//                    newMedicineToAdd.setAuthorizedCodeExpireDate();没数据
                    newMedicineToAdd.setStandard(medicine.getStandard());
//                    newMedicineToAdd.setDose();
//                    newMedicineToAdd.setUnit();
//                    newMedicineToAdd.setTrocheType();
                    newMedicineToAdd.setMillTitle(medicine.getFactoryCn());
//                    newMedicineToAdd.setMillTitleEn();没数据
//                    newMedicineToAdd.setBentrustedStoreName();
//                    newMedicineToAdd.setBentrustedStoreNameEn();
                    newMedicineToAdd.setBarcode(medicine.getBarcode());
//                    newMedicineToAdd.setTrademark();不确定这是是不是品牌，到时候同步后再看同一个条形码对于的商标是哪个数据
//                    newMedicineToAdd.setPeriod();
//                    newMedicineToAdd.setPeriodUnit();
//                    newMedicineToAdd.setWeight(medicine.getWeight());不知道单位
//                    newMedicineToAdd.setWeightUnit();
//                    newMedicineToAdd.setStorageType(medicine.getStoreStyle());
//                    newMedicineToAdd.setStorageTempMin();
//                    newMedicineToAdd.setStorageTempMax();
//                    newMedicineToAdd.setCustomsCode();
//                    newMedicineToAdd.setCustomsWebsite();
//                    newMedicineToAdd.setIncomeControl();
//                    newMedicineToAdd.setTaxCode();
                    newMedicineToAdd.setActive(1);
                    newMedicineToAdd.setUpdateTime(new Date());
                    newMedicineToAdd.setCreateTime(new Date());
                    newMedicineToAdd.setCreatorId(-1L);
                    newMedicineToAdd.setUpdaterId(-1L);
                    newMedicineToAdd.setValidStatus(1);
                    newMedicineToAdd.setCreator("JACK-同步");
                    newMedicineToAdd.setUpdater("JACK-同步");
                    newMedicineToAdd.setDataSource("0");
//                    newMedicineToAdd.setDataSourceCompany();
                    newMedicineToAdd.setAnesthesia(medicine.getIsNarcosis());
                    newMedicineToAdd.setSpirit(medicine.getIsMental());
                    newMedicineToAdd.setToxic(medicine.getIsPoison());
                    newMedicineToAdd.setRadiation(medicine.getIsRadio());
                    newMedicineToAdd.setExcited(medicine.getIsDope());
//                    newMedicineToAdd.setTaxRate();
//                    newMedicineToAdd.setCompanyId();
                    newMedicineToAdd.setProduceCountry(medicine.getCountryCode());
//                    newMedicineToAdd.setTrademarkEn();
                    newMedicineToAdd.setMillTitleAddress(medicine.getLocality());
                    newMedicineToAdd.setProduceCountryCode(medicine.getLocalCode());
                    newMedicineToAdd.setProduceCountryPrice(medicine.getPriceLocal());
//                    newMedicineToAdd.setArcCode();
//                    newMedicineToAdd.setMeiTuanCode();
//                    newMedicineToAdd.setExpressType();
//                    newMedicineToAdd.setReportAuditStatus(0);
                    newMedicineToAdd.setSynDataType(2);
                    newMedicineService.save(newMedicineToAdd);
                    //插入MedicineDetail数据
                    MedicineDetail medicineDetail = new MedicineDetail();
                    medicineDetail.setMedicineId(newMedicineToAdd.getId());
//                    medicineDetail.setImages();
                    medicineDetail.setDescription(medicine.getManUrl());
                    medicineDetail.setIndication(medicine.getAdapt());
//                    medicineDetail.setDisease();
//                    medicineDetail.setDealerCompany();
                    medicineDetail.setActive(1);
                    medicineDetail.setUpdateTime(new Date());
                    medicineDetail.setCreateTime(new Date());
                    medicineDetail.setCreatorId(-1L);
                    medicineDetail.setUpdaterId(-1L);
                    medicineDetail.setValidStatus(1);
                    medicineDetail.setCreator("JACK-同步");
                    medicineDetail.setUpdater("JACK-同步");
                    medicineDetail.setDataSource("1");
//                    medicineDetail.setDataSourceCompany();
                    medicineDetail.setComponent(medicine.getContent());
                    medicineDetail.setContraindication(medicine.getAvoid());
                    medicineDetail.setAttention(medicine.getAttentions());
                    medicineDetail.setUsageDosage(medicine.getUsages());
                    medicineDetail.setSideEffect(medicine.getSideEffect());
                    medicineDetail.setStorage(medicine.getStoreStyle());
                    medicineDetail.setMarketInfo(medicine.getGlobalMarketSituation());
                    medicineDetailService.save(medicineDetail);

                }
            }
        } else {
            System.out.println("没有查询到任何药品数据");
        }

        System.out.println("执行完成**************************************************");
    }

    //生成药品名称的首字母
    private String genNameLetter(String nameCn) {
        if (nameCn == null || nameCn.isEmpty()) {
            return "";
        }
        StringBuilder firstLetter = new StringBuilder();
        for (char c : nameCn.toCharArray()) {
            if (Character.isLetter(c)) {
                firstLetter.append(Character.toUpperCase(c));
            } else if (Character.isDigit(c)) {
                firstLetter.append(c);
            } else {
                firstLetter.append('_'); // 非字母数字字符用下划线代替
            }
        }
        return firstLetter.toString();
    }
}