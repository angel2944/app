/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.changsheng.angel.app.dto.position.bean;

/**
 * 高德搜索返回Poi bean
 *
 * @author : 李昌雄
 * @version : 1.0.0
 * @date : 2019-9-7
 */
public class GaodePoiBean {

    private String id;

    private String name;

    private String type;

    private String typecode;
    /**
     * 详细地址(不包含省市区)
     */
    private String address;
    /**
     * 经纬度
     */
    private String location;
    /**
     * 省编码
     */
    private String pcode;
    /**
     * 身份名称
     */
    private String pname;
    /**
     * 城市code
     */
    private String citycode;
    /**
     * 城市名称
     */
    private String cityname;
    /**
     * 区域名称
     */
    private String adname;
    /**
     * 区域编码
     */
    private String adcode;

    public static String getFullAddress(GaodePoiBean gaodePoiBean) {
        String provinceName = gaodePoiBean.getPname();
        String cityName = gaodePoiBean.getCityname();
        String districtName = gaodePoiBean.getAdname();
        if (provinceName == null) {
            provinceName = "";
        }
        if (cityName == null) {
            cityName = "";
        }
        if (districtName == null) {
            districtName = "";
        }
        String address = gaodePoiBean.getAddress();
        if ("[]".equals(address)) {
            address = "";
        }
        if (provinceName.equals(cityName)) {
            provinceName = "";
        }
        if (districtName.equals(address)) {
            address = "";
        }
        return String.join("", provinceName, cityName, districtName, address);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }
}
