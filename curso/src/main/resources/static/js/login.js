// Call the dataTables jQuery plugin
$(document).ready(function () {});

// Function for sending all the data manually to the table in 'users.html'.
async function startSession() {
    let rdata = {};
    rdata.Email = document.getElementById('InputEmail').value
    rdata.Password = document.getElementById('InputPassword').value
    
    const request = await fetch('/user', {
        method: 'POST',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        },
        body: JSON.stringify(rdata)
        // Takes the response and converts it to a JSON String.
    });
  const res = await request.text();
  if (res=='OK') {
    window.location.href = 'users.html';
  } else {
    alert('Incorrect login data! Try again.')
  }
}