const menubuttons = Array.from(document.getElementsByClassName("sub-menu-button"));
const menucontents = Array.from(document.getElementsByClassName("sub-menu-content"));
function menu(){
    menubuttons.forEach(element => {
        if(element.classList.contains("active-button")){
            element.style.backgroundColor = "rgb(38, 149, 255)";
            element.style.color = "white";
        }
        else{
            element.style.backgroundColor = "white";
            element.style.color = "rgb(38, 149, 255)";
        }
    });
}
function menucontent(){
    menucontents.forEach(element => {
        element.style.display = element.classList.contains("active-content")?"block":"none";   
    });
}


menubuttons.forEach(button => {
    button.addEventListener("click",()=>{
        const id = button.id;
        menubuttons.forEach(button =>{
            const isActive = button.id === id;
            button.classList.toggle("active-button",isActive);
        });
        menucontents.forEach(element => {
            const isActive = element.id === id;
            element.classList.toggle("active-content",isActive);
        });
        menucontent();
        menu();
    });
});
menucontent();
menu();

document.getElementById("nav-2").style.borderBottom = "2px solid white";