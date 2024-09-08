import { useState } from "react"

function Inputs({ setExpenses }) {
  const [expense, setExpense] = useState([
    {
    name: "",
    price: ""
    }
  ])

  const handleChange = (e) => {
    const {name, value} = e.target
    setExpense(prev => ({
      ...prev,
      [name]: value
    }))
  }

  const handleClick = () => {
    setExpenses(prev => [...prev, {name: expense.name, price: expense.price}])
    setExpense({
      name: "",
      price: ""
    })
  }

  return (
    <div>
      <p>Expense Name</p>
      <input 
        type="text" 
        name='name'
        value={expense.name} 
        onChange={(e) => handleChange(e)}/>
      <br />
      <p>Expense Price</p>
      <input 
        type="number" 
        name='price'
        value={expense.price} 
        onChange={(e) => handleChange(e)} />
      <br />
      <button onClick={handleClick}>Expense</button>
    </div>
  )
}

export default Inputs