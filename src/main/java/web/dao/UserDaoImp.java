package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("from User ");
        return query.getResultList();
    }

    @Override
    public User getUser(int id) {
        Query query = entityManager.createQuery("from User where id = :userId");
        query.setParameter("userId", id);
        return (User) query.getSingleResult();
    }

    @Override
    public void update(int id, User updateUser) {
        Query query = entityManager.createQuery("update User set name = :name, age = :age, phoneNumber = :phoneNumber where id = :id");
        query.setParameter("name", updateUser.getName());
        query.setParameter("age", updateUser.getAge());
        query.setParameter("phoneNumber", updateUser.getPhoneNumber());
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("delete from User where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
