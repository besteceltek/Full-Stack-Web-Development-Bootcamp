import './Contact.css'
import ContactInfo from './ContactInfo.jsx'
import Map from './Map.jsx'
import Appointment from './Appointment.jsx'

function Contact() {
  return (
    <section className="contact" id="contact">
        <div className="padding"></div>
        <div className="contact-header">
            <h2>CONTACT US</h2>
            <hr />
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsam eos, voluptas doloremque ullam sequi commodi?</p>
        </div>
        <div className="container">
            <div className="left">
                <ContactInfo />
                <Appointment />
            </div>
            <Map />
        </div>
    </section>
  )
}

export default Contact