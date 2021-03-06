package xin.mengzuo.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xin.mengzuo.customer.pojo.User;
@Repository
public interface RegisterDao extends JpaRepository<User, Integer>{
public User findByUsername(String username);
public User findByActivecode(String code);
public User findByPhone(String Phone);
public User findByEmail(String email);
}
