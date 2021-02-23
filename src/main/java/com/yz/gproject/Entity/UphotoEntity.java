package com.yz.gproject.Entity;

import javax.persistence.*;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
import java.io.InputStream;

/**
 * @Description  
 * @Author  yz
 * @Date 2021-02-13 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="uphoto" )
public class UphotoEntity  implements Serializable {

	private static final long serialVersionUID =  5837590231014736612L;

	@Id
   	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

   	@Column(name = "name" )
	private String name;

   	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
   	@Column(name = "time" )
	private Date time;

   	@Column(name = "photo" )
	private byte[] photo;

   	@Column(name = "owner")
	private String owner;

}
