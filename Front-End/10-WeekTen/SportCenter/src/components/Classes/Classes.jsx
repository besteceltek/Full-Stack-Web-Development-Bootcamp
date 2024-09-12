import "./Classes.css"
import { useState } from "react"
import { classes } from "../../data"
import Bmi from "./Bmi"

function Classes() {
    const [activeClass, setActiveClass] = useState("yoga")

    const handleActiveClass = (e) => {
        setActiveClass(e.target.id)
    }

  return (
    <section className="classes" id="classes">
        <div className="padding"></div>
        <div className="class-background">
            <div className="class-header">
                <h2>OUR CLASSES</h2>
                <hr />
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsam eos, voluptas doloremque ullam sequi commodi?</p>
            </div>
            <div className="button-group">
                {classes.map((item, index) => (
                    <button key={index} id={item.name} className={`${item.name}-btn ${item.name === activeClass ? "active" : ""}`} onClick={handleActiveClass}>{item.header}</button>
                ))}
            </div>
            <div className="class-info">
                {classes.map((item, index) => (
                    <div key={index} className={`content ${item.name === activeClass ? "active" : ""}`} id={item.name}>
                        <div className={`${item.name}-info`}>
                            <h3>{item.header} Classes</h3>
                            <p>{item.description}</p>
                            <h3>When is the Class Time?</h3>
                            <ul>
                                {item.classTime.map((time, index) => (
                                    <li key={index}>{time.days}: {time.hours}</li>
                                ))}
                            </ul>
                        </div>
                        <div className="yoga-image">
                            <img src={item.image} alt="" />
                        </div>
                    </div>
                ))}
            </div>
        </div>
        <Bmi />
    </section>
  )
}

export default Classes