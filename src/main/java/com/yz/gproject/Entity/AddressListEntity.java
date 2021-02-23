package com.yz.gproject.Entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  
 * @Author  yz
 * @Date 2021-02-12 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="address_list" )
public class AddressListEntity  implements Serializable {

	private static final long serialVersionUID =  7031297651526933580L;

	@Id
   	@Column(name = "Id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

   	@Column(name = "name" )
	private String name;

   	@Column(name = "phone" )
	private String phone;

	@Column(name = "owner")
	private String owner;

}
