import { useContext } from "react"
import { ActivePageContext } from "../context/ActivePageProvider"

function Links() {
  const { setActivePage } = useContext(ActivePageContext)
  return (
    <div className="links">
        <span onClick={() => setActivePage("Home")}>Home</span>
        <span onClick={() => setActivePage("About")}>About</span>
        <span onClick={() => setActivePage("Contact")}>Contact</span>
    </div>
  )
}

export default Links