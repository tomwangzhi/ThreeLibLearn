package commonBeanUtils;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * 利用反射对属性进行一些操作
 */
public class PropertyOperateUtil {

    @Test
    public void test() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        User user1 = new User("111","34343");
        Apple apple = new Apple();
        // 把一个对象里面的值赋值到另一个对象中去 不关心对象的类型 只需保证对象同名即可
        PropertyUtils.copyProperties(apple,user1);
        System.out.println(apple);
    }
}
