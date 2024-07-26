// @@@@@@7.25 상품 디테일에 댓글 달기.
const commentContent = document.getElementById("commentContent");
const commentBtn = document.getElementById("commentBtn");
const commentList = document.getElementById("commentList");
const commentClose = document.getElementById("commentClose");
const commentPnum = document.getElementById("commentPnum");
    const commentPnumCon = commentPnum.getAttribute("data-commentPnum");
const openModal = document.getElementById("openModal");


getList(1);


// true = 댓글 등록, false = 댓글 수정
let flag = true;
let board_num = 0;

//openModal을 클릭 했을 때
openModal.addEventListener("click", ()=>{
    flag = true;
    commentBtn.innerHTML = "댓글 등록";
    commentContent.value = "";
})

// 댓글 수정
commentList.addEventListener("click", (e)=>{
    if(e.target.classList.contains("ups")){
        flag = false;
        board_num = e.target.getAttribute("data-commentListBtn");
        let c = e.target.getAttribute("data-update-con");
        c = document.getElementById(c).innerHTML;
        console.log(c);
        commentContent.value=c;
        commentBtn.innerHTML="댓글 수정";
    }
})

// 댓글 등록 및 수정
commentBtn.addEventListener("click", ()=>{
    let contents = commentContent.value;

    if(contents == null || contents==""){
        alert("댓글을 입력");
        return;
    }


    let url = "./commentAdd";
    //let param = "board_contents=" + contents + "&product_num=" + commentPnum.getAttribute("data-commentPnum");
    // param 대신에 form을 사용할 수도 있음.
    const form = new FormData(); //<form></form>
    form.append("board_contents", contents);
    //<input type="text" name="board_contents", value ="contents값">
    form.append("product_num", commentPnum.getAttribute("data-commentPnum"));
    // 
    form.append("board_num", board_num);

    let msg = "댓글 추가 완료";

    if(!flag){
        url = "./commentUpdate";
    //    param = "board_contents=" + contents + "&board_num=" + board_num;
        msg = "댓글 수정 완료";
    }


    commentClose.click();

    
    //옵션은 {}
    // Get 방식일 때는 파라미터를 ./commentAdd 뒤에 ? 를 붙여서함
    // Post방식일 때는 body에 담아서 보냄
    fetch(url, {
        method : "POST",
        // headers:{
        //     "Content-type":"application/x-www-form-urlencoded"
        // },
    body: form
    })
    .then(r=>r.text()) //결과가 오면 텍스트를  꺼내자
    .then(r=>{
        r=r.trim();
        if(r>0){
            alert(msg);
            getList(1);
        }
    })
    
    .catch(()=>{
        alert("댓글 추가 실패");
    })    

    commentContent.value = "";
})


//@@ comment List를 가져오는 과정.

function getList(page){
    fetch("commentList?product_num=" + commentPnumCon + "&page=" + page,{
        method : "GET"
    })
    .then(r=>r.text())
    .then(r=>commentList.innerHTML=r)
}



//
commentList.addEventListener("click", (e)=>{
    e.preventDefault();
    //preventDefault를 사용하면 기본적으로 가지고 있던 a태그 이벤트가 작동하지 않음,.
    if(e.target.classList.contains("pageList")){
        let p = e.target.getAttribute("data-page-num");
        alert(p);
        getList(p);
    }
})


// 댓글 하나 삭제


commentList.addEventListener("click", (e)=>{
    if(e.target.classList.contains("commentListBtn")){
        let id = e.target.getAttribute("data-commentListBtn");
        fetch("./commentDelete", {
            //상대경로는 생략이 가능하다 ./ 일 떄만!
            method : "POST",
            headers:{
                "Content-type":"application/x-www-form-urlencoded"
            },
            body:"board_num=" + id
        })
        .then(r=>r.text())
        .then(r=>{
            r=r.trim();
            if(r>0){
                alert("삭제 성공");
                getList(1);
            }else{
                alert("삭제 실패");
            }
        })
    }
})



