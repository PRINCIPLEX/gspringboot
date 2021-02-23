package com.yz.gproject.Entity;

import javax.persistence.*;
import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Description  
 * @Author  yz
 * @Date 2021-02-02 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="uorder" )
public class OrderEntity  implements Serializable {

	private static final long serialVersionUID =  6470715165307631892L;

	@Id
	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

   	@Column(name = "orderid" )
	private String orderid;

   	@Column(name = "totalprice" )
	private Double totalprice;

   	@Column(name = "cphone" )
	private String cphone;

   	@Column(name = "cname" )
	private String cname;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@Column(name = "time" )
	private Date time;

   	@Column(name = "payway" )
	private String payway;

   	@Column(name = "eatway" )
	private String eatway;

   	@Column(name = "iseatway" )
	private boolean iseatway;

   	@Column(name = "remark" )
	private String remark;

   	@Column(name = "isdeal" )
	private boolean isdeal;

}
