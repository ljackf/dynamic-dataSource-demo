package com.warm.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.warm.common.DBTypeEnum;
import com.warm.common.DataSourceSwitch;
import com.warm.system.entity.MedicineDetail;
import com.warm.system.entity.NewMedicine;
import com.warm.system.mapper.MedicineDetailMapper;
import com.warm.system.mapper.NewMedicineMapper;
import com.warm.system.service.db2.MedicineDetailService;
import com.warm.system.service.db2.NewMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class MedicineDetailServiceImpl extends ServiceImpl<MedicineDetailMapper, MedicineDetail> implements MedicineDetailService {

    @Autowired
    private MedicineDetailMapper medicineDetailMapper;

    @Override
    @DataSourceSwitch(DBTypeEnum.db2)
    public void save(MedicineDetail medicineDetail) {
        medicineDetailMapper.insert(medicineDetail);
    }
}
