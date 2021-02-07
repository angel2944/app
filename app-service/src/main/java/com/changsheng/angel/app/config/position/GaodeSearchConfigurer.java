/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.changsheng.angel.app.config.position;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author : 李昌雄
 * @version : 1.0.0
 * @date : 2019-9-7
 */
@RefreshScope
@Component
@ConfigurationProperties(prefix = "delivery.search.gaode")
@Data
public class GaodeSearchConfigurer {
    /**
     * 私钥
     */
    private String key = "e20f3a6213584e44a7364ada6f9e869a";

    /**
     * 附近搜索url
     */
    private String aroundUrl = "https://restapi.amap.com/v3/place/around";

    /**
     * 附近搜索关键词，多个用|隔开
     */
    private String aroundKeyword = "深圳";

    /**
     * 附近搜索关键词对应的类型，多个用|隔开
     */
    private String aroundTypes;

    /**
     * 附近搜索范围，单位米，取值范围:0-50000
     */
    private Integer aroundRadius = 1000;

    /**
     * 附近搜索返回的地址数量，最大25
     */
    private Integer aroundSize = 10;

    /**
     * 关键词搜索url
     */
    private String keywordUrl;

    /**
     * 关键词搜索每页地址数量，最大25
     */
    private Integer keywordSize = 20;

    /**
     * 关键词搜索默认城市名称，用于无定位城市信息时
     */
    private String defaultCityName = "深圳";

    /**
     * 高德id搜索url
     *
     * @return
     */
    private String gaoDeIdSearchUrl = "https://restapi.amap.com/v3/place/detail";

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAroundUrl() {
        return aroundUrl;
    }

    public void setAroundUrl(String aroundUrl) {
        this.aroundUrl = aroundUrl;
    }

    public String getAroundKeyword() {
        return aroundKeyword;
    }

    public void setAroundKeyword(String aroundKeyword) {
        this.aroundKeyword = aroundKeyword;
    }

    public String getAroundTypes() {
        return aroundTypes;
    }

    public void setAroundTypes(String aroundTypes) {
        this.aroundTypes = aroundTypes;
    }

    public Integer getAroundRadius() {
        return aroundRadius;
    }

    public void setAroundRadius(Integer aroundRadius) {
        this.aroundRadius = aroundRadius;
    }

    public Integer getAroundSize() {
        return aroundSize;
    }

    public void setAroundSize(Integer aroundSize) {
        this.aroundSize = aroundSize;
    }

    public String getKeywordUrl() {
        return keywordUrl;
    }

    public void setKeywordUrl(String keywordUrl) {
        this.keywordUrl = keywordUrl;
    }

    public Integer getKeywordSize() {
        return keywordSize;
    }

    public void setKeywordSize(Integer keywordSize) {
        this.keywordSize = keywordSize;
    }

    public String getDefaultCityName() {
        return defaultCityName;
    }

    public void setDefaultCityName(String defaultCityName) {
        this.defaultCityName = defaultCityName;
    }

    public String getGaoDeIdSearchUrl() {
        return gaoDeIdSearchUrl;
    }

    public void setGaoDeIdSearchUrl(String gaoDeIdSearchUrl) {
        this.gaoDeIdSearchUrl = gaoDeIdSearchUrl;
    }
}
