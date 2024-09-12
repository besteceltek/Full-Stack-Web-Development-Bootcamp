import './Trainer.css'
import { trainers } from '../../data'
import Purchase from './Purchase'

function Trainer() {
  return (
    <section className='trainer' id='trainer'>
        <div className="trainers">
            <h2>OUR BEST TRAINERS</h2>
            <hr />
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsam eos, voluptas doloremque ullam sequi commodi?</p>
            <div className="trainer-images">
                {trainers.map((trainer, index) => (
                    <div key={index} className="trainer-image">
                        <img src={trainer.image} alt="" />
                        <div className="trainer-text">
                            <h4>{trainer.name}</h4>
                            <p>{trainer.class}</p>
                        </div>
                    </div>
                ))}
            </div>
        </div>
        <Purchase />
    </section>
  )
}

export default Trainer