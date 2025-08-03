package com.warm.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.warm.common.DBTypeEnum;
import com.warm.common.DataSourceSwitch;
import com.warm.system.entity.Medicine;
import com.warm.system.entity.NewMedicine;
import com.warm.system.mapper.MedicineMapper;
import com.warm.system.mapper.NewMedicineMapper;
import com.warm.system.service.db1.MedicineService;
import com.warm.system.service.db2.NewMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, Medicine> implements MedicineService {

    @Autowired
    private MedicineMapper medicineMapper;
    @Override
    @DataSourceSwitch(DBTypeEnum.db1)
    public List<Medicine> selectList() {
        //查询过滤deleted!=1的所有数据
        HashMap map = new HashMap<String, Object>();
        map.put("deleted", 0);
        List<Medicine>medicines = medicineMapper.selectByMap(map);
        List<Medicine> result = new ArrayList<>();
        result.add(medicines.get(0));
        return medicines;

    }
}
