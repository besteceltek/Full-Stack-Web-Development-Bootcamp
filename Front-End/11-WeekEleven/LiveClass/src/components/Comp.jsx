import { useContext } from "react"
import { ActivePageContext } from "../context/ActivePageProvider"
import Home from "./Home"
import About from "./About"
import Contact from "./Contact"

function Comp() {
    const { activePage } = useContext(ActivePageContext)
    if (activePage === 'Home') {
        return <Home />
    } else if (activePage === 'About') {
        return <About />
    } else if (activePage === 'Contact') {
        return <Contact />
    }
}

export default Comp