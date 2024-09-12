import { useState } from 'react'
import './App.css'
import Header from "./components/Header/Header"
import Home from "./components/Home/Home"
import Classes from './components/Classes/Classes'
import Trainer from './components/Trainer/Trainer'

function App() {
  const [activePage, setActivePage] = useState("Active Page")

  return (
    <>
      <Header />
      <Home />
      <Classes />
      <Trainer />
    </>
  )
}

export default App