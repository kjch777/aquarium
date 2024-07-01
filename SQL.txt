create table item (item_no number(1) not null,
item_name varchar2(50) not null,
item_desc varchar2(4000) not null,
item_price number(6) not null,
img_file varchar2(25) not null);

create sequence item_seq start with 1 increment by 1;

insert into item values (item_seq.nextval, '바닷 속 친구들 키링', '심플한 디자인의 키링입니다.', 8000, 'simpleKeyRing.jpg');
insert into item values (item_seq.nextval, '돌고래 모양 키링', '귀여운 돌고래 모양의 키링입니다.', 10000, 'dolphinKeyRing.jpg');
insert into item values (item_seq.nextval, '사이좋은 오리 자매 인형', '장난꾸러기 오리 모양의 인형입니다.\r\n\r\n둘은 사이좋기로 유명한 자매입니다.\r\n\r\n(1개 구매 시 2개의 인형이 한 쌍으로 출고됩니다.)', 12000, 'duckDuckDoll.jpg');
insert into item values (item_seq.nextval, '파랑 상어 인형', '드넓은 바다의 무법자 상어 모양의 인형입니다.\r\n\r\n배가 고파지면 이것저것 가리지 않고 삼켜버릴 수 있으니 주의하세요!\r\n\r\n(어른이 베고 자도 문제 없을 정도의 크기입니다.)', 15000, 'blueSharkDoll.jpg');
insert into item values (item_seq.nextval, '바다의 왕자 범고래 인형', '드넓은 바다의 왕자 범고래 모양의 인형입니다.\r\n\r\n파랑 상어와는 티격태격 하지만, 그래도 가장 친한 친구랍니다.\r\n\r\n(어린이가 베고 잘 수 있을 정도의 크기입니다.)', 11000, 'blackWhaleDoll.jpg');
insert into item values (item_seq.nextval, '먼작귀 삼총사 키링', '저 멀리 일본에서 건너 온 먼작귀 삼총사!\r\n\r\n가방이나 신발 주머니에 걸어보세요~\r\n\r\n(정식 라이센스를 취득한 제품이며, 3개가 한 세트입니다.)', 9000, 'chiikawasKeyRing.jpg');

commit;

create table order_tb (order_no number(3) not null,
order_quantity number(3) not null,
rec_name varchar2(15) not null,
rec_phone varchar2(15) not null,
rec_addr varchar2(150) not null,
rec_detail_addr varchar2(100) not null,
rec_postcode varchar2(15) not null,
rec_request varchar2(4000),
payment_method varchar2(15) not null,
card_type varchar2(15),
installment varchar2(15),
bank_type varchar2(15),
item_no number(1) not null,
memberId varchar2(50) not null);

create sequence order_seq start with 1 increment by 1;

commit;