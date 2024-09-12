import './Trainer.css'
import { trainers } from '../../data'
import { purchases } from '../../data'
import AddToCart from './AddToCart'

function Trainer() {
  return (
    <section className='trainer' id='trainer'>
        <div className="trainers">
            <h2>OUR BEST TRAINERS</h2>
            <hr />
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsam eos, voluptas doloremque ullam sequi commodi?</p>
            <div className="trainer-images">
                {trainers.map((trainer, index) => (
                    <div key={index} className="trainer-image">
                        <img src={trainer.image} alt="" />
                        <div className="trainer-text">
                            <h4>{trainer.name}</h4>
                            <p>{trainer.class}</p>
                        </div>
                    </div>
                ))}
            </div>
        </div>
        <div className="purchase">
            <h2>PURCHASE FROM US</h2>
            <hr />
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Laborum dolorem nulla beatae. Nihil, nobis hic?</p>
            <div className="purchase-cards">
                {purchases.map((purchase, index) => (
                    <div key={index} className="card">
                        <img src={purchase.image} alt="" />
                        <div className="card-text">
                            <h4>{purchase.product}</h4>
                            <p><span>{purchase.price}$</span> / {purchase.discount}$</p>
                            <AddToCart />
                        </div>
                    </div>
                ))}
            </div>
        </div>
    </section>
  )
}

export default Trainer