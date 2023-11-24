package leetcode.editor.cn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicTest {

    public static void main(String[] args) {
        UserImpl user = new UserImpl();
        User u = (User) Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(), new MyInvocationHandler(user));
        u.name();
    }

}

class MyInvocationHandler implements InvocationHandler {

    public Object t;

    public MyInvocationHandler(Object t) {
        this.t = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("into invoke");
        return method.invoke(t, args);
    }

}

interface User {
    void name();
}

class UserImpl implements User {
    @Override
    public void name() {
        System.out.println("zhangsan");
    }
}

