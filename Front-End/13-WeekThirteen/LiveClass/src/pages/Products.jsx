import { useEffect, useState } from 'react'
import ProductsCard from '../components/ProductsCard'
import axios from 'axios'
import Loading from '../components/Loading'
import Error from '../components/Error'

function Products() {
    const [products, setProducts] = useState([])
    const [isLoading, setIsLoading] = useState(true)
    const [error, setError] = useState(false)

    useEffect(() => {
        axios
        .get('https://dummyjson.com/products')
        .then((res) => {
          setProducts(res.data.products)
          setIsLoading(false)
        })
        .catch((err) => setError(true))
        .finally(() => console.log("API call finished"))
    }, [])

  if (isLoading) return <Loading />
  if (error) return <Error /> 
  return (
    <div className='products'>
        {products.map((product, index) => (
            <ProductsCard key={index} product={product} />
        ))}
    </div>
  )
}

export default Products