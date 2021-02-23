package com.yz.gproject.Entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  
 * @Author  yz
 * @Date 2021-02-22 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="super_admin" )
public class SuperAdminEntity  implements Serializable {

	private static final long serialVersionUID =  7245045719488083406L;

	@Id
	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

   	@Column(name = "account" )
	private String account;

   	@Column(name = "password" )
	private String password;

}
