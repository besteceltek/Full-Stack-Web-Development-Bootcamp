window.addEventListener("scroll", () => {
    const header = document.querySelector(".header");
    const scrollPosition = window.scrollY;

    if (scrollPosition > 70) { 
        header.style.backgroundColor = "#355592";
    } else {
        header.style.backgroundColor = "";
    }
});
