package com.wyc.web.config.Util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class JdkProxy<T> implements InvocationHandler {

    private Object target;

    private Map<Method, Map<Integer, Object>> preMethodMapMap;
    private Map<Method, Map<Integer, Object>> postMethodMapMap;

    public Map<Method, Map<Integer, Object>> getPreMethodMapMap() {
        return preMethodMapMap;
    }

    public void setPreMethodMapMap(Map<Method, Map<Integer, Object>> preMethodMapMap) {
        this.preMethodMapMap = preMethodMapMap;
    }

    public Map<Method, Map<Integer, Object>> getPostMethodMapMap() {
        return postMethodMapMap;
    }

    public void setPostMethodMapMap(Map<Method, Map<Integer, Object>> postMethodMapMap) {
        this.postMethodMapMap = postMethodMapMap;
    }

    private JdkProxy(T t, Map<Method,Map<Integer, Object>> preMethodMapMap, Map<Method, Map<Integer, Object>> postMethodMapMap) {
        this.target = t;
        this.preMethodMapMap=preMethodMapMap;
        this.postMethodMapMap=postMethodMapMap;
    }

    public static <T> T getInstence(T t, Map<Method, Map<Integer, Object>> preMethodMapMap, Map<Method, Map<Integer, Object>> postMethodMapMap) {

        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new JdkProxy(t,preMethodMapMap,postMethodMapMap));
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (preMethodMapMap != null) {
            invokeMethod(preMethodMapMap);
        }
        Object object = method.invoke(target, args);
        if (postMethodMapMap != null) {
            invokeMethod(postMethodMapMap);
        }
        return null;
    }

    private void invokeMethod(Map<Method, Map<Integer, Object>> methodMapMap) throws Exception {
        for (Map.Entry<Method, Map<Integer, Object>> methodMapEntry : methodMapMap.entrySet()) {
            int count = methodMapEntry.getKey().getParameterCount();
            if (methodMapEntry.getValue().size() != count) {
                throw new Exception("method is error!");
            }
            Object[] params=null;
            if (count>0) {
                params = new Object[count - 1];
                for (int i = 1; i < count; i++) {
                    params[i] = methodMapEntry.getValue().get(i);
                }
            }


            methodMapEntry.getKey().invoke(params);

        }
    }

/*

    public static void main(String... args) {
        Inter inter = new InterTest();
        Map<Method, Map<Integer, Object>> methodMapMap = new HashMap<>();
        Method[] me = MethodC.class.getMethods();

        methodMapMap.put(me[0], new HashMap<>());

        Inter proxy = JdkProxy.getInstence(inter, methodMapMap, methodMapMap);
        proxy.syHello();
    }
*/


}

class MethodC{

    public static void SayBaiBai() {
        System.out.println("baibai");
    }

}
