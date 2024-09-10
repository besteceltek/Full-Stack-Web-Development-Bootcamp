import Statistics from "./Statistics"
import "./Home.css"

function Home() {
    return (
        <section className="home" id="home">
            <div className="hero-image">
                <img src="src/assets/hero-man.jpg" alt=""/>
            </div>
            <div className="home-content">
                <h3>POWERFULL</h3>
                <h1>Group<br/>Practice<br/>With Trainer</h1>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Impedit ea mollitia tenetur cum repellat culpa dolorem illo voluptatem beatae. Quasi expedita dolore nostrum eligendi. Aliquam amet repellat corrupti officia laboriosam.</p>
                <div className="hero-buttons">
                    <a className="btn signup" href="#">Sign Up</a>
                    <a className="btn details" href="#">Details</a>
                </div>
            </div>
            <Statistics />
        </section>
    )
}

export default Home