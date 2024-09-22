import { useState } from 'react'
import './App.css'
import Header from './components/Header/Header'
import Products from './components/Products/Products'
import Receipt from './components/Receipt/Receipt'

function App() {
  const [money, setMoney] = useState(100000000000)

  return (
    <div className='container'>
      <Header money={money} />
      <Products />
      <Receipt />
    </div>
  )
}

export default App
