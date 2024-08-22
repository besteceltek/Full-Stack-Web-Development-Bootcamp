import { useContext } from "react"
import { ActivePageContext } from "../../context/ActivePageProvider"

function Links() {
    const { setActivePage } = useContext(ActivePageContext)
    return (
        <nav className="navbar">
            <span onClick={() => setActivePage("Home")}>Home</span>
            <span onClick={() => setActivePage("Classes")}>Classes</span>
            <span onClick={() => setActivePage("Trainer")}>Trainer</span>
            <span onClick={() => setActivePage("Review")}>Review</span>
            <span onClick={() => setActivePage("Contact")}>Contact</span>
            <a href="#joinus">
                <button className="join-us-btn">JOIN US</button>
            </a>
        </nav>
    )
}

export default Links