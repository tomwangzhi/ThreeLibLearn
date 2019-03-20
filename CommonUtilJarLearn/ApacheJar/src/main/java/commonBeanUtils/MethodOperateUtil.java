package commonBeanUtils;

import org.apache.commons.beanutils.MethodUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * commons-beanutils是Apache开源组织提供的用于操作JAVA BEAN的工具包。
 * 使用commons-beanutils，我们可以很方便的对bean对象的属性进行操作。
 * use MethodUtils to write some demo in order to better understanding
 *
 * MethodUtils通过反射访问对象的方法并且执行方法。
 *
 * 1. static  clearCache() 清空方法缓存
 * 2. static getAccessibleMethod(Class<?> clazz, Method method) 返回一个可访问的方法
 * 3. static getAccessibleMethod(Class<?> clazz, String methodName, Class<?> parameterType) 返回一个可访问的方法
 * 4 getAccessibleMethod(Method method)
 * 5. getMatchingAccessibleMethod(Class<?> clazz, String methodName, Class<?>[] parameterTypes) 找与方法名及参数匹配的可访问方法
 * 6. getPrimitiveType(Class<?> wrapperType) 获得包装类的基本数据类型
 * 7. getPrimitiveWrapper(Class<?> primitiveType) 获得基本数据类型的包装类型
 * 8. invokeExactMethod(Object object, String methodName, Object arg) 执行方法
 *
 */
public class MethodOperateUtil {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        User user = new User();
        // 获得方法调用然后设置值
        // 源码解析：
        /*
           1.传一个参数类型时，将参数包装成数组，然后调用另外一个多参数的访问
           2. 将这个三个参数传入一个构造器中MethodDescriptor，该构造器对传入的参数校验，前两个为null，就抛出非受检的
              IllegalArgumentException，否则就进行参数赋值到该类的成员变量中去
           3.然后将包装的参数类传入一个判断缓存中有没有的方法，有的话从缓存中取，该缓存是一个
           Map<MethodDescriptor, Reference<Method>> cache = Collections
            .synchronizedMap(new WeakHashMap<MethodDescriptor, Reference<Method>>())
            检查调用者类有没有权限调用
            4.调用Class的getMethod方法，然后再调用该类的另外一个参数不同的方法去获取方法类型
            5.将获取的方法缓存起来
         */

        // 学习借鉴 工具方法定义一个map的方法引用，下次调用时可以从缓存中取，减少了运行的开销。并且是用的虚引用。
        // 各个方法职责分明getAccessibleMethod getCachedMethod  cacheMethod checkMemberAccess
        Method method = MethodUtils.getAccessibleMethod(User.class,"setName",String.class);
        method.invoke(user,"张三");
        System.out.println(user);

    }

    @Test
    public void test() {

    }
}
