function List({ item }) {
  return (
    <li>
      <span>{item.name} </span>
      <span>${item.price}</span>
    </li>
  )
}

export default List