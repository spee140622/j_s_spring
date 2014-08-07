package org.w.spring.mvc.message;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * 国际化文件读取类
 *
 * @version 1.0
 * Created by wenzhouyang on 8/7/2014.
 */
public class MessageReader {

    /**
     * 国际化文件汇总文件
     * key:key
     * value:国际化文件名
     */
    private Properties properties;

    /**
     * 国际化文件
     */
    private List<String> propertiesList;

    /**
     * Sets new 国际化文件汇总文件
     * key:key
     * value:国际化文件名.
     *
     * @param properties New value of 国际化文件汇总文件
     *                   key:key
     *                   value:国际化文件名.
     */
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    /**
     * Gets 国际化文件.
     *
     * @return Value of 国际化文件.
     */
    public List<String> getPropertiesList() {
        if (propertiesList == null && properties != null)
            propertiesList = new ArrayList<String>();

        if (properties != null) {
            Enumeration enumeration = properties.propertyNames();
            String value;
            while (enumeration.hasMoreElements()) {
                value = properties.getProperty((String) enumeration.nextElement());
                if (value != null && value.trim().length() > 0) {
                    propertiesList.add(value);
                }
            }
        }
        return propertiesList;
    }

    /**
     * 获取国际化文件
     *
     * @return String[]
     */
    public String[] getPropertiesFiles() {
        List<String> propList = getPropertiesList();
        if (propList != null && !propList.isEmpty()) {
            return (String[]) propList.toArray();
        }

        return null;
    }

    /**
     * Sets new 国际化文件.
     *
     * @param propertiesList New value of 国际化文件.
     */
    public void setPropertiesList(List<String> propertiesList) {
        this.propertiesList = propertiesList;
    }

    /**
     * Gets 国际化文件汇总文件
     * key:key
     * value:国际化文件名.
     *
     * @return Value of 国际化文件汇总文件
     * key:key
     * value:国际化文件名.
     */
    public Properties getProperties() {
        return properties;
    }
}
