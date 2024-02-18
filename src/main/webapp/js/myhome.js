var clicked = false;
let profilepic = document.getElementById("profilepic");
profilepic.addEventListener("click",function(){
    console.log("clicked");
    if(clicked){
        document.getElementById("sub-menu").style.display = "none";
        clicked = false;
    }
    else{
        document.getElementById("sub-menu").style.display = "block";
        clicked = true;
    }
});
