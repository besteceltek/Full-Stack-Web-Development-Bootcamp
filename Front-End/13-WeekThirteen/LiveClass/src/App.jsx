import { Routes, Route } from 'react-router-dom'
import Navbar from './components/Navbar'
import './App.css'
import Products from './pages/Products'
import Basket from './pages/Basket'

function App() {

  return (
    <>
      <Navbar></Navbar>
      <Routes>
        <Route path='/' element={<Products />}/>
        <Route path='/basket' element={<Basket />}/>
      </Routes>
    </>
  )
}

export default App
