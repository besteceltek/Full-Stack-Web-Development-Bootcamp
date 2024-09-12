import Client from './Client'
import './Review.css'

function Review() {
  return (
    <section className="review" id="review">
        <div className="review-background">
            <div className="review-header">
                <h2>REVIEW CLIENT</h2>
                <hr />
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsam eos, voluptas doloremque ullam sequi commodi?</p>
            </div>
            <Client />
        </div>
    </section>
  )
}

export default Review