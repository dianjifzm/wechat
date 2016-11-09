//package com.yilan.utils;
//
//import java.lang.annotation.Annotation;
//import javax.persistence.Basic;
//import javax.persistence.ElementCollection;
//import javax.persistence.FetchType;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import org.codehaus.jackson.map.introspect.Annotated;
//import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
//
//class JpaLazyIntrospector extends JacksonAnnotationIntrospector
//{
//    public boolean isHandled(Annotation ann)
//    {
//        boolean handled = super.isHandled(ann);
//        if (!handled) {
//            handled = ann.toString().startsWith("@javax.persistence");
//        }
//        if (!handled) {
//            handled = ann.annotationType().equals(JsonLazy.class);
//        }
//        return handled;
//    }
//
//    protected boolean _isIgnorable(Annotated a)
//    {
//        boolean ignor = super._isIgnorable(a);
//        if (!ignor) {
//            ignor = isLazy(a);
//        }
//        return ignor;
//    }
//
//    private boolean isLazy(Annotated a) {
//        boolean lazy = false;
//
//        JsonLazy jsonLazy = (JsonLazy)a.getAnnotation(JsonLazy.class);
//        if (jsonLazy != null) {
//            return false;
//        }
//
//        Basic basic = (Basic)a.getAnnotation(Basic.class);
//        if ((basic != null) && (basic.fetch() == FetchType.LAZY)) {
//            lazy = true;
//        }
//
//        ElementCollection elementCollection = (ElementCollection)a.getAnnotation(ElementCollection.class);
//        if ((elementCollection != null) && (elementCollection.fetch() != FetchType.EAGER)) {
//            lazy = true;
//        }
//
//        ManyToMany manyToMany = (ManyToMany)a.getAnnotation(ManyToMany.class);
//        if ((manyToMany != null) && (manyToMany.fetch() != FetchType.EAGER)) {
//            lazy = true;
//        }
//
//        OneToMany oneToMany = (OneToMany)a.getAnnotation(OneToMany.class);
//        if ((oneToMany != null) && (oneToMany.fetch() != FetchType.EAGER)) {
//            lazy = true;
//        }
//
//        ManyToOne manyToOne = (ManyToOne)a.getAnnotation(ManyToOne.class);
//        if ((manyToOne != null) && (manyToOne.fetch() == FetchType.LAZY)) {
//            lazy = true;
//        }
//
//        OneToOne oneToOne = (OneToOne)a.getAnnotation(OneToOne.class);
//        if ((oneToOne != null) && (oneToOne.fetch() == FetchType.LAZY)) {
//            lazy = true;
//        }
//        return lazy;
//    }
//}