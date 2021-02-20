package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.TFile;
import com.stylefeng.guns.modular.system.dao.TFileMapper;
import com.stylefeng.guns.modular.system.service.ITFileService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-09-19
 */
@Service
public class TFileServiceImpl extends ServiceImpl<TFileMapper, TFile> implements ITFileService {

}
