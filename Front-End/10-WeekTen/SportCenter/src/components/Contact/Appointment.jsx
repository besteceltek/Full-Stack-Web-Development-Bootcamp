function Appointment() {
  return (
    <div className="appoinment">
        <h3>Make An Appoinment</h3>
        <input type="text" name="name" id="name" placeholder="Your Name" />
        <input type="email" name="email" id="email" placeholder="Your Email" />
        <textarea name="message" id="message" placeholder="Your Message"></textarea>
    </div>
  )
}

export default Appointment