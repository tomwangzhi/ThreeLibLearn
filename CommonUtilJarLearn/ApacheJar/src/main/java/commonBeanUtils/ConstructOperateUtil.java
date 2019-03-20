package commonBeanUtils;

import org.apache.commons.beanutils.ConstructorUtils;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 利用反射对构造函数进行一些操作
 */
public class ConstructOperateUtil {

    @Test
    public void testConstruct() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Constructor<User> constructor = ConstructorUtils.getAccessibleConstructor(User.class, String.class);
        String name = constructor.getName();
        // 调用够造函数传参数 单个参数的情况
        User test = ConstructorUtils.invokeConstructor(User.class,"test");
        // 多参数情况
        User user = ConstructorUtils.invokeConstructor(User.class,new String[]{"11","dd"},new Class[]{String.class,String.class});
        System.out.println(user);
        System.out.println(test);
        System.out.println(name);

    }
}
