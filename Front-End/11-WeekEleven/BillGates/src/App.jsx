import React, { useEffect, useState } from 'react';
import { products } from './data';
import billgates from './assets/billgates.jpg'
import './App.css';

function App() {
  const [totalMoney, setTotalMoney] = useState(100000000000);
  const [receiptItems, setReceiptItems] = useState([]);
  const [inputValues, setInputValues] = useState({});

  console.log(receiptItems)

  const handleBuy = (item, amount) => {
    const cost = item.price * amount;
    if (totalMoney - cost >= 0) {
      setTotalMoney(totalMoney - cost);

      const updatedReceipt = receiptItems.map(receiptItem => 
        receiptItem.name === item.name ? 
        { ...receiptItem, amount: receiptItem.amount + amount } : 
        receiptItem
      );
      
      if (!updatedReceipt.some(receiptItem => receiptItem.name === item.name)) {
        updatedReceipt.push({ ...item, amount });
      }
      
      setReceiptItems(updatedReceipt);
    } else {
      alert('Not enough money!');
    }
  };

  const handleSell = (item) => {
    const receiptItem = receiptItems.find(receiptItem => receiptItem.name === item.name);
    if (receiptItem) {
      if (receiptItem.amount > 0) {
        const refund = item.price;

        const updatedReceipt = receiptItems.map(receiptItem =>
          receiptItem.name === item.name && receiptItem.amount > 1
            ? { ...receiptItem, amount: receiptItem.amount - 1 }
            : receiptItem.name === item.name && receiptItem.amount === 1
            ? null
            : receiptItem
        ).filter(Boolean); // Remove items where the amount becomes 0

        setTotalMoney(totalMoney + refund);
        setReceiptItems(updatedReceipt);
      }
    }
  };

  const handleAmount = (item, inputAmount) => {
    const cost = item.price * inputAmount;

    // Check if the user has enough money to buy the entered amount
    if (totalMoney >= cost) {
      handleBuy(item, inputAmount);
    } else {
      // Calculate how many the user can buy with the available money
      const affordableAmount = Math.floor(totalMoney / item.price);
      if (affordableAmount > 0) {
        handleBuy(item, affordableAmount);
        alert(`Not enough money for ${inputAmount}. Bought ${affordableAmount} instead.`);
      } else {
        alert('Not enough money to buy even 1 unit.');
      }
    }
  };

  const handleInputChange = (item, value) => {
    // Update the input field value for the specific product
    setInputValues({
      ...inputValues,
      [item.name]: value,
    });
  };

  return (
    <div className="app">
      <div className='header'>
        <div className="title">
          <img className="header-img" src={billgates} alt="Image of Bill Gates" />
          <span>Spend Bill Gates' Money</span>
        </div>
        <div className="money-bar">${totalMoney.toLocaleString()}</div>
      </div>

      <div className="items">
        {products.map((product, index) => (
          <div key={index} className="item-wrapper">
            <img className='item-img' src={product.image} alt="" />
            <div className='item-name'>{product.name}</div>
            <div className='item-price'>${product.price.toLocaleString()}</div>
            <div className='item-controls'>
              <button 
                className='item-sell'
                onClick={() => handleSell(product)}
                disabled={!receiptItems.some(receiptItem => receiptItem.id === product.id)}
              > Sell </button>
              <input 
                className='item-input'
                pattern="\d*"
                type="number"
                value={inputValues[product.name] || ''} // Display input value for the product
                onChange={(e) => handleInputChange(product, parseInt(e.target.value) || 0)}
              />
              <button 
                className='item-buy'
                onClick={() => handleBuy(product, 1)} 
                disabled={totalMoney < product.price}
              > Buy </button>
            </div>
          </div>
        ))}
      </div>

      <div className='receipt-wrapper'>
        <div className='receipt-title'>Your Receipt</div>
        
        {receiptItems.length === 0 ? (
          <p>No items purchased yet.</p>
        ) : (
          receiptItems.map((item, index) => (
            <div key={index} className='receipt-items'>
              <div className='receipt-item-name'>{item.name}</div>
              <div className='receipt-item-amount'>x{item.amount}</div>
              <div className='receipt-item-cost'>${(item.price * item.amount).toLocaleString()}</div>
            </div>
          ))
        )}

        {receiptItems.length > 0 && (
          <div className='receipt-total'>
            <span>TOTAL</span>
            {/* Calculate the total cost of all items */}
            <div className='receipt-total-cost'>
              ${receiptItems.reduce((total, item) => total + item.price * item.amount, 0).toLocaleString()}
            </div>
          </div>
        )}
      </div>
    </div>
  );
}

export default App;
