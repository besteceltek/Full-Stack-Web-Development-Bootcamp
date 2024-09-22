import './App.css'
import Main from './components/Main'
import Navbar from './components/Navbar'
import ActivePageProvider from './context/ActivePageProvider'

function App() {
  
  return (
    <ActivePageProvider>
      <Navbar />
      <Main />
    </ActivePageProvider>
  )
}

export default App
