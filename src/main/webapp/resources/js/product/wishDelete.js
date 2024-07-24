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