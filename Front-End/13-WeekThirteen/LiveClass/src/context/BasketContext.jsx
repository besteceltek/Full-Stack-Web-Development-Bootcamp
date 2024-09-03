import { createContext, useState } from "react";

const BasketContext = createContext()

function BasketProvider({ children }) {
  const [basket, setBasket] = useState([])
  const addToBasket = (product) => {
    setBasket((prev) => [...prev, product])
  }
  const removeFromBasket = (product) => {
    setBasket((prev) => prev.filter(item => item.id !== product.id))
  }

  return (
    <BasketContext.Provider value={{basket, setBasket, addToBasket, removeFromBasket}}>
      {children}
    </BasketContext.Provider>
  )
}

export { BasketProvider }

export default BasketContext