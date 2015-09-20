import com.jprogrammers.model.User;
import com.jprogrammers.model.UserDetail;
import com.jprogrammers.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by jprogrammers.
 */
public class Test {
    public static void main(String[] args) {

        User user = new User();
        user.setFirstName("vahid");
        user.setLastName("forghani");

        UserDetail userDetail = new UserDetail();
        userDetail.setEmailAddress("vahid.forghani@gmail.com");
        userDetail.setPhoneNumber("09124707967");

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        session.save(user);
        userDetail.setUser(user);
        session.save(userDetail);

        transaction.commit();
        session.flush();
        session.close();
    }
}