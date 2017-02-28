package longtianlove.eventbuslib;

/**
 * Created by 58 on 2016/12/8.
 */

public class Eventbus {
    static volatile Eventbus defaultInstance;

    public static Eventbus getDefault() {
        if (defaultInstance == null) {
            synchronized (Eventbus.class) {
                if (defaultInstance == null) {
                    defaultInstance = new Eventbus();
                }
            }
        }
        return defaultInstance;
    }

    //注册订阅的对象用来接收消息，当不接受消息的时候， 订阅者必须调用unregister(object)
    //订阅者必须使用de.greenrobot.event.Subscribe注解，注解允许配置线程模型和优先级
    public void register(Object subscriber) {
        Class<?> subscriberClass = subscriber.getClass();
        //@Subscribe 在匿名内部类中不可见注释进程,需要强制反射
        boolean forceReflection = subscriberClass.isAnonymousClass();

    }
}
