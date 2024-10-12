import { useState } from 'react'
import './App.css'

function App() {
  const [todos, setTodos] = useState([])
  const [newTodo, setNewTodo] = useState("")
  const [filter, setFilter] = useState("All")

  const addTodo = () => {
    if (newTodo.trim() !== "") {
      setTodos([...todos, { text: newTodo, completed: false }])
      setNewTodo("")
    }
  }

  const handleKeyPress = (e) => {
    if (e.key === "Enter") {
      e.preventDefault()
      addTodo()
    }
  }

  const deleteTodo = (index) => {
    const updatedTodos = todos.filter((_, i) => i !== index)
    setTodos(updatedTodos)
  }

  const toggleTodo = (index) => {
    const updatedTodos = [...todos]
    updatedTodos[index].completed = !updatedTodos[index].completed
    setTodos(updatedTodos)
  }

  const getFilteredTodos = () => {
    if (filter === "Active") {
      return todos.filter((todo) => !todo.completed)
    } else if (filter === "Completed") {
      return todos.filter((todo) => todo.completed)
    }
    return todos
  }

  const clearCompletedTodos = () => {
    const activeTodos = todos.filter((todo) => !todo.completed)
    setTodos(activeTodos)
  }

  return (
    <>
      <section className='todoapp'>
        <header className="header">
        	<h1>todos</h1>
        	<form>
        		<input
              className="new-todo"
              value={newTodo}
              onChange={(e) => setNewTodo(e.target.value)}
              onKeyDown={handleKeyPress}
              placeholder="What needs to be done?"
              autoFocus />
        	</form>
        </header>
        <div className='main'>
          <input className='toggle-all' type="checkbox" />
          <label htmlFor="toggle-all"> Mark all as complete</label>
          <ul className='todo-list'>
            {getFilteredTodos().map((todo, index) => (
              <li key={index} className={todo.completed ? "completed" : ""}>
                <div className='view' onClick={() => toggleTodo(index)}>
                  <input className="toggle" type="checkbox" checked={todo.completed} readOnly />
                  <label>{todo.text}</label>
                  <button 
                    className="destroy" 
                    onClick={(e) => {
                      e.stopPropagation()
                      deleteTodo(index)
                    }}></button>
                </div>
              </li>
            ))}
          </ul>
        </div>
        <footer className='footer'>
          <span className='todo-count'>
            <strong>{todos.filter(todo => !todo.completed).length}</strong> items left
          </span>
          <ul className='filters'>
            <li>
              <a href="#/" className={filter === "All" ? "selected" : ""} onClick={() => setFilter("All")}>
                All
              </a>
            </li>
            <li>
              <a href="#/" className={filter === "Active" ? "selected" : ""} onClick={() => setFilter("Active")}>
                Active
              </a>
            </li>
            <li>
              <a href="#/" className={filter === "Completed" ? "selected" : ""} onClick={() => setFilter("Completed")}>
                Completed
              </a>
            </li>
          </ul>
          <button className='clear-completed' onClick={clearCompletedTodos}>
            Clear completed
          </button>
        </footer>
      </section>
      <footer className="info">
      	<p>Click to edit a todo</p>
      	<p>Created by <a href="https://d12n.me/">Dmitry Sharabin</a></p>
      	<p>Part of <a href="http://todomvc.com">TodoMVC</a></p>
      </footer>
    </>
  )
}

export default App