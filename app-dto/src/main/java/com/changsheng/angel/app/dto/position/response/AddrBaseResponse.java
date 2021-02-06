/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.changsheng.angel.app.dto.position.response;

import com.changsheng.angel.app.common.constant.AppConstant;
import com.changsheng.angel.app.dto.position.bean.GaoDeSearchBean;
import com.changsheng.angel.app.dto.position.bean.GaodePoiBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 地址返回基类
 *
 * @author : 李昌雄
 * @version : 1.0.0
 * @date : 2019-8-24
 */
@ApiModel(description = "地址返回基类")
public class AddrBaseResponse {

    @ApiModelProperty(notes = "地址编码")
    private String addrCode;

    @ApiModelProperty(notes = "地址名称")
    private String addrName;

    @ApiModelProperty(notes = "纬度")
    private String latitude;

    @ApiModelProperty(notes = "经度")
    private String longitude;

    @ApiModelProperty(notes = "详情地址，包含省市区+街道地址")
    private String address;

    @ApiModelProperty(notes = "区域编码")
    private String areaCode;

    public AddrBaseResponse() {

    }

    public AddrBaseResponse(AddrBaseResponse other) {
        this.addrCode = other.addrCode;
        this.addrName = other.addrName;
        this.latitude = other.latitude;
        this.longitude = other.longitude;
        this.areaCode = other.areaCode;
        this.address = other.address;
    }

    public String getAddrCode() {
        return addrCode;
    }

    public void setAddrCode(String addrCode) {
        this.addrCode = addrCode;
    }

    public String getAddrName() {
        return addrName;
    }

    public void setAddrName(String addrName) {
        this.addrName = addrName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }


    public static List<AddrBaseResponse> fromGaodeSearchBean(GaoDeSearchBean gaoDeSearchBean) {
        List<GaodePoiBean> poiList = gaoDeSearchBean.getPois();
        if (CollectionUtils.isEmpty(poiList)) {
            return Collections.emptyList();
        }
        return poiList.stream().map(AddrBaseResponse::fromGaodePoiBean).collect(Collectors.toList());
    }

    public static AddrBaseResponse fromGaodePoiBean(GaodePoiBean gaodePoiBean) {
        AddrBaseResponse addrBaseResponse = new AddrBaseResponse();
        addrBaseResponse.setAddrCode(gaodePoiBean.getId());
        addrBaseResponse.setAddrName(gaodePoiBean.getName());
        addrBaseResponse.setAreaCode(gaodePoiBean.getAdcode());
        String address = GaodePoiBean.getFullAddress(gaodePoiBean);
        addrBaseResponse.setAddress(address);
        String location = gaodePoiBean.getLocation();
        if (location.contains(",")) {
            String[] latLon = location.split(AppConstant.COMMA_STR);
            addrBaseResponse.setLongitude(latLon[0]);
            addrBaseResponse.setLatitude(latLon[1]);
        }
        return addrBaseResponse;
    }


}
