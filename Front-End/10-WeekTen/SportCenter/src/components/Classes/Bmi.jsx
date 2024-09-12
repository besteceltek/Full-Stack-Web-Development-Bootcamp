import bmiImage from "../../assets/bmi-index.jpg"

function Bmi() {
    const calculateBmi = () => {
        let height = parseFloat(document.getElementById('height').value);
        let weight = parseFloat(document.getElementById('weight').value);
        
        if (height > 0 && weight > 0) {
            let bmi = weight / ((height / 100) ** 2);
            positionTriangle(bmi);
        } else {
            alert("Please enter a valid value.");
        }
    }
    
    function positionTriangle(bmi) {
        let bmiTriangle = document.getElementById('bmi-triangle');
        
        if (bmi < 18.5) {
            bmiTriangle.style.left = '26.5%'; // Position for underweight
        } else if (bmi >= 18.5 && bmi < 25) {
            bmiTriangle.style.left = '38%'; // Position for normal weight
        } else if (bmi >= 25 && bmi < 30) {
            bmiTriangle.style.left = '50%'; // Position for overweight
        } else if (bmi >= 30 && bmi < 35) {
            bmiTriangle.style.left = '61.5%'; // Position for obese
        } else {
            bmiTriangle.style.left = '73%'; // Position for extremely obese
        }
    
        bmiTriangle.style.display = 'block';
    }

  return (
    <div className="bmi">
        <div className="calculator">
            <h2>BMI Calculator</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptates labore excepturi dolore modi saepe neque non vel, nostrum fugit praesentium.</p>
            <p>Laborum quas dolorum nihil quod maiores, autem eveniet rerum necessitatibus? Sit soluta officiis veniam! Ut dolores eos iusto eligendi exercitationem.</p>
            <div className="bmi-input">
                <input type="number" name="height" id="height" placeholder="Your Height" />
                <label htmlFor="height">cm</label>
                <input type="number" name="weight" id="weight" placeholder="Your Weight" />
                <label htmlFor="weight">kg</label>
                <button className="calculate" onClick={calculateBmi}>Calculate</button>
            </div>
        </div>
        <div className="bmi-chart-section">
            <h3>Your BMI</h3>
            <img src={bmiImage} alt="" className="bmi-chart" />
            <div id="bmi-triangle" className="bmi-triangle"></div>
        </div>
    </div>
  )
}

export default Bmi