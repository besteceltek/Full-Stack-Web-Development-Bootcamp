import { useEffect, useState } from 'react'
import ProductsCard from '../components/ProductsCard'
import axios from 'axios';

function Products() {
    const [products, setProducts] = useState([]);
    useEffect(() => {
        axios
        .get('https://dummyjson.com/products')
        .then((res) => setProducts(res.data.products))
    }, [])
  return (
    <div className='products'>
        {products.map((product, index) => (
            <ProductsCard key={index} product={product} />
        ))}
    </div>
  )
}

export default Products