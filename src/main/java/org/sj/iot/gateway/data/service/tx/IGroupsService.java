package org.sj.iot.gateway.data.service.tx;

import org.sj.iot.gateway.data.model.Lights;

import java.util.List;

/**
 * 房间、设备组业务操作接口
 *
 * @author shijian
 * @email shijianws@163.com
 * @date 2017-09-06
 */
public interface IGroupsService {
    List<Lights> listlight();
}
