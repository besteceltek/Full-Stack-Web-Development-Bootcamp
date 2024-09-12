import { useState } from 'react'
import './App.css'
import Header from "./components/Header/Header"
import Home from "./components/Home/Home"
import Classes from './components/Classes/Classes'
import Trainer from './components/Trainer/Trainer'
import Review from './components/Review/Review'
import Contact from './components/Contact/Contact'
import Footer from './components/Footer/Footer'

function App() {
  const [activePage, setActivePage] = useState("Active Page")

  return (
    <>
      <Header />
      <Home />
      <Classes />
      <Trainer />
      <Review />
      <Contact />
      <Footer />
    </>
  )
}

export default App