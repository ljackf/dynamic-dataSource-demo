package com.warm.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.warm.common.DBTypeEnum;
import com.warm.common.DataSourceSwitch;
import com.warm.system.entity.NewMedicine;
import com.warm.system.entity.User;
import com.warm.system.mapper.NewMedicineMapper;
import com.warm.system.mapper.OrderMapper;
import com.warm.system.mapper.UserMapper;
import com.warm.system.service.db1.UserService;
import com.warm.system.service.db2.NewMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
@Service
public class NewMedicineServiceImpl extends ServiceImpl<NewMedicineMapper, NewMedicine> implements NewMedicineService {

    @Autowired
    private NewMedicineMapper newMedicineMapper;
    @Override
    @DataSourceSwitch(DBTypeEnum.db2)
    public List<NewMedicine> selectList() {
        return newMedicineMapper.selectList(null);
    }

    @Override
    @DataSourceSwitch(DBTypeEnum.db2)
    public NewMedicine selectOneByBarcode(String barcode) {
        NewMedicine newMedicine = new NewMedicine();
        newMedicine.setBarcode(barcode);
        return newMedicineMapper.selectOne(newMedicine);
    }

    @Override
    @DataSourceSwitch(DBTypeEnum.db2)
    public void updateSynDataType(NewMedicine newMedicine) {
        newMedicineMapper.updateSynDataType(newMedicine.getId());
    }

    @Override
    @DataSourceSwitch(DBTypeEnum.db2)
    public void save(NewMedicine newMedicineToAdd) {
        newMedicineMapper.insert(newMedicineToAdd);
    }
}
