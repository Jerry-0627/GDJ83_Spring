const wishDelete = document.getElementsByClassName("wishDelete");

for(let w of wishDelete){
    w.addEventListener("click", ()=>{
        let id = w.getAttribute("data-wish-id");
        // 서버로 DB 삭제를 요청해야함.
        fetch("./deleteWishList?product_num="+id,{        
            //option은 자바 스크립트의 객체 형식으로 보냄, 
            method:"GET"
        
        //then은 요청을 받았을때 요청을 받은 것을 가지고 ~하겠다 라는 뜻임.
        //function 안에 변수
        //return은 안적어도 return해줌
        }).then((r)=>{return r.text()})
         .then((r)=>{
            //공백이 있을 수도 있기 때문에 제거해야함
            r=r.trim();
            if(r>0){
                w.parentNode.parentNode.remove();
                alert("삭제를 성공하였다.");
            }else{
                alert("삭제를 실패..1");
            }
        //catch는 서버나 프론트에서 에러가 발생했을 때,Exception이 발생했을 때 사용함
         }).catch(()=>{alert("삭제를 실패..2")})



    });
}


// @@@@@@ 724 @@@@@@
// @@@@@@ 체크 박스
const checkAll = document.getElementById("checkAll");
const checkOne = document.getElementsByClassName("checkOne");

// @@ checkAll 클릭 시 checkOne 전체 선택 또는 해제
checkAll.addEventListener("click", ()=>{
    console.log("checkAll 체크함");
    for(let c of checkOne){
        c.checked = checkAll.checked
    }
});

// @@ checkOne 클릭 시 checkAll 체크 여부 변경
for(let c of checkOne){
    c.addEventListener("click", ()=>{
        let flag = true;
        for(let c2 of checkOne){
            if(!c2.checked){
                flag = false;
                break;
            }
        }
        checkAll.checked = flag;
    }
)}

// @@@@@@ wish List 전체 삭제
const deleteWishAll = document.getElementById("deleteWishAll");
const wishListTr = document.getElementsByName("wishListTr");

deleteWishAll.addEventListener("click", ()=>{
    const e = [];
    let url="./deleteWishList?"


    // 파라미터를 보내는거.
    for(let c of checkOne){
        if(c.checked == true){
            url = url + "product_num=" + c.getAttribute("data-wish-id") + "&";
            e.push(c);
        }
    }
    url = url.substring(0, url.length - 1);


    // 비동기식 처리하는거.
    fetch(url,{        
        method:"GET"
    }).then((r)=>{return r.text()})
     .then((r)=>{
        r=r.trim();
        if(r>0){
            for(let ele of e){
                ele.parentNode.parentNode.remove();
            }
            alert("삭제를 성공하였다.");
        }else if(r=0){
            alert("삭제를 실패..1");
        }else{
            alert("삭제를 실패..2");

        }
    }).catch(()=>{alert("삭제를 실패..3")})


})