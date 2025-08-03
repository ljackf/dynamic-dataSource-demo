package com.warm.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.warm.system.entity.NewMedicine;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface NewMedicineMapper extends BaseMapper<NewMedicine> {
    @Update("update medicine set syn_data_type = 1 where id =#{id}")
    void updateSynDataType(Long id);
}