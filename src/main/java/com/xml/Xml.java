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
import java.util.logging.Logger;

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
        FileOutputStream xmlFile = null;
        try {
            xmlFile = new FileOutputStream("multiLayerTest.xml");
        } catch (FileNotFoundException e) {
            LOGGER.info(e.getMessage());
        }
        XMLEncoder xmlEncoder = new XMLEncoder(xmlFile);
        xmlEncoder.writeObject(list);
    }
}
