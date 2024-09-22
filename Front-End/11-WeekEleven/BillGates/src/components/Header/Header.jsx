import billgates from "../../assets/billgates.jpg"
import "./Header.css"

function Header({ money }) {
  return (
    <div>
        <div className="title">
            <img className="header-img" src={billgates} alt="Image of Bill Gates" />
            <span>Spend Bill Gates' Money</span>
        </div>
        <div className="money-bar">${Math.round(money).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}</div>
    </div>
  )
}

export default Header