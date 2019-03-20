package commonBeanUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * 用反射来操作bean
 */
public class BeanOperateUtil {

    @Test
    public void test() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        User user = new User("lll","root");
        User copyUser = (User) BeanUtils.cloneBean(user);
        System.out.println(copyUser);
    }
}
