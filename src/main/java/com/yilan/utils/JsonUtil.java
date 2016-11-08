package com.yilan.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.node.TextNode;
import org.codehaus.jackson.type.TypeReference;

public abstract class JsonUtil {
      public static void main(String[] args){
        Object ss = parseJson("{\"datasourceId\":12201,\"dsName\":\"bj\",\"jndiName\":\"\",\"driverClass\":\"oracle.jdbc.OracleDriver\",\"jdbcURL\":\"jdbc:oracle:thin:@10.88.107.250:1521:orcl\",\"userName\":\"devtest\",\"password\":\"devtest\"}");
     
        String josnString = "{ \"excelName\" : \"组织结构模板.xls\", \"sheet\" : [ { \"entryCode\" : \"epdm_pcOrganizationT\", \"columns\" : [ { \"field\" : \"orgName\", \"title\" : \"机构名称\" }, { \"field\" : \"orgCode\", \"title\" : \"机构代码\" }, { \"field\" : \"canton\", \"title\" : \"行政区名称\" }, { \"field\" : \"cantonCode\", \"title\" : \"行政区代码\" }, { \"field\" : \"mailingAddress\", \"title\" : \"邮递地址\" }, { \"field\" : \"orgId\", \"title\" : \"ORG_ID\" }, { \"field\" : \"orgLevel\", \"title\" : \"级别\" }, { \"field\" : \"parentId\", \"title\" : \"上级机构名称\" } ], \"sheetName\" : \"Sheet1\", \"rows\" : [ { \"\" : \"\", \"orgId\" : \"444.0\", \"parentId\" : \"雍和宫\", \"cantonCode\" : \"7777.0\", \"orgCode\" : \"9999.0\", \"canton\" : \"石景山\", \"orgName\" : \"八角\", \"mailingAddress\" : \"102300.0\", \"orgLevel\" : \"中级\" }, { \"\" : \"\", \"orgId\" : \"444.0\", \"parentId\" : \"雍和宫\", \"cantonCode\" : \"7777.0\", \"orgCode\" : \"10000.0\", \"canton\" : \"石景山\", \"orgName\" : \"八角\", \"mailingAddress\" : \"102300.0\", \"orgLevel\" : \"中级\" }, { \"\" : \"\", \"orgId\" : \"444.0\", \"parentId\" : \"雍和宫\", \"cantonCode\" : \"7777.0\", \"orgCode\" : \"10001.0\", \"canton\" : \"石景山\", \"orgName\" : \"八角\", \"mailingAddress\" : \"102300.0\", \"orgLevel\" : \"中级\" }, { \"\" : \"\", \"orgId\" : \"444.0\", \"parentId\" : \"雍和宫\", \"cantonCode\" : \"7777.0\", \"orgCode\" : \"10002.0\", \"canton\" : \"石景山\", \"orgName\" : \"八角\", \"mailingAddress\" : \"102300.0\", \"orgLevel\" : \"中级\" } ] }, { \"entryCode\" : \"epdm_pcOrganizationT\", \"columns\" : [ { \"field\" : \"orgName\", \"title\" : \"机构名称\" }, { \"field\" : \"orgCode\", \"title\" : \"机构代码\" }, { \"field\" : \"canton\", \"title\" : \"行政区名称\" }, { \"field\" : \"cantonCode\", \"title\" : \"行政区代码\" }, { \"field\" : \"mailingAddress\", \"title\" : \"邮递地址\" }, { \"field\" : \"orgId\", \"title\" : \"ORG_ID\" }, { \"field\" : \"orgLevel\", \"title\" : \"级别\" }, { \"field\" : \"parentId\", \"title\" : \"上级机构名称\" } ], \"sheetName\" : \"Sheet2\", \"rows\" : [ { \"\" : \"\", \"orgId\" : \"444.0\", \"parentId\" : \"雍和宫\", \"cantonCode\" : \"7777.0\", \"orgCode\" : \"888.0\", \"canton\" : \"石景山\", \"orgName\" : \"八角\", \"mailingAddress\" : \"102300.0\", \"orgLevel\" : \"中级\" }, { \"\" : \"\", \"orgId\" : \"444.0\", \"parentId\" : \"雍和宫\", \"cantonCode\" : \"7777.0\", \"orgCode\" : \"889.0\", \"canton\" : \"石景山\", \"orgName\" : \"八角\", \"mailingAddress\" : \"102300.0\", \"orgLevel\" : \"中级\" }, { \"\" : \"\", \"orgId\" : \"444.0\", \"parentId\" : \"雍和宫\", \"cantonCode\" : \"7777.0\", \"orgCode\" : \"890.0\", \"canton\" : \"石景山\", \"orgName\" : \"八角\", \"mailingAddress\" : \"102300.0\", \"orgLevel\" : \"中级\" }, { \"\" : \"\", \"orgId\" : \"444.0\", \"parentId\" : \"雍和宫\", \"cantonCode\" : \"7777.0\", \"orgCode\" : \"891.0\", \"canton\" : \"石景山\", \"orgName\" : \"八角\", \"mailingAddress\" : \"102300.0\", \"orgLevel\" : \"中级\" } ] } ] }";
     
        Object sssw = parseJson(josnString);
        System.out.println(sssw);
        System.out.println(ss);
      }
       
