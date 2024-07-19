/**
 * 
 */
 
const btn = document.getElementById("btn");
const user_id = document.getElementById("user_id");
const user_pw = document.getElementById("user_pw");
const user_pw_check = document.getElementById("user_pw_check");
const user_name = document.getElementById("user_name");
const user_phone_num = document.getElementById("user_phone_num");
const user_email = document.getElementById("user_email");
const user_address = document.getElementById("user_address");
const frm = document.getElementById("frm");
const error = document.getElementById("password-error");
const eqError = document.getElementById("password-eqError");
const eqError2 = document.getElementById("password-eqError2");
const del = document.getElementById("del");


btn.addEventListener("click", function(){
  
    if(user_id.value == "" || user_pw.value == "" || user_pw_check.value == "" || user_name.value=="" || 
        user_phone_num.value=="" || user_email.value=="" || user_address.value==""){
        alert("정보를 모두 기입해주세요.");
            if(user_pw.value == ""){
                error.innerText="비밀번호 입력좀 해";
            }else if(user_pw.value.length < 8){
                error.innerText="비밀번호는 8글자 이상 입력해야됨 ㅋ";
            }
    }else if(user_pw.value.length < 8){
        error.innerText="비밀번호는 8글자 이상 입력해야됨 ㅋ";
    }else{
        frm.submit();
    }
})


user_pw_check.addEventListener("blur", function(){

    if(user_pw_check.value != user_pw.value){
        user_pw_check.value = "";
        eqError.innerText="비밀번호가 맞지 않는다.";
        eqError2.innerText="";

    }else{
        eqError.innerText="";
        eqError2.innerText="비밀번호가 일치합니다.";
    }
})

user_pw.addEventListener("change", function(){
    user_pw_check.value = "";
    eqError.innerText="";
    eqError2.innerText="";
})