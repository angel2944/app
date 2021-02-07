/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.changsheng.angel.app.service.position.impl;

import com.alibaba.fastjson.JSONObject;
import com.changsheng.angel.app.common.constant.AppConstant;
import com.changsheng.angel.app.config.position.GaodeSearchConfigurer;
import com.changsheng.angel.app.dto.position.bean.GaoDeSearchBean;
import com.changsheng.angel.app.dto.position.request.LatLonRequest;
import com.changsheng.angel.app.dto.position.response.AddrBaseResponse;
import com.changsheng.angel.app.service.position.AddrService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

/**
 * @author : 李昌雄
 * @version : 1.0.0
 * @date : 2019-9-7
 */
@Service
@Slf4j
public class AddrServiceImpl implements AddrService {
    private static final Logger logger = LoggerFactory.getLogger(AddrServiceImpl.class);

    @Autowired
    private GaodeSearchConfigurer gaodeSearchConfigurer;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<AddrBaseResponse> listNearbyAddrByLatLon(LatLonRequest latLonRequest) {
        String latitude = latLonRequest.getLatitude();
        String longitude = latLonRequest.getLongitude();
        long start = System.currentTimeMillis();
        //1.调用高德周边搜索API
        //http://restapi.amap.com/v3/place/around?key=%s&output=json&keywords=%s&types=%s&offset=%d&page=1&location=%s&radius=%d&extensions=base
        int num = gaodeSearchConfigurer.getAroundSize();
        String reqUrl = this.getGaodeAroundUrl(latitude, longitude, num);
        String result = "";
        try {
            result = restTemplate.getForEntity(reqUrl, String.class).getBody();
            logger.info("listNearbyAddrByLatLon 请求高德周边搜索API完成,reqUrl={},result={},耗时={}ms", reqUrl, result, (System.currentTimeMillis() - start));
        } catch (Exception e) {
            logger.error("listNearbyAddrByLatLon 请求高德周边搜索API失败,reqUrl={},耗时={}ms", reqUrl, (System.currentTimeMillis() - start), e);
        }
        if (!StringUtils.isEmpty(result)) {
            GaoDeSearchBean gaoDeSearchBean = JSONObject.parseObject(result, GaoDeSearchBean.class);
//            GaoDeSearchBean gaoDeSearchBean = CommonUtils.deSerialize(objectMapper, result, GaoDeSearchBean.class);
            if (gaoDeSearchBean != null && AppConstant.NUM_ONE_STR.equals(gaoDeSearchBean.getStatus()) && gaoDeSearchBean.getCount() > 0) {
                List<AddrBaseResponse> addrBaseResponseList = AddrBaseResponse.fromGaodeSearchBean(gaoDeSearchBean);
                logger.info("listNearbyAddrByLatLon 请求高德周边搜索API完成,总耗时={}ms", (System.currentTimeMillis() - start));
                return addrBaseResponseList;
            }
        }
        return Collections.emptyList();
    }

    /**
     * 自定restTemplate
     */
   /* private RestTemplate getRestTemplate(Integer timeOut) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
      //  restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        if (timeOut != null) {
            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
            requestFactory.setConnectTimeout(1000);
            requestFactory.setReadTimeout(timeOut);
            restTemplate.setRequestFactory(requestFactory);
        }
        return restTemplate;
}

    */


    /**
     * 获取高德附近地址url
     *
     * @param latitude
     * @param longitude
     * @return
     * @throws
     * @author : 李昌雄
     * @version : 1.0.0
     * @date : 2019-9-11
     */
    private String getGaodeAroundUrl(String latitude, String longitude, int arountSize) {
        String aroundUrl = gaodeSearchConfigurer.getAroundUrl();
        String key = gaodeSearchConfigurer.getKey();
        String keywords = gaodeSearchConfigurer.getAroundKeyword();
        String types = gaodeSearchConfigurer.getAroundTypes();
        Integer radius = gaodeSearchConfigurer.getAroundRadius();
        return String.join("", aroundUrl, "?key=", key, "&output=json&keywords=", keywords,
                "&offset=", String.valueOf(arountSize), "&page=1&location=", longitude, ",", latitude, "&radius=", String.valueOf(radius), "&extensions=all");
    }
}
