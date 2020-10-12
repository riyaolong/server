package com.xlzhou.server.service.impl;

import com.xlzhou.server.service.IService;

import javax.jws.WebService;

/**
 * @Auther: zxl
 * @Date: 2020/9/7 - 09 - 07 - 15:18
 */
@WebService(serviceName = "MyService", endpointInterface = "com.xlzhou.server.service.IService")
public class MyService implements IService {
    @Override
    public String getStr(String string) {
        return string + " :成功调用 欢迎进入webService";
    }
}
