/**
 * 
 */
const add = document.getElementById("add");
const result = document.getElementById("result");

let idx = 0; // 부모의 id값으로 사용
let max = 1; // 최대 첨부 파일 개수
let count = 0; // 만든 횟수

function setMax(m){
    max = m;
}
 
 result.addEventListener("click", function(e){
    if(e.target.id=="del"){
        //e.target.parentNode.parentNode.remove();
        let ids = e.target.getAttribute("data-del-id");
        document.getElementById(ids).remove();
        count--;
    }
})
 
 add.addEventListener("click", function(){

        if(count >= max){
            alert("첨부 파일은 최대" + max +" 개만 가능하단다.");
            return;
        }

        let parent = document.createElement("div");
        parent.id="file" + idx;
        parent.classList.add("input-group", "mb-3");

        let input = document.createElement("input");
        input.type = "file";
        input.name = "files";
        input.classList.add("form-control");
        parent.append(input);

        let div = document.createElement("div");
        div.classList.add("input-group-append")
        let span = document.createElement("span");
        span.classList.add("input-group-text");
        span.id="del";
        span.setAttribute("data-del-id", "file"+idx);
        span.innerText="X";
        div.append(span);
        parent.append(div);

        result.append(parent);

        idx++;
        count++;

})