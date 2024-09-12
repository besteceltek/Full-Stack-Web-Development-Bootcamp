import { purchases } from '../../data'
import AddToCart from './AddToCart'

function Purchase() {
  return (
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
  )
}

export default Purchase