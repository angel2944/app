package com.changsheng.angel.app.api.controller.position;

import com.changsheng.angel.app.dto.position.request.LatLonRequest;
import com.changsheng.angel.app.dto.position.response.AddrBaseResponse;
import com.changsheng.angel.app.service.position.AddrService;
import com.changsheng.angel.dubhe.controller.BaseController;
import com.changsheng.angel.dubhe.dto.RestResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 配送地址api controller
 *
 * @author 张晓宁
 * @version 1.0.0
 * @date 2019/8/13
 */
@RestController("addrController")
@RequestMapping("/addr")
@Api(tags = "地址管理")
public class AddrController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AddrController.class);

    private AddrService addrService;

    @Value("${delivery.search.address.version:113}")
    private Integer addressVersion;

    @Autowired
    public AddrController(AddrService addrService) {
        this.addrService = addrService;
    }




    @ApiOperation(value = "定位经纬度获取附近地址列表", notes = "定位经纬度获取附近地址列表")
    @PostMapping("/listNearbyAddrByLatLon")
    public RestResult<List<AddrBaseResponse>> listNearbyAddrByLatLon(@Validated @RequestBody LatLonRequest latLonRequest) {
        return success(addrService.listNearbyAddrByLatLon(latLonRequest));

    }




}

