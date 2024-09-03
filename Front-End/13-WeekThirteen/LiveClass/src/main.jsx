import { BrowserRouter } from 'react-router-dom'
import { createRoot } from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import { BasketProvider } from './context/BasketContext.jsx'

createRoot(document.getElementById('root')).render(
  <BasketProvider>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </BasketProvider>
)
