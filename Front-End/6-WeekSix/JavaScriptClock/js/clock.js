function submitName() {
    var name = document.getElementById("nameInput").value;
    document.getElementById("myName").innerText = name;
    $('#nameModal').modal('hide'); // Use jQuery to hide the modal
  }

  // Show the modal when the page loads
  window.onload = function() {
    $('#nameModal').modal('show');
    showTime();
    setInterval(showTime, 1000); // Update the clock every second
  }

  // Function to display the current time and day of the week
  function showTime() {
    var now = new Date();
    var hours = now.getHours();
    var minutes = now.getMinutes();
    var seconds = now.getSeconds();
    var day = now.getDay();

    // Format the time to always show two digits
    hours = hours < 10 ? '0' + hours : hours;
    minutes = minutes < 10 ? '0' + minutes : minutes;
    seconds = seconds < 10 ? '0' + seconds : seconds;

    // Get the name of the day
    var days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
    var dayName = days[day];
    
    // Display the time and day
    document.getElementById("myClock").innerText = `${hours}:${minutes}:${seconds} - ${dayName}`;
  }