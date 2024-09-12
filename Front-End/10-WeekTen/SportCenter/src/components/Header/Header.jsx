import Logo from "./Logo"
import './Header.css'
import "./Scroll.js"

const navbarHandler = () => {
    const navbar = document.querySelector('.navbar')
    navbar.classList.toggle('active');
}

function Header() {
    return (
        <header className="header">
            <div className="container">
                <Logo />
                <div className="hamburger" onClick={navbarHandler}>
                    <i className="fas fa-bars"></i>
                </div>
                <nav className="navbar">
                    <span>Home</span>
                    <span>Classes</span>
                    <span>Trainer</span>
                    <span>Review</span>
                    <span>Contact</span>
                    <a href="#joinus">
                        <button className="join-us-btn">JOIN US</button>
                    </a>
                </nav>
            </div>
        </header>
    )
}

export default Header