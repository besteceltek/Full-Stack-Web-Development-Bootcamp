import { useState } from 'react'
import './App.css'
import { content } from './data'
import Viewer from './components/Viewer/Viewer'

function App() {
  const [list, setList] = useState(content)
  const [activeFolderId, setActiveFolderId] = useState("1")
  const [parentFolderId, setParentFolderId] = useState(null)
  const changeFolder = (id) => {
    setActiveFolderId(id)
    setParentFolderId(activeFolderId)
  }
  return (
    <>
      <Viewer 
      parentFolderId={parentFolderId}
      activeFolderId={activeFolderId} 
      list={list} 
      changeFolder={changeFolder} />
    </>
  )
}

export default App
