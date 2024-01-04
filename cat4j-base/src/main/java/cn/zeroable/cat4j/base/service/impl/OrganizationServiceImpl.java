package cn.zeroable.cat4j.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import cn.zeroable.cat4j.base.entity.OrganizationPO;
import cn.zeroable.cat4j.base.mapper.OrganizationMapper;
import cn.zeroable.cat4j.base.service.OrganizationService;
/**
 * 组织架构;(cat4j_organization)表服务实现类
 *
 * @author : zeroable
 * @version : 2023-12-27 21:32:21
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, OrganizationPO> implements OrganizationService {
}