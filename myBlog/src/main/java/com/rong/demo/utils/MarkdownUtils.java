package com.rong.demo.utils;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class MarkdownUtils {
        public static String markdownToHtml(String markdown){
                Parser parser = Parser.builder().build();
                Node document = parser.parse(markdown);
                HtmlRenderer renderer = HtmlRenderer.builder().build();
                return renderer.render(document);
        }

        public static String markdownToHtmlExtensions(String markdown){
                //h标题生成id
                Set<Extension> headingAnchorExtensions = Collections.singleton(HeadingAnchorExtension.create());
                //转换table的html
                List<Extension> tableExtension = Arrays.asList(TablesExtension.create());
                Parser parser = Parser.builder().extensions(tableExtension).build();
                Node document = parser.parse(markdown);
                HtmlRenderer renderer = HtmlRenderer.builder()
                        .extensions(headingAnchorExtensions)
                        .extensions(tableExtension)
                        .attributeProviderFactory(new AttributeProviderFactory() {
                                @Override
                                public AttributeProvider create(AttributeProviderContext attributeProviderContext) {
                                        return new CustomAttributeProvider();
                                }
                        })
                        .build();
                return renderer.render(document);
        }
}
