document.addEventListener("DOMContentLoaded", () => {
    const buttons = document.querySelectorAll(".btn");
    const keyToSoundMap = {};
    
    buttons.forEach(button => {
        const key = button.querySelector("span.button-text").innerText;
        const soundFile = soundFileUrl(key);
        keyToSoundMap[key] = button;

        // Add click event listener to each button
        button.addEventListener("click", () => {
          playSound(soundFile);
          button.classList.add("active");
          setTimeout(() => button.classList.remove("active"), 200); // Remove 'active' class after 200ms
        });
    });

    document.addEventListener("keydown", (event) => {
        const key = event.key.toUpperCase();
        if (keyToSoundMap[key]) {
            const button = keyToSoundMap[key];
            const soundFile = soundFileUrl(key);
            playSound(soundFile);
            button.classList.add("active");
            setTimeout(() => button.classList.remove("active"), 200); // Remove 'active' class after 200ms
        }
      });

    function soundFileUrl(key) {
        let audioUrl;
        switch (key) {
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
        return audioUrl;
    }

    function playSound(soundFile) {
        const audio = new Audio(`${soundFile}`);
        audio.play();
    }
})
