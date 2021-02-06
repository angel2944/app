/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.changsheng.angel.app.service.position;


import com.changsheng.angel.app.dto.position.request.LatLonRequest;
import com.changsheng.angel.app.dto.position.response.AddrBaseResponse;

import java.util.List;

/**
 * 到家搜索-地址service
 *
 * @author : 李昌雄
 * @version : 1.0.0
 * @date : 2019-9-7
 */
public interface AddrService {


    /**
     * 地址列表
     * @param latLonRequest
     * @return
     */
    List<AddrBaseResponse> listNearbyAddrByLatLon(LatLonRequest latLonRequest);
}
