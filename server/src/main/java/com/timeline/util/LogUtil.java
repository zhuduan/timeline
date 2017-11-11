package com.timeline.util;

import org.apache.log4j.Logger;

public class LogUtil {
    public static final String SYS_LOG = "SYS";     // 系统日志, 记录异常信息;
    public static final String APP_LOG = "APP";     // 应用日志, 记录接口的访问信息;
    public static final String PFM_LOG = "PFM";     // 性能日志, 记录执行SQL,使用文件,网络等资源时的耗时时间信息;
    public static final String SVC_LOG = "SVC";     // 服务日志, 记录服务日志的情况;
    public static final String ITC_LOG = "ITC";     // 拦截器日志
    public static final String ERROR_LOG = "ERROR"; // 应用日志, 记录接口的访问信息;
    public static final String MQ_LOG  = "MQ";      // mq消息生产者，记录生产消息异常信息
    public static final String CACHE_LOG = "CACHE"; // 缓存日志，记录缓存操作异常信息

    public static final Logger sysLog = getLogger(SYS_LOG);
    public static final Logger appLog = getLogger(APP_LOG);
    public static final Logger pfmLog = getLogger(PFM_LOG);
    public static final Logger svcLog = getLogger(SVC_LOG);
    public static final Logger itcLog = getLogger(ITC_LOG);
    public static final Logger errLog = getLogger(ERROR_LOG);
    public static final Logger mqLog  = getLogger(MQ_LOG);
    public static final Logger cacheLog = getLogger(CACHE_LOG);

    public static Logger getLogger(String logName){
        return Logger.getLogger(logName);
    }

    public static String getMsg(String userMsg){
        return (PositionUtil.getPositionInfo() + " => " + userMsg);
    }
}
