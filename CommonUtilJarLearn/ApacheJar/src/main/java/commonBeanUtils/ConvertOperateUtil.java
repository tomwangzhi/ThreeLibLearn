package commonBeanUtils;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据类型相互转换的方法。
 */
public class ConvertOperateUtil {

    @Test
    public void test() {

        ConvertUtils.register(new Converter()
        {

            public <T> T convert(Class<T> arg0, Object arg1)
            {
                try
                {
                    return (T) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                            .parse((String) arg1);
                }
                catch (ParseException e)
                {
                    return null;
                }
            }
        }, Date.class);

        System.out.println(ConvertUtils
                .convert("2016-04-09 12:41:00", Date.class));
    }

}
