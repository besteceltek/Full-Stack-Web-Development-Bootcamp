import { useState } from 'react'
import './App.css'
import Header from "./components/Header/Header"
import ActivePageProvider from './context/ActivePageProvider'

function App() {
  const [activePage, setActivePage] = useState("Active Page")

  return (
    <ActivePageProvider>
      <Header />
    </ActivePageProvider>
  )
}

export default App
