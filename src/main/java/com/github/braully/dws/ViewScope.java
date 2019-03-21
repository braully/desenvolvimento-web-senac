/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.braully.dws;

import java.util.Map;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 *
 * @author Aluno
 */
public class ViewScope  implements Scope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();
        if (viewMap.containsKey(name)) {
            return viewMap.get(name);
        } else {
            Object object = objectFactory.getObject();
            viewMap.put(name, object);

            return object;
        }
    }

    @Override
    public String getConversationId() {
        return null;
    }

    @Override
    public void registerDestructionCallback(String arg0, Runnable arg1) {

    }

    @Override
    public Object remove(String name) {
        return FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name);
    }

    @Override
    public Object resolveContextualObject(String arg0) {
        return null;
    }

}