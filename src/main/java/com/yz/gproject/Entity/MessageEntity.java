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
 * @Date 2021-02-12 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="message" )
public class MessageEntity  implements Serializable {

	private static final long serialVersionUID =  4906786541144397253L;

	@Id
   	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

   	@Column(name = "phone" )
	private String phone;

   	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
   	@Column(name = "time" )
	private Date time;

   	@Column(name = "type" )
	private String type;

	@Column(name = "content" )
	private String content;

	@Column(name = "owner")
	private String owner;


}
