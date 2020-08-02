import com.cimo.MainApplication;
import com.cimo.dao.UserDao;
import com.cimo.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author ths
 * @create 2020/8/2 21:55
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String,String> rt;

    @Autowired
    private UserDao userDao;

    @Test
    public void t() throws JsonProcessingException {
        List<User> list = null;
        //1.从redis中获取数据，数据形式json字符串
        String userList = rt.boundValueOps("user.findAll").get();
        //2.判断redis中是否存在数据
        //3.不存在，则从数据库查询
        if ( null == userList ){
            //2.1 从数据库获取数据
            list = userDao.findUserList();
            //2.2 将查询出的数据存入redis
            ObjectMapper objectMapper = new ObjectMapper();
            String u = objectMapper.writeValueAsString(list);
            rt.boundValueOps("user.findAll").set(u);
            System.out.println("==== 数据库中查询 =====");
        } else {
            System.out.println("==== redis缓存中获取 ====");
        }
        System.out.println(userList);
        //4.将数据在控制台打印

    }


}
