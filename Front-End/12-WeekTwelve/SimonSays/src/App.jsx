import { useState, useEffect } from 'react'
import './App.css'

const boardItem = [
  { id: 1, name: "green"},
  { id: 2, name: "blue"},
  { id: 3, name: "red"},
  { id: 4, name: "yellow"}
]

function sleep(ms = 500) {
  return new Promise(res => setTimeout(res, ms))
}

function App() {
  const [compArr, setCompArr] = useState([])
  const [userArr, setUserArr] = useState([])
  const [turn, setTurn] = useState(false)

  useEffect(() => {
    const randomNumber = Math.floor(Math.random() * 4) + 1
    setCompArr((prev) => [...prev, randomNumber]) 
  }, [])

  useEffect(() => {
    const playCompArr = async () => {
      for (let i = 0; i < compArr.length; i++) {
        const pad = document.getElementById(compArr[i])
        pad.classList.add("active")
        await sleep()
        pad.classList.remove("active")
        await sleep()
      }
      if (compArr.length !== 0) {
        setTurn((prev) => !prev)
      }
    }
    playCompArr()
  }, [compArr])

  return (
    <div className='App'>
      <h3>{turn ? "Sıra sende" : "Sıra Simon'da"}</h3>
      <div className='board'>
        <div className='pads'>
          {boardItem.map((item) => (
            <div
              key={item.name} 
              id={item.id} 
              className={`pad ${item.name}`}
            ></div>
          ))}
        </div>
      </div>
    </div>
  )
}

export default App
