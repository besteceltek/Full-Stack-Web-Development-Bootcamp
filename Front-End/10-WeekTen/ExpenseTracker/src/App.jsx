import { useState } from 'react'
import './App.css'
import List from './components/List/List'
import Inputs from './components/Inputs/Inputs'

function App() {
  const [username, setUsername] = useState("")
  const [usernameInput, setUsernameInput] = useState("")
  const [expenses, setExpenses] = useState([
    {
      name: "Flower",
      price: 50
    },
    {
      name: "Bread",
      price: 5
    }
  ])

  const handleNewUser = () => {
    setUsername(usernameInput)
  }

  if ( username === "") {
    return (
      <>
        <h3>Welcome</h3>
        <input 
          type="text"
          value={usernameInput}
          onChange={(e) => setUsernameInput(e.target.value)}
        />
        <button onClick={handleNewUser}>Start</button>
      </>
    )
  }

  return (
    <>
      <h3>Expense Tracker</h3>
      <Inputs setExpenses={setExpenses}/>
      <hr />
      <h4>Expenses</h4>
      <ul>
        {expenses.map((item, index) => (
          <List key={index} item={item}/>
        ))}
      </ul>
    </>
  )
}

export default App
