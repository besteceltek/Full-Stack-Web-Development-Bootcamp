import { clients } from '../../data'

function Client() {
  return (
    <div className="review-content">
        {clients.map((client, index) => (
            <div key={index} className="client-card">
                <div className="client">
                    <img src={client.image} alt="" />
                    <div className="client-info">
                        <h4>{client.name}</h4>
                        <p>{client.title}</p>
                    </div>
                </div>
                <div className="client-text">
                    <p>{client.comment}</p>
                </div>
            </div>
        ))}
    </div>
  )
}

export default Client