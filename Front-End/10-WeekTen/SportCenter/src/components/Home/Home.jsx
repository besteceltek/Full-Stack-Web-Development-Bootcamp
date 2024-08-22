import Statistics from "./Statistics"
import HomeContent from "./HomeContent"
import "./Home.css"

function Home() {
    return (
        <section className="home" id="home">
            <div className="hero-image">
                <img src="src/assets/hero-man.jpg" alt=""/>
            </div>
            <HomeContent />
            <Statistics />
        </section>
    )
}

export default Home