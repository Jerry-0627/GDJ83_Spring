const wishDelete = document.getElementsByClassName("wishDelete");


for(let w of wishDelete){
    w.addEventListener("click", ()=>{
        let id = w.getAttribute("data-wish-id");
        w.parentNode.parentNode.remove();
        alert(id);
    });
}