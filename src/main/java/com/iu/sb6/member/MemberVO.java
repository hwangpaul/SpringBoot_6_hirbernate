package com.iu.sb6.member;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "member")
public class MemberVO {
	
	@Id
	private String id;
	@Column
	private String pw;
	@Transient
	private String pw2;
	@Column(name = "age")
	private int age;
	@Column
	private String name;
	@Column
	private String email;
	
	//1:1 관계
	@OneToOne(mappedBy = "memberVO", cascade = CascadeType.ALL)
	//mappedBy = 자식 VO에 선언된 부모 VO의 변수명
	//
	private MemberFilesVO memberFilesVO;


}
