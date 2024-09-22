import { useState, useContext, useEffect } from "react"
import { ActivePageContext } from "../context/ActivePageProvider"

function Logo() {
  const [count, setCount] = useState(0)
  const { activePage } = useContext(ActivePageContext)

  useEffect(() => {
    setCount((prev) => prev + 1)
  }, [activePage])

  return (
    <div>Logo: {count}</div>
  )
}

export default Logo