  public static String getJSONString(String filePath) throws Exception{
            StringBuffer data = new StringBuffer();
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader(new File(filePath)));
            String temp = null;
          while((temp = reader.readLine()) != null){
                  data.append(temp);
              }
          if (reader != null){
                reader.close();
              }
            return data.toString();
        }
     
              public static ObjectMapper getObjectMapper() {
        ObjectMapper om = new ObjectMapper().setAnnotationIntrospector(new JpaLazyIntrospector());
     
        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        om.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        om.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        om.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        om.configure(DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        om.configure(DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS, false);
        om.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        om.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        om.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
     
        return om;
      }
     
              public static String toJsonString(Object object)
      {
        try
        {
              return getObjectMapper().writeValueAsString(object);
            } catch (IOException ex) {
              throw new RuntimeException(ex);
            }
      }
     
              public static void writeJsonString(Object object, Writer writer)
      {
        try
        {
              getObjectMapper().writeValue(writer, object);
            } catch (IOException ex) {
              throw new RuntimeException(ex);
            }
      }
     
              public static Map<?, ?> parseJson(String jsonString)
      {
        JsonNode jn = null;
        try {
              jn = getObjectMapper().readTree(jsonString);
            } catch (IOException ex) {
              ex.printStackTrace();
            }
        return (Map<?, ?>)JsonNodeToMap(jn);
      }
     
              public static Object parseJson2MapOrList(String jsonString)
      {
        JsonNode jn = null;
        try {
              jn = getObjectMapper().readTree(jsonString);
            } catch (IOException ex) {
              ex.printStackTrace();
            }
        return JsonNodeToMap(jn);
      }
     
              public static <T> T parseJson(String jsonString, Class<T> classType)
      {
        try {
              return getObjectMapper().readValue(jsonString, classType);
            } catch (Exception ex) {
              ex.printStackTrace();
            }return null;
      }
     
              public static <T> T parseJson(String jsonString, TypeReference<T> typeReference)
      {
        try
        {
              return getObjectMapper().readValue(jsonString, typeReference);
            } catch (Exception ex) {
              ex.printStackTrace();
            }return null;
      }
     
              public static <T> T parseJsonT(String jsonString)
      {
        try
        {
              return getObjectMapper().readValue(jsonString, new TypeReference<Object>() { } );
            }
        catch (Exception ex) {
              ex.printStackTrace();
            }return null;
      }
     
              public static <T> Map<?, ?> bean2Map(Object bean)
      {
        try
        {
              return (Map<?, ?>)getObjectMapper().convertValue(bean, Map.class);
            } catch (Exception ex) {
              ex.printStackTrace();
            }return null;
      }
     
              public static <T> T map2Bean(Map<?, ?> map, Class<T> clazz)
      {
        try
        {
              return getObjectMapper().convertValue(map, clazz);
            } catch (Exception ex) {
              ex.printStackTrace();
            }return null;
      }
     
              public static Object JsonNodeToMap(JsonNode root)
      {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if (root == null) {
              return map;
            }
        if (root.isArray()) {
              List<Object> list = new ArrayList<Object>();
              for (JsonNode node : root) {
                    Object nmp = JsonNodeToMap(node);
                    list.add(nmp);
                  }
              return list;
            }if (root.isTextual()) {
              try {
                    return ((TextNode)root).asText();
                  } catch (Exception e) {
                    return root.toString();
                  }
            }
        Iterator<?> iter = root.getFields();
        while (iter.hasNext()) {
              @SuppressWarnings("rawtypes")
            Map.Entry entry = (Map.Entry)iter.next();
              String key = (String)entry.getKey();
              JsonNode ele = (JsonNode)entry.getValue();
              if (ele.isObject())
                map.put(key, JsonNodeToMap(ele));
              else if (ele.isTextual())
                map.put(key, ((TextNode)ele).asText());
              else if (ele.isArray())
                map.put(key, JsonNodeToMap(ele));
              else {
                    map.put(key, ele.toString());
                  }
            }
        return map;
      }
}