package com.yz.gproject.Dao;

import com.yz.gproject.Entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface CustomerDao extends JpaRepository<CustomerEntity, Long> {

    CustomerEntity findCustomerEntityByPhoneAndAndEmail(String phone,String email);

    CustomerEntity getById(long id);

    CustomerEntity findCustomerEntityByPhoneAndPassword(String phone,String password);


    CustomerEntity findByPhone(String phone);


    @Modifying
    @Query(value = "UPDATE customer set customer.avatar = :avatar WHERE customer.phone =:phone",nativeQuery = true)
    void changeUserAvatar(@Param("phone")String userPhone,@Param("avatar")byte[] avatar);

    @Modifying
    @Query(value = "UPDATE customer set customer.password = :password WHERE customer.phone =:phone",nativeQuery = true)
    void changeUserPassword(@Param("phone")String userPhone,@Param("password")String password);



    @Modifying
    @Query(value = "UPDATE customer set customer.username = :userName WHERE customer.phone =:phone",nativeQuery = true)
    void changeUserName(@Param("phone")String userPhone,@Param("userName")String userName);

    @Modifying
    @Query(value = "UPDATE customer set customer.phone = :newphone WHERE customer.phone =:phone",nativeQuery = true)
    void changeUserPhone(@Param("phone")String userPhone,@Param("newphone")String newphone);



    @Query(
            value = "SELECT * FROM customer WHERE phone LIKE %:query%",
            nativeQuery = true
    )
    Page<CustomerEntity> findByPhoneWithPage(@Param("query")String query, Pageable page);

}
