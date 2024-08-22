import Links from "./Links"
import Logo from "./Logo"
import './Header.css'

function Header() {
    return (
        <header className="header">
            <div className="container">
                <Logo />
                <div className="hamburger">
                    <i className="fas fa-bars"></i>
                </div>
                <Links />
            </div>
        </header>
    )
}

export default Header