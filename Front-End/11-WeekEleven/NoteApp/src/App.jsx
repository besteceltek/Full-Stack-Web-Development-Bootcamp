import { useState } from 'react'
import './App.css'

function App() {
  const [notes, setNotes] = useState([])
  const [currentNote, setCurrentNote] = useState('')
  const [selectedColor, setSelectedColor] = useState('#000000')
  const [filterText, setFilterText] = useState('')

  const handleAddNote = () => {
    if (currentNote.trim() !== '') {
      setNotes(
        [...notes, 
          { 
            text: currentNote, 
            color: selectedColor 
          }
        ]
      );
      setCurrentNote('')
      setSelectedColor('#000000')
    }
  };

  const filteredNotes = notes.filter(note => note.text.toLowerCase()
    .includes(filterText.toLowerCase()));

  return (
    <div style={{ padding: '20px' }}>
      <h1>Notes App</h1>
      <input
        className='filter-area'
        type="text"
        placeholder="Search..."
        value={filterText}
        onChange={(e) => setFilterText(e.target.value)}
      />
      <div className='note-area'>
        <textarea
          className='text-area'
          value={currentNote}
          onChange={(e) => setCurrentNote(e.target.value)}
          placeholder="Enter your note here..."
          rows="4"
          cols="50"
        />
        <input
        type="color"
        value={selectedColor}
        onChange={(e) => setSelectedColor(e.target.value)}
      />
        <button className='add-button' onClick={handleAddNote}>ADD</button>
      </div>
      <div className='notes-list'>
        {filteredNotes.map((note, index) => (
          <p className='note' key={index} style={{ backgroundColor: note.color }}>{note.text}</p>
        ))}
      </div>
    </div>
  )
}

export default App
