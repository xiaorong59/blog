package com.rong.demo.utils;

import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.renderer.html.AttributeProvider;

import java.util.Map;

public class CustomAttributeProvider implements AttributeProvider {
    @Override
    public void setAttributes(Node node, String s, Map<String, String> map) {
        if (node instanceof Link){
            map.put("target", "_blank");
        }
        if (node instanceof TableBlock){
            map.put("class", "ui celled table");
        }
    }
}
