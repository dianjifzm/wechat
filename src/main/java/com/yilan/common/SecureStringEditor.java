package com.yilan.common;

import org.apache.commons.lang3.StringEscapeUtils;

import java.beans.PropertyEditorSupport;

/**
 * Created by Administrator on 2016-11-9.
 */
public class SecureStringEditor  extends PropertyEditorSupport {
    // 是否做安全的Html转换
    private boolean escapeHTML;
    // 是否做安全的JS关键字转换
    private boolean escapeJavaScript;
    // 是否做安全的XML关键字转换
    private boolean escapeXML;

    public SecureStringEditor() {
        super();
    }

    public SecureStringEditor(boolean escapeHTML, boolean escapeJavaScript, boolean escapeXML) {
        super();
        this.escapeHTML = escapeHTML;
        this.escapeJavaScript = escapeJavaScript;
        this.escapeXML = escapeXML;
    }

    /**
     * Sets the property value by parsing a given String.  May raise
     * java.lang.IllegalArgumentException if either the String is
     * badly formatted or if this kind of property can't be expressed
     * as text.
     *
     * @param text The string to be parsed.
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null) {
            setValue(null);
        } else {
            String value = text;
            if (escapeHTML) {
                value = StringEscapeUtils.escapeHtml4(value);
            }
            if (escapeJavaScript) {
                value = StringEscapeUtils.escapeEcmaScript(value);
            }
            if (escapeXML) {
                value = StringEscapeUtils.escapeXml(value);
            }
            setValue(value);
        }
    }
}
