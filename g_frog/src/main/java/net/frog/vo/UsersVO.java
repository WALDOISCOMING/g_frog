package net.frog.vo;

import java.util.Date;

public class UsersVO {
	protected int no;
	protected String real_name;
	protected String show_name;
	protected String email;
	protected String password;
	protected boolean sex;
	protected Date birth_date;
	protected Date created_date;
	protected Date last_date;
	protected String image_path;
	
	/*
	 * CREATE TABLE users (
  		no int not null auto_increment comment 'ȸ�� ��ȣ',
  		real_name varchar(200) not null comment 'ȸ�� �̸�',
  		show_name varchar(45) not null comment 'ȸ�� �г���',
  		email varchar(255) not null comment 'ȸ�� �̸���',
  		password varchar(50) not null comment '��й�ȣ',
  		sex bool not null comment '����',
  		birth_date date not null comment '����',
  		created_date datetime not null comment 'ȸ������ ��¥',
  		last_date datetime not null comment '������ ������¥',
  		image_path varchar(50) default 'default.jpg' comment 'ȸ�� ����',
  		PRIMARY KEY (no),
  		UNIQUE INDEX (user_email)
)
	 * 
	 * 
	 */
	
	
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getShow_name() {
		return show_name;
	}
	public void setShow_name(String show_name) {
		this.show_name = show_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getLast_date() {
		return last_date;
	}
	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	
	
	
	
	
	
	
	
	
}
