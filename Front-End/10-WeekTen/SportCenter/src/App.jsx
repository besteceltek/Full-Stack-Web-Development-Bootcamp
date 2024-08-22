import { useState } from 'react'
import './App.css'
import Header from "./components/Header/Header"
import Home from "./components/Home/Home"
import ActivePageProvider from './context/ActivePageProvider'

function App() {
  const [activePage, setActivePage] = useState("Active Page")

  return (
    <ActivePageProvider>
      <Header />
      <Home />
    </ActivePageProvider>
  )
}

export default App
