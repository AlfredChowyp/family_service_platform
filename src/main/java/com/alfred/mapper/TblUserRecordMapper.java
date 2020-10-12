package com.alfred.mapper;

import com.alfred.bean.TblUserRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户档案 Mapper 接口
 * </p>
 *
 * @author lian
 * @since 2020-10-09
 */
@Component
public interface TblUserRecordMapper extends BaseMapper<TblUserRecord> {

    TblUserRecord login(@Param("username") String username, @Param("password") String password);
}
