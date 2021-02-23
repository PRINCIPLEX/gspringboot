package com.yz.gproject.Entity;

import javax.persistence.*;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  
 * @Author  yz
 * @Date 2021-01-24 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="admin_user" )
public class AdminUserEntity  implements Serializable {

	private static final long serialVersionUID =  8881618472938689170L;

	@Id
	@Column(name = "Id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

   	@Column(name = "account" )
	private String account;

   	@Column(name = "password" )
	private String password;

}
