// Call the dataTables jQuery plugin
$(document).ready(function () {});

// Function for sending all the data manually to the table in 'users.html'.
async function startSession() {
  let rdata = {};
  rdata.email = document.getElementById('InputEmail').value;
  rdata.password = document.getElementById('InputPassword').value;

  const request = await fetch("http://localhost:8080/login", {
    method: "POST",
    headers: {
      "Accept": "application/json",
      "Content-Type": "application/json"
    },
    body: JSON.stringify(rdata),
    // Takes the response and converts it to a JSON String.
  });
  const res = await request.text();
  
  if (res == "Login failed! Try again..." || res == "") {
    alert("Login failed! Try again.");
  } else {
    localStorage.setItem("email",rdata.email);
    localStorage.token = res;
    if(!isTokenExpired(localStorage.token)){
      window.location.href = "users.html";
    }
  }
}
