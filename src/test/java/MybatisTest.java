import com.cimo.MainApplication;
import com.cimo.dao.UserDao;
import com.cimo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ths
 * @create 2020/8/2 21:41
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class MybatisTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void t(){
        System.out.println(userDao.findUserList());
    }

    /**
     * 转账操作 --> mybatis 事务控制
     */
    @Test
    @Transactional
    public void transfer(){
        User user1 = userDao.findUserByName("张三");
        user1.setMoney(user1.getMoney() - 200);
        User user2 = userDao.findUserByName("李四");
        user2.setMoney(user2.getMoney() + 200);
        userDao.updateUser(user1);
        int i = 1/0;
        userDao.updateUser(user2);
    }

}
