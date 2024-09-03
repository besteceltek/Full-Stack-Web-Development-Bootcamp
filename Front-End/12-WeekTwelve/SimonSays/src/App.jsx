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
  const [score, setScore] = useState(0)
  const [isPlaying, setIsPlaying] = useState(false)

  const handleStart = () => {
    setIsPlaying(true)
    computerTurn()
  }

  function computerTurn() {
    const randomNumber = Math.floor(Math.random() * 4) + 1
    setCompArr((prev) => [...prev, randomNumber]) 
  }

  useEffect(() => {
    const playCompArr = async () => {
      for (let i = 0; i < compArr.length; i++) {
        const pad = document.getElementById(compArr[i])
        await sleep()
        pad.classList.add("active")
        await sleep()
        pad.classList.remove("active")
      }
      if (compArr.length !== 0) {
        setTurn((prev) => !prev)
      }
    }
    playCompArr()
  }, [compArr])

  useEffect(() => {
    if (userArr.length === 0) return
    if (userArr.length === compArr.length) {
      if (JSON.stringify(userArr) === JSON.stringify(compArr)) {
        setScore(prev => prev + 1)
        setUserArr([])
        setTimeout(() => {
          computerTurn()
        }, 1000)
        setTurn((prev) => !prev)
      }else {
        setUserArr([])
        setCompArr([])
        setScore(0)
        setIsPlaying(false)
      }
    }
  }, [userArr])

  const handleClick = async (e) => {
    const id = parseInt(e.target.id)
    setUserArr((prev) => [...prev, id])
    const pad = document.getElementById(id)
    pad.classList.add("active")
    await sleep()
    pad.classList.remove("active")
  }

  return (
    <div className='App'>
      {isPlaying && (<h3>{turn ? "Sıra sende" : "Sıra Simon'da"}</h3>)}
      <h3>Score: {score}</h3>
      {!isPlaying && (
        <div>
          <h3>Simon Game</h3>
          <button onClick={handleStart}>Start Game</button>
        </div>
      )}
      {isPlaying && (
        <div className='board'>
          <div className='pads'>
            {boardItem.map((item) => (
              <div
                key={item.name} 
                id={item.id} 
                className={`pad ${item.name}`}
                onClick={handleClick}
              ></div>
            ))}
          </div>
        </div>
      )}
    </div>
  )
}

export default App
