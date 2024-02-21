/* js for hamburger */

const hamburger = document.querySelector('.hamburger');
const navLink = document.querySelector('.nav__link');

hamburger.addEventListener('click', () => {
  navLink.classList.toggle('hide');
});


/* js for slider */


let slideIndex = 0;
const slides = document.querySelectorAll('.slide');

function showSlide(n) {
    if (n < 0) {
        slideIndex = slides.length - 1;
    } else if (n >= slides.length) {
        slideIndex = 0;
    } else {
        slideIndex = n;
    }

    slides.forEach(slide => {
        slide.style.display = 'none';
    });

    slides[slideIndex].style.display = 'block';
}

function moveSlide(n) {
    showSlide(slideIndex += n);
}

// Auto slide
setInterval(() => moveSlide(1), 3000);

// Show first slide initially
showSlide(slideIndex);


/* js for mouse hover */

function changeImage(card) {
    var img = card.querySelector('img');
    img.src = img.getAttribute('data-hover');
}

function restoreImage(card) {
    var img = card.querySelector('img');
    img.src = img.getAttribute('data-original');
}



function toggleDropdown() {
    var dropdownContent = document.getElementById("dropdownContent");
    if (dropdownContent.style.display === "none") {
        dropdownContent.style.display = "block";
    } else {
        dropdownContent.style.display = "none";
    }
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
    if (!event.target.matches('#si')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        for (var i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.style.display === "block") {
                openDropdown.style.display = "none";
            }
        }
    }
}
