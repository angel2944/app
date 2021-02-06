/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.changsheng.angel.app.dto.position.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 高德搜索返回bean对象
 *
 * @author : 李昌雄
 * @version : 1.0.0
 * @date : 2019-9-7
 */
public class GaoDeSearchBean implements Serializable {

    private String status;

    private String info;

    private int count;

    private String infocode;

    private List<GaodePoiBean> pois;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public List<GaodePoiBean> getPois() {
        return pois;
    }

    public void setPois(List<GaodePoiBean> pois) {
        this.pois = pois;
    }
}
