import './Review.css'
import { clients } from '../../data'

function Review() {
  return (
    <section className="review" id="review">
        <div className="review-background">
            <div className="review-header">
                <h2>REVIEW CLIENT</h2>
                <hr />
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsam eos, voluptas doloremque ullam sequi commodi?</p>
            </div>
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
        </div>
    </section>
  )
}

export default Review