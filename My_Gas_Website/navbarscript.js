
function checkViewport() {
  var menu = document.querySelector('.mobile-menu');
  var menuToggle = document.querySelector('.menu-toggle');

  if (window.innerWidth >= 780) {
    menu.classList.remove('show');
    menu.style.display = 'none'; // Hide the mobile menu
    menuToggle.style.display = 'none';
  } else {
    menuToggle.style.display = 'block';
    menu.style.display = ''; // Reset the display property of the mobile menu


  }
}
function toggleMobileMenu() {
  var menu = document.querySelector('.mobile-menu');
  menu.classList.toggle('show');
}

window.addEventListener('resize', checkViewport);
checkViewport();
