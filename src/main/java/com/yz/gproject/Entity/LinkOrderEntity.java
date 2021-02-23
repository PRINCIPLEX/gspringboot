package com.yz.gproject.Entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  
 * @Author  yz
 * @Date 2021-02-02 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="link_order" )
public class LinkOrderEntity  implements Serializable {

	private static final long serialVersionUID =  787883405739491462L;

   	@Column(name = "id" )
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

   	@Column(name = "uid" )
	private String uid;

   	@Column(name = "gid" )
	private Long gid;

   	@Column(name = "count" )
	private long count;

}
