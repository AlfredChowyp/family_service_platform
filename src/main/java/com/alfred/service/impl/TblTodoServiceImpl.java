package com.alfred.service.impl;

import com.alfred.bean.TblTodo;
import com.alfred.mapper.TblTodoMapper;
import com.alfred.service.TblTodoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 待办事项 服务实现类
 * </p>
 *
 * @author lian
 * @since 2020-10-09
 */
@Service
public class TblTodoServiceImpl extends ServiceImpl<TblTodoMapper, TblTodo> implements TblTodoService {

}
