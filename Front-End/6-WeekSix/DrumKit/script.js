// Function to handle button click and get the text inside the span
function handleButtonClick(event) {
    let button = event.target;
    let spanText = button.querySelector("span.button-text").innerText;
    let audioUrl;
    switch (spanText) {
        case "A":
            audioUrl = "assets/boom.wav";
            break;
        case "S":
            audioUrl = "assets/clap.wav";
            break;
        case "D":
            audioUrl = "assets/hihat.wav";
            break;
        case "F":
            audioUrl = "assets/kick.wav";
            break;
        case "G":
            audioUrl = "assets/openhat.wav";
            break;
        case "H":
            audioUrl = "assets/ride.wav";
            break;
        case "J":
            audioUrl = "assets/snare.wav";
            break;
        case "K":
            audioUrl = "assets/tink.wav";
            break;
        case "L":
            audioUrl = "assets/tom.wav";
            break;
        default:
            break;
    }
    console.log(audioUrl);
    var audio = new Audio(audioUrl);
    audio.play();
}