import { useEffect, useState } from 'react'
import axios from 'axios'
import logo from '../assets/logo.png'
import shipImg from '../assets/ship.jpg'
import { useNavigate } from 'react-router-dom'

function SpaceShips({ spaceShips, setSpaceShips }) {
  
  const [nextPage, setNextPage] = useState(1)
  const [getUrl, setGetUrl] = useState(`${import.meta.env.VITE_APP_BASE_URL}?page=1`)
  const [hasMorePages, setHasMorePages] = useState(true)
  const [searchTerm, setSearchTerm] = useState('')

  const navigate = useNavigate()

  useEffect(() => {
    axios.get(getUrl)
    .then((res) => {
      if (nextPage === 1 || searchTerm !== '') {
        setSpaceShips(res.data.results)
      } else {
        setSpaceShips(prevShips => [...prevShips, ...res.data.results])
      }

      if (res.data.next) {
        setNextPage(prev => prev + 1)
      } else {
        setHasMorePages(false)
      }
    })
    .catch(err => console.error(err))
  }, [getUrl])

  const handleLoadMore = () => {
    setGetUrl(`${import.meta.env.VITE_APP_BASE_URL}?page=${nextPage}&search=${searchTerm}`)
  }

  const handleSearch = (e) => {
    const value = e.target.value
    setSearchTerm(value)
    setNextPage(1)
    setHasMorePages(true)
    setGetUrl(`${import.meta.env.VITE_APP_BASE_URL}?page=1&search=${value}`)  
  };

  const handleCardClick = (index) => {
    navigate(`/ship-details/${index}`)
  };

  return (
    <div className="container">
      <div className='logo'>
        <img src={logo} alt="" />
      </div>
      <div className='filter-area'>
        <p>Name / Model</p>
        <input 
          type="text"
          placeholder='Name / Model'
          value={searchTerm}
          onChange={handleSearch}
        />
        <button>Filter</button>
      </div>
      <hr />
      <div className='ship-container'>
        {spaceShips.map((ship, index) => (
          <div 
            key={index}
            className='ship-card'
            style={{ cursor: 'pointer' }}
            onClick={() => handleCardClick(index)}
          >
            <img src={shipImg} alt="" />
            <h3>{ship.name}</h3>
            <div className="ship-info">
              <p><strong>Model:</strong> {ship.model}</p>
              <p><strong>Hyperdrive Rating:</strong> {ship.hyperdrive_rating}</p>
            </div>
          </div>
        ))}
      </div>
      {hasMorePages && (
        <button onClick={handleLoadMore}>Load More</button>
      )}
    </div>
  )
}

export default SpaceShips