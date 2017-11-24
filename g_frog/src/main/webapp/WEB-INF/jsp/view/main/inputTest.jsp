<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<script src="http://code.jquery.com/jquery-1.6.2.min.js" type="text/javascript"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.1.js"></script>
<script>
function a(){
	alert("amount");
	//form name
	//var form = document.form_test;
	
	var pay_method =document.getElementById("pay_method").value; 
	var amount = document.getElementById("amount").value;
	var buyer_email = document.getElementById("buyer_email").value;
	var buyer_name = document.getElementById("buyer_name").value;
	var buyer_tel =document.getElementById("buyer_tel").value;
	var buyer_addr = document.getElementById("buyer_addr").value;
	var buyer_postcode = document.getElementById("buyer_postcode").value;
	
var IMP = window.IMP;
IMP.init('imp21919110');
IMP.request_pay({
    pg : 'kakao', // version 1.1.0부터 지원. 
        /*
            'kakao':카카오페이,
            'inicis':이니시스, 'html5_inicis':이니시스(웹표준결제), 
            'nice':나이스, 
            'jtnet':jtnet, 
            'uplus':LG유플러스,
            'danal':다날
        */
        
    pay_method : pay_method, // 'card':신용카드, 'trans':실시간계좌이체, 'vbank':가상계좌, 'phone':휴대폰소액결제
    merchant_uid : 'merchant_' + new Date().getTime(),
    name : '주문명:결제테스트',
    amount : amount,
    buyer_email : buyer_email,
    buyer_name : buyer_name,
    buyer_tel : buyer_tel,
    buyer_addr : buyer_addr,
    buyer_postcode : buyer_postcode
}, function(rsp) {
    if ( rsp.success ) {
        var msg = '결제가 완료되었습니다.';
        msg += '고유ID : ' + rsp.imp_uid;
        msg += '상점 거래ID : ' + rsp.merchant_uid;
        msg += '결제 금액 : ' + rsp.paid_amount;
        msg += '카드 승인번호 : ' + rsp.apply_num;
    } else {
        var msg = '결제에 실패하였습니다.';
        msg += '에러내용 : ' + rsp.error_msg;
    }
});

}

</script>
<form >
구매방법<input type="text" id="pay_method"></br>
가격<input type="text" id="amount"></br>
이메일<input type="text" id="buyer_email"></br>
이름<input type="text" id="buyer_name"></br>
전화번호<input type="text" id="buyer_tel"></br>
주소<input type="text" id="buyer_addr"></br>
우편번호<input type="text" id="buyer_postcode"></br>

<input type="button" onclick="a()" value="Click">
</form>



</body>
</html>