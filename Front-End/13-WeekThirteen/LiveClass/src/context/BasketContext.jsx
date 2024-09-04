import { createContext, useState, useReducer } from "react";
import { basketReducer, initialState } from "./BasketReducer"

const BasketContext = createContext()

function BasketProvider({ children }) {
  const [basket, setBasket] = useReducer(basketReducer, initialState)
  
  const removeFromBasket = (product) => {
    setBasket({type: "REMOVE_FROM_BASKET", payload: product})
  }

  const addToBasket = (product) => {
    setBasket({type: "ADD_TO_BASKET", payload: product})
  }

  return (
    <BasketContext.Provider value={{basket, addToBasket, removeFromBasket}}>
      {children}
    </BasketContext.Provider>
  )
}

export { BasketProvider }

export default BasketContext