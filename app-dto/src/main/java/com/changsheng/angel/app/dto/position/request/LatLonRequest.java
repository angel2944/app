/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.changsheng.angel.app.dto.position.request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * 经纬度请求类
 *
 * @author : 李昌雄
 * @version : 1.0.0
 * @date : 2019-8-24
 */
@ApiModel(description = "经纬度请求类")
public class LatLonRequest {

    @ApiModelProperty(notes = "经度")
    private String longitude;

    @ApiModelProperty(notes = "纬度")
    private String latitude;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
