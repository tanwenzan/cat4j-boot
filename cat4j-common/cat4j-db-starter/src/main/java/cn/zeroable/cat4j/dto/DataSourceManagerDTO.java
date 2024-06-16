package cn.zeroable.cat4j.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.sql.DataSource;

/**
 * 数据源管理DTO.
 *
 * @author zeroable
 * @version 2024/6/11 17:21
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
public class DataSourceManagerDTO {

    private String key;

    private Boolean isAllowDel;

    private DataSource dataSource;
}
