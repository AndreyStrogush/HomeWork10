package com.xml;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;

public class Xml {
    private static final Logger LOGGER = Logger.getLogger(Xml.class.getName());

    public void makeMultiLayer() {
        List<Map<List<Set<Integer>>, String>> multiLayer = new ArrayList<>();
        Integer number = 1;
        Set<Integer> set = new HashSet<>(number);
        List<Set<Integer>> list = new ArrayList<>();
        list.add(set);
        Map<List<Set<Integer>>, String> map = new HashMap<>();
        map.put(list, "Test");
        multiLayer.add(map);
        makeXmlFile(multiLayer);
    }

    private void makeXmlFile(List list) {
        XMLEncoder xmlEncoder = null;
        try {
            FileOutputStream xmlFile = new FileOutputStream("multiLayerTest.xml");
            xmlEncoder = new XMLEncoder(xmlFile);
            xmlEncoder.writeObject(list);
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found exeption : " + e.getMessage());
        } finally {
            xmlEncoder.close();
        }
    }
}
