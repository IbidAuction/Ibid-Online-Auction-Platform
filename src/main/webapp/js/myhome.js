document.getElementById("nav-1").style.borderBottom = "2px solid white";

const productModal = document.querySelector(".product-modal");
const modalClose = document.querySelector('#modalcls');

let viewId = null;

function viewProduct(el){
    viewId = el.getAttribute("data-product-id");
    var bids = getBidders(viewId);
    productModal.querySelector(".desc").innerText = el.querySelector(".discription").innerText;
    productModal.querySelector(".pname").innerText = el.querySelector(".item-title").innerText;
    productModal.querySelector(".itemi").src = el.querySelector(".item-image").src;
    productModal.querySelector(".day").src = el.querySelector(".day").innerText;
    productModal.querySelector(".hour").innerText = el.querySelector(".hour").innerText;
    productModal.querySelector(".minute").innerText = el.querySelector(".minute").innerText;
    productModal.querySelector(".sec").innerText = el.querySelector(".sec").innerText;
    // productModal.querySelector(".bidnum").innerText = bids.length;
    // productModal.querySelector(".topbid").innerText = bids[bids.length-1].bidAmount;
    productModal.style.display = 'flex';
    var input = productModal.querySelector(".amount");
    productModal.querySelector(".bidnow").addEventListener("click",addbid(viewId,input));
    
}

modalClose.addEventListener('click', ()=>{
    productModal.style.display = 'none';
    viewId = null;
})

function getBidders(id) {
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'getbidders?id='+id, true); // Replace 'YourServletURL' with the actual URL of your servlet
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function() {
        if (xhr.status >= 200 && xhr.status < 300) {
            // Success
            var response = JSON.parse(xhr.responseText);
            console.log('Response from servlet:', response);
            return response;
        } else {
            console.error('Error:', xhr.statusText);
        }
    };

    xhr.onerror = function() {
        console.error('Request failed');
    };
    xhr.send();
}

function addbid(id, input) {
    var amount = parseInt(input.name);
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'addbid?id='+id+'&amount='+amount, true); // Replace 'YourServletURL' with the actual URL of your servlet
    xhr.onload = function() {
        if (xhr.status >= 200 && xhr.status < 300) {
            // Success
            var response = xhr.responseText;
            console.log('Response from servlet:', response);
        } else {
            console.error('Error:', xhr.statusText);
        }
    };

    xhr.onerror = function() {
        console.error('Request failed');
    };
    xhr.send();
}
