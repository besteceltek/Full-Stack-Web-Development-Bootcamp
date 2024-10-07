import { useNavigate, useParams } from 'react-router-dom';
import shipImg from '../assets/ship.jpg'
import './ShipDetails.css'
import ArrowBackIcon from '@mui/icons-material/ArrowBack';

const ShipDetails = ({ spaceShips }) => {
  const { index } = useParams()
  const shipIndex = parseInt(index, 10)
  const shipDetails = spaceShips[shipIndex]
  const navigate = useNavigate()

  if (!shipDetails) {
    return (
      <div>
        <button className='back-button' onClick={() => navigate(-1)}>
          <ArrowBackIcon/>
        </button>
        Loading...
      </div>
    );
  }

  return (
    <div>
      <button className='back-button' onClick={() => navigate(-1)}>
        <ArrowBackIcon/>
      </button>
      <div className='card-container'>
        <div className="details-card">
          <h2>{shipDetails.name}</h2>
          <hr />
          <img src={shipImg} alt="" />
          <div className="details-info">
            <p><strong>Model: </strong>{shipDetails.model}</p>
            <p><strong>Hyperdrive Rating: </strong>{shipDetails.hyperdrive_rating}</p>
            <p><strong>Passengers: </strong>{shipDetails.passengers}</p>
            <p><strong>Max Atmospheric Speed: </strong>{shipDetails.max_atmosphering_speed}</p>
            <p><strong>Manufacturer: </strong>{shipDetails.manufacturer}</p>
            <p><strong>Crew: </strong>{shipDetails.crew}</p>
            <p><strong>Cargo Capacity: </strong>{shipDetails.consumables}</p>
          </div>
        </div>
      </div>
    </div>
  )
}

export default ShipDetails