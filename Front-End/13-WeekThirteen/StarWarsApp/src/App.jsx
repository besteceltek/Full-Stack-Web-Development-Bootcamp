import './App.css'
import SpaceShips from './components/SpaceShips'
import ShipDetails from './components/ShipDetails'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import { useState } from 'react'

const App = () => {
  const [spaceShips, setSpaceShips] = useState([])
  return (
    <Router>
      <Routes>
        <Route path="/" element={<SpaceShips spaceShips={spaceShips} setSpaceShips={setSpaceShips} />}/>
        <Route path="/ship-details/:index" element={<ShipDetails spaceShips={spaceShips} />} />
      </Routes>
    </Router>
  )
}

export default App
