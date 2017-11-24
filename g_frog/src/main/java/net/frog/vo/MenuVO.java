package net.frog.vo;

import java.util.Date;

public class MenuVO {
/*
 * 
 * create table menu(
no int not null auto_increment comment 'menu no',
diners_no int not null comment 'diners_no',
menu_name varchar(100) not null comment 'menu name',
menu_main varchar(100) not null comment 'menu main',
menu_original_price int not null comment 'menu original cost',
menu_sale int not null comment 'menu salse',
menu_start_date datetime not null comment 'menu start date',
menu_end_date datetime not null comment 'menu end date',
menu_photo varchar(100) not null comment 'menu photo dir',
primary key(no),
foreign key(diners_no)
references diners(no) on delete cascade

)
 */
	protected int no;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getDiners_no() {
		return diners_no;
	}
	public void setDiners_no(int diners_no) {
		this.diners_no = diners_no;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_main() {
		return menu_main;
	}
	public void setMenu_main(String menu_main) {
		this.menu_main = menu_main;
	}
	public int getMenu_original_price() {
		return menu_original_price;
	}
	public void setMenu_original_price(int menu_original_price) {
		this.menu_original_price = menu_original_price;
	}
	public int getMenu_sale() {
		return menu_sale;
	}
	public void setMenu_sale(int menu_sale) {
		this.menu_sale = menu_sale;
	}
	public Date getMenu_start_date() {
		return menu_start_date;
	}
	public void setMenu_start_date(Date menu_start_date) {
		this.menu_start_date = menu_start_date;
	}
	public Date getMenu_end_date() {
		return menu_end_date;
	}
	public void setMenu_end_date(Date menu_end_date) {
		this.menu_end_date = menu_end_date;
	}
	public String getMenu_photo() {
		return menu_photo;
	}
	public void setMenu_photo(String menu_photo) {
		this.menu_photo = menu_photo;
	}
	protected int diners_no;
	protected String menu_name;
	protected String menu_main;
	protected int menu_original_price;
	protected int menu_sale;
	protected Date menu_start_date;
	protected Date menu_end_date;
	protected String menu_photo;
	
	public MenuVO(){}
	//protected 
	
	
}
