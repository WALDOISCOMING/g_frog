
CREATE TABLE users (
  no int not null auto_increment comment 'ȸ�� ��ȣ',
  real_name varchar(45) not null comment 'ȸ�� �̸�',
  show_name varchar(45) not null comment 'ȸ�� �г���',
  email varchar(255) not null comment 'ȸ�� �̸���',
  password varchar(50) not null comment '��й�ȣusers',
  sex bool not null comment '����',
  birth_date date not null comment '����',
  created_date datetime not null comment 'ȸ������ ��¥',
  last_date datetime not null comment '������ ������¥',
  image_path varchar(255) default 'default.jpg' comment 'ȸ�� ����',
  enabled bool NOT NULL DEFAULT 1,
  PRIMARY KEY (no),
  UNIQUE INDEX (email),
  UNIQUE INDEX (show_name)
)
COMMENT 'ȸ��';

CREATE TABLE user_roles (
  user_role_no int not null auto_increment comment '���� ��ȣ',
  user_no int not null comment 'ȸ�� ��ȣ',
  email varchar(255) not null comment '�̸���',
  role varchar(45) not null default 'ROLE_USER' comment 'ȸ�� ����',
  PRIMARY KEY (user_role_no),
  FOREIGN KEY (user_no) REFERENCES users (no)
)
COMMENT 'ȸ�� ����';

CREATE TABLE diners ( 
  no int not null auto_increment comment '�Ĵ� ��ȣ',
  diner_name varchar(200) not null comment '�Ĵ� �̸�',
  diner_call varchar(200) not null comment '�Ĵ� ��ȭ��ȣ',
  intro text not null comment'�Ĵ� �Ұ�',
  rest_day varchar(200) not null comment '�޹���',
  posting_date datetime not null comment '�ۼ� ��¥',
  diner_directory_name varchar(255) not null comment '���丮 ��',
  PRIMARY KEY(no)
)
COMMENT '�Ĵ�';

CREATE TABLE diners_menu(
  no int not null auto_increment comment '�޴� ��ȣ',
  diners_no int not null comment '�Ĵ� ��ȣ',
  menu_name varchar(200) not null comment '�޴� �̸�',
  menu_main int not null default '0' comment '��ǥ �Ŵ�',
  posting_date datetime not null comment '���ε� ��¥',
  original_file_name varchar(260) not null comment '���� ����',
  stored_file_name varchar(260) not null comment '���� �����',
  intro text not null comment '�޴� �Ұ�',
  PRIMARY KEY (no),
  FOREIGN KEY (diners_no) REFERENCES diners(no) on delete cascade
)
COMMENT '�Ĵ�޴�';

CREATE TABLE diners_photo(
  no int not null auto_increment comment '�Ĵ� ���� ��ȣ',
  diners_no int not null comment '�Ĵ� ��ȣ',
  diners_photo_value int not null comment '�Ĵ� value',
  original_file_name varchar(260) not null comment '���� ����',
  stored_file_name varchar(260) not null comment '���� �����',
  PRIMARY KEY (no),
  FOREIGN KEY (diners_no) REFERENCES  diners(no) on delete cascade
)
COMMENT '�Ĵ����';

CREATE TABLE diners_photo_path(
  no int not null auto_increment comment '�Ĵ� ���� path',
  diners_photo_no int not null comment '�Ĵ� ���� value',
  stored_file_path varchar(255) not null comment '���� �����',
  PRIMARY KEY (no),
  FOREIGN KEY (diners_photo_no) 
  REFERENCES diners_photo(no) on delete cascade
)
COMMENT '�Ĵ�������';

CREATE TABLE reply (
  no int not null auto_increment comment '���� ��ȣ',
  diners_no int not null comment '�����ȣ',
  user_show_name varchar(45) not null comment 'ȸ�� �г���',
  content text not null comment '���� ����',
  posting_date datetime not null comment '���� �ۼ� ��¥',
  grade int(2) not null comment '����',
  PRIMARY KEY (no),
  FOREIGN KEY (diners_no) REFERENCES  diners(no) on delete cascade,
  FOREIGN KEY (user_show_name) REFERENCES  users(show_name)
)
COMMENT '���';