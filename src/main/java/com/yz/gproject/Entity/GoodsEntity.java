package com.yz.gproject.Entity;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.InputStream;

/**
 * @Description  
 * @Author  yz
 * @Date 2021-01-29 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="goods" )
public class GoodsEntity  implements Serializable {

	private static final long serialVersionUID =  3523824528410787689L;

	@Id
   	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

   	@Column(name = "gname" )
	private String gname;

   	@Column(name = "img" )
	private byte[] img;

   	@Column(name = "sales" )
	private Long sales;

   	@Column(name = "price" )
	private Double price;

	@Column(name="category_id")
	private Long categoryId;

	@Column(name="issale")
	private boolean issale;
}
