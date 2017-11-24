package net.frog.vo;

import java.util.Date;

public class DinersVO {
	protected int no;
	protected String diner_name;
	protected String diner_call;
	protected String intro;
	protected String rest_day;
	protected Date posting_date;
	protected String diner_directory_name;
	
	public DinersVO(){
		
	}
	public DinersVO(int no,
					String diner_name,
					String diner_call,
					String intro,
					String rest_day,
					Date posting_date,
					String diner_directory_name){
		this.no = no;
		this.diner_name = diner_name;
		this.diner_call = diner_call;
		this.intro = intro;
		this.rest_day = rest_day;
		this.posting_date = posting_date;
		this.diner_directory_name = diner_directory_name;
	}
	
	public String getDiner_name() {
		return diner_name;
	}
	public void setDiner_name(String diner_name) {
		this.diner_name = diner_name;
	}
	public String getDiner_call() {
		return diner_call;
	}
	public void setDiner_call(String diner_call) {
		this.diner_call = diner_call;
	}
	public Date getPosting_date() {
		return posting_date;
	}
	public void setPosting_date(Date posting_date) {
		this.posting_date = posting_date;
	}
	public String getDiner_directory_name() {
		return diner_directory_name;
	}
	public void setDiner_directory_name(String diner_directory_name) {
		this.diner_directory_name = diner_directory_name;
	}
	public String getRest_day() {
		return rest_day;
	}
	public void setRest_day(String rest_day) {
		this.rest_day = rest_day;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return diner_name;
	}
	public void setName(String name) {
		this.diner_name = name;
	}
	public String getCall_number() {
		return diner_call;
	}
	public void setCall_number(String call_number) {
		this.diner_call = call_number;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Date getPostring_date() {
		return getPostring_date();
	}
	public void setPostring_date(Date postring_date) {
		this.posting_date = postring_date;
	}	   
}
