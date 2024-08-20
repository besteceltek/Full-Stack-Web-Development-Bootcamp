import { useState } from 'react'
import './App.css'
import Main from "./components/Main"
import Navbar from "./components/Navbar"
import ActivePageProvider from './context/ActivePageProvider'

function App() {
  const [activePage, setActivePage] = useState("Active Page")

  return (
    <ActivePageProvider>
      <Navbar />
      <Main />
    </ActivePageProvider>
  )
}

export default App
