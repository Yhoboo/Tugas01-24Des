package com.yhoboo.challenge3.dao;

import com.yhoboo.challenge3.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }
    @Override
    public UserEntity findById(int userId) {
        return (UserEntity) this.getSession().createQuery("from UserEntity where userId=: idUser").setParameter("idUser", userId).uniqueResult();
    }

    @Override
    public UserEntity findByName(String username) {
        return (UserEntity)this.getSession().createQuery("from UserEntity where userName=: nameUser").setParameter("nameUser", username).uniqueResult();
    }

    @Override
    public void insertUser(UserEntity userEntity) {
        this.getSession().save(userEntity);
    }

    @Override
    public List<UserEntity> listByRoleId(int listRoleId) {
        return (List<UserEntity>)this.getSession().createQuery("from UserEntity where role.roleId=: roleIdFK").setParameter("roleIdFK",listRoleId).list();
    }
}
