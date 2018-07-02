/**
 *    Copyright 2006-2018 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.custom;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;
import java.util.Set;

/**
 * 自定模板生成器
 * testxxxxxxxxxxxxxxxxxx
 *
 * @author tarofang@163.com
 */
public class CustomCommentGenerator extends DefaultCommentGenerator {

    private Properties properties;
    //private Properties systemPro;
    /** 字段注释 */
    private boolean addFieldComments;
    private boolean addModelClassComments;
    /** 实体类注释 */
    private boolean addClassComments;
    private boolean addEnumComments;
    private boolean addGetterComments;
    private boolean addSetterComments;
    private boolean addGeneralMethodComments;
    private boolean addJavaFileComments;
    /** xml节点注释 */
    private boolean addXmlComments;

    public CustomCommentGenerator() {
        super();
        properties = new Properties();
        //systemPro = System.getProperties();
        addFieldComments = true;
        addModelClassComments = true;
        addClassComments = true;
        addEnumComments = true;
        addGetterComments = true;
        addSetterComments = true;
        addGeneralMethodComments = true;
        addXmlComments = true;
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        if (!addJavaFileComments) {
            return;
        }
        super.addJavaFileComment(compilationUnit);
    }

    @Override
    public void addComment(XmlElement xmlElement) {
        if (!addXmlComments) {
            return;
        }
        super.addComment(xmlElement);
    }

    @Override
    public void addRootComment(XmlElement rootElement) {
        super.addRootComment(rootElement);
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        this.properties.putAll(properties);
        addFieldComments = StringUtility.isTrue(properties.getProperty(CustomPropertyRegistry.COMMENT_GENERATOR_ADD_FIELD_COMMENTS));
        addModelClassComments = StringUtility.isTrue(properties.getProperty(CustomPropertyRegistry.COMMENT_GENERATOR_ADD_MODEL_CLASS_COMMENTS));
        addClassComments = StringUtility.isTrue(properties.getProperty(CustomPropertyRegistry.COMMENT_GENERATOR_ADD_CLASS_COMMENTS));
        addEnumComments = StringUtility.isTrue(properties.getProperty(CustomPropertyRegistry.COMMENT_GENERATOR_ADD_ENUM_COMMENTS));
        addGetterComments = StringUtility.isTrue(properties.getProperty(CustomPropertyRegistry.COMMENT_GENERATOR_ADD_GETTER_COMMENTS));
        addSetterComments = StringUtility.isTrue(properties.getProperty(CustomPropertyRegistry.COMMENT_GENERATOR_ADD_SETTER_COMMENTS));
        addGeneralMethodComments = StringUtility.isTrue(properties.getProperty(CustomPropertyRegistry.COMMENT_GENERATOR_ADD_GENERAL_METHOD_COMMENTS));
        addJavaFileComments = StringUtility.isTrue(properties.getProperty(CustomPropertyRegistry.COMMENT_GENERATOR_ADD_JAVA_FILE_COMMENTS));
        addXmlComments = StringUtility.isTrue(properties.getProperty(CustomPropertyRegistry.COMMENT_GENERATOR_ADD_XML_COMMENTS));
    }

    @Override
    protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
        super.addJavadocTag(javaElement, markAsDoNotDelete);
    }

    @Override
    protected String getDateString() {
        return super.getDateString();
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        if (!addClassComments) {
            return;
        }
        super.addClassComment(innerClass, introspectedTable);
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        if (!addClassComments) {
            return;
        }
        super.addClassComment(innerClass, introspectedTable, markAsDoNotDelete);
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        if (!addModelClassComments) {
            return;
        }
        super.addModelClassComment(topLevelClass, introspectedTable);
    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
        if (!addEnumComments) {
            return;
        }
        super.addEnumComment(innerEnum, introspectedTable);
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        if (!addFieldComments) {
            return;
        }
        super.addFieldComment(field, introspectedTable, introspectedColumn);
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        if (!addFieldComments) {
            return;
        }
        super.addFieldComment(field, introspectedTable);
    }

    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        if (!addGeneralMethodComments) {
            return;
        }
        super.addGeneralMethodComment(method, introspectedTable);
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
        if (!addGetterComments) {
            return;
        }
        super.addGetterComment(method, introspectedTable, introspectedColumn);
    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
        if (!addSetterComments) {
            return;
        }
        super.addSetterComment(method, introspectedTable, introspectedColumn);
    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {
        super.addGeneralMethodAnnotation(method, introspectedTable, introspectedColumn, set);
    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {
        super.addGeneralMethodAnnotation(method, introspectedTable, set);
    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {
        super.addFieldAnnotation(field, introspectedTable, set);
    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {
        super.addFieldAnnotation(field, introspectedTable, introspectedColumn, set);
    }

    @Override
    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {
        super.addClassAnnotation(innerClass, introspectedTable, set);
    }
}
