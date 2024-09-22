import './Receipt.css'
import { products } from '../../data'

function Receipt() {
  return (
    <div className='receipt-wrapper'>
        <div className='receipt-title'>Your Receipt</div>
        {products.map((product, index) => (
            <div key={index} className='receipt-items' style={{display: "none"}}>
                <div className='receipt-item-name'>{product.name}</div>
                <div className='receipt-item-amount'>x{product.amount}</div>
                <div className='receipt-item-cost'>${product.price * product.amount}</div>
            </div>
        ))}
        <div className='receipt-total'>
            <span>TOTAL</span>
            <div className='receipt-total-cost'>$100</div>
        </div>
    </div>
  )
}

export default Receipt