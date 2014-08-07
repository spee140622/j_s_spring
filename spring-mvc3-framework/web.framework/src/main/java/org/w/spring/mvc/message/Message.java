package org.w.spring.mvc.message;

import org.springframework.context.support.AbstractMessageSource;

/**
 * @version 1.0
 *          Created by wenzhouyang on 8/8/2014.
 */
public class Message {

    public String getMessage(String code, Object[] args) {
        BaseMessageSource baseMessageSource = new BaseMessageSource(null);
        AbstractMessageSource messageSource = baseMessageSource.getMessageSource();
        return messageSource.getMessage(code, args, baseMessageSource.getDefaultLocale());
    }
}
