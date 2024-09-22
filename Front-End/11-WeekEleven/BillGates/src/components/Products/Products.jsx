import { useState } from "react";
import { products as initialProducts } from '../../data'; // Import your products
import "./Products.css"

function Products() {
  const [products, setProducts] = useState(initialProducts);

  const handleBuy = (index) => {
    const newProducts = [...products];
    newProducts[index].amount += 1;
    setProducts(newProducts);
  };

  const handleSell = (index) => {
    const newProducts = [...products];
    if (newProducts[index].amount > 0) {
      newProducts[index].amount -= 1;
    }
    setProducts(newProducts);
  };

  const handleAmount = (index, value) => {
    const newProducts = [...products];
    newProducts[index].amount = value >= 0 ? value : 0; // Ensure no negative values
    setProducts(newProducts);
  };

  return (
    <div className='items'>
        {initialProducts.map((product, index) => (
            <div key={index} className="item-wrapper">
                <img className='item-img' src={product.image} alt="" />
                <div className='item-name'>{product.name}</div>
                <div className='item-price'>${Math.round(product.price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}</div>
                <div className='item-controls'>
                    <button className='item-sell' onClick={() => handleSell(index)}> Sell </button>
                    <input 
                      className='item-input'
                      pattern="\d*"
                      type="number"
                      value={product.amount === 0 ? '' : product.amount}
                      onChange={(e) => handleAmount(index, parseInt(e.target.value) || 0)}
                    />
                    <button className='item-buy' onClick={() => handleBuy(index)}> Buy </button>
                </div>
            </div>
        ))}
    </div>
  )
}

export default Products