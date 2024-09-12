import './Contact.css'

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
                <div className="contact-info">
                    <div className="mobile">
                        <h4>Mobile Number</h4>
                        <p>+135 773 321 4442</p>
                    </div>
                    <div className="email">
                        <h4>Email Address</h4>
                        <p>demo@demo.com</p>
                    </div>
                </div>
                <div className="appoinment">
                    <h3>Make An Appoinment</h3>
                    <input type="text" name="name" id="name" placeholder="Your Name" />
                    <input type="email" name="email" id="email" placeholder="Your Email" />
                    <textarea name="message" id="message" placeholder="Your Message"></textarea>
                </div>
            </div>
            <div className="right">
                <iframe 
                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d75352.07426802976!2d28.98989229027249!3d40.98470196477091!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14cac77679efc8e1%3A0x7f26fabbe30a7ebe!2sPowerfull%20Athletic%20Club!5e0!3m2!1str!2sie!4v1723316432122!5m2!1str!2sie" 
                    width="400" 
                    height="300" 
                    style={{border:0}} 
                    allowFullScreen="" 
                    loading="lazy" 
                    referrerPolicy="no-referrer-when-downgrade">
                </iframe>
            </div>
        </div>
    </section>
  )
}

export default Contact