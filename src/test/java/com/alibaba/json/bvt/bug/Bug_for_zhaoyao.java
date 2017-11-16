package com.alibaba.json.bvt.bug;

import java.util.HashMap;

import com.alibaba.fastjson.parser.Feature;
import org.junit.Assert;
import junit.framework.TestCase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Bug_for_zhaoyao extends TestCase {
    public void test_FieldMap() throws Exception {
        FieldMap map = new FieldMap();
        map.put("a", 1);
        map.put("b", 2);
        String text = JSON.toJSONString(map, SerializerFeature.WriteClassName);
        System.out.println(text);
        
        FieldMap map2 = (FieldMap) JSON.parse(text, Feature.SupportAutoType);
        
        Assert.assertTrue(map.equals(map2));
    }

    public static class FieldMap extends HashMap<String, Object> {

        private static final long serialVersionUID = 1L;

        public FieldMap field(String field, Object val) {
            this.put(field, val);
            return this;
        }
    }
}
