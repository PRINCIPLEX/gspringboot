package com.yz.gproject.Entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  
 * @Author  yz
 * @Date 2021-01-28 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="customer" )
public class CustomerEntity  implements Serializable {

	private static final long serialVersionUID =  8271367531470342951L;

	@Id
	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="avatar")
	private byte[] avatar;

   	@Column(name = "username" )
	private String username;

   	@Column(name = "phone" )
	private String phone;

   	@Column(name = "password" )
	private String password;

   	@Column(name = "email" )
	private String email;
}
