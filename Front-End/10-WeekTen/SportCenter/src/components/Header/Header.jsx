import Links from "./Links"
import Logo from "./Logo"
import './Header.css'

function Header() {
    return (
        <header class="header">
            <div class="container">
                <Logo />
                <div class="hamburger">
                    <i class="fas fa-bars"></i>
                </div>
                <Links />
            </div>
        </header>
    )
}

export default Header