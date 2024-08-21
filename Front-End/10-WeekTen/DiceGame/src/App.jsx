import React, { useState } from "react";
import './App.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faShuffle } from '@fortawesome/free-solid-svg-icons'

function App() {
  const [player1Roll, setPlayer1Roll] = useState(1)
  const [player2Roll, setPlayer2Roll] = useState(1)
  const [rolling, setRolling] = useState(false)
  const [result, setResult] = useState("Let's Play")
  const [player1Name, setPlayer1Name] = useState("Player 1");
  const [player1NameInput, setPlayer1NameInput] = useState("");

  const rollDice = () => {
    setRolling(true)
    const rollInterval = setInterval(() => {
      setPlayer1Roll(Math.floor(Math.random() * 6) + 1)
      setPlayer2Roll(Math.floor(Math.random() * 6) + 1)
    }, 100)

    setTimeout(() => {
      clearInterval(rollInterval)

      const finalPlayer1Roll = Math.floor(Math.random() * 6) + 1;
      const finalPlayer2Roll = Math.floor(Math.random() * 6) + 1;

      setPlayer1Roll(finalPlayer1Roll);
      setPlayer2Roll(finalPlayer2Roll);

      if (finalPlayer1Roll > finalPlayer2Roll) {
        setResult(`${player1Name} Wins!`);
      } else if (finalPlayer1Roll < finalPlayer2Roll) {
        setResult("Player 2 Wins!");
      } else {
        setResult("It's a Draw!");
      }

      setRolling(false)
    },2000)
  }

  const handleNameChange = (e) => {
    setPlayer1NameInput(e.target.value);
  };

  const updatePlayer1Name = () => {
    setPlayer1Name(player1NameInput || "Player 1");
  };

  return (
    <>
      <div className='header'>
        <h1>Draw! 🤝🏻</h1>
      </div>
      <div className="input-area">
        <input type="text" placeholder="Enter Player 1 Name" value={player1NameInput} onChange={handleNameChange} />
        <button onClick={updatePlayer1Name}>Update Name</button>
      </div>
      <div className='game'>
        <div className="player">
          <h2 className='player-name'>{player1Name}</h2>
          <Dice face={player1Roll} />
        </div>
        <div className="player">
          <h2 className='player-name'>Player 2</h2>
          <Dice face={player2Roll} />
        </div>
      </div>
      <div className='play-button'>
        <button onClick={rollDice} disabled={rolling}><FontAwesomeIcon icon={faShuffle} /></button>
        <h2>{result}</h2>
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