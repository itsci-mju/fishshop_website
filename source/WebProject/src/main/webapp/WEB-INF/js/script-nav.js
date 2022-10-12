let mainNav = document.getElementById('js-menu');
let navBarToggle = document.getElementById('js-nav-toggle');

navBarToggle.addEventListener("click", function(){
    navBarToggle.classList.toggle('active-nav');
    document.body.classList.toggle('active-nav');
});