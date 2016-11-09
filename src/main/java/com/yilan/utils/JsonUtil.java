package com.yilan.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public abstract class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    private final static com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
    static {
        //序列化时，如果对象的某属性为null,生成Json字符串时不包含这个null属性
//        objectMapper.setAnnotationIntrospector(new JpaLazyIntrospector());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.setLocale(Locale.CHINA);
    }
    /**
     * 将 Java 对象转为 JSON 字符串
     */
    public static <T> String toJSON(T obj) {
        String jsonStr;
        try {
            jsonStr = objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            logger.error("Java 转 JSON 出错！", e);
            throw new RuntimeException(e);
        }
        return jsonStr;
    }

    /**
     * 将 JSON 字符串转为 Java 对象
     * (1)转换为普通JavaBean：readValue(json,Student.class)
     * (2)转换为List,如List<Student>,将第二个参数传递为Student
     * [].class.然后使用Arrays.asList();方法把得到的数组转换为特定类型的List
     */
    public static <T> T fromJSON(String json, Class<T> type) {
        T obj;
        try {
            obj = objectMapper.readValue(json, type);
        } catch (Exception e) {
            logger.error("JSON 转 Java 出错！", e);
            throw new RuntimeException(e);
        }
        return obj;
    }

    /**
     * 用于从JSON中解析复杂的泛型对象
     * 如果是ArrayList<YourBean>那么使用ObjectMapper 的getTypeFactory().constructParametricType(collectionClass, elementClasses);
     * 如果是HashMap<String,YourBean>那么 ObjectMapper 的getTypeFactory().constructParametricType(HashMap.class,String.class, YourBean.class);
     * @param json JSON字符串
     * @param parametrized  泛型对象的类，如List<T>,HashMap<T,E>等
     * @param parameterClasses 泛型元素具体的类
     * @return
     */
    public static Object json2parametrizedObj(String json, Class<?> parametrized,
                                              Class<?>... parameterClasses) {
        try {
            JavaType javaType = objectMapper.getTypeFactory()
                    .constructParametricType(parametrized, parameterClasses);
            return objectMapper.readValue(json, javaType);
        } catch (Exception e) {
            logger.error(
                    "an error occured while translate json to obj:" + json, e);
            return null;
        }
    }
    /**
     * 从json字符串中读取出指定的节点
     * @param json
     * @param key
     * @return
     */
    public static com.fasterxml.jackson.databind.JsonNode getValueFromJson(String json, String key) {
        com.fasterxml.jackson.databind.JsonNode node = null;
        try {
            node = objectMapper.readTree(json);
            return node.get(key);
        } catch (IOException e) {
            logger.error("getValueFromJson",e);
            return null;
        }
    }
}