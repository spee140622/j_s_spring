package org.w.spring.mvc.message;

import org.springframework.context.support.AbstractMessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.JdkVersion;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * 消息处理类
 *
 * @version 1.0
 * Created by wenzhouyang on 8/7/2014.
 */
public class BaseMessageSource {

    public BaseMessageSource(String[] basenames) {
        this.basenames = basenames;
    }

    /**
     * 构造方法
     *
     * @param defaultEncoding 默认编码 default UTF-8
     * @param cacheSecond 缓存时间
     * @param basenames 文件名
     */
    public BaseMessageSource(String defaultEncoding,int cacheSecond, String... basenames) {
        if (defaultEncoding != null)
            this.defaultEncoding = defaultEncoding;
        if (cacheSecond > 0)
            this.cacheSecond = cacheSecond;
        this.basenames = basenames;
    }

    private static ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;

    private static ResourceBundleMessageSource resourceBundleMessageSource;

    private int cacheSecond = -1;

    private String defaultEncoding = "UTF-8";

    private String basenames[];

    /**
     * 获取本地化
     *
     * @param request httpServletRequest
     *                @see javax.servlet.http.HttpServletRequest
     * @return Local
     * @see java.util.Locale
     */
    public Locale getLocale(HttpServletRequest request) {
        return RequestContextUtils.getLocale(request);
    }

    /**
     * 获取默认本地化
     *
     * default china
     *
     * @return Locale
     * @see java.util.Locale
     */
    public Locale getDefaultLocale() {
        return Locale.CHINA;
    }

    /**
     * 获取消息源
     *
     * @return abstractMessageSource
     * @see org.springframework.context.support.AbstractMessageSource
     */
    public AbstractMessageSource getMessageSource() {
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
}
