import { useState } from "react";
import { createContext } from "react"

const ActivePageContext = createContext();

function ActivePageProvider({ children }) {
    const [activePage, setActivePage] = useState("Active Page")
    return (
        <ActivePageContext.Provider value={{ activePage, setActivePage }}>
            {children}
        </ActivePageContext.Provider>
    )
}

export default ActivePageProvider
export { ActivePageContext }