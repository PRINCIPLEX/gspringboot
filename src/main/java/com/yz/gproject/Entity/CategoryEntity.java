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
@Table ( name ="category" )
public class CategoryEntity  implements Serializable {

	private static final long serialVersionUID =  151716491917918002L;

   	@Id
	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

   	@Column(name = "name" )
	private String name;

}
