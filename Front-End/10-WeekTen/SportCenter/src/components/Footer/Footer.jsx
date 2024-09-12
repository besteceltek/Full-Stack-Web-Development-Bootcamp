import './Footer.css'
import Logo from "../Header/Logo"

function Footer() {
  return (
    <footer>
        <Logo />
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Aliquam facere corporis, quia possimus, quibusdam esse perspiciatis repellendus veritatis sint libero repudiandae nisi eaque reiciendis iusto enim cum nobis pariatur exercitationem dolorem beatae doloribus officiis! Magnam ut molestiae incidunt repudiandae fugit.</p>
        <div className="links">
            <div className="information">
                <h3>Information</h3>
                <ul>
                    <li>About Us</li>
                    <li>Classes</li>
                    <li>Blog</li>
                    <li>Contact</li>
                </ul>
            </div>
            <div className="helpful">
                <h3>Helpful Links</h3>
                <ul>
                    <li>Services</li>
                    <li>Support</li>
                    <li>Terms & Condition</li>
                    <li>Privacy Policy</li>
                </ul>
            </div>
        </div>
    </footer>
  )
}

export default Footer