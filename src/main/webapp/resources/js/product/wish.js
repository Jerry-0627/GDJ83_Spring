const addWish = document.getElementById("addWish");
const wishResult = document.getElementById("wishResult");
// addWish.addEventListener("click", function(){
//     fetch("./addWish?num=15&name=iu", {
//         method:"GET"
//     });
// })

//Arrow function 개념
// 함수 선언
// function [함수명](){} 
// ()->{}
// 'function' 등.. 불필요한 것들을 줄임..
// 코드가 한줄이면 중괄호 생략 가능
addWish.addEventListener("click", ()=>{
    let id = addWish.getAttribute("data-product-id");
    // 여기서 요청을 보내면, 응답도 여기서 받아야 한다.
    console.log(id);
    fetch("./addWish?product_num=" + id, {
                method:"GET"
    })
    .then((res)=>{return res.text()})
    //function(res){return res.text();} 이런 식으로 구성된 코드임.
    .then((res)=>{
        if(res > 0){
            let check = confirm("Wish List를 확인 하시겠습니까?")
            if(check){
                alert("Wish List로 이동합니다.")
                location.href="./wishList";
            }
        }else{
            alert('Wish List에 이미 들어있는 상품입니다.');
        }
    })
    .catch(()=>{
        alert("오류 발생");
    })
});

