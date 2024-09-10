import { statistics } from '../../data.js'

function Statistics() {
    return (
        <div className="statistics">
            {statistics.map((item, index) => (
                <div key={index} className="stat-block">
                    <p className="numbers">{item.number}</p>
                    <p className="texts">{item.text}</p>
                </div>
            ))}
        </div>
    )
}

export default Statistics