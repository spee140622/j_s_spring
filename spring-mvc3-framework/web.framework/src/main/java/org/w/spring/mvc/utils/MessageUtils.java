package org.w.spring.mvc.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.JdkVersion;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @version 1.5
 * Created by wenzhouyang on 8/7/2014.
 */
public class MessageUtils {

    private MessageUtils() {}

    private static ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;

    private static ResourceBundleMessageSource resourceBundleMessageSource;

    private static long cacheSecond = -1;

    private static String defaultEncoding = "UTF-8";

    private static synchronized ReloadableResourceBundleMessageSource getReloadableResourceBundleMessageSource() {
        if (reloadableResourceBundleMessageSource == null)
            reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        return reloadableResourceBundleMessageSource;
    }

    private static synchronized ResourceBundleMessageSource getResourceBundleMessageSource() {
        if (resourceBundleMessageSource == null)
            resourceBundleMessageSource = new ResourceBundleMessageSource();
        return resourceBundleMessageSource;
    }

    /**
     * 获取本地化
     *
     * @param request httpServletRequest
     *                @see javax.servlet.http.HttpServletRequest
     * @return Local
     * @see java.util.Locale
     */
    public static Locale getLocale(HttpServletRequest request) {
        return RequestContextUtils.getLocale(request);
    }

    public static Locale getDefault() {
        return Locale.getDefault();
    }

    /**
     * 获取消息源
     *
     * @param defaultEncoding 默认编码 default UTF-8
     * @param cacheSecond 缓存时间
     * @param basenames 文件名
     * @return abstractMessageSource
     * @see org.springframework.context.support.AbstractMessageSource
     */
    public static AbstractMessageSource getMessageSource(String defaultEncoding,int cacheSecond, String... basenames) {
        if (defaultEncoding != null)
            MessageUtils.defaultEncoding = defaultEncoding;
        if (cacheSecond > 0)
            MessageUtils.cacheSecond = cacheSecond;
        if (JdkVersion.getMajorJavaVersion() < JdkVersion.JAVA_16) {
            reloadableResourceBundleMessageSource = getReloadableResourceBundleMessageSource();
            reloadableResourceBundleMessageSource.setBasenames(basenames);
            reloadableResourceBundleMessageSource.setDefaultEncoding(defaultEncoding);
            reloadableResourceBundleMessageSource.setCacheSeconds(cacheSecond);
            return reloadableResourceBundleMessageSource;
        } else {
            resourceBundleMessageSource = getResourceBundleMessageSource();
            resourceBundleMessageSource.setBasenames(basenames);
            resourceBundleMessageSource.setCacheSeconds(cacheSecond);
            resourceBundleMessageSource.setDefaultEncoding(defaultEncoding);
            return resourceBundleMessageSource;
        }
    }



}
