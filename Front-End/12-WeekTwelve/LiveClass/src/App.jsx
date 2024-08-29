import axios from 'axios'
import { useEffect,useState } from 'react'
import './App.css'

function App() {
  const [data, setData] = useState()

  useEffect(() => {
    axios.get('https://dummyjson.com/users').then(res => {
      setData(res.data)
    })
  }, [])

  return (
    <>
      <h1>Cohort 3</h1> 
      <div>
        {data?.users?.map((user, index) => (
          <div key={index} className='user'>
            <h3>
              {" "}
              {user.firstName} {user.lastName} {" "}
            </h3>
            <p> {user.role} </p>
            <hr/>
          </div>
        ))}  
      </div> 
    </>
  )
}

export default App
