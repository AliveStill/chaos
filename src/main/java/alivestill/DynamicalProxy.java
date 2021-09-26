package alivestill;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicalProxy {

    public static void main(String[] args) {
        SomeService sm = new ServiceImpl();
        SomeService s = (SomeService)Proxy.newProxyInstance(
                sm.getClass().getClassLoader(),
                sm.getClass().getInterfaces(),
                new MyInvocationHandler(sm));
        s.serve();
    }
}

interface SomeService {
    public void serve();
}

class ServiceImpl implements SomeService{
    @Override
    public void serve() {
        System.out.println("Service executed");
    }
}

/* not used in this Dynamical Proxy pattern */
@Deprecated
class ServiceProxy implements SomeService {

    ServiceImpl sp;

    ServiceProxy(ServiceImpl sp) {
        this.sp = sp;
    }

    @Override
    public void serve() {
        // some other actions here

        sp.serve();
    }
}

// until now, the proxy pattern has been constructed
class MyInvocationHandler implements InvocationHandler {

    Object obj;

    MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // beforeProcess();
        System.out.println("Proxy Before");
        Object ret = method.invoke(obj, args);
        // afterProcess();
        System.out.println("Proxy After");
        return ret;
    }
}