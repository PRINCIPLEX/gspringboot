package com.yz.gproject.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
@Table ( name ="shop_open" )
public class ShopOpenEntity  implements Serializable {


	@Id
   	@Column(name = "id" )
	private Long id;

   	@Column(name = "status" )
	private Boolean status;

}
