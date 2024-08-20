import React, { useState } from "react";
import './App.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faShuffle } from '@fortawesome/free-solid-svg-icons'

function App() {
  const [player1Roll, setPlayer1Roll] = useState(1);
  const [player2Roll, setPlayer2Roll] = useState(1);

  const rollDice = () => {
    const rollInterval = setInterval(() => {
      setPlayer1Roll(Math.floor(Math.random() * 6) + 1);
      setPlayer2Roll(Math.floor(Math.random() * 6) + 1);
    }, 100);

    setTimeout(() => {
      clearInterval(rollInterval)
    },3000)
  };

  return (
    <>
      <div className='header'>
        <h1>Draw! 🤝🏻</h1>
      </div>
      <div className='game'>
        <div className="player">
          <h2 className='player-name'>Player 1</h2>
          <Dice face={player1Roll} />
        </div>
        <div className="player">
          <h2 className='player-name'>Player 2</h2>
          <Dice face={player2Roll} />
        </div>
      </div>
      <div className='play-button'>
        <button onClick={rollDice}><FontAwesomeIcon icon={faShuffle} /></button>
      </div>
    </>
  )
}

function Dice({ face }) {
  return (
    <img className="player-img" src={`/images/dice${face}.png`} alt={`Dice face ${face}`}/>
  )
}

export default App