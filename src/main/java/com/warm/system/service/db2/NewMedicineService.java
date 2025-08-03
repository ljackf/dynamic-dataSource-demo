package com.warm.system.service.db2;

import com.baomidou.mybatisplus.service.IService;
import com.warm.system.entity.NewMedicine;
import com.warm.system.entity.Order;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
public interface NewMedicineService extends IService<NewMedicine> {

    List<NewMedicine> selectList();

    NewMedicine selectOneByBarcode(String barcode);

    void updateSynDataType(NewMedicine newMedicine);

    void save(NewMedicine newMedicineToAdd);
}